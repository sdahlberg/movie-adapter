package nl.dahlberg.movieadapter.interfaces.test.web;

import lombok.AllArgsConstructor;
import nl.dahlberg.movieadapter.MovieTitleImporter;
import nl.dahlberg.movieadapter.domain.repository.MovieTitleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor
@RestController
@RequestMapping("/api/movie-adapter")
public class TestController {
    private final MovieTitleImporter movieTitleImporter;
    private final MovieTitleRepository movieTitleRepository;

    @GetMapping("import-csv")
    public void doImport() throws IOException {
        movieTitleImporter.importTest();
    }

    @GetMapping("clear-database")
    public void clear() {
        movieTitleRepository.deleteAll();
    }

    @PostMapping
    public void doImport(final InputStream inputStream) throws IOException {
        movieTitleImporter.importMovieTitles(inputStream);
    }
}
