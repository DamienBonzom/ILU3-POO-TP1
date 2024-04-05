package Jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import package1.Attaque;
import package1.Bataille;
import package1.Borne;
import package1.Carte;
import package1.DebutLimite;
import package1.FinLimite;
import package1.Limite;
import package1.Parade;
import package1.Probleme;
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
	
	public boolean estDepotAutorise(Carte carte) {
		if(carte instanceof Borne) {
			Borne carte2 = (Borne) carte;
			if(!estBloque() && carte2.getKm() <= donnerLimitationVitesse() && donnerKmParcourus() + carte2.getKm() <=1000) {
				return true;
			}
		}else if(carte instanceof Botte) {
			return true;
		}else if(carte instanceof DebutLimite) {
			if(!estPrioritaire() && donnerLimitationVitesse() != 50) {
				return true;
			}
		}else if(carte instanceof FinLimite) {
			if(!estPrioritaire() && donnerLimitationVitesse() == 50) {
				return true;
			}
		}else if(carte instanceof Bataille) {
			Probleme top;
			if(zonejeu.getBatailles().isEmpty()) {
				if(estPrioritaire() || carte.equals(Cartes.FEU_ROUGE)){
					top = Cartes.FEU_VERT;
				}else {
					top = Cartes.FEU_ROUGE;
				}
			}else {
				top = zonejeu.getBatailles().get(0);
			}
			
			if(top instanceof Attaque && !estPrioType(top.getType())) {
				return true;
			}else if(top instanceof Parade) {
				//TODO: faire le dernier cas tp 4 qst 1.2
			}
			
		}
		return false;
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
