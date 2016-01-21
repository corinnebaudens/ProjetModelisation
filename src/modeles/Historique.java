package modeles;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Gestion d'un 'historique' de 'cotation's
 * @author Vincent
 *
 */
public class Historique {
	
	// attributs
	private String ticker;
	private List<GregorianCalendar> date;
	private List<Double> open;
	private List<Double> high;
	private List<Double> low;
	private List<Double> close;
	private List<Integer> volume;
	private List<Double> adjusted;
	
	// constructeurs
	public Historique() {
		this.ticker = null;
		this.date = new ArrayList<>();
		this.open = new ArrayList<>();
		this.high = new ArrayList<>();
		this.low = new ArrayList<>();
		this.close = new ArrayList<>();
		this.volume = new ArrayList<>();
		this.adjusted = new ArrayList<>();
	}
	
	// Accesseurs
	/**
	 * @return le nombre de valeurs du titre
	 */
	public int taille() {
		return date.size();
	}
	
	/**
	 * @return le ticker du titre
	 */
	public String getTicker() {
		return ticker;
	}
	
	/**
	 * @return the list of dates
	 */
	public List<GregorianCalendar> getDateList() {
		return date;
	}
	
	/**
	 * @return the list of open
	 */
	public List<Double> getOpenList() {
		return open;
	}

	/**
	 * @return the list of high
	 */
	public List<Double> getHighList() {
		return high;
	}

	/**
	 * @return the list of low
	 */
	public List<Double> getLowList() {
		return low;
	}

	/**
	 * @return the list of close
	 */
	public List<Double> getCloseList() {
		return close;
	}

	/**
	 * @return the list of volume
	 */
	public List<Integer> getVolumeList() {
		return volume;
	}

	/**
	 * @return the list of adjusted
	 */
	public List<Double> getAdjustedList() {
		return adjusted;
	}

	/**
	 * @param index l'indice de la cotation souhaitée
	 * @return les valeurs sous la forme d'un objet Cotation
	 */
	public Cotation getCotation(int index){
		return new Cotation(ticker, date.get(index), open.get(index), high.get(index), low.get(index),
				close.get(index), volume.get(index), adjusted.get(index));
	}
	
	// Méthodes de gestion de la liste (à compléter éventuellement)
	/**
	 * @param cot la cotation à ajouter (utilisée par la classe Download,
	 * à manipuler avec précaution pour l'ordre des dates)
	 */
	protected void ajouter(Cotation cot){
		if (this.ticker == null)
			this.ticker = cot.getTicker();
		this.date.add(cot.getDate());
		this.open.add(cot.getOpen());
		this.high.add(cot.getHigh());
		this.low.add(cot.getLow());
		this.close.add(cot.getClose());
		this.volume.add(cot.getVolume());
		this.adjusted.add(cot.getAdjusted());	
	}
	
	/**
	 * @param index l'index de la cotation à supprimer
	 * @return la cotation supprimée
	 */
	public Cotation supprimer(int index) {
		Cotation result =  new Cotation(ticker, date.remove(index), open.remove(index),
				high.remove(index), low.remove(index), close.remove(index), volume.remove(index),
				adjusted.remove(index));
		return result;
	}
	
	/**
	 * @return la cotation en tête de liste
	 */
	public Cotation supprimerPremiere() {
		Cotation result =  new Cotation(ticker, date.remove(0), open.remove(0), high.remove(0),
				low.remove(0), close.remove(0), volume.remove(0), adjusted.remove(0));
		return result;
	}
	
	/**
	 * @param chaine la date de la cotation à supprimer
	 * @return la cotation supprimée si elle existe
	 */
	public Cotation supprimerDate(String chaine) {
		GregorianCalendar cal = Cotation.parseDate(chaine);
		int index = 0;
		for (GregorianCalendar date : this.date) {
			if (date.equals(cal))
				return this.supprimer(index);
			index++;
		}
		return null;
	}
	
	/**
	 * Calcul pour l'historique concerné des valeurs moyennes (open, close, adjusted), minimum (low),
	 * maximum (high) ou cumulées (volume) hebdomadaires. Le jour de la cotation est arbitrairement choisi au
	 * premier jour de la semaine condernée.
	 * @return un nouvel historique contenant des valeurs hebdomadaires
	 */
	public Historique histoHebdo() {
		Historique hebdo = new Historique();
		String ticker = this.getTicker();
		int weekOfYear = this.getDateList().get(0).get(Calendar.WEEK_OF_YEAR);
		Cotation tempCot;
		int index = 0;
		while (index < this.taille()){
			// Initialisation des variables
			double open = 0.0, close = 0.0, high = -1, low = -1, adjusted = 0.0;
			int volume = 0, nbCot = 0;
			// Boucle tant que l'on est dans la même semaine
			do {
				tempCot = this.getCotation(index);
				open += tempCot.getOpen();
				close += tempCot.getClose();
				volume += tempCot.getVolume();
				adjusted += tempCot.getAdjusted();
				if (low == -1 || tempCot.getLow() < low) low = tempCot.getLow();
				if (high == -1 || tempCot.getHigh() > high) high = tempCot.getHigh();
				index++;
				nbCot++;
			} while (index < this.taille() && weekOfYear == this.getDateList().get(index).get(Calendar.WEEK_OF_YEAR));
			// Calcul des moyennes necessaires et ajout à l'historique hebdo
			open /= nbCot;
			close /= nbCot;
			adjusted /= nbCot;
			hebdo.ajouter(new Cotation(ticker, tempCot.getDateFormatted(), open, high, low, close, volume, adjusted));
			if(index < this.taille())
				weekOfYear = this.getDateList().get(index).get(Calendar.WEEK_OF_YEAR);
		}		
		return hebdo;
	}
	
	/**
	 * Calcul pour l'historique concerné des valeurs moyennes (open, close, adjusted), minimum (low),
	 * maximum (high) ou cumulées (volume) mensuelles. Le jour de la cotation est arbitrairement choisi au
	 * premier jour du mois conderné.
	 * @return un nouvel historique contenant des valeurs mensuelles
	 */
	public Historique histoMensuel() {
		Historique mensuel = new Historique();
		String ticker = this.getTicker();
		int month = this.getDateList().get(0).get(Calendar.MONTH);
		Cotation tempCot;
		int index = 0;
		while (index < this.taille()){
			// Initialisation des variables
			double open = 0.0, close = 0.0, high = -1, low = -1, adjusted = 0.0;
			int volume = 0, nbCot = 0;
			int year = this.getDateList().get(0).get(Calendar.YEAR);
			// Boucle tant que l'on est dans le même mois
			do {
				tempCot = this.getCotation(index);
				open += tempCot.getOpen();
				close += tempCot.getClose();
				volume += tempCot.getVolume();
				adjusted += tempCot.getAdjusted();
				if (low == -1 || tempCot.getLow() < low) low = tempCot.getLow();
				if (high == -1 || tempCot.getHigh() > high) high = tempCot.getHigh();
				index++;
				nbCot++;
			} while (index < this.taille() && month == this.getDateList().get(index).get(Calendar.MONTH));
			// Calcul des moyennes necessaires et ajout à l'historique mensuel
			open /= nbCot;
			close /= nbCot;
			adjusted /= nbCot;
			mensuel.ajouter(new Cotation(ticker, new GregorianCalendar(year, month, 1), open, high, low, close, volume, adjusted));
			if(index < this.taille())
				month = this.getDateList().get(index).get(Calendar.MONTH);
		}		
		return mensuel;
	}
	
	/**
	 * Calcul pour l'historique concerné des valeurs moyennes (open, close, adjusted), minimum (low),
	 * maximum (high) ou cumulées (volume) annuelles. Le jour de la cotation est arbitrairement choisi au
	 * premier jour de l'année condernée.
	 * @return un nouvel historique contenant des valeurs annuelles
	 */
	public Historique histoAnnuel() {
		Historique annuel = new Historique();
		String ticker = this.getTicker();
		int year = this.getDateList().get(0).get(Calendar.YEAR);
		Cotation tempCot;
		int index = 0;
		while (index < this.taille()){
			// Initialisation des variables
			double open = 0.0, close = 0.0, high = -1, low = -1, adjusted = 0.0;
			int volume = 0, nbCot = 0;
			// Boucle tant que l'on est dans la même année
			do {
				tempCot = this.getCotation(index);
				open += tempCot.getOpen();
				close += tempCot.getClose();
				volume += tempCot.getVolume();
				adjusted += tempCot.getAdjusted();
				if (low == -1 || tempCot.getLow() < low) low = tempCot.getLow();
				if (high == -1 || tempCot.getHigh() > high) high = tempCot.getHigh();
				index++;
				nbCot++;
			} while (index < this.taille() && year == this.getDateList().get(index).get(Calendar.YEAR));
			// Calcul des moyennes necessaires et ajout à l'historique annuel
			open /= nbCot;
			close /= nbCot;
			adjusted /= nbCot;
			annuel.ajouter(new Cotation(ticker, new GregorianCalendar(year, 0, 1), open, high, low, close, volume, adjusted));
			if(index < this.taille())
				year = this.getDateList().get(index).get(Calendar.YEAR);
		}		
		return annuel;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String res = "";
		for (int index = 0 ; index < this.taille() ; index++)
			res += this.getCotation(index) + "\n";
		return res;		
	}
}