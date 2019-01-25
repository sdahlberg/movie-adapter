package nl.dahlberg.movieadapter.infrastructure.messaging.converter;

import lombok.AllArgsConstructor;
import nl.dahlberg.movieadapter.domain.model.MovieTitle;
import nl.dahlberg.movieadapter.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.movieadapter.infrastructure.messaging.model.MovieTitleMessage;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Component
public class MovieTitleToMovieTitleMessageConverter extends ConversionServiceAwareConverter<MovieTitle, MovieTitleMessage> {
    private final StringToMovieTitleTypeMessageConverter typeConverter;
    private final StringToMovieTitleGenreMessageConverter genreConverter;

    @Override
    public MovieTitleMessage convert(final MovieTitle movieTitle) {
        return MovieTitleMessage.builder()
                .uuid(movieTitle.getUuid())
                .tconst(movieTitle.getTconst())
                .movieTitleType(typeConverter.convert(movieTitle.getMovieTitleType()))
                .primaryTitle(movieTitle.getPrimaryTitle())
                .originalTitle(movieTitle.getOriginalTitle())
                .isAdult(movieTitle.isAdult())
                .startYear(movieTitle.getStartYear())
                .endYear(movieTitle.getEndYear())
                .runtimeMinutes(movieTitle.getRuntimeMinutes())
                .genres(movieTitle.getGenres().stream().map(genreConverter::convert).collect(toList()))
                .build();
    }
}
