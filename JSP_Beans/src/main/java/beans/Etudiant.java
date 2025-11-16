package beans;

public class Etudiant {

	public String nom;
	public String prenom;
	public double note;
	
	public Etudiant() {}
	
	public String getNom() {
		return nom;
		
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public String getPrenom() {
		return prenom;
		
	}
	public void setPrenom(String prenom) {
		this.prenom= prenom;
	}
	
	public double getNote() {
		return note;
		
	}
	public void setNote(double note) {
		this.note= note;
	}
}
