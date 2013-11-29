package solene;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FenetreComptable extends JFrame  implements ActionListener {
	private JMenuBar menu;
	private JMenu menuAccueil;
	private JMenu menuVisuVisiteur;
	private JMenu menuValiderFiche;
	private JMenu menuQuitter;
	
	FenetreComptable(){
		Image icone = Toolkit.getDefaultToolkit().getImage("logo.jpg");
		this.setIconImage(icone);
		
		this.setTitle("GSB - Home"); //Titre de la fen�tre.
		/* Fermeture de la fen�tre lorsque l'on clique sur la croix
		  (sinon la fen�tre sera ferm�e mais le programme toujours en cours d'ex�cution).*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 250); // Determine la taille de la fen�tre.
		this.setResizable(false); // On interdit le redimensionnement de la fen�tre.
		
		menu = new JMenuBar();
		menuAccueil = new JMenu("Accueil");	
		menuVisuVisiteur = new JMenu("Voir Visiteurs");	
		menuValiderFiche = new JMenu("Valider Fiche");	
		menuQuitter = new JMenu ("Quitter");
		menu.add(menuAccueil);
		menu.add(menuVisuVisiteur);
		menu.add(menuValiderFiche);
		menu.add(menuQuitter);
		this.setJMenuBar(menu);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel);
		
		menuQuitter.addActionListener(this);
		
		this.setLocationRelativeTo(null);// Permet d'avoir la fen�tre au milieu de l'�cran
	    this.setVisible(true); // Permet de voir la fen�tre
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuQuitter){
			this.dispose();
		}
	}	
	
}
