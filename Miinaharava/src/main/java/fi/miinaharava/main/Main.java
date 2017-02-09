
package fi.miinaharava.main;

import fi.miinaharava.kayttoliittyma.Kayttoliittyma;
import fi.miinaharava.logiikka.Kentta;

public class Main {

    public static void main(String[] args) {
        Kentta kentta = new Kentta(10, 10);
        
        Kayttoliittyma k = new Kayttoliittyma(kentta);
        
        k.run();
    }
    
}
