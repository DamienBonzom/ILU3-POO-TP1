package cartes;

import java.util.ArrayList;
import java.util.List;

import package1.Attaque;
import package1.Borne;
import package1.Botte;
import package1.Carte;
import package1.DebutLimite;
import package1.FinLimite;
import package1.Parade;
import package1.Probleme.Type;
import utils.Utils;

public class JeuDeCartes {

	private List<Carte> listeCartes = new ArrayList<>();
	private Carte[] typeDeCartes = new Carte[] 
			{new Botte(1, Type.FEU), new Botte(1, Type.ACCIDENT), new Botte(1, Type.CREVAISON), new Botte(1, Type.ESSENCE), 
					new Attaque(5, Type.FEU),new Attaque(3, Type.ACCIDENT),new Attaque(3, Type.CREVAISON),new Attaque(3, Type.ESSENCE),
					new Parade(14, Type.FEU),new Parade(6, Type.ACCIDENT),new Parade(6, Type.CREVAISON),new Parade(6, Type.ESSENCE),
					new Borne(10,25),new Borne(10,50),new Borne(10,75),new Borne(12,100), new Borne(4,200),
					new DebutLimite(4), new FinLimite(6)};
	
	public JeuDeCartes() {
		for(Carte carte : typeDeCartes) {
			for(int i = 0; i < carte.getNombre(); i++) {
				listeCartes.add(carte);
				//System.out.println("ajout d'une carte");
			}
		}
		listeCartes = Utils.melanger(listeCartes);
	}
	
	public int get_taille() {
		return listeCartes.size();
	}

	public List<Carte> getListeCartes() {
		return listeCartes;
	}
	
	
	public boolean checkCount() {
		int nbrAttendu;
		int total;
		for(Carte typeCarte : typeDeCartes) {
			nbrAttendu = typeCarte.getNombre();
			total = 0;
			for(Carte carte : listeCartes) {
				if(carte.equals(typeCarte)) {
					total++;
				}
			}
			if(total != nbrAttendu) {
				return false;
			}
			
		}
		return true;
	}
	

}
