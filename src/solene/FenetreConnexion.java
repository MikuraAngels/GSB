package solene;

import javax.swing.*;

import com.mysql.*;
import java.awt.*;
import java.awt.event.* ;
import java.sql.Connection;

public class FenetreConnexion extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JPanel panel_principal;
	private JPanel panel_label;
	private JPanel panel_field;
	private JPanel panel_button;
	
	private JLabel lblLogin;
	private JLabel lblMdp;

	private JTextField jtxLogin;
	private JPasswordField jpxMdp;
	 
	private JButton btnConnexion;
	private JButton	btnAnnuler;

	private String strLogin;
	private String strMdp;
	
	private JOptionPane jop;	
	private JOptionPane jop2;	
	
	Model maConnexion = new Model();
	Connection connection = maConnexion.connecterdb();
	
	FenetreConnexion(){
		this.setTitle("Connexion"); //Titre de la fenêtre.
		/* Fermeture de la fenêtre lorsque l'on clique sur la croix
		  (sinon la fenêtre sera fermée mais le programme toujours en cours d'exécution).*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); // On interdit le redimensionnement de la fenêtre.
		
		panel = new JPanel();
		this.getContentPane().add(panel);
		
	    panel_principal = new JPanel(new BorderLayout());
	    panel_label = new JPanel(new GridLayout(2,1));
	    panel_field = new JPanel(new GridLayout(2,1));
	    panel_button = new JPanel(new GridLayout(1,2));
	    panel_principal.add(panel_label, BorderLayout.WEST);
	    panel_principal.add(panel_field, BorderLayout.CENTER);
	    panel_principal.add(panel_button, BorderLayout.SOUTH);
	   
	    lblLogin = new JLabel ("Login");
	    panel_label.add(lblLogin);
	    jtxLogin = new JTextField();
	    panel_field.add(jtxLogin);
	     
	    lblMdp = new JLabel ("Mot de passe");
	    panel_label.add(lblMdp);
	    jpxMdp = new JPasswordField();
	    panel_field.add(jpxMdp); 
	    
	    btnAnnuler = new JButton("Annuler" );
	    panel_button.add(btnAnnuler);	    
	    btnConnexion = new JButton("Connexion");
	    panel_button.add(btnConnexion);

	   
	    panel.add(panel_principal);
	    
	    btnAnnuler.addActionListener(this);
	    btnConnexion.addActionListener(this);
	    
	    this.pack();
		this.setLocationRelativeTo(null);// Permet d'avoir la fenêtre au milieu de l'écran
	    this.setVisible(true); // Permet de voir la fenêtre
	 
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAnnuler){
			jop2.showMessageDialog(null, "Fermeture de la fenêtre.", "Attention", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
		
		if (e.getSource() == btnConnexion){
			strLogin = new String(jtxLogin.getText());
			strMdp   = new String(jpxMdp.getPassword());
			maConnexion.connexionComptable(strLogin, strMdp);
			
			if(maConnexion.getValidCo() == true){
				FenetreComptable maFenetreComptable = new FenetreComptable();
			}
		else{
				jop.showMessageDialog(null, "Login ou Mot de passe incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}