package Commun;

import Donnes.ValeurFloat;
import Donnes.ValeurInt;

public interface Affichage {

	void afficher();

	void ajouterLigne(ValeurInt[] nouvelleLigne);

	ValeurInt obtenir(int ligne, int colonne);

	void supprimerLigne(int ligne);

}
