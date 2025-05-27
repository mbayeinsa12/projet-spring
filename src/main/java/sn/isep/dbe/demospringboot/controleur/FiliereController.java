package sn.isep.dbe.demospringboot.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.isep.dbe.demospringboot.models.Filiere;
import sn.isep.dbe.demospringboot.service.FiliereService;

import java.util.List;

@Controller
@RequestMapping("/filieres")
public class FiliereController {

    private final FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @GetMapping
    public String listFilieres(Model model) {
        List<Filiere> filieres = filiereService.getFilieres();
        model.addAttribute("filieres", filieres);
        return "filieres/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("filiere", new Filiere());
        return "filieres/add";
    }

    @PostMapping("/save")
    public String saveFiliere(@ModelAttribute Filiere filiere) {
        filiereService.createFiliere(filiere);
        return "redirect:/filieres";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Filiere filiere = filiereService.getFiliereById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID filière invalide: " + id));
        model.addAttribute("filiere", filiere);
        return "filieres/edit";
    }

    @PostMapping("/update/{id}")
    public String updateFiliere(@PathVariable Integer id, @ModelAttribute Filiere filiere) {
        filiereService.updateFiliere(id, filiere);
        return "redirect:/filieres";
    }

    @GetMapping("/delete/{id}")
    public String deleteFiliere(@PathVariable Integer id) {
        filiereService.deleteFiliere(id);
        return "redirect:/filieres";
    }

    @GetMapping("/search")
    public String searchFilieres(@RequestParam String nom, Model model) {
        List<Filiere> filieres = filiereService.searchByNom(nom);
        model.addAttribute("filieres", filieres);
        return "filieres/list";
    }
}