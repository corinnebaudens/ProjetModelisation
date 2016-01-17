package modeles;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * Gestion d'une 'cotation' journalière
 * @author Vincent
 */
public class Cotation {
	
	// Attributs
	private String ticker;
	private GregorianCalendar date;
	private double open;
	private double high;
	private double low;
	private double close;
	private int volume;
	private double adjusted;
	private String[] data;
	
	// Constructeurs
	public Cotation(String ticker, String date, double open, double high, double low, double close,
			int volume, double adjusted) {
		this.ticker = ticker;
		this.date = parseDate(date);
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.adjusted = adjusted;
	}
	
	public Cotation(String ticker, GregorianCalendar date, double open, double high, double low,
			double close, int volume, double adjusted) {
		this.ticker = ticker;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.adjusted = adjusted;
	}

	public Cotation (String ticker, String data, String separator) {
		this.ticker = ticker;
		this.data = data.split(separator);
		this.date = parseDate(this.data[0]);
		this.open = Float.parseFloat(this.data[1]);
		this.high = Float.parseFloat(this.data[2]);
		this.low = Float.parseFloat(this.data[3]);
		this.close = Float.parseFloat(this.data[4]);
		this.volume = Integer.parseInt(this.data[5]);
		this.adjusted = Float.parseFloat(this.data[6]);
	}
	
	// Getters
	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return this.ticker;
	}
	
	/**
	 * @return the date as a GragorianCalendar
	 */
	public GregorianCalendar getDate() {
		return date;
	}
	
	/**
	 * @return the date as a String
	 */
	public String getDateFormatted() {
		return date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH)+1) + "-"
				+ date.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * @return the open
	 */
	public double getOpen() {
		return open;
	}

	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}

	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}

	/**
	 * @return the close
	 */
	public double getClose() {
		return close;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @return the adjusted
	 */
	public double getAdjusted() {
		return adjusted;
	}
	
	// Méthodes accessibles dans le package
	/**
	 * Transforme la date donnée sous forme de chaine de caractères en objet GregorienCalendar 
	 * @return the date
	 */
	protected static GregorianCalendar parseDate(String chaine) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
	    Date d;
		try {
			d = sdf.parse(chaine);
			cal.setTime(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal;
	}
	
	// Méthodes publiques
	/**
	 * Convertit l'objet en chaine de caractères équivalente pour insertion dans un fichier CSV
	 * @return une chaine de caractères
	 */
	public String formatCSV() {
		return date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH)+1) + "-"
				+ date.get(Calendar.DAY_OF_MONTH) + "," + open + "," + high + "," + low + "," + close
				+ "," + volume + "," + adjusted;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ticker + " [date=" + date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH)+1)
				+ "-" + date.get(Calendar.DAY_OF_MONTH) + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", close=" + close + ", volume=" + volume + ", adjusted="
				+ adjusted + "]";
	}
}