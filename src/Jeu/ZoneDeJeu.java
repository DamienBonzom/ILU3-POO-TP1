package Jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import package1.Attaque;
import package1.Bataille;
import package1.Borne;
import package1.Botte;
import package1.Carte;
import package1.DebutLimite;
import package1.FinLimite;
import package1.Limite;
import package1.Parade;
import package1.Probleme;
import package1.Probleme.Type;

public class ZoneDeJeu implements Cartes{

	private List<Limite> pileLimites = new ArrayList<>();
	private List<Bataille> batailles = new ArrayList<>();
	private List<Borne> bornes = new ArrayList<>();
	private HashSet<Botte> bottes = new HashSet<>();
	
	public ZoneDeJeu() {
		
	}

	public List<Limite> getPileLimites() {
		return pileLimites;
	}

	public void setPileLimites(List<Limite> pileLimites) {
		this.pileLimites = pileLimites;
	}

	public void setBatailles(List<Bataille> batailles) {
		this.batailles = batailles;
	}

	public void setBornes(List<Borne> bornes) {
		this.bornes = bornes;
	}

	public void setBottes(HashSet<Botte> bottes) {
		this.bottes = bottes;
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
	
	public boolean estPrioType(Type type) {
		for(Botte bots : getBottes()) {
			if(bots.getType() == type) {
				return true;
			}
		}return false;
	}
	
	public boolean estPrioritaire() {
		return getBottes().contains(Cartes.PRIORITAIRE);
	}
	
	public boolean estBloque() {
		if(getBatailles().isEmpty() && estPrioritaire()) {
			return false;
		}else {
			Bataille sommet = getBatailles().get(0);
			if(sommet == Cartes.FEU_VERT 
					|| (sommet instanceof Parade && estPrioritaire()) 
					|| (sommet == Cartes.FEU_ROUGE && estPrioritaire()) 
					|| (sommet instanceof Attaque && estPrioType(sommet.getType()))) {
				return false;
			}
		}
		return true;
	}
	
	public int donnerLimitationVitesse() {
		if(getPileLimites().isEmpty() || estPrioritaire()) {
			return 200;
		}else {
			Limite lim = getPileLimites().get(0);
			if(lim.equals(Cartes.FIN_LIMITE)) {
				return 200;
			}
			return 50;
		}
	}
	
	public int donnerKmParcourus() {
		int total = 0;
		for(Borne born : getBornes()) {
			total += born.getKm();
		}
		return total;
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
			Bataille carte2 = (Bataille) carte;
			if(getBatailles().isEmpty()) {
				if(estPrioritaire() || carte2.equals(Cartes.FEU_ROUGE)){
					top = Cartes.FEU_VERT;
				}else {
					top = Cartes.FEU_ROUGE;
				}
			}else {
				top = getBatailles().get(0);
			}
			
			if(top instanceof Attaque && !estPrioType(top.getType()) && carte2 instanceof Parade && carte2.getType() == top.getType()) {
				return true;
			}else if(top instanceof Parade && carte2 instanceof Attaque && !estPrioType(carte2.getType())) {
				return true;
			}
			
		}
		return false;
	}
	
	public boolean deposer(Carte c) {
		if(estDepotAutorise(c)) {
			if(c instanceof Borne) {
				return bornes.add((Borne) c);
			}else if(c instanceof Botte) {
				Botte c2 = (Botte) c;
				if(!batailles.isEmpty() && batailles.get(0) instanceof Attaque && batailles.get(0).getType()==c2.getType()) {
					batailles.remove(0);
				}
				return bottes.add((Botte) c);
			}else if(c instanceof DebutLimite) {
				pileLimites.add(0,(DebutLimite) c);
				return pileLimites.contains((DebutLimite) c);
			}else if(c instanceof FinLimite) {
				pileLimites.add(0,(FinLimite) c);
				return pileLimites.contains((FinLimite) c);
			}else if(c instanceof Bataille) {
				batailles.add(0,(Bataille) c);
				return batailles.contains((Bataille) c);
			}
		}
		
		return false;
	}
	
	
	public void afficherZone() {
		System.out.println(getBatailles());
		System.out.println(getBornes());
		System.out.println(getBottes());
		System.out.println(getPileLimites());
	}

}
