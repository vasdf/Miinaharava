package fi.miinaharava.kayttoliittyma;

import fi.miinaharava.logiikka.PelinHallinta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
/**
 * Luokka kuuntelee uusipelipainikketta.
 * 
 */
public class UusiPeliPainikkeenKuuntelija implements ActionListener {

    private JTextField sivunpituus;
    private JTextField miinojenmaara;
    /**
     * Konstruktorissa luodaan olio.
     * 
     * @param sivunpituus   Käyttäjän haluama sivunpituus
     * @param miinojenmaara Käyttäjän haluama miinojenmäärä
     */
    public UusiPeliPainikkeenKuuntelija(JTextField sivunpituus, JTextField miinojenmaara) {
        this.sivunpituus = sivunpituus;
        this.miinojenmaara = miinojenmaara;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!sivunpituus.getText().isEmpty() && !miinojenmaara.getText().isEmpty()) {

            if (tarkistaOnkoSallittu(sivunpituus.getText()) && tarkistaOnkoSallittu(miinojenmaara.getText())) {
                int a = Integer.parseInt(sivunpituus.getText());
                int b = Integer.parseInt(miinojenmaara.getText());
                
                if (a > 50) {
                    a = 50;
                }
                
                if (b > a * a) {
                    b = a * a;
                }
                if (a != 0) {
                    PelinHallinta.uusiPeli(a, b);
                }
            }
        }
    }

    /**
     * Metodi varmistaa että annetut sivunpituus ja miinojemäärä ovat sallittuja
     *
     * @param merkkijono Annettu syöte
     * @return kertoo onko merkkijono numero vai ei
     */
    private boolean tarkistaOnkoSallittu(String merkkijono) {
        for (char c : merkkijono.toCharArray()) {
            if (!"1234567890".contains("" + c)) {
                return false;
            }
        }

        return true;
    }
}
