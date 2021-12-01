package controleur;

public class Bus {
	private int idbus;
	private String matricule, marque;
	private int nbkm;
	private String energie;
	private int anciennete;
	
	public Bus() {
		super();
		this.idbus = 0;
		this.matricule = "";
		this.marque = "";
		this.energie = "";
		this.nbkm = 0;
		this.anciennete = 0;
	}
	
	public Bus (int idbus, String matricule, String marque, int nbkm, String energie, int anciennete) {
		super();
		this.idbus = idbus;
		this.matricule = matricule;
		this.marque = marque;
		this.nbkm = nbkm ;
		this.energie = energie;
		this.anciennete = anciennete;
	}

	public int getIdbus() {
		return idbus;
	}

	public void setIdbus(int idbus) {
		this.idbus = idbus;
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