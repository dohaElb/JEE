package pres;
import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presentation2 {
    public static void main(String[] args) throws Exception {  //InstantiationException : quand on a pas un constructeur par defaut
        //Instantiation dynamique (dans java on peut instancier dynaiquement ou statiquement )
        Scanner scanner=new Scanner(new File("config.txt"));
        String daoClassName= scanner.nextLine();
        Class cDao=Class.forName(daoClassName);
        /*
        forName on lui donne le nom de la classe et il va la chercher
        si elle existe => il va charger le byte code en memoire (toutes le classes en java sont charges 1 fois en memoire sous forme d un objet de type classe )
        dont le nom se trouve dans le fichier texte
         */

        // puisaue je ne sais pas la classe mais je sais l interface :
        IDao dao=(IDao) cDao.newInstance(); // comme si on fait new
        System.out.println(dao.getData());



        //Pour l objet metier
        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.newInstance();


        //setter dynamique
        Method methode=cMetier.getMethod("setDao",IDao.class);
        methode.invoke(metier,dao); // executer la methode

        System.out.println(metier.calcul());
    }
}
