package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.ControleurFiniEntrer;
import modele.Joueur;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceEntrer extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtAge;
	private Joueur[] joueurs;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceEntrer frame = new InterfaceEntrer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public JTextField getTxtNom(){ return txtNom;}
	public JTextField getTxtAge(){ return txtAge;}
	public Joueur[] getJoueurs(){ return joueurs;}
	/**
	 * Create the frame.
	 */
	public InterfaceEntrer(int nombre, Joueur[] j, int index) {
		joueurs = j;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomDeJoueur = new JLabel("Nom de joueur");
		lblNomDeJoueur.setBounds(50, 47, 141, 18);
		contentPane.add(lblNomDeJoueur);
		
		txtNom = new JTextField();
		txtNom.setBounds(50, 78, 86, 24);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblAgeDeJoueur = new JLabel("Age de joueur");
		lblAgeDeJoueur.setBounds(50, 115, 119, 18);
		contentPane.add(lblAgeDeJoueur);
		
		txtAge = new JTextField();
		txtAge.setBounds(50, 146, 86, 24);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JButton btnDaccord = new JButton("D'accord");
		btnDaccord.setBounds(50, 183, 113, 27);
		contentPane.add(btnDaccord);
		
		new ControleurFiniEntrer(btnDaccord, this, nombre, index);
	}
}
