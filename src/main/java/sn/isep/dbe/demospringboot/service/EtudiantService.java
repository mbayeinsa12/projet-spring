package sn.isep.dbe.demospringboot.service;

import org.springframework.stereotype.Service;
import sn.isep.dbe.demospringboot.models.Etudiant;
import sn.isep.dbe.demospringboot.dao.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public void addNewEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    public Optional<Etudiant> getEtudiantById(Integer id) {
        return etudiantRepository.findById(id);
    }

    public void updateEtudiant(Integer id, Etudiant updatedEtudiant) {
        Etudiant existingEtudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant introuvable avec l'id: " + id));

        existingEtudiant.setNom(updatedEtudiant.getNom());
        existingEtudiant.setPrenom(updatedEtudiant.getPrenom());
        existingEtudiant.setId(updatedEtudiant.getId());
        existingEtudiant.setCarteEtudiant(updatedEtudiant.getCarteEtudiant());
        existingEtudiant.setEmail(updatedEtudiant.getEmail());
        existingEtudiant.setFiliere(updatedEtudiant.getFiliere());

        etudiantRepository.save(existingEtudiant);
    }

    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }

    public List<Etudiant> getEtudiants() {
        return etudiantRepository.findAll();
    }

    public List<Etudiant> getEtudiantsByFiliere(Integer filiereId) {
        return etudiantRepository.findAll();
    }

    // Ajoute d'autres méthodes selon besoins
}
