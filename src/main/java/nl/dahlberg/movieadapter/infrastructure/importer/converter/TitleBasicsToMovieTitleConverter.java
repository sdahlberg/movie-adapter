package nl.dahlberg.movieadapter.infrastructure.importer.converter;

import nl.dahlberg.movieadapter.domain.model.MovieTitle;
import nl.dahlberg.movieadapter.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.movieadapter.infrastructure.importer.model.TitleBasics;
import org.springframework.stereotype.Component;

@Component
public class TitleBasicsToMovieTitleConverter extends ConversionServiceAwareConverter<TitleBasics, MovieTitle> {

    @Override
    public MovieTitle convert(final TitleBasics titleBasics) {
        return MovieTitle.create()
                .tconst(titleBasics.getTconst())
                .movieTitleType(titleBasics.getTitleType())
                .primaryTitle(titleBasics.getPrimaryTitle())
                .originalTitle(titleBasics.getOriginalTitle())
                .startYear(titleBasics.getStartYear())
                .endYear(titleBasics.getEndYear())
                .isAdult(titleBasics.getIsAdult())
                .runtimeMinutes(titleBasics.getRuntimeMinutes())
                .genres(titleBasics.getGenres())
                .build();
    }
}
