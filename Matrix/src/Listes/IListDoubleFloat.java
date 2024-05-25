package Listes;

import java.util.List;

import Donnes.ValeurFloat;

public interface IListDoubleFloat {

	int taille();

	void afficher();

	void ajouterLigne(List<ValeurFloat> nouvelleLigne);

	ValeurFloat obtenir(int ligne, int colonne);

	void supprimerLigne(int ligne);
}
