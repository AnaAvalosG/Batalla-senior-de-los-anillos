package com.test.modelo.personajes.bestias;

import com.modelo.personajes.bestias.Orco;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrcoTest {

    @Test
    void testValoresInicialesOrco() {
        Orco orco = new Orco("Lurtz", 150, 60);

        assertEquals("Lurtz", orco.getNombre());
        assertEquals(150, orco.getPuntosDeVida());
        assertEquals(60, orco.getArmadura());
    }

    @Test
    void testTirarDadoOrco() {
        Orco orco = new Orco("Shagrat", 150, 60);

        for (int i = 0; i < 100; i++) {
            int resultado = orco.tirarDado();
            assertTrue(resultado >= 0 && resultado <= 90, "Resultado fuera de rango: " + resultado);
        }
    }
}
