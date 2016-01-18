package modeles;

import java.util.Observable;

public class Test extends Observable{

	public Test(){
		
	}
	
	public Double[][] getData(){
//		Download dl = new Download("AI.PA", 2011, 1, 1, 2015, 12, 31);
//		Historique test = ConversionObjectCSV.CSVToHistorique(dl.getFichier());
//		int taille = test.taille();
//		Double[][] vector = new Double[taille][2];
//		for (int ligne = 0 ; ligne < taille ; ligne++){
//			// Double n'est pas double :)
//			Double ligneDouble = Double.valueOf(ligne);
//			vector[ligne][0] = ligneDouble;
//			// test.taille() - ligne - 1 pour afficher la courbe dans le bon sens
//			// du coup, problème possible avec la droite de régression linéaire
//			vector[ligne][1] = test.getOpenList().get(taille - ligne - 1);
//		}
		
		Double[][] vector = {{1.0, 5.0}, {2.0, 3.0}, {4.0, 1.0}, {5.0, 2.5}, {6.0, 9.0}};
		return vector;
	}
}
