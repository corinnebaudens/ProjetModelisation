package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Fenetre  extends JFrame  implements ActionListener {

	private JTextField Titre;
	public Fenetre()
	{
	      this.setPreferredSize(new Dimension(800,600));
	      this.setTitle("Traitement de Séries chronologiques boursières");
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.pack();
	      this.setLocationRelativeTo(null);
	      this.setResizable(true);
	      	      
	      JPanel pan = new JPanel();
	      pan.setBackground(Color.RED);
	      this.setContentPane(pan);
	      
	      this.setLayout(new BorderLayout());
	      Container c = this.getContentPane();
	      pan.add(new JButton ("Télécharger"),BorderLayout.SOUTH);
	      
	      //JButton buton = new JButton("Télécharger");
	     // pan.add(buton);
	      
	      String [] Elts = {"AI.AP", "CAC40"};
	      JList liste = new JList(Elts);
	      JLabel text = new JLabel("Choisissez un titre");
	      
	      pan.add(text,BorderLayout.NORTH);
	      pan.add(liste);	  
	      
	      pan.setBorder(BorderFactory.createTitledBorder("une bordure"));
	   
	      this.setVisible(true);
	      

	}
	  // public static void main(String[] args)
	  // {
	  //    Fenetre f = new Fenetre();
	  // }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
