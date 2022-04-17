package com.lamia.stadiumservice.repository;

import com.lamia.stadiumservice.model.Stadium;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StadiumRepository extends PagingAndSortingRepository<Stadium, UUID> {
}
