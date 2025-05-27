package sn.isep.dbe.demospringboot.dao;

import sn.isep.dbe.demospringboot.models.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
}