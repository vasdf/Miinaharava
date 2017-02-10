package fi.miinaharava.logiikka;

import java.util.ArrayList;

//*ei valmis*
public class VierekkaistenRuutujenPainaja {

    private VierekkaistenRuutujenEtsija vierekkaistenruutujenetsija;
    private ArrayList<Painike> painetut;

    public VierekkaistenRuutujenPainaja(VierekkaistenRuutujenEtsija vierekkaistenruutujenetsija) {
        this.vierekkaistenruutujenetsija = vierekkaistenruutujenetsija;
        this.painetut = new ArrayList<>();
    }

    public void painaVierekkaisiaTyhjiaPainikkeita(ArrayList<Painike> tyhjatpainikkeet) {
        for (Painike painike2 : tyhjatpainikkeet) {

            painetut.add(painike2);
            painike2.getPainike().setText("" + painike2.getArvo());
            painike2.getPainike().setEnabled(false);

            ArrayList<Painike> viereiset = vierekkaistenruutujenetsija.etsiVierekkaisetPainikkeet(painike2);
            painaPainikkeet(viereiset);
        }
    }

    public void painaPainikkeet(ArrayList<Painike> painikkeet) {

        for (Painike painike2 : painikkeet) {
            painetut.add(painike2);
            painike2.getPainike().setText("" + painike2.getArvo());
            painike2.getPainike().setEnabled(false);
        }

        painaVierekkaisiaTyhjiaPainikkeita(poistaPainetutPainikkeet(palautaTyhjatPainikkeet(painikkeet)));
    }

    public ArrayList<Painike> palautaTyhjatPainikkeet(ArrayList<Painike> painikkeet) {
        ArrayList<Painike> palautus = new ArrayList<>();

        for (Painike painike2 : painikkeet) {
            if (painike2.getArvo() == 0) {
                palautus.add(painike2);
            }
        }

        return palautus;
    }

    public ArrayList<Painike> poistaPainetutPainikkeet(ArrayList<Painike> painikkeet) {
        ArrayList<Painike> palautus = painikkeet;

        for (Painike painike : painikkeet) {
            if (painetut.contains(painike)) {
                palautus.remove(painike);
            }
        }

        return palautus;
    }
}
