package testsFonctionnels;

import Jeu.Cartes;
import Jeu.Joueur;
import package1.Carte;

public class TestZoneDeJeu implements Cartes {

	public TestZoneDeJeu() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Joueur j1 = new Joueur("Martin");
		
		j1.deposer(Cartes.FEU_ROUGE);
		//j1.getZonejeu().afficherZone();
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.deposer(Cartes.PRIORITAIRE);
		//j1.getZonejeu().afficherZone();
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.deposer(Cartes.ACCIDENT);
		//j1.getZonejeu().afficherZone();
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.deposer(Cartes.ASVOLANT);
		//j1.getZonejeu().afficherZone();
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.deposer(Cartes.PANNEESSENCE);
		//j1.getZonejeu().afficherZone();
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.deposer(Cartes.ESSENCE);
		//j1.getZonejeu().afficherZone();
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.viderBottes();
		//j1.getZonejeu().afficherZone();
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));
		
		j1.deposer(Cartes.FEU_VERT);
		//j1.getZonejeu().afficherZone();
		
		System.out.println(String.format("Joueur bloqué ? : %b", j1.estBloque()));


	}

}
