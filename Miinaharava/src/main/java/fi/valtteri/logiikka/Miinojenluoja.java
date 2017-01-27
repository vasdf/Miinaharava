package fi.valtteri.logiikka;

import java.util.Random;

public class Miinojenluoja {

    private int sivunpituus;
    private int miinoja;
    private Random random;

    //poista mahdollisesti miinojenmaara muuttuja
    public Miinojenluoja(int kentansivunpituus, int miinojenmaara) {
        sivunpituus = kentansivunpituus;
        miinoja = miinojenmaara;
        random = new Random();
    }

    public Miina luoMiinaSatunnaisestiJaPalautaSe() {
        int x = random.nextInt(sivunpituus);
        int y = random.nextInt(sivunpituus);

        Miina miina = new Miina(x, y);

        return miina;
    }

    public int getSivunPituus() {
        return sivunpituus;
    }

    public int getMiinojenmaara() {
        return miinoja;
    }

    public void setSivunPituus(int luku) {
        sivunpituus = luku;
    }

    public void setMiinojenMaara(int luku) {
        miinoja = luku;
    }
}
