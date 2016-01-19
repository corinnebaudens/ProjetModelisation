package testGraph;

import java.awt.Dimension;
import modeles.Modele;
import controleur.Controleur;
import javax.swing.*;

public class Affichage {
	
	JFrame frame = new JFrame();
	AffGraph BeauGraphique;
//	Controleur controleur;
//	Test modele;
	
		
	Affichage(Controleur controleur, Modele modele){
	
	BeauGraphique = new AffGraph(modele);
		
	frame.setTitle("Affichage d'un graphique");
	frame.getContentPane().add(BeauGraphique);

	frame.setPreferredSize(new Dimension(800,600));
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.pack();
	frame.setVisible(true);
	}

}















