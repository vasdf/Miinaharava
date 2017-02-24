package fi.miinaharava.logiikka;

import java.util.ArrayList;
import javax.swing.JButton;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VierekkaistenRuutujenEtsijaTest {

    private RuutujenEtsija etsija;
    private Ruutu[][] ruudukko;

    public VierekkaistenRuutujenEtsijaTest() {
    }

    @Before
    public void setUp() {
        ruudukko = new Ruutu[15][15];

        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 15; x++) {
                Ruutu ruutu = new Ruutu(x, y);

                JButton painike = new JButton();

                ruutu.setPainike(painike);

                ruudukko[y][x] = ruutu;
            }
        }

        etsija = new RuutujenEtsija(ruudukko);
    }

    @Test
    public void etsiiViereisetRuudut() {
        ArrayList<Ruutu> viereiset1 = etsija.etsiVierekkaisetRuudut(ruudukko[3][5]);
        ArrayList<Ruutu> viereiset2 = etsija.etsiVierekkaisetRuudut(ruudukko[0][0]);

        assertEquals(9, viereiset1.size());
        assertEquals(4, viereiset2.size());
    }

    @Test
    public void eiLoydaMiinoja() {
        ruudukko[4][4].asetaMiina();
        ruudukko[4][5].asetaMiina();
        ruudukko[4][6].asetaMiina();
        ruudukko[5][6].asetaMiina();
        ruudukko[6][6].asetaMiina();
        ruudukko[6][5].asetaMiina();
        ruudukko[6][4].asetaMiina();
        ruudukko[5][4].asetaMiina();

        ArrayList<Ruutu> viereiset1 = etsija.etsiVierekkaisetRuudut(ruudukko[5][5]);

        assertEquals(1, viereiset1.size());
    }

    @Test
    public void eiLoydaJoPainettujaRuutuja() {
        ruudukko[4][4].paina();
        ruudukko[4][5].paina();
        ruudukko[4][6].paina();
        ruudukko[5][6].paina();
        ruudukko[6][6].paina();
        ruudukko[6][5].paina();
        ruudukko[6][4].paina();
        ruudukko[5][4].paina();

        ArrayList<Ruutu> viereiset1 = etsija.etsiVierekkaisetRuudut(ruudukko[5][5]);

        assertEquals(1, viereiset1.size());
    }

    @Test
    public void onkoRuudutVierekkain() {
        assertTrue(etsija.onkoVierekkain(ruudukko[0][2], ruudukko[1][1]));
        assertTrue(etsija.onkoVierekkain(ruudukko[2][2], ruudukko[1][1]));
        assertTrue(etsija.onkoVierekkain(ruudukko[5][4], ruudukko[4][5]));
        assertTrue(etsija.onkoVierekkain(ruudukko[3][2], ruudukko[3][3]));
        assertFalse(etsija.onkoVierekkain(ruudukko[3][2], ruudukko[3][4]));
        assertFalse(etsija.onkoVierekkain(ruudukko[0][0], ruudukko[5][4]));
        assertFalse(etsija.onkoVierekkain(ruudukko[0][0], ruudukko[3][0]));
        assertFalse(etsija.onkoVierekkain(ruudukko[5][5], ruudukko[3][3]));
    }
}
