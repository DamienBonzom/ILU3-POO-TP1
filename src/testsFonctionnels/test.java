package testsFonctionnels;

import java.util.Iterator;

import Jeu.Sabot;
import package1.Attaque;
import package1.Botte;
import package1.Carte;
import package1.Parade;
import package1.Probleme.Type;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Botte asVolant = new Botte(1, Type.ACCIDENT);
		Attaque accident = new Attaque(3, Type.ACCIDENT);
		Parade reparation = new Parade(3, Type.ACCIDENT);
		Sabot sabot = new Sabot(110);
		
		System.out.println("Question 2.a :");
		sabot.ajouterFamilleCarte(accident, reparation, asVolant);

		while(!sabot.estVide()) {
			Carte cartePiochee = sabot.piocher();
			System.out.println(String.format("Je pioche %s", cartePiochee));
		}
		
		System.out.println("Question 2.b :");
		sabot.ajouterFamilleCarte(accident, reparation, asVolant);
		Iterator<Carte> it = sabot.iterator();
		while(it.hasNext()) {
			Carte carte = it.next();
			System.out.println(String.format("Je prioche %s", carte));
			it.remove();
			sabot.ajouterFamilleCarte(asVolant); // ConcurrentModificationException
			//sabot.piocher();
		}
	}

}
