package vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.*;


public class Fenetre  extends JFrame implements ActionListener {

	public Fenetre()
	{
	      setPreferredSize(new Dimension(530,600));
	      setTitle("Traitement de Séries chronologiques boursières");
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	      setResizable(true);
	      setVisible(true);

	}
	   public static void main(String[] args)
	   {
	      Fenetre f = new Fenetre();
	   }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
