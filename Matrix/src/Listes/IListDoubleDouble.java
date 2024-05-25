package Listes;

import java.util.List;

import Donnes.ValeurDouble;

public interface IListDoubleDouble {

	int taille();

	void afficher();

	void ajouterLigne(List<ValeurDouble> nouvelleLigne);

	ValeurDouble obtenir(int ligne, int colonne);

	void supprimerLigne(int ligne);
}
