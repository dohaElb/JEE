package pres;

import dao.DaoImpl;
import ext.DaoImplm2;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        /*
        Injecton des dependance par instatnciation static cad new (couplage fort) (ce n'est pas pratique c'est probleme pour la maintenance)
         */

        MetierImpl metier=new MetierImpl();

        /*exception 'NullPointerException' car on a appeler une methode
          d'un objet null qui n etait pas cree (on n a pas satisfait les dependances )
          il faut injecter les dependances
        */
       // DaoImpl dao=new DaoImpl();
        DaoImplm2 dao=new DaoImplm2();

        metier.setDao(dao);

        System.out.println(metier.calcul());

        /*
        NB :
        la classe dans laquelle on cree des objet et on fait l injection des dependance s'appel factory
         */
    }
}
