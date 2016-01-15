package testGraph;

import modeles.Test;
import vues.Demarrage;
import controleur.Controleur;

public class Main {

	public static void main(String[] args) {
		Test modele = new Test();
		Controleur controleur = new Controleur(modele);
		new Affichage (controleur, modele);
	}

}
