package vn.edu.iuh.fit.backend.configs.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;

public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
    final ObjectMapper mapper = new ObjectMapper();
    public ObjectMapperContextResolver() {
        mapper.registerModule(new JavaTimeModule());
    }
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
