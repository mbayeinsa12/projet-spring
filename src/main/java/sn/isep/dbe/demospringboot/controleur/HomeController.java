package sn.isep.dbe.demospringboot.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/accueil")
    public String accueil() {
        return "accueil"; // Refers to accueil.jsp
    }

    @GetMapping("/") // Redirect to accueil on root URL
    public String root() {
        return "redirect:/accueil";
    }
}