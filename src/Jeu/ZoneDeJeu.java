package Jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import package1.Bataille;
import package1.Borne;
import package1.Botte;
import package1.Carte;
import package1.DebutLimite;
import package1.FinLimite;
import package1.Limite;

public class ZoneDeJeu {

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
	
	
	public void afficherZone() {
		System.out.println(getBatailles());
		System.out.println(getBornes());
		System.out.println(getBottes());
		System.out.println(getPileLimites());
	}

}
