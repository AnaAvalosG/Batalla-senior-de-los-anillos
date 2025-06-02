package com.controlador;

import java.util.ArrayList;
import java.util.List;

import com.modelo.batalla.Batalla;
import com.modelo.personajes.bestias.Bestias;
import com.modelo.personajes.bestias.Orco;
import com.modelo.personajes.bestias.Trasgos;
import com.modelo.personajes.heroes.Elfo;
import com.modelo.personajes.heroes.Heroes;
import com.modelo.personajes.heroes.Hobbits;
import com.modelo.personajes.heroes.Humanos;
import com.utilidades.SalidaBatalla;

/**
 * Clase controladora principal que inicializa y gestiona el juego "El Señor de
 * los Anillos". Se encarga de crear los ejércitos de héroes y bestias, y de
 * iniciar la batalla entre ellos.
 * 
 * @author Ana Avalos
 */
public class JuegoElSenorDeLosAnillos {

	private List<Heroes> ejercitoHeroes;
	private List<Bestias> ejercitoBestias;

	/**
	 * Constructor que inicializa los ejércitos con personajes predeterminados.
	 */
	public JuegoElSenorDeLosAnillos() {
		ejercitoHeroes = new ArrayList<>();
		ejercitoBestias = new ArrayList<>();
		crearEjercitos();
	}

	/**
	 * Método privado que crea y carga los personajes de ambos ejércitos. Se añaden
	 * varios héroes y bestias al inicio del juego.
	 */
	private void crearEjercitos() {
		// Heroes
		ejercitoHeroes.add(new Humanos("Aragorn", 100, 70));
		ejercitoHeroes.add(new Humanos("Boromir", 300, 40));
		ejercitoHeroes.add(new Elfo("Fingolfin", 120, 50));
		ejercitoHeroes.add(new Elfo("Légolas", 200, 60));
		ejercitoHeroes.add(new Hobbits("Frodo", 100, 20));
		ejercitoHeroes.add(new Hobbits("Sam", 180, 80));

		// Bestias
		ejercitoBestias.add(new Orco("Lurtz", 200, 60));
		ejercitoBestias.add(new Orco("Shagrat", 220, 70));
		ejercitoBestias.add(new Orco("Sauron", 180, 30));
		ejercitoBestias.add(new Trasgos("Uglúk", 300, 40));
		ejercitoBestias.add(new Trasgos("Mauhúr", 100, 50));
	}

	/**
	 * Inicia la batalla utilizando el motor de combate y una salida proporcionada.
	 * 
	 * @param salida Interfaz para imprimir resultados (puede ser consola o Swing).
	 */
	public void iniciarBatalla(SalidaBatalla salida) {
		Batalla batalla = new Batalla(ejercitoHeroes, ejercitoBestias, salida);
		batalla.iniciar();
	}

}
