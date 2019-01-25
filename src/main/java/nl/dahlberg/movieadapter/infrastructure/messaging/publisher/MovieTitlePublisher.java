package nl.dahlberg.movieadapter.infrastructure.messaging.publisher;

import nl.dahlberg.movieadapter.conversion.DomainConversionService;
import nl.dahlberg.movieadapter.domain.model.MovieTitle;
import nl.dahlberg.movieadapter.infrastructure.messaging.model.MovieTitleMessage;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@lombok.AllArgsConstructor
@Component
public class MovieTitlePublisher {
    private final Source source;
    private final DomainConversionService domainConversionService;

    public void sendMovieTitle(final MovieTitle movieTitle) {
        final MovieTitleMessage movieTitleMessage = domainConversionService.convert(movieTitle, MovieTitleMessage.class);
        System.out.println("Send: " + movieTitleMessage);
        source.output().send(MessageBuilder.withPayload(movieTitleMessage).build());
    }
}
