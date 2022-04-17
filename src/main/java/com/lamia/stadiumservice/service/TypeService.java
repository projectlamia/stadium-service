package com.lamia.stadiumservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lamia.stadiumservice.model.Type;
import com.lamia.stadiumservice.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService {

    private final Logger log = LoggerFactory.getLogger(TypeService.class);
    private final TypeRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public TypeService(TypeRepository repository) {
        this.repository = repository;
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public Type getByIdAndStatus(Integer id) throws JsonProcessingException {
        log.info("Entering method getByIdAndStatus on class " + TypeService.class.getName() + " at " + System.currentTimeMillis());
        Optional<Type> dataType = repository.findByTypeIdAndIsActive(id, true);
        Type type = new Type();

        dataType.ifPresentOrElse(data -> {
            type.setTypeId(data.getTypeId());
            type.setTypeName(data.getTypeName());
            type.setTypeCategory(data.getTypeCategory());
        }, () -> {});

        log.info("Leaving method getByIdAndStatus on class " + TypeService.class.getName() + " at " + System.currentTimeMillis());
        log.info(mapper.writeValueAsString(type));
        return type;
    }
}
