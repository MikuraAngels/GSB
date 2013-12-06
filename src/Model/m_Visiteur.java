// Informe du package où se trouve la classe
package Model;

/**
 * @ autor Solène Ernoul
*/

public class m_Visiteur {
	/**                          DECLARATION                       **/ 
	private String nom;
	private String prenom;	
	
	/**                          METHODE                           **/
	
	// Controleur
	public m_Visiteur(String sonNom, String sonPrenom){
		this.nom=sonNom;
		this.prenom=sonPrenom;	
	}

	/*                          Methode get/set                     */
	
	// Récupère le Nom du Visiteur
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// Récupère le Prénom du Visiteur
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
