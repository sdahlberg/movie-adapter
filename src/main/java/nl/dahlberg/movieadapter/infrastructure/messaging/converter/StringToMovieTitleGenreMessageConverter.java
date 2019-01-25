package nl.dahlberg.movieadapter.infrastructure.messaging.converter;

import nl.dahlberg.movieadapter.infrastructure.messaging.model.MovieTitleGenreMessage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToMovieTitleGenreMessageConverter implements Converter<String, MovieTitleGenreMessage> {
    @Override
    public MovieTitleGenreMessage convert(String movieTitleGenre) {
        return MovieTitleGenreMessage.getByValue(movieTitleGenre);
    }
}
