package sn.isep.dbe.demospringboot.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private int credit;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();

    @ManyToMany(mappedBy = "coursInscrits", fetch = FetchType.LAZY)
    private List<Etudiant> etudiantsInscrits = new ArrayList<>();

    public Cours() {
    }

    public Cours(String titre, int credit) {
        this.titre = titre;
        this.credit = credit;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public int getCredit() { return credit; }
    public void setCredit(int credit) { this.credit = credit; }
    public List<Note> getNotes() { return notes; }
    public void setNotes(List<Note> notes) { this.notes = notes; }
    public List<Etudiant> getEtudiantsInscrits() { return etudiantsInscrits; }
    public void setEtudiantsInscrits(List<Etudiant> etudiantsInscrits) { this.etudiantsInscrits = etudiantsInscrits; }
}