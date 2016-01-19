package testGraph;

import modeles.Modele;
import vues.Demarrage;
import controleur.Controleur;

public class TestMain {

	public static void main(String[] args) {
		Modele modele = new Modele();
		Controleur controleur = new Controleur(modele);
		new Affichage (controleur, modele);
		
		
	}

}
