package com.modelo.personajes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase abstracta que representa un personaje generico en el sistema de
 * batalla. Define atributos comunes y establece una estructura base para los
 * personajes.
 *
 * Esta clase utiliza anotaciones de Lombok para generar automáticamente: -
 * Getters y setters - Constructor por defecto - Constructor con todos los
 * argumentos - Metodos toString, equals y hashCode
 * 
 * Atributos: - nombre: Nombre del personaje. - puntosDeVida: Salud del
 * personaje, al llegar a 0 el personaje muere. - armadura: Valor defensivo que
 * reduce el daño recibido.
 * 
 * @author Ana Avalos
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Personaje {

	private String nombre;
	private int puntosDeVida;
	private int armadura;

	/**
	 * Metodo que simula el lanzamiento de un dado para calcular el ataque del
	 * personaje. Este metodo debera ser sobreescrito e implementado por las
	 * subclases.
	 *
	 * @return Valor base de ataque (por defecto 0).
	 */
	public int tirarDado() {
		return 0;
	}
}
