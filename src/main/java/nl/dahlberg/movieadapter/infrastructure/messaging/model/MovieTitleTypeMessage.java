package nl.dahlberg.movieadapter.infrastructure.messaging.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MovieTitleTypeMessage {
    MOVIE("movie"),
    SHORT("short"),
    TV_EPISODE("tvEpisode"),
    TV_MINI_SERIES("tvMiniSeries"),
    TV_MOVIE("tvMovie"),
    TV_SERIES("tvSeries"),
    TV_SHORT("tvShort"),
    TV_SPECIAL("tvSpecial"),
    VIDEO("video"),
    VIDEO_GAME("videoGame");

    @JsonValue
    private final String value;

    public static MovieTitleTypeMessage getByValue(final String value) {
        for (MovieTitleTypeMessage movieTitleTypeMessage : MovieTitleTypeMessage.values()) {
            if (movieTitleTypeMessage.value.equals(value)) {
                return movieTitleTypeMessage;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}