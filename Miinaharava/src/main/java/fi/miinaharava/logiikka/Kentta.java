package fi.miinaharava.logiikka;

import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;

/**
 * Luokka luo Ruutu olioista koostuvan taulun eli pelikentän.
 */
public class Kentta {

    private Ruutu[][] ruudukko;
    private int sivunpituus;
    private int miinojenmaara;
    private Miinojenluoja miinojenluoja;
    private RuudunArvonlaskija ruudunarvonlaskija;
    private RuutujenPainaja painaja;

    /**
     * Konstruktorissa luodaan halutun lainen Ruuduista koostuva taulukko, joka
     * toimii kenttänä.
     *
     * @param sivunpituus Käyttäjän haluama sivunpituus
     *
     * @param miinojenmaara Käyttäjän haluama miinojenmäärä
     */
    public Kentta(int sivunpituus, int miinojenmaara) {
        this.sivunpituus = sivunpituus;
        this.miinojenmaara = miinojenmaara;
        this.ruudukko = new Ruutu[sivunpituus][sivunpituus];

        luoPelialusta();
    }
    
    /**
     * Metodi luo Ruutu olioille tehtyyn taulukkoon Ruutu olioit.
     */
    private void luoPelialusta() {
        for (int y = 0; y < sivunpituus; y++) {
            for (int x = 0; x < sivunpituus; x++) {
                Ruutu ruutu = new Ruutu(x, y);

                JButton painike = new JButton();
                
                ruutu.setPainike(painike);

                ruudukko[y][x] = ruutu;
            }
        }
        
        miinojenluoja = new Miinojenluoja(sivunpituus, miinojenmaara);
        ruudukko = miinojenluoja.luoMiinatSatunnaisesti(ruudukko);

        ruudunarvonlaskija = new RuudunArvonlaskija();
        ruudukko = ruudunarvonlaskija.laskeArvot(ruudukko);

        painaja = new RuutujenPainaja(ruudukko);
    }

    /**
     * Metodi kutsuu VierekkaisteRuutujenPainajan metodia paina.
     *
     * @param ruutu TapahtumaKuuntelijalta saatu Ruutu, jota painettiin
     */
    public void paina(Ruutu ruutu) {
        painaja.paina(ruutu);
    }

    public Ruutu[][] getKentta() {
        return ruudukko;
    }
    
    /**
     * Metodi on testejä varten.
     * 
     * @return palauttaa miinojeluojaolion
     */
    public Miinojenluoja getMiinojenluoja() {
        return miinojenluoja;
    }
}
