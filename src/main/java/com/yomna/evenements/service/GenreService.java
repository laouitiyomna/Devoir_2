package com.yomna.evenements.service;

import com.yomna.evenements.entities.Genre;

import java.util.List;

public interface GenreService {

    Genre saveGenre(Genre g);
    Genre updateGenre(Genre g);
    void deleteGenre(Genre g);
    void deleteGenreById(Long id);
    Genre getGenre(Long id);
    List<Genre> getAllGenres();
    List<Genre> findByNomGenre(String nomGenre);
    List<Genre> findByNomGenreContains(String kw);
}