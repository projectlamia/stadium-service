package com.lamia.stadiumservice.repository;

import com.lamia.stadiumservice.model.Court;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourtRepository extends PagingAndSortingRepository<Court, UUID> {
}
