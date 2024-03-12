package histoire;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ScenarioTestException {
	
	
	public static void main(String[] args) {
		Village village = new Village("Village Gaulois", 10, 5);
		Etal etal = new Etal();
		etal.libererEtal();
		
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Druide druide = new Druide("Panoramix", 2, 5, 10);
		Gaulois obelix = null;
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois assurancetourix = new Gaulois("Assurancetourix", 2);
		Gaulois bonemine = new Gaulois("Bonemine", 7);
		
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(assurancetourix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(druide);
		village.ajouterHabitant(abraracourcix);
		
		village.installerVendeur(bonemine, "Bonbon", 10);
		Etal etalBb = village.rechercherEtal(bonemine);
	    System.out.println(etalBb.acheterProduit(5, obelix));
		
		
		System.out.println("Fin du test\n");
	}
}
