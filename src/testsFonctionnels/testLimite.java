package testsFonctionnels;

import Jeu.Joueur;
import package1.Botte;
import package1.DebutLimite;
import package1.FinLimite;
import package1.Probleme.Type;

public class testLimite {

	public testLimite() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Joueur j1 = new Joueur("Martin");
		FinLimite finlim = new FinLimite(1);
		DebutLimite debutlim = new DebutLimite(1);
		Botte prioritaire = new Botte(1, Type.FEU);
		
		System.out.println(String.format("Limite de vitesse sans carte limites : %d\n", j1.getLimite()));
		
		j1.donner(debutlim);
		j1.jouer(debutlim);
		
		System.out.println(String.format("Limite de vitesse avec une limite : %d\n", j1.getLimite()));


		j1.donner(finlim);
		j1.jouer(finlim);
		
		System.out.println(String.format("Limite de vitesse avec une fin de limite : %d\n", j1.getLimite()));

		j1.donner(debutlim);
		j1.jouer(debutlim);
		j1.donner(prioritaire);
		j1.jouer(prioritaire);
		
		System.out.println(String.format("Limite de vitesse avec une limite MAIS j1 est prioritaire : %d\n", j1.getLimite()));

	}

}
