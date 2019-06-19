package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import modele.Jeu;

public class ControleurOui {
	JButton unButton;
	JDialog frame;
	public ControleurOui(JButton jb, JDialog frame, Jeu jeu){
		unButton = jb;
		this.frame = frame;
		unButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jeu.setBool(true);
			}
		});
	}
}
