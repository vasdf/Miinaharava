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
    /**
     * Konstruktorissa kerrotaan miinojenluojalle tarvitut arvot.
     * 
     * @param sivunpituus   Kentän antama sivunpituus
     * 
     * @param miinojenmaara Kentän antama miinojenmäärä
     */
    public Miinojenluoja(int sivunpituus, int miinojenmaara) {
        this.sivunpituus = sivunpituus;
        this.miinojenmaara = miinojenmaara;;
        this.random = new Random();
    }
    /**
     * Metodi muuttaa parametrinä saamansa
     * Ruutu olioita sisältävän taulun Ruutuja miinoiksi
     * eli asettaa Ruutu olion boolean arvon miina todeksi
     * 
     * Ruutuja muutetaan konstruktorissa annettu miinojemaara.
     * 
     * @param ruudukko  Kentta luokan luoma ruudukko
     * 
     * @return taulukko, jossa Ruutuja on muunnettu miinoiksi haluttu määrä
     * 
     * @see Ruutu#asetaMiina() 
     */
    public Ruutu[][] luoMiinatSatunnaisesti(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;
        
        int miinojaluotu = 0;

        while (miinojaluotu < miinojenmaara) {
            int x = random.nextInt(sivunpituus);
            int y = random.nextInt(sivunpituus);

            if (ruudukko[y][x].onkoMiina() == false) {
                ruudukko[y][x].asetaMiina();
                
                miinojaluotu++;
            }
        }

        return ruudukko;
    }
}
