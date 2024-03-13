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

	public String afficherVillageois() throws VillageSansChefException {
		StringBuilder chaine = new StringBuilder();
		if(chef == null) {
			throw new VillageSansChefException("Ce village n'a pas de chef\n");
		}
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	 public String installerVendeur(Gaulois vendeur, String produit,int nbProduit) {
		 StringBuilder chaine = new StringBuilder();
		 chaine.append(vendeur.getNom() + " cherche un endroit pour vendre " + nbProduit + " " + produit +"\n");
		 int indiceEtal = marche.trouverEtalLibre();
		 if(indiceEtal == -1) {
			 chaine.append(vendeur + " n'a pas trouv� d'etal libre !\n");
		 }
		 else {
			 marche.utiliserEtal(indiceEtal, vendeur, produit, nbProduit);
			 chaine.append("Le vendeur "+ vendeur.getNom() + " vend des " + produit + " � l'etal n." + (indiceEtal + 1) + ".\n\n");
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
			 chaine.append("Il n'y a pas de vendeur qui propose des " + produit + " au march�.\n");
		 }else if (nombreEtalTrouve == 1) {
			 chaine.append("Seul le vendeur " + etalTab[0].getVendeur().getNom() + " propose des " + produit + " au march�.\n");
		 }else {
			 chaine.append("Les vendeurs qui proposent des " + produit + " sont :\n");
			 for(int i = 0; i < nombreEtalTrouve; i++) {
				 chaine.append("- " + etalTab[i].getVendeur().getNom() + "\n");
			 }
		 }
		 return chaine.toString();
	 }
	 
	 public Etal rechercherEtal(Gaulois vendeur) {
		 Etal etalGaulois = marche.trouverVendeur(vendeur);
		 return etalGaulois;
	 }
	 
	 public String partirVendeur(Gaulois vendeur) {
		 Etal etalLibere = rechercherEtal(vendeur);
		 return etalLibere.libererEtal();
	 }
	 
	 public String afficherMarche() {
		 StringBuilder chaine = new StringBuilder();
		 chaine.append("Le marche du village " + nom + " possède plusieurs étals :\n");
		 chaine.append(marche.afficherMarche() + "\n\n");
		 return chaine.toString();
	 }
} 