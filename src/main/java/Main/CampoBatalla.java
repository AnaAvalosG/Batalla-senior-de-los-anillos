package Main;

import java.util.ArrayList;
import java.util.List;

import personajes.bestias.Bestias;
import personajes.bestias.Orco;
import personajes.bestias.Trasgos;
import personajes.heroes.Elfo;
import personajes.heroes.Heroes;
import personajes.heroes.Hobbits;
import personajes.heroes.Humanos;

public class CampoBatalla {

	public static void main(String[] args) {
		System.out.println("¡Batalla épica comienza!");
		
		List<Heroes> ejercitoHeroes = new ArrayList<>();  
		List<Bestias> ejercitoBestias = new ArrayList<>();
		
		//Creacion ejercito Heroes
	ejercitoHeroes.add(new Humanos("Aragorn", 100, 70));
	ejercitoHeroes.add(new Humanos("Boromir", 300, 40));
	ejercitoHeroes.add(new Elfo("Fingolfin", 120, 100));
	ejercitoHeroes.add(new Elfo("Légolas", 200,60));
	ejercitoHeroes.add(new Hobbits("Fodo", 100, 20));
	ejercitoHeroes.add(new Hobbits("Sam", 180, 90));
	
	
	//Creacion ejercito Bestias
	ejercitoBestias.add(new Orco("Lurtz",200,60));
	ejercitoBestias.add(new Orco("Shagrat",220,70));
	ejercitoBestias.add(new Orco("Sauron",180,90));
	ejercitoBestias.add(new Trasgos("Uglúk",300,40));
	ejercitoBestias.add(new Trasgos("Mauhúr",100,90));
		
	
	//SeniorAnillos.batalla(ejercitoHeroes, ejercitoBestias);
	}

}
