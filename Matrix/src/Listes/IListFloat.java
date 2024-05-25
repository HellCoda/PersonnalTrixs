package Listes;

import Donnes.ValeurFloat;

public interface IListFloat {

	ValeurFloat obtenir(int index);

	void supprimer(int index);

	int taille();

	void afficher();

	void ajouter(ValeurFloat valeur);

	
}
