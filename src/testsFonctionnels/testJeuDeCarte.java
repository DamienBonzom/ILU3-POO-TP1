package testsFonctionnels;

import cartes.JeuDeCartes;
import package1.Carte;

public class testJeuDeCarte {

	public testJeuDeCarte() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		
		for(Carte carte : jeu.getListeCartes()) {
			System.out.println(carte);
		}
		
		System.out.println(String.format("Le jeu de cartes est bien construit : %b\n", jeu.checkCount()));

	}

}
