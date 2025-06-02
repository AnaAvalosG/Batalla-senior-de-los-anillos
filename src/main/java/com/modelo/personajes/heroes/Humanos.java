package com.modelo.personajes.heroes;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Humanos extends Heroes {

	 public Humanos(String nombre, int puntosDeVida, int armadura) {
	        super(nombre, puntosDeVida, armadura);
	    }
}
