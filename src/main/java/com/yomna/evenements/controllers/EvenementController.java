package com.yomna.evenements.controllers;

import com.yomna.evenements.entities.Evenement;
import com.yomna.evenements.entities.Genre;
import com.yomna.evenements.service.EvenementService;
import com.yomna.evenements.service.GenreService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class EvenementController {

    private final EvenementService evenementService;
    private final GenreService genreService;

    public EvenementController(EvenementService evenementService, GenreService genreService) {
        this.evenementService = evenementService;
        this.genreService = genreService;
    }

    private String chargerListe(ModelMap modelMap, int page, int size, String kw) {
        Page<Evenement> evts;
        if (kw == null || kw.isEmpty()) {
            evts = evenementService.getAllEvenementsParPage(page, size);
        } else {
            evts = evenementService.chercherParNomPage(kw, page, size);
        }
        modelMap.addAttribute("evenements", evts);
        modelMap.addAttribute("pages", new int[evts.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        modelMap.addAttribute("kw", kw);
        return "ListeEvenements"; // ← corrigé avec L majuscule
    }

    @RequestMapping("/ListeEvenements")
    public String listeEvenements(ModelMap modelMap,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "3") int size,
                                  @RequestParam(name = "kw", defaultValue = "") String kw) {
        return chargerListe(modelMap, page, size, kw);
    }

    @RequestMapping("/supprimerEvenement")
    public String supprimerEvenement(@RequestParam("id") Long id,
                                     ModelMap modelMap,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "3") int size) {
        evenementService.deleteEvenementById(id);
        return chargerListe(modelMap, page, size, "");
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("genres", genreService.getAllGenres());
        return "createEvenement";
    }

    @RequestMapping("/saveEvenement")
    public String saveEvenement(@ModelAttribute("evenement") Evenement evenement,
                                @RequestParam("date") String date,
                                @RequestParam(name = "idGenre", required = false) Long idGenre,
                                ModelMap modelMap) throws ParseException {
        evenement.setDateEvenement(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        if (idGenre != null) {
            evenement.setGenre(genreService.getGenre(idGenre));
        }
        Evenement saved = evenementService.saveEvenement(evenement);
        modelMap.addAttribute("msg", "Événement enregistré avec Id " + saved.getIdEvenement());
        modelMap.addAttribute("genres", genreService.getAllGenres());
        return "createEvenement";
    }

    @RequestMapping("/modifierEvenement")
    public String modifierEvenement(@RequestParam("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("evenement", evenementService.getEvenement(id));
        modelMap.addAttribute("genres", genreService.getAllGenres());
        return "editerEvenement";
    }

    @RequestMapping("/updateEvenement")
    public String updateEvenement(@ModelAttribute("evenement") Evenement evenement,
                                  @RequestParam("date") String date,
                                  @RequestParam(name = "idGenre", required = false) Long idGenre,
                                  ModelMap modelMap,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "3") int size) throws ParseException {
        evenement.setDateEvenement(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        if (idGenre != null) {
            evenement.setGenre(genreService.getGenre(idGenre));
        }
        evenementService.updateEvenement(evenement);
        return chargerListe(modelMap, page, size, "");
    }
}
