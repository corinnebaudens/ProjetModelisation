package testGraph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import modeles.Test;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AffGraph extends JPanel implements Observer {
	protected static final int GRAPHIC_SIZE = 300 ;
	Test modele ;
	double minX ;
	double maxX ;
	double minY ;
	double maxY ;
	public AffGraph(modeles.Test modele) {
		super() ;
		this.modele = modele ;
		modele.addObserver(this) ;
		this.setPreferredSize(new Dimension(700,1000)) ;
	}

	protected void drawData(Graphics g, Double[][] data) {
		// Calcul d'échelle
		minX = 0.0 ;
		minY = 0.0 ;
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
        int left = convX(minX) ;
        int width = convX(maxX) - convX(minX) ;
        int top = convY(maxY) ;
        int height = convY(minY) - convY(maxY) ;
        g.setColor(Color.BLACK);
        g.drawLine(convX(0.0), convY(minY), convX(0.0), convY(maxY) );
        g.drawLine(convX(minX), convY(0.0), convX(maxX), convY(0.0) );
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

