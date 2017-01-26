
package fi.valtteri.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaTest {
    
    Miina miina;
    
    public MiinaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        miina = new Miina(2,4);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void sijaintiOikein() {
        assertEquals(2,miina.getX());
        
        assertEquals(4,miina.getY());
    }
}
