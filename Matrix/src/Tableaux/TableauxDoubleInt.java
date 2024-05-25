package Tableaux;

import Donnes.ValeurInt;

public class TableauxDoubleInt implements ITableauxDoubleInt{

	private ValeurInt[][] valeurs;
	private int tailleActuelle; // Pour garder une trace du nombre de lignes actuellement dans le tableau
	private int sousTailleActuelle; // Pour garder une trace du nombre de colonnes

	public TableauxDoubleInt(int taille, int sousTaille) {
		this.valeurs = new ValeurInt[taille][sousTaille];
		this.tailleActuelle = 0;
		this.sousTailleActuelle = sousTaille;
	}

	@Override
	public void ajouterLigne(ValeurInt[] nouvelleLigne) {
		if (tailleActuelle < valeurs.length) {
			valeurs[tailleActuelle] = nouvelleLigne;
			tailleActuelle++;
		} else {
			System.out.println("Le tableau est plein. Impossible d'ajouter plus de lignes.");
		}
	}

	@Override
	public ValeurInt obtenir(int ligne, int colonne) {
		if (ligne >= 0 && ligne < tailleActuelle && colonne >= 0 && colonne < sousTailleActuelle) {
			return valeurs[ligne][colonne];
		} else {
			System.out.println("Index invalide.");
			return null;
		}
	}

	@Override
	public void supprimerLigne(int ligne) {
		if (ligne >= 0 && ligne < tailleActuelle) {
			for (int i = ligne; i < tailleActuelle - 1; i++) {
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
			System.out.print("[");
			for (int j = 0; j < sousTailleActuelle; j++) {
				if (valeurs[i][j] != null) {
					System.out.print(valeurs[i][j].getValeur());
					if (j < sousTailleActuelle - 1) {
						System.out.print(", ");
					}
				}
			}
			System.out.print("]");
			if (i < tailleActuelle - 1) {
				System.out.print(",\n ");
			}
		}
		System.out.println("]");
	}

}
