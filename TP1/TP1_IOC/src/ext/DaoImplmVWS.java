package ext;

import dao.IDao;

public class DaoImplmVWS implements IDao {

    @Override
    public double getData() {
        System.out.println("Web service");
        return 90;
    }
}
