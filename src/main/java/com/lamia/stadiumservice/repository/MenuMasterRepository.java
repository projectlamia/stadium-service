package com.lamia.stadiumservice.repository;

import com.lamia.stadiumservice.model.MenuMaster;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuMasterRepository extends PagingAndSortingRepository<MenuMaster, Integer> {
    Optional<MenuMaster> findByPath(String path);
}
