package ma.emsi.springsecurity.repositories;

import ma.emsi.springsecurity.entities.Patient;
import ma.emsi.springsecurity.entities.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNomContains(String kw, Pageable pageable);
    public static void main(String[] args) {
    }
}
