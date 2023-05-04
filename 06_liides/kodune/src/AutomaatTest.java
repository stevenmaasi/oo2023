import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AutomaatTest {

    @Test
    public void kontrolli_swedbanki_kuumakse_arvutust() {
        Swedbank swedbank = new Swedbank(2.2, 36);
        Laen laen = new Laen(100, 10);
        assertEquals(14.7, swedbank.arvutaKuumakse(laen), 0.0);
    }

    @Test
    public void kontrolli_swedbanki_intressi_summa_arvutust() {
        Swedbank swedbank = new Swedbank(2.2, 36);
        Laen laen = new Laen(100, 10);
        assertEquals(47.0, swedbank.arvutaIntressiSumma(laen), 0.0);
    }

    @Test
    public void kontrolli_lhv_kuumakse_arvutust() {
        Lhv lhv = new Lhv(1.2, 20);
        Laen laen = new Laen(1000, 20);
        assertEquals(63.25, lhv.arvutaKuumakse(laen), 0.0);
    }

    @Test
    public void kontrolli_lhv_intressi_summa_arvutust() {
        Lhv lhv = new Lhv(1.2, 20);
        Laen laen = new Laen(1000, 20);
        assertEquals(265.0, lhv.arvutaIntressiSumma(laen), 0.0);
    }

    @Test
    public void kontrolli_tfbanki_kuumakse_arvutust() throws Exception {
        TfBank tfBank = new TfBank(0, 12);
        Laen laen = new Laen(600, 3);
        assertEquals(200.0, tfBank.arvutaKuumakse(laen), 0.0);
    }

    @Test
    public void kontrolli_tfbanki_intressi_summa_arvutust() throws Exception {
        TfBank tfBank = new TfBank(0, 12);
        Laen laen = new Laen(600, 3);
        assertEquals(0.0, tfBank.arvutaIntressiSumma(laen), 0.0);
    }

    @Test
    public void kontrolli_tfbanki_kuumakse_arvutust_veaga() {
        TfBank tfBank = new TfBank(0, 12);
        Laen laen = new Laen(600, 15);

        try {
            tfBank.arvutaKuumakse(laen);
        } catch (Exception error) {
            assertEquals(new Exception("Laenuperiood yle maksimumi"), error);
        }
    }
}