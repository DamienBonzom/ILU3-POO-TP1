package Jeu;

import package1.Attaque;
import package1.Carte;
import package1.DebutLimite;
import package1.FinLimite;

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
	
	public boolean estValide(Joueur joueur) {
		return ((carte instanceof Attaque || carte instanceof DebutLimite) && !joueur.equals(cible)
				|| (!(carte instanceof Attaque || carte instanceof DebutLimite) && joueur.equals(cible)));
	}
	
	@Override
	public boolean equals(Object objet) {
		if(objet instanceof Coup) {
			Coup coup = (Coup) objet;
			if(coup.getCible() == null && cible == null) {
				return coup.getCarte().equals(carte);
			}else if(coup.getCible() == null && cible != null || cible == null && coup.getCible() != null) {
				return false;
			}
			return coup.getCible().equals(cible) && coup.getCarte().equals(carte);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		if(cible == null) {
			return 31*carte.hashCode();
		}
		return 31*carte.hashCode() + 7*cible.hashCode();
	}
	
	@Override
	public String toString() {
		return String.format("deposer la carte %s dans la zone de jeu de %s", carte.toString(), cible.toString());
	}

}
