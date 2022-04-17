package com.lamia.stadiumservice.repository;

import com.lamia.stadiumservice.model.Facility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends CrudRepository<Facility, Integer> {
}
