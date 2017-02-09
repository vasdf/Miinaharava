package fi.miinaharava.logiikka;

public class Ruudunarvonlaskija {

    private Ruutu[][] ruudukko;

    public Ruudunarvonlaskija(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;
    }

    public void laskeArvot(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;

        for (int y = 0; y < ruudukko.length; y++) {
            for (int x = 0; x < ruudukko.length; x++) {
                laskeArvo(ruudukko[y][x]);
            }
        }
    }

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

    public boolean onkoLahekkain(Ruutu ruutu1, Ruutu ruutu2) {
        return Math.abs(ruutu1.getX() - ruutu2.getX()) <= 1 && Math.abs(ruutu1.getY() - ruutu2.getY()) <= 1;
    }

}
