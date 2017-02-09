package fi.miinaharava.logiikka;

public class Kentta {

    private Ruutu[][] ruudukko;
    private int sivunpituus;
    private int miinojenmaara;
    private Miinojenluoja miinojenluoja;
    private Harava harava;
    private Ruudunarvonlaskija ruudunarvonlaskija;

    public Kentta(int sivunpituus, int miinojenmaara) {
        this.sivunpituus = sivunpituus;
        this.miinojenmaara = miinojenmaara;
        this.ruudukko = new Ruutu[sivunpituus][sivunpituus];
        this.harava = new Harava(ruudukko);

        for (int y = 0; y < sivunpituus; y++) {
            for (int x = 0; x < sivunpituus; x++) {
                Ruutu ruutu = new Ruutu(x, y);
                ruudukko[y][x] = ruutu;
            }
        }

        miinojenluoja = new Miinojenluoja(sivunpituus, miinojenmaara, ruudukko);
        ruudukko = miinojenluoja.luoMiinatSatunnaisesti();

        ruudunarvonlaskija = new Ruudunarvonlaskija(ruudukko);
    }

    public void haravoi(Ruutu ruutu) {
        harava.haravoiRuutu(ruutu);;
    }

    public Ruutu getRuutu(int x, int y) {
        return ruudukko[y][x];
    }

    public Ruutu[][] getKentta() {
        return ruudukko;
    }

    public Miinojenluoja getMiinojenluoja() {
        return miinojenluoja;
    }

}
