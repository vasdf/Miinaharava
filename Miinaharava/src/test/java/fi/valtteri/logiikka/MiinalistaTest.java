
package fi.valtteri.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinalistaTest {
    
    Miinalista miinalista;
    Miina miina1;
    Miina miina2;
    
    public MiinalistaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        miinalista = new Miinalista();
        miina1 = new Miina(2,4);
        miina2 = new Miina(3,4);
        miinalista.lisaaMiina(miina1);
        miinalista.lisaaMiina(miina2);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void miinojaLisataanListaanOikeaMaara() {
        assertEquals(2,miinalista.getMiinalista().size());
    }
    
    @Test
    public void halututMiinatLisataanListaan() {
        assertEquals(miina1,miinalista.getMiinalista().get(0));
        
        assertEquals(miina2,miinalista.getMiinalista().get(1));
    }
}
