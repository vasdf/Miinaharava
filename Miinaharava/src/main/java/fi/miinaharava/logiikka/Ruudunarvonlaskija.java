package fi.miinaharava.logiikka;
/**
 * Luokka laskee jokaiselle annetun Ruutuja sisältävän taulukon ruudulle 
 * arvon, joka kertoo montakko miinaa on ympärillä.
 */
public class Ruudunarvonlaskija {

    private Ruutu[][] ruudukko;

    public Ruudunarvonlaskija(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;
    }
    
    /**
     * Metodi laskee parametrina annetun ruuduista koostuvan taulun
     * jokaiselle ruudulle arvon, joka kertoo montako miinaa on
     * kyseisen ruudun ympärillä.
     * 
     * @param ruudukko, jolle halutaan asettaa arvot 
     */
    public void laskeArvot(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;

        for (int y = 0; y < ruudukko.length; y++) {
            for (int x = 0; x < ruudukko.length; x++) {
                laskeArvo(ruudukko[y][x]);
            }
        }
    }

    /**
     * Metodi laskee arvon parametrina annetulle ruudulle.
     * 
     * @param ruutu , jolle arvo halutaan laskea
     */
    public void laskeArvo(Ruutu ruutu) {
        int arvo = 0;

        for (int y = 0; y < ruudukko.length; y++) {
            for (int x = 0; x < ruudukko.length; x++) {
                if (onkoLahekkain(ruutu, ruudukko[y][x]) && ruudukko[y][x].onkoMiina() == true) {
                    arvo++;
                }
            }
        }

        ruutu.setArvo(arvo);
    }
    /**
     * Metodi kertoo ovatko parametrina annetun ruudut lähekkäin.
     * 
     * @param ruutu1 , toinen ruuduista
     * @param ruutu2 , toinen ruuduista
     * @return boolean ovatko ruudut lahekkain
     */
    public boolean onkoLahekkain(Ruutu ruutu1, Ruutu ruutu2) {
        return Math.abs(ruutu1.getX() - ruutu2.getX()) <= 1 && Math.abs(ruutu1.getY() - ruutu2.getY()) <= 1;
    }

}
