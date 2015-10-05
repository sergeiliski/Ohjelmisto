package Test;

import MockEsimerkki.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TilaustenKasittelyFakeTest {

    @Test
    public void testaaKasittelijaWithFakeHinnoittelija1() {
        float alkuSaldo = 100.0f;
        float listaHinta = 300.0f;
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));

        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        Hinnoittelija hinnoittelija = new FakeHinnoittelija(alennus);

        TilaustenKäsittely kasittelija = new TilaustenKäsittely();
        kasittelija.setHinnoittelija(hinnoittelija);
        kasittelija.käsittele(new Tilaus(asiakas, tuote));

        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
    }
}
