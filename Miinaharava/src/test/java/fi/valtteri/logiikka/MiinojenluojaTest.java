package fi.valtteri.logiikka;

import fi.valtteri.logiikka.Miina;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiinojenluojaTest {

    Miinojenluoja miinojenluoja;

    public MiinojenluojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        miinojenluoja = new Miinojenluoja(10, 5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void miinojenLuotiToimii() {
        Miina miina1 = miinojenluoja.luoMiinaSatunnaisestiJaPalautaSe();
        assertEquals("class fi.valtteri.logiikka.Miina", miina1.getClass().toString());
    }

    @Test
    public void sivunPituudenVaihtoOnnistuu() {
        assertEquals(10, miinojenluoja.getSivunPituus());

        miinojenluoja.setSivunPituus(15);

        assertEquals(15, miinojenluoja.getSivunPituus());
    }
}
