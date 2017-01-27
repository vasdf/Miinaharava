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
        if (!miinat.contains(miina)) {
            miinat.add(miina);
        }
    }

    public int montakoMiinaaYmparilla(int x, int y) {
        int miinojaYmparilla = 0;

        for (Miina miina2 : miinat) {
            if (onkoLahekkain(x, y, miina2)) {
                miinojaYmparilla++;
            }
        }

        return miinojaYmparilla;
    }

    public boolean onkoLahekkain(int x, int y, Miina miina2) {
        return Math.abs(x - miina2.getX()) <= 1 && Math.abs(y - miina2.getY()) <= 1;
    }
}
