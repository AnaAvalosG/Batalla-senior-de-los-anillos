package com.test.modelo.personajes.heroes;

import com.modelo.personajes.heroes.Humanos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HumanosTest {

    @Test
    void testValoresInicialesHumano() {
        Humanos humano = new Humanos("Aragorn", 150, 60);
        assertEquals("Aragorn", humano.getNombre());
        assertEquals(150, humano.getPuntosDeVida());
        assertEquals(60, humano.getArmadura());
    }

    @Test
    void testTirarDadoHumano() {
        Humanos humano = new Humanos("Aragorn", 150, 60);
        for (int i = 0; i < 100; i++) {
            int resultado = humano.tirarDado();
            assertTrue(resultado >= 0 && resultado <= 100);
        }
    }
}

