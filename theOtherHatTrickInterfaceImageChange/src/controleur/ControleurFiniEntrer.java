package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import modele.Jeu;
import modele.JoueurReel;
import modele.JoueurVirtuel;
import vue.InterfaceEntrer;
import vue.InterfaceStart;
import vue.VueTexte;

public class ControleurFiniEntrer {
	private JButton unButton;
	private InterfaceEntrer frameEntrer;
	private InterfaceEntrer frameEntrerNext;
	private InterfaceStart frameStart;
	
	public ControleurFiniEntrer(JButton jb, InterfaceEntrer entrer, int nombre, int index){
		unButton = jb;
		frameEntrer = entrer;
		unButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameEntrer.getJoueurs()[index] = new JoueurReel(frameEntrer.getTxtNom().getText(), 
												Integer.parseInt(frameEntrer.getTxtAge().getText()));
				frameEntrer.setVisible(false);
				if( nombre == 1){
					for(int i=1; i<3; i++)
						if(frameEntrer.getJoueurs()[i]==null)
							frameEntrer.getJoueurs()[i] = new JoueurVirtuel();
					frameStart = new InterfaceStart(new Jeu(frameEntrer.getJoueurs()[0],
															frameEntrer.getJoueurs()[1],
															frameEntrer.getJoueurs()[2]));
					frameStart.getFrame().setVisible(true);
					try {
						frameStart.setVue(new VueTexte(frameStart.getJeu()));
						frameStart.getJeu().game();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					frameEntrerNext = new InterfaceEntrer(nombre-1, frameEntrer.getJoueurs(), index+1);
					frameEntrerNext.setVisible(true);
				}
			}
		});
	}
}
