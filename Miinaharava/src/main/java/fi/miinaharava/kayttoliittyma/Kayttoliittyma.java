package fi.miinaharava.kayttoliittyma;

import fi.miinaharava.logiikka.Kentta;
import fi.miinaharava.logiikka.Ruutu;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Luokka luo kayttoliittyman.
 *
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Kentta kentta;
    private Ruutu[][] ruudukko;
    private int sivunpituus;
    private Container c;

    /**
     * Konstruktorissa luodaa olio.
     *
     * @param kentta Kentta, jota vastaava kayttoliittyma halutaan luoda
     */
    public Kayttoliittyma(Kentta kentta) {
        this.kentta = kentta;
        this.ruudukko = kentta.getKentta();
        this.sivunpituus = ruudukko.length;
        this.c = new Container();
    }

    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        c = luoKomponentit(c);

        frame.setContentPane(c);

        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Metodi luo tarvittavat komponentit
     * 
     * @param container JFramen container
     * @return  palauttaa muunnetun containerin
     */
    private Container luoKomponentit(Container container) {

        container.setLayout(new BorderLayout(0, 0));

        JPanel kenttapaneli = new JPanel(new GridLayout(sivunpituus, sivunpituus));

        for (int y = 0; y < sivunpituus; y++) {
            for (int x = 0; x < sivunpituus; x++) {
                TapahtumaKuuntelija kuuntelija = new TapahtumaKuuntelija(ruudukko[y][x], kentta);

                ruudukko[y][x].getPainike().addActionListener(kuuntelija);

                kenttapaneli.add(ruudukko[y][x].getPainike());
            }
        }

        container.add(kenttapaneli, BorderLayout.CENTER);

        JPanel asetukset = new JPanel(new FlowLayout());

        JLabel sivunpituusteksti = new JLabel("Sivunpituus:");
        asetukset.add(sivunpituusteksti);

        JTextField koko = new JTextField("", 3);
        asetukset.add(koko);

        JLabel miinojenmaarateksti = new JLabel("Miinojen määrä:");
        asetukset.add(miinojenmaarateksti);

        JTextField miinoja = new JTextField("", 3);
        asetukset.add(miinoja);

        JButton uudelleenaloitus = new JButton("Uusi peli");

        UusiPeliPainikkeenKuuntelija kuuntelija2 = new UusiPeliPainikkeenKuuntelija(koko, miinoja);
        uudelleenaloitus.addActionListener(kuuntelija2);

        asetukset.add(uudelleenaloitus);

        container.add(asetukset, BorderLayout.SOUTH);

        return container;
    }
    /**
     * Metodia tarvitaan uudenpelin luomisessa.
     * 
     * @param kentta Uusikentta, jota vastaava kayttoliittyma halutaan luoda
     */
    public void uusiPeli(Kentta kentta) {
        this.kentta = kentta;
        this.ruudukko = kentta.getKentta();
        this.sivunpituus = ruudukko.length;

        c.removeAll();

        c = luoKomponentit(c);

        frame.setContentPane(c);

        frame.revalidate();

    }

}
