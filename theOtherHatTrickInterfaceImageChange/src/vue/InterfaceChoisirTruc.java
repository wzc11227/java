package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.ControleurNon;
import controleur.ControleurOui;
import modele.Jeu;
import modele.Truc;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;

public class InterfaceChoisirTruc extends JDialog implements Observer{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceChoisirTruc frame = new InterfaceChoisirTruc();
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
	public InterfaceChoisirTruc(Truc t, String title, Jeu jeu) {
		setModal(true);
		ImageIcon icon;
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTuVeuxLe = new JLabel(title);
		lblTuVeuxLe.setBounds(148, 13, 136, 18);
		contentPane.add(lblTuVeuxLe);
		
		JLabel label = new JLabel("");
		label.setBounds(116, 44, 200, 142);
		icon = new ImageIcon("Truc/" + t.getNumero() + ".png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
		contentPane.add(label);
		
		JButton btnOui = new JButton("Oui");
		btnOui.setBounds(58, 213, 113, 27);
		contentPane.add(btnOui);
		
		JButton btnNon = new JButton("Non");
		btnNon.setBounds(261, 213, 113, 27);
		contentPane.add(btnNon);
		
		new ControleurNon(btnNon, this, jeu);
		new ControleurOui(btnOui, this, jeu);
	}
	
	public void update(Observable arg0, Object arg1) {
		if (arg1 == "choisirTruc")
			this.setVisible(false);
	}

}
