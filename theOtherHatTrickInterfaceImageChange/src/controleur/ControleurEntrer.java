package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import modele.Jeu;
import modele.Joueur;
import modele.JoueurVirtuel;
import vue.InterfaceDeJeu;
import vue.InterfaceEntrer;
import vue.InterfaceStart;
import vue.VueTexte;

public class ControleurEntrer {
	private JButton unButton;
	private InterfaceDeJeu interJeu;
	private InterfaceStart frameStart;
	private JFrame frameEntrer;
	
	public ControleurEntrer(JButton jb, InterfaceDeJeu idj){
		unButton = jb;
		interJeu = idj;
		unButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				interJeu.getFrame().setVisible(false);
				if( interJeu.getNombre() == 3){
					Joueur joueur1 = new JoueurVirtuel();
					Joueur joueur2 = new JoueurVirtuel();
					Joueur joueur3 = new JoueurVirtuel();
					Jeu jeu = new Jeu(joueur1, joueur2, joueur3);
					frameStart = new InterfaceStart(jeu);
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
					frameEntrer = new InterfaceEntrer(3-interJeu.getNombre(), new Joueur[3], 0);
					frameEntrer.setVisible(true);
				}
			}
		});
		
	}
}
