package nl.dahlberg.movieadapter.infrastructure.repository;

import nl.dahlberg.movieadapter.domain.model.MovieTitle;
import nl.dahlberg.movieadapter.domain.repository.MovieTitleRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class MovieTitleRepositoryImpl implements MovieTitleRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Transactional
    @Override
    public Iterable<MovieTitle> saveAllBatched(final Iterable<MovieTitle> movieTitles) {
        int i = 0;
        for (final MovieTitle movieTitle : movieTitles) {
            entityManager.persist(movieTitle);
            i++;

            if (i % 500 == 0) {
                entityManager.flush();
                entityManager.clear();
            }

            publisher.publishEvent(movieTitle);
        }
        return movieTitles;
    }
}
