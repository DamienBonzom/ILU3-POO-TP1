package package1;

import java.util.HashMap;
import java.util.Map;

public class Botte extends Probleme {

	static Map<Type, String> nom = new HashMap<>();
	
	static {
		nom.put(Type.ACCIDENT, "As du volant");
		nom.put(Type.CREVAISON, "Increvable");
		nom.put(Type.ESSENCE, "Citerne d'essence");
		nom.put(Type.FEU, "Véhicule prioritaire");
	}
	
	public Botte(int n, Type t) {
		super(n, t);
	}
	
	public String toString() {
		
		return nom.get(getType());
	}

}
