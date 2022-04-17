package com.lamia.stadiumservice.model;

import com.lamia.stadiumservice.model.audit.DateAudit;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "facilities")
@Proxy(lazy = false)
public class Facility extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "facility_id", nullable = false)
    private Integer facilityId;

    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "is_active")
    private Boolean isActive;
}
