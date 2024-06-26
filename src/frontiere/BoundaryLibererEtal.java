package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String etalOccupe[] = controlLibererEtal.libererEtal(nomVendeur);
			System.out.println("Vous avez vendu " + etalOccupe[4] 
					+ " sur " + etalOccupe[3] + " " + etalOccupe[2] + ".");
			System.out.println("En revoir " + nomVendeur + ", passez une bonne journée.");
		}
	}
}
