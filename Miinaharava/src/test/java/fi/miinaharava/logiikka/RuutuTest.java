package fi.miinaharava.logiikka;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
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
    public void arvollinenPainikeToimiiOikein() {
        ruutu.setArvo(4);
        ruutu.paina();
        
        assertEquals("4", painike.getText());
        assertFalse(painike.isEnabled());
        assertEquals(new Font("", Font.PLAIN, 20), painike.getFont());
        assertEquals(new Insets(0, 0, 0, 0), painike.getMargin());
    }
    
    @Test
    public void miinaPainikeToimiiOikein() {
        ruutu.asetaMiina();
        ruutu.paina();
        
        assertEquals("*", painike.getText());
        assertFalse(painike.isEnabled());
        assertEquals(Color.red, painike.getBackground());
        assertEquals(new Font("", Font.PLAIN, 30), painike.getFont());
        assertEquals(new Insets(12, 0, 0, 0), painike.getMargin());
        assertFalse(ruutu.getPainike().isEnabled());
    }
    
    @Test
    public void tyhjanRuudunArvoOikein() {
        ruutu.setArvo(0);
        ruutu.paina();
        assertEquals("", painike.getText());
        assertFalse(ruutu.getPainike().isEnabled());
    }
}
