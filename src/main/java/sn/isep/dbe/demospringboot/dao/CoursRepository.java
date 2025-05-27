package sn.isep.dbe.demospringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isep.dbe.demospringboot.models.Cours;

import java.util.List;
import java.util.Optional;

public interface CoursRepository extends JpaRepository<Cours, Integer> {
    List<Cours> findByFiliereId(Integer filiereId);
    List<Cours> findByNomContainingIgnoreCase(String nom);
    Optional<Cours> findByCode(String code);
}