package Jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import package1.Carte;

public interface Main extends Iterable<Carte> {
	
	List<Carte> carteMain = new ArrayList<>();
	Iterator<Carte> it = carteMain.iterator();
	
	public void prendre(Carte carte);
	public void jouer(Carte carte);
}
