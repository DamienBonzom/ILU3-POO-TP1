package package1;

import package1.Probleme.Type;

public class Attaque extends Bataille {

	public Attaque(int n, Type t) {
		super(n, t);
	}

	public String toString() {
		if(getType() == Type.ACCIDENT) {
			return "Accident";
		}else if(getType() == Type.CREVAISON) {
			return "Crevaison";
		}else if(getType() == Type.ESSENCE) {
			return "Panne d'essence";
		}else {
			return "FeuRouge";
		}
	}
	
	
}
