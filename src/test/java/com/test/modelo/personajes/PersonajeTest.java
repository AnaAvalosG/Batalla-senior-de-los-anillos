package com.test.modelo.personajes;

import com.modelo.personajes.Personaje;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {

    // Creamos una subclase anónima concreta para poder testear Personaje
    static class DummyPersonaje extends Personaje {
        public DummyPersonaje(String nombre, int vida, int armadura) {
            super(nombre, vida, armadura);
        }

        @Override
        public int tirarDado() {
            return super.tirarDado(); // Esperamos 0 en clase base
        }
    }

    @Test
    void testValoresIniciales() {
        DummyPersonaje personaje = new DummyPersonaje("Test", 100, 50);

        assertEquals("Test", personaje.getNombre());
        assertEquals(100, personaje.getPuntosDeVida());
        assertEquals(50, personaje.getArmadura());
    }

    @Test
    void testSetters() {
        DummyPersonaje personaje = new DummyPersonaje("Test", 100, 50);

        personaje.setNombre("Nuevo");
        personaje.setPuntosDeVida(200);
        personaje.setArmadura(70);

        assertEquals("Nuevo", personaje.getNombre());
        assertEquals(200, personaje.getPuntosDeVida());
        assertEquals(70, personaje.getArmadura());
    }

    @Test
    void testTirarDadoBase() {
        DummyPersonaje personaje = new DummyPersonaje("Test", 100, 50);
        assertEquals(0, personaje.tirarDado(), "El método base debe devolver 0");
    }
}
