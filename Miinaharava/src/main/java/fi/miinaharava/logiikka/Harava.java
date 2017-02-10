package fi.miinaharava.logiikka;

public class Harava {

    private Ruutu[][] kentta;

    public Harava(Ruutu[][] kentta) {
        this.kentta = kentta;
    }
    /**
     * Metodi asettaa Ruutu olion boolean muuttujan haravointu todeksi
     * 
     * @param ruutu haravoitava ruutu
     */
    public void haravoiRuutu(Ruutu ruutu) {
        ruutu.haravoi();

        haravoiRuudutYmparilta(ruutu);
    }
    
    /**
     * Metodi haravoi kaikki ruudut annetun ruudun ympäriltä
     * eli asettaa boolean muuttujan haravoitu todeksi.
     * 
     * @param ruutu ympäriltä haravoitava ruutu
     */
    public void haravoiRuudutYmparilta(Ruutu ruutu) {
        for (int y = 0; y < kentta.length; y++) {
            for (int x = 0; x < kentta.length; x++) {
                if (onkoLahekkain(ruutu, kentta[y][x]) && ruutu != kentta[y][x]) {
                    if (ruutu.getArvo() == 0 && kentta[y][x].onkoHaravoitu() == false) {
                        haravoiRuutu(kentta[y][x]);
                    } else if (kentta[y][x].getArvo() == 0 && kentta[y][x].onkoHaravoitu() == false) {
                        haravoiRuutu(kentta[y][x]);
                    }
                }
            }
        }
    }
    
    /**
     * Metodi kertoo onko ruudut vierekkain eli koskevatko reunat/kulmat.
     * 
     * @param ruutu1, toinen verrattavista ruuduista
     * @param ruutu2, toinen verrattavista ruuduista
     * @return boolean onko annetut ruudut vierekkäin
     */
    public boolean onkoLahekkain(Ruutu ruutu1, Ruutu ruutu2) {
        return Math.abs(ruutu1.getX() - ruutu2.getX()) <= 1 && Math.abs(ruutu1.getY() - ruutu2.getY()) <= 1;
    }
}
