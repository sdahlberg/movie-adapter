package nl.dahlberg.movieadapter.interfaces.test.web;

import lombok.AllArgsConstructor;
import nl.dahlberg.movieadapter.MovieTitleProcessor;
import nl.dahlberg.movieadapter.domain.repository.MovieTitleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/movie-adapter")
public class TestController {
    private final MovieTitleProcessor movieTitleProcessor;
    private final MovieTitleRepository movieTitleRepository;

    @GetMapping("import-csv")
    public void doImport() {
        movieTitleProcessor.fillDatabase();
    }

    @GetMapping("clear-database")
    public void clear() {
        movieTitleRepository.deleteAll();
    }
}
