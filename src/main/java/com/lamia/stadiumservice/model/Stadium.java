package com.lamia.stadiumservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lamia.stadiumservice.model.audit.UserDateAudit;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "stadiums")
@Proxy(lazy = false)
public class Stadium extends UserDateAudit {

    @Id
    @Column(name = "stadium_id", nullable = false)
    private UUID stadiumId;

    @Column(name = "stadium_name", nullable = false)
    private String stadiumName;

    @Column(name = "stadium_description")
    private String stadiumDescription;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    @JsonIgnore
    private Type type;
}
