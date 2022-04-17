package com.lamia.stadiumservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lamia.stadiumservice.model.audit.UserDateAudit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "courts")
public class Court extends UserDateAudit {
    @Id
    @Column(name = "court_id", nullable = false, length = 32)
    private String courtId;

    @Column(name = "court_number", nullable = false, length = 21)
    private String courtNumber;

    @Column(name = "court_price", nullable = false)
    private Long courtPrice;

    @Column(name = "is_booked", nullable = false)
    private Boolean isBooked;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    @JsonIgnore
    private Type type;

}
