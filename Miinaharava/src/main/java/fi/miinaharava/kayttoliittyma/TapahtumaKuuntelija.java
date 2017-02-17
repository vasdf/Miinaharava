package fi.miinaharava.kayttoliittyma;

import fi.miinaharava.logiikka.Kentta;
import fi.miinaharava.logiikka.Ruutu;
import fi.miinaharava.logiikka.VierekkaistenRuutujenPainaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TapahtumaKuuntelija implements ActionListener {

    private Ruutu ruutu;
    private VierekkaistenRuutujenPainaja painaja;
    private Kentta kentta;

    //*siirrä logiikka metodit muuaalle*
    public TapahtumaKuuntelija(Ruutu ruutu, Kentta kentta) {
        this.ruutu = ruutu;
        this.kentta = kentta;
        this.painaja = new VierekkaistenRuutujenPainaja(kentta.getKentta());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        painaja.paina(ruutu);
    }
}
