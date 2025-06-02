package com.test.modelo.batalla;

import static org.junit.jupiter.api.Assertions.*;

import com.modelo.batalla.Batalla;
import com.modelo.personajes.bestias.Bestias;
import com.modelo.personajes.bestias.Orco;
import com.modelo.personajes.heroes.Heroes;
import com.modelo.personajes.heroes.Humanos;
import com.utilidades.SalidaBatalla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BatallaTest {

    private List<Heroes> ejercitoHeroes;
    private List<Bestias> ejercitoBestias;
    private StringBuilder salidaSimulada;
    private SalidaBatalla salida;

    @BeforeEach
    void setUp() {
        ejercitoHeroes = new ArrayList<>();
        ejercitoBestias = new ArrayList<>();
        salidaSimulada = new StringBuilder();

        salida = linea -> salidaSimulada.append(linea).append("\n");
    }

    @Test
    void batallaDebeTerminarConVictoriaDeLosHeroes() {
        ejercitoHeroes.add(new Humanos("Aragorn", 100, 10)); // Heroe fuerte
        ejercitoBestias.add(new Orco("Orco1", 10, 5));        // Bestia débil

        Batalla batalla = new Batalla(ejercitoHeroes, ejercitoBestias, salida);
        batalla.iniciar();

        String resultado = salidaSimulada.toString();
        assertTrue(resultado.contains("La victoria pertenece a los heroes!"));
    }

    @Test
    void batallaDebeTerminarConVictoriaDeLasBestias() {
        ejercitoHeroes.add(new Humanos("HéroeDébil", 10, 5)); // Heroe débil
        ejercitoBestias.add(new Orco("OrcoFuerte", 100, 10)); // Bestia fuerte

        Batalla batalla = new Batalla(ejercitoHeroes, ejercitoBestias, salida);
        batalla.iniciar();

        String resultado = salidaSimulada.toString();
        assertTrue(resultado.contains("¡No!, las bestias lograron la victoria"));
    }
}

