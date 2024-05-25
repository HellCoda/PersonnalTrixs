package Tableaux;

import Donnes.ValeurDouble;

public interface ITableausimpleDouble {


	void ajouter(double valeur);

	ValeurDouble obtenir(int index);

	void supprimer(int index);

	int taille();

	void afficher();
}
