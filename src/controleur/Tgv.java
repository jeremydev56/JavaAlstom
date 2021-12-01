package controleur;

public class Tgv {
	private int idtgv;
	private String matricule, marque, energie;
	private int nbkm;
	private int anciennete;
	
	public Tgv (int idtgv, String matricule, String marque, int nbkm, String energie,  int anciennete) {
		super();
		this.idtgv = idtgv;
		this.matricule = matricule;
		this.marque = marque;
		this.nbkm = nbkm ;
		this.energie = energie;
		this.anciennete = anciennete;
	}
	
	public Tgv() {
		super();
		this.idtgv = 0;
		this.matricule = "";
		this.marque = "";
		this.nbkm = 0;
		this.energie = "";
		this.anciennete = 0;
	}

	public int getIdtgv() {
		return idtgv;
	}

	public void setIdtgv(int idtgv) {
		this.idtgv = idtgv;
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
