package nl.dahlberg.movieadapter.domain.repository;

import nl.dahlberg.movieadapter.domain.model.MovieTitle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieTitleRepository extends PagingAndSortingRepository<MovieTitle, Long>, MovieTitleRepositoryCustom,
        JpaSpecificationExecutor<MovieTitle> {

}
