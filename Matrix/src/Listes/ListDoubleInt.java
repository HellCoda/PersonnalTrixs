package Listes;

import java.util.ArrayList;
import java.util.List;

import Donnes.ValeurInt;

public class ListDoubleInt implements IListDoubleInt {

	private List<List<ValeurInt>> valeurs;
	private int sousTailleActuelle; // Pour garder une trace du nombre de colonnes

	public ListDoubleInt(int sousTaille) {
		this.valeurs = new ArrayList<>();
		this.sousTailleActuelle = sousTaille;
	}

	@Override
	public void ajouterLigne(List<ValeurInt> nouvelleLigne) {
		if (nouvelleLigne.size() == sousTailleActuelle) {
			valeurs.add(nouvelleLigne);
		} else {
			System.out.println("La taille de la nouvelle ligne ne correspond pas à la sous-taille actuelle.");
		}
	}

	@Override
	public ValeurInt obtenir(int ligne, int colonne) {
		if (ligne >= 0 && ligne < valeurs.size() && colonne >= 0 && colonne < sousTailleActuelle) {
			List<ValeurInt> ligneListe = valeurs.get(ligne);
			return ligneListe.get(colonne);
		} else {
			System.out.println("Index invalide.");
			return null;
		}
	}

	@Override
	public void supprimerLigne(int ligne) {
		if (ligne >= 0 && ligne < valeurs.size()) {
			valeurs.remove(ligne);
		} else {
			System.out.println("Index invalide.");
		}
	}

	@Override
	public int taille() {
		return valeurs.size();
	}

	@Override
	public void afficher() {
		System.out.print("[");
		for (int i = 0; i < valeurs.size(); i++) {
			System.out.print("[");
			List<ValeurInt> ligneListe = valeurs.get(i);
			for (int j = 0; j < ligneListe.size(); j++) {
				if (ligneListe.get(j) != null) {
					System.out.print(ligneListe.get(j).getValeur());
					if (j < ligneListe.size() - 1) {
						System.out.print(", ");
					}
				}
			}
			System.out.print("]");
			if (i < valeurs.size() - 1) {
				System.out.print(",\n ");
			}
		}
		System.out.println("]");
	}
}
