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
 *
 */
public class Cotation {
	
	// Attributs
	private String ticker;
	private GregorianCalendar date;
	private float open;
	private float high;
	private float low;
	private float close;
	private int volume;
	private float adjusted;
	private String[] data;
	
	// Constructeurs
	public Cotation(String ticker, String date, float open, float high, float low, float close, int volume, float adjusted) {
		this.ticker = ticker;
		this.date = parseDate(date);
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
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}
	
	/**
	 * @return the date as a String
	 */
	public String getDateFormatted() {
		return date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH)+1) + "-" + date.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * @return the open
	 */
	public float getOpen() {
		return open;
	}

	/**
	 * @return the high
	 */
	public float getHigh() {
		return high;
	}

	/**
	 * @return the low
	 */
	public float getLow() {
		return low;
	}

	/**
	 * @return the close
	 */
	public float getClose() {
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
	public float getAdjusted() {
		return adjusted;
	}
	
	// Méthodes accessibles dans le package
	/**
	 * Transforme la date donnée sous forme de chaine de caractère en objet GregorienCalendar 
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
	 * Convertit l'objet en chaine de caractère équivalente pour insetion dans un fichier CSV
	 * @return une chaine de caractère
	 */
	public String formatCSV() {
		return date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH)+1) + "-" + date.get(Calendar.DAY_OF_MONTH) 
		+ "," + open + "," + high + "," + low + "," + close + "," + volume + "," + adjusted;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cotation [date=" + date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH)+1) + "-" + date.get(Calendar.DAY_OF_MONTH)
			+ ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close
			+ ", volume=" + volume + ", adjusted=" + adjusted + "]";
	}
}