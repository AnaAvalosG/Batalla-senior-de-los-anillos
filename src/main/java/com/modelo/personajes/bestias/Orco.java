package com.modelo.personajes.bestias;

/**
 * Clase que representa a un Orco dentro del ejercito de las bestias. Hereda de
 * {@link Bestias} y utiliza el constructor de su clase padre para inicializar
 * sus atributos.
 * 
 * Los orcos tienen un comportamiento especial en combate definido en la clase
 * {@code Combate}, donde reducen la armadura del oponente en un 10%. Esta clase
 * no agrega comportamiento adicional, pero permite instanciar orcos
 * específicos.
 * 
 * @author Ana Avalos
 */
public class Orco extends Bestias {

	/**
	 * Constructor que inicializa un orco con sus atributos principales.
	 *
	 * @param nombre       Nombre del orco.
	 * @param puntosDeVida Puntos de vida del orco.
	 * @param armadura     Nivel de armadura del orco.
	 */
	public Orco(String nombre, int puntosDeVida, int armadura) {
		super(nombre, puntosDeVida, armadura);
	}
}
