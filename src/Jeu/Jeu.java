package Jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.JeuDeCartes;
import package1.Carte;

public class Jeu {

	private List<Joueur> joueurs = new ArrayList<>();
	private Sabot sabot = new Sabot(106);
	private int NBCARTES = 6;
	
	public void Jeu() {
		
	}
	
	public void inscrire(Joueur joueur) {
		joueurs.add(joueur);
	}
	
	public void remplirSabot(JeuDeCartes jeu) {
		for(Carte carte : jeu.getListeCartes()) {
			sabot.ajouterCarte(carte);
		}
	}
	
	public void distribuerCartes() {
		for(int i = 0; i < NBCARTES; i++) {
			for(Joueur joueur : joueurs) {
				joueur.donner(sabot.piocher());
			}
		}
	}
	
	public void jouerTour() {
		for(Joueur joueur : joueurs) {
			joueur.donner(sabot.piocher());
			
		}
	}
	
}
