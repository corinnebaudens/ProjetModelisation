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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;

import controleur.Controleur;
import modeles.Download;




public class Demarrage implements ActionListener, ListSelectionListener {

	JScrollPane scrollTitre, scrollTraitement, scrollGraph;
	JList ListTitre, ListTraitement, ListGraph;
	JButton Bouton;
	JPanel panG, panC, panD, panelBouton, panelPeriode;
	JTextField text;
	
	//JSplitPane pSepare;
	
	public Demarrage(Controleur controleur) 
	{
		  
		  final JFrame fen= new JFrame("Traitement de Séries chronologiques boursières");
	      fen.setPreferredSize(new Dimension(900,630));
		  	  		  
		  //panneau gauche
		  String [] itemsTitre = {"AI.PA", "ALU.PA","AIR.PA","BN.PA","CA.PA","OR.PA"};
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
	      		Bouton = new JButton("<Html>Charger le<br>titre sélectionné</Html>");
	      		panelBouton = new JPanel();
	      		panelBouton.setPreferredSize(new Dimension(400,500));
	      		Bouton.setPreferredSize(new Dimension(140,50));
	      		panelBouton.add(Bouton);
	      		panelBouton.setOpaque(false);
	      		
	      		Bouton.addActionListener(new ActionListener() {
	      			public void actionPerformed(ActionEvent evt) {
	      				
	      				/* Essai pour le téléchargement d'un fichier csv
	      				 * Pour l'instant, celui-ci se fait à la racine du projet
	      				 */
	      				//Download dl = new Download("AI.PA", 2015, 12, 01, 2015, 12, 29);
	      				
	      				//JDialog periode = new JDialog();
	      				//periode.setTitle("période à définir");
	      				//periode.setLocation(400, 400);
	      				//periode.setPreferredSize(new Dimension(200,200));
	      				//periode.pack();
	      				//periode.setVisible(true);
	      				
	      				JLabel labelDebut = new JLabel("Début :");
	      				JLabel labelFin = new JLabel("Fin :");
	      				JTextField debut = new JTextField("YYYY-MM-DD");
	      				JTextField fin = new JTextField("YYYY-MM-DD");
	      				JLabel lab = new JLabel ("");
	      				Object [] tab = new Object [] {labelDebut, debut, labelFin, fin, lab};
	      				int rep = JOptionPane.showOptionDialog(fen, tab, "Entrez dates de début et fin de période", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,null);
	      				//JOptionPane jop = new JOptionPane();
	      				//String name = jop.showInputDialog(null, "Entrez dates de début et de fin de période","périodes à définir",JOptionPane.QUESTION_MESSAGE);
	      				
	      			}
	      		});
	      		//fin de l'ajout du bouton
	      		
	      panG.add(panelBouton);
	      panG.setPreferredSize(new Dimension(150,500));
	      // panG.setLayout(new FlowLayout());
	      
	      
	      //panneau central
	      String [] itemsTraitement = {"Régression linéaire","Moyenne Mobile"};
	      ListTraitement = new JList(itemsTraitement);
	      ListTraitement.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      scrollTraitement = new JScrollPane(ListTraitement);
	      Border EtchedBorderbc = BorderFactory.createEtchedBorder();
	      Border bc = BorderFactory.createTitledBorder(EtchedBorderbc,"Liste des traitements",
	    		  TitledBorder.LEFT, TitledBorder.TOP,new Font("Arial", Font.BOLD,13),Color.BLUE);
	      scrollTraitement.setBorder(bc);
	      scrollTraitement.setPreferredSize(new Dimension(250,500));
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
	      Border bd = BorderFactory.createTitledBorder(EtchedBorderbd,"Résultat graphique",
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
	
	      fen.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.DARK_GRAY));
	      //fen.getRootPane().setBackground(BackgroundFactory.);
	      fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      fen.pack();
	      fen.setLocationRelativeTo(null);
		  fen.setResizable(false);
		  fen.setVisible(true);
		  
		  // ajout de la fenêtre modale
		  JDialog modal = new JDialog(fen,false);
	      modal.setTitle("Bienvenue sur notre application boursière");
	      modal.setPreferredSize(new Dimension(500,300));
	      modal.setLocation(580, 280);
	      //modal.setUndecorated(true);
	      modal.pack();
	      modal.setResizable(false);
	      modal.setVisible(true);
	      JLabel label = new JLabel();
	      label.setBackground(Color.ORANGE);
	      label.setOpaque(true);
	      label.setText("<Html><br>Bienvenue sur notre application boursière !<br><br><br>"
	      		+ "L'application est composée de 3 panneaux:<br><ul><li>Liste des titres</li>"
	      		+ "<li>Liste des traitements</li><li>Résultat graphique</li></ul>"
	      		+ "<br>Vous devez commencer par séléctionner le titre boursier<br>que vous souhaitez analyser"
	      		+ " et cliquer sur le bouton<br>charger le titre sélectionné"
	      		+ "<br>ensuite vous devez choisir le traitement mathématique à appliquer."
	      		+ "<br><br>Vous verrez alors apparaitre le graphique correspondant à vos choix<br><br>.<Html>");
	      modal.add(label, BorderLayout.PAGE_START);
	      
	      
		  
	     
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
