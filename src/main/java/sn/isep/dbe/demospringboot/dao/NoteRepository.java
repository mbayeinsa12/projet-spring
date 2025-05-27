package sn.isep.dbe.demospringboot.dao;

import sn.isep.dbe.demospringboot.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}