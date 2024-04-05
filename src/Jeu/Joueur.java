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

public class Joueur implements Cartes{

	private String nom;
	private ZoneDeJeu zonejeu = new ZoneDeJeu();
	
	private MainAsListe main = new MainAsListe();


	public Joueur(String nom) {
		this.nom = nom;
	}
	
	
	public void donner(Carte carte) {
		main.prendre(carte);
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
	
	public int donnerKmParcourus() {
		int total = 0;
		for(Borne born : zonejeu.getBornes()) {
			total += born.getKm();
		}
		return total;
	}
	
	public boolean estPrioritaire() {
		return zonejeu.getBottes().contains(Cartes.PRIORITAIRE);
	}
	
	public int donnerLimitationVitesse() {
		if(zonejeu.getPileLimites().isEmpty() || estPrioritaire()) {
			return 200;
		}else {
			Limite lim = zonejeu.getPileLimites().get(0);
			if(lim.equals(FIN_LIMITE)) {
				return 200;
			}
			return 50;
		}
	}
	
	public boolean estPrioType(Type type) {
		for(Botte bots : zonejeu.getBottes()) {
			if(bots.getType() == type) {
				return true;
			}
		}return false;
	}
	
	public boolean estBloque() {
		if(zonejeu.getBatailles().isEmpty() && estPrioritaire()) {
			return false;
		}else {
			Bataille sommet = zonejeu.getBatailles().get(0);
			if(sommet == Cartes.FEU_VERT 
					|| (sommet instanceof Parade && estPrioritaire()) 
					|| (sommet == Cartes.FEU_ROUGE && estPrioritaire()) 
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

	
	public MainAsListe getMain() {
		return main;
	}
	
	public void deposer(Borne borne) {
		List<Borne> bornes_temp = zonejeu.getBornes();
		bornes_temp.add(borne);
		zonejeu.setBornes(bornes_temp);
	}
	
	public void deposer(Limite lim) {
		List<Limite> lim_temp = zonejeu.getPileLimites();
		lim_temp.add(0,lim);
		zonejeu.setPileLimites(lim_temp);
	}
	
	public void deposer(Bataille bat) {
		List<Bataille> bat_temp = zonejeu.getBatailles();
		bat_temp.add(0,bat);
		zonejeu.setBatailles(bat_temp);
	}
	
	public ZoneDeJeu getZonejeu() {
		return zonejeu;
	}


	public void deposer(Botte bot) {
		HashSet<Botte> bot_temp = zonejeu.getBottes();
		bot_temp.add(bot);
		zonejeu.setBottes(bot_temp);
	}
	
	public void viderBottes() {
		zonejeu.setBottes(new HashSet<>());
	}

}
