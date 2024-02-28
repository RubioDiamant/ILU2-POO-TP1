package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		marche = new Marche(nbEtals);
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	 public String installerVendeur(Gaulois vendeur, String produit,int nbProduit) {
		 StringBuilder chaine = new StringBuilder();
		 chaine.append(vendeur + " cherche un endroit pour vendre " + nbProduit + " " + produit +"\n");
		 int indiceEtal = marche.trouverEtalLibre();
		 if(indiceEtal == -1) {
			 chaine.append(vendeur + " n'a pas trouvé d'etal libre !\n");
		 }
		 else {
			 marche.utiliserEtal(indiceEtal, vendeur, produit, nbProduit);
			 chaine.append("Le vendeur "+ vendeur + " vend des " + produit + " à l'etal n." + indiceEtal + ".\n\n");
		 }
		 return chaine.toString();
		 
	 }
	 
	 public String rechercherVendeursProduit(String produit) {
		 StringBuilder chaine = new StringBuilder();
		 Etal[] etalTab = marche.trouverEtals(produit);
		 int nombreEtalTrouve = 0;
		 for(int i = 0; i< etalTab.length; i++) {
			 if(etalTab[i] != null) {
				 nombreEtalTrouve ++;
			 }
		 }
		 if(nombreEtalTrouve == 0) {
			 chaine.append("Il n'y a pas de vendeur qui propose des " + produit + " au marché.\n");
		 }else if (nombreEtalTrouve == 1) {
			 chaine.append("Seul le vendeur " + etalTab[0].getVendeur() + " propose des " + produit + " au marché.\n");
		 }else {
			 chaine.append("Les vendeurs qui proposent des " + produit + " sont :\n");
			 for(int i = 0; i < nombreEtalTrouve; i++) {
				 chaine.append("- " + etalTab[i].getVendeur() + "\n");
			 }
		 }
		 return chaine.toString();
	 }
}