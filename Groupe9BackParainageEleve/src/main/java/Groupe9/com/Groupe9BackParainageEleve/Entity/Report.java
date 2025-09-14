package Groupe9.com.Groupe9BackParainageEleve.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateGeneration;
    private String presence;
    private String notes;
    private String photoClasse;
    private String type;

    @ManyToOne
    @JoinColumn(name = "enfant_id")
    private Child enfant;

    @ManyToOne
    @JoinColumn(name = "parrain_id")
    private User parrain;

    //constructeur

    public Report(Long id, LocalDateTime dateGeneration, String presence, String notes, String photoClasse, String type, Child enfant, User parrain) {
        this.id = id;
        this.dateGeneration = dateGeneration;
        this.presence = presence;
        this.notes = notes;
        this.photoClasse = photoClasse;
        this.type = type;
        this.enfant = enfant;
        this.parrain = parrain;
    }

    public Report() {}


    //Getter et Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateGeneration() {
        return dateGeneration;
    }

    public void setDateGeneration(LocalDateTime dateGeneration) {
        this.dateGeneration = dateGeneration;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPhotoClasse() {
        return photoClasse;
    }

    public void setPhotoClasse(String photoClasse) {
        this.photoClasse = photoClasse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Child getEnfant() {
        return enfant;
    }

    public void setEnfant(Child enfant) {
        this.enfant = enfant;
    }

    public User getParrain() {
        return parrain;
    }

    public void setParrain(User parrain) {
        this.parrain = parrain;
    }
}

