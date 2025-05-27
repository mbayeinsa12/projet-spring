package sn.isep.dbe.demospringboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isep.dbe.demospringboot.models.Note;
import sn.isep.dbe.demospringboot.dao.NoteRepository;

import java.util.List;

@Service
@Transactional
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Integer id, Note noteDetails) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note non trouvée"));

        note.setNote(noteDetails.getNote());
        note.setDateEnregistrement(noteDetails.getDateEnregistrement());

        return noteRepository.save(note);
    }

    public void deleteNote(Integer id) {
        noteRepository.deleteById(id);
    }

    public List<Note> getNotesByEtudiant(Integer etudiantId) {
        return noteRepository.findByEtudiantId(etudiantId);
    }

    public List<Note> getNotesByCours(Integer coursId) {
        return noteRepository.findByCoursId(coursId);
    }

    public List<Note> getNotesByEtudiantAndCours(Integer etudiantId, Integer coursId) {
        return noteRepository.findByEtudiantIdAndCoursId(etudiantId, coursId);
    }
}