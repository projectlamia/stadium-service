package com.lamia.stadiumservice.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lamia.stadiumservice.model.Type;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StadiumRequest implements Serializable {
    private UUID stadiumId;
    private String stadiumName;
    private String stadiumDescription;
    private Boolean isActive;
    private TypeRequest stadiumType;
}
