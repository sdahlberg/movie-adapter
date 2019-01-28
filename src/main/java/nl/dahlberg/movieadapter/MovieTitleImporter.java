package nl.dahlberg.movieadapter;

import nl.dahlberg.movieadapter.domain.model.MovieTitle;
import nl.dahlberg.movieadapter.domain.service.MovieTitleService;
import nl.dahlberg.movieadapter.infrastructure.importer.importer.CsvFileImporter;
import nl.dahlberg.movieadapter.infrastructure.messaging.publisher.MovieTitlePublisher;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

@lombok.AllArgsConstructor
@Component
public class MovieTitleImporter {
    private final MovieTitleService movieTitleService;
    private final CsvFileImporter csvFileImporter;
    private final MovieTitlePublisher movieTitlePublisher;

    public void importMovieTitles(final InputStream inputStream) throws IOException {
        final Stream<MovieTitle> movieTitleStream = csvFileImporter.importCsvStream(inputStream);
        movieTitleService.addMovieTitles(movieTitleStream);
    }

    public void importTest() throws IOException {
        final long start = System.currentTimeMillis();
        final ClassPathResource resource = new ClassPathResource("imports/test.tsv");
        final Stream<MovieTitle> movieTitleStream = csvFileImporter.importCsvStream(resource.getInputStream());
        movieTitleService.addMovieTitles(movieTitleStream);
        System.out.println("Import finished in " + (System.currentTimeMillis() - start) + "ms.");
    }

    @EventListener
    public void handleNewMovieTitle(final MovieTitle movieTitle) {
        movieTitlePublisher.sendMovieTitle(movieTitle);
    }
}
