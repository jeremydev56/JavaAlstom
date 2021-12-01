package controleur;

public class Employe {
	private int idemploye;
	private String nom, prenom, qualification, tel ;
	private int anciennete;
	
	public Employe() {
		super();
		this.idemploye = 0;
		this.nom = "";
		this.prenom = "";
		this.qualification = "";
		this.tel = "";
		this.anciennete = 0;	
	}
	
	public Employe(int idemploye, String nom, String prenom, String qualification, String tel, int anciennete) {
		super();
		this.idemploye = idemploye;
		this.nom = nom;
		this.prenom = prenom;
		this.qualification = qualification;
		this.tel = tel;
		this.anciennete = anciennete;
	}

	public int getIdemploye() {
		return idemploye;
	}

	public void setIdemploye(int idemploye) {
		this.idemploye = idemploye;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAnciennete() {
		return anciennete;
	}

	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}	
}
