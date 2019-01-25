package nl.dahlberg.movieadapter.infrastructure.messaging.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MovieTitleGenreMessage {
    ACTION("Action"),
    ADULT("Adult"),
    ADVENTURE("Adventure"),
    ANIMATION("Animation"),
    BIOGRAPHY("Biography"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DOCUMENTARY("Documentary"),
    DRAMA("Drama"),
    FAMILY("Family"),
    FANTASY("Fantasy"),
    FILM_NOIR("Film-Noir"),
    GAME_SHOW("Game-Show"),
    HISTORY("History"),
    HORROR("Horror"),
    MUSIC("Music"),
    MUSICAL("Musical"),
    MYSTERY("Mystery"),
    NEWS("News"),
    REALITY_TV("Reality-TV"),
    ROMANCE("Romance"),
    SCI_FI("Sci-Fi"),
    SHORT("Short"),
    SPORT("Sport"),
    TALK_SHOW("Talk-Show"),
    THRILLER("Thriller"),
    WAR("War"),
    WESTERN("Western");

    @JsonValue
    private final String value;

    public static MovieTitleGenreMessage getByValue(final String value) {
        for (MovieTitleGenreMessage movieTitleGenreMessage : MovieTitleGenreMessage.values()) {
            if (movieTitleGenreMessage.value.equals(value)) {
                return movieTitleGenreMessage;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
