package fi.miinaharava.logiikka;

import fi.miinaharava.kayttoliittyma.Kayttoliittyma;

/**
 * Luokan avulla aloitetaan uusipeli.
 *
 * @author vavo
 */
public class Pelinhallinta {

    private static Kentta kentta;
    private static Kayttoliittyma kayttoliittyma;

    /**
     * Luo luokan ja antaa sille aloitus kentän.
     *
     * @param kentta Kenttä millä aloitetaan
     */
    public Pelinhallinta(Kentta kentta) {
        this.kentta = kentta;
    }

    /**
     * Metodi luo käyttöliittymän ja aloittaa pelin.
     */
    public void aloitaPeli() {
        kayttoliittyma = new Kayttoliittyma(kentta);

        kayttoliittyma.run();
    }

    /**
     * Metodi aloittaa uudenpelin tietyillä arvoilla.'
     * 
     * @param sivunpituus   Käyttäjän haluama sivunpituus
     * @param miinojenmaara Käyttäjän haluama miinojen määrä
     */
    public static void uusiPeli(int sivunpituus, int miinojenmaara) {
        kentta = new Kentta(sivunpituus, miinojenmaara);

        kayttoliittyma.uusiPeli(kentta);
    }
}
