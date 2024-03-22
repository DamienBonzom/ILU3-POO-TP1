package testsFonctionnels;

import cartes.JeuDeCartes;

import package1.Carte;

import utils.Utils;

public class testJeuDeCarte {

	public testJeuDeCarte() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		Utils util = new Utils();
		
		for(Carte carte : jeu.getListeCartes()) {
			System.out.println(carte);
		}
		
		System.out.println(String.format("Le jeu de cartes est bien construit : %b\n", jeu.checkCount()));
		System.out.println(String.format("Jeu de carte rassemblé, verification : %b\n", util.verifierRassemblement(util.rassembler(jeu.getListeCartes()))));

	}

}
