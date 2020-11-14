package com.bigcat;


import com.bigcat.entity.BikeRent;
import com.bigcat.repository.BikeRentalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BikeRentalApp  {
    public static void main(String[] args) {
        SpringApplication.run(BikeRentalApp.class);
    }

    @Bean
    public CommandLineRunner sampleData(BikeRentalRepository repository) {
        return (args) -> {
            repository.save(new BikeRent("Paul", "10/10/2020", "11/10/2020"));
            repository.save(new BikeRent("Abby", "10/10/2020", "11/10/2020"));
            repository.save(new BikeRent("Poko", "10/10/2020", "11/10/2020"));
        };
    }
}
