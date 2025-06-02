package com.test.modelo.personajes.bestias;

import com.modelo.personajes.bestias.Trasgos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrasgosTest {

    @Test
    void testValoresInicialesTrasgo() {
        Trasgos trasgo = new Trasgos("Uglúk", 130, 45);

        assertEquals("Uglúk", trasgo.getNombre());
        assertEquals(130, trasgo.getPuntosDeVida());
        assertEquals(45, trasgo.getArmadura());
    }

    @Test
    void testTirarDadoTrasgo() {
        Trasgos trasgo = new Trasgos("Mauhúr", 130, 45);

        for (int i = 0; i < 100; i++) {
            int resultado = trasgo.tirarDado();
            assertTrue(resultado >= 0 && resultado <= 90, "Resultado fuera de rango: " + resultado);
        }
    }
}
