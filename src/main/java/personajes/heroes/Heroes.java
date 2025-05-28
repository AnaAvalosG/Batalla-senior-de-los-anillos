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

	public Heroes(String nombre, int puntosDeVida, int armadura) {
	    super(nombre, puntosDeVida, armadura);
	}
	
	public int tirarDado() {
		
	int dado1=(int) (Math.random()*101);
	int dado2 =(int) (Math.random()*101);
	
	return Math.max(dado1, dado2);
	}


	
}
