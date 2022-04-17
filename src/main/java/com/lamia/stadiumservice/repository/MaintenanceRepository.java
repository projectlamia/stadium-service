package com.lamia.stadiumservice.repository;

import com.lamia.stadiumservice.model.Maintenance;
import com.lamia.stadiumservice.model.MenuMaster;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MaintenanceRepository extends PagingAndSortingRepository<Maintenance, UUID> {
    long countByMenuMaster(MenuMaster menu);
}
