
package fi.miinaharava.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HaravaTest {
    private Harava harava;
    private Kentta kentta;
    private Ruutu ruutu;
    
    public HaravaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kentta = new Kentta(10, 20);
        harava = new Harava(kentta.getKentta());
        ruutu = new Ruutu(5,5);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void yhdenRuudunHaravointi() {
        assertFalse(ruutu.onkoHaravoitu());
        
        harava.haravoiRuutu(ruutu);
        
        assertTrue(ruutu.onkoHaravoitu());
    }
    
    @Test
    public void haravoiYmparillaOlevat() {
        //todo
    }
    
    @Test
    public void onkoRuudutLahekkain() {
        Ruutu ruutu1 = new Ruutu(3,3);
        Ruutu ruutu2 = new Ruutu(3,2);
        Ruutu ruutu3 = new Ruutu(2,2);
        Ruutu ruutu4 = new Ruutu(4,4);
        Ruutu ruutu5 = new Ruutu(4,2);
        Ruutu ruutu6 = new Ruutu(2,4);
        Ruutu ruutu7 = new Ruutu(1,3);
        Ruutu ruutu8 = new Ruutu(5,7);
        
        assertTrue(harava.onkoLahekkain(ruutu1, ruutu2));
        assertTrue(harava.onkoLahekkain(ruutu1, ruutu3));
        assertTrue(harava.onkoLahekkain(ruutu1, ruutu4));
        assertTrue(harava.onkoLahekkain(ruutu1, ruutu5));
        assertTrue(harava.onkoLahekkain(ruutu1, ruutu6));
        assertTrue(harava.onkoLahekkain(ruutu2, ruutu3));
        assertFalse(harava.onkoLahekkain(ruutu1, ruutu7));
        assertFalse(harava.onkoLahekkain(ruutu1, ruutu8));    
    }
    
    
}
