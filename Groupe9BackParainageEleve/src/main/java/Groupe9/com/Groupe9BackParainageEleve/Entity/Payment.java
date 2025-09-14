package Groupe9.com.Groupe9BackParainageEleve.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal montant;
    private LocalDateTime datePaiement;
    private String moyenPaiement;
    private String statut;
    private String referenceTransaction;

    @ManyToOne
    @JoinColumn(name = "parrainage_id")
    private Sponsorship parrainage;

    @OneToMany(mappedBy = "paiement")
    private List<Expense> depenses;

    //Constructeur

    public Payment(Long id, BigDecimal montant, LocalDateTime datePaiement, String moyenPaiement, String statut, String referenceTransaction, Sponsorship parrainage, List<Expense> depenses) {
        this.id = id;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.moyenPaiement = moyenPaiement;
        this.statut = statut;
        this.referenceTransaction = referenceTransaction;
        this.parrainage = parrainage;
        this.depenses = depenses;
    }

    public Payment() {}


    //Getter et Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(String moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getReferenceTransaction() {
        return referenceTransaction;
    }

    public void setReferenceTransaction(String referenceTransaction) {
        this.referenceTransaction = referenceTransaction;
    }

    public Sponsorship getParrainage() {
        return parrainage;
    }

    public void setParrainage(Sponsorship parrainage) {
        this.parrainage = parrainage;
    }

    public List<Expense> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<Expense> depenses) {
        this.depenses = depenses;
    }
}

