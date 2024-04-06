package Jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		return zonejeu.donnerKmParcourus();
	}
	
	public boolean estPrioritaire() {
		return zonejeu.estPrioritaire();
	}
	
	public int donnerLimitationVitesse() {
		return zonejeu.donnerLimitationVitesse();
	}
	
	public boolean estPrioType(Type type) {
		for(Botte bots : zonejeu.getBottes()) {
			if(bots.getType() == type) {
				return true;
			}
		}return false;
	}
	
	public boolean estBloque() {
		return zonejeu.estBloque();
	}
	
	public boolean estDepotAutorise(Carte carte) {
		return zonejeu.estDepotAutorise(carte);
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
	
	public Set<Coup> coupsPossibles(Set<Joueur> participants){
		HashSet<Coup> coups = new HashSet<>();
		for(Joueur joueur : participants) {
			for(Carte carte : getMain()) {
				Coup coup = new Coup(joueur, carte);
				if(coup.estValide(this)) {
					coups.add(coup);
				}
			}
		}
		return coups;
	}
	
	public Set<Coup> coupsDefausse(){
		HashSet<Coup> coups = new HashSet<>();
		for(Carte carte: getMain()) {
			coups.add(new Coup(null, carte));
		}
		return coups;
	}

}
