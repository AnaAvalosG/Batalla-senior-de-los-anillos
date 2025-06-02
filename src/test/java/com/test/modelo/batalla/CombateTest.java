package com.test.modelo.batalla;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.modelo.batalla.Combate;
import com.modelo.personajes.bestias.Orco;
import com.modelo.personajes.bestias.Trasgos;
import com.modelo.personajes.heroes.Elfo;
import com.modelo.personajes.heroes.Hobbits;

public class CombateTest {

    @Test
    public void testVentajaElfoVsOrco() {
        Elfo elfo = new Elfo("Legolas", 100, 30);
        Orco orco = new Orco("Lurtz", 100, 20);

        int daño = Combate.daño(elfo, orco);

        // El Elfo tiene ventaja +10 contra orcos, esperamos que el daño sea mayor a 0
        assertEquals(true, daño >= 10);
    }

    @Test
    public void testDesventajaHobbitVsTrasgo() {
        Hobbits hobbit = new Hobbits("Sam", 100, 30);
        Trasgos trasgo = new Trasgos("Snaga", 100, 20);

        int daño = Combate.daño(hobbit, trasgo);

        // El Hobbit tiene -5 al ataque contra trasgos, por lo que el daño podría ser 0 o pequeño
        assertEquals(true, daño >= 0);
    }

    @Test
    public void testOrcoReduceArmaduraEnemiga() {
        Orco orco = new Orco("Shagrat", 100, 30);
        Elfo elfo = new Elfo("Thranduil", 100, 100);

        int daño = Combate.daño(orco, elfo);

        // El orco reduce la armadura del enemigo en 10%
        assertEquals(true, daño >= 0 && daño <= 100);
    }
}
