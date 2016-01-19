package modeles;

import java.util.ArrayList;
import java.util.Observable;

public class Modele extends Observable{

	Double [][] data = {{1.0, 5.0}, {2.0, 3.0}, {4.0, 1.0}, {5.0, 2.5}, {6.0, 9.0}};
	ArrayList<Coord> dataBase;
	
	public Modele(){
		this.dataBase = new ArrayList<>();
	}
	
	public void setData(String ticker, String dateDebut, String dateFin){
		Download dl = new Download("AI.PA", 2011, 1, 1, 2015, 12, 31);
		Historique test = ConversionObjectCSV.CSVToHistorique(dl.getFichier());
		int taille = test.taille();
		Double[][] vector = new Double[taille][2];
		
		for (int ligne = 0 ; ligne < taille ; ligne++){
			// Double n'est pas double :)
			Double ligneDouble = Double.valueOf(ligne);
			vector[ligne][0] = ligneDouble;
			// test.taille() - ligne - 1 pour afficher la courbe dans le bon sens
			// du coup, problème possible avec la droite de régression linéaire
			vector[ligne][1] = test.getOpenList().get(taille - ligne - 1);
		}
		/* méthode à compléter pour l'utilisation d'une arraylist (permet beaucoup + de souplesse !)
		if(!dataBase.isEmpty()) dataBase.clear();*/
		
		
		
//		Double[][] vector = {{1.0, 5.0}, {2.0, 3.0}, {4.0, 1.0}, {5.0, 2.5}, {6.0, 9.0}};
		setChanged();
		notifyObservers();
		data = vector;
		// ajouter mise à jour de l'arrayList
	}

	public Double[][] getData() {
		return data;
	}

	
}