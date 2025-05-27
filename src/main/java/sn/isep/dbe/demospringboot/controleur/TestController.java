package sn.isep.dbe.demospringboot.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.isep.dbe.demospringboot.dao.FiliereRepository;
import sn.isep.dbe.demospringboot.models.Filiere;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private FiliereRepository filiereRepository;

    @GetMapping("/filieres")
    public ResponseEntity<List<Filiere>> getAllFilieres() {
        return ResponseEntity.ok(filiereRepository.findAll());
    }
}