package Jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import package1.Carte;

public class MainAsListe implements Main {

	private List<Carte> carteMain = new ArrayList<>();
	private Iterator<Carte> it = carteMain.iterator();
	
	
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

}
