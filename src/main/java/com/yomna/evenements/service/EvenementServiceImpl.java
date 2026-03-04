package com.yomna.evenements.service;

import com.yomna.evenements.entities.Evenement;
import com.yomna.evenements.entities.Genre;
import com.yomna.evenements.repos.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementServiceImpl implements EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Override
    public Evenement saveEvenement(Evenement ev) {
        return evenementRepository.save(ev);
    }

    @Override
    public Evenement updateEvenement(Evenement ev) {
        return evenementRepository.save(ev);
    }

    @Override
    public void deleteEvenement(Evenement ev) {
        evenementRepository.delete(ev);
    }

    @Override
    public void deleteEvenementById(Long id) {
        evenementRepository.deleteById(id);
    }

    @Override
    public Evenement getEvenement(Long id) {
        return evenementRepository.findById(id).get();
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Page<Evenement> getAllEvenementsParPage(int page, int size) {
        return evenementRepository.findAll(PageRequest.of(page, size));
    }

    // Objectif 8
    @Override
    public List<Evenement> findByNomEvenement(String nom) {
        return evenementRepository.findByNomEvenement(nom);
    }

    @Override
    public List<Evenement> findByNomEvenementContains(String nom) {
        return evenementRepository.findByNomEvenementContains(nom);
    }

    @Override
    public List<Evenement> findByNomLieu(String nom, String lieu) {
        return evenementRepository.findByNomLieu(nom, lieu);
    }

    @Override
    public List<Evenement> findByGenre(Genre genre) {
        return evenementRepository.findByGenre(genre);
    }

    @Override
    public List<Evenement> findByGenreIdGenre(Long id) {
        return evenementRepository.findByGenreIdGenre(id);
    }

    @Override
    public List<Evenement> findByOrderByNomEvenementAsc() {
        return evenementRepository.findByOrderByNomEvenementAsc();
    }

    @Override
    public List<Evenement> trierEvenementsNomLieu() {
        return evenementRepository.trierEvenementsNomLieu();
    }

    @Override
    public Page<Evenement> chercherParNomPage(String kw, int page, int size) {
        return evenementRepository.findByNomEvenementContains(kw, PageRequest.of(page, size));
    }
}