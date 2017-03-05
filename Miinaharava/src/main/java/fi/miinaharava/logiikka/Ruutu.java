package fi.miinaharava.logiikka;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;

/**
 * Luokkaa tarvitaan pelikentän, eli taulun, joka koostuu Ruutu olioista,
 * luomiseen.
 */
public class Ruutu {

    private JButton painike;
    private int x;
    private int y;
    private int arvo;
    private boolean miina;

    /**
     * Konstruktori luo Ruutu olion halutuilla arvoilla.
     *
     * @param x Kentän kertoma x-koordinaatti
     * @param y Kentän kertoma y-koordinaatti
     */
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        this.arvo = 0;
        this.miina = false;
    }

    public JButton getPainike() {
        return painike;
    }

    public void setPainike(JButton painike) {
        this.painike = painike;
    }

    /**
     * Metodi asettaa JButton painikkeen tekstin halutuksi riippuen onko
     * kyseessä miina vai ei ja poistaa sen käytöstä.
     */
    public void paina() {       
        if (miina == true) {
            painike.setText("*");
            painike.setFont(new Font("", Font.PLAIN, 30));
            painike.setMargin(new Insets(12, 0, 0, 0));
            painike.setBackground(Color.red);
            
        } else if (arvo == 0) {
            painike.setText("");
            
        } else {
            painike.setText("" + arvo);
            painike.setMargin(new Insets(0, 0, 0, 0));
            painike.setFont(new Font("", Font.PLAIN, 20));
        }

        painike.setEnabled(false);
    }

    /**
     * Metodi asettaa boolean muuttuja miina todeksi. Muuttujan avulla tiedetään
     * onko kyseinen ruutu miina vai ei.
     */
    public void asetaMiina() {
        arvo = -1;
        miina = true;
    }

    /**
     * Metodi kertoo onko kyseessä miina vai ei.
     *
     * @return boolean onko miina
     */
    public boolean onkoMiina() {
        return miina;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public int getArvo() {
        return arvo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
