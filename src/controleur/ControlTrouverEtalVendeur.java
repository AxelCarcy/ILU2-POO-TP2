package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Etal etal = null;
		Gaulois trouverGaulois = village.trouverHabitant(nomVendeur);
		if (trouverGaulois != null) {
			etal = village.rechercherEtal(trouverGaulois);
		}
		return etal;
	}
}
