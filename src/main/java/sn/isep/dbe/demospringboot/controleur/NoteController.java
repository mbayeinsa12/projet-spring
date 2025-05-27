package sn.isep.dbe.demospringboot.controleur;

import sn.isep.dbe.demospringboot.models.Note;
import sn.isep.dbe.demospringboot.models.Etudiant;
import sn.isep.dbe.demospringboot.models.Cours;
import sn.isep.dbe.demospringboot.service.NoteService;
import sn.isep.dbe.demospringboot.service.EtudiantService;
import sn.isep.dbe.demospringboot.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private CoursService coursService;

    @GetMapping("/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);
        return "list-note";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        model.addAttribute("coursList", coursService.getAllCours());
        return "ajout-note";
    }

    @PostMapping("/save")
    public String saveNote(@ModelAttribute("note") Note note,
                           @RequestParam("etudiantId") Long etudiantId,
                           @RequestParam("coursId") Long coursId) {
        Optional<Etudiant> etudiantOpt = etudiantService.getEtudiantById(etudiantId);
        Optional<Cours> coursOpt = coursService.getCoursById(coursId);

        if (etudiantOpt.isPresent() && coursOpt.isPresent()) {
            note.setEtudiant(etudiantOpt.get());
            note.setCours(coursOpt.get());
            noteService.saveNote(note);
        } else {
            // Handle error, e.g., redirect with an error message
            return "redirect:/notes/add?error=true";
        }
        return "redirect:/notes/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Note> note = noteService.getNoteById(id);
        if (note.isPresent()) {
            model.addAttribute("note", note.get());
            model.addAttribute("etudiants", etudiantService.getAllEtudiants());
            model.addAttribute("coursList", coursService.getAllCours());
            return "modifier-note";
        }
        return "redirect:/notes/list";
    }

    @PostMapping("/update")
    public String updateNote(@ModelAttribute("note") Note note,
                             @RequestParam("etudiantId") Long etudiantId,
                             @RequestParam("coursId") Long coursId) {
        Optional<Etudiant> etudiantOpt = etudiantService.getEtudiantById(etudiantId);
        Optional<Cours> coursOpt = coursService.getCoursById(coursId);
        Optional<Note> existingNoteOpt = noteService.getNoteById(note.getId());

        if (existingNoteOpt.isPresent() && etudiantOpt.isPresent() && coursOpt.isPresent()) {
            Note existingNote = existingNoteOpt.get();
            existingNote.setValeur(note.getValeur());
            existingNote.setEtudiant(etudiantOpt.get());
            existingNote.setCours(coursOpt.get());
            noteService.saveNote(existingNote);
        } else {
            // Handle error
            return "redirect:/notes/edit/" + note.getId() + "?error=true";
        }
        return "redirect:/notes/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/notes/list";
    }
}