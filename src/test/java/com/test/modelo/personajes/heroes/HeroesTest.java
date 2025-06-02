package com.test.modelo.personajes.heroes;

import com.modelo.personajes.heroes.Heroes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroesTest {

    static class DummyHeroe extends Heroes {
        public DummyHeroe(String nombre, int vida, int armadura) {
            super(nombre, vida, armadura);
        }
    }

    @Test
    void testValoresIniciales() {
        DummyHeroe heroe = new DummyHeroe("Dummy", 200, 50);
        assertEquals("Dummy", heroe.getNombre());
        assertEquals(200, heroe.getPuntosDeVida());
        assertEquals(50, heroe.getArmadura());
    }

    @Test
    void testTirarDadoRango() {
        DummyHeroe heroe = new DummyHeroe("Dummy", 200, 50);
        for (int i = 0; i < 100; i++) {
            int resultado = heroe.tirarDado();
            assertTrue(resultado >= 0 && resultado <= 100, "Resultado fuera de rango: " + resultado);
        }
    }

    @Test
    void testTirarDadoMayorDeDos() {
        DummyHeroe heroe = new DummyHeroe("Dummy", 200, 50);
        boolean seDioElMaximo = false;

        for (int i = 0; i < 500; i++) {
            int resultado = heroe.tirarDado();
            if (resultado == 100) {
                seDioElMaximo = true;
                break;
            }
        }

        assertTrue(seDioElMaximo, "Esperaba que al menos una vez se tirara 100 como máximo de los dos dados.");
    }
}
