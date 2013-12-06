// Informe du package où se trouve la classe
package Model;
/**
 * @ autor Solène Ernoul
 * 
*/

// Importation des classes nécessaire
import java.sql.*;
import java.util.ArrayList;

public class m_Model{
	/**                          DECLARATION                       **/ 
	
	static Connection connect = null;
	boolean ValidCo;
 	Statement st1;
	private static ArrayList <m_Visiteur> mesVisiteurs;
	
 	/* Permet de récupéré la valeur (false ou true) 
 	 * Pour ajouter une erreur lors de la connexion
 	 * Si l'utilisateur s'est trompé dans son login/mot de passe
 	 */
	public boolean getValidCo() {
		return ValidCo;
	}

	/* Permet de modifier la valeur (false ou true) 
 	 * Pour ajouter une erreur lors de la connexion
 	 * Si l'utilisateur s'est trompé dans son login/mot de passe
 	 */
	public void setValidCo(boolean validCo) {
		ValidCo = validCo;
	}

	// Controleur
	public m_Model() {

	}
	
	/**                          FONCTION                           **/
	
	// Fonction de connexion à la base de ddonnées
	public static Connection connecterdb() {
		
		try {
		// Charge le driver "com.mysql.jdbc.Driver"
		Class.forName("com.mysql.jdbc.Driver");
		
		// Connexion à la base de donnée		
		connect = DriverManager.getConnection("jdbc:mysql://localhost/gsb_frais" , "root", "");
		System.out.println("Connexion à la base réussi !");
		}
		catch (SQLException erreur) {
			// Affiche une erreur si la connexion n'a pas correctement fonctionné
			System.out.println("Erreur de connexion à la base.");
		}
	
		catch (ClassNotFoundException e) {
			// Ajoute une erreur si le driver "com.mysql.jdbc.Driver" n'a pas été chargé
			System.out.println("Driver non chargé, connexion impossible.");
		}
		
		// Retourne le résultat de la connexion
		return connect;
	}
	
	// Fonction de déconnexion à la base de données
	public static boolean deconnecterdb() {
		// instanciation du booléen en false
		boolean bool = false;
		try {
			// récupère la connexion pour la fermer
			connect.close();
			// ajoute un bouléen true pour prévenir de la fermeture de la connexion
			bool = true ;
		}
		catch (SQLException erreur) {
			// ajoute un bouléen false pour prévenir que la connexion ne s'est pas fermée
			bool = false;
			
		}
		// Retourne le résultat du booléen
		return bool;
	}
	
	public void connexionComptable(String monLogin, String monMdp){
		// Met à false avant la validation de la connexion
		setValidCo(false);
		try {
			// Creation de la requête pour la connexion
			st1 = connect.createStatement();
			// Requête qui récupère l'utilisateur selon son login, son mot de passe et si il est comptable
			ResultSet rs = st1.executeQuery("SELECT login, mdp " +
											"FROM utilisateur " +
											"WHERE login='" + monLogin + "' AND mdp='" + monMdp +"' AND statut='Comptable'");
			
			// Recupère les données pour la connexion
			while(rs.next()){
				rs.getString(1);
				rs.getString(2);
				
				// Met à true si la connexion est bonne afin de la valider 
				setValidCo(true);
				System.out.println("Connexion Réussi");
			}
			
			// Ferme le ResultSet
			rs.close();
		}
		
		catch (SQLException e) {
			// Ajoute une erreur si le comptable n'a pas pu être récupéré
			System.out.println("Impossible de récupérer le comptable.");
		}
		
		// Récupère la valeur du setValidCo(...)
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