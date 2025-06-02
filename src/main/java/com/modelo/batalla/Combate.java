package com.modelo.batalla;

import com.modelo.personajes.Personaje;
import com.modelo.personajes.bestias.Orco;
import com.modelo.personajes.bestias.Trasgos;
import com.modelo.personajes.heroes.Elfo;
import com.modelo.personajes.heroes.Hobbits;

/**
 * Clase utilitaria encargada de calcular el daño causado por un personaje a
 * otro durante el combate. Aplica reglas especiales según el tipo de personaje
 * involucrado.
 * 
 * Reglas especiales: - Elfos hacen +10 de daño a Orcos. - Hobbits hacen -5 de
 * daño a Trasgos. - Orcos reducen la armadura del enemigo en un 10%.
 * 
 * @author Ana Avalos
 */
public class Combate {

	/**
	 * Método estático que calcula el daño infligido por un atacante a un atacado
	 * según sus atributos y reglas especiales.
	 *
	 * @param atacante El personaje que ataca.
	 * @param atacado  El personaje que recibe el ataque.
	 * @return La cantidad de daño causado (nunca negativa).
	 */
	public static int daño(Personaje atacante, Personaje atacado) {
		int ataque = atacante.tirarDado();// Ataque inicial basado en el dado

		// Ventajas/desventajas por tipo
		if (atacante instanceof Elfo && atacado instanceof Orco) {
			ataque += 10; // Elfo tiene ventaja sobre Orco

		} else if (atacante instanceof Hobbits && atacado instanceof Trasgos) {
			ataque -= 5; // Hobbit tiene desventaja contra Trasgo
		}

		int armaduraAtacado = atacado.getArmadura();

		// Orcos reducen la armadura del objetivo
		if (atacante instanceof Orco) {
			armaduraAtacado *= 0.9;
		}
		// Se asegura que el daño no sea negativo
		int calcularDanio = Math.max(ataque - armaduraAtacado, 0);

		return calcularDanio;

	}
}
