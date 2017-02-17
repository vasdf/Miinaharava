package fi.miinaharava.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KenttaTest {

    Kentta kentta;

    public KenttaTest() {
    }

    @Before
    public void setUp() {
        kentta = new Kentta(10, 10);
    }

    @Test
    public void kenttassaOikeaMaaraRuutuja() {
        int ruutuja = 0;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (kentta.getKentta()[y][x].getClass() == Ruutu.class) {
                    ruutuja++;
                }
            }
        }
        
        assertEquals(100, ruutuja);
        assertEquals(10, kentta.getKentta().length);
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void kenttaLuodaanOikeanKokoiseksi() {
        kentta.getKentta()[10][5].getX();
    }
}
