package Tableaux;

import Donnes.ValeurInt;

public interface ITableausimpleInt {

	void ajouter(ValeurInt valeur);

	ValeurInt obtenir(int index);

	void supprimer(int index);

	int taille();

	void afficher();
	
}
