package package1;

import java.util.HashMap;
import java.util.Map;

import package1.Probleme.Type;

public class Parade extends Bataille {

	static Map<Type, String> nom = new HashMap<>();
	
	static {
		nom.put(Type.ACCIDENT, "Réparation");
		nom.put(Type.CREVAISON, "Roue de secours");
		nom.put(Type.ESSENCE, "Essence");
		nom.put(Type.FEU, "FeuVert");
	}
	
	public Parade(int n, Type t) {
		super(n, t);
	}

	public String toString() {
		return nom.get(getType());
	}
	
}
