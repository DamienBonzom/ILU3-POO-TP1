package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public static <U> U extraire(List<U> liste){
		Random randomNumbers = new Random();
		int indice = randomNumbers.nextInt(liste.size());
		U obj = liste.get(indice);
		liste.remove(indice);
		return obj;
	}
	
	public static <U> U extraireIt(List<U> liste){
		Random randomNumbers = new Random();
		int indice = randomNumbers.nextInt(liste.size());
		ListIterator<U> it = liste.listIterator(indice);
		U obj;
		
		if(it.hasNext()) {
			obj = it.next();
		}else {
			obj = it.previous();
		}
		
		it.remove();
		
		return obj;
	}
	
	public static <U> List<U> melanger(List<U> liste){
		List<U> melange = new ArrayList<>();
		while(liste.size() > 0) {
			melange.add(extraire(liste));
		}
		return melange;
	}
	
	public static <U> boolean verifierMelange(List<U> liste1, List<U> liste2) {
		for(int i = 0; i < liste1.size(); i++) {
			U obj = liste1.get(i);
			if(Collections.frequency(liste1, obj) != Collections.frequency(liste2, liste2.get(liste2.indexOf(obj)))) {
				return false;
			}
		}
		return true;
	}
	
	public static <U> List<U> rassembler(List<U> liste){
		List<U> listerassemblee = new ArrayList<>();
		for (U obj : liste) {
			if(!liste.contains(obj)) {
				for(int i = 0; i < Collections.frequency(liste, obj); i++) {
					listerassemblee.add(obj);
				}
			}
		}
		return listerassemblee;
	}
	
	public static <U> boolean verifierRassemblement(List<U> liste) {
		boolean fininstance;
		boolean debut;
		for(U obj : liste) {
			U objRef = obj;
			fininstance = false;
			debut = false;
			for(U objduplique : liste) {
				if(objduplique.equals(objRef) && !fininstance) {
					debut = true;
				}else if(!objduplique.equals(objRef)) {
					fininstance = true;
				}else if (objduplique.equals(objRef) && fininstance) {
					return false;
				}
			}
		}
		return true;
	}

}
