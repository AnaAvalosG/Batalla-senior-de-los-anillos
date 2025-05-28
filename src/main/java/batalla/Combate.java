package batalla;

import personajes.Personaje;
import personajes.bestias.Orco;
import personajes.bestias.Trasgos;
import personajes.heroes.Elfo;
import personajes.heroes.Hobbits;

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
