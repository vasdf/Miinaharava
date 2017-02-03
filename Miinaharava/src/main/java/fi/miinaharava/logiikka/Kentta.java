package fi.miinaharava.logiikka;

public class Kentta {
    
    private Ruutu[][] ruudukko;
    private int sivunpituus;//ei tarvitse välttämättä
    private int miinojenmaara;//ei tarvitse välttämättä
    private Miinojenluoja miinojenluoja;
    private Harava harava;

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
    }
    
    public void Haravoi(Ruutu ruutu) {
        harava.haravoiRuutu(ruutu);;
    }
    
    public Ruutu[][] getKentta() {
        return ruudukko;
    }
    
    public Miinojenluoja getMiinojenluoja() {
        return miinojenluoja;
    }

}
