package fi.miinaharava.logiikka;

import javax.swing.JButton;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutujenPainajaTest {

    private RuutujenPainaja painaja;
    private Ruutu[][] ruudukko;

    public RuutujenPainajaTest() {
    }

    @Before
    public void setUp() {
        ruudukko = new Ruutu[10][10];

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Ruutu ruutu = new Ruutu(x, y);

                JButton painike = new JButton();

                ruutu.setPainike(painike);

                ruudukko[y][x] = ruutu;
            }
        }

        painaja = new RuutujenPainaja(ruudukko);

        PelinHallinta ph = new PelinHallinta(new Kentta(10, 10));
    }

    @Test
    public void paina() {
        ruudukko[4][5].setArvo(3);

        painaja.paina(ruudukko[4][5]);

        assertFalse(ruudukko[4][5].getPainike().isEnabled());
    }

    @Test
    public void painaRuutuja() {
        ruudukko[3][3].setArvo(3);
        ruudukko[3][4].setArvo(3);
        ruudukko[3][5].setArvo(1);
        ruudukko[3][6].setArvo(3);
        ruudukko[3][7].setArvo(3);
        ruudukko[4][7].setArvo(1);
        ruudukko[5][7].setArvo(3);
        ruudukko[4][8].setArvo(3);
        ruudukko[4][9].setArvo(10);
        ruudukko[5][9].setArvo(3);
        ruudukko[7][9].setArvo(3);
        ruudukko[7][8].setArvo(3);
        ruudukko[7][7].setArvo(3);
        ruudukko[7][6].setArvo(9);
        ruudukko[7][5].setArvo(3);
        ruudukko[7][4].setArvo(3);
        ruudukko[7][3].setArvo(3);
        ruudukko[6][3].setArvo(7);
        ruudukko[5][3].setArvo(3);
        ruudukko[4][3].setArvo(3);

        painaja.paina(ruudukko[5][5]);

        assertFalse(ruudukko[4][4].getPainike().isEnabled());
        assertFalse(ruudukko[4][5].getPainike().isEnabled());
        assertFalse(ruudukko[4][6].getPainike().isEnabled());
        assertFalse(ruudukko[5][6].getPainike().isEnabled());
        assertFalse(ruudukko[6][6].getPainike().isEnabled());
        assertFalse(ruudukko[6][5].getPainike().isEnabled());
        assertFalse(ruudukko[6][4].getPainike().isEnabled());
        assertFalse(ruudukko[5][4].getPainike().isEnabled());
        assertFalse(ruudukko[6][7].getPainike().isEnabled());
        assertFalse(ruudukko[6][8].getPainike().isEnabled());
        assertFalse(ruudukko[5][8].getPainike().isEnabled());
        assertFalse(ruudukko[6][9].getPainike().isEnabled());
        assertTrue(ruudukko[1][2].getPainike().isEnabled());
        assertTrue(ruudukko[9][9].getPainike().isEnabled());
        assertTrue(ruudukko[5][2].getPainike().isEnabled());
    }

    @Test
    public void peliLoppuuKunPainetaanMiinaa() {
        ruudukko[2][2].asetaMiina();

        painaja.paina(ruudukko[2][2]);

        int i = 0;
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (ruudukko[y][x].getPainike().isEnabled()) {
                    i++;
                }

            }
        }

        assertEquals(0, i);
    }

    @Test
    public void peliLoppuuKunOllaanValtettyKaikkiaMiinoja() {
        assertFalse(painaja.onkoKaikkiaEiMiinojaPainettu());

        ruudukko[2][2].asetaMiina();
        ruudukko[2][2].setArvo(-1);
        ruudukko[1][1].asetaMiina();
        ruudukko[1][1].setArvo(-1);
        ruudukko[7][6].setArvo(9);
        ruudukko[7][5].setArvo(3);
        ruudukko[7][4].setArvo(3);
        ruudukko[7][3].setArvo(3);
        ruudukko[6][3].setArvo(7);
        ruudukko[5][3].setArvo(3);
        ruudukko[4][3].setArvo(3);

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (x != 2 | y != 2) {
                    if (x != 1 & y != 1) {
                    } else {
                        painaja.paina(ruudukko[y][x]);
                    }
                }

            }
        }

        assertTrue(painaja.onkoKaikkiaEiMiinojaPainettu());

        int i = 0;

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (ruudukko[y][x].getPainike().isEnabled()) {
                    i++;
                }

            }
        }

        assertEquals(0, i);
    }
    
    @Test
    public void painaKaikkiaToimii() {
        painaja.painaKaikkia();
        
        int i = 0;

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (ruudukko[y][x].getPainike().isEnabled()) {
                    i++;
                }

            }
        }
        
        assertEquals(0,i);
    }
}
