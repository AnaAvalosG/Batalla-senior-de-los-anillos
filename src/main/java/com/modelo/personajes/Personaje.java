package com.modelo.personajes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Personaje {

	private String nombre;
	private int puntosDeVida;
	private int armadura;
	
	
	public int tirarDado() {
        // Por defecto no hace nada
        return 0;
    }
}
