package nl.dahlberg.movieadapter.domain.repository;

import nl.dahlberg.movieadapter.domain.model.MovieTitle;

public interface MovieTitleRepositoryCustom {
    void saveAllBatched(Iterable<MovieTitle> movieTitles);
}
