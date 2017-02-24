package fi.miinaharava.main;

import fi.miinaharava.logiikka.Kentta;
import fi.miinaharava.logiikka.PelinHallinta;

public class Main {

    public static void main(String[] args) {
        
        Kentta kentta = new Kentta(16, 35);
        
        PelinHallinta ph = new PelinHallinta(kentta);
        
        ph.aloitaPeli();
    }

}
