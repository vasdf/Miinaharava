package fi.miinaharava.logiikka;

public class Ruutu {

    private int x;
    private int y;
    private int arvo; //kertoo miinojen maaran ymparilla
    private boolean miina;
    private boolean haravoitu;

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        this.arvo = 0;
        this.miina = false;
        this.haravoitu = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void haravoi() {
        haravoitu = true;
    }

    public boolean onkoHaravoitu() {
        return haravoitu;
    }

    public void asetaMiina() {
        miina = true;
    }

    public boolean onkoMiina() {
        return miina;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public int getArvo() {
        return arvo;
    }
}
