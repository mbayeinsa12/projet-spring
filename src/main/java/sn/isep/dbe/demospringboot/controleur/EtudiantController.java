package sn.isep.dbe.demospringboot.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.isep.dbe.demospringboot.models.Etudiant;
import sn.isep.dbe.demospringboot.models.Filiere;
import sn.isep.dbe.demospringboot.service.EtudiantService;
import sn.isep.dbe.demospringboot.service.FiliereService;

import java.util.List;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;
    private final FiliereService filiereService;

    public EtudiantController(EtudiantService etudiantService, FiliereService filiereService) {
        this.etudiantService = etudiantService;
        this.filiereService = filiereService;
    }

    @GetMapping
    public String listEtudiants(Model model) {
        List<Etudiant> etudiants = etudiantService.getEtudiants();
        model.addAttribute("etudiants", etudiants);
        return "list-etudiant";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        Etudiant etudiant = new Etudiant();
        List<Filiere> filieres = filiereService.getFilieres();

        model.addAttribute("etudiant", etudiant);
        model.addAttribute("filieres", filieres);
        return "ajout-etudiant";
    }

    @PostMapping("/save")
    public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant) {
        // Récupération de la filière persistée
        Filiere filiere = filiereService.getFiliereById(etudiant.getFiliere().getId())
                .orElseThrow(() -> new IllegalArgumentException("Filière invalide"));
        etudiant.setFiliere(filiere);

        etudiantService.addNewEtudiant(etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("modifier/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Etudiant etudiant = etudiantService.getEtudiantById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID étudiant invalide: " + id));
        if (etudiant.getFiliere() == null) {
            etudiant.setFiliere(new Filiere());
        }
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("filieres", filiereService.getFilieres());
        return "etudiant-modifier";
    }

    @PostMapping("/modifier/{id}")
    public String updateEtudiant(@PathVariable Integer id, @ModelAttribute("etudiant") Etudiant etudiant) {
        // Récupération de la filière persistée avant mise à jour
        Filiere filiere = filiereService.getFiliereById(etudiant.getFiliere().getId())
                .orElseThrow(() -> new IllegalArgumentException("Filière invalide"));
        etudiant.setFiliere(filiere);

        etudiantService.updateEtudiant(id, etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/delete/{id}")
    public String deleteEtudiant(@PathVariable Integer id) {
        etudiantService.deleteEtudiant(id);
        return "redirect:/etudiants";
    }

    @GetMapping("/byFiliere/{filiereId}")
    public String getEtudiantsByFiliere(@PathVariable Integer filiereId, Model model) {
        List<Etudiant> etudiants = etudiantService.getEtudiantsByFiliere(filiereId);
        Filiere filiere = filiereService.getFiliereById(filiereId)
                .orElseThrow(() -> new IllegalArgumentException("ID filière invalide: " + filiereId));

        model.addAttribute("etudiants", etudiants);
        model.addAttribute("filiere", filiere);
        return "etudiants/byFiliere";
    }
}
