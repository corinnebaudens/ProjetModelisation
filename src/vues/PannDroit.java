package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controleur.Controleur;

import modeles.Coord;
import modeles.Modele;


public class PannDroit implements Observer{
	JPanel panD;
	Border bd;
	Controleur controleur;
	Modele modele;
	ArrayList<Coord> dataBase;
	AffGraphique graphique;
	
	public PannDroit(Modele modele, Controleur controleur, JFrame fen, JPanel panD){
		modele.addObserver(this);
		this.controleur=controleur;
		this.modele=modele;
		graphique = new AffGraphique(modele, controleur);
		Border EtchedBorderbd = BorderFactory.createEtchedBorder();
		bd = BorderFactory.createTitledBorder(EtchedBorderbd,"Résultat graphique",
		TitledBorder.LEFT, TitledBorder.TOP,new Font("Arial", Font.BOLD,13),Color.BLUE);
		graphique.setBorder(bd);
//		scrollGraph.setPreferredSize(new Dimension(450,500));
		panD = new JPanel();
		panD.setPreferredSize(new Dimension(450,500));
//		panD.setLayout(new FlowLayout());
		panD.add(graphique);
		panD.setOpaque(false);
		this.panD=panD;
		System.out.println("classe atteinte : PannDroit - CONSTRUCTEUR initialisé");

	}
	
/*	public void dessiner(String ticker, int anneeD, int moisD, int jourD, int anneeF, int moisF, int jourF){
		AffGraphique graphique = new AffGraphique(modele, controleur);
		graphique.setBorder(bd);
		panD.add(graphique);
		panD.validate() ;
		panD.repaint();
	}
*/

	public JPanel getPanD() {
		return panD;
	}

	public void setPanD(JPanel panD) {
		this.panD = panD;
	}

	@Override
	public void update(Observable o, Object arg) {
		dataBase=this.modele.getData();
		graphique.repaint();
		
	}
}