package sn.isep.dbe.demospringboot.controleur;

import sn.isep.dbe.demospringboot.models.Filiere;
import sn.isep.dbe.demospringboot.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @GetMapping("/list")
    public String listFilieres(Model model) {
        List<Filiere> filieres = filiereService.getAllFilieres();
        model.addAttribute("filieres", filieres);
        return "list-filiere";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("filiere", new Filiere());
        return "ajout-filiere";
    }

    @PostMapping("/save")
    public String saveFiliere(@ModelAttribute("filiere") Filiere filiere) {
        filiereService.saveFiliere(filiere);
        return "redirect:/filieres/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Filiere> filiere = filiereService.getFiliereById(id);
        if (filiere.isPresent()) {
            model.addAttribute("filiere", filiere.get());
            return "modifier-filiere";
        }
        return "redirect:/filieres/list";
    }

    @PostMapping("/update") // Use update for submission from edit form
    public String updateFiliere(@ModelAttribute("filiere") Filiere filiere) {
        filiereService.saveFiliere(filiere); // save will update if ID exists
        return "redirect:/filieres/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
        return "redirect:/filieres/list";
    }
}