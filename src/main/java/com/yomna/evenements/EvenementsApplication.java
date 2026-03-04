package com.yomna.evenements;

import com.yomna.evenements.entities.Evenement;
import com.yomna.evenements.entities.Genre;
import com.yomna.evenements.service.EvenementService;
import com.yomna.evenements.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class EvenementsApplication implements CommandLineRunner {

    @Autowired
    EvenementService evenementService;

    @Autowired
    GenreService genreService;

    public static void main(String[] args) {
        SpringApplication.run(EvenementsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (genreService.getAllGenres().isEmpty()) {
            genreService.saveGenre(new Genre(null, "Musique", null));
            genreService.saveGenre(new Genre(null, "Culture", null));
            genreService.saveGenre(new Genre(null, "Sport", null));
            genreService.saveGenre(new Genre(null, "Cinéma", null));
        }

        if (evenementService.getAllEvenements().isEmpty()) {
            List<Genre> genres = genreService.getAllGenres();
            Genre musique = genres.get(0);
            Genre culture = genres.get(1);
            Genre cinema  = genres.get(3);

            evenementService.saveEvenement(new Evenement(null, "Concert Jazz", "Tunis", new Date(), "Yomna", musique));
            evenementService.saveEvenement(new Evenement(null, "Salon du Livre", "Sousse", new Date(), "Ahmed", culture));
            evenementService.saveEvenement(new Evenement(null, "Festival Cinema", "Carthage", new Date(), "Sara", cinema));
            evenementService.saveEvenement(new Evenement(null, "Rock Night", "Hammamet", new Date(), "Sami", musique));
            evenementService.saveEvenement(new Evenement(null, "Expo Photo", "Sfax", new Date(), "Leila", culture));
        }
    }
}
