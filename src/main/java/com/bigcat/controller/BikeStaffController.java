package com.bigcat.controller;

import com.bigcat.entity.BikeStaff;
import com.bigcat.repository.BikeStaffRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/staff")
public class BikeStaffController {
    private BikeStaffRepository bikeStaffRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public BikeStaffController(BikeStaffRepository bikeStaffRepository,  BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bikeStaffRepository = bikeStaffRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    @PostMapping(value ="/sign-up", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeStaff signUp(@RequestBody BikeStaff bikeStaff) {
        bikeStaff.setPassword(bCryptPasswordEncoder.encode(bikeStaff.getPassword()));
        return bikeStaffRepository.save(bikeStaff);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BikeStaff> getStaff() {
        return bikeStaffRepository.findAll();
    }

    @GetMapping(value = "/{staffid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeStaff getStaff(@PathVariable long staffid){
        return bikeStaffRepository.findById(staffid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid staff id %s", staffid)));
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeStaff createStaff(@Valid @RequestBody BikeStaff bikeStaff) {
        return bikeStaffRepository.save(bikeStaff);
    }

    @PutMapping(value = "/{staffid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeStaff updateStaff(@RequestBody BikeStaff bikeStaffPut) {
        BikeStaff bikeStaff = bikeStaffRepository.findById(bikeStaffPut.getStaffid()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid staff id %s", bikeStaffPut.getStaffid())));
        bikeStaff.setStaffname(bikeStaffPut.getStaffname());
        bikeStaff.setStaffrole(bikeStaffPut.getStaffrole());
        bikeStaffRepository.save(bikeStaff);
        return bikeStaff;
    }

    @DeleteMapping(value = "/{staffid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeStaff deleteRent(@PathVariable long staffid) {
        BikeStaff bikeStaff = bikeStaffRepository.findById(staffid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid staff id %s", staffid)));
        bikeStaffRepository.delete(bikeStaff);
        return bikeStaff;
    }
}