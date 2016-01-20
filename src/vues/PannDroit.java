package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controleur.Controleur;

import modeles.Modele;


public class PannDroit {
	JPanel panD;
	Border bd;
	Controleur controleur;
	Modele modele;
	
	public PannDroit(Modele modele, Controleur controleur, JFrame fen, JPanel panD){
		this.controleur=controleur;
		this.modele=modele;
//		AffGraphique graphique = new AffGraphique(modele, controleur);
		Border EtchedBorderbd = BorderFactory.createEtchedBorder();
		bd = BorderFactory.createTitledBorder(EtchedBorderbd,"Résultat graphique",
		TitledBorder.LEFT, TitledBorder.TOP,new Font("Arial", Font.BOLD,13),Color.BLUE);
//		graphique.setBorder(bd);
//		scrollGraph.setPreferredSize(new Dimension(450,500));
		panD = new JPanel();
		panD.setPreferredSize(new Dimension(450,500));
//		panD.setLayout(new FlowLayout());
//		panD.add(graphique);
		panD.setOpaque(false);
		this.panD=panD;
	}
	
	public void dessiner(){
		AffGraphique graphique = new AffGraphique(modele, controleur);
		graphique.setBorder(bd);
		panD.add(graphique);
	}

	public JPanel getPanD() {
		return panD;
	}

	public void setPanD(JPanel panD) {
		this.panD = panD;
	}

	
}
