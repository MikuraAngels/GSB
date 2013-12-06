// Informe du package o� se trouve la classe
package Model;
/**
 * @ autor Sol�ne Ernoul
 * 
*/

// Importation des classes n�cessaire
import java.sql.*;
import java.util.ArrayList;

public class m_Model{
	/**                          DECLARATION                       **/ 
	
	static Connection connect = null;
	boolean ValidCo;
 	Statement st1;
	private static ArrayList <m_Visiteur> mesVisiteurs;
	
 	/* Permet de r�cup�r� la valeur (false ou true) 
 	 * Pour ajouter une erreur lors de la connexion
 	 * Si l'utilisateur s'est tromp� dans son login/mot de passe
 	 */
	public boolean getValidCo() {
		return ValidCo;
	}

	/* Permet de modifier la valeur (false ou true) 
 	 * Pour ajouter une erreur lors de la connexion
 	 * Si l'utilisateur s'est tromp� dans son login/mot de passe
 	 */
	public void setValidCo(boolean validCo) {
		ValidCo = validCo;
	}

	// Controleur
	public m_Model() {

	}
	
	/**                          FONCTION                           **/
	
	// Fonction de connexion � la base de ddonn�es
	public static Connection connecterdb() {
		
		try {
		// Charge le driver "com.mysql.jdbc.Driver"
		Class.forName("com.mysql.jdbc.Driver");
		
		// Connexion � la base de donn�e		
		connect = DriverManager.getConnection("jdbc:mysql://localhost/gsb_frais" , "root", "");
		System.out.println("Connexion � la base r�ussi !");
		}
		catch (SQLException erreur) {
			// Affiche une erreur si la connexion n'a pas correctement fonctionn�
			System.out.println("Erreur de connexion � la base.");
		}
	
		catch (ClassNotFoundException e) {
			// Ajoute une erreur si le driver "com.mysql.jdbc.Driver" n'a pas �t� charg�
			System.out.println("Driver non charg�, connexion impossible.");
		}
		
		// Retourne le r�sultat de la connexion
		return connect;
	}
	
	// Fonction de d�connexion � la base de donn�es
	public static boolean deconnecterdb() {
		// instanciation du bool�en en false
		boolean bool = false;
		try {
			// r�cup�re la connexion pour la fermer
			connect.close();
			// ajoute un boul�en true pour pr�venir de la fermeture de la connexion
			bool = true ;
		}
		catch (SQLException erreur) {
			// ajoute un boul�en false pour pr�venir que la connexion ne s'est pas ferm�e
			bool = false;
			
		}
		// Retourne le r�sultat du bool�en
		return bool;
	}
	
	public void connexionComptable(String monLogin, String monMdp){
		// Met � false avant la validation de la connexion
		setValidCo(false);
		try {
			// Creation de la requ�te pour la connexion
			st1 = connect.createStatement();
			// Requ�te qui r�cup�re l'utilisateur selon son login, son mot de passe et si il est comptable
			ResultSet rs = st1.executeQuery("SELECT login, mdp " +
											"FROM utilisateur " +
											"WHERE login='" + monLogin + "' AND mdp='" + monMdp +"' AND statut='Comptable'");
			
			// Recup�re les donn�es pour la connexion
			while(rs.next()){
				rs.getString(1);
				rs.getString(2);
				
				// Met � true si la connexion est bonne afin de la valider 
				setValidCo(true);
				System.out.println("Connexion R�ussi");
			}
			
			// Ferme le ResultSet
			rs.close();
		}
		
		catch (SQLException e) {
			// Ajoute une erreur si le comptable n'a pas pu �tre r�cup�r�
			System.out.println("Impossible de r�cup�rer le comptable.");
		}
		
		// R�cup�re la valeur du setValidCo(...)
		getValidCo();
	}
	
	public static ArrayList<m_Visiteur> afficherVisiteur() {
		mesVisiteurs = new ArrayList<m_Visiteur>();
		PreparedStatement st2;
		try {
			connect = connecterdb();		
			st2 = connect.prepareStatement("SELECT nom, prenom, " +
										   "FROM utilisateur " +
										   "WHERE statut='visiteur';");
			ResultSet rs = st2.executeQuery();
			while (rs.next()) {
				mesVisiteurs.add(new m_Visiteur(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
		
			System.out.println("Erreur requete");
		}

		return mesVisiteurs;
	}
}