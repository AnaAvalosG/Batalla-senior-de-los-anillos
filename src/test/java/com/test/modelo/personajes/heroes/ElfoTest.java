package com.test.modelo.personajes.heroes;

import com.modelo.personajes.heroes.Elfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElfoTest {

    @Test
    void testValoresInicialesElfo() {
        Elfo elfo = new Elfo("Fingolfin", 120, 40);
        assertEquals("Fingolfin", elfo.getNombre());
        assertEquals(120, elfo.getPuntosDeVida());
        assertEquals(40, elfo.getArmadura());
    }

    @Test
    void testTirarDadoElfo() {
        Elfo elfo = new Elfo("Fingolfin", 120, 40);
        for (int i = 0; i < 100; i++) {
            int resultado = elfo.tirarDado();
            assertTrue(resultado >= 0 && resultado <= 100);
        }
    }
}
