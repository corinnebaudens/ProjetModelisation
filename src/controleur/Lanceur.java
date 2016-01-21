package controleur;
import modeles.Modele;

import vues.Vue;

public class Lanceur {
	/*
	 * Lancement de l'application en mode MVC :
	 * 1- nouveau modèle;
	 * 2- nouveau contrôleur avec le modèle en paramètre
	 * 3- nouvelle fenêtre avec le contrôleur en paramètre
	 */
	public static void main(String[] args) {
		Modele modele = new Modele();
		Controleur controleur = new Controleur(modele);
		Vue vue = new Vue(controleur, modele);	// il faut que l'instanciation de la vue
												// prenne une instance de Controleur en paramètre
	}
}