package Jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.JeuDeCartes;
import package1.Carte;

public class Jeu {

	private Set<Joueur> joueurs = new HashSet<>();
	private Sabot sabot;
	private int NBCARTES = 6;
	
	public void Jeu() {
		
	}
	
	public void inscrire(Joueur joueur) {
		joueurs.add(joueur);
	}
	
	public void remplirSabot(JeuDeCartes jeu) {
		sabot = new Sabot(jeu.get_taille());
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
			Carte pioche = sabot.piocher();
			joueur.donner(pioche);
			System.out.println(String.format("Le joueur %s a pioche %s", joueur.toString(), pioche.toString()));
			System.out.println(String.format("Il a dans sa main : %s", joueur.getMain().toString()));
			Coup coupchoisi = joueur.choisirCoup(joueurs);
			joueur.retirerDeLaMain(coupchoisi.getCarte());
			if(coupchoisi.getCible() == null) {
				sabot.ajouterCarte(coupchoisi.getCarte());
			}else {
				coupchoisi.getCible().deposer(coupchoisi.getCarte());
			}
			if(coupchoisi.getCible() == null) {
				System.out.println(String.format("defausser la carte %s dans le sabot", coupchoisi.getCarte().toString()));
			}else {
				System.out.println(String.format("deposer la carte %s dans la zone de jeu de %s", coupchoisi.getCarte().toString(), coupchoisi.getCible().toString()));
			}
			System.out.println("");
		}
	}
	
}
