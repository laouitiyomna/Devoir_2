package com.yomna.evenements.service;

import com.yomna.evenements.entities.Genre;
import com.yomna.evenements.repos.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre saveGenre(Genre g) {
        return genreRepository.save(g);
    }

    @Override
    public Genre updateGenre(Genre g) {
        return genreRepository.save(g);
    }

    @Override
    public void deleteGenre(Genre g) {
        genreRepository.delete(g);
    }

    @Override
    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Genre getGenre(Long id) {
        return genreRepository.findById(id).get();
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findByNomGenre(String nomGenre) {
        return genreRepository.findByNomGenre(nomGenre);
    }

    @Override
    public List<Genre> findByNomGenreContains(String kw) {
        return genreRepository.findByNomGenreContains(kw);
    }
}