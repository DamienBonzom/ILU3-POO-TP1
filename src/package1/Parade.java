package package1;

import package1.Probleme.Type;

public class Parade extends Bataille {

	public Parade(int n, Type t) {
		super(n, t);
	}

	public String toString() {
		if(getType() == Type.ACCIDENT) {
			return "Reparations";
		}else if(getType() == Type.CREVAISON) {
			return "Roue de secours";
		}else if(getType() == Type.ESSENCE) {
			return "Essence";
		}else {
			return "FeuVert";
		}
	}
	
}
