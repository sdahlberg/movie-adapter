package nl.dahlberg.movieadapter;

import nl.dahlberg.movieadapter.domain.model.MovieTitle;
import nl.dahlberg.movieadapter.domain.service.MovieTitleService;
import nl.dahlberg.movieadapter.infrastructure.importer.importer.CsvFileImporter;
import nl.dahlberg.movieadapter.infrastructure.messaging.publisher.MovieTitlePublisher;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Stream;

@lombok.AllArgsConstructor
@Component
public class MovieTitleProcessor {
    private final MovieTitleService movieTitleService;
    private final CsvFileImporter csvFileImporter;
    private final MovieTitlePublisher movieTitlePublisher;

    public void fillDatabase() {
        //final ClassPathResource resource = new ClassPathResource("imports/title-basics.tsv");
        final ClassPathResource resource = new ClassPathResource("imports/test.tsv");

        final long start = System.currentTimeMillis();
        try {
            final Stream<MovieTitle> movieTitleStream = csvFileImporter.importCsvStream(resource.getInputStream());
            final Iterable<MovieTitle> movieTitles = movieTitleService.addMovieTitles(movieTitleStream);
        } catch (IOException e) {
            throw new IllegalStateException("Should be able to read title-basics.tsv", e);
        }

        System.out.println("Import finished in " + (System.currentTimeMillis() - start) + "ms.");
    }

    @EventListener
    public void handleNewMovieTitle(final MovieTitle movieTitle) {
        movieTitlePublisher.sendMovieTitle(movieTitle);
    }
}
