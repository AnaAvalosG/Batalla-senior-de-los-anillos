package com.modelo.batalla;

import java.util.List;

import com.modelo.personajes.Personaje;
import com.modelo.personajes.bestias.Bestias;
import com.modelo.personajes.heroes.Heroes;
import com.utilidades.SalidaBatalla;

/**
 * Clase que gestiona la lógica del combate entre los ejércitos de héroes y
 * bestias. Utiliza una salida inyectada para mostrar los resultados (consola o
 * GUI).
 * 
 * @author Ana Avalos
 */
public class Batalla {

	private List<Heroes> ejercitoHeroes;
	private List<Bestias> ejercitoBestias;
	private SalidaBatalla salida;

	private int turno;

	/**
	 * Constructor que inicializa los ejércitos y la salida de resultados.
	 *
	 * @param ejercitoHeroes  Lista de héroes que lucharán.
	 * @param ejercitoBestias Lista de bestias que lucharán.
	 * @param salida          Interfaz de salida para imprimir resultados (por
	 *                        consola o por GUI).
	 */
	public Batalla(List<Heroes> ejercitoHeroes, List<Bestias> ejercitoBestias, SalidaBatalla salida) {
		this.ejercitoHeroes = ejercitoHeroes;
		this.ejercitoBestias = ejercitoBestias;
		this.salida = salida;
		this.turno = 1;
	}

	/**
	 * Método que inicia la simulación de la batalla por rondas. Los personajes se
	 * enfrentan de forma emparejada y se aplica la lógica de combate.
	 */
	public void iniciar() {
		while (!ejercitoHeroes.isEmpty() && !ejercitoBestias.isEmpty()) {
			salida.imprimir("Ronda " + turno++);

			int turnoEmparejado = Math.min(ejercitoHeroes.size(), ejercitoBestias.size());

			for (int i = 0; i < turnoEmparejado; i++) {
				Personaje heroe = (Personaje) ejercitoHeroes.get(i);
				Personaje bestia = (Personaje) ejercitoBestias.get(i);

				// Ataque del heroe a la bestia
				int danioHeroe = Combate.daño(heroe, bestia);
				bestia.setPuntosDeVida(bestia.getPuntosDeVida() - danioHeroe);
				salida.imprimir(
						heroe.getNombre() + " ataco a " + bestia.getNombre() + " causando " + danioHeroe + " de daño");

				if (bestia.getPuntosDeVida() <= 0) {
					// System.out.println(bestia.getNombre()+" ah muerto ⚔");
					salida.imprimir(bestia.getNombre() + " ah muerto 😥");
					ejercitoBestias.remove(i);
					turnoEmparejado--;
					i--;
					continue;
				}

				// Ataque de la bestia al heroe
				int danioBestia = Combate.daño(bestia, heroe);
				heroe.setPuntosDeVida(heroe.getPuntosDeVida() - danioBestia);
				salida.imprimir(
						bestia.getNombre() + " ataco a " + heroe.getNombre() + " causando " + danioBestia + " de daño");

				if (heroe.getPuntosDeVida() <= 0) {
					// System.out.println(heroe.getNombre()+" ah muerto 😥");
					salida.imprimir(heroe.getNombre() + " ah muerto 😥");

					ejercitoHeroes.remove(i);
					turnoEmparejado--;
					i--;
					continue;
				}

				// Estado parcial despues de cada ataque
				salida.imprimir("Estado de los contincantes:");
				salida.imprimir("Heroe: " + heroe.getNombre() + " → vida=" + heroe.getPuntosDeVida());
				salida.imprimir("Bestia:" + bestia.getNombre() + " → vida=" + bestia.getPuntosDeVida());

			}

		}

		// Resultado final de la batalla
		if (ejercitoHeroes.isEmpty()) {
			salida.imprimir("¡No!, las bestias lograron la victoria... ");
		} else if (ejercitoBestias.isEmpty()) {
			salida.imprimir("La victoria pertenece a los heroes!");
		}
	}
}
