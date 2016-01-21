package modeles;

import java.util.GregorianCalendar;

public class MovingAverage {
	

	/**
	 * Calcul de la moyenne mobile de paramètre order
	 * @param hist historique de référence
	 * @param order nombre de jour pour la moyenne
	 * @return historique contenant les moyennes mobiles
	 */
	public static Historique movingAverage(Historique hist, int order) {
		Historique result = new Historique();
		
		// Boucle sur les données de réference (taille de 'hist' - 'order' lignes)
		int boucle = hist.taille() - order;
		String ticker = hist.getTicker();
		Cotation tempCot;
		
		for (int index = 0 ; index < boucle ; index++) {
			GregorianCalendar tempDate = new GregorianCalendar();
			double open = 0, high = 0, low = 0, close = 0, adjusted = 0;
			int volume = 0;
			long dateInMilliS = 0;
			// Somme des 'order' valeurs pour les différents champs
			for (int i = index ; i < (index + order) ; i++) {
				tempCot = hist.getCotation(i);
				dateInMilliS += tempCot.getDate().getTimeInMillis();
				open += tempCot.getOpen();
				high += tempCot.getHigh();
				low += tempCot.getLow();
				close += tempCot.getClose();
				volume += tempCot.getVolume();
				adjusted += tempCot.getAdjusted();
			}
			// Calcul des moyennes pour les différents champs
			dateInMilliS /= order;
			tempDate.setTimeInMillis(dateInMilliS);
			open /= order;
			high /= order;
			low /= order;
			close /= order;
			volume /= order;
			adjusted /= order;
			// Ajout des valeurs obtenues
			result.ajouter(new Cotation(ticker, tempDate, open, high, low, close, volume, adjusted));
		}
		return result;
	}
}