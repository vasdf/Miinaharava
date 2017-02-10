package fi.miinaharava.logiikka;

import java.util.Random;
/**
 * Luokka luo valmiiksi luotuun Ruutu olioita sisältävään taulukkoon
 * miinat eli muuttaa Ruutu olion boolean arvon miina todeksi.
 */
public class Miinojenluoja {

    private int sivunpituus;
    private int miinojenmaara;
    private Random random;
    private Ruutu[][] ruudukko;

    public Miinojenluoja(int sivunpituus, int miinojenmaara, Ruutu[][] kentta) {
        this.sivunpituus = sivunpituus;
        this.miinojenmaara = miinojenmaara;
        this.ruudukko = kentta;
        this.random = new Random();
    }
    /**
     * Metodi muuttaa konstruktorissa saamansa
     * Ruutu olioita sisältävän taulun Ruutuja miinoiksi.
     * 
     * Ruutuja muutetaan konstruktorissa annettu miinojemaara.
     * 
     * @return taulukko, jossa Ruutuja on muunnettu miinoiksi
     */
    public Ruutu[][] luoMiinatSatunnaisesti() {
        int miinojaluotu = 0;

        while (miinojaluotu < miinojenmaara) {
            int x = random.nextInt(sivunpituus);
            int y = random.nextInt(sivunpituus);

            if (ruudukko[y][x].onkoMiina() == false) {
                ruudukko[y][x].asetaMiina();
                miinojaluotu++;

                kasvataYmparillaOlevienRuutujenArvoja(ruudukko[y][x]);
            }
        }

        return ruudukko;
    }
    /**
     * Metodi kasvattaa ruudun, joka muunnettiin miinaksi ympärillä
     * olevien ruutujen arvoja yhdellä. Ruudun arvo kertoo ympärillä olevien
     * miinojen määrän.
     * 
     *
     * @param ruutu, joka muunnettiin miinaksi.
     */
    public void kasvataYmparillaOlevienRuutujenArvoja(Ruutu ruutu) {
        for (int y = 0; y < sivunpituus; y++) {
            for (int x = 0; x < sivunpituus; x++) {
                if (onkoLahekkain(ruutu, ruudukko[y][x]) && ruutu != ruudukko[y][x]) {
                    ruudukko[y][x].setArvo(+1);
                }
            }
        }
    }
    /**
     * Metodi kertoo onko ruudut vierekkain eli koskevatko reunat/kulmat.
     * 
     * @param ruutu1, toinen verrattavista ruuduista
     * @param ruutu2, toinen verrattavista ruuduista
     * @return boolean onko annetut ruudut vierekkäin
     */
    public boolean onkoLahekkain(Ruutu ruutu1, Ruutu ruutu2) {
        return Math.abs(ruutu1.getX() - ruutu2.getX()) <= 1 && Math.abs(ruutu1.getY() - ruutu2.getY()) <= 1;
    }
}
