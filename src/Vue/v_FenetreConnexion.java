package Vue;

/**
 * @ autor Solène Ernoul
*/

//Importation des classes nécessaire

import javax.swing.*;
import Model.m_Model;
import java.awt.*;
import java.awt.event.* ;
import java.sql.Connection;

@SuppressWarnings("serial")
public class v_FenetreConnexion extends JFrame implements ActionListener {
	/**                          DECLARATION                      **/ 
	
	// Panel
	private JPanel panel; 
	private JPanel panel_principal;
	private JPanel panel_label;
	private JPanel panel_field;
	private JPanel panel_button;
	
	// Label 
	private JLabel lblLogin;
	private JLabel lblMdp;

	// Champs de texte
	private JTextField jtxLogin; 
	private JPasswordField jpxMdp;
	
	// Bouton
	private JButton btnConnexion;
	private JButton	btnAnnuler;

	// String pour champs de texte
	private String strLogin;
	private String strMdp;
	
	// Boite de dialogue
	private JOptionPane jop;	
	private JOptionPane jop2;	
	
	// Déclaration de la connexion
	m_Model maConnexion = new m_Model();
	@SuppressWarnings("static-access")
	Connection connection = maConnexion.connecterdb();
	
	/**                          CONTRUCTEUR                        */
	public v_FenetreConnexion(){
		
		// Déclaration du logo GSB comme icône
		Image icone = Toolkit.getDefaultToolkit().getImage("logo.jpg");
		this.setIconImage(icone); // Ajoute l'icône à la fenêtre
		
		this.setTitle("Connexion"); //Titre de la fenêtre.
		/* Fermeture de la fenêtre lorsque l'on clique sur la croix
		 * (sinon la fenêtre sera fermée mais le programme toujours en cours d'exécution).*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); // On interdit le redimensionnement de la fenêtre.
		
		// Paramètre des panels
			//-> Création panel
		panel = new JPanel();
		this.getContentPane().add(panel);
			//-> Création des panel avec ajout de Layout
	    panel_principal = new JPanel(new BorderLayout()); 
	    panel_label = new JPanel(new GridLayout(2,1));
	    panel_field = new JPanel(new GridLayout(2,1)); 
	    panel_button = new JPanel(new GridLayout(1,2));
	    	//-> Ajout des panels au panel principal
	    panel_principal.add(panel_label, BorderLayout.WEST);
	    panel_principal.add(panel_field, BorderLayout.CENTER);
	    panel_principal.add(panel_button, BorderLayout.SOUTH);
	   
	    // Paramètre des Labels
	    lblLogin = new JLabel ("Login");
	    panel_label.add(lblLogin); // Ajout du Label au panel_label 
	    jtxLogin = new JTextField();
	    panel_field.add(jtxLogin); // Ajout du Champs de texte au panel_field
	    
	    lblMdp = new JLabel ("Mot de passe");
	    panel_label.add(lblMdp); // Ajout du Label au panel_label 
	    jpxMdp = new JPasswordField();
	    panel_field.add(jpxMdp);  // Ajout du Champs de texte au panel_field
	    
	    
	    // Paramètre des bouton
	    btnAnnuler = new JButton("Annuler" );
	    panel_button.add(btnAnnuler); // Ajout du Button au panel_button
	    btnConnexion = new JButton("Connexion");
	    panel_button.add(btnConnexion); // Ajout du Button au panel_button

	    // Paramètre panel
	    panel.add(panel_principal);// Ajout du panel_principal au panel de base
	    
	    // ActionListener
	    btnAnnuler.addActionListener(this);
	    btnConnexion.addActionListener(this);
	    
	    this.pack(); // Compacte la fenêtre
		this.setLocationRelativeTo(null);// Permet d'avoir la fenêtre au milieu de l'écran
	    this.setVisible(true); // Permet de voir la fenêtre
	 
	}

	@SuppressWarnings({ "static-access", "unused" })
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAnnuler){
			// Affiche un message de fermeture de fenêtre lors d'un clic sur le bouton Annuler
			jop2.showMessageDialog(null, "Fermeture de la fenêtre.", "Attention", JOptionPane.INFORMATION_MESSAGE);
			// Ferme la fenêtre
			this.dispose();
		}
		
		if (e.getSource() == btnConnexion){
			// Récupère le Login pour le mettre dans un String
			strLogin = new String(jtxLogin.getText());
			// Récupère le Mot de passe pour le mettre dans un String
			strMdp   = new String(jpxMdp.getPassword());
			
			// Ajoute les informations login et mot de passe à la fonction connexionCompte
			maConnexion.connexionComptable(strLogin, strMdp);
			
			// Si l'utilisateur entre les bonnes informations de connexion, on ouvre la fenêtre comptable
			if(maConnexion.getValidCo() == true){
				// Ferme la fenêtre
				this.dispose();
				// Créé la nouvelle fenêtre
				v_FenetreComptable maFenetreComptable = new v_FenetreComptable();
			}
			//Sinon, on affiche une erreur
			else{
			// Affiche un message d'erreur (Login ou Mot de passe) si l'utilisateur rentre mal ses informations
				jop.showMessageDialog(null, "Login ou Mot de passe incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}