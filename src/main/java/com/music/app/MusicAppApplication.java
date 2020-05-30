package com.music.app;

import com.music.app.repository.ArtistsRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.music.app"})
@EnableJpaRepositories
public class MusicAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(ArtistsRepo artistsRepo) {
        return args -> {
			//artistsRepo.save(new Artists(null,"Adi","Spanish",null));


        };
    }

}
