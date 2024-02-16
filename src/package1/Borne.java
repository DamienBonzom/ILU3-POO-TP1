package package1;

public class Borne extends Carte {

	private int km;
	
	public Borne(int n, int km) {
		super(n);
		this.km = km;
	}

	public int getKm() {
		return km;
	}
	
	
	public String toString() {
		return String.format("Borne %d", km).toString();
	}

}
