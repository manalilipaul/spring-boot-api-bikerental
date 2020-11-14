package com.bigcat.controller;

import com.bigcat.entity.BikeStaff;
import com.bigcat.repository.BikeStaffRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class BikeStaffController {
    private final BikeStaffRepository bikeStaffRepository;

    public BikeStaffController(BikeStaffRepository bikeStaffRepository) {
        this.bikeStaffRepository = bikeStaffRepository;
    }

    @GetMapping(value = "/staff", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BikeStaff> getStaff() {
        return bikeStaffRepository.findAll();
    }

    @GetMapping(value = "/staff/{staffid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeStaff getStaff(@PathVariable long staffid){
        return bikeStaffRepository.findById(staffid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid staff id %s", staffid)));
    }

    @PostMapping(value = "/staff", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeStaff createStaff(@Valid @RequestBody BikeStaff bikeStaff) {
        return bikeStaffRepository.save(bikeStaff);
    }

    @PutMapping(value = "/staff/{staffid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeStaff updateStaff(@RequestBody BikeStaff bikeStaffPut) {
        BikeStaff bikeStaff = bikeStaffRepository.findById(bikeStaffPut.getStaffid()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid staff id %s", bikeStaffPut.getStaffid())));
        bikeStaff.setStaffname(bikeStaffPut.getStaffname());
        bikeStaff.setStaffrole(bikeStaffPut.getStaffrole());
        bikeStaffRepository.save(bikeStaff);
        return bikeStaff;
    }

    @DeleteMapping(value = "/staff/{staffid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeStaff deleteRent(@PathVariable long staffid) {
        BikeStaff bikeStaff = bikeStaffRepository.findById(staffid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid staff id %s", staffid)));
        bikeStaffRepository.delete(bikeStaff);
        return bikeStaff;
    }
}