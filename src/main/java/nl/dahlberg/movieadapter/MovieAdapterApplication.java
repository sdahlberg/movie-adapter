package nl.dahlberg.movieadapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding(Source.class)
public class MovieAdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieAdapterApplication.class, args);
    }
}

