package Groupe9.com.Groupe9BackParainageEleve.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignupRequest {

    @NotBlank
    @Size(min = 2, max = 100)
    private String nom;

    @NotBlank
    @Size(min = 2, max = 100)
    private String prenom;

    @NotBlank
    @Email
    private String Email;

    @NotBlank
    @Size(min = 6)
    private String motDePasse;

    @NotBlank
    private String telephone;

    private String role; // ROLE_PARRAIN ou ROLE_SCHOOL

    // Infos école si ROLE_SCHOOL
    private String nomEcole;
    private String adresseEcole;
    private String telephoneEcole;

}
