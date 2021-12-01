package controleur;

public class Vehicule {
	private int idvehicule;
	private String matricule, marque;
	private int nbkm;
	private String energie;
	private int anciennete;
	
	public Vehicule (int idvehicule, String matricule, String marque, int nbkm, String energie, int anciennete) {
		super();
		this.idvehicule = idvehicule;
		this.matricule = matricule;
		this.marque = marque;
		this.nbkm = nbkm ;
		this.energie = energie;
		this.anciennete = anciennete;
	}
	
	public Vehicule() {
		super();
		this.idvehicule = 0;
		this.matricule = "";
		this.marque = "";
		this.nbkm = 0;
		this.energie = "";
		this.anciennete = 0;
	}

	public int getIdvehicule() {
		return idvehicule;
	}

	public void setIdvehicule(int idvehicule) {
		this.idvehicule = idvehicule;
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
