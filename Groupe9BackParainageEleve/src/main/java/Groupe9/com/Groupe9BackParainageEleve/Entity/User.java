package Groupe9.com.Groupe9BackParainageEleve.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    private String motDePasse;
    private String telephone;
    private LocalDateTime dateCreation;
    private Boolean actif;


    // ✅ Avant insertion, remplir automatiquement la date
    @PrePersist
    protected void onCreate() {
        this.dateCreation = LocalDateTime.now();
    }
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private School school;

    @OneToMany(mappedBy = "parrain")
    private List<Sponsorship> parrainages;

    @OneToMany(mappedBy = "parrain")
    private List<Report> reports;

    @OneToMany(mappedBy = "utilisateur")
    private List<Notification> notifications;


    //Les constructeurs

    public User(Long id, String nom, String prenom, String email, String motDePasse, String telephone, LocalDateTime dateCreation, Boolean actif, Set<Role> roles, School school, List<Sponsorship> parrainages, List<Report> reports, List<Notification> notifications) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.dateCreation = dateCreation;
        this.actif = actif;
        this.roles = roles;
        this.school = school;
        this.parrainages = parrainages;
        this.reports = reports;
        this.notifications = notifications;
    }

    public User() {

    }


    // les getters et setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
