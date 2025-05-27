package sn.isep.dbe.demospringboot.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.isep.dbe.demospringboot.models.*;
import sn.isep.dbe.demospringboot.service.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;
    private final EtudiantService etudiantService;
    private final CoursService coursService;

    public NoteController(NoteService noteService,
                          EtudiantService etudiantService,
                          CoursService coursService) {
        this.noteService = noteService;
        this.etudiantService = etudiantService;
        this.coursService = coursService;
    }

    @GetMapping
    public String listNotes(Model model) {
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);
        return "notes/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        List<Etudiant> etudiants = etudiantService.getEtudiants();
        List<Cours> cours = coursService.getAllCours();

        model.addAttribute("note", new Note());
        model.addAttribute("etudiants", etudiants);
        model.addAttribute("cours", cours);
        return "notes/add";
    }

    @PostMapping("/save")
    public String saveNote(@ModelAttribute Note note) {
        noteService.createNote(note);
        return "redirect:/notes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Note note = noteService.getAllNotes().stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ID note invalide: " + id));

        List<Etudiant> etudiants = etudiantService.getEtudiants();
        List<Cours> cours = coursService.getAllCours();

        model.addAttribute("note", note);
        model.addAttribute("etudiants", etudiants);
        model.addAttribute("cours", cours);
        return "notes/edit";
    }

    @PostMapping("/update/{id}")
    public String updateNote(@PathVariable Integer id, @ModelAttribute Note note) {
        noteService.updateNote(id, note);
        return "redirect:/notes";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable Integer id) {
        noteService.deleteNote(id);
        return "redirect:/notes";
    }

    @GetMapping("/byEtudiant/{etudiantId}")
    public String getNotesByEtudiant(@PathVariable Integer etudiantId, Model model) {
        List<Note> notes = noteService.getNotesByEtudiant(etudiantId);
        Etudiant etudiant = etudiantService.getEtudiantById(etudiantId)
                .orElseThrow(() -> new IllegalArgumentException("ID étudiant invalide: " + etudiantId));

        model.addAttribute("notes", notes);
        model.addAttribute("etudiant", etudiant);
        return "notes/byEtudiant";
    }

    @GetMapping("/byCours/{coursId}")
    public String getNotesByCours(@PathVariable Integer coursId, Model model) {
        List<Note> notes = noteService.getNotesByCours(coursId);
        Cours cours = coursService.getCoursById(coursId)
                .orElseThrow(() -> new IllegalArgumentException("ID cours invalide: " + coursId));

        model.addAttribute("notes", notes);
        model.addAttribute("cours", cours);
        return "notes/byCours";
    }
}