
package fi.miinaharava.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuudunarvonlaskijaTest {
    private Ruudunarvonlaskija laskija;
    private Ruutu[][] ruudukko;
    
    public RuudunarvonlaskijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruudukko = new Ruutu[10][10];
        
        for (int y = 0; y < 10; y++) {
            for (int x =  0; x < 10; x++) {
                ruudukko[y][x] = new Ruutu(x, y);
            }
        }
        ruudukko[3][4].asetaMiina();
        ruudukko[4][4].asetaMiina();
        ruudukko[5][5].asetaMiina();
        ruudukko[0][0].asetaMiina();
        ruudukko[9][6].asetaMiina();
        
        this.laskija = new Ruudunarvonlaskija(ruudukko);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void laskeArvoToimii() {
        laskija.laskeArvo(ruudukko[1][1]);
        assertEquals(1,ruudukko[1][1].getArvo());
        laskija.laskeArvo(ruudukko[4][3]);
        assertEquals(2,ruudukko[4][3].getArvo());
        laskija.laskeArvo(ruudukko[0][2]);
        assertEquals(0,ruudukko[0][2].getArvo());
    }
    
    @Test
    public void laskeArvotToimii() {
        laskija.laskeArvot(ruudukko);
        assertEquals(1,ruudukko[1][1].getArvo());
        assertEquals(2,ruudukko[4][3].getArvo());
        assertEquals(0,ruudukko[0][2].getArvo());
        assertEquals(0,ruudukko[9][9].getArvo());
        assertEquals(1,ruudukko[9][6].getArvo());
        assertEquals(3,ruudukko[4][5].getArvo());
        assertEquals(1,ruudukko[6][6].getArvo());
    }    
    
    @Test
    public void onkoLahekkainToimii() {
        assertTrue(laskija.onkoLahekkain(ruudukko[0][2], ruudukko[1][1]));
        assertTrue(laskija.onkoLahekkain(ruudukko[2][2], ruudukko[1][1]));
        assertTrue(laskija.onkoLahekkain(ruudukko[5][4], ruudukko[4][5]));
        assertTrue(laskija.onkoLahekkain(ruudukko[3][2], ruudukko[3][3]));
        assertFalse(laskija.onkoLahekkain(ruudukko[3][2], ruudukko[3][4]));
        assertFalse(laskija.onkoLahekkain(ruudukko[0][0], ruudukko[5][4]));
        assertFalse(laskija.onkoLahekkain(ruudukko[0][0], ruudukko[3][0]));
        assertFalse(laskija.onkoLahekkain(ruudukko[5][5], ruudukko[3][3]));
    }
}
