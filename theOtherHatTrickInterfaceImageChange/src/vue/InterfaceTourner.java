package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controleur0;
import controleur.Controleur1;
import modele.Accessoire;
import modele.Jeu;
import modele.Joueur;

public class InterfaceTourner extends JDialog implements Observer{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceChoisirCarte frame = new InterfaceChoisirCarte();
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
	public InterfaceTourner(String title, Joueur j, Jeu jeu) {
		setModal(true);
		ImageIcon icon;
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(title);
		label.setBounds(121, 13, 210, 18);
		contentPane.add(label);
		
		JButton button1 = new JButton("");
		button1.setBounds(47, 112, 142, 200);
		icon = new ImageIcon("Accessoire/" + j.getCarte()[0].getNumero() + ".png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
		button1.setIcon(icon);
		if(j.getCarte()[0].estTourne())
			button1.setEnabled(false);
		contentPane.add(button1);
		
		JButton button = new JButton("");
		button.setBounds(245, 112, 142, 200);
		icon = new ImageIcon("Accessoire/" + j.getCarte()[1].getNumero() + ".png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_DEFAULT));
		button.setIcon(icon);
		if(j.getCarte()[1].estTourne())
			button.setEnabled(false);
		contentPane.add(button);
		
		new Controleur0(button1, this, jeu);
		new Controleur1(button, this, jeu);
	}
	
	public void update(Observable arg0, Object arg1) {
		if (arg1 == "tourner")
			this.setVisible(false);
	}

}
