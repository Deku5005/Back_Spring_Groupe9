package Groupe9.com.Groupe9BackParainageEleve.Repository;

import Groupe9.com.Groupe9BackParainageEleve.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findByUserId(Long userId);
}
