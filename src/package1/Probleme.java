package package1;

public abstract class Probleme extends Carte {

	public enum Type{FEU,ESSENCE,CREVAISON,ACCIDENT}
	
	private Type type;
	
	public Probleme(int n, Type t) {
		super(n);
		type = t;
	}

	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probleme) {
			Probleme prob = (Probleme) obj;
			return super.equals(prob) && prob.getType() == getType();
		}
		return false;
	} 

}
