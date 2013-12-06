// Informe du package où se trouve la classe
package Model;
/**
 * @ autor Solène Ernoul
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
	
	// Récupère le Prénom du Comptable
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Récupère le Prénom du Comptable
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}