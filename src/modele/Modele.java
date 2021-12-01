package modele;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.User;

import controleur.Admin;
import controleur.Bus;
import controleur.Employe;
import controleur.Metro;
import controleur.Tgv;
import controleur.Vehicule;

public class Modele
{
	private static Bdd uneBdd = new Bdd("localhost","alstom","root","");
	
	public static User verifConnexion (String email, String mdp)
	{
		User unUser = null;
		String requete = "select * from user where email = '" +email+"'and mdp = '"+mdp+"';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				unUser = new User(unRes.getInt("iduser"), unRes.getString("email"), unRes.getString("mdp"), unRes.getString("nom"), unRes.getString("prenom"), unRes.getString("droits"));
			}
			unRes.close();
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (Exception e) {
			System.out.println("Erreur d'exécution de la requete : " + requete);
		}
		
		return(unUser);
	}
	
	/* --------------------les methodes de gestion de la table Admin -------------------- */
	public static void insertAdmin (Admin unAdmin)
	{
		String requete ="insert into admin values (null, '"
	+ unAdmin.getNom() + "','"
	+ unAdmin.getPrenom() +"','"
	+ unAdmin.getQualification() + "','"
	+ unAdmin.getTel()+ "','"
	+ unAdmin.getAnciennete() +"' );" ;
		/* 
		 * ERREUR réparée !!!!
		 * Il manquait la cote après les guillemets sur ancienneté
		 * !!!
		 */
		executerRequete(requete);
	}
	
	public static void deleteAdmin (int idadmin)
	{
		String requete = "delete from admin where idadmin = "+idadmin +" ; " ;
		executerRequete(requete);	
	}
	
	public static void updateAdmin (Admin unAdmin)
	{
		String requete ="update admin set nom = '" + unAdmin.getNom()
		+ "', prenom = '" + unAdmin.getPrenom()
		+ "', qualification = '" + unAdmin.getQualification()
		+ "', tel = '" + unAdmin.getTel()
		+ "', anciennete = '" + unAdmin.getAnciennete()
		+ "', where idadmin = " + unAdmin.getIdadmin() + " ;" ;
		executerRequete(requete);	
	}
	
	public static Admin selectWhereAdmin(int idadmin)
	{
		Admin unAdmin=null;
		String requete = "select * from admin where idadmin = "+idadmin+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()){
				unAdmin = new Admin (
						unRes.getInt("idadmin"),
						unRes.getString("nom"),
						unRes.getString("prenom"),
						unRes.getString("qualification"), 
						unRes.getString("téléphone"),
						unRes.getInt("ancienneté")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (Exception exp) {
			System.out.println("Erreur d'exécution de la requete : "+ requete);
		}
		return unAdmin;
	}
	
	//surcharge de la méthode avec de nouveaux arguments 
		public static Admin selectWhereAdmin (String qualification, String tel)
		{
			String requete ="select * from admin where qualification = '"+ qualification +"' and tel = '"+tel +"' ;" ;
			Admin unAdmin = null ; 
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unAdmin = new Admin (
							unRes.getInt("idadmin"),
							unRes.getString("nom"),
							unRes.getString("prenom"),
							unRes.getString("qualification"), 
							unRes.getString("tel"),
							unRes.getInt("anciennete")
							);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return unAdmin ; 
		}
	
	public static ArrayList<Admin> selectAllAdmins(String mot)
	{
		String requete ; 
		if (mot.equals("")) {
			requete ="select * from admin ;" ;
		}
		else
		{
			requete ="select * from admin where nom like '%"+mot+"%' or prenom like '%"+mot+"%' or qualification like '%" + mot + "%' ; " ;
		}
		ArrayList<Admin> lesAdmins = new ArrayList<Admin>();  
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while(desRes.next())
			{
				Admin unAdmin = new Admin(
						desRes.getInt("idadmin"),
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getString("qualification"),
						desRes.getString("tel"),
						desRes.getInt("anciennete"));
				lesAdmins.add(unAdmin);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (Exception e) {
			System.out.println("Erreur d'exécution de la requete : "+requete);
		}
		return(lesAdmins);
	}
	public static void executerRequete (String requete)
	{
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (Exception exc) {
			System.out.println("Erreur d'execution de la requete : "+requete);
		}
	}
	
	/* --------------------les methodes de gestion de la table Bus -------------------- */

	public static void insertBus (Bus unBus)
	{
		String requete ="insert into bus values (null, '"
	+ unBus.getMatricule() + "','"
	+ unBus.getMarque() +"','"
	+ unBus.getNbkm() + "','"
	+ unBus.getEnergie() + "','"
	+ unBus.getAnciennete() +"' );" ;
		/* 
		 * ERREUR réparée !!!!
		 * Il manquait la cote après les guillemets sur ancienneté
		 * !!!
		 */
		executerRequete(requete);
	}
	
	public static void deleteBus (int idbus)
	{
		String requete = "delete from bus where idbus = "+idbus +" ; " ;
		executerRequete(requete);	
	}
	
	public static void updateBus (Bus unBus)
	{
		String requete ="update bus set matricule = '" + unBus.getMatricule()
		+ "', marque = '" + unBus.getMarque()
		+ "', nbkm = '" + unBus.getNbkm()
		+ "', energie = '" + unBus.getEnergie()
		+ "', anciennete = '" + unBus.getAnciennete()
		+ "', where idbus = " + unBus.getIdbus() + " ;" ;
		executerRequete(requete);	
	}
	
	public static Bus selectWhereBus(int idbus)
	{
		Bus unBus=null;
		String requete = "select * from bus where idbus = "+idbus+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()){
				unBus = new Bus (
						unRes.getInt("idbus"),
						unRes.getString("matricule"),
						unRes.getString("marque"),
						unRes.getInt("nbkm"),
						unRes.getString("energie"),
						unRes.getInt("anciennete")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (Exception exp) {
			System.out.println("Erreur d'exécution de la requete : "+ requete);
		}
		return unBus;
	}
	
	//surcharge de la méthode avec de nouveaux arguments 
		public static Bus selectWhereBus (String matricule, String marque)
		{
			String requete ="select * from bus where matricule = '"+ matricule +"' and marque = '"+ marque +"' ;" ;
			Bus unBus = null ; 
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unBus = new Bus (
							unRes.getInt("idbus"),
							unRes.getString("matricule"),
							unRes.getString("marque"),
							unRes.getInt("nbkm"),
							unRes.getString("energie"),
							unRes.getInt("anciennete")
							);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return unBus ; 
		}
	
	public static ArrayList<Bus> selectAllBus(String mot)
	{
		String requete ; 
		if (mot.equals("")) {
			requete ="select * from bus ;" ;
		}
		else
		{
			requete ="select * from bus where matricule like '%"+mot+"%' or marque like '%"+mot+"%' or energie like '%" + mot + "%' ; " ;
		}
		ArrayList<Bus> lesBus = new ArrayList<Bus>();  
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while(desRes.next())
			{
				Bus unBus = new Bus(
						desRes.getInt("idbus"),
						desRes.getString("matricule"),
						desRes.getString("marque"),
						desRes.getInt("nbkm"),
						desRes.getString("energie"),
						desRes.getInt("anciennete"));
				lesBus.add(unBus);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (Exception e) {
			System.out.println("Erreur d'exécution de la requete : "+requete);
		}
		return(lesBus);
	}
	
	
	/* --------------------les methodes de gestion de la table Employe -------------------- */
	
	public static void insertEmploye(Employe unEmploye)
	{
		String requete ="insert into employe values (null, '"
	+ unEmploye.getNom() + "','"
	+ unEmploye.getPrenom() +"','"
	+ unEmploye.getQualification() + "','"
	+ unEmploye.getTel()+ "','"
	+ unEmploye.getAnciennete() +"' );" ;
		
		executerRequete(requete);
	}
	
	public static void deleteEmploye (int idemploye)
	{
		String requete = "delete from employe where idemploye = "+idemploye +" ; " ;
		executerRequete(requete);	
	}
	
	public static void updateEmploye (Employe unEmploye)
	{
		String requete ="update employe set nom = '" + unEmploye.getNom()
		+ "', prenom = '" + unEmploye.getPrenom()
		+ "', qualification = '" +unEmploye.getQualification()
		+ "', tel = '" + unEmploye.getTel()
		+ "', anciennete = '" + unEmploye.getAnciennete()
		+ "', where idemploye = " + unEmploye.getIdemploye() + " ;" ;
		executerRequete(requete);	
	}
	
	public static Employe selectWhereEmploye(int idemploye)
	{
		Employe unEmploye=null;
		
		String requete = "select * from employe where idemploye = "+idemploye+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()){
				unEmploye = new Employe (
						unRes.getInt("idemploye"),
						unRes.getString("nom"),
						unRes.getString("prenom"),
						unRes.getString("qualification"), 
						unRes.getString("tel"),
						unRes.getInt("anciennete")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (Exception exp) {
			System.out.println("Erreur d'exécution de la requete : "+ requete);
		}
		return unEmploye;
	}
	
	//surcharge de la méthode avec de nouveaux arguments 
		public static Employe selectWhereEmploye (String qualification, String tel)
		{
			String requete ="select * from employe where qualification = ' "+ qualification +" ' and tel = ' "+tel +" ' ;" ;
			Employe unEmploye = null ; 
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unEmploye = new Employe (
							unRes.getInt("idemploye"),
							unRes.getString("nom"),
							unRes.getString("prenom"),
							unRes.getString("qualification"), 
							unRes.getString("tel"),
							unRes.getInt("anciennete")
							);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return unEmploye ; 
		}
	
		public static ArrayList<Employe> selectAllEmployes(String mot)
		{
			String requete ; 
			if (mot.equals("")) {
				requete ="select * from employe ;" ;
			}
			else
			{
				requete ="select * from employe where nom like '%"+mot+"%' or prenom like '%"+mot+"%' or qualification like '%" + mot + "%' ; " ;
			}
			ArrayList<Employe> lesEmployes = new ArrayList<Employe>();  
			
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				while(desRes.next())
				{
					Employe unEmploye = new Employe(
							desRes.getInt("idemploye"),
							desRes.getString("nom"),
							desRes.getString("prenom"),
							desRes.getString("qualification"),
							desRes.getString("tel"),
							desRes.getInt("anciennete"));
					lesEmployes.add(unEmploye);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			} catch (Exception e) {
				System.out.println("Erreur d'exécution de la requete : "+requete);
			}
			return(lesEmployes);
		}
	
	
	/* --------------------les methodes de gestion de la table Metro -------------------- */

		public static void insertMetro(Metro unMetro)
		{
			String requete ="insert into metro values (null, '"
		+ unMetro.getMatricule() + "','"
		+ unMetro.getMarque() +"','"
		+ unMetro.getNbkm() + "','"
		+ unMetro.getEnergie() + "','"
		+ unMetro.getAnciennete() +"' );" ;
			
			executerRequete(requete);
		}
		
		public static void deleteMetro(int idmetro)
		{
			String requete = "delete from metro where idmetro = "+idmetro +" ; " ;
			executerRequete(requete);	
		}
		
		public static void updateMetro(Metro unMetro)
		{
			String requete ="update metro set matricule = '" + unMetro.getMatricule()
			+ "', marque = '" + unMetro.getMarque()
			+ "', nbkm = '" + unMetro.getNbkm()
			+ "', energie = '" + unMetro.getEnergie()
			+ "', anciennete = '" + unMetro.getAnciennete() + " ;" ;
			executerRequete(requete);	
		}
		
		public static Metro selectWhereMetro(int idmetro)
		{
			Metro unMetro=null;
			String requete = "select * from metro where idmetro = "+idmetro+";";
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				if(unRes.next()){
					unMetro = new Metro (
							unRes.getInt("idmetro"),
							unRes.getString("matricule"),
							unRes.getString("marque"),
							unRes.getInt("nbkm"),
							unRes.getString("energie"),
							unRes.getInt("anciennete")
							);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			} catch (Exception exp) {
				System.out.println("Erreur d'exécution de la requete : "+ requete);
			}
			return unMetro;
		}
		
		//surcharge de la méthode avec de nouveaux arguments 
			public static Metro selectWhereMetro (String matricule, String marque)
			{
				String requete ="select * from metro where matricule = '"+ matricule +"' and marque = '"+ marque +"' ;" ;
				Metro unMetro = null ; 
				try {
					uneBdd.seConnecter();
					Statement unStat = uneBdd.getMaConnexion().createStatement(); 
					ResultSet unRes = unStat.executeQuery(requete);
					if (unRes.next()) {
						unMetro = new Metro (
								unRes.getInt("idmetro"),
								unRes.getString("matricule"),
								unRes.getString("marque"),
								unRes.getInt("nbkm"),
								unRes.getString("energie"),
								unRes.getInt("anciennete")
								);
					}
					unStat.close();
					uneBdd.seDeconnecter();
				}
				catch(SQLException exp) {
					System.out.println("Erreur d'exécution de la requete : " + requete );
				}
				return unMetro ; 
			}
		
			public static ArrayList<Metro> selectAllMetros(String mot)
			{
				String requete ; 
				if (mot.equals("")) {
					requete ="select * from metro ;" ;
				}
				else
				{
					requete ="select * from metro where matricule like '%"+mot+"%' or marque like '%"+mot+"%' or energie like '%" + mot + "%' ; " ;
				}
				
				ArrayList<Metro> lesMetros = new ArrayList<Metro>();  
				
				try {
					uneBdd.seConnecter();
					Statement unStat = uneBdd.getMaConnexion().createStatement();
					ResultSet desRes = unStat.executeQuery(requete);
					while(desRes.next())
					{
						Metro unMetro = new Metro(
								desRes.getInt("idmetro"),
								desRes.getString("matricule"),
								desRes.getString("marque"),
								desRes.getInt("nbkm"),
								desRes.getString("energie"),
								desRes.getInt("anciennete"));
						
						lesMetros.add(unMetro);
					}
					unStat.close();
					uneBdd.seDeconnecter();
				} catch (Exception e) {
					System.out.println("Erreur d'exécution de la requete : "+requete);
				}
				return(lesMetros);
			}
	
	
		
		/* --------------------les methodes de gestion de la table TGV -------------------- */

		public static void insertTgv(Tgv unTgv)
		{
			String requete ="insert into Tgv values (null, '"
		+ unTgv.getMatricule() + "','"
		+ unTgv.getMarque() +"','"
		+ unTgv.getNbkm() + "','"
		+ unTgv.getEnergie() + "','"
		+ unTgv.getAnciennete() +"' );" ;
			/* 
			 * ERREUR réparée !!!!
			 * Il manquait la cote après les guillemets sur ancienneté
			 * !!!
			 */
			executerRequete(requete);
		}
		
		public static void deleteTgv(int idtgv)
		{
			String requete = "delete from tgv where idtgv = "+idtgv +" ; " ;
			executerRequete(requete);	
		}
		
		public static void updateTgv (Tgv unTgv)
		{
			String requete ="update tgv set matricule = '" + unTgv.getMatricule()
			+ "', marque = '" + unTgv.getMarque()
			+ "', nbkm = '" + unTgv.getNbkm()
			+ "', energie = '" + unTgv.getEnergie()
			+ "', anciennete = '" + unTgv.getAnciennete() + " ;" ;
			executerRequete(requete);	
		}
		
		public static Tgv selectWhereTgv(int idtgv)
		{
			Tgv unTgv=null;
			String requete = "select * from tgv where idtgv = "+idtgv+";";
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				if(unRes.next()){
					unTgv = new Tgv (
							unRes.getInt("idtgv"),
							unRes.getString("matricule"),
							unRes.getString("marque"),
							unRes.getInt("nbkm"),
							unRes.getString("energie"),
							unRes.getInt("anciennete")
							);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			} catch (Exception exp) {
				System.out.println("Erreur d'exécution de la requete : "+ requete);
			}
			return unTgv;
		}
		
		//surcharge de la méthode avec de nouveaux arguments 
			public static Tgv selectWhereTgv (String matricule, String marque)
			{
				String requete ="select * from tgv where matricule = '"+ matricule +"' and marque = '"+ marque +"' ;" ;
				Tgv unTgv = null ; 
				try {
					uneBdd.seConnecter();
					Statement unStat = uneBdd.getMaConnexion().createStatement(); 
					ResultSet unRes = unStat.executeQuery(requete);
					if (unRes.next()) {
						unTgv = new Tgv (
								unRes.getInt("idtgv"),
								unRes.getString("matricule"),
								unRes.getString("marque"),
								unRes.getInt("nbkm"),
								unRes.getString("energie"),
								unRes.getInt("anciennete")
								);
					}
					unStat.close();
					uneBdd.seDeconnecter();
				}
				catch(SQLException exp) {
					System.out.println("Erreur d'exécution de la requete : " + requete );
				}
				return unTgv ; 
			}
		
			public static ArrayList<Tgv> selectAllTgv(String mot)
			{
				String requete ; 
				if (mot.equals("")) {
					requete ="select * from tgv ;" ;
				}
				else
				{
					requete ="select * from tgv where matricule like '%"+mot+"%' or marque like '%"+mot+"%' or energie like '%" + mot + "%' ; " ;
				}
				
				ArrayList<Tgv> lesTgv = new ArrayList<Tgv>();  
				
				try {
					uneBdd.seConnecter();
					Statement unStat = uneBdd.getMaConnexion().createStatement();
					ResultSet desRes = unStat.executeQuery(requete);
					while(desRes.next())
					{
						Tgv unTgv = new Tgv(
								desRes.getInt("idtgv"),
								desRes.getString("matricule"),
								desRes.getString("marque"),
								desRes.getInt("nbkm"),
								desRes.getString("energie"),
								desRes.getInt("anciennete"));
						
						lesTgv.add(unTgv);
					}
					unStat.close();
					uneBdd.seDeconnecter();
				} catch (Exception e) {
					System.out.println("Erreur d'exécution de la requete : "+requete);
				}
				return(lesTgv);
			}
			
			
			/* --------------------les methodes de gestion de la table Véhicule -------------------- */

			public static void insertVehicule(Vehicule unVehicule)
			{
				String requete ="insert into vehicule values (null, '"
			+ unVehicule.getMatricule() + "','"
			+ unVehicule.getMarque() +"','"
			+ unVehicule.getNbkm() + "','"
			+ unVehicule.getEnergie() + "','"
			+ unVehicule.getAnciennete() +"' );" ;
				/* 
				 * ERREUR réparée !!!!
				 * Il manquait la cote après les guillemets sur ancienneté
				 * !!!
				 */
				executerRequete(requete);
			}
			
			public static void deleteVehicule (int idvehicule)
			{
				String requete = "delete from vehicule where idvehicule = "+idvehicule +" ; " ;
				executerRequete(requete);	
			}
			
			public static void updateVehicule (Vehicule unVehicule)
			{
				String requete ="update vehicule set matricule = '" + unVehicule.getMatricule()
				+ "', marque = '" + unVehicule.getMarque()
				+ "', nbkm = '" + unVehicule.getNbkm()
				+ "', energie = '" + unVehicule.getEnergie()
				+ "', anciennete = '" + unVehicule.getAnciennete() + " ;" ;
				executerRequete(requete);	
			}
			
			public static Vehicule selectWhereVehicule(int idvehicule)
			{
				Vehicule unVehicule=null;
				String requete = "select * from vehicule where idvehicule = "+idvehicule+";";
				try {
					uneBdd.seConnecter();
					Statement unStat = uneBdd.getMaConnexion().createStatement();
					ResultSet unRes = unStat.executeQuery(requete);
					if(unRes.next()){
						unVehicule = new Vehicule (
								unRes.getInt("idvehicule"),
								unRes.getString("matricule"),
								unRes.getString("marque"),
								unRes.getInt("nbkm"),
								unRes.getString("energie"),
								unRes.getInt("anciennete")
								);
					}
					unStat.close();
					uneBdd.seDeconnecter();
				} catch (Exception exp) {
					System.out.println("Erreur d'exécution de la requete : "+ requete);
				}
				return unVehicule;
			}
			
			//surcharge de la méthode avec de nouveaux arguments 
				public static Vehicule selectWhereVehicule (String matricule, String marque)
				{
					String requete ="select * from vehicule where matricule = '"+ matricule +"' and marque = '"+ marque +"' ;" ;
					Vehicule unVehicule = null ; 
					try {
						uneBdd.seConnecter();
						Statement unStat = uneBdd.getMaConnexion().createStatement(); 
						ResultSet unRes = unStat.executeQuery(requete);
						if (unRes.next()) {
							unVehicule = new Vehicule (
									unRes.getInt("idvehicule"),
									unRes.getString("matricule"),
									unRes.getString("marque"),
									unRes.getInt("nbkm"),
									unRes.getString("energie"),
									unRes.getInt("anciennete")
									);
						}
						unStat.close();
						uneBdd.seDeconnecter();
					}
					catch(SQLException exp) {
						System.out.println("Erreur d'exécution de la requete : " + requete );
					}
					return unVehicule ; 
				}
			
			public static ArrayList<Vehicule> selectAllVehicules(String mot)
			{
				String requete ; 
				if (mot.equals("")) {
					requete ="select * from vehicule ;" ;
				}
				else
				{
					requete ="select * from vehicule where matricule like '%"+mot+"%' or marque like '%"+mot+"%' or energie like '%" + mot + "%' ; " ;
				}
				ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();  
				
				try {
					uneBdd.seConnecter();
					Statement unStat = uneBdd.getMaConnexion().createStatement();
					ResultSet desRes = unStat.executeQuery(requete);
					while(desRes.next())
					{
						Vehicule unVehicule = new Vehicule(
								desRes.getInt("idvehicule"),
								desRes.getString("matricule"),
								desRes.getString("marque"),
								desRes.getInt("nbkm"),
								desRes.getString("energie"),
								desRes.getInt("anciennete"));
						lesVehicules.add(unVehicule);
					}
					unStat.close();
					uneBdd.seDeconnecter();
				} catch (Exception e) {
					System.out.println("Erreur d'exécution de la requete : "+requete);
				}
				return(lesVehicules);
			}		
}
