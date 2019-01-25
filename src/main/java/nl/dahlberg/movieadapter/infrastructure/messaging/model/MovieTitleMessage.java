package nl.dahlberg.movieadapter.infrastructure.messaging.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Year;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
@Builder
public class MovieTitleMessage {
    private UUID uuid;
    private String tconst;
    private MovieTitleTypeMessage movieTitleType;
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private Year startYear;
    private Year endYear;
    private int runtimeMinutes;
    private List<MovieTitleGenreMessage> genres;
}
