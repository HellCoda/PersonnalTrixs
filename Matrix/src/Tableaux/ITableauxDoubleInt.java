package Tableaux;

import Donnes.ValeurInt;

public interface ITableauxDoubleInt {

	int taille();

	void afficher();

	void ajouterLigne(ValeurInt[] nouvelleLigne);

	ValeurInt obtenir(int ligne, int colonne);

	void supprimerLigne(int ligne);
}
