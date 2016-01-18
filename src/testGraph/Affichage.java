package testGraph;

import java.awt.Dimension;
import modeles.Test;
import controleur.Controleur;
import javax.swing.*;

public class Affichage {
	
	JFrame frame = new JFrame();
	AffGraph BeauGraphique;
//	Controleur controleur;
//	Test modele;
	
		
	Affichage(Controleur controleur, Test modele){
	
	BeauGraphique = new AffGraph(modele);
		
	frame.setTitle("Affichage d'un graphique");
	frame.getContentPane().add(BeauGraphique);

	frame.setPreferredSize(new Dimension(450,350));
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.pack();
	frame.setVisible(true);
	}

}















