package com.modelo.personajes.bestias;

/**
 * Clase concreta que representa a un Trasgo en el ejercito de las bestias. Esta
 * clase hereda de {@link Bestias} y permite la creacion de instancias concretas
 * de trasgos, las cuales se utilizarán en la batalla. Aunque no contiene logica
 * adicional, su comportamiento especial (por ejemplo, reciben menos daño si el
 * atacante es un Hobbit) esta definido en la clase {@code Combate}.
 * 
 * @author Ana Avalos
 */
public class Trasgos extends Bestias {

	/**
	 * Constructor que inicializa un trasgo con sus atributos.
	 *
	 * @param nombre       Nombre del trasgo.
	 * @param puntosDeVida Puntos de vida del trasgo.
	 * @param armadura     Nivel de armadura del trasgo.
	 */
	public Trasgos(String nombre, int puntosDeVida, int armadura) {
		super(nombre, puntosDeVida, armadura);
	}
}
