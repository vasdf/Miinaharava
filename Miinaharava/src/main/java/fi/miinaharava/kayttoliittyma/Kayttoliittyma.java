package fi.miinaharava.kayttoliittyma;

import fi.miinaharava.logiikka.Kentta;
import fi.miinaharava.logiikka.Painike;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Kentta kentta;
    private List<Painike> painikkeet;

    public Kayttoliittyma(Kentta kentta) {
        this.kentta = kentta;
        painikkeet = new ArrayList<>();
    }

    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(10, 10));

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                JButton painike = new JButton("" + x + "," + y);
                Painike painikee = new Painike(painike, x, y, kentta.getRuutu(x, y).getArvo());

                painikkeet.add(painikee);
            }
        }

        for (Painike painike : painikkeet) {
            TapahtumaKuuntelija kuuntelija = new TapahtumaKuuntelija(kentta.getRuutu(painike.getX(), painike.getY()), painike, kentta);
            kuuntelija.asetaPainikeLista(painikkeet);

            painike.getPainike().addActionListener(kuuntelija);

            container.add(painike.getPainike());
        }

    }

}
