package Tableaux;


import Donnes.ValeurDouble;

public class TableauxSimpleDouble implements ITableausimpleDouble {

	private ValeurDouble[] valeurs;
	private int tailleActuelle; // Pour garder une trace du nombre d'éléments actuellement dans le tableau

	public TableauxSimpleDouble(int taille) {
		this.valeurs = new ValeurDouble[taille];
		this.tailleActuelle = 0;
	}

	public void ajouter(ValeurDouble valeurdouble) {
		if (tailleActuelle < valeurs.length) {
			valeurs[tailleActuelle] = valeurdouble;
			tailleActuelle++;
		} else {
			System.out.println("Le tableau est plein. Impossible d'ajouter plus de valeurs.");
		}
	}

	public ValeurDouble obtenir(int index) {
		if (index >= 0 && index < tailleActuelle) {
			return valeurs[index];
		} else {
			System.out.println("Index invalide.");
			return null;
		}
	}

	public void supprimer(int index) {
		if (index >= 0 && index < tailleActuelle) {
			for (int i = index; i < tailleActuelle - 1; i++) {
				valeurs[i] = valeurs[i + 1];
			}
			valeurs[tailleActuelle - 1] = null;
			tailleActuelle--;
		} else {
			System.out.println("Index invalide.");
		}
	}

	public int taille() {
		return tailleActuelle;
	}

	public void afficher() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < tailleActuelle; i++) {
			if (valeurs[i] != null) {
				sb.append(valeurs[i]);
				if (i < tailleActuelle - 1) {
					sb.append(", ");
				}
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	
	public void ajouter(Double valeur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouter(double valeur) {
		// TODO Auto-generated method stub
		
	}

}
