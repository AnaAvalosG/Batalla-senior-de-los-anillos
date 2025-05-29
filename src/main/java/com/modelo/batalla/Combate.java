package com.modelo.batalla;

import com.modelo.personajes.Personaje;
import com.modelo.personajes.bestias.Orco;
import com.modelo.personajes.bestias.Trasgos;
import com.modelo.personajes.heroes.Elfo;
import com.modelo.personajes.heroes.Hobbits;

public class Combate {

	public static int daño(Personaje atacante, Personaje atacado) {
		int ataque =atacante.tirarDado();
		
		
		if(atacante instanceof Elfo && atacado instanceof Orco) {
			ataque += 10;
			
		}else if(atacante instanceof Hobbits && atacado instanceof  Trasgos) {
			ataque -= 5;
		}
		
		int armaduraAtacado = atacado.getArmadura();
		
		if(atacante instanceof Orco) {
			armaduraAtacado  *= 0.9;
					}
		
		int calcularDanio =Math.max(ataque - armaduraAtacado, 0);
		
		 
		return calcularDanio;
		
	}
}
