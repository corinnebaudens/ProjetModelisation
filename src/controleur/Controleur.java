package controleur;
import java.io.File;

import modeles.Modele;

public class Controleur {
	/*
	le contrôleur intercepte les actions de l'utilisateur. Après vérification, il envoit les données au modèle	
	*/

	protected Modele modele;

	public Controleur(Modele bourse){	// constructeur
		this.modele=bourse;		
	}
	

	public Double[][] graphRequest (String ticker, String dateDebut, String dateFin){
		
		// vérifier que la chaîne de caractères est valide
		
		return modele.getData(ticker, dateDebut, dateFin);				
	}
	
	
	public void control(){
		/*
		 * si le titre sélectionné est valide, on envoit au modèle
		 * si le traitement sélectionné est valide, on envoit au modèle
		*/
	}	
}