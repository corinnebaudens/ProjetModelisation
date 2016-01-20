package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import modeles.Modele;
import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class AffGraphique extends JPanel implements Observer {
	protected static final int GRAPHIC_SIZE = 400 ;
	Modele modele ;
	double minX ;
	double maxX ;
	double minY ;
	double maxY ;
	public AffGraphique(Modele modele) {
		super() ;
		this.modele = modele ;
		modele.addObserver(this) ;
		this.setPreferredSize(new Dimension(GRAPHIC_SIZE,800)) ;
	}
	
/*	public double[][] getCoordinates (Modele modele){ // valable pour tout tableau ayant le même nombre d'élément à chaque ligne
		double [][] data = new double [modele.getData().length][modele.getData()[0].length];
		for(int i=0; i<modele.getData().length; i++){
			for(int j=0; j<modele.getData()[i].length; j++){
				data[i][j]=modele.getData()[i][j] ;
			}
		}		
		return data ;
	}
*/
	protected void drawData(Graphics g, Double[][] data) {
		// Calcul d'échelle
		minX = 0.0 ;
		minY = 1000.0 ;
		maxX = 0.0 ;
		maxY = 0.0 ;
		for (int i = 0 ; i < data.length ; i++) {
			double x = data[i][0] ;
			double y = data[i][1] ;
			if (x > maxX) maxX = x ;
			if (y > maxY) maxY = y ;
			if (x < minX) minX = x ;
			if (y < minY) minY = y ;
		}
        g.setColor(Color.RED);
        /*
        int left = convX(minX) ;
        int width = convX(maxX) - convX(minX) ;
        int top = convY(maxY) ;
        int height = convY(minY) - convY(maxY) ;
		*/
        g.setColor(Color.BLACK);
        g.drawLine(convX(0.0), convY(minY), convX(0.0), convY(maxY) );
        g.drawLine(convX(minX), convY(0.0), convX(maxX), convY(0.0) );
        
        double x0=0.0;
        double y0=0.0;
        double x1=0.0;
        double y1=0.0;
        for(int i=0; i<data.length; i++){
        		x1 = data[i][0];
        		y1 = data[i][1];
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
		Double[][] data = modele.getData();
		if (data.length > 0) {
			drawData(g, data) ;
		} else {
	        g.drawString("Pas de donnée à afficher", 10, 20);
		}
    }
	
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint() ;
	}
}