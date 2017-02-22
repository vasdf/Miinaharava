package fi.miinaharava.kayttoliittyma;

import fi.miinaharava.logiikka.Kentta;
import fi.miinaharava.logiikka.Pelinhallinta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class UusiPeliPainikkeenKuuntelija implements ActionListener {

    private JTextField sivunpituus;
    private JTextField miinojenmaara;

    public UusiPeliPainikkeenKuuntelija(JTextField sivunpituus, JTextField miinojenmaara) {
        this.sivunpituus = sivunpituus;
        this.miinojenmaara = miinojenmaara;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!sivunpituus.getText().isEmpty() && !miinojenmaara.getText().isEmpty()) {
            
            if (tarkistaOnkoNumero(sivunpituus.getText()) && tarkistaOnkoNumero(miinojenmaara.getText())) {
                int a = Integer.parseInt(sivunpituus.getText());
                int b = Integer.parseInt(miinojenmaara.getText());
                
                if ( b > a*a) {
                    b = a*a;
                }
                
                Pelinhallinta.uusiPeli(a,b);
            }   
        }
    }
    
    /**
     * Metodi varmistaa että annetut sivunpituus ja miinojemäärä ovat numeroita
     * 
     * @param merkkijono    Annettu syöte
     * @return kertoo onko merkkijono numero vai ei
     */
    private boolean tarkistaOnkoNumero(String merkkijono) {
        for (char c : merkkijono.toCharArray()) {
            if (!"1234567890".contains("" + c)) {
                return false;
            }
        }
        
        return true;
    }
}
