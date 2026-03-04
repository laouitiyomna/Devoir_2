package com.yomna.evenements;

import com.yomna.evenements.entities.Evenement;
import com.yomna.evenements.entities.Genre;
import com.yomna.evenements.repos.EvenementRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EvenementApplicationTests {

    @Autowired
    private EvenementRepository evenementRepository;

    // Objectif 3
    @Test
    public void testFindByNomEvenement() {
        List<Evenement> evs = evenementRepository.findByNomEvenement("Concert Jazz");
        for (Evenement e : evs) {
            System.out.println(e);
        }
    }

    @Test
    public void testFindByNomEvenementContains() {
        List<Evenement> evs = evenementRepository.findByNomEvenementContains("C");
        for (Evenement e : evs) {
            System.out.println(e);
        }
    }

    // Objectif 4
    @Test
    public void testFindByNomLieu() {
        List<Evenement> evs = evenementRepository.findByNomLieu("Conférence IA", "Tunis");
        for (Evenement e : evs) {
            System.out.println(e);
        }
    }

    // Objectif 5
    @Test
    public void testFindByGenre() {
        Genre g = new Genre();
        g.setIdGenre(1L);
        List<Evenement> evs = evenementRepository.findByGenre(g);
        for (Evenement e : evs) {
            System.out.println(e);
        }
    }

    // Objectif 6
    @Test
    public void testFindByGenreIdGenre() {
        List<Evenement> evs = evenementRepository.findByGenreIdGenre(1L);
        for (Evenement e : evs) {
            System.out.println(e);
        }
    }

    // Objectif 7
    @Test
    public void testFindByOrderByNomEvenementAsc() {
        List<Evenement> evs = evenementRepository.findByOrderByNomEvenementAsc();
        for (Evenement e : evs) {
            System.out.println(e);
        }
    }

    @Test
    public void testTrierEvenementsNomLieu() {
        List<Evenement> evs = evenementRepository.trierEvenementsNomLieu();
        for (Evenement e : evs) {
            System.out.println(e);
        }
    }
}