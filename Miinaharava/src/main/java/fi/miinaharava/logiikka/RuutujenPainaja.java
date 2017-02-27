package fi.miinaharava.logiikka;

import java.util.ArrayList;
/**
 * Luokka hallinnoi ruutujen painamista.
 * 
 */
public class RuutujenPainaja {

    private RuutujenEtsija etsija;
    private Ruutu[][] ruudukko;
    
    /**
     * Konstruktori luo olion ja ottaa muistiin annetun taulukon
     * sekä luo etsijän.
     * 
     * @param ruudukko  Kentän antama taulukko, jonka Ruutu olioita käsitellään
     */
    public RuutujenPainaja(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;
        this.etsija = new RuutujenEtsija(ruudukko);
    }
    
    /**
     * Metodi painaa yhtä ruutua ja jos ruudun arvo on 0 
     * eli ympärillä ei ole yhtään miinaa niin kutsuu
     * seuraavaa metodia.
     * 
     * @param ruutu Ruutu, jota halutaan painaa
     */
    public void paina(Ruutu ruutu) {
        ruutu.paina();
        
        if (ruutu.onkoMiina()) {
            painaKaikkia();
            PelinHallinta.havisit();
        }
        
        if (ruutu.getArvo() == 0) {
            painaKaikkiaYmparillaOlevia(ruutu);
        }
        
        if (onkoKaikkiaEiMiinojaPainettu()) {
            painaKaikkia();
            PelinHallinta.voitit();
        }
    }
    
    /**
     * Metodi painaa parametrina saadun ruudun vieressä olevia ruutuja ja jos
     * painettu ruutu on arvoltaan 0 niin kutsutaan samaa metodia uudestaan
     * painetulle ruudulle.
     * 
     * @param ruutu Ruutu, jonka ympärillä olevat ruudut halutaan painaa
     */
    public void painaKaikkiaYmparillaOlevia(Ruutu ruutu) {
        ArrayList<Ruutu> vierekkaiset = etsija.etsiVierekkaisetRuudut(ruutu);

        for (Ruutu ruutu2 : vierekkaiset) {
            
            ruutu2.paina();
            
            if (ruutu2.getArvo() == 0) {
                painaKaikkiaYmparillaOlevia(ruutu2);
            }

        }
    }
    /**
     * Metodi paljastaa peli kentän pelaaja osuessa miinaan.
     */
    public void painaKaikkia() {
        for (int y = 0; y < ruudukko.length; y++) {
            for (int x = 0; x < ruudukko.length; x++) {
                ruudukko[y][x].paina();
            }
        }
    }
    /**
     * Metodi tarkistaa onko kaikkia ei miinoja painettu.
     * Tarvitaan pelin voittamisen varmistamisessa
     * 
     * @return boolean onko peli voitettu
     */
    public boolean onkoKaikkiaEiMiinojaPainettu() {
        for (int y = 0; y < ruudukko.length; y++) {
            for (int x = 0; x < ruudukko.length; x++) {
                if (ruudukko[y][x].onkoMiina() == false) {
                    if (ruudukko[y][x].getPainike().isEnabled() == true) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
