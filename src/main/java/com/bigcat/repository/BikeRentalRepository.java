package com.bigcat.repository;

import com.bigcat.entity.BikeRent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRentalRepository extends CrudRepository<BikeRent, Long> {
    List<BikeRent> findBycustomername(String customername);
}
