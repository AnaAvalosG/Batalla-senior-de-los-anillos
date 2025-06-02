package com.modelo.personajes.bestias;

import com.modelo.personajes.Personaje;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase abstracta que representa a las criaturas del ejercito de las bestias.
 * Extiende la clase {@link Personaje} e implementa el comportamiento del metodo
 * tirarDado(). Esta clase está destinada a ser heredada por clases concretas
 * como {@code Orco} y {@code Trasgos}.
 * 
 * Uso de anotaciones de Lombok: - {@code @Getter, @Setter}: generan
 * automáticamente metodos getter y setter. - {@code @ToString}: genera
 * automáticamente el metodo toString().
 * 
 * Comportamiento: - El metodo {@code tirarDado()} retorna un valor aleatorio
 * entre 0 y 90, representando el ataque de una bestia.
 * 
 * @author Ana Avalos
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class Bestias extends Personaje {

	/**
	 * Constructor que inicializa los atributos heredados del personaje.
	 *
	 * @param nombre       Nombre de la bestia.
	 * @param puntosDeVida Vida inicial de la bestia.
	 * @param armadura     Nivel de defensa de la bestia.
	 */
	public Bestias(String nombre, int puntosDeVida, int armadura) {
		super(nombre, puntosDeVida, armadura);
	}

	/**
	 * Devuelve el valor de ataque de la bestia mediante un numero aleatorio entre 0
	 * y 90 (inclusive).
	 *
	 * @return Valor de ataque aleatorio.
	 */
	public int tirarDado() {
		return (int) (Math.random() * 91);
	}

}
