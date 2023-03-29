package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{

    //couplage faible
    //@Autowired


    //public MetierImpl(IDao dao) {
      //  this.dao = dao;
   // }
    @Autowired
    @Qualifier("dao")  // on veut specifier l instance a injecter

    private IDao dao;
    @Override
    public double calcul() {
        double tmp=dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }

    //cette methode c'est pour injecter dans la variable dao un objet d une qui classe implement l interface IDAO
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
