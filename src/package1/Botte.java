package package1;

public class Botte extends Probleme {

	public Botte(int n, Type t) {
		super(n, t);
	}
	
	public String toString() {
		if(getType() == Type.ACCIDENT) {
			return "As du volant";
		}else if(getType() == Type.CREVAISON) {
			return "Increvable";
		}else if(getType() == Type.ESSENCE) {
			return "Citerne d'essence";
		}else {
			return "Véhicule prioritaire";
		}
	}

}
