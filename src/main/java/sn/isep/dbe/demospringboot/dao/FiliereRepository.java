package sn.isep.dbe.demospringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isep.dbe.demospringboot.models.Filiere;

import java.util.Optional;

// FiliereRepository.java
public interface FiliereRepository extends JpaRepository<Filiere, Integer> {
    Optional<Filiere> findByCode(String code);
}
