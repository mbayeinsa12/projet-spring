package sn.isep.dbe.demospringboot.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sn.isep.dbe.demospringboot.dao.FiliereRepository;
import sn.isep.dbe.demospringboot.models.Filiere;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FiliereService {

    private final FiliereRepository filiereRepository;

    public FiliereService(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    public List<Filiere> getFilieres() {
        return filiereRepository.findAll();
    }

    public Optional<Filiere> getFiliereById(Integer id) {
        return filiereRepository.findById(id);
    }

    public Filiere createFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    public void deleteFiliere(Integer id) {
        filiereRepository.deleteById(id);
    }

    public void updateFiliere(Integer id, Filiere filiere) {
    }

    public List<Filiere> searchByNom(String nom) {
        return searchByNom(nom);
    }
}
