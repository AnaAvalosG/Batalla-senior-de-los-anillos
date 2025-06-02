package com.modelo.personajes.heroes;

/**
 * Clase que representa a un Hobbit dentro del ejercito de los héroes. Esta
 * clase hereda de {@link Heroes} y se utiliza para inicializar personajes
 * hobbits con sus caracteristicas basicas como nombre, puntos de vida y
 * armadura.
 * 
 * En el sistema de combate, los hobbits tienen desventaja frente a ciertos
 * enemigos, por ejemplo, hacen menos daño a los trasgos, como se especifica en
 * la clase {@code Combate}.
 * 
 * Es utilizada para crear y diferenciar personajes hobbits en la batalla.
 * 
 * @author Ana Avalos
 */
public class Hobbits extends Heroes {

	/**
	 * Constructor que crea un nuevo hobbit con los atributos indicados.
	 * 
	 * @param nombre       Nombre del hobbit.
	 * @param puntosDeVida Puntos de vida del hobbit.
	 * @param armadura     Valor de armadura del hobbit.
	 */
	public Hobbits(String nombre, int puntosDeVida, int armadura) {
		super(nombre, puntosDeVida, armadura);
	}
}
