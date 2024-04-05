package Jeu;

import package1.Carte;

public class Coup {

	private Joueur cible;
	private Carte carte;
	
	public Coup(Joueur j, Carte c) {
		cible = j;
		carte = c;
	}

	public Joueur getCible() {
		return cible;
	}

	public Carte getCarte() {
		return carte;
	}

}
