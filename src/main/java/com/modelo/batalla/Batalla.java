package com.modelo.batalla;

import java.util.List;

import com.modelo.personajes.Personaje;
import com.modelo.personajes.bestias.Bestias;
import com.modelo.personajes.heroes.Heroes;

public class Batalla {

		
		 private List<Heroes> ejercitoHeroes;
		    private List<Bestias> ejercitoBestias;
		    private int turno;

		    // Constructor que recibe los ejércitos
		    public Batalla(List<Heroes> ejercitoHeroes, List<Bestias> ejercitoBestias) {
		        this.ejercitoHeroes = ejercitoHeroes;
		        this.ejercitoBestias = ejercitoBestias;
		        this.turno = 1;
		    }



		public void iniciar() {
			while(!ejercitoHeroes.isEmpty() && !ejercitoBestias.isEmpty()) {
				System.out.println("Ronda " +turno++);
				
				int turnoEmparejado = Math.min(ejercitoHeroes.size(), ejercitoBestias.size());
				
				for (int i = 0; i < turnoEmparejado; i++) {
					Personaje heroe = (Personaje) ejercitoHeroes.get(i);
					Personaje bestia = (Personaje) ejercitoBestias.get(i);
					
					int danioHeroe = Combate.daño(heroe, bestia);
					bestia.setPuntosDeVida(bestia.getPuntosDeVida() - danioHeroe);
					System.out.println(heroe.getNombre() + " ataco a " + bestia.getNombre()+
	                                                    " causando " +danioHeroe+ " de daño");
					
					if(bestia.getPuntosDeVida() <= 0) {
						System.out.println(bestia.getNombre()+" ah muerto ⚔");
						ejercitoBestias.remove(i);
						turnoEmparejado--;
						i--;
						continue;
					}
					
					int danioBestia = Combate.daño(bestia, heroe);
					heroe.setPuntosDeVida(heroe.getPuntosDeVida() - danioBestia);
					System.out.println(bestia.getNombre() +" ataco a " + heroe.getNombre() +" causando "+
					danioBestia+ " de daño");
					
					if(heroe.getPuntosDeVida() <= 0) {
						System.out.println(heroe.getNombre()+" ah muerto 😥");
						ejercitoHeroes.remove(i);
						turnoEmparejado--;
						i--;
						continue;
					}
					System.out.println("Estado parcial:");
				    System.out.println("Heroe: " + heroe.getNombre() + " → vida=" + heroe.getPuntosDeVida());
				    System.out.println("Bestia:" + bestia.getNombre() + " → vida=" + bestia.getPuntosDeVida());
					
				}
				 
		        
			}
			if(ejercitoHeroes.isEmpty()) {
				System.out.println("¡No!, las bestias lograron la victoria... ");
			}else if(ejercitoBestias.isEmpty()) {
				System.out.println("La victoria pertenece a los heroes!");
			}
		}
	}

	

