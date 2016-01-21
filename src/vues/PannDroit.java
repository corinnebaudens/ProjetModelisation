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

/**
 * 
 * @author C. Baudens, V. Dubromez, G. Durand
 *
 */
public class PannDroit implements Observer{
	JPanel panD;
	Border bd;
	Controleur controleur;
	Modele modele;
	ArrayList<Coord> dataBase;
	AffGraphique graphique;
	
	/**
	 * Constructeur de la classe
	 * @param modele l'instance de la classe Modele en cours
	 * @param controleur l'instance de la classe Controleur en cours
	 * @param fen l'instance de la JFrame qui regroupe l'ensemble des JPanel
	 * @param panD l'instance du JPanel définissant le panneau droit
	 */
	public PannDroit(Modele modele, Controleur controleur, JFrame fen, JPanel panD){
		modele.addObserver(this);
		this.controleur=controleur;
		this.modele=modele;
		graphique = new AffGraphique(modele, controleur);
		Border EtchedBorderbd = BorderFactory.createEtchedBorder();
		bd = BorderFactory.createTitledBorder(EtchedBorderbd,"Résultat graphique",
		TitledBorder.LEFT, TitledBorder.TOP,new Font("Arial", Font.BOLD,13),Color.BLUE);
		graphique.setBorder(bd);
		panD = new JPanel();
		panD.setPreferredSize(new Dimension(450,500));
		panD.add(graphique);
		panD.setOpaque(false);
		this.panD=panD;
		System.out.println("classe atteinte : PannDroit - CONSTRUCTEUR initialisé");

	}
	
	/**
	 * 
	 * @return l'instance du JPanel en cours
	 */
	public JPanel getPanD() {
		return panD;
	}

	/**
	 * met à jour l'attribut de classe JPanel
	 * @param panD
	 */
	public void setPanD(JPanel panD) {
		this.panD = panD;
	}

	@Override
	public void update(Observable o, Object arg) {
		dataBase=this.modele.getData();
		graphique.repaint();
		
	}
}