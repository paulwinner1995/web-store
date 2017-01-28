package ua.ppadalka.webstore.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        Optional<LocalDateTime> timeOptional = Optional.ofNullable(localDateTime);

        if (!timeOptional.isPresent()) return null;

        Instant instant = timeOptional.get().toInstant(ZoneOffset.UTC);

        return Timestamp.from(instant);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        Optional<Timestamp> timestampOptional = Optional.ofNullable(timestamp);

        if (!timestampOptional.isPresent()) return null;

        return timestampOptional.get().toLocalDateTime();
    }
}
