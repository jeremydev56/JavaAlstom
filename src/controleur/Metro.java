package controleur;

public class Metro {
	private int idmetro;
	private String matricule, marque;
	private int nbkm;
	private String energie;
	private int anciennete;
	
	public Metro() {
		super();
		this.idmetro = 0;
		this.matricule = "";
		this.marque = "";
		this.nbkm = 0;
		this.energie = "";
		this.anciennete = 0;
	}
	
	public Metro (int idmetro, String matricule, String marque, int nbkm, String energie, int anciennete) {
		super();
		this.idmetro = idmetro;
		this.matricule = matricule;
		this.marque = marque;
		this.nbkm = nbkm ;
		this.energie = energie;
		this.anciennete = anciennete;
	}

	public int getIdmetro() {
		return idmetro;
	}

	public void setIdmetro(int idmetro) {
		this.idmetro = idmetro;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getNbkm() {
		return nbkm;
	}

	public void setNbkm(int nbkm) {
		this.nbkm = nbkm;
	}

	public String getEnergie() {
		return energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}

	public int getAnciennete() {
		return anciennete;
	}

	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}
}