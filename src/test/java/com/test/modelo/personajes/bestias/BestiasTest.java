package com.test.modelo.personajes.bestias;

import com.modelo.personajes.bestias.Bestias;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BestiasTest {

    static class DummyBestia extends Bestias {
        public DummyBestia(String nombre, int vida, int armadura) {
            super(nombre, vida, armadura);
        }
    }

    @Test
    void testValoresIniciales() {
        DummyBestia bestia = new DummyBestia("Dummy", 120, 40);

        assertEquals("Dummy", bestia.getNombre());
        assertEquals(120, bestia.getPuntosDeVida());
        assertEquals(40, bestia.getArmadura());
    }

    @Test
    void testTirarDadoRango() {
        DummyBestia bestia = new DummyBestia("Dummy", 120, 40);

        for (int i = 0; i < 100; i++) {
            int resultado = bestia.tirarDado();
            assertTrue(resultado >= 0 && resultado <= 90, "Resultado fuera de rango: " + resultado);
        }
    }
}

