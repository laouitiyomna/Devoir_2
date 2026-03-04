package com.yomna.evenements.repos;

import com.yomna.evenements.entities.Evenement;
import com.yomna.evenements.entities.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    // Objectif 3 — attribut non clé
    List<Evenement> findByNomEvenement(String nom);
    List<Evenement> findByNomEvenementContains(String nom);
    Page<Evenement> findByNomEvenementContains(String nom, Pageable pageable);

    // Objectif 4 — @Query JPQL avec critères multiples
    @Query("select e from Evenement e where e.nomEvenement like %:nom and e.lieu = :lieu")
    List<Evenement> findByNomLieu(@Param("nom") String nom, @Param("lieu") String lieu);

    // Objectif 5 — @Query en passant une entité en paramètre
    @Query("select e from Evenement e where e.genre = ?1")
    List<Evenement> findByGenre(Genre genre);

    // Objectif 6 — interroger selon l'id du genre
    List<Evenement> findByGenreIdGenre(Long id);

    // Objectif 7 — trier par nom
    List<Evenement> findByOrderByNomEvenementAsc();

    // Objectif 7 — trier par nom et lieu
    @Query("select e from Evenement e order by e.nomEvenement ASC, e.lieu DESC")
    List<Evenement> trierEvenementsNomLieu();
}