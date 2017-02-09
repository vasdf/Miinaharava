package fi.miinaharava.kayttoliittyma;

import fi.miinaharava.logiikka.Kentta;
import fi.miinaharava.logiikka.Painike;
import fi.miinaharava.logiikka.Ruutu;
import fi.miinaharava.logiikka.VierekkaistenRuutujenEtsija;
import fi.miinaharava.logiikka.VierekkaistenRuutujenPainaja;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class TapahtumaKuuntelija implements ActionListener {

    private List<Painike> painikkeet;
    private Ruutu ruutu;
    private Painike painike;
    private VierekkaistenRuutujenEtsija vierekkaistenruutujenetsija;
    private VierekkaistenRuutujenPainaja vierekkaistenruutujenpainaja;
    private Kentta kentta;

    //*siirrä logiikka metodit muuaalle*
    public TapahtumaKuuntelija(Ruutu ruutu, Painike painike, Kentta kentta) {
        this.ruutu = ruutu;
        this.painike = painike;;
        this.kentta = kentta;
    }

    public void asetaPainikeLista(List<Painike> painikkeet) {
        this.painikkeet = painikkeet;
        this.vierekkaistenruutujenetsija = new VierekkaistenRuutujenEtsija(painikkeet);
        this.vierekkaistenruutujenpainaja = new VierekkaistenRuutujenPainaja(vierekkaistenruutujenetsija);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (ruutu.onkoMiina() == true) {
            painike.getPainike().setText("M");
        } else {
            painike.getPainike().setText("" + ruutu.getArvo());
        }
        painike.getPainike().setEnabled(false);

        ArrayList<Painike> viereiset = vierekkaistenruutujenetsija.etsiVierekkaisetPainikkeet(painike);

        ArrayList<Painike> tyhjatpainikkeet = vierekkaistenruutujenpainaja.palautaTyhjatPainikkeet(viereiset);

        vierekkaistenruutujenpainaja.painaVierekkaisiaTyhjiaPainikkeita(tyhjatpainikkeet);
    }
}
