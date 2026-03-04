package com.yomna.evenements.service;

import com.yomna.evenements.entities.Evenement;
import com.yomna.evenements.entities.Genre;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EvenementService {

    Evenement saveEvenement(Evenement ev);
    Evenement updateEvenement(Evenement ev);
    void deleteEvenement(Evenement ev);
    void deleteEvenementById(Long id);
    Evenement getEvenement(Long id);
    List<Evenement> getAllEvenements();
    Page<Evenement> getAllEvenementsParPage(int page, int size);

    // Objectif 8 — méthodes du repository ajoutées au service
    List<Evenement> findByNomEvenement(String nom);
    List<Evenement> findByNomEvenementContains(String nom);
    List<Evenement> findByNomLieu(String nom, String lieu);
    List<Evenement> findByGenre(Genre genre);
    List<Evenement> findByGenreIdGenre(Long id);
    List<Evenement> findByOrderByNomEvenementAsc();
    List<Evenement> trierEvenementsNomLieu();
    Page<Evenement> chercherParNomPage(String kw, int page, int size);
}