package com.lamia.stadiumservice.model;

import com.lamia.stadiumservice.model.audit.DateAudit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "types")
public class Type extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id", nullable = false)
    private Integer typeId;

    @Column(name = "type_name", nullable = false, length = 50)
    private String typeName;

    @Column(name = "type_category", nullable = false, length = 50)
    private String typeCategory;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
