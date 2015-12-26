package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;




public class Demarrage {

	JScrollPane scrollTitre, scrollTraitement, scrollGraph;
	JList ListTitre, ListTraitement, ListGraph;
	JButton Bouton;
	JPanel panG, panC, panD, panelBouton;
	//JSplitPane pSepare;
	
	public Demarrage()
	{
		  JFrame fen= new JFrame("Traitement de Séries chronologiques boursières");
		  		  
		  //panneau gauche
		  String [] itemsTitre = {"AI.AP", "CAC40","yy","yy","tt","uu","tt","uu","ii","tt","ii","ii",
	      "ii","ii","ii","ii"};
		  ListTitre = new JList(itemsTitre);
	      ListTitre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      scrollTitre = new JScrollPane(ListTitre);
	      //Border bg = BorderFactory.createTitledBorder("Liste des titres");
	      Border EtchedBorderbg = BorderFactory.createEtchedBorder();
	      Border bg = BorderFactory.createTitledBorder(EtchedBorderbg,"Liste des titres",
	    		  TitledBorder.LEFT, TitledBorder.TOP,new Font("Arial", Font.BOLD,13),Color.BLUE);
	      scrollTitre.setBorder(bg);
	      scrollTitre.setPreferredSize(new Dimension(150,500));
	      panG = new JPanel();
	      panG.add(scrollTitre);
	      panG.setOpaque(false);
	      
	      
	      		//ajout du bouton au panneau gauche
	      		Bouton = new JButton("<Html>Charger le<br>titre sélectionné<Html>");
	      		panelBouton = new JPanel();
	      		panelBouton.setPreferredSize(new Dimension(400,500));
	      		Bouton.setPreferredSize(new Dimension(140,40));
	      		panelBouton.add(Bouton);
	      		panelBouton.setOpaque(false);
	      		//fin de l'ajout du bouton
	      		
	      panG.add(panelBouton);
	      panG.setPreferredSize(new Dimension(150,500));
	      // panG.setLayout(new FlowLayout());
	      
	      
	      //panneau central
	      String [] itemsTraitement = {"régression","moyennemobile"};
	      ListTraitement = new JList(itemsTraitement);
	      ListTraitement.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      scrollTraitement = new JScrollPane(ListTraitement);
	      Border EtchedBorderbc = BorderFactory.createEtchedBorder();
	      Border bc = BorderFactory.createTitledBorder(EtchedBorderbc,"Liste des traitements",
	    		  TitledBorder.LEFT, TitledBorder.TOP,new Font("Arial", Font.BOLD,13),Color.BLUE);
	      scrollTraitement.setBorder(bc);
	      scrollTraitement.setPreferredSize(new Dimension(150,500));
	      panC = new JPanel();
	      panC.setPreferredSize(new Dimension(200,500));
	      //panC.setLayout(new FlowLayout());
	      panC.add(scrollTraitement);
	      panC.setOpaque(false);
	      
	      
	      //panneau droit
	      String [] test = {"titi","tutu"};
	      ListGraph = new JList(test);
	      scrollGraph = new JScrollPane(ListGraph); 
	      Border EtchedBorderbd = BorderFactory.createEtchedBorder();
	      Border bd = BorderFactory.createTitledBorder(EtchedBorderbd,"Résultat Graphique",
	    		  TitledBorder.LEFT, TitledBorder.TOP,new Font("Arial", Font.BOLD,13),Color.BLUE);
	      scrollGraph.setBorder(bd);
	      scrollGraph.setPreferredSize(new Dimension(450,500));
	      panD = new JPanel();
	      panD.setPreferredSize(new Dimension(450,500));
	     //panD.setLayout(new FlowLayout());
	      panD.add(scrollGraph);
	      panD.setOpaque(false);
	     
	      //ajout des panneaux à la JFrame
	      fen.getContentPane().setBackground(Color.LIGHT_GRAY);
	      fen.getContentPane().add(panG, BorderLayout.WEST);
	      fen.getContentPane().add(panC, BorderLayout.CENTER);
	      fen.getContentPane().add(panD, BorderLayout.EAST);
	      fen.setPreferredSize(new Dimension(800,600));
	      fen.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.DARK_GRAY));
	      //fen.getRootPane().setBackground(BackgroundFactory.);
	      fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      fen.setVisible(true);
		  fen.pack();
		  fen.setLocationRelativeTo(null);
		  fen.setResizable(false);
	}
}
