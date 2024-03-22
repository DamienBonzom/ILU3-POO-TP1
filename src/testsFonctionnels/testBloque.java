package testsFonctionnels;

import Jeu.Joueur;
import package1.Carte;

public class testBloque {

	public testBloque() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Joueur j1 = new Joueur("Martin");
		
		j1.donner(Carte.FEU_ROUGE);
		j1.jouer(Carte.FEU_ROUGE);
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.donner(Carte.prio);
		j1.jouer(Carte.prio);
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.donner(Carte.ACCIDENT);
		j1.jouer(Carte.ACCIDENT);
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.donner(Carte.ASVOLANT);
		j1.jouer(Carte.ASVOLANT);
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.donner(Carte.PANNEESSENCE);
		j1.jouer(Carte.PANNEESSENCE);
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.donner(Carte.ESSENCE);
		j1.jouer(Carte.ESSENCE);
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.viderBottes();
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.donner(Carte.FEU_VERT);
		j1.jouer(Carte.FEU_VERT);
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));


	}

}
