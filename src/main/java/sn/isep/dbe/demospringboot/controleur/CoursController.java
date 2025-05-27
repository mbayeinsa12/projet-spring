package sn.isep.dbe.demospringboot.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.isep.dbe.demospringboot.models.Cours;
import sn.isep.dbe.demospringboot.models.Filiere;
import sn.isep.dbe.demospringboot.service.CoursService;
import sn.isep.dbe.demospringboot.service.FiliereService;

import java.util.List;

@Controller
@RequestMapping("/cours")
public class CoursController {

    private final CoursService coursService;
    private final FiliereService filiereService;

    public CoursController(CoursService coursService, FiliereService filiereService) {
        this.coursService = coursService;
        this.filiereService = filiereService;
    }

    @GetMapping
    public String listCours(Model model) {
        List<Cours> cours = coursService.getAllCours();
        model.addAttribute("cours", cours);
        return "cours/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        List<Filiere> filieres = filiereService.getFilieres();
        model.addAttribute("cours", new Cours());
        model.addAttribute("filieres", filieres);
        return "cours/add";
    }

    @PostMapping("/save")
    public String saveCours(@ModelAttribute Cours cours) {
        coursService.createCours(cours);
        return "redirect:/cours";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Cours cours = coursService.getCoursById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID cours invalide: " + id));
        List<Filiere> filieres = filiereService.getFilieres();

        model.addAttribute("cours", cours);
        model.addAttribute("filieres", filieres);
        return "cours/edit";
    }

    @PostMapping("/update/{id}")
    public String updateCours(@PathVariable Integer id, @ModelAttribute Cours cours) {
        coursService.updateCours(id, cours);
        return "redirect:/cours";
    }

    @GetMapping("/delete/{id}")
    public String deleteCours(@PathVariable Integer id) {
        coursService.deleteCours(id);
        return "redirect:/cours";
    }

    @GetMapping("/byFiliere/{filiereId}")
    public String getCoursByFiliere(@PathVariable Integer filiereId, Model model) {
        List<Cours> cours = coursService.getCoursByFiliere(filiereId);
        Filiere filiere = filiereService.getFiliereById(filiereId)
                .orElseThrow(() -> new IllegalArgumentException("ID filière invalide: " + filiereId));

        model.addAttribute("cours", cours);
        model.addAttribute("filiere", filiere);
        return "cours/byFiliere";
    }
}