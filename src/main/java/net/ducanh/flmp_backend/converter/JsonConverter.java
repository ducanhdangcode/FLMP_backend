package net.ducanh.flmp_backend.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.ducanh.flmp_backend.entity.CustomEntity.PlayerFormation;

import java.io.IOException;
import java.util.List;

@Converter
public class JsonConverter implements AttributeConverter<List<PlayerFormation>, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<PlayerFormation> playerFormations) {
        try {
            return objectMapper.writeValueAsString(playerFormations);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting list to JSON", e);
        }
    }

    @Override
    public List<PlayerFormation> convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, PlayerFormation.class));
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to list", e);
        }
    }
}
