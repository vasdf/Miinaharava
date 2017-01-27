
package fi.valtteri.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumeroruutuTest {
    Numeroruutu numeroruutu;
    
    public NumeroruutuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        numeroruutu = new Numeroruutu(2, 3);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void sijaintiOikein() {
        assertEquals(2,numeroruutu.getX());
        assertEquals(3,numeroruutu.getY());
    }
    
    @Test
    public void arvoAsetetaabOikein() {
        numeroruutu.setArvo(4);
        
        assertEquals(4,numeroruutu.getArvo());
    }
}
