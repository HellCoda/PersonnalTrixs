package Listes;

import Donnes.ValeurInt;

public interface IListInt {

	void ajouter(ValeurInt valeur);

	ValeurInt obtenir(int index);

	void supprimer(int index);

	int taille();

	void afficher();
}
