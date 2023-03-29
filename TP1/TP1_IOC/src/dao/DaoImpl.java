package dao;

public class DaoImpl  implements IDao{


    @Override
    public double getData() {
        /*
         se connecter a la BD pour recuperer la temperature
        */
        System.out.println("v BD");
         double temp=Math.random()*40;
        return temp;
    }
}
