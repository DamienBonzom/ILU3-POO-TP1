package Jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import package1.Attaque;
import package1.Bataille;
import package1.Borne;
import package1.Carte;
import package1.FinLimite;
import package1.Limite;
import package1.Parade;
import package1.Probleme.Type;
import package1.Botte;

import package1.Carte;

public class Joueur {

	private String nom;
	private List<Limite> pileLimites = new ArrayList<>();
	private List<Bataille> batailles = new ArrayList<>();
	private List<Borne> bornes = new ArrayList<>();
	private HashSet<Botte> bottes = new HashSet<>();
	
	private MainAsListe main = new MainAsListe();


	public Joueur(String nom) {
		this.nom = nom;
	}
	
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public void jouer(Carte carte) {
		main.jouer(carte);
		if(carte instanceof Limite) {
			pileLimites.add(0, (Limite) carte); 
		}else if(carte instanceof Bataille) {
			batailles.add(0, (Bataille) carte); 
		}else if(carte instanceof Borne) {
			bornes.add(0, (Borne) carte); 
		}else if(carte instanceof Botte) {
			bottes.add((Botte) carte); 
		}
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if(sabot.isEmpty()) {
			return null;
		}else {
			Carte carte = sabot.get(0);
			sabot.remove(carte);
			donner(carte);
			return carte;
		}
	}
	
	public int getKM() {
		int total = 0;
		for(Borne born : bornes) {
			total += born.getKm();
		}
		return total;
	}
	
	public boolean estPrioritaire() {
		return bottes.contains(Carte.prio);
	}
	
	public int getLimite() {
		if(pileLimites.isEmpty() || estPrioritaire()) {
			return 200;
		}else {
			Limite lim = pileLimites.get(0);
			if(lim instanceof FinLimite) {
				return 200;
			}
			return 50;
		}
	}
	
	public boolean estPrioType(Type type) {
		for(Botte bots : bottes) {
			if(bots.getType() == type) {
				return true;
			}
		}return false;
	}
	
	public boolean estBloque() {
		if(batailles.isEmpty()) {
			return false;
		}else {
			Bataille sommet = batailles.get(0);
			if(sommet == Carte.FEU_VERT 
					|| (sommet instanceof Parade && estPrioritaire()) 
					|| (sommet == Carte.FEU_ROUGE && estPrioritaire()) 
					|| (sommet instanceof Attaque && estPrioType(sommet.getType()))) {
				return false;
			}
		}
		return true;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur) {
			Joueur j2 = (Joueur) obj;
			return j2.getNom().equals(nom);
		}
		return false;
	}
	
	public String toString() {
		return nom;
	}

	public String getNom() {
		return nom;
	}

	public List<Limite> getPileLimites() {
		return pileLimites;
	}

	public List<Bataille> getBatailles() {
		return batailles;
	}

	public List<Borne> getBornes() {
		return bornes;
	}

	public HashSet<Botte> getBottes() {
		return bottes;
	}
	
	public MainAsListe getMain() {
		return main;
	}
	
	public void viderBottes() {
		bottes = new HashSet<>();
	}

}
