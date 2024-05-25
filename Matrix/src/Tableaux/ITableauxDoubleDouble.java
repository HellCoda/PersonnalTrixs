package Tableaux;

import Donnes.ValeurDouble;
import Donnes.ValeurInt;

public interface ITableauxDoubleDouble {

	void ajouter(Double valeur);

	ValeurInt obtenir(int ligne, int colonne);

	void supprimer(int index);

	int taille();

	void afficher();

	void ajouterLigne(ValeurDouble[] nouvelleLigne);
}
