package modele;


import java.sql.SQLException;


import java.sql.Connection;
import java.sql.DriverManager;

public class Bdd 
{
	// ATTRIBUTS DE LA BASE DE DONNEES
	private String serveur, user, mdp ;
	private String bdd = "alstom";
	private Connection maConnexion ; 

	public Bdd(String serveur, String bdd, String user, String mdp) {
		// CONSTRUCTEURS DE LA BASE DE DONNEES
		this.serveur = serveur;
		this.bdd = bdd;
		this.user = user;
		this.mdp = mdp;
	} 
	
	public void chargerPilote ()
	{
		// METHODE POUR CHARLER LE PILOTE JDBC
		try {
			//Vérifier la présence du pilote 
			Class.forName("com.mysql.jdbc.Driver"); 
		}
		catch(ClassNotFoundException exp) {
			System.out.println("Le pilote JDBC n'existe pas");
		}
	}
	public void seConnecter() {
		// METHODE POUR SE CONNECTER A LA BASE DE DONNEES
		this.chargerPilote(); 
		String url = "jdbc:mysql://" + this.serveur + "/" + this.bdd ; 
		try
		{
			this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de connexion à url : " + url);
		}
	}
	public void seDeconnecter ()
	{
		// METHODE POUR SE DECONNECTER DE LA BASE DE DONNEES
		try {
			if (this.maConnexion != null) {
				this.maConnexion.close();
			}
		}
		catch (SQLException exp)
		{	
			System.out.println("Erreur lors de la fermeture de la connexion ");
			//exp.printStackTrace();
		}
	}
	
	// Getter
	
	public Connection getMaConnexion ()
	{
		return this.maConnexion; 
	}
	
	
}
