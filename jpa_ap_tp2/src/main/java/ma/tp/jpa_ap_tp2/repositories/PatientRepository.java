package ma.tp.jpa_ap_tp2.repositories;

import ma.tp.jpa_ap_tp2.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    public List<Patient> findByMalade(boolean m);
    public Page<Patient> findByMalade(boolean m, PageRequest of);

    public List<Patient> findByMaladeAndScoreLessThan(boolean m,int score);
    List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    //List<Patient> findByDateNaissanceBetweenAAndMaladeIsTrueOrNomLike (Date d1, Date d2,String mc);

    @Query("select p from Patient p where p.dateNaissance between :x and :y or p.nom like :z")
    List<Patient> chercherPatient(@Param("x") Date d1,@Param("y") Date d2,@Param("z") String nom);

    @Query("select p from Patient p where  p.nom like :z and p.score<:y")
    List<Patient> chercherPatient2(@Param("y") int scoreMin,@Param("z") String nom);



}
