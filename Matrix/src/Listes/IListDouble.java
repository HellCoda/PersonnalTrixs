package Listes;

import Donnes.ValeurDouble;

public interface IListDouble {

	ValeurDouble obtenir(int index);

	void supprimer(int index);

	int taille();

	void afficher();

	void ajouter(ValeurDouble valeur);
}
