package Jeu;

import package1.Attaque;
import package1.Botte;
import package1.FinLimite;
import package1.Parade;
import package1.Probleme;

public interface Cartes {
	public static final Botte PRIORITAIRE = new Botte(0,Probleme.Type.FEU);
	public static final Botte ASVOLANT = new Botte(0,Probleme.Type.ACCIDENT);
	public static final Attaque FEU_ROUGE = new Attaque(0, Probleme.Type.FEU);
	public static final Parade FEU_VERT = new Parade(0, Probleme.Type.FEU);
	public static final Attaque ACCIDENT = new Attaque(0, Probleme.Type.ACCIDENT);
	public static final Attaque PANNEESSENCE = new Attaque(0, Probleme.Type.ESSENCE);
	public static final Parade ESSENCE = new Parade(0, Probleme.Type.ESSENCE);
	public static final FinLimite FIN_LIMITE = new FinLimite(0);
}
