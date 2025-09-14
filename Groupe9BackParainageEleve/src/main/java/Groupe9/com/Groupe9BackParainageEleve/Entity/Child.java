package Groupe9.com.Groupe9BackParainageEleve.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "child")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String photo;
    private String niveau;
    private String besoinsSpeciaux;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "enfant")
    private List<Sponsorship> parrainages;

    @OneToMany(mappedBy = "enfant")
    private List<Report> reports;


    //constructeur


    public Child(Long id,
                 String nom,
                 String prenom,
                 LocalDate dateNaissance,
                 String photo,
                 String niveau,
                 String besoinsSpeciaux,
                 School school,
                 List<Sponsorship> parrainages,
                 List<Report> reports) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
        this.niveau = niveau;
        this.besoinsSpeciaux = besoinsSpeciaux;
        this.school = school;
        this.parrainages = parrainages;
        this.reports = reports;
    }

    public Child() {

    }

    //getter et setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getBesoinsSpeciaux() {
        return besoinsSpeciaux;
    }

    public void setBesoinsSpeciaux(String besoinsSpeciaux) {
        this.besoinsSpeciaux = besoinsSpeciaux;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Sponsorship> getParrainages() {
        return parrainages;
    }

    public void setParrainages(List<Sponsorship> parrainages) {
        this.parrainages = parrainages;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}

