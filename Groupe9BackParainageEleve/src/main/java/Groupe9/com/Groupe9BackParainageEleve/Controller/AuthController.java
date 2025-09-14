package Groupe9.com.Groupe9BackParainageEleve.Controller;


import Groupe9.com.Groupe9BackParainageEleve.Config.JwtUtils;
import Groupe9.com.Groupe9BackParainageEleve.DTO.LoginRequest;
import Groupe9.com.Groupe9BackParainageEleve.DTO.SignupRequest;
import Groupe9.com.Groupe9BackParainageEleve.Entity.School;
import Groupe9.com.Groupe9BackParainageEleve.Entity.User;
import Groupe9.com.Groupe9BackParainageEleve.Repository.RoleRepository;
import Groupe9.com.Groupe9BackParainageEleve.Repository.SchoolRepository;
import Groupe9.com.Groupe9BackParainageEleve.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.RuntimeException;
import java.util.HashMap;

import Groupe9.com.Groupe9BackParainageEleve.Entity.Role;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;





    @PostMapping("/signup")
    public String registerUser(@RequestBody SignupRequest signupRequest){

        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return "Erreur : Email deja utilisé";
        }

        //Creer le user
        User user = new User();
        user.setNom(signupRequest.getNom());
        user.setPrenom(signupRequest.getPrenom());
        user.setEmail(signupRequest.getEmail());
        user.setTelephone(signupRequest.getTelephone());
        user.setMotDePasse(passwordEncoder.encode(signupRequest.getMotDePasse()));
        user.setActif(true);
        userRepository.save(user);


        // Assigner le rôle
        Role roleEntity = roleRepository.findByNom(signupRequest.getRole())
                .orElseThrow(() -> new RuntimeException("Erreur: rôle introuvable."));

        user.getRoles().add(roleEntity);

        userRepository.save(user);


        // Si rôle SCHOOL, créer la ligne School
        if ("ROLE_SCHOOL".equals(signupRequest.getRole())) {
            School school = new School();
            school.setUser(user);
            school.setNomEcole(signupRequest.getNomEcole());
            school.setAdresse(signupRequest.getAdresseEcole());
            school.setTelephone(signupRequest.getTelephoneEcole());
            schoolRepository.save(school);
        }

        return "Utilisateur enregistré avec succès !";



    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(loginRequest.getMotDePasse(), user.getMotDePasse())) {
            return ResponseEntity.status(401).body("Mot de passe incorrect");
        }


        String token = jwtUtils.generateToken(user.getEmail());

        return ResponseEntity.ok(new HashMap<>() {{
            put("token", token);
            put("email", user.getEmail());
            put("roles", user.getRoles().stream().map(Role::getNom).toList());
        }});
    }

}
