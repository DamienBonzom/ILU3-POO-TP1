package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import Jeu.Cartes;
import Jeu.Joueur;
import package1.Carte;

public class TestDepotBloque implements Cartes {

	public static void main(String[] args) {
		Joueur j1 = new Joueur("damien");
		boolean estDepose;
		
		List<Carte> cartes = new ArrayList<>();
		cartes.add(Cartes.FEU_ROUGE);
		cartes.add(Cartes.ACCIDENT);
		cartes.add(Cartes.ASVOLANT);
		cartes.add(Cartes.PANNEESSENCE);
		cartes.add(Cartes.ESSENCE);
		cartes.add(Cartes.FEU_VERT);
		cartes.add(Cartes.BORNE100);
		cartes.add(Cartes.LIMITE);
		cartes.add(Cartes.BORNE100);
		cartes.add(Cartes.BORNE25);
		cartes.add(Cartes.FIN_LIMITE);
		cartes.add(Cartes.BORNE100);
		
		for(Carte carte : cartes) {
			estDepose = j1.deposer(carte);
			System.out.println(String.format("déposer %s : dépôt ok ? %b, bloqué ? %b", carte.toString(), estDepose, j1.estBloque()));
		}

	}

}
