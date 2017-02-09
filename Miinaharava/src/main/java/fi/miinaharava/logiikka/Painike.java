
package fi.miinaharava.logiikka;

import javax.swing.JButton;

public class Painike {
    private JButton painike;
    private int x;
    private int y;
    private int arvo;
    
    public Painike(JButton painike, int x, int y, int arvo) {
        this.painike = painike;
        this.x = x;
        this.y = y;
        this.arvo = arvo;
    }
    
    public JButton getPainike() {
        return painike;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getArvo() {
        return arvo;
    }
    
    public void paina() {
        painike.setEnabled(false);
    }
}
