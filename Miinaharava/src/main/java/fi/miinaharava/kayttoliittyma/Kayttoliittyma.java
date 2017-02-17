package fi.miinaharava.kayttoliittyma;

import fi.miinaharava.logiikka.Kentta;
import fi.miinaharava.logiikka.Ruutu;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.plaf.FontUIResource;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Kentta kentta;
    private Ruutu[][] ruudukko;
    private int sivunpituus;
    
    public Kayttoliittyma(Kentta kentta) {
        this.kentta = kentta;
        this.ruudukko = kentta.getKentta();
        this.sivunpituus = ruudukko.length;
    }

    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(sivunpituus, sivunpituus));
        
        for (int y = 0; y < sivunpituus; y++) {
            for (int x = 0; x < sivunpituus; x++) {
                TapahtumaKuuntelija kuuntelija = new TapahtumaKuuntelija(ruudukko[y][x], kentta);
                
                ruudukko[y][x].getPainike().addActionListener(kuuntelija);
                
                container.add(ruudukko[y][x].getPainike());
            }
        }
    }

}
