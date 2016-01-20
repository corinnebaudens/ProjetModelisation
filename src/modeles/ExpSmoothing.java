package modeles;

import java.util.ArrayList;

public class ExpSmoothing {
	
	// Faire une méthode qui retourne une Coord, ou qui ajoute directement au set data la prévision ?
	/**
	 * Méthode de calcul de lissage exponentiel simple. Un coefficient de 0.4 est bon
	 * @param data le jeu de données
	 * @param alpha le coefficient de lissage
	 * @return un objet Coord contenant la prévision à l'instant t+1
	 */
	public static Coord simpleExpSmoothing (ArrayList<Coord> data, double alpha) {
		int index, dataSize = data.size();
		int x = 100;
		double a = alpha;
		
		// Nombre de valeurs à prendre en compte, arbitrairement choisi à x (si possible)
		if (dataSize < x)
			index = 0;
		else
			index = dataSize - x;
		
		//initialisation et calculs successifs pour obtenir le yPrev final
		double yPrev = data.get(index).getY();
		for (int i = index + 1 ; i < dataSize ; i++) {
			yPrev = a * data.get(i).getY() + (1 - a) * yPrev;
		}

		return new Coord(data.get(dataSize - 1).getX() + 1, yPrev, "");
	}
	
	
	public static Coord doubleExpSmoothing () {
		// TO DO
		return null;
	}
}
