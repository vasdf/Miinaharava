package fi.miinaharava.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinojenluojaTest {

    Kentta kentta;
    Miinojenluoja miinojenluoja;
    
    public MiinojenluojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kentta = new Kentta(10, 15);
        miinojenluoja = kentta.getMiinojenluoja();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoOikeanMaaranMiinoja() {
        int miinoja = 0;
        
        for (int y = 0; y < kentta.getKentta().length; y++) {
            for (int x = 0; x < kentta.getKentta().length; x++) {
                if (kentta.getKentta()[y][x].onkoMiina()) {
                    miinoja++;
                }
            }
        }

        assertEquals(15, miinoja);
    }
}
