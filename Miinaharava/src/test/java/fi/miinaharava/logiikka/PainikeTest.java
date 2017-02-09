
package fi.miinaharava.logiikka;

import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PainikeTest {
    private Painike painike;
    private JButton nappi;
    public PainikeTest() {
        this.nappi = new JButton();
        this.painike = new Painike(nappi, 2, 4, 3);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void painikkeenPalautusToimii() {
        assertEquals(nappi,painike.getPainike());
    }
    
    @Test
    public void getteritToimivat() {
        assertEquals(2,painike.getX());
        assertEquals(4,painike.getY());
        assertEquals(3,painike.getArvo());
    }
    
    @Test
    public void panikkeenPainaminenToimii() {
        painike.paina();
        assertFalse(nappi.isEnabled());
    }
}
