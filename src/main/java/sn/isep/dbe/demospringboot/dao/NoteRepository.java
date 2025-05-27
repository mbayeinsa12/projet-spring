package sn.isep.dbe.demospringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isep.dbe.demospringboot.models.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByEtudiantId(Integer etudiantId);
    List<Note> findByCoursId(Integer coursId);
    List<Note> findByEtudiantIdAndCoursId(Integer etudiantId, Integer coursId);
}