package histoire;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ScenarioTestException {
	
	
	public static void main(String[] args) {
		try{
			Etal etal1 = new Etal();
			etal1.libererEtal();
		}catch(NullPointerException e) {
			System.err.println(e.getMessage());
		}
		
		
		try {
			Etal etal2 = new Etal();
			etal2.acheterProduit(5, null);
		} catch(NullPointerException e){
			System.err.println(e.getMessage());
		}
		
		try {
			Etal etal3 = new Etal();
			etal3.acheterProduit(-5, new Gaulois("Asterix", 10));
		} catch(IllegalArgumentException e){
			System.err.println(e.getMessage());
		}
		
		try {
			Etal etal4 = new Etal();
			etal4.acheterProduit(5, new Gaulois("Obelix", 10));
		} catch(IllegalStateException e){
			System.err.println(e.getMessage());
		}
		
		
		System.out.println("Fin du test\n");
	}
}
