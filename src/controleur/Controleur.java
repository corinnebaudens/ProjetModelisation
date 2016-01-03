package controleur;
import java.io.File;

import modeles.Test;

public class Controleur {
	/*
	le contrôleur intercepte les actions de l'utilisateur
	après vérification, il envoit les données au modèle
	
	Nous retrouvons donc en attributs les données traitées par le Controleur, que le modèle récupérera :
	*/
	protected Test modele;			// instance du modèle (basée pour le moment sur la classe Test)

	/* récupération, soit d'un fichier : */
	protected File csv;	
	
	/*	...soit des données de base pour la classe Download :
	(=> on pourrait, après vérification, envoyer une seule String déjà concaténée à la classe "Download")	*/
	protected String ticker;				// String du titre sélectionné par clic (et validé)
	protected int startYear, startMonth, startDay;	// données pour requête au site boursier
	protected int endYear, endMonth, endDay;		// données pour requête au site boursier

	protected String traitement;			// String du traitement sélectionné par clic (et validé)	

	
	
	public Controleur(Test bourse){					// constructeur du contrôleur
		this.modele=bourse;
		
	}
	
	public void control(){
		/*
		 * si le titre sélectionné est valide, on envoit au modèle
		 * si le traitement sélectionné est valide, on envoit au modèle
		*/
	}
	
}
