package Tableaux;

import Donnes.ValeurFloat;

public interface ITableausimpleFloat {

	void ajouter(Float valeur);

	ValeurFloat obtenir(int index);

	void supprimer(int index);

	int taille();

	void afficher();
}
