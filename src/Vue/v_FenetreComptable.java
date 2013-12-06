// Informe du package o� se trouve la classe
package Vue;

/**
 * @ autor Sol�ne Ernoul
*/

//Importation des classes n�cessaire
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class v_FenetreComptable extends JFrame  implements ActionListener {
	/**                          DECLARATION                      **/ 
	
	// Panel
	private JPanel panel; 
	
	// Menu
	private JMenuBar menu;
	private JMenu menuAccueil;
	private JMenu menuVisuVisiteur;
	private JMenu menuValiderFiche;
	private JMenu menuQuitter;
	
	/**                         CONSTRUCTEUR                      **/ 
	v_FenetreComptable(){

		// D�claration du logo GSB comme ic�ne
		Image icone = Toolkit.getDefaultToolkit().getImage("logo.jpg");
		this.setIconImage(icone); // Ajoute l'ic�ne � la fen�tre
		
		this.setTitle("GSB - Home"); //Titre de la fen�tre.
		/* Fermeture de la fen�tre lorsque l'on clique sur la croix
		  (sinon la fen�tre sera ferm�e mais le programme toujours en cours d'ex�cution).*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 250); // Determine la taille de la fen�tre.
		this.setResizable(false); // On interdit le redimensionnement de la fen�tre.
		
		/* Param�tre des menus */
		menu = new JMenuBar(); // Cr�ation du MenuBar
		menuAccueil = new JMenu("Accueil");	// Cr�ation d'un menu "Accueil"
		menuVisuVisiteur = new JMenu("Voir Visiteurs");	// Cr�ation d'un menu "Voir Visiteurs"
		menuValiderFiche = new JMenu("Valider Fiche");	// Cr�ation d'un menu "Valider Fiche"
		menuQuitter = new JMenu ("Quitter"); // Cr�ation d'un menu "Quitter"
		// Ajout au MenuBar
		menu.add(menuAccueil);
		menu.add(menuVisuVisiteur);
		menu.add(menuValiderFiche);
		menu.add(menuQuitter);
		// Ajout le MenuBar � la fen�tre
		this.setJMenuBar(menu);
				
		panel = new JPanel(); // Cr�ation du panel
		this.getContentPane().add(panel); // Ajout du panel au conteneur
		
		// ActionListener
		menuQuitter.addActionListener(this);
		
		this.setLocationRelativeTo(null);// Permet d'avoir la fen�tre au milieu de l'�cran
	    this.setVisible(true); // Permet de voir la fen�tre
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuQuitter){
			// Ferme la fen�tre au moment du clic sur "Quitter"
			this.dispose();
		}
	}	
	
}
