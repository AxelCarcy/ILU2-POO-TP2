package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentiteClient(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur 
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			
			String[] vendeurQuiVendProduit = controlAcheterProduit.trouverVendeurs(produit);
			if (vendeurQuiVendProduit == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				System.out.println("Chez quel commerçant voulez-vous acheter des " + produit);
				for(int i = 0; i < vendeurQuiVendProduit.length; i++)
					System.out.println((i + 1) + " -" + vendeurQuiVendProduit[i]);
				int numeroVendeur;
				do {
					numeroVendeur = Clavier.entrerEntier("") -1;
				} while(0 < numeroVendeur && numeroVendeur <= vendeurQuiVendProduit.length);
				
				String vendeur = vendeurQuiVendProduit[numeroVendeur];
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeur);
				
				System.out.println("Bonjour " + nomAcheteur);
				int nbProduitDemander = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int quantiteRestant = controlAcheterProduit.acheterProduit(vendeur, nbProduitDemander);
				if(quantiteRestant == 0) {
					System.out.println(nomAcheteur + " veut acheter " 
							+ nbProduitDemander + " " + produit 
								+ ", malheuresement il n'y en a plus !");
					
				} else if(quantiteRestant < nbProduitDemander) {
					System.out.println(nomAcheteur + " veut acheter " 
							+ nbProduitDemander + " " + produit 
								+ ", malheuresement " + vendeur 
									+ " n'en a plus que " + quantiteRestant + ". " 
										+ nomAcheteur + " achetè tout le stock de " + vendeur);
				} else {
					System.out.println(nomAcheteur + " achète " 
							+ nbProduitDemander + " " + produit + " à " + vendeur);
				}
			}
		}
	}
}
