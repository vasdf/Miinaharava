package fi.miinaharava.logiikka;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class VierekkaistenRuutujenEtsija {

    private List<Painike> painikkeet;

    public VierekkaistenRuutujenEtsija() {

    }

    public VierekkaistenRuutujenEtsija(List<Painike> painikkeet) {
        this.painikkeet = painikkeet;
    }

    public ArrayList<Painike> etsiVierekkaisetPainikkeet(Painike painike) {
        ArrayList<Painike> vierekkaiset = new ArrayList<>();

        for (int y = 0; y < sqrt(painikkeet.size()); y++) {
            for (int x = 0; x < sqrt(painikkeet.size()); x++) {
                Painike painike2 = haePainike(x, y);

                if (onkoVierekkain(painike, painike2)) {
                    vierekkaiset.add(painike2);
                }
            }
        }

        return vierekkaiset;
    }

    public Painike haePainike(int x, int y) {
        for (Painike painike : painikkeet) {
            if (painike.getX() == x && painike.getY() == y) {
                return painike;
            }
        }

        return null;
    }

    public boolean onkoVierekkain(Painike painike1, Painike painike2) {
        return Math.abs(painike1.getX() - painike2.getX()) <= 1 && Math.abs(painike1.getY() - painike2.getY()) <= 1;
    }
}
