package com.lamia.stadiumservice.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TypeRequest implements Serializable {
    @JsonProperty(value = "type_id")
    private Integer typeId;

    @JsonProperty(value = "type_name")
    private String typeName;
}
