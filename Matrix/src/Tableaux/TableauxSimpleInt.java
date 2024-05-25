package Tableaux;

import Donnes.ValeurInt;

public class TableauxSimpleInt implements ITableausimpleInt {
	
	private ValeurInt[] valeurs;
	private int tailleActuelle; // Pour garder une trace du nombre d'éléments actuellement dans le tableau

	public TableauxSimpleInt(int taille) {
		this.valeurs = new ValeurInt[taille];
		this.tailleActuelle = 0;
	}

	@Override
	public void ajouter(ValeurInt valeur) {
		if (tailleActuelle < valeurs.length) {
			valeurs[tailleActuelle] = valeur;
			tailleActuelle++;
		} else {
			System.out.println("Le tableau est plein. Impossible d'ajouter plus de valeurs.");
		}
	}

	@Override
	public ValeurInt obtenir(int index) {
		if (index >= 0 && index < tailleActuelle) {
			return valeurs[index];
		} else {
			System.out.println("Index invalide.");
			return null;
		}
	}

	@Override
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

	@Override
	public int taille() {
		return tailleActuelle;
	}

	@Override
	public void afficher() {
		System.out.print("[");
		for (int i = 0; i < tailleActuelle; i++) {
			if (valeurs[i] != null) {
				System.out.print(valeurs[i].getValeur());
				if (i < tailleActuelle - 1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println("]");
	}
}
