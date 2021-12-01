package controleur;

public class User {
	private int iduser;
	private String email, mdp, nom, prenom, droits;
	
	// Plusieurs constructeurs = surcharge
	
	public User(int iduser, String email, String mdp, String nom, String prenom, String droits) {
		super();
		this.iduser = iduser;
		this.email = email;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.droits = droits;
	}

	public User() {
		super();
		this.iduser = 0;
		this.email = "";
		this.mdp = "";
		this.nom = "";
		this.prenom = "";
		this.droits = "";
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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

	public String getDroits() {
		return droits;
	}

	public void setDroits(String droits) {
		this.droits = droits;
	}
}
