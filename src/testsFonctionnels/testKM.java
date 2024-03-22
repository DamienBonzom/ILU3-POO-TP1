package testsFonctionnels;

import Jeu.Joueur;
import package1.Borne;

public class testKM {

	public testKM() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Joueur j1 = new Joueur("Martin");
		Borne borne20 = new Borne(1, 20);
		
		System.out.println(String.format("Total KM sans borne : %d\n", j1.getKM()));
		
		j1.donner(borne20);
		j1.jouer(borne20);
		
		System.out.println(String.format("Total KM avec 1 borne 20km : %d\n", j1.getKM()));
		
		j1.donner(borne20);
		j1.donner(borne20);
		j1.donner(borne20);
		j1.donner(borne20);
		j1.jouer(borne20);
		j1.jouer(borne20);
		j1.jouer(borne20);
		j1.jouer(borne20);
		
		System.out.println(String.format("Total KM avec 5 bornes 20km : %d\n", j1.getKM()));

	}

}
