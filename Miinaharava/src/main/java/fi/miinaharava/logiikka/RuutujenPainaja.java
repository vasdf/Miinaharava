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
        
        if (ruutu.getArvo() == 0 && ruutu.onkoMiina() == false) {
            painaKaikkiaYmparillaOlevia(ruutu);
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
}
