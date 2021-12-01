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

import controleur.Main;
import controleur.Employe;
import controleur.Tableau;

@SuppressWarnings("serial")

public class VueEmploye extends JFrame implements ActionListener
{
	// instanciation des fenêtres d'ajout et de liste
	private JPanel panelAjout = new JPanel(); 
	private JPanel panelLister = new JPanel();
	
	// instanciation des boutons
	private JButton btRetour = new JButton("Retour au Menu");
	
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtQualification= new JTextField(); 
	private JTextField txtTel = new JTextField();
	private JTextField txtAnciennete = new JTextField();
	
	// instanciation du tableau
	private JTable uneTable ; 
	// instanciation du menu déroulant
	private JScrollPane uneScroll ; 
	private Tableau unTableau ;
	
	// instanciation du mot de recherche
	private JTextField txtMot = new JTextField ();
	private JButton btFiltrer = new JButton("filtrer"); 
	
	public VueEmploye()
	{
		// FENÊTRE PRINCIPALE
		this.setBounds(100, 100, 900, 500);
		this.setTitle("Gestion des employés d'Alstom");
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
		this.panelAjout.add(new JLabel("Nom :")); 
		this.panelAjout.add(this.txtNom);
		this.panelAjout.add(new JLabel("Prénom :")); 
		this.panelAjout.add(this.txtPrenom);
		this.panelAjout.add(new JLabel("Qualification :")); 
		this.panelAjout.add(this.txtQualification);
		this.panelAjout.add(new JLabel("Téléphone :")); 
		this.panelAjout.add(this.txtTel);
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
				
			//suppression d'un employe de la table 
				
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
							int idemploye = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString()); 
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet employé ?", "Suppression", JOptionPane.YES_NO_OPTION); 
							if (retour == 0) // si clic sur Yes
								{
								int idEmploye = 0;
								//suppression dans la base 
								Main.deleteEmploye(idemploye);
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
							
							txtNom.setText(unTableau.getValueAt(ligne, 1).toString());
							txtPrenom.setText(unTableau.getValueAt(ligne, 2).toString());
							txtQualification.setText(unTableau.getValueAt(ligne, 3).toString());
							txtTel.setText(unTableau.getValueAt(ligne, 4).toString());
							txtAnciennete.setText(unTableau.getValueAt(ligne, 5).toString());
							
							btEnregistrer.setText("Modifier");
						}
					}
				}
			);
				
				//filter les employes par un mot de recherche 
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
		String entetes [] = {"ID Employé", "Nom", "Prénom", "Qualification", "Téléphone", "Ancienneté"};
		Object donnees [][] = this.getDonnees (mot) ;		
		this.unTableau = new Tableau (donnees, entetes); 
		this.uneTable = new JTable(this.unTableau); 
		this.uneScroll = new JScrollPane(this.uneTable); 
		this.panelLister.setBounds(350, 80, 530, 300);
		
		this.uneScroll.setBounds(20, 20, 510, 280);
		this.panelLister.add(this.uneScroll);
	}

	public Object [] [] getDonnees(String mot) {
		//recuperer les employés de la bdd 
		ArrayList<Employe> lesEmployes = Main.selectAllEmployes(mot); 
		//transofrmation des employés en matrice de données 
		Object donnees [][] = new Object [lesEmployes.size()][7];
		int i = 0 ; 
		for (Employe unEmploye : lesEmployes) {
			donnees[i][0] = unEmploye.getIdemploye()+""; 
			donnees[i][1] = unEmploye.getNom(); 
			donnees[i][2] = unEmploye.getPrenom(); 
			donnees[i][3] = unEmploye.getQualification(); 
			donnees[i][4] = unEmploye.getTel(); 
			donnees[i][5] = unEmploye.getAnciennete() + ""; 
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
			this.insertEmploye();
			// l'employe est inséré
		}
		else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Modifier"))  
		{
			// si clic sur le bouton modifier
			this.updateEmploye();
			// l'employe est modifié
		}
		else if (e.getSource() == this.btFiltrer)
		{
			// si clic sur le bouton filtrer
			this.remplirPanelLister(this.txtMot.getText());
			// la recherche est renvoyée sur le mot recherché
		}
	}
	
	public void insertEmploye() {
		String nom = this.txtNom.getText(); 
		String prenom = this.txtPrenom.getText(); 
		String qualification = this.txtQualification.getText(); 
		String tel = this.txtTel.getText();
		
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
			Employe unEmploye = new Employe(anciennete,nom, prenom, qualification, tel, anciennete);
			//insertion dans la base de données 
			Main.insertEmploye(unEmploye);
			
			//recuperation de l'id a travers un select where 
			unEmploye = Main.selectWhereEmploye(qualification, tel);
			
			//insertion dans l'affichage tableau 
			Object ligne[] = {unEmploye.getIdemploye(), nom, prenom, qualification, tel, anciennete +""};
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
	
	public void updateEmploye() {
		String nom = this.txtNom.getText(); 
		String prenom = this.txtPrenom.getText(); 
		String qualification = this.txtQualification.getText(); 
		String tel = this.txtTel.getText();
		
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
			int idemploye = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());
			Employe unEmploye = new Employe(idemploye, nom, prenom, qualification, tel, anciennete);
			//update dans la base de données 
			Main.updateEmploye(unEmploye);
			
			//modification dans l'affichage tableau 
			Object ligne[] = {unEmploye.getIdemploye(), nom, prenom, qualification, tel, anciennete +""};
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
		 this.txtNom.setText("");
		 this.txtPrenom.setText("");
		 this.txtQualification.setText("");
		 this.txtTel.setText("");; 
		 this.txtAnciennete.setText("");
		 
		 this.btEnregistrer.setText("Enregistrer");
	}
}