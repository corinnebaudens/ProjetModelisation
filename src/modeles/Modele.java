package modeles;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

public class Modele extends Observable{
	
	ArrayList<Coord> dataBase;
	String ticker, process;
	int anneeD, moisD, jourD, anneeF, moisF, jourF;
	
	public Modele(){
		this.dataBase = new ArrayList<>();
	}
	
	public void recupDonnees(String ticker, int anneeD, int moisD, int jourD, int anneeF, int moisF, int jourF){
		this.ticker=ticker;
		this.anneeD=anneeD;
		this.moisD=moisD;
		this.jourD=jourD;
		this.anneeF=anneeF;
		this.moisF=moisF;
		this.jourF=jourF;
		setData();
		setChanged();
		notifyObservers();
	}
	
	public void recupDonnees(String process){
		this.process=process;
		setChanged();
		notifyObservers();
	}
		
	private void ajouterCoord(double x, double y, String z){
		this.dataBase.add(new Coord(x, y, z));
	}
	
/*	public void setData(String ticker, String dateDebut, String dateFin){
		Download dl = new Download("AI.PA", 2011, 1, 1, 2015, 12, 31);
		Historique test = ConversionObjectCSV.CSVToHistorique(dl.getFichier()); */
	
	public void setData(){
		Download dl = new Download(ticker, anneeD, moisD, jourD, anneeF, moisF, jourF);
		Historique test = ConversionObjectCSV.CSVToHistorique(dl.getFichier());
		//	Creation d'un objet Historique à partir d'un fichier csv présent sur le disque
		//	String nom = ticker + "-" + dateDebut.replaceAll("-", "") + "-" + dateFin.replaceAll("-", "")+".csv";
		//	Historique test = ConversionObjectCSV.CSVToHistorique(new File(nom));
		int taille = test.taille();
		if(!dataBase.isEmpty()) dataBase.clear();
		for (int ligne = 0 ; ligne < taille ; ligne++){
			ajouterCoord(ligne, test.getOpenList().get(taille - ligne - 1), test.getCotation(taille - ligne - 1).getDateFormatted());
		}
		setChanged();
		notifyObservers();
	}

	
	public ArrayList<Coord> getData() {
		return dataBase;
	}
}