package controleur;
import modeles.Test;
import vues.Demarrage;

public class Lanceur {
	/*
	 * Lancement de l'application en mode MVC :
	 * 1- nouveau modèle;
	 * 2- nouveau contrôleur avec le modèle en paramètre
	 * 3- nouvelle fenêtre avec le contrôleur en paramètre
	 */

	public static void main(String[] args) {

		Test modele = new Test();
		Controleur controleur = new Controleur(modele);
		Demarrage vue = new Demarrage(controleur);	// il faut que l'instanciation de la vue
													// prenne une instance de Controleur en paramètre
	}

}
