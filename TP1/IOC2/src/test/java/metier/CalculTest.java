package metier;

import org.junit.Assert;
import org.junit.Test;

public class CalculTest {
    private Calcul calcul;
    @Test   // pour que la methode soit une methode de test
    public void testSomme()
    {
        // Creation d un senario de test
        calcul=new Calcul();
        double a=5;double b=9;
        double expected=14;
        double res= calcul.somme(a,b);
        Assert.assertTrue(res==expected);


    }
}
