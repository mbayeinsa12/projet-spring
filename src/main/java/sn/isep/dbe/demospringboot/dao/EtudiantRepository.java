package sn.isep.dbe.demospringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isep.dbe.demospringboot.models.Etudiant;

import java.util.List;

// EtudiantRepository.java
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    List<Etudiant> findByFiliereId(Integer filiereId);
}