package modeles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Download {
	
	private File fichier;
	
	/**
	 * Constructeur prenant les paramètres de la date sous forme décomposée d'entiers
	 * @param ticker le titre de l'action
	 * @param startYear année de début
	 * @param startMonth mois de début
	 * @param startDay jour de début
	 * @param endYear année de fin
	 * @param endMonth mois de fin
	 * @param endDay jour de fin
	 */
	public Download(String ticker, int startYear, int startMonth, int startDay,
			int endYear, int endMonth, int endDay)
	{
		this.fichier = telecharger(ticker, startYear, (startMonth-1), startDay,
				endYear, (endMonth-1), endDay);
	}
	
	/**
	 * Constructeur prenant les paramètres de la date sous forme de chaine
	 * @param ticker le titre de l'action
	 * @param debut date de début
	 * @param fin date de fin
	 */
	public Download(String ticker, String debut, String fin)
	{
		GregorianCalendar dateD = Cotation.parseDate(debut);
		GregorianCalendar dateF = Cotation.parseDate(fin);
		int startYear = dateD.get(Calendar.YEAR);
		int startMonth = dateD.get(Calendar.MONTH);
		int startDay = dateD.get(Calendar.DAY_OF_MONTH);
		int endYear = dateF.get(Calendar.YEAR);
		int endMonth = dateF.get(Calendar.MONTH);
		int endDay = dateF.get(Calendar.DAY_OF_MONTH);
		this.fichier = telecharger(ticker, startYear, startMonth, startDay,
				endYear, endMonth, endDay);
	}
	
	/**
	 * Méthode interne de téléchargement des données sous forme d'un fichier csv
	 */
	private File telecharger(String ticker, int startYear, int startMonth, int startDay,
			int endYear, int endMonth, int endDay)
	{
		File save = new File(ticker + "-" + startYear + startMonth + startDay + "-" + endYear + endMonth + endDay + ".csv");;
		String link = "http://real-chart.finance.yahoo.com/table.csv?s=" + ticker
				+ "&a=" + startMonth + "&b=" + startDay + "&c=" + startYear + "&d="
				+ endMonth + "&e=" + endDay + "&f=" + endYear + "&g=d&ignore=.csv";
		try {
			
			URL url = new URL(link);
			

			System.setProperty("http.proxyHost", "cache.univ-lille1.fr");
			System.setProperty("http.proxyPort", "3128");
			
			
			InputStreamReader isr = new InputStreamReader(url.openStream());
			BufferedReader in = new BufferedReader(isr);
			PrintWriter out = new PrintWriter(save);
			String input = in.readLine();
			
			while (input != null) {
				out.println(input);
				input = in.readLine();
			}
			
			in.close();
			out.close();
			return save;
			
		} catch (MalformedURLException e) {
			System.out.println("Erreur !!! L'URL n'est pas valide");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Erreur !!! Le ticker ou les dates ne sont pas valides");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return save;
	}


	/**
	 * @return le fichier sous forme d'objet File
	 */
	public File getFichier() {
		return this.fichier;
	}
	
}


