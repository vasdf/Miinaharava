package fi.miinaharava.logiikka;

import fi.miinaharava.kayttoliittyma.Kayttoliittyma;

/**
 * Luokan avulla aloitetaan uusipeli.
 *
 * (Luokalle ei ole testejä, koska luokka ei tee mitään erikoista)
 */
public class PelinHallinta {

    private static Kentta kentta;
    private static Kayttoliittyma kayttoliittyma;

    /**
     * Luo luokan ja antaa sille aloitus kentän.
     *
     * @param kentta Kenttä millä aloitetaan
     */
    public PelinHallinta(Kentta kentta) {
        this.kentta = kentta;
    }

    /**
     * Metodi luo käyttöliittymän ja aloittaa pelin.
     * 
     * @see Kayttoliittyma#run() 
     */
    public void aloitaPeli() {
        kayttoliittyma = new Kayttoliittyma(kentta);

        kayttoliittyma.run();
    }

    /**
     * Metodi aloittaa uudenpelin tietyillä arvoilla.
     *
     * @param sivunpituus Käyttäjän haluama sivunpituus
     * @param miinojenmaara Käyttäjän haluama miinojen määrä
     * 
     * @see Kayttoliittyma#uusiPeli(fi.miinaharava.logiikka.Kentta) 
     */
    public static void uusiPeli(int sivunpituus, int miinojenmaara) {
        kentta = new Kentta(sivunpituus, miinojenmaara);

        kayttoliittyma.uusiPeli(kentta);
    }

    /**
     * Metodi kertoo kayttoliittymalle häviöstä.
     * 
     * null tarkistus on RuutujenPainajaTest luokkaa varten
     * 
     * @see Kayttoliittyma#havisit() 
     */
    public static void havisit() {
        if (kayttoliittyma != null) {
            kayttoliittyma.havisit();
        }
    }

    /**
     * Metodi kertoo kayttoliittymalle voitosta.
     * 
     * null tarkistus on RuutujenPainajaTest luokkaa varten
     * 
     * @see Kayttoliittyma#voitit() 
     */
    public static void voitit() {
        if (kayttoliittyma != null) {
            kayttoliittyma.voitit();
        }
    }
}
