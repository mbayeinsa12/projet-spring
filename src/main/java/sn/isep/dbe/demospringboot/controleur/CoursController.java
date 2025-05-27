package sn.isep.dbe.demospringboot.controleur;

import sn.isep.dbe.demospringboot.models.Cours;
import sn.isep.dbe.demospringboot.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @GetMapping("/list")
    public String listCours(Model model) {
        List<Cours> cours = coursService.getAllCours();
        model.addAttribute("cours", cours);
        return "list-cours";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("cours", new Cours());
        return "ajout-cours";
    }

    @PostMapping("/save")
    public String saveCours(@ModelAttribute("cours") Cours cours) {
        coursService.saveCours(cours);
        return "redirect:/cours/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Cours> cours = coursService.getCoursById(id);
        if (cours.isPresent()) {
            model.addAttribute("cours", cours.get());
            return "modifier-cours";
        }
        return "redirect:/cours/list";
    }

    @PostMapping("/update")
    public String updateCours(@ModelAttribute("cours") Cours cours) {
        coursService.saveCours(cours);
        return "redirect:/cours/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
        return "redirect:/cours/list";
    }
}