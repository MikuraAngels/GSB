package Model;
public class Comptable {
	
	private String nom;
	private String prenom;
	
	public Comptable(String unNom, String unPrenom){
		this.nom=unNom;
		this.prenom=unPrenom;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}