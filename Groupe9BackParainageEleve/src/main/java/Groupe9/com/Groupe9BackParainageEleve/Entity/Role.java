package Groupe9.com.Groupe9BackParainageEleve.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    //constructeur

    public Role(Long id, String nom, Set<User> users) {
        this.id = id;
        this.nom = nom;
        this.users = users;
    }

    public Role() {

    }


    // getter et setter


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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

