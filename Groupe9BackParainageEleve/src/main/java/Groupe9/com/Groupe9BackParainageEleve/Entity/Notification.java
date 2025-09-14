package Groupe9.com.Groupe9BackParainageEleve.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String message;
    private LocalDateTime dateEnvoi;
    private String type;
    private Boolean lu;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User utilisateur;

    //Constructor

    public Notification(Long id, String titre, String message, LocalDateTime dateEnvoi, String type, Boolean lu, User utilisateur) {
        this.id = id;
        this.titre = titre;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
        this.type = type;
        this.lu = lu;
        this.utilisateur = utilisateur;
    }

    public Notification() {}


    //Getter et Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDateTime dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }
}

