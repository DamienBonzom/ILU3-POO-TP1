package package1;

public abstract class Carte {
	private int nombre;
	public static final Botte prio = new Botte(0,Probleme.Type.FEU);
	public static final Botte ASVOLANT = new Botte(0,Probleme.Type.ACCIDENT);
	public static final Attaque FEU_ROUGE = new Attaque(0, Probleme.Type.FEU);
	public static final Parade FEU_VERT = new Parade(0, Probleme.Type.FEU);
	public static final Attaque ACCIDENT = new Attaque(0, Probleme.Type.ACCIDENT);
	public static final Attaque PANNEESSENCE = new Attaque(0, Probleme.Type.ESSENCE);
	public static final Parade ESSENCE = new Parade(0, Probleme.Type.ESSENCE);

	public int getNombre() {
		return nombre;
	}
	
	public Carte(int n) {
		this.nombre = n;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Carte) {
			Carte carte = (Carte) obj;
			return carte.getClass() == getClass();
		}
		return false;
	}
}
