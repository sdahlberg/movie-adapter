package nl.dahlberg.movieadapter.domain.repository;

import nl.dahlberg.movieadapter.domain.model.MovieTitle;

public interface MovieTitleRepositoryCustom {
    Iterable<MovieTitle>  saveAllBatched(Iterable<MovieTitle> movieTitles);
}
