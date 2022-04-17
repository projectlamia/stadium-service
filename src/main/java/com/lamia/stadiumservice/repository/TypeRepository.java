package com.lamia.stadiumservice.repository;

import com.lamia.stadiumservice.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {
    Optional<Type> findByTypeIdAndIsActive(Integer typeId, Boolean isActive);
}
