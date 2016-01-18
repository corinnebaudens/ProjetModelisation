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

public class Download {
	
	private File fichier;
	
	public Download(String ticker, int startYear, int startMonth, int startDay,
			int endYear, int endMonth, int endDay)
	{
		this.fichier = telecharger(ticker, startYear, startMonth, startDay,
				endYear, endMonth, endDay);
	}
	
	
	private File telecharger(String ticker, int startYear, int startMonth, int startDay,
			int endYear, int endMonth, int endDay)
	{
		File save = new File(ticker + "-" + startYear + startMonth + startDay + "-" + endYear + endMonth + endDay + ".csv");;
		String link = "http://real-chart.finance.yahoo.com/table.csv?s=" + ticker
				+ "&a=" + (startMonth-1) + "&b=" + startDay + "&c=" + startYear + "&d="
				+ (endMonth-1) + "&e=" + endDay + "&f=" + endYear + "&g=d&ignore=.csv";
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


