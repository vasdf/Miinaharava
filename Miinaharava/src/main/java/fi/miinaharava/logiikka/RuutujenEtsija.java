package fi.miinaharava.logiikka;

import java.util.ArrayList;

/**
 * Luokka auttaa Ruuduista koostuvan taulukon läpikäymisessä.
 */
public class RuutujenEtsija {

    private Ruutu[][] ruudukko;
    
    /**
     * Konstruktori luo olion.
     * 
     * @param ruudukko Ruudukko, josta ruutuja halutaan etsiä
     */
    public RuutujenEtsija(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;
    }
    

    /**
     * Metodi etsii Ruudun vieressä olevat ruudut.
     * HUOM: Ei palauta listassamiinoja tai jo painettuja ruutuja
     * eli ruutuja, joiden painikkeet ovat pois käytöstä.
     *
     * @param ruutu Ruutu, jonka viereiset ruudut halutaan etsiä
     *
     * @return Lista, joka sisältää viereiset ruudut
     */
    public ArrayList<Ruutu> etsiVierekkaisetRuudut(Ruutu ruutu) {
        ArrayList<Ruutu> vierekkaiset = new ArrayList<>();

        for (int y = 0; y < ruudukko.length; y++) {
            for (int x = 0; x < ruudukko.length; x++) {
                if (onkoVierekkain(ruutu, ruudukko[y][x]) && ruudukko[y][x].onkoMiina() == false && ruudukko[y][x].getPainike().isEnabled() == true) {
                    vierekkaiset.add(ruudukko[y][x]);
                }
            }
        }

        return vierekkaiset;
    }
    
    /**
     * Metodi kertoo ovatko ruudut 1 ja 2 vierekkäin
     * eli koskevatko niiden reunat/kulmat.
     * 
     * @param ruutu1    Toinen verrattavista ruuduista
     * @param ruutu2    Toinen verrattavista ruuduista
     * 
     * @return boolean onko ruuduit vierekkäin
     */
    public boolean onkoVierekkain(Ruutu ruutu1, Ruutu ruutu2) {
        return Math.abs(ruutu1.getX() - ruutu2.getX()) <= 1 && Math.abs(ruutu1.getY() - ruutu2.getY()) <= 1;
    }
}
