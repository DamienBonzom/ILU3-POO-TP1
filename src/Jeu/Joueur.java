package Jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

import java.util.Random;

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
	/*
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
	
	public void deposer(Botte bot) {
		HashSet<Botte> bot_temp = zonejeu.getBottes();
		bot_temp.add(bot);
		zonejeu.setBottes(bot_temp);
	}
	*/
	
	public ZoneDeJeu getZonejeu() {
		return zonejeu;
	}

	
	public void viderBottes() {
		zonejeu.setBottes(new HashSet<>());
	}
	
	public Set<Coup> coupsPossibles(Set<Joueur> participants){
		HashSet<Coup> coups = new HashSet<>();
		for(Joueur joueur : participants) {
			for(Carte carte : getMain()) {
				Coup coup = new Coup(joueur, carte);
				if(coup.estValide(this) && estDepotAutorise(carte)) {
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
	
	public boolean deposer(Carte c) {
		return zonejeu.deposer(c);
	}
	
	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);
	}
	
	private <E> E choisirElement(Set<E> liste, int indice) {
		int i = 0;
		for(Iterator<E> it = liste.iterator(); it.hasNext();){
			if(i == indice) {
				E c = it.next();
				it.remove();
				return c;
			}else {
				it.next();
				i+=1;
			}
		}
		return null;
	}
	
	public Coup choisirCoup(Set<Joueur> participants) {
		Set<Coup> liste_coups = coupsPossibles(participants);
		Set<Coup> liste_defausses = coupsDefausse();
		Random randomNumbers = new Random();
		if(liste_coups.size() == 0) {
			return choisirElement(liste_defausses, randomNumbers.nextInt(liste_defausses.size()));
		}else {
			return choisirElement(liste_coups, randomNumbers.nextInt(liste_coups.size()));
		}
	}

}
