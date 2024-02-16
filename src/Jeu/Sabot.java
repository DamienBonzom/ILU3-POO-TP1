package Jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import package1.Carte;

public class Sabot implements Iterable<Carte> {
	
	private int nbCartes = 0;
	private int capacite;
	private Carte[] cartes;
	
	private int nombreOperations = 0;

	public Sabot(int capacite) {
		this.capacite = capacite;
		this.cartes = new Carte[capacite];
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	private void ajouterCarte(Carte carte){
		if(nbCartes == capacite) {
			throw new ArrayIndexOutOfBoundsException("Le sabot est plein");
		}
		
		cartes[nbCartes] = carte;
		nbCartes += 1;
		
		nombreOperations++;
		
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		for(int i = 0; i < carte.getNombre(); i++) {
			ajouterCarte(carte);
		}
	}
	
	public void ajouterFamilleCarte(Carte... cartes) {
		for(Carte carte : cartes) {
			ajouterFamilleCarte(carte);
		}
	}
	
	public Carte piocher() {
		Iterator<Carte> it = iterator();
		Carte carteRetiree = it.next();
		it.remove();
		return carteRetiree;
	}
	
	public Iterator<Carte> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte>{
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nombreOperationsReference = nombreOperations;
		
		
		
		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		@Override
		public Carte next() {
			verificationConcurrence();
			if(hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			}else {
				throw new NoSuchElementException();
			}
		}
		
		public void remove() {
			verificationConcurrence();
			if(nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for(int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i+1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
		}
		
		private void verificationConcurrence() {
			if(nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
		
		
		
	}

}
