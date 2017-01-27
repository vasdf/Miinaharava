
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
    Miina miina3;
    Miina miina4;
    Miina miina5;
    
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
        
        miina1 = new Miina(1,3);
        miina2 = new Miina(2,3);
        miina3 = new Miina(1,1);
        miina4 = new Miina(3,2);
        miina5 = new Miina(2,4);
        
        miinalista.lisaaMiina(miina1);
        miinalista.lisaaMiina(miina2);
        miinalista.lisaaMiina(miina3);
        miinalista.lisaaMiina(miina4);
        miinalista.lisaaMiina(miina5);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void miinojaLisataanListaanOikeaMaara() {
        assertEquals(5,miinalista.getMiinalista().size());
    }
    
    @Test
    public void samaaMiinaaEiVoiLisataUudestaan() {
        miinalista.lisaaMiina(miina1);
        miinalista.lisaaMiina(miina2);
        
        assertEquals(5,miinalista.getMiinalista().size());
    }
    
    @Test
    public void halututMiinatLisataanListaan() {
        assertEquals(miina1,miinalista.getMiinalista().get(0));
        
        assertEquals(miina2,miinalista.getMiinalista().get(1));
    }
    
    @Test
    public void onkoMiinatLahekkainTesti() {
        assertTrue(miinalista.onkoLahekkain(2, 2, miina1));
        assertTrue(miinalista.onkoLahekkain(2 , 2, miina2));
        assertTrue(miinalista.onkoLahekkain(2 , 2, miina3));
        assertTrue(miinalista.onkoLahekkain(2, 2, miina4));
        assertFalse(miinalista.onkoLahekkain(2, 2, miina5));
    }
    
    @Test
    public void oikeaMaaraLahellaOleviaMiinoja() {
        assertEquals(4, miinalista.montakoMiinaaYmparilla(2, 2));
        
        assertEquals(3, miinalista.montakoMiinaaYmparilla(3, 3));
    }
}
