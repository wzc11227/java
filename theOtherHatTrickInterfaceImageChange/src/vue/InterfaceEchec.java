package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.ControleurOui;
import modele.Jeu;
import modele.Joueur;
import modele.Truc;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

public class InterfaceEchec extends JDialog implements Observer{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceEchec frame = new InterfaceEchec();
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
	public InterfaceEchec(Joueur j, Truc t, Jeu jeu) {
		setModal(true);
		ImageIcon icon;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(j.getPrenom() + " a echoue de effectuer ce truc");
		label.setBounds(42, 13, 342, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(116, 44, 200, 142);
		icon = new ImageIcon("Truc/" + t.getNumero() + ".png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(icon);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(52, 204, 142, 200);
		if( j.getCarte()[0].estTourne())
			icon = new ImageIcon("Accessoire/" + j.getCarte()[0].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_DEFAULT));
		label_2.setIcon(icon);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(242, 204, 142, 200);
		if( j.getCarte()[1].estTourne())
			icon = new ImageIcon("Accessoire/" + j.getCarte()[1].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_DEFAULT));
		label_3.setIcon(icon);
		contentPane.add(label_3);
		
		JButton btnOui = new JButton("Oui");
		btnOui.setBounds(156, 417, 113, 27);
		contentPane.add(btnOui);
		
		new ControleurOui(btnOui, this, jeu);
	}
	
	public void update(Observable arg0, Object arg1) {
		if (arg1 == "echec")
			this.setVisible(false);
	}
}
