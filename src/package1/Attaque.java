package package1;

import java.util.HashMap;
import java.util.Map;

import package1.Probleme.Type;

public class Attaque extends Bataille {

	static Map<Type, String> nom = new HashMap<>();
	
	static {
		nom.put(Type.ACCIDENT, "Accident");
		nom.put(Type.CREVAISON, "Crevaison");
		nom.put(Type.ESSENCE, "Panne d'essence");
		nom.put(Type.FEU, "FeuRouge");
	}
	
	public Attaque(int n, Type t) {
		super(n, t);
	}

	public String toString() {
		return nom.get(getType());
	}
	
	
}
