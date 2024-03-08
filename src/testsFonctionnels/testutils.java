package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import cartes.JeuDeCartes;
import package1.Carte;
import utils.Utils;

public class testutils {

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu.getListeCartes();
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = Utils.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
		+ Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));

	}

}
