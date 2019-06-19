package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.ControleurNon;
import controleur.ControleurOui;
import modele.Jeu;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

public class InterfaceChoisirString extends JDialog implements Observer{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceChoisirString frame = new InterfaceChoisirString();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public InterfaceChoisirString(String title, String nom1, String nom2, Jeu jeu) {
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(title);
		label.setBounds(121, 13, 210, 18);
		contentPane.add(label);
		
		JButton button1 = new JButton(nom1);
		button1.setBounds(47, 112, 140, 30);
		contentPane.add(button1);
		
		JButton button = new JButton(nom2);
		button.setBounds(245, 112, 140, 30);
		contentPane.add(button);
		
		new ControleurNon(button1, this, jeu);
		new ControleurOui(button, this, jeu);
	}
	
	public void update(Observable arg0, Object arg1) {
		if (arg1 == "choisirString")
			this.setVisible(false);
	}
}
