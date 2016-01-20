package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import modeles.Modele;


public class PannDroit {
	JPanel panD;
	
	public PannDroit(Modele modele, JFrame fen, JPanel panD){
		
    AffGraphique graphique = new AffGraphique(modele);
    Border EtchedBorderbd = BorderFactory.createEtchedBorder();
    Border bd = BorderFactory.createTitledBorder(EtchedBorderbd,"Résultat graphique",
  		  TitledBorder.LEFT, TitledBorder.TOP,new Font("Arial", Font.BOLD,13),Color.BLUE);
    graphique.setBorder(bd);
//    scrollGraph.setPreferredSize(new Dimension(450,500));
    panD = new JPanel();
    panD.setPreferredSize(new Dimension(450,500));
   //panD.setLayout(new FlowLayout());
    panD.add(graphique);
    panD.setOpaque(false);
    this.panD=panD;
   
	}

	public JPanel getPanD() {
		return panD;
	}

	public void setPanD(JPanel panD) {
		this.panD = panD;
	}

	
}
