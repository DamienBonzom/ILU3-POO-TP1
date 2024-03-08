package testsFonctionnels;


import package1.Attaque;
import package1.Borne;
import package1.Botte;
import package1.Probleme.Type;

public class testComparaison {

	public testComparaison() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Attaque attaque1 = new Attaque(1, Type.FEU);
		Attaque attaque2 = new Attaque(1, Type.ACCIDENT);
		
		Botte botte = new Botte(1, Type.ACCIDENT);
		
		Borne b1 = new Borne(1, 10);
		Borne b2 = new Borne(1, 20);
		
		System.out.println("Tests de comparaisons : ");
		System.out.println(String.format("Comparaison entre attaque feu et attaque accident : %b", attaque1.equals(attaque2)));
		System.out.println(String.format("Comparaison entre attaque feu et attaque feu : %b", attaque1.equals(attaque1)));
		System.out.println(String.format("Comparaison entre botte accident et attaque accident : %b", botte.equals(attaque2)));
		System.out.println(String.format("Comparaison entre borne 10km et borne 20km : %b", b1.equals(b2)));
		System.out.println(String.format("Comparaison entre borne 10km et borne 10km : %b", b1.equals(b1)));

	}

}
