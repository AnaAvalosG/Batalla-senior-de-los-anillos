package com.modelo.personajes.heroes;

import com.modelo.personajes.Personaje;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase abstracta que representa a los Heroes. Extiende la clase
 * {@link Personaje} e implementa una logica personalizada para el ataque
 * mediante la sobrescritura del metodo {@code tirarDado()}.
 * 
 * Los heroes lanzan dos dados (valores aleatorios entre 0 y 100) y eligen el
 * mayor, lo que les da una ventaja ofensiva frente a las bestias.
 * 
 * Esta clase debe ser extendida por clases concretas como {@link Humanos},
 * {@link Elfo} y {@link Hobbits}.
 * 
 * @author Ana Avalos
 */
@AllArgsConstructor
@Getter
@Setter
@ToString

public abstract class Heroes extends Personaje {

	/**
	 * Constructor que inicializa un heroe con nombre, puntos de vida y armadura.
	 * 
	 * @param nombre       Nombre del héroe.
	 * @param puntosDeVida Puntos de vida del héroe.
	 * @param armadura     Valor de armadura del héroe.
	 */
	public Heroes(String nombre, int puntosDeVida, int armadura) {
		super(nombre, puntosDeVida, armadura);
	}

	/**
	 * Simula el lanzamiento de dos dados (0-100) y devuelve el mayor valor. Esto
	 * otorga una ventaja en combate a los heroes.
	 * 
	 * @return El valor mas alto de los dos dados simulados.
	 */
	public int tirarDado() {

		int dado1 = (int) (Math.random() * 101);
		int dado2 = (int) (Math.random() * 101);

		return Math.max(dado1, dado2);
	}

}
