package controleur;

import java.util.ArrayList;



// importation du modèle
import modele.Modele;

import vue.VueConnexion;
import vue.VueAdmin;
import vue.VueBus;
import vue.VueEmploye;
import vue.VueMetro;
import vue.VueTgv;
import vue.VueVehicule;


public class Main {
	// instanciation des vues
	private static VueConnexion uneVueConnexion;
	private static VueConnexion uneVueAdmin;
	private static VueBus unevueBus;
	private static VueEmploye uneVueEmploye;
	private static VueMetro uneVueMetro;
	private static VueTgv uneVueTgv;
	private static VueVehicule uneVueVehicule;
	
	
	
	
	public static void main(String[] args)
	{
		uneVueConnexion = new VueConnexion();
	}
	
	/******************************* Gestion des vues ********************************/
	
	public static void instancierVueAdmin()
	{
		new VueAdmin();
	}
	
	public static void instancierVueBus()
	{
		new VueBus();
	}
	
	public static void instancierVueEmploye()
	{
		new VueEmploye();
	}
	
	public static void instancierVueMetro()
	{
		new VueMetro();
	}
	
	public static void instancierVueTgv()
	{
		new VueTgv();
	}
	
	public static void instancierVueVehicule()
	{
		new VueVehicule();
	}
	
	public static void rendreVisible(boolean action)
	{
		uneVueConnexion.setVisible(action);
	}
	
	public static User verifConnexion(String email, String mdp)
	{
		return Modele.verifConnexion(email,mdp);
	}
	
	/******************************* Controleur Admin ********************************/
	
	public static void insertAdmin(Admin unAdmin)
	{
		//ici on réalise des controles avant insertion
		Modele.insertAdmin(unAdmin);
	}
	
	public static void deleteAdmin(int idadmin)
	{
		Modele.deleteAdmin(idadmin);
	}
	
	public static void updateAdmin(Admin unAdmin)
	{
		//ici on réalise des controles avant mise à jour
		Modele.updateAdmin(unAdmin);
	}
	
	public static Admin selectWhereAdmin(int idadmin)
	{
		return Modele.selectWhereAdmin(idadmin);
	}
	
	public static Admin selectWhereAdmin (String qualification, String tel)
	{
		
		return Modele.selectWhereAdmin(qualification, tel);
	}
	
	public static ArrayList<Admin> selectAllAdmins  (String mot)
	{
		return Modele.selectAllAdmins(mot);
	}
	
	/******************************* Controleur Bus ********************************/
	
	public static void insertBus(Bus unBus)
	{
		//ici on réalise des controles avant insertion
		Modele.insertBus(unBus);
	}
	
	public static void deleteBus(int idbus)
	{
		Modele.deleteBus(idbus);
	}
	
	public static void updateBus(Bus unBus)
	{
		//ici on réalise des controles avant mise à jour
		Modele.updateBus(unBus);
	}
	
	public static Bus selectWhereBus(int idbus)
	{
		return Modele.selectWhereBus(idbus);
	}
	
	public static Bus selectWhereBus (String matricule, String marque)
	{
		
		return Modele.selectWhereBus(matricule, marque);
	}
	
	public static ArrayList<Bus> selectAllBus (String mot)
	{
		return Modele.selectAllBus(mot);
	}
	
	/******************************* Controleur Employe *******************************/
	
	public static void insertEmploye(Employe unEmploye)
	{
		//ici on réalise des controles avant insertion
		Modele.insertEmploye(unEmploye);
	}
	
	public static void deleteEmploye(int idemploye)
	{
		Modele.deleteEmploye(idemploye);
	}
	
	public static void updateEmploye(Employe unEmploye)
	{
		//ici on réalise des controles avant mise à jour
		Modele.updateEmploye(unEmploye);
	}
	
	public static Employe selectWhereEmploye(int idemploye)
	{
		return Modele.selectWhereEmploye(idemploye);
	}
	
	public static Employe selectWhereEmploye (String qualification, String tel)
	{
		
		return Modele.selectWhereEmploye(qualification, tel);
	}
	
	public static ArrayList<Employe> selectAllEmployes  (String mot)
	{
		return Modele.selectAllEmployes(mot);
	}

	
	/******************************* Controleur Metro ********************************/
	
	public static void insertMetro(Metro unMetro)
	{
		//ici on réalise des controles avant insertion
		Modele.insertMetro(unMetro);
	}
	
	public static void deleteMetro(int idmetro)
	{
		Modele.deleteMetro(idmetro);
	}
	
	public static void updateMetro(Metro unMetro)
	{
		//ici on réalise des controles avant mise à jour
		Modele.updateMetro(unMetro);
	}
	
	public static Metro selectWhereMetro(int idmetro)
	{
		return Modele.selectWhereMetro(idmetro);
	}
	
	public static Metro selectWhereMetro (String matricule, String marque)
	{
		
		return Modele.selectWhereMetro(matricule, marque);
	}
	
	public static ArrayList<Metro> selectAllMetros  (String mot)
	{
		return Modele.selectAllMetros(mot);
	}
	
	/******************************* Controleur TGV *******************************/
	
	public static void insertTgv(Tgv unTgv)
	{
		//ici on réalise des controles avant insertion
		Modele.insertTgv(unTgv);
	}
	
	public static void deleteTgv(int idTgv)
	{
		Modele.deleteTgv(idTgv);
	}
	
	public static void updateTgv(Tgv unTgv)
	{
		//ici on réalise des controles avant mise à jour
		Modele.updateTgv(unTgv);
	}
	
	public static Tgv selectWhereTgv(int idtgv)
	{
		return Modele.selectWhereTgv(idtgv);
	}
	
	public static Tgv selectWhereTgv (String matricule, String marque)
	{
		
		return Modele.selectWhereTgv(matricule, marque);
	}
	
	public static ArrayList<Tgv> selectAllTgv (String mot)
	{
		return Modele.selectAllTgv(mot);
	}
	
	/******************************* Controleur Vehicule *******************************/
	
	public static void insertVehicule(Vehicule unVehicule)
	{
		//ici on réalise des controles avant insertion
		Modele.insertVehicule(unVehicule);
	}
	
	public static void deleteVehicule(int idVehicule)
	{
		Modele.deleteVehicule(idVehicule);
	}
	
	public static void updateVehicule(Vehicule unVehicule)
	{
		//ici on réalise des controles avant mise à jour
		Modele.updateVehicule(unVehicule);
	}
	
	public static Vehicule selectWhereVehicule(int idvehicule)
	{
		return Modele.selectWhereVehicule(idvehicule);
	}
	
	public static Vehicule selectWhereVehicule (String matricule, String marque)
	{
		
		return Modele.selectWhereVehicule(matricule, marque);
	}
	
	public static ArrayList<Vehicule> selectAllVehicules (String mot)
	{
		return Modele.selectAllVehicules(mot);
	}
}
