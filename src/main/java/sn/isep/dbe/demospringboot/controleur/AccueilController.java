package sn.isep.dbe.demospringboot.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    @GetMapping("/")
    public String accueil() {
        return "accueil"; // Spring va chercher /WEB-INF/views/accueil.jsp
    }
}
