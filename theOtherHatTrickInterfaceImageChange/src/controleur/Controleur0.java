package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import modele.Jeu;

public class Controleur0 {
	JButton unButton;
	JDialog frame;
	public Controleur0(JButton jb, JDialog frame, Jeu jeu){
		unButton = jb;
		this.frame = frame;
		unButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jeu.setInt1(0);
			}
		});
	}
}
