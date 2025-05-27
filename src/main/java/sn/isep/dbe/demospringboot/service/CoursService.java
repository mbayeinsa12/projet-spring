package sn.isep.dbe.demospringboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isep.dbe.demospringboot.models.Cours;
import sn.isep.dbe.demospringboot.dao.CoursRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoursService {

    private final CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    public Optional<Cours> getCoursById(Integer id) {
        return coursRepository.findById(id);
    }

    public Cours createCours(Cours cours) {
        return coursRepository.save(cours);
    }

    public Cours updateCours(Integer id, Cours coursDetails) {
        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));

        cours.setCode(coursDetails.getCode());
        cours.setNom(coursDetails.getNom());
        cours.setDescription(coursDetails.getDescription());
        cours.setVolumeHoraire(coursDetails.getVolumeHoraire());
        cours.setFiliere(coursDetails.getFiliere());

        return coursRepository.save(cours);
    }

    public void deleteCours(Integer id) {
        coursRepository.deleteById(id);
    }

    public List<Cours> getCoursByFiliere(Integer filiereId) {
        return coursRepository.findByFiliereId(filiereId);
    }

    public List<Cours> searchCoursByNom(String nom) {
        return coursRepository.findByNomContainingIgnoreCase(nom);
    }
}
