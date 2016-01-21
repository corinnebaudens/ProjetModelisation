package modeles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Avec des fichiers existants, le travail est correctement fait, il ne faudra pas oublier
 * les vérifications d'existence de fichier/objet dans le contrôleur avant les appels de méthode
 */

public class ConversionObjectCSV {

	/**
	 * Passge du fichier CSV à l'objet
	 * @param le fichier csv
	 * @return un objet Historique contenant les cotations
	 */
	public static Historique CSVToHistorique(File csv){
		Historique result = new Historique();
		/* On ne prend pas en compte la ligne d'entête
		 * et on commence à créer les objets Cotation à partir de la deuxième ligne
		 */
		try {
			
			String[] ticker = csv.getName().split("-");
			FileReader fis = new FileReader(csv);
			BufferedReader in = new BufferedReader(fis);
			
			String input = in.readLine();
			// Si le fichier n'est pas vide, on vérifie que le première ligne correspond à l'entête pour commencer la création 
			if (input.equals("Date,Open,High,Low,Close,Volume,Adj Close"))
				input = in.readLine();
			else
				input = null;
			while (input != null) {
				result.ajouter(new Cotation(ticker[0], input, ","));
				input = in.readLine();
			}
			fis.close();
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Passage de l'objet au fichier CSV
	 * @param histo
	 * @return le fichier créé sous forme d'un objet File
	 */
	public File HistoriqueToCSV(Historique histo){
		// Nom de fichier à modifier par la suite (par exemple avec le nom de la modification apportée)
		File fichier = new File(histo.getTicker() + "-" + histo.getCotation(histo.taille()-1).getDateFormatted().replaceAll("-", "") + 
				"-" + histo.getCotation(0).getDateFormatted().replaceAll("-", "") + "-historiqueToCSV.csv");
		/* Après ajout de la ligne d'entete,
		 * lecture de chacune des entrées de l'historique qui sont ajoutées dans le fichier csv
		 */
		try {
			FileWriter out = new FileWriter(fichier);
			out.write("Date,Open,High,Low,Close,Volume,Adj Close\n");
			for (int index=0 ; index < histo.taille() ; index++) {
				out.write(histo.getCotation(index).formatCSV() + "\n");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fichier;
	}

}