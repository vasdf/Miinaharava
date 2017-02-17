package fi.miinaharava.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinojenluojaTest {

    Kentta kentta;
    Miinojenluoja miinojenluoja;
    
    public MiinojenluojaTest() {
    }
    
    @Before
    public void setUp() {
        kentta = new Kentta(10, 15);
        miinojenluoja = kentta.getMiinojenluoja();
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
