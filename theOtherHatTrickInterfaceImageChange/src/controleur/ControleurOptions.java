package controleur;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import vue.InterfaceDeJeu;
import vue.InterfaceOptions;

public class ControleurOptions {
	private JButton unButton;
	private JDialog frameOptions;
	private InterfaceDeJeu ij;
	
	public ControleurOptions(JButton jb, InterfaceDeJeu jeu){
		unButton = jb;
		ij = jeu;
		unButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameOptions = new InterfaceOptions(ij);
				frameOptions.setModal(true);
				frameOptions.setVisible(true);
			}
		});
	}
	
}
