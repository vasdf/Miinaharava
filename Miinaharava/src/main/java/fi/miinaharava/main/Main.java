package fi.miinaharava.main;

import fi.miinaharava.logiikka.Kentta;
import fi.miinaharava.logiikka.Pelinhallinta;

public class Main {

    public static void main(String[] args) {
        
        Kentta kentta = new Kentta(20, 20);
        
        Pelinhallinta ph = new Pelinhallinta(kentta);
        
        ph.aloitaPeli();
    }

}
