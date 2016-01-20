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
	

	public void graphRequest (String ticker, String dateDebut, String dateFin){
		// todo : vérifier que la chaîne de caractères est valide
		modele.setData(ticker, dateDebut, dateFin);

	}
	
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