package vue;

import java.awt.Color;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;
import controleur.User;

@SuppressWarnings("serial")
public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	// création des boutons et champs de texte
	private JButton btSeConnecter = new JButton("Se Connecter");
	private JButton btAnnuler = new JButton("Annuler");
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	
	// création des fenêtres
	private JPanel panelConnexion = new JPanel();
	private JPanel panelMenu = new JPanel();
	
	// création des boutons
	private JButton btAdmin = new JButton("Gestion des Administrateurs");
	private JButton btBus = new JButton("Gestion des Bus");
	private JButton btEmploye = new JButton("Gestion des Employés");
	private JButton btMetro = new JButton("Gestion des Métros");
	private JButton btTgv = new JButton("Gestion des TGV");
	private JButton btVehicule = new JButton("Gestion des Véhicules");	
	private JButton btQuitter = new JButton("Quitter l'application");
	
	public VueConnexion()
	{
		/* on s'occupe de la fenêtre principale
		 * la taille
		 * le titre de la fenêtre
		 * le redimensionnement
		 * la fermeture
		 * la couleur
		 */
		this.setBounds(200, 200, 900, 600);
		this.setTitle("Connexion à l'application Alstom");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		// RGB = Red, Green, Blue
		this.getContentPane().setBackground(new Color(0,0,200));
		
		this.panelConnexion.setLayout(new GridLayout(3,2));
		this.panelConnexion.setBounds(350,200,300,140);
		this.panelConnexion.add(new JLabel("Email : "));
		this.panelConnexion.add(this.txtEmail);
		this.panelConnexion.add(new JLabel("Mot de passe : "));
		this.panelConnexion.add(this.txtMdp);
		this.panelConnexion.add(this.btAnnuler);
		this.panelConnexion.add(this.btSeConnecter);
		
		// rendre l'arrière-plan de cette mini-fenêtre de connexion BLANCHE
		// BLANCHE = (255,255,255)
		this.panelConnexion.setBackground(new Color(255,255,255));
		
		ImageIcon uneImage = new ImageIcon("src/images/alstom.jpeg");
		JLabel monLogo = new JLabel(uneImage);
		monLogo.setBounds(60,200,256,256);
		this.add(monLogo);
		
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		this.btAdmin.addActionListener(this);
		this.btBus.addActionListener(this);
		this.btEmploye.addActionListener(this);
		this.btMetro.addActionListener(this);
		this.btTgv.addActionListener(this);
		this.btVehicule.addActionListener(this);
		this.btQuitter.addActionListener(this);
		
		// Rendre les boutons blancs (255,255,255)
		this.btAdmin.setBackground(new Color(255,255,255));
		this.btBus.setBackground(new Color(255,255,255));
		this.btEmploye.setBackground(new Color(255,255,255));
		this.btMetro.setBackground(new Color(255,255,255));
		this.btTgv.setBackground(new Color(255,255,255));
		this.btVehicule.setBackground(new Color(255,255,255));
		this.btQuitter.setBackground(new Color(255,255,255));
		
		
		// Rendre les boutons rouges (255,50,50)
		this.btAnnuler.setBackground(new Color(255,70,70));
		this.btSeConnecter.setBackground(new Color(255,70,70));
		
		
		//rentre les TXT ecoutable sur frappe de touche
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.add(this.panelConnexion);
		
		//construction du panel menu
		this.panelMenu.setLayout(new GridLayout(4,2,1,2));
		// lignes, colonnes, espace
		this.panelMenu.setBounds(350,200,400,200);
		this.panelMenu.setBackground(new Color(255,255,255));
		
		this.panelMenu.add(this.btAdmin);
		this.panelMenu.add(this.btBus);
		this.panelMenu.add(this.btEmploye);
		this.panelMenu.add(this.btMetro);
		this.panelMenu.add(this.btTgv);
		this.panelMenu.add(this.btVehicule);
		this.panelMenu.add(this.btQuitter);
		
		this.panelMenu.setVisible(false);
		this.add(this.panelMenu);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler)
		{
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if(e.getSource()==this.btSeConnecter)
		{
			this.traitement();
		}
		else if(e.getSource()==this.btQuitter)
		{
			int retour = JOptionPane.showConfirmDialog(this, "Voulez vous quitter l'application ?", "Quitter l'application", JOptionPane.YES_NO_OPTION);
			if(retour==0)
			{
				this.panelConnexion.setVisible(true);
				this.panelMenu.setVisible(false);
			}
		}
		else if(e.getSource()==this.btAdmin)
		{
			//on rend invisible la vueConnexion
			this.setVisible(false);
			//on instancie la vueAdmin
			Main.instancierVueAdmin();
		}
		else if(e.getSource()==this.btBus)
		{
			//on rend invisible la vueConnexion
			this.setVisible(false);
			//on instancie la vueBus
			Main.instancierVueBus();
		}
		else if(e.getSource()==this.btEmploye)
		{
			//on rend invisible la vueConnexion
			this.setVisible(false);
			// on instancie la vueEmploye
			Main.instancierVueEmploye();
		}
		
		else if(e.getSource()==this.btMetro)
		{
			//on rend invisible la vueConnexion
			this.setVisible(false);
			// on instancie la vueEmploye
			Main.instancierVueMetro();
		}
		
		else if(e.getSource()==this.btTgv)
		{
			//on rend invisible la vueConnexion
			this.setVisible(false);
			// on instancie la vueEmploye
			Main.instancierVueTgv();
		}
		
		else if(e.getSource()==this.btVehicule)
		{
			//on rend invisible la vueConnexion
			this.setVisible(false);
			// on instancie la vueEmploye
			Main.instancierVueVehicule();
		}
		/* else if(e.getSource()==this.btVols)
		{
			//instructions
		}
		*/
	}
	
	public void traitement()
	{
		String email = this.txtEmail.getText();
		String mdp = new String(this.txtMdp.getPassword());
		
		User unUser = Main.verifConnexion(email, mdp);
		if(unUser == null)
		{
			JOptionPane.showMessageDialog(this, "Erreur de connexion, vérifiez vos identifiants.");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Entre ici "+unUser.getPrenom()+" "+unUser.getNom()+" !");
			//Ouverture du menu général
			this.panelConnexion.setVisible(false);
			this.panelMenu.setVisible(true);
			this.txtEmail.setText("");
			this.txtMdp.setText("");
			
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)//si la touche entrée est appuyée
		{
			this.traitement();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
