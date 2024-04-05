package package1;

public abstract class Carte {
	private int nombre;

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
