package ma.tp.jpa_ap_tp2;

import ma.tp.jpa_ap_tp2.entities.Patient;
import ma.tp.jpa_ap_tp2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaApTp2Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRep;
    public static void main(String[] args) {

        SpringApplication.run(JpaApTp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i =0 ;i<100;i++)
        {
            patientRep.save(new Patient(null,"hassan",new Date(),Math.random()>0.5?true:false,(int)Math.random()*100))
            ;
        }


        patientRep.save(new Patient(null,"doha",new Date(),true,50));
        patientRep.save(new Patient(null,"soukayna",new Date(),false,100));
        patientRep.save(new Patient(null,"saad",new Date(),false,30));

       Page<Patient> patient= patientRep.findAll(PageRequest.of(0,5));
        System.out.println("total pages"+patient.getTotalPages());
        System.out.println("total elem"+patient.getTotalElements());
        System.out.println("page number"+patient.getNumber());
        List<Patient> content=patient.getContent();
        Page<Patient> byMalade=patientRep.findByMalade(true,PageRequest.of(3,5 ));
        List<Patient> testQuery=patientRep.chercherPatient2(40,"%h%");

        byMalade.forEach(p->
               {
                   System.out.println("------------------------------");
                   System.out.println(p.getId());
                   System.out.println(p.getNom());
                   System.out.println(p.getDateNaissance());
                   System.out.println(p.getScore());
                   System.out.println(p.isMalade());
               }
               );
        System.out.println("||||||||||||||||||||||||||||||");
        Patient pat=patientRep.findById(1L).orElse(null);
        if(pat!=null)
        {
            System.out.println(pat.getNom());
            System.out.println(pat.isMalade());
        }
        pat.setScore(1200);
        patientRep.save(pat);    // update si l objet a un id a une valeur sinon si id=null save fera insert
       // patientRep.deleteById(1L);

    }
}
