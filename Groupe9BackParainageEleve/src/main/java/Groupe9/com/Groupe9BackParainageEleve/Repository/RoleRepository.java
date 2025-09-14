package Groupe9.com.Groupe9BackParainageEleve.Repository;

import Groupe9.com.Groupe9BackParainageEleve.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNom(String nom);
}