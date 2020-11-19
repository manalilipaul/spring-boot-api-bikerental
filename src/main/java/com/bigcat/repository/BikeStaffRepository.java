package com.bigcat.repository;

import com.bigcat.entity.BikeStaff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeStaffRepository extends CrudRepository<BikeStaff, Long> {

    BikeStaff findByUsername(String username);
}
