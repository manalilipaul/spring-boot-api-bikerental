package com.bigcat.controller;



import com.bigcat.entity.BikeRent;
import com.bigcat.repository.BikeRentalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class BikeRentalController {
    private final BikeRentalRepository bikeRentalRepository;

    public BikeRentalController(BikeRentalRepository bikeRentalRepository) {
        this.bikeRentalRepository = bikeRentalRepository;
    }

    @GetMapping(value = "/rent", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<BikeRent> getRent() {
        return bikeRentalRepository.findAll();
    }

    @GetMapping(value = "/rent/{bikeid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeRent getRent(@PathVariable long bikeid){
        return bikeRentalRepository.findById(bikeid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid bike id %s", bikeid)));
    }

    @PostMapping(value = "/rent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeRent createRent(@Valid @RequestBody BikeRent bikeRent) {
        return bikeRentalRepository.save(bikeRent);
    }

    @PutMapping(value = "/rent/{bikeid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeRent updateRent(@RequestBody BikeRent bikeRentPut) {
        BikeRent bikeRent = bikeRentalRepository.findById(bikeRentPut.getBikeid()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid bike id %s", bikeRentPut.getBikeid())));
        bikeRent.setCustomername(bikeRentPut.getCustomername());
        bikeRent.setCheckin(bikeRentPut.getCheckin());
        bikeRent.setCheckout(bikeRentPut.getCheckout());
        bikeRentalRepository.save(bikeRent);
        return bikeRent;
    }

    @DeleteMapping(value = "/rent/{bikeid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeRent deleteRent(@PathVariable long bikeid) {
        BikeRent bikeRent = bikeRentalRepository.findById(bikeid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid bike id %s", bikeid)));
        bikeRentalRepository.delete(bikeRent);
        return bikeRent;
    }
}
