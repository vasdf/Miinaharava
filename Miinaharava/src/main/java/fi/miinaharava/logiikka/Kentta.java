package fi.miinaharava.logiikka;

import java.awt.Insets;
import javax.swing.JButton;

/**
 * Luokka luo Ruutu olioista koostuvan taulun eli pelikentän
 */
public class Kentta {

    private Ruutu[][] ruudukko;
    private int sivunpituus;
    private int miinojenmaara;
    private Miinojenluoja miinojenluoja;
    private Ruudunarvonlaskija ruudunarvonlaskija;

    public Kentta(int sivunpituus, int miinojenmaara) {
        this.sivunpituus = sivunpituus;
        this.miinojenmaara = miinojenmaara;
        this.ruudukko = new Ruutu[sivunpituus][sivunpituus];

        luoKentta();

        miinojenluoja = new Miinojenluoja(sivunpituus, miinojenmaara);
        ruudukko = miinojenluoja.luoMiinatSatunnaisesti(ruudukko);

        ruudunarvonlaskija = new Ruudunarvonlaskija();
        ruudukko = ruudunarvonlaskija.laskeArvot(ruudukko);
    }
    
    /**
     * Metodi luo Ruutu olioita sisältävään taulukkoon Ruutu olioit
     */
    private void luoKentta() {
        for (int y = 0; y < sivunpituus; y++) {
            for (int x = 0; x < sivunpituus; x++) {
                Ruutu ruutu = new Ruutu(x, y);
                
                JButton painike = new JButton();
                painike.setMargin(new Insets(0, 0, 0, 0));
                
                ruutu.setPainike(painike);
                
                ruudukko[y][x] = ruutu;
            }
        }
    }

    public Ruutu getRuutu(int x, int y) {
        return ruudukko[y][x];
    }

    public Ruutu[][] getKentta() {
        return ruudukko;
    }

    public Miinojenluoja getMiinojenluoja() {
        return miinojenluoja;
    }

}
