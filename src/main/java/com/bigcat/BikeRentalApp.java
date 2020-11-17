package com.bigcat;


import com.bigcat.entity.BikeRent;
import com.bigcat.repository.BikeRentalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.sql.Date;
import java.util.Calendar;

@SpringBootApplication
@EnableJpaAuditing
public class BikeRentalApp  {
    public static void main(String[] args) {
        SpringApplication.run(BikeRentalApp.class);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Bean
    public CommandLineRunner sampleData(BikeRentalRepository repository) {
        return (args) -> {
            long d = System.currentTimeMillis();
            Date date=new Date(d);


            repository.save(new BikeRent("Paul",  null));
            repository.save(new BikeRent("Abby",  addDays(date,1)));
            repository.save(new BikeRent("Poko",  addDays(date,2)));
        };
    }

    public static Date addDays(Date date, int days)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        Date dateAddDays=new Date(c.getTimeInMillis());
        return dateAddDays;
    }
}
