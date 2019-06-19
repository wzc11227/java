package controleur;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import vue.InterfaceDeJeu;

public class ControleurRetourDeOptions {
	JButton unButton;
	JDialog frameOptions;
	InterfaceDeJeu interMain;
	
	public ControleurRetourDeOptions(JButton jb, JDialog options, InterfaceDeJeu main){
		unButton = jb;
		frameOptions = options;
		interMain = main;
		unButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameOptions.setVisible(false);
				for( Component c : frameOptions.getContentPane().getComponents()){
					if( c instanceof JRadioButton && ((JRadioButton)c).isSelected()){
						try {
							if( ((JRadioButton)c).getText() == "facile")
									interMain.setDifficulte(0);
							else if( ((JRadioButton)c).getText() == "difficile")
								interMain.setDifficulte(1);
							else if( ((JRadioButton)c).getText() == "0")
								interMain.setNombre(0);
							else if( ((JRadioButton)c).getText() == "1")
								interMain.setNombre(1);
							else if( ((JRadioButton)c).getText() == "2")
								interMain.setNombre(2);
							else if( ((JRadioButton)c).getText() == "3")
								interMain.setNombre(3);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
}
