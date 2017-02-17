package fi.miinaharava.logiikka;

import javax.swing.JButton;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {

    Ruutu ruutu;
    JButton painike;

    public RuutuTest() {
    }

    @Before
    public void setUp() {
        ruutu = new Ruutu(2, 3);
        
        painike = new JButton();
        
        ruutu.setPainike(painike);
    }
    
    @Test
    public void sijaintiOikein() {
        assertEquals(2, ruutu.getX());
        assertEquals(3, ruutu.getY());
    }

    @Test
    public void arvoAsetetaabOikein() {
        assertEquals(0, ruutu.getArvo());

        ruutu.setArvo(5);

        assertEquals(5, ruutu.getArvo());
    }

    @Test
    public void aluksiOnkoMiinaFalse() {
        assertFalse(ruutu.onkoMiina());
    }
    
    @Test
    public void muutoksenJalkeenOnkoMiinaTrue() {
        ruutu.asetaMiina();

        assertTrue(ruutu.onkoMiina());
        assertEquals(-1, ruutu.getArvo());
    }
    
    @Test
    public void painikkeenPainaminenToimii() {
        ruutu.setArvo(4);
        ruutu.paina();
        
        assertEquals("4", painike.getText());
        assertFalse(painike.isEnabled());
    }
    
    @Test
    public void painikkeenPainaminenToimiiJosMiina() {
        ruutu.asetaMiina();
        ruutu.paina();
        
        assertEquals("-1", painike.getText());
        assertFalse(painike.isEnabled());
    }
}
