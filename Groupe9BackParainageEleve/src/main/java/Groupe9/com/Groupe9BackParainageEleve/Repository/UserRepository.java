package Groupe9.com.Groupe9BackParainageEleve.Repository;

import Groupe9.com.Groupe9BackParainageEleve.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
