package personajes.heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import personajes.Personaje;

@AllArgsConstructor
@Getter
@Setter
@ToString

public abstract class Heroes extends Personaje{

	
	public int calcularAtaqueContra(Personaje enemigo) {
		
	int dado1=(int) (Math.random()*101);
	int dado2 =(int) (Math.random()*101);
	
	return Math.max(dado1, dado2);
	}


	public Heroes(String nombre, int puntosDeVida, int armadura) {
		
	}
	
}
