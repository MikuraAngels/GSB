// Informe du package o� se trouve la classe
package Model;
/**
 * @ autor Sol�ne Ernoul
 * 
*/
public class m_Comptable {
	/**                          DECLARATION                       **/ 
	private String nom;
	private String prenom;

	/**                          METHODE                           **/
	
	// Controleur
	public m_Comptable(String unNom, String unPrenom){
		this.nom=unNom;
		this.prenom=unPrenom;	
	}

	/*                          Methode get/set                     */
	
	// R�cup�re le Pr�nom du Comptable
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// R�cup�re le Pr�nom du Comptable
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}