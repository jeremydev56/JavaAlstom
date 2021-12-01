package vue;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Bus;
import controleur.Main;
import controleur.Vehicule;
import controleur.Tableau;
import controleur.Tgv;

@SuppressWarnings("serial")

public class VueVehicule extends JFrame implements ActionListener {
	// instanciation des fenêtres d'ajout et de liste
	private JPanel panelAjout = new JPanel();
	private JPanel panelLister = new JPanel();
	
	
	// instanciation des boutons
	private JButton btRetour = new JButton("Retour au Menu");
	
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtMatricule = new JTextField(); 
	private JTextField txtMarque = new JTextField(); 
	private JTextField txtEnergie= new JTextField(); 
	private JTextField txtNbKm = new JTextField();
	private JTextField txtAnciennete = new JTextField();

	// instanciation du tableau
	private JTable uneTable ; 
	// instanciation du menu déroulant
	private JScrollPane uneScroll ; 
	private Tableau unTableau ;
	
	// instanciation du mot de recherche
	private JTextField txtMot = new JTextField ();
	private JButton btFiltrer = new JButton("filtrer"); 
	
	public VueVehicule()
	{
		// FENÊTRE PRINCIPALE
		this.setBounds(100, 100, 900, 500);
		this.setTitle("Gestion des véhicules d'Alstom");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		// RGB = Red, Green, Blue
		this.getContentPane().setBackground(new Color(0,0,200));
		
		//installer le bouton retour
		// (x,y, longueur, largeur)
		this.btRetour.setBounds(730, 430, 140, 30);
		this.add(this.btRetour);
		this.btRetour.addActionListener(this);
		
		//construction du panel Ajout
		this.panelAjout.setBounds(40, 100, 300, 250);
		
		// rendre le panel Ajout en blanc (255,255,255)
		this.panelAjout.setBackground(new Color (255, 255, 255));
		
		this.panelAjout.setLayout(new GridLayout(7,2));
		this.panelAjout.add(new JLabel("Matricule :")); 
		this.panelAjout.add(this.txtMatricule);
		this.panelAjout.add(new JLabel("Marque :")); 
		this.panelAjout.add(this.txtMarque);
		this.panelAjout.add(new JLabel("Nombre de kilomètres :")); 
		this.panelAjout.add(this.txtNbKm);
		this.panelAjout.add(new JLabel("Énergie :")); 
		this.panelAjout.add(this.txtEnergie);
		this.panelAjout.add(new JLabel("Ancienneté :"));
		this.panelAjout.add(this.txtAnciennete);
				
		this.panelAjout.add(this.btAnnuler); 
		this.panelAjout.add(this.btEnregistrer);
				
		this.add(this.panelAjout);
				
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		// rendre les boutons rouges (255,70,70)
		this.btAnnuler.setBackground(new Color(255,70,70));
		this.btEnregistrer.setBackground(new Color(255,70,70));
		this.btRetour.setBackground(new Color(255,70,70));
		this.btFiltrer.setBackground(new Color(255,70,70));
				
		//construire le panel Lister 
		// rendre le panelLister en blanc (255,255,255)
		this.panelLister.setBackground(new Color (255, 255, 255  ));
				
		
		this.panelLister.setLayout(null);
		this.add(this.panelLister); 
				
		this.remplirPanelLister ("");
				
			//suppression d'un admin de la table 
				
				this.uneTable.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() >=2)
							{
							/* s'il y a 2 clics sur la ligne :
							 * suppression des lignes
							 */
							int ligne = uneTable.getSelectedRow();
							System.out.println(ligne);
							int idvehicule = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString()); 
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce véhicule ?", "Suppression", JOptionPane.YES_NO_OPTION); 
							if (retour == 0) // si clic sur Yes
								{
								int idVehicule = 0;
								//suppression dans la base 
								Main.deleteVehicule(idVehicule);
								//suppression dans la table d'affichage 
								unTableau.deleteLigne(ligne);
								JOptionPane.showMessageDialog(null, "Suppression réussie");
							}
						}
						else if (e.getClickCount() ==1) {
							/* s'il y a 1 clic sur la ligne :
							 * modification des lignes
							 */
							int ligne = uneTable.getSelectedRow();
							
							txtMatricule.setText(unTableau.getValueAt(ligne, 1).toString());
							txtMarque.setText(unTableau.getValueAt(ligne, 2).toString());
							txtNbKm.setText(unTableau.getValueAt(ligne, 3).toString());
							txtEnergie.setText(unTableau.getValueAt(ligne, 4).toString());
							txtAnciennete.setText(unTableau.getValueAt(ligne, 5).toString());
							
							btEnregistrer.setText("Modifier");
						}
					}
				});
				
				//filter les bus par un mot de recherche 
				this.txtMot.setBounds(450, 40, 100, 20);
				this.add(this.txtMot); 
				this.btFiltrer.setBounds(580, 40, 100, 20);
				this.add(this.btFiltrer);
				this.btFiltrer.addActionListener(this);
		
		this.setVisible(true);
	}
	
public void remplirPanelLister(String mot) {
		// menu de liste
		this.panelLister.removeAll();
		String entetes [] = {"ID Véhicule", "Matricule", "Marque", "Nbkm", "Energie", "Ancienneté"};
		Object donnees [][] = this.getDonnees (mot) ;		
		this.unTableau = new Tableau (donnees, entetes);
		this.uneTable = new JTable(this.unTableau); 
		this.uneScroll = new JScrollPane(this.uneTable); 
		this.panelLister.setBounds(350, 80, 530, 300);
		
		this.uneScroll.setBounds(20, 20, 510, 280);
		this.panelLister.add(this.uneScroll);
		
	}

	public Object [] [] getDonnees(String mot) {
		//recuperer les Tgv de la bdd 
		ArrayList<Vehicule> lesVehicules = Main.selectAllVehicules(mot); 
		//transofrmation des admins en matrice de données 
		Object donnees [][] = new Object [lesVehicules.size()][7];
		int i = 0 ; 
		for (Vehicule unVehicule : lesVehicules) {
			donnees[i][0] = unVehicule.getIdvehicule()+""; 
			donnees[i][1] = unVehicule.getMatricule(); 
			donnees[i][2] = unVehicule.getMarque();
			donnees[i][3] = unVehicule.getNbkm(); 
			donnees[i][4] = unVehicule.getEnergie(); 
			donnees[i][5] = unVehicule.getAnciennete() + ""; 
			i++; 
		}
				
		return donnees;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btRetour) {
			this.dispose ();
			//retour au menu
			Main.rendreVisible(true);
		}
		else if (e.getSource() == this.btAnnuler)
		{
			// Si clic sur le bouton annuler
			this.viderLesChamps ();
			// les champs sont vidés
		}
		else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Enregistrer")) 
		{
			// si clic sur le bouton enregistrer
			this.insertVehicule(); 
			// le tgv est inséré
		}
		else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Modifier")) 
		{
			// si clic sur le bouton modifier
			this.updateVehicule ();
			// le tgv est modifié
		}
		else if (e.getSource() == this.btFiltrer)
		{
			// si clic sur le bouton filtrer
			this.remplirPanelLister(this.txtMot.getText());
			// la recherche est renvoyée sur le mot recherché
		}
	}
	
	public void insertVehicule() {
		String matricule = this.txtMatricule.getText(); 
		String marque = this.txtMarque.getText(); 
		int nbkm = Integer.parseInt(this.txtNbKm.getText());
		String energie = this.txtEnergie.getText();
		
		int anciennete = 0; 
		try 
		{
			// transformer l'integer anciennete en texte
			anciennete = Integer.parseInt(this.txtAnciennete.getText());
		}
		catch (NumberFormatException exp) {
			// message de levée d'exception
			JOptionPane.showMessageDialog(this,"Attention au format de l'ancienneté !");
			anciennete = -1 ;
		}
		if (anciennete >=0 ) {
			Vehicule unVehicule = new Vehicule(anciennete,matricule, marque, nbkm, energie, anciennete);
			//insertion dans la base de données 
			Main.insertVehicule(unVehicule);
			
			//recuperation de l'id a travers un select where 
			unVehicule = Main.selectWhereVehicule(matricule, marque);
			
			//insertion dans l'affichage tableau 
			Object ligne[] = {unVehicule.getIdvehicule(), matricule, marque, nbkm, energie, anciennete +""};
			this.unTableau.insertLigne(ligne);
			
			JOptionPane.showMessageDialog(this,"Insertion réussie !");
			this.viderLesChamps();
		}
		else
		{
			// si faux, champ coloré en rouge
			this.txtAnciennete.setBackground(Color.red);
		}
	}
	
	public void updateVehicule() {
		String matricule = this.txtMatricule.getText(); 
		String marque = this.txtMarque.getText();
		String nbkm = this.txtNbKm.getText();
		String energie = this.txtEnergie.getText();
		
		int anciennete = 0; 
		try {
			anciennete = Integer.parseInt(this.txtAnciennete.getText());
		}
		catch (NumberFormatException exp) {
			JOptionPane.showMessageDialog(this,"Attention au format de l'ancienneté !");
			anciennete = -1 ;
		}
		if (anciennete >=0 ) {
			int numLigne = uneTable.getSelectedRow(); 
			int idvehicule = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());
			Vehicule unVehicule = new Vehicule();
			//update dans la base de données 
			Main.updateVehicule(unVehicule);
			
			//modification dans l'affichage tableau 
			Object ligne[] = {unVehicule.getIdvehicule(), matricule, marque, nbkm, energie, anciennete +""};
			this.unTableau.updateLigne(numLigne, ligne);
			
			JOptionPane.showMessageDialog(this,"Modification réussie !");
			this.viderLesChamps();
		}
		else
		{
			this.txtAnciennete.setBackground(Color.red);
		}
	}
	
	public void viderLesChamps() {
		//vider l'ensemble des champs du formulaire 
		 this.txtMatricule.setText("");
		 this.txtMarque.setText("");
		 this.txtNbKm.setText(""); 
		 this.txtEnergie.setText("");
		 this.txtAnciennete.setText("");
		 
		 this.btEnregistrer.setText("Enregistrer");
	}
	
}