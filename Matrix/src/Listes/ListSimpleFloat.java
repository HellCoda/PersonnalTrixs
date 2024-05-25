package Listes;

import Donnes.ValeurFloat;

public class ListSimpleFloat implements IListFloat {

	private ValeurFloat[] valeurs;
	private int tailleActuelle;

	public ListSimpleFloat(int capaciteInitiale) {
		valeurs = new ValeurFloat[capaciteInitiale];
		tailleActuelle = 0;
	}

	@Override
	public void ajouter(ValeurFloat valeur) {
		if (tailleActuelle >= valeurs.length) {
			agrandir();
		}
		valeurs[tailleActuelle] = valeur;
		tailleActuelle++;
	}

	private void agrandir() {
		ValeurFloat[] nouveauTableau = new ValeurFloat[valeurs.length * 2];
		for (int i = 0; i < valeurs.length; i++) {
			nouveauTableau[i] = valeurs[i];
		}
		valeurs = nouveauTableau;
	}

	@Override
	public ValeurFloat obtenir(int index) {
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
