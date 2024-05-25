package Tableaux;

import Commun.Affichage;
import Donnes.ValeurDouble;
import Donnes.ValeurInt;

public class TableauxDoubleDouble implements ITableauxDoubleDouble, Affichage {

	private ValeurInt[][] valeurs;
	private int tailleActuelle; // Pour garder une trace du nombre de lignes actuellement dans le tableau
	private int sousTailleActuelle; // Pour garder une trace du nombre de colonnes

	public TableauxDoubleDouble(int taille, int sousTaille) {
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
				System.out.print(valeurs[i][j]);
				if (j < sousTailleActuelle - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			if (i < tailleActuelle - 1) {
				System.out.print(",\n ");
			}
		}
		System.out.println("]");
	}


	@Override
	public void supprimer(int index) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ajouter(Double valeur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterLigne(ValeurDouble[] nouvelleLigne) {
		// TODO Auto-generated method stub
		
	}

}
