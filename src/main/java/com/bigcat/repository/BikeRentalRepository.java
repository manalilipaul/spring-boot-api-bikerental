package com.bigcat.repository;

import com.bigcat.entity.BikeRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRentalRepository extends JpaRepository<BikeRent, Long> {
    List<BikeRent> findBycustomername(String customername);
}