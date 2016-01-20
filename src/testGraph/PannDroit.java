package testGraph;

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

import vues.AffGraphique;

public class PannDroit {
	
	public PannDroit(Modele modele, JFrame fen, JPanel panG, JPanel panC, JPanel panD){
		
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
   
    //ajout des panneaux à la JFrame
    fen.getContentPane().setBackground(Color.LIGHT_GRAY);
    fen.getContentPane().add(panG, BorderLayout.WEST);
    fen.getContentPane().add(panC, BorderLayout.CENTER);
    fen.getContentPane().add(panD, BorderLayout.EAST);

    fen.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.DARK_GRAY));
    //fen.getRootPane().setBackground(BackgroundFactory.);
    fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fen.pack();
    fen.setLocationRelativeTo(null);
	  fen.setResizable(false);
	  fen.setVisible(true);
	}

}
