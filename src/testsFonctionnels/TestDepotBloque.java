package testsFonctionnels;

import package1.Attaque;
import package1.Borne;
import package1.Botte;
import Jeu.Cartes;
import package1.DebutLimite;
import package1.FinLimite;
import package1.Parade;
import package1.Probleme.Type;
import Jeu.ZoneDeJeu;

public class TestDepotBloque {
	public static void main(String args[]) {
//        ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
//        zoneDeJeu.deposer(Cartes.FEU_ROUGE);
//        System.out.println("bloqué ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(Cartes.PRIORITAIRE);
//        System.out.println("bloqué ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(new Attaque(0, Type.ACCIDENT));
//        System.out.println("bloqué ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(new Botte(0, Type.ACCIDENT));
//        System.out.println("bloqué ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(new Attaque(0, Type.ESSENCE));
//        System.out.println("bloqué ? "+zoneDeJeu.estBloque());
//        zoneDeJeu.deposer(new Parade(0, Type.ESSENCE));
//        System.out.println("bloqué ? "+zoneDeJeu.estBloque());
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		System.out.println("Deposer carte Feu rouge");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(Cartes.FEU_ROUGE));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte attaque - accident");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Attaque(0, Type.ACCIDENT)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte botte - accident");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Botte(0, Type.ACCIDENT)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte Feu vert");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(Cartes.FEU_VERT));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte attaque - essence");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Attaque(0, Type.ESSENCE)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte parade - essence");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Parade(0, Type.ESSENCE)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte Feu vert");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(Cartes.FEU_VERT));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte borne - 100");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Borne(0, 100)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte limite - 50");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new DebutLimite(0)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte borne - 100");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Borne(0, 100)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte borne - 25");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Borne(0, 25)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte fin limite - 50");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new FinLimite(0)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
		System.out.println("Deposer carte borne - 100");
		System.out.println("dépôt ok ? " + zoneDeJeu.deposer(new Borne(0, 100)));
		System.out.println("bloqué ? " + zoneDeJeu.estBloque());
	}

}