package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import modeles.Coord;
import modeles.Modele;
import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
/**
 * Réalise l'affichage du graphique
 * @author C. Baudens, V. Dubromez, G. Durand
 * @param	modele : l'instance de la classe Modele
 * 			controleur : l'instance de la classe Controleur
 * @return renvoit tous les éléments pour l'affichage de la courbe
 */
public class AffGraphique extends JPanel {
	protected static final int GRAPHIC_SIZE = 400 ;
	Modele modele ;
	Controleur controleur;
	double minX ;
	double maxX ;
	double minY ;
	double maxY ;
	ArrayList<Coord> dataBase;
	String ticker;
	int anneeD, moisD, jourD, anneeF, moisF, jourF;
	
	/**
	 * Constructeur de la classe
	 * @param modele l'instance de la classe Modele en cours
	 * @param controleur l'instance de la classe Controleur en cours
	 */
	public AffGraphique(Modele modele, Controleur controleur) {
		super() ;
		this.modele = modele ;
		this.setPreferredSize(new Dimension(GRAPHIC_SIZE,800)) ;
	}

	/**
	 * 
	 * @param g
	 * @param dataBase la liste des points donnée par le modèle
	 */
	protected void drawData(Graphics g, ArrayList<Coord> dataBase) {
		// Calcul d'échelle
		minX = 0.0 ;
		minY = 1000.0 ;
		maxX = 0.0 ;
		maxY = 0.0 ;
		for (int i = 0 ; i < dataBase.size() ; i++) {
			double x = dataBase.get(i).getX() ;
			double y = dataBase.get(i).getY() ;
			if (x > maxX) maxX = x ;
			if (y > maxY) maxY = y ;
			if (x < minX) minX = x ;
			if (y < minY) minY = y ;
		}
        g.setColor(Color.RED);
        g.setColor(Color.BLACK);
        g.drawLine(convX(0.0), convY(minY), convX(0.0), convY(maxY) );
        g.drawLine(convX(minX), convY(0.0), convX(maxX), convY(0.0) );
        
        double x0=0.0;
        double y0=0.0;
        double x1=0.0;
        double y1=0.0;
        for(int i=0; i<dataBase.size(); i++){
        		x1 = dataBase.get(i).getX() ;
        		y1 = dataBase.get(i).getY() ;
        		if(i!=0) g.drawLine(convX(x0), convY(y0), convX(x1), convY(y1));
        		x0=x1;
        		y0=y1;
        }
	}
		
	protected int convX(Double x) {
		return (int) ((x - minX) * GRAPHIC_SIZE / (maxX - minX)) ;
	}
	protected int convY(Double y) {
		return (int) ((maxY - y) * GRAPHIC_SIZE / (maxY - minY)) ;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        this.dataBase=modele.getData();
        if (dataBase.isEmpty()) {
			g.drawString("Aucune donnée à afficher", 30, 40);
		}
		else {
			drawData(g, dataBase);
		}
    }
}