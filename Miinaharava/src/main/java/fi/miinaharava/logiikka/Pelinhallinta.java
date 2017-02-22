package fi.miinaharava.logiikka;

import fi.miinaharava.kayttoliittyma.Kayttoliittyma;

public class Pelinhallinta {

    private static Kentta kentta;
    private static Kayttoliittyma kayttoliittyma;

    public Pelinhallinta(Kentta kentta) {
        this.kentta = kentta;
    }
    
    public void aloitaPeli() {
        kayttoliittyma = new Kayttoliittyma(kentta);
        
        kayttoliittyma.run();
    }
    
    public static void uusiPeli(int sivunpituus, int miinojenmaara) {
        kentta = new Kentta(sivunpituus, miinojenmaara);
        
        kayttoliittyma.uusiPeli(kentta);
    }
}
