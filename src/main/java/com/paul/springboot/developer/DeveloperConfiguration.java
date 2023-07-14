package com.paul.springboot.developer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DeveloperConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(DeveloperRepository developerRepository) {
        return args -> {
            /*Developer developer1 = new Developer(
                    "Ankush",
                    "ankush@gmail.com",
                    21,
                    "Java"
            );
            Developer developer2 = new Developer(
                    "Soumik",
                    "soumik@gmail.com", 21,
                    "MERN"
            );

            developerRepository.saveAll(List.of(developer1, developer2));*/
        };
    }
}
