package Jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

import cartes.JeuDeCartes;
import package1.Carte;

public class Jeu {

	private Set<Joueur> joueurs = new LinkedHashSet<>();
	Iterator<Joueur> it;
	private Sabot sabot;
	private int NBCARTES = 6;
	
	public void Jeu() {
		it = joueurs.iterator();
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
	
	public Coup jouerTour(Joueur joueur) {
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
		System.out.println(String.format("Le joueur a parcouru %dkm", joueur.donnerKmParcourus()));
		System.out.println("");
		return coupchoisi;
	}
	
	public Joueur donnerJoueurSuivant() {
		if(it.hasNext()) {
			return it.next();
		}
		it = joueurs.iterator();
		return it.next();
	}
	
	public void lancer() {
		boolean esttermine = false;
		while(!sabot.sabotEstVide() && !esttermine) {
			for(Joueur joueur : joueurs) {
				Coup coupjoue = jouerTour(joueur);
				if(joueur.donnerKmParcourus() == 1000) {
					System.out.println(String.format("LE JEU EST TERMINE !!! %s a gagné !!!!", joueur.toString()));
					esttermine = true;
					break;
				}
			}
		}
		if(sabot.sabotEstVide()) {
			System.out.println("Heuuu le sabot est vide le jeu est terminé..");
			System.out.println(String.format("C'est le joueur %s qui a gagné !", classement().iterator().next()));
		}
		/*
		if(esttermine) {
			System.out.println("Heuuu plus personne peut jouer apparamment");
			System.out.println(String.format("C'est le joueur %s qui a gagné !", classement().iterator().next()));
		}*/
		
		System.out.println(String.format("Classement complet : %s", classement().toString()));
	}
	
	public Set<Joueur> classement(){
		NavigableSet<Joueur> clssmt = new TreeSet<>(new Comparator<Joueur>() {
			public int compare(Joueur j1, Joueur j2) {
				int compar = j2.donnerKmParcourus() - j1.donnerKmParcourus();
				if(compar == 0) {
					return j1.toString().compareTo(j2.toString());
				}
				return compar;
			}
		});
		clssmt.addAll(joueurs);
		return clssmt;
	}
	
}
