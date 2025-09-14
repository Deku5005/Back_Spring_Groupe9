package Groupe9.com.Groupe9BackParainageEleve.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeDepense;
    private BigDecimal montant;
    private String justificatif;
    private LocalDateTime dateEnregistrement;

    @ManyToOne
    @JoinColumn(name = "paiement_id")
    private Payment paiement;

    //Constructeur

    public Expense(Long id, String typeDepense, BigDecimal montant, String justificatif, LocalDateTime dateEnregistrement, Payment paiement) {
        this.id = id;
        this.typeDepense = typeDepense;
        this.montant = montant;
        this.justificatif = justificatif;
        this.dateEnregistrement = dateEnregistrement;
        this.paiement = paiement;
    }

    public Expense() {

    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", typeDepense='" + typeDepense + '\'' +
                ", montant=" + montant +
                ", justificatif='" + justificatif + '\'' +
                ", dateEnregistrement=" + dateEnregistrement +
                ", paiement=" + paiement +
                '}';
    }

    //Getter et setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeDepense() {
        return typeDepense;
    }

    public void setTypeDepense(String typeDepense) {
        this.typeDepense = typeDepense;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getJustificatif() {
        return justificatif;
    }

    public void setJustificatif(String justificatif) {
        this.justificatif = justificatif;
    }

    public LocalDateTime getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(LocalDateTime dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public Payment getPaiement() {
        return paiement;
    }

    public void setPaiement(Payment paiement) {
        this.paiement = paiement;
    }
}


