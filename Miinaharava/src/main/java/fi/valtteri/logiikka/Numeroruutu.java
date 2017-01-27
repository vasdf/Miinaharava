
package fi.valtteri.logiikka;

public class Numeroruutu {
    private int x;
    private int y;
    private int arvo;
    
    public Numeroruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    } 
    
    public void setArvo(int arvo) {
        this.arvo = arvo;
    }
    
    public int getArvo() {
        return arvo;
    }
}
