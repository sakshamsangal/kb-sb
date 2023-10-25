package com.app.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {

    /**
     * This method helps customize the Jackson Object mapper.
     *
     * @return Instance of {@link ObjectMapper}.
     */
    @Bean
    public ObjectMapper objectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        mapper.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);

        final JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        javaTimeModule.addSerializer(OffsetDateTime.class, new LocalDateTimeSerializer());
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        javaTimeModule.addDeserializer(OffsetDateTime.class, new LocalDateTimeDeserializer());

        mapper.registerModules(javaTimeModule);

        return mapper;
    }

    /**
     * The Local Date Serializer.
     */
    public static class LocalDateSerializer extends JsonSerializer<LocalDate> {
        @Override
        public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }

    /**
     * The Local Date Deserializer.
     */
    public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
            return LocalDate.parse(p.getValueAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }

    /**
     * The Local Date Serializer.
     */
    public static class LocalDateTimeSerializer extends JsonSerializer<OffsetDateTime> {
        @Override
        public void serialize(final OffsetDateTime value, final JsonGenerator gen, final SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        }
    }

    /**
     * The Local Date Deserializer.
     */
    public static class LocalDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {
        @Override
        public OffsetDateTime deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
            return OffsetDateTime.parse(p.getValueAsString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }
    }
}
