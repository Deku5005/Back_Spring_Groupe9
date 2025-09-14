package Groupe9.com.Groupe9BackParainageEleve.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sponsorship")
public class Sponsorship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateParrainage;
    private Boolean actif;
    private BigDecimal montantInitial;

    @ManyToOne
    @JoinColumn(name = "parrain_id")
    private User parrain;

    @ManyToOne
    @JoinColumn(name = "enfant_id")
    private Child enfant;

    @OneToMany(mappedBy = "parrainage")
    private List<Payment> payments;

    // constructeur

    public Sponsorship(Long id, LocalDateTime dateParrainage, Boolean actif, BigDecimal montantInitial, User parrain, Child enfant, List<Payment> payments) {
        this.id = id;
        this.dateParrainage = dateParrainage;
        this.actif = actif;
        this.montantInitial = montantInitial;
        this.parrain = parrain;
        this.enfant = enfant;
        this.payments = payments;
    }

    public Sponsorship() {

    }


    //Setter et getter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateParrainage() {
        return dateParrainage;
    }

    public void setDateParrainage(LocalDateTime dateParrainage) {
        this.dateParrainage = dateParrainage;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public BigDecimal getMontantInitial() {
        return montantInitial;
    }

    public void setMontantInitial(BigDecimal montantInitial) {
        this.montantInitial = montantInitial;
    }

    public User getParrain() {
        return parrain;
    }

    public void setParrain(User parrain) {
        this.parrain = parrain;
    }

    public Child getEnfant() {
        return enfant;
    }

    public void setEnfant(Child enfant) {
        this.enfant = enfant;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}


