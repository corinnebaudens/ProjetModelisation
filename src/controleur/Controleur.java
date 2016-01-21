package controleur;
import java.util.ArrayList;

import modeles.Coord;
import modeles.Modele;

/**
 * Intercepte les actions de l'utilisateur. Après vérification, il envoit les données au modèle	
 * @author C. Baudens, V. Dubromez, G. Durand
 * 
 */
public class Controleur {

	protected Modele modele;

	public Controleur(Modele bourse){
		this.modele=bourse;		
	}
	
	/**
	 * Transfère la demande de l'utilisateur suite à la sélection des titres et dates
	 * @param ticker le titre
	 * @param anneeD année initiale
	 * @param moisD mois initial
	 * @param jourD jour initial
	 * @param anneeF année finale
	 * @param moisF mois final
	 * @param jourF jour final
	 */
	public void transfertDemande(String ticker, int anneeD, int moisD, int jourD, int anneeF, int moisF, int jourF){
		modele.recupDonnees(ticker, anneeD, moisD, jourD, anneeF, moisF, jourF);
	}
	
	/**
	 * Transfère la demande de l'utilisateur suite au choix d'un traimement
	 * @param process le nom du traitement choisi
	 */
	public void transfertDemande(String process){
		modele.recupDonnees(process);
	}
	

	public ArrayList<Coord> dataRequest(){
		return modele.getData();
	}

	public void control(){
		// méthode à compléter pour contrôle plus précis des données transmises par l'utilisateur
	}	
}