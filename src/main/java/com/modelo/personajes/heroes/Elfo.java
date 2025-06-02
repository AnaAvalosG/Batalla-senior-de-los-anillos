package com.modelo.personajes.heroes;

/**
 * Clase que representa a un Elfo dentro del ejercito de los heroes. Esta clase
 * hereda de {@link Heroes} y permite crear personajes de tipo Elfo con sus
 * atributos caracteristicos (nombre, puntos de vida y armadura).
 * 
 * En el sistema de combate, los elfos tienen ventaja frente a ciertos enemigos,
 * por ejemplo, hacen mas daño a los orcos, como esta definido en la clase
 * {@code Combate}.
 * 
 * Es utilizada para identificar personajes elficos en la simulación de batalla.
 * 
 * @author Ana Avalos
 */
public class Elfo extends Heroes {

	/**
	 * Constructor que inicializa un elfo con los valores proporcionados.
	 * 
	 * @param nombre       Nombre del elfo.
	 * @param puntosDeVida Puntos de vida del elfo.
	 * @param armadura     Nivel de armadura del elfo.
	 */
	public Elfo(String nombre, int puntosDeVida, int armadura) {
		super(nombre, puntosDeVida, armadura);
	}

}
