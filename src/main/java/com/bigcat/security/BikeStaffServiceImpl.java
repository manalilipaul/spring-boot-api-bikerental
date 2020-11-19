package com.bigcat.security;


import com.bigcat.entity.BikeStaff;
import com.bigcat.repository.BikeStaffRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class BikeStaffServiceImpl implements UserDetailsService {
    private BikeStaffRepository bikeStaffRepository;

    public BikeStaffServiceImpl(BikeStaffRepository bikeStaffRepository) {
        this.bikeStaffRepository = bikeStaffRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BikeStaff bikeStaff = bikeStaffRepository.findByUsername(username);
        if (bikeStaff == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(bikeStaff.getUsername(), bikeStaff.getPassword(), emptyList());
    }
}