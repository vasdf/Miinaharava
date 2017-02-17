package fi.miinaharava.logiikka;

/**
 * Luokka laskee jokaiselle Ruutuja sisältävän taulukon ruudulle arvon,
 * joka kertoo montakko miinaa on ympärillä.
 */
public class Ruudunarvonlaskija {

    private Ruutu[][] ruudukko;
    
    public Ruudunarvonlaskija() {
    }

    /**
     * Metodi laskee parametrina annetun ruuduista koostuvan taulun jokaiselle
     * ruudulle arvon, joka kertoo montako miinaa on kyseisen ruudun ympärillä.
     *
     * @param ruudukko  Ruudukko, jonka ruuduille arvot halutaan laskea
     * 
     * @return taulukko, jonka ruuduille arvot on lasekttu
     */
    public Ruutu[][] laskeArvot(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;

        for (int y = 0; y < ruudukko.length; y++) {
            for (int x = 0; x < ruudukko.length; x++) {
                laskeArvo(ruudukko[y][x]);
            }
        }

        return ruudukko;
    }

    /**
     * Metodi laskee arvon parametrina annetulle yksittäiselle ruudulle.
     *
     * @param ruutu Ruutu, jolle halutaan laskea arvo
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
        if (ruutu.onkoMiina() == true) {
            ruutu.setArvo(-1);
        } else {
            ruutu.setArvo(arvo);
        }
    }

    /**
     * Metodi kertoo ovatko parametrina annetun ruudut lähekkäin eli
     * koskevatko ne toisiaan sivuista/kulmista
     *
     * @param ruutu1    toinen ruuduista
     * @param ruutu2    toinen ruuduista
     * 
     * @return boolean ovatko ruudut lahekkain
     */
    public boolean onkoLahekkain(Ruutu ruutu1, Ruutu ruutu2) {
        return Math.abs(ruutu1.getX() - ruutu2.getX()) <= 1 && Math.abs(ruutu1.getY() - ruutu2.getY()) <= 1;
    }

}
