// Informe du package où se trouve la classe
package Vue;

/**
 * @ autor Solène Ernoul
*/

//Importation des classes nécessaire
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

		// Déclaration du logo GSB comme icône
		Image icone = Toolkit.getDefaultToolkit().getImage("logo.jpg");
		this.setIconImage(icone); // Ajoute l'icône à la fenêtre
		
		this.setTitle("GSB - Home"); //Titre de la fenêtre.
		/* Fermeture de la fenêtre lorsque l'on clique sur la croix
		  (sinon la fenêtre sera fermée mais le programme toujours en cours d'exécution).*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 250); // Determine la taille de la fenêtre.
		this.setResizable(false); // On interdit le redimensionnement de la fenêtre.
		
		/* Paramètre des menus */
		menu = new JMenuBar(); // Création du MenuBar
		menuAccueil = new JMenu("Accueil");	// Création d'un menu "Accueil"
		menuVisuVisiteur = new JMenu("Voir Visiteurs");	// Création d'un menu "Voir Visiteurs"
		menuValiderFiche = new JMenu("Valider Fiche");	// Création d'un menu "Valider Fiche"
		menuQuitter = new JMenu ("Quitter"); // Création d'un menu "Quitter"
		// Ajout au MenuBar
		menu.add(menuAccueil);
		menu.add(menuVisuVisiteur);
		menu.add(menuValiderFiche);
		menu.add(menuQuitter);
		// Ajout le MenuBar à la fenêtre
		this.setJMenuBar(menu);
				
		panel = new JPanel(); // Création du panel
		this.getContentPane().add(panel); // Ajout du panel au conteneur
		
		// ActionListener
		menuQuitter.addActionListener(this);
		
		this.setLocationRelativeTo(null);// Permet d'avoir la fenêtre au milieu de l'écran
	    this.setVisible(true); // Permet de voir la fenêtre
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuQuitter){
			// Ferme la fenêtre au moment du clic sur "Quitter"
			this.dispose();
		}
	}	
	
}
