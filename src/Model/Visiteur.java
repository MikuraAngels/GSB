package Model;

public class Visiteur {
	
	private String nom;
	private String prenom;

	
	public Visiteur(String sonNom, String sonPrenom){
		this.nom=sonNom;
		this.prenom=sonPrenom;	
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