package fi.miinaharava.kayttoliittyma;

import fi.miinaharava.logiikka.Kentta;
import fi.miinaharava.logiikka.Ruutu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Luokka kuuntelee Ruutujen painalluksia.
 * 
 */
public class TapahtumaKuuntelija implements ActionListener {

    private Ruutu ruutu;
    private Kentta kentta;
    
    /**
     * Konstruktorissa luodaan kuuntelija.
     * 
     * @param ruutu Kuuntelijaan littyvä ruutu
     * @param kentta Kentta, johon ruutu kuuluu
     */
    public TapahtumaKuuntelija(Ruutu ruutu, Kentta kentta) {
        this.ruutu = ruutu;
        this.kentta = kentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kentta.paina(ruutu);
    }
}
