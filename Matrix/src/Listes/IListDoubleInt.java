package Listes;

import java.util.List;

import Donnes.ValeurInt;

public interface IListDoubleInt {

	int taille();

	void afficher();

	void ajouterLigne(List<ValeurInt> nouvelleLigne);

	ValeurInt obtenir(int ligne, int colonne);

	void supprimerLigne(int ligne);
}
