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

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;




public class Demarrage implements ActionListener{

	JScrollPane scrollTitre, scrollTraitement, scrollGraph;
	JList ListTitre, ListTraitement, ListGraph;
	JButton Bouton;
	JPanel panG, panC, panD, panelBouton;

	//JSplitPane pSepare;
	
	public Demarrage()
	{
		  JFrame fen= new JFrame("Traitement de Séries chronologiques boursières");
		  		  
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
	      		Bouton.setPreferredSize(new Dimension(140,40));
	      		panelBouton.add(Bouton);
	      		panelBouton.setOpaque(false);
	      		
	      		Bouton.addActionListener(new ActionListener() {
	      			public void actionPerformed(ActionEvent evt) {
	      				
	      				JDialog coucou = new JDialog();
	      				coucou.setTitle("essai graph");
	      				coucou.setLocation(900, 100);
	      				coucou.setPreferredSize(new Dimension(200,200));
	      				coucou.pack();
	      				coucou.setVisible(true);
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
	      fen.setPreferredSize(new Dimension(800,600));
	      fen.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.DARK_GRAY));
	      //fen.getRootPane().setBackground(BackgroundFactory.);
	      fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      fen.setVisible(true);
		  fen.pack();
		  fen.setLocationRelativeTo(null);
		  fen.setResizable(false);
		  
		  // ajout de la fenêtre modale
		  JDialog modal = new JDialog(fen,false);
	      modal.setTitle("Bienvenue sur notre application boursière");
	      modal.setPreferredSize(new Dimension(400,300));
	      modal.setLocation(500, 200);
	      //modal.setUndecorated(true);
	      modal.pack();
	      modal.setVisible(true);
	      modal.setResizable(false);
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
}
