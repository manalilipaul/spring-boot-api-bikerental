package com.bigcat.repository;

import com.bigcat.entity.BikeStaff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeStaffRepository extends CrudRepository<BikeStaff, Long> {
    List<BikeStaff> findBystaffname(String staffname);
}
