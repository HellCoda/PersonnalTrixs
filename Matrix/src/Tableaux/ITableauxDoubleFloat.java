package Tableaux;

import Donnes.ValeurFloat;
import Donnes.ValeurInt;

public interface ITableauxDoubleFloat {

	void ajouter(Float valeur);

	ValeurInt obtenir(int ligne, int colonne);

	void supprimer(int index);

	int taille();

	void afficher();

	void ajouterLigne(ValeurFloat[] nouvelleLigne);
}
