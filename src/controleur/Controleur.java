package controleur;
import java.io.File;
import java.util.ArrayList;

import modeles.Coord;
import modeles.Modele;

public class Controleur {
	/*
	le contrôleur intercepte les actions de l'utilisateur. Après vérification, il envoit les données au modèle	
	*/
	protected Modele modele;

	public Controleur(Modele bourse){	// constructeur
		this.modele=bourse;		
	}
	
	public void transfertDemande(String ticker, int anneeD, int moisD, int jourD, int anneeF, int moisF, int jourF){
		modele.recupDonnees(ticker, anneeD, moisD, jourD, anneeF, moisF, jourF);
	}
	
/*	public ArrayList<Coord> graphRequest (String ticker, int anneeD, int moisD, int jourD, int anneeF, int moisF, int jourF){		// todo : vérifier que la chaîne de caractères est valide
		System.out.println("classe atteinte : Controleur");
		modele.setData(ticker, anneeD, moisD, jourD, anneeF, moisF, jourF);
		return modele.getData();
	}
*/	
	public ArrayList<Coord> dataRequest(){
		return modele.getData();
	}

	public void control(){
		/*
		 * si le titre sélectionné est valide, on envoit au modèle
		 * si le traitement sélectionné est valide, on envoit au modèle
		*/
	}	
}