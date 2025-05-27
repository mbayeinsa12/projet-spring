package sn.isep.dbe.demospringboot.controleur;

import sn.isep.dbe.demospringboot.models.Etudiant;
import sn.isep.dbe.demospringboot.models.Filiere;
import sn.isep.dbe.demospringboot.models.Cours; // Needed for many-to-many enrollment
import sn.isep.dbe.demospringboot.service.EtudiantService;
import sn.isep.dbe.demospringboot.service.FiliereService;
import sn.isep.dbe.demospringboot.service.CoursService; // Inject CoursService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private CoursService coursService; // Inject CoursService

    @GetMapping("/list")
    public String listEtudiants(Model model) {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        model.addAttribute("etudiants", etudiants);
        return "list-etudiant";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        model.addAttribute("filieres", filiereService.getAllFilieres());
        model.addAttribute("allCours", coursService.getAllCours()); // For Many-to-Many enrollment
        return "ajout-etudiant";
    }

    @PostMapping("/save")
    public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
                               @RequestParam(value = "coursIds", required = false) List<Long> coursIds) {
        // Handle Filiere if it's new or selected from existing
        if (etudiant.getFiliere() != null && etudiant.getFiliere().getId() != null) {
            filiereService.getFiliereById(etudiant.getFiliere().getId())
                    .ifPresent(etudiant::setFiliere);
        } else {
            etudiant.setFiliere(null); // Or handle creation of new Filiere if needed
        }

        // Handle Many-to-Many relationship with Cours
        if (coursIds != null && !coursIds.isEmpty()) {
            List<Cours> selectedCours = coursIds.stream()
                    .map(coursService::getCoursById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            etudiant.setCoursInscrits(selectedCours);
        } else {
            etudiant.setCoursInscrits(new ArrayList<>());
        }

        etudiantService.saveEtudiant(etudiant);
        return "redirect:/etudiants/list";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Etudiant> etudiant = etudiantService.getEtudiantById(id);
        if (etudiant.isPresent()) {
            model.addAttribute("etudiant", etudiant.get());
            model.addAttribute("filieres", filiereService.getAllFilieres());
            model.addAttribute("allCours", coursService.getAllCours()); // For Many-to-Many enrollment
            return "modifier-etudiant";
        }
        return "redirect:/etudiants/list";
    }

    @PostMapping("/update") // Use update for submission from edit form
    public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
                                 @RequestParam(value = "coursIds", required = false) List<Long> coursIds) {
        // Fetch existing etudiant to avoid detaching issues
        Optional<Etudiant> existingEtudiantOpt = etudiantService.getEtudiantById(etudiant.getId());
        if (existingEtudiantOpt.isPresent()) {
            Etudiant existingEtudiant = existingEtudiantOpt.get();
            existingEtudiant.setNom(etudiant.getNom());
            existingEtudiant.setPrenom(etudiant.getPrenom());
            existingEtudiant.setDateNaissance(etudiant.getDateNaissance());

            // Update Filiere
            if (etudiant.getFiliere() != null && etudiant.getFiliere().getId() != null) {
                filiereService.getFiliereById(etudiant.getFiliere().getId())
                        .ifPresent(existingEtudiant::setFiliere);
            } else {
                existingEtudiant.setFiliere(null);
            }

            // Update Many-to-Many relationship with Cours
            if (coursIds != null && !coursIds.isEmpty()) {
                List<Cours> selectedCours = coursIds.stream()
                        .map(coursService::getCoursById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());
                existingEtudiant.setCoursInscrits(selectedCours);
            } else {
                existingEtudiant.setCoursInscrits(new ArrayList<>());
            }
            etudiantService.saveEtudiant(existingEtudiant);
        }
        return "redirect:/etudiants/list";
    }


    @PostMapping("/delete/{id}")
    public String deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return "redirect:/etudiants/list";
    }
}