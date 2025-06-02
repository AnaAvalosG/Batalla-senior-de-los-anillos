package com.test.modelo.personajes.heroes;

import com.modelo.personajes.heroes.Hobbits;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HobbitsTest {

    @Test
    void testValoresInicialesHobbit() {
        Hobbits hobbit = new Hobbits("Frodo", 100, 20);
        assertEquals("Frodo", hobbit.getNombre());
        assertEquals(100, hobbit.getPuntosDeVida());
        assertEquals(20, hobbit.getArmadura());
    }

    @Test
    void testTirarDadoHobbit() {
        Hobbits hobbit = new Hobbits("Frodo", 100, 20);
        for (int i = 0; i < 100; i++) {
            int resultado = hobbit.tirarDado();
            assertTrue(resultado >= 0 && resultado <= 100);
        }
    }
}
