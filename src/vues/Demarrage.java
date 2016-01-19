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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;

import controleur.Controleur;
import modeles.Download;




public class Demarrage {//implements ActionListener, ListSelectionListener {

	JFrame fen;
	JScrollPane scrollTitre, scrollTraitement, scrollGraph;
	JList ListTitre, ListTraitement, ListGraph;
	JButton Bouton;
	JPanel panG, panC, panD, panelBouton, panelPeriode;
	JTextField text, jourDebut, moisDebut, anneeDebut, jourFin, moisFin, anneeFin;
	JDialog periode;
	String rec;
	Download dl;
	
		
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
	      		
	      		//Bouton.addActionListener(new ActionListener() {
	      			//public void actionPerformed(ActionEvent evt) {
	      		//Bouton.addActionListener(new BtCharger());	
	      		//ListTitre.addListSelectionListener(new BtCharger());
	      		ListTitre.addMouseListener(new BtCharger());
	      		Bouton.addActionListener(new BtCharger());
	      				/* Essai pour le téléchargement d'un fichier csv
	      				 * Pour l'instant, celui-ci se fait à la racine du projet
	      				 */
	      				//Download dl = new Download("AI.PA", 2015, 12, 01, 2015, 12, 29);
	      					      				     				
	      				//JLabel labelDebut = new JLabel("Début :");
	      				//JLabel labelFin = new JLabel("Fin :");
	      				//JTextField debut = new JTextField("YYYY-MM-DD");
	      				//JTextField fin = new JTextField("YYYY-MM-DD");
	      				//JLabel lab = new JLabel ("");
	      				//Object [] tab = new Object [] {labelDebut, debut, labelFin, fin, lab};
	      				//int rep = JOptionPane.showOptionDialog(fen, tab, "Entrez dates de début et fin de période", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,null);
	      				//JOptionPane jop = new JOptionPane();
	      				//String name = jop.showInputDialog(null, "Entrez dates de début et de fin de période","périodes à définir",JOptionPane.QUESTION_MESSAGE);
	      				
	      				//ListTitre.addListSelectionListener(this);
	      				//Download dl = new Download("AI.PA", 2015, 12, 01, 2015, 12, 29);
	      			//}
	      		//});
	      		//fin de l'ajout du bouton
	      		
	      panG.add(panelBouton);
	      panG.setPreferredSize(new Dimension(150,500));
	      
	      
	      
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
	      modal.setPreferredSize(new Dimension(470,400));
	      modal.setLocation(580, 280);
	      //modal.setUndecorated(true);
	      
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
	      		+ "<br><br>Vous verrez alors apparaitre le graphique correspondant à vos choix.<br><br><Html>");
	      modal.add(label, BorderLayout.PAGE_START);
	      modal.pack();
	      modal.setLocationRelativeTo(null);
	      modal.setResizable(false);
	      modal.setVisible(true);
	      
	      
	}		  
	 
	
// Classes externes pour la gestion des évenements
	
	public class BtCharger implements ListSelectionListener, ActionListener, MouseListener {
		
		
		//@Override
		//public void actionPerformed(ActionEvent e) {
			
			
			//if(JOptionPane.OK_CANCEL_OPTION == 1) {
			//} dl = new Download("", 2015, 12, 01, 2015, 12, 29);
	//}
		/*@Override
		public void valueChanged(ListSelectionEvent e) {
			
				// création de la boite de dialogue pour demande des périodes début et fin
			JDialog periode = new JDialog();
			periode.setTitle("Saisir la période à télécharger");
			periode.setPreferredSize(new Dimension(400,200));
		    periode.setLocation(380, 280);
		    		
		    		//création de la zone "DEBUT"
			JLabel labelDebut = new JLabel("Début :");
			labelDebut.setBounds(50,65,150,15);
		    periode.add(labelDebut);
		    		    
		    anneeDebut = new JTextField();
		    anneeDebut.setBounds(180,60,60,25);
		    periode.add(anneeDebut);
		    
		    moisDebut = new JTextField();
		    moisDebut.setBounds(240,60,40,25);
		    periode.add(moisDebut);
		    
		    jourDebut = new JTextField();
		    jourDebut.setBounds(300,60,40,25);
		    periode.add(jourDebut);
		    		    
		    
		      
		    
		    
		    //JLabel labelJJMMAA = new JLabel("(jj/mm/aaaa)");
		    //labelJJMMAA.setBounds(380,65,150,15);
		    //labelJJMMAA.setFont(new Font("helvetica",Font.PLAIN,13));
		    //periode.add(labelJJMMAA);
		      
		     		//création de la zone "FIN"
		    JLabel labelFin = new JLabel("Fin :");
			labelFin.setBounds(50,100,150,15);
		    periode.add(labelFin);
			
		    anneeFin = new JTextField();
		    anneeFin.setBounds(180,95,60,25);
		    periode.add(anneeFin);
		    
		    
		    moisFin = new JTextField();
		    moisFin.setBounds(240,95,40,25);
		    periode.add(moisFin);
		    
		    jourFin = new JTextField();
		    jourFin.setBounds(300,95,40,25);
		    periode.add(jourFin);
		      
		    
		      
		    
		      
	        JLabel labelJJMMAA2 = new JLabel("(aaaa/mm/jj)");
		    labelJJMMAA2.setBounds(380,100,250,15);
		    labelJJMMAA2.setFont(new Font("helvetica",Font.PLAIN,13));
		    periode.add(labelJJMMAA2);
		      
			//JTextField debut = new JTextField("YYYY-MM-DD");
			//JTextField fin = new JTextField("YYYY-MM-DD");
		   
			
			periode.setModal(false);
		    periode.pack();
		    periode.setVisible(true);
			//periode.setDefaultCloseOperation(JDialog.e);
			
		    
		   	//JLabel lab = new JLabel ("");
			//Object [] tab = new Object [] {labelDebut, debut, labelFin, fin, lab};
			//int rep = JOptionPane.showOptionDialog(fen, tab, "Entrez dates de début et fin de période", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,null);
			JList list = (JList) e.getSource();
			int selection[] = list.getSelectedIndices();
			Object selectionValues[] = list.getSelectedValues();
			for (int i=0, n=selection.length; i<n ; i++) {
			System.out.println(selectionValues[i]);
			String rec = (String) selectionValues[i];
			//dl = new Download(rec, Integer.parseInt(anneeDebut.getText()), Integer.parseInt(moisDebut.getText()), Integer.parseInt(jourDebut.getText()), Integer.parseInt(anneeFin.getText()),
			//	Integer.parseInt(moisFin.getText()), Integer.parseInt(jourFin.getText()));
			//dl = new Download("AI.PA",2015,02,02,2015,03,03);
			}
			
			}*/
		public void actionPerformed(ActionEvent e) {
			//JList list = (JList) e.getSource();
			//int selection[] = list.getSelectedIndices();
			//Object selectionValues[] = list.getSelectedValues();
			//for (int i=0, n=selection.length; i<n ; i++) {
				//System.out.println(selectionValues[i]);
				//String rec = (String) selectionValues[i];
				
			//}
			
			dl = new Download("ALU.PA",Integer.parseInt(anneeDebut.getText()),
					Integer.parseInt(moisDebut.getText()),
					Integer.parseInt(jourDebut.getText()),
					Integer.parseInt(anneeFin.getText()),
					Integer.parseInt(moisFin.getText()),
					Integer.parseInt(jourFin.getText()));
			//System.out.println(rec);
			//System.out.println(Integer.parseInt(moisDebut.getText()));
			//System.out.println(Integer.parseInt(jourDebut.getText()));
			//System.out.println(Integer.parseInt(anneeFin.getText()));
			//System.out.println(Integer.parseInt(moisFin.getText()));
			//System.out.println(Integer.parseInt(jourFin.getText()));
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			
			// création de la boite de dialogue pour demande des périodes début et fin
						JDialog periode = new JDialog();
						periode.setTitle("Saisir la période à télécharger");
						periode.setPreferredSize(new Dimension(400,200));
					    periode.setLocation(380, 280);
					    		
					    		//création de la zone "DEBUT"
						JLabel labelDebut = new JLabel("Début :");
						labelDebut.setBounds(50,65,150,15);
					    periode.add(labelDebut);
					    		    
					    anneeDebut = new JTextField();
					    anneeDebut.setBounds(180,60,60,25);
					    periode.add(anneeDebut);
					    
					    moisDebut = new JTextField();
					    moisDebut.setBounds(240,60,40,25);
					    periode.add(moisDebut);
					    
					    jourDebut = new JTextField();
					    jourDebut.setBounds(300,60,40,25);
					    periode.add(jourDebut);
					    		    
					    
					      
					    
					    
					    //JLabel labelJJMMAA = new JLabel("(jj/mm/aaaa)");
					    //labelJJMMAA.setBounds(380,65,150,15);
					    //labelJJMMAA.setFont(new Font("helvetica",Font.PLAIN,13));
					    //periode.add(labelJJMMAA);
					      
					     		//création de la zone "FIN"
					    JLabel labelFin = new JLabel("Fin :");
						labelFin.setBounds(50,100,150,15);
					    periode.add(labelFin);
						
					    anneeFin = new JTextField();
					    anneeFin.setBounds(180,95,60,25);
					    periode.add(anneeFin);
					    
					    
					    moisFin = new JTextField();
					    moisFin.setBounds(240,95,40,25);
					    periode.add(moisFin);
					    
					    jourFin = new JTextField();
					    jourFin.setBounds(300,95,40,25);
					    periode.add(jourFin);
					      
					    
					      
					    
					      
				        JLabel labelJJMMAA2 = new JLabel("(aaaa/mm/jj)");
					    labelJJMMAA2.setBounds(380,100,250,15);
					    labelJJMMAA2.setFont(new Font("helvetica",Font.PLAIN,13));
					    periode.add(labelJJMMAA2);
					      
						//JTextField debut = new JTextField("YYYY-MM-DD");
						//JTextField fin = new JTextField("YYYY-MM-DD");
					   
						
						periode.setModal(false);
					    periode.pack();
					    periode.setVisible(true);
						//periode.setDefaultCloseOperation(JDialog.e);
						
					    
					   	//JLabel lab = new JLabel ("");
						//Object [] tab = new Object [] {labelDebut, debut, labelFin, fin, lab};
						//int rep = JOptionPane.showOptionDialog(fen, tab, "Entrez dates de début et fin de période", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,null);
						JList list = (JList) e.getSource();
						int selection[] = list.getSelectedIndices();
						Object selectionValues[] = list.getSelectedValues();
						for (int i=0, n=selection.length; i<n ; i++) {
						System.out.println(selectionValues[i]);
						String rec = (String) selectionValues[i];
						//dl = new Download(rec, Integer.parseInt(anneeDebut.getText()), Integer.parseInt(moisDebut.getText()), Integer.parseInt(jourDebut.getText()), Integer.parseInt(anneeFin.getText()),
						//	Integer.parseInt(moisFin.getText()), Integer.parseInt(jourFin.getText()));
						//dl = new Download("AI.PA",2015,02,02,2015,03,03);
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
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		}
		
		}



