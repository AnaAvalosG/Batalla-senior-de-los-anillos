package com.modelo.personajes.heroes;

import lombok.AllArgsConstructor;

/**
 * Clase que representa a un Humano dentro del ejercito de los heroes. Esta
 * clase extiende {@link Heroes} y modela a los personajes humanos. Los humanos
 * tienen valores personalizados de vida y armadura, y participan en la batalla
 * de acuerdo a la logica de combate implementada en {@code Combate}.
 * 
 * No poseen ventajas ni desventajas especiales en el sistema actual.
 * 
 * @author Ana Avalos
 */
@AllArgsConstructor
public class Humanos extends Heroes {

	/**
	 * Constructor que inicializa un humano con nombre, puntos de vida y armadura.
	 * 
	 * @param nombre       Nombre del humano.
	 * @param puntosDeVida Puntos de vida del humano.
	 * @param armadura     Valor de armadura del humano.
	 */
	public Humanos(String nombre, int puntosDeVida, int armadura) {
		super(nombre, puntosDeVida, armadura);
	}
}
