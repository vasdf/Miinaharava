
package fi.miinaharava.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
/**
 * Luokka päivittää kellon numeroa sekunnin välein.
 * 
 */
public class KellonPaivittaja implements ActionListener {
    private JLabel kello;
    /**
     * Luodaan kellonpäivittäjä.
     * 
     * @param kello JLabel jossa aika halutaan näyttää
     */
    public KellonPaivittaja(JLabel kello) {
        this.kello = kello;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(kello.getText())+1;
        kello.setText("" + a);
    }
    
}
