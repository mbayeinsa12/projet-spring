package sn.isep.dbe.demospringboot.service;

import sn.isep.dbe.demospringboot.dao.CoursRepository;
import sn.isep.dbe.demospringboot.models.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    public Optional<Cours> getCoursById(Long id) {
        return coursRepository.findById(id);
    }

    public Cours saveCours(Cours cours) {
        return coursRepository.save(cours);
    }

    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }
}