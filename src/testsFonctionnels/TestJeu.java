package testsFonctionnels;

import cartes.JeuDeCartes;
import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Jeu;
public class TestJeu {
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.inscrire(new Joueur("Damien"));
		jeu.inscrire(new Joueur("Melissa"));
		jeu.inscrire(new Joueur("Emily"));
		jeu.inscrire(new Joueur("Martin"));
		jeu.remplirSabot(new JeuDeCartes());
		jeu.distribuerCartes();
		jeu.lancer();
	}
}
