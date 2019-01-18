package nl.dahlberg.movieadapter.infrastructure.importer.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class BooleanConverter extends StdConverter<String, Boolean> {

    @Override
    public Boolean convert(final String value) {
        if ("0".equals(value)) {
            return false;
        } else if ("1".equals(value)) {
            return true;
        }
        return null;
    }
}
