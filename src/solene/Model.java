package solene;
import java.sql.*;
import java.util.ArrayList;

public class Model{
	static Connection connect = null;
	boolean ValidCo;
 	Statement st1;
	
	public boolean getValidCo() {
		return ValidCo;
	}


	public void setValidCo(boolean validCo) {
		ValidCo = validCo;
	}


	public Model() {

	}
	

	public static Connection connecterdb() {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		connect = DriverManager.getConnection("jdbc:mysql://localhost/gsb_frais" , "root", "");
		System.out.println("Connexion � la base r�ussi !");
		}
		catch (SQLException erreur) {
			System.out.println("Erreur de connexion � la base.");
		}
	
		catch (ClassNotFoundException e) {
			
			System.out.println("Driver non charg�, connexion impossible.");
		}
		return connect;
	}
	
	
	public static boolean deconnecterdb() {
		boolean bool;
		try {
			connect.close();
			bool = true ;
		}
		catch (SQLException erreur) {
			bool = false;
			
		}
		return bool;
	}
	
	public void connexionComptable(String monLogin, String monMdp){
		setValidCo(false);
		try {
			st1 = connect.createStatement();
			ResultSet rs = st1.executeQuery("SELECT login, mdp " +
											"FROM visiteur " +
											"WHERE login='" + monLogin + "' AND mdp='" + monMdp +"' AND statut='Comptable'");
			
			while(rs.next()){
				rs.getString(1);
				rs.getString(2);
				
				setValidCo(true);
				System.out.println("Connexion R�ussi");
			}
			
			rs.close();
		}
		
		catch (SQLException e) {
			System.out.println("Impossible de r�cup�rer le comptable.");
		}
		
		getValidCo();
	}
}