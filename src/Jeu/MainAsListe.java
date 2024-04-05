package Jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import package1.Carte;

public class MainAsListe implements Main {

	private List<Carte> carteMain = new ArrayList<>();
	
	
	public MainAsListe() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prendre(Carte carte) {
		carteMain.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		assert(carteMain.contains(carte));
		carteMain.remove(carte);
	}

	@Override
	public Iterator<Carte> iterator() {
		return carteMain.iterator();
	}
	
	@Override
	public String toString() {
		StringBuilder concat = new StringBuilder();
		for (Carte carte : carteMain) {
			concat.append(String.format(", %s", carte.toString()));
		}
		return concat.toString();
	}

}
