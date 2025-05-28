package personajes.bestias;

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
public abstract class Bestias extends Personaje {
	
	public Bestias(String nombre, int puntosDeVida, int armadura) {
	    super(nombre, puntosDeVida, armadura);
	} 
	
	public int tirarDado() {
	 return (int) (Math.random() *91);
	}
	
	

}
