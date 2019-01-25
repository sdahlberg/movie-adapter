package nl.dahlberg.movieadapter.infrastructure.messaging.converter;

import nl.dahlberg.movieadapter.infrastructure.messaging.model.MovieTitleTypeMessage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToMovieTitleTypeMessageConverter implements Converter<String, MovieTitleTypeMessage> {
    @Override
    public MovieTitleTypeMessage convert(String movieTitleType) {
        return MovieTitleTypeMessage.getByValue(movieTitleType);
    }
}
