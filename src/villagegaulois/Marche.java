package villagegaulois;

import personnages.Gaulois;

public class Marche {
	private Etal[] etals;
	private int nbEtal;
	
	public Marche(int nombreEtals) {
		etals = new Etal[nombreEtals];
		nbEtal = nombreEtals;
		for(int i = 0; i<nbEtal; i++) {
			etals[i] = new Etal();
		}
	}
	
	public int getNbEtals() {
		return nbEtal;
	}

	
	public void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
		if(indiceEtal < etals.length) {
			etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}
		else {
			System.out.println("Indice invalide !");
		}
		
	}
	
	public int trouverEtalLibre(){
		for(int i = 0; i<etals.length; i++) {
			if(!etals[i].isEtalOccupe()) {
				return i;
			}
		}
		return -1;
	}
	
	public Etal[] trouverEtals(String produit){
		int indice = 0;
		Etal etalVente[] = new Etal[etals.length];
		for(int i = 0; i<etals.length; i++) {
			if(etals[i].isEtalOccupe()) {
				if(etals[i].contientProduit(produit)){
					etalVente[indice] = etals[i];
					indice++;
				}
			}
		}
		return etalVente;
	}
	
	public Etal trouverVendeur(Gaulois gaulois) {
		for(int i = 0; i<etals.length; i++) {
			if(etals[i].getVendeur() == gaulois) {
				return etals[i];
			}
		}
		return null;
	}
	
	public String afficherMarche() {
		int etalVide = 0;
		StringBuilder chaine = new StringBuilder();
		for(int i = 0; i<etals.length; i++) {
			if(etals[i].isEtalOccupe()) {
				chaine.append(etals[i].afficherEtal());
			}
			else{
				etalVide++;
			}
		}
		if(etalVide != 0) {
			chaine.append("Il reste " + etalVide + " �tals non utilis�s dans le march�.\n");
		}
		return chaine.toString();
	}
		
}
