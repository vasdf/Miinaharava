
package fi.valtteri.logiikka;

import java.util.ArrayList;

public class Miinalista {
    private ArrayList<Miina> miinat;
    
    public Miinalista() {
        miinat = new ArrayList<>();
    }
    
    public ArrayList getMiinalista() {
        return miinat;
    }
    
    public void lisaaMiina(Miina miina) {
        miinat.add(miina);
    }
}
