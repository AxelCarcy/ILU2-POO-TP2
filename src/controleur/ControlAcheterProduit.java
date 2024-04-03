package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentiteClient(String nomClient) {
		return controlVerifierIdentite.verifierIdentite(nomClient);
	}
	
	public boolean trouverProduit (String produit) {
		return village.rechercherVendeursProduit(produit) != null;
	}
	
	public String [] trouverVendeurs(String produit) {
		String [] listeVendeurs = null;
		if (village.rechercherVendeursProduit(produit) == null)
			return null;
		int nbVendeurs = village.rechercherVendeursProduit(produit).length;
		if (nbVendeurs > 0) {
			listeVendeurs = new String[nbVendeurs];
			for(int i = 0; i < nbVendeurs; i++) {
				listeVendeurs[i] = village.rechercherVendeursProduit(produit)[i].getNom();
			}
		}
		return listeVendeurs;
	}
	
	public int acheterProduit(String nomVendeur, int quantiteAcheter) {
		int nbProduitAcheter = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantiteAcheter);
		return nbProduitAcheter;
	}
	
	
}
