package modeles;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

public class Modele extends Observable{

	Double [][] data = {{1.0, 5.0}, {2.0, 3.0}, {4.0, 1.0}, {5.0, 2.5}, {6.0, 9.0}};
	ArrayList<Coord> dataBase;;	
	
	public Modele(){
		this.dataBase = new ArrayList<>();
	}
	
	private void ajouterCoord(double x, double y, String z){
		this.dataBase.add(new Coord(x, y, z));
	}
	
	public void setData(String ticker, String dateDebut, String dateFin){
		Download dl = new Download("AI.PA", 2011, 1, 1, 2015, 12, 31);
		Historique test = ConversionObjectCSV.CSVToHistorique(dl.getFichier());
		
//		// Creation d'un objet Historique à partir d'un fichier csv présent sur le disque
//		String nom = ticker + "-" + dateDebut.replaceAll("-", "") + "-" + dateFin.replaceAll("-", "");
//		Historique test = ConversionObjectCSV.CSVToHistorique(new File(nom));
		
		int taille = test.taille();
//		Double[][] vector = new Double[taille][2];
//		
//		for (int ligne = 0 ; ligne < taille ; ligne++){
//			// Double n'est pas double :)
//			Double ligneDouble = Double.valueOf(ligne);
//			vector[ligne][0] = ligneDouble;
//			// test.taille() - ligne - 1 pour afficher la courbe dans le bon sens
//			// du coup, problème possible avec la droite de régression linéaire
//			vector[ligne][1] = test.getOpenList().get(taille - ligne - 1);
//		}
		
		
		// méthode à compléter pour l'utilisation d'une arraylist (permet beaucoup + de souplesse !)
		if(!dataBase.isEmpty()) dataBase.clear();
		for (int ligne = 0 ; ligne < taille ; ligne++){
			ajouterCoord(ligne, test.getOpenList().get(taille - ligne - 1), test.getCotation(taille - ligne - 1).getDateFormatted());
		}
		
		
		
//		Double[][] vector = {{1.0, 5.0}, {2.0, 3.0}, {4.0, 1.0}, {5.0, 2.5}, {6.0, 9.0}};
		setChanged();
		notifyObservers();
		// data = vector;
		// ajouter mise à jour de l'arrayList
	}

	public Double[][] getDdata() {
		return data;
	}
	
	public ArrayList<Coord> getData() {
		// remplissage temporaire pour test
		// à supprimer
//		dataBase.add(new Coord(1.0, 3.0, ""));
//		dataBase.add(new Coord(2.0, 1.0, ""));
//		dataBase.add(new Coord(3.0, 2.5, ""));
//		dataBase.add(new Coord(4.0, 9.0, ""));
//		dataBase.add(new Coord(5.0, 5.0, ""));
//		dataBase.add(new Coord(6.0, 8.0, ""));
//		dataBase.add(new Coord(7.0, 2.0, ""));
		return dataBase;
	}

	
}