package testsFonctionnels;

import cartes.JeuDeCartes;
import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Jeu;
public class TestJeu {
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.inscrire(new Joueur("Jack"));
		jeu.inscrire(new Joueur("Bill"));
		jeu.inscrire(new Joueur("Luffy"));
		jeu.remplirSabot(new JeuDeCartes());
		jeu.distribuerCartes();
		jeu.jouerTour();
	}
}
