package ext;

import dao.IDao;

public class DaoImplm2 implements IDao {

    @Override
    public double getData() {
        System.out.println("version capteur");
        double temp=1000;
        return temp;
    }
}
