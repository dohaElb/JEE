package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImplm2 implements IDao {

    @Override
    public double getData() {
        System.out.println("version capteur");
        double temp=1000;
        return temp;
    }
}
