package fi.miinaharava.logiikka;

import fi.miinaharava.logiikka.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {

    Ruutu ruutu;

    public RuutuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruutu = new Ruutu(2, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void sijaintiOikein() {
        assertEquals(2, ruutu.getX());
        assertEquals(3, ruutu.getY());
    }

    @Test
    public void arvoAsetetaabOikein() {
        ruutu.setArvo(4);

        assertEquals(4, ruutu.getArvo());
    }

    @Test
    public void aluksiHaravointiFalse() {
        assertFalse(ruutu.onkoHaravoitu());
    }
    
    @Test
    public void aluksiOnkoMiinaFalse() {
        assertFalse(ruutu.onkoMiina());
    }

    @Test
    public void muutoksenJalkeenHaravointiTrue() {
        ruutu.haravoi();

        assertTrue(ruutu.onkoHaravoitu());
    }
    
    @Test
    public void muutoksenJalkeenOnkoMiinaTrue() {
        ruutu.asetaMiina();

        assertTrue(ruutu.onkoMiina());
    }

    @Test
    public void arvoOikein() {
        assertEquals(0, ruutu.getArvo());

        ruutu.setArvo(5);

        assertEquals(5, ruutu.getArvo());
    }
}
