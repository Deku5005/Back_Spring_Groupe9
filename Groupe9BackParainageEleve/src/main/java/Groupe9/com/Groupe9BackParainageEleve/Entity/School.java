package Groupe9.com.Groupe9BackParainageEleve.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "school")
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomEcole;
    private String adresse;
    private String telephone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "school")
    private List<Child> enfants;

    //constructeur

    public School(Long id, String nomEcole, String adresse, String telephone, User user, List<Child> enfants) {
        this.id = id;
        this.nomEcole = nomEcole;
        this.adresse = adresse;
        this.telephone = telephone;
        this.user = user;
        this.enfants = enfants;
    }


    //getters et setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEcole() {
        return nomEcole;
    }

    public void setNomEcole(String nomEcole) {
        this.nomEcole = nomEcole;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Child> getEnfants() {
        return enfants;
    }

    public void setEnfants(List<Child> enfants) {
        this.enfants = enfants;
    }
}

