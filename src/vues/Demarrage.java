package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.Controleur;
import modeles.Download;
import modeles.Modele;


public class Demarrage {

	JFrame fen;
	JScrollPane scrollTitre, scrollTraitement, scrollGraph;
	JList ListTitre, ListTraitement, ListGraph;
	JButton Bouton;
	JPanel panG, panC, panD, panelBouton, panelPeriode;
	JTextField text, jourDebut, moisDebut, anneeDebut, jourFin, moisFin, anneeFin;
	JDialog periode;
	String rec;
	Download dl;
	
		
	public Demarrage(Controleur controleur, Modele modele)
	{
		  
		  final JFrame fen= new JFrame("Traitement de Séries chronologiques boursières  (version 1.0)       Application conçue par C.BAUDENS, V.DUBROMEZ, G.DURAND");
	      fen.setPreferredSize(new Dimension(900,630));
		  	  		  
		  // Création du panneau gauche
	      
		  String [] itemsTitre = {"AI.PA", "ALU.PA","AIR.PA","BN.PA","CA.PA","OR.PA"};
		  ListTitre = new JList(itemsTitre);
	      ListTitre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      scrollTitre = new JScrollPane(ListTitre);
	      Border EtchedBorderbg = BorderFactory.createEtchedBorder();
	      Border bg = BorderFactory.createTitledBorder(EtchedBorderbg,"Liste des titres",
	    		  TitledBorder.LEFT, TitledBorder.TOP,new Font("Arial", Font.BOLD,13),Color.BLUE);
	      scrollTitre.setBorder(bg);
	      scrollTitre.setPreferredSize(new Dimension(150,500));
	      panG = new JPanel();
	      panG.add(scrollTitre);
	      panG.setOpaque(false);
	      	      
	      		// ajout du bouton au panneau gauche	      
	      		Bouton = new JButton("<Html>Charger le<br>titre sélectionné</Html>");
	      		panelBouton = new JPanel();
	      		panelBouton.setPreferredSize(new Dimension(400,500));
	      		Bouton.setPreferredSize(new Dimension(140,50));
	      		panelBouton.add(Bouton);
	      		panelBouton.setOpaque(false);
	      		panG.add(panelBouton);
	      		panG.setPreferredSize(new Dimension(150,500));
	      			     
	      		// gestion des événements liés au panneau gauche
	      		ListTitre.addMouseListener(new ClickTitre());
	      		Bouton.addActionListener(new BtCharger());
	      				
	          
	      
	      
	      // Création du panneau central
	      		
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
	      panC.add(scrollTraitement);
	      panC.setOpaque(false);
	      
	      	// gestion des événements liés au panneau central
	      			ListTraitement.addMouseListener(new ClickTrait());
	      
	      
	      			
	      // Création du panneau droit
	      PannDroit p = new PannDroit(modele, controleur, fen, panD);
	      panD = p.getPanD();
	      p.dessiner();
	      
	     
	      // Ajout des panneaux à la JFrame
	      fen.getContentPane().setBackground(Color.LIGHT_GRAY);
	      fen.getContentPane().add(panG, BorderLayout.WEST);
	      fen.getContentPane().add(panC, BorderLayout.CENTER);
	      fen.getContentPane().add(panD, BorderLayout.EAST);
	
	      fen.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.DARK_GRAY));
	      fen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	      fen.pack();
	      fen.setLocationRelativeTo(null);
		  fen.setResizable(false);
		  
		  fen.addWindowListener(new WindowAdapter(){
		        public void windowClosing(WindowEvent e){
		              int reponse = JOptionPane.showConfirmDialog(fen,
		                                   "Voulez-vous quitter l'application ?",
		                                   "Confirmation",
		                                   JOptionPane.YES_NO_OPTION,
		                                   JOptionPane.QUESTION_MESSAGE);
		              if (reponse==JOptionPane.YES_OPTION){
		                      fen.dispose();
		              }
		        }});
		  
		  fen.setVisible(true);
		  
		  // Création de la fenêtre modale
		  JDialog modal = new JDialog(fen,false);
	      modal.setTitle("Bienvenue sur notre application boursière           Version 1.0");
	      modal.setPreferredSize(new Dimension(470,350));
	      modal.setLocation(580, 280);	      
	      JLabel label = new JLabel();
	      label.setBackground(Color.ORANGE);
	      label.setOpaque(true);
	      label.setText("<Html><br>Bienvenue sur notre application boursière !<br><br><br>"
	      		+ "L'application est composée de 3 panneaux:<br><ul><li>Liste des titres</li>"
	      		+ "<li>Liste des traitements</li><li>Résultat graphique</li></ul>"
	      		+ "<br>Vous devez commencer par séléctionner le titre boursier<br>que vous souhaitez analyser"
	      		+ "<br>par un double-click sur le titre choisi."
	      		+ "<br>Une nouvelle fenêtre s'ouvre pour vous permettre de renseigner"
	      		+ "<br>la date de début et de fin de période à extraire."
	      		+ "<br>Enfin cliquer sur le bouton <B>charger le titre sélectionné</B>"
	      		+ "<br>Ensuite vous devez choisir le traitement mathématique à appliquer."
	      		+ "<br><br>Vous verrez alors apparaitre le graphique correspondant à vos choix.<br><br></html>");
	      		
	      modal.add(label, BorderLayout.PAGE_START);
	      modal.pack();
	      modal.setLocationRelativeTo(null);
	      modal.setResizable(false);
	      modal.setVisible(true);	      
}		  
	 
	
// Classes externes pour la gestion des évenements
	
	// Gestion du Click sur le bouton "Charger le titre sélectionné"
	public class BtCharger implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			dl = new Download(rec,Integer.parseInt(anneeDebut.getText()),
					Integer.parseInt(moisDebut.getText()),
					Integer.parseInt(jourDebut.getText()),
					Integer.parseInt(anneeFin.getText()),
					Integer.parseInt(moisFin.getText()),
					Integer.parseInt(jourFin.getText()));
			}
		}
		
	
	// Gestion du Click sur la "liste des titres"	
	public class ClickTitre implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
				// création de la boite de dialogue pour demande des périodes début et fin
						JDialog periode = new JDialog();
						periode.setTitle("Saisir la période à télécharger");
						periode.setPreferredSize(new Dimension(300,150));
					    periode.setLocation(380, 280);

					    	    		
					 //création de la zone "DEBUT"
						JLabel labelDebut = new JLabel("Début :");
						labelDebut.setBounds(50,15,150,15);
					    periode.add(labelDebut);
					    		    
					    anneeDebut = new JTextField();
					    anneeDebut.setBounds(100,10,60,25);
					    periode.add(anneeDebut);
					    
					    moisDebut = new JTextField();
					    moisDebut.setBounds(170,10,40,25);
					    periode.add(moisDebut);
					    
					    jourDebut = new JTextField();
					    jourDebut.setBounds(220,10,40,25);
					    periode.add(jourDebut);    
					    					    
					      
					 //création de la zone "FIN"
					    JLabel labelFin = new JLabel("Fin :");
						labelFin.setBounds(50,80,150,15);
					    periode.add(labelFin);
						
					    anneeFin = new JTextField();
					    anneeFin.setBounds(100,75,60,25);
					    periode.add(anneeFin);
					    					    
					    moisFin = new JTextField();
					    moisFin.setBounds(170,75,40,25);
					    periode.add(moisFin);
					    
					    jourFin = new JTextField();
					    jourFin.setBounds(220,75,40,25);
					    periode.add(jourFin);		      
					    	      
					  		     
				        JLabel labelJJMMAA = new JLabel("aaaa/mm/jj");
					    labelJJMMAA.setBounds(300,100,150,15);
					    labelJJMMAA.setFont(new Font("helvetica",Font.PLAIN,13));
					    labelJJMMAA.setForeground(Color.BLUE);
					    periode.add(labelJJMMAA);
					    
						periode.setModal(false);
					    periode.pack();
					    periode.setVisible(true);
					    
					    
					  // Récupération de la valeur sélectionnée dans la "liste de titre"
				  			    
					   	JList list = (JList) e.getSource();
						int selection[] = list.getSelectedIndices();
						Object selectionValues[] = list.getSelectedValues();
						for (int i=0, n=selection.length; i<n ; i++) {
						rec = (String) selectionValues[i];
			}
						
}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
}
		

	// Gestion du Click sur la "liste des traitements"	
	public class ClickTrait implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			/* ***************************************************** */
			/* insérer ici l'action de dessiner le panneaudroit */
			/* ***************************************************** */
					
}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}


