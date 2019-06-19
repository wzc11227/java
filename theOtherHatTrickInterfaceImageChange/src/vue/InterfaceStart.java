package vue;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import modele.Deck;
import modele.Jeu;
import modele.Joueur;
import modele.JoueurReel;
import modele.Pile;
import modele.Truc;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class InterfaceStart implements Observer{

	private JFrame frame;
	private Jeu jeu;
	private VueTexte vue;
	private JDialog dialog;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceStart window = new InterfaceStart();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public Jeu getJeu(){ return jeu;}
	public JFrame getFrame(){ return frame;}
	public VueTexte getVue(){ return vue;}
	public void setVue(VueTexte v){ vue = v;}
	/**
	 * Create the application.
	 */
	public InterfaceStart(Jeu jeu) {
		initialize(jeu);
		for( Joueur j : jeu.getJoueurs()){
			j.addObserver(this);
		}
		jeu.getDeck().addObserver(this);
		jeu.getPile().addObserver(this);
		jeu.addObserver(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Jeu jeu) {
		
		ImageIcon icon;
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(39, 129, 71, 100);
		icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_11.setIcon(icon);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(124, 129, 71, 100);
		icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_12.setIcon(icon);
		frame.getContentPane().add(label_12);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(217, 375, 71, 100);
		if( jeu.getJoueurs()[0] instanceof JoueurReel)
			icon = new ImageIcon("Accessoire/" + jeu.getJoueurs()[0].getCarte()[0].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_21.setIcon(icon);
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setBounds(302, 375, 71, 100);
		if( jeu.getJoueurs()[0] instanceof JoueurReel)
			icon = new ImageIcon("Accessoire/" + jeu.getJoueurs()[0].getCarte()[1].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_22.setIcon(icon);
		frame.getContentPane().add(label_22);
		
		JLabel label_31 = new JLabel("");
		label_31.setBounds(595, 129, 71, 100);
		icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_31.setIcon(icon);
		frame.getContentPane().add(label_31);
		
		JLabel label_32 = new JLabel("");
		label_32.setBounds(682, 129, 71, 100);
		icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_32.setIcon(icon);
		frame.getContentPane().add(label_32);
		
		JLabel lblNom1 = new JLabel("Nom:" + jeu.getJoueurs()[2].getPrenom());
		lblNom1.setBounds(39, 36, 128, 18);
		frame.getContentPane().add(lblNom1);
		
		JLabel lblNote1 = new JLabel("Note:0");
		lblNote1.setBounds(39, 98, 72, 18);
		frame.getContentPane().add(lblNote1);
		
		JLabel lblNote2 = new JLabel("Note:0");
		lblNote2.setBounds(216, 344, 72, 18);
		frame.getContentPane().add(lblNote2);
		
		JLabel lblNom2 = new JLabel("Nom:" + jeu.getJoueurs()[0].getPrenom());
		lblNom2.setBounds(217, 282, 128, 18);
		frame.getContentPane().add(lblNom2);
		
		JLabel lblNote3 = new JLabel("Note:0");
		lblNote3.setBounds(595, 98, 72, 18);
		frame.getContentPane().add(lblNote3);
		
		JLabel lblNom3 = new JLabel("Nom:" + jeu.getJoueurs()[1].getPrenom());
		lblNom3.setBounds(595, 36, 128, 18);
		frame.getContentPane().add(lblNom3);
		
		JLabel lblAge1 = new JLabel("Age:" + jeu.getJoueurs()[2].getAge());
		lblAge1.setBounds(39, 67, 72, 18);
		frame.getContentPane().add(lblAge1);
		
		JLabel lblAge3 = new JLabel("Age:" + jeu.getJoueurs()[1].getAge());
		lblAge3.setBounds(595, 67, 72, 18);
		frame.getContentPane().add(lblAge3);
		
		JLabel lblAge2 = new JLabel("Age:" + jeu.getJoueurs()[0].getAge());
		lblAge2.setBounds(217, 313, 72, 18);
		frame.getContentPane().add(lblAge2);
		
		JLabel label = new JLabel("");
		label.setBounds(337, 67, 71, 100);
		icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
		frame.getContentPane().add(label);
		
		JLabel lblDeck = new JLabel("");
		lblDeck.setBounds(523, 375, 180, 126);
		icon = new ImageIcon("Truc/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(lblDeck.getWidth(), lblDeck.getHeight(), Image.SCALE_DEFAULT));
		lblDeck.setIcon(icon);
		frame.getContentPane().add(lblDeck);
		
		JLabel lblPile = new JLabel("");
		lblPile.setBounds(523, 242, 180, 126);
		icon = new ImageIcon("Truc/pile.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(lblDeck.getWidth(), lblDeck.getHeight(), Image.SCALE_DEFAULT));
		lblPile.setIcon(icon);
		frame.getContentPane().add(lblPile);
		
		this.jeu = jeu;
	}

	private void reset(){
		
		ImageIcon icon;
		Joueur j;
		
		frame.getContentPane().removeAll();
		
		frame.setBounds(100, 100, 841, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		j = jeu.getJoueurs()[(jeu.getJoueurActuel()+2)%3];
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(39, 129, 71, 100);
		if( j.getCarte()[0].estTourne())
			icon = new ImageIcon("Accessoire/" + j.getCarte()[0].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_11.setIcon(icon);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(124, 129, 71, 100);
		if( j.getCarte()[1].estTourne())
			icon = new ImageIcon("Accessoire/" + j.getCarte()[1].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_12.setIcon(icon);
		frame.getContentPane().add(label_12);
		
		j = jeu.getJoueurs()[jeu.getJoueurActuel()];
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(217, 375, 71, 100);
		if( j instanceof JoueurReel || j.getCarte()[0].estTourne())
			icon = new ImageIcon("Accessoire/" + j.getCarte()[0].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_21.setIcon(icon);
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setBounds(302, 375, 71, 100);
		if( j instanceof JoueurReel || j.getCarte()[1].estTourne())
			icon = new ImageIcon("Accessoire/" + j.getCarte()[1].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_22.setIcon(icon);
		frame.getContentPane().add(label_22);
		
		j = jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3];
		
		JLabel label_31 = new JLabel("");
		label_31.setBounds(595, 129, 71, 100);
		if( j.getCarte()[0].estTourne())
			icon = new ImageIcon("Accessoire/" + j.getCarte()[0].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_31.setIcon(icon);
		frame.getContentPane().add(label_31);
		
		JLabel label_32 = new JLabel("");
		label_32.setBounds(682, 129, 71, 100);
		if( j.getCarte()[1].estTourne())
			icon = new ImageIcon("Accessoire/" + j.getCarte()[1].getNumero() + ".png");
		else
			icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label_11.getWidth(), label_11.getHeight(), Image.SCALE_DEFAULT));
		label_32.setIcon(icon);
		frame.getContentPane().add(label_32);
		
		JLabel lblNom1 = new JLabel("Nom:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+2)%3].getPrenom());
		lblNom1.setBounds(39, 36, 128, 18);
		frame.getContentPane().add(lblNom1);
		
		JLabel lblNote1 = new JLabel("Note:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+2)%3].getNote());
		lblNote1.setBounds(39, 98, 72, 18);
		frame.getContentPane().add(lblNote1);
		
		JLabel lblNote2 = new JLabel("Note:" + jeu.getJoueurs()[jeu.getJoueurActuel()].getNote());
		lblNote2.setBounds(216, 344, 72, 18);
		frame.getContentPane().add(lblNote2);
		
		JLabel lblNom2 = new JLabel("Nom:" + jeu.getJoueurs()[jeu.getJoueurActuel()].getPrenom());
		lblNom2.setBounds(217, 282, 128, 18);
		frame.getContentPane().add(lblNom2);
		
		JLabel lblNote3 = new JLabel("Note:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getNote());
		lblNote3.setBounds(595, 98, 72, 18);
		frame.getContentPane().add(lblNote3);
		
		JLabel lblNom3 = new JLabel("Nom:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getPrenom());
		lblNom3.setBounds(595, 36, 128, 18);
		frame.getContentPane().add(lblNom3);
		
		JLabel lblAge1 = new JLabel("Age:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+2)%3].getAge());
		lblAge1.setBounds(39, 67, 72, 18);
		frame.getContentPane().add(lblAge1);
		
		JLabel lblAge3 = new JLabel("Age:" + jeu.getJoueurs()[(jeu.getJoueurActuel()+1)%3].getAge());
		lblAge3.setBounds(595, 67, 72, 18);
		frame.getContentPane().add(lblAge3);
		
		JLabel lblAge2 = new JLabel("Age:" + jeu.getJoueurs()[jeu.getJoueurActuel()].getAge());
		lblAge2.setBounds(217, 313, 72, 18);
		frame.getContentPane().add(lblAge2);
		
		JLabel label = new JLabel("");
		label.setBounds(337, 67, 71, 100);
		icon = new ImageIcon("Accessoire/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
		frame.getContentPane().add(label);
		
		JLabel lblDeck = new JLabel("");
		lblDeck.setBounds(523, 375, 180, 126);
		if( jeu.getDeck().getDeck().isEmpty())
			icon = new ImageIcon("Truc/deck.png");
		else
			icon = new ImageIcon("Truc/0.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(lblDeck.getWidth(), lblDeck.getHeight(), Image.SCALE_DEFAULT));
		lblDeck.setIcon(icon);
		frame.getContentPane().add(lblDeck);
		
		JLabel lblPile = new JLabel("");
		lblPile.setBounds(523, 242, 180, 126);
		if( jeu.getPile().getPile().isEmpty())
			icon = new ImageIcon("Truc/pile.png");
		else
			icon = new ImageIcon("Truc/" + jeu.getPile().getPile().peek().getNumero() + ".png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(lblDeck.getWidth(), lblDeck.getHeight(), Image.SCALE_DEFAULT));
		lblPile.setIcon(icon);
		frame.getContentPane().add(lblPile);
		frame.setVisible(false);
		frame.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if( arg0 instanceof Joueur){
			if(arg1 == "choisirUnTruc"){
				dialog = new InterfaceChoisirTruc(jeu.getPile().getPile().peek(), "Tu veux choisir ce truc?", jeu);
				dialog.setLocation(925, 100);
				dialog.setVisible(true);
			}
			else if(arg1 == "choisirUnJoueur"){
				int num = jeu.getNum((Joueur)arg0);
				Joueur joueur1 = jeu.getJoueurs()[(num+2)%3];
				Joueur joueur2 = jeu.getJoueurs()[(num+1)%3];
				dialog = new InterfaceChoisirString("Choisir un joueur", joueur1.getPrenom(), joueur2.getPrenom(), jeu);
				dialog.setLocation(925, 100);
				dialog.setVisible(true);
			}
			else if(arg1 == "choisirUneCarteEchanger1"){
				dialog = new InterfaceChoisirCarte("Choisir une de tes cartes", (Joueur)arg0, true, jeu);
				dialog.setLocation(925, 100);
				dialog.setVisible(true);
			}
			else if(arg1 instanceof Joueur){
				dialog = new InterfaceChoisirCarte("Choisir une de ses cartes", (Joueur)arg1, false, jeu);
				dialog.setLocation(925, 100);
				dialog.setVisible(true);
			}
			else if(arg1 == "effectuer"){
				dialog = new InterfaceChoisirTruc(jeu.getPile().getPile().peek(), "Tu peux effectuer, veux-tu?", jeu);
				dialog.setLocation(925, 100);
				dialog.setVisible(true);
			}
			else if(arg1 == "nouvellesCartes"){
				dialog = new InterfaceChoisir7((Joueur)arg0,jeu.getSeptieme(), jeu);
				dialog.setLocation(925, 100);
				dialog.setVisible(true);
			}
			else if(arg1 == "choisirUneCarteTourner"){
				if(((Joueur)arg0).getCarte()[0].estTourne()&&((Joueur)arg0).getCarte()[1].estTourne()){
					
				}
				else{
					dialog = new InterfaceTourner("Choisir une de tes cartes a tourner", (Joueur)arg0, jeu);
					dialog.setLocation(925, 100);
					dialog.setVisible(true);
				}
			}
			else if(arg1 instanceof int[]){
				if(((int[])arg1)[0] == -1){}
				else{
					JFrame frame = new InterfaceResultat((int[])arg1, jeu);
					frame.setLocation(925, 100);
					frame.setVisible(true);
				}
			}
			else if(arg1 instanceof Truc){
				dialog = new InterfaceSucces((Truc)arg1, jeu.getJoueurs()[jeu.getJoueurActuel()].getPrenom()+" a reussi de effectuer ce truc", jeu);
				dialog.setLocation(925, 100);
				dialog.setVisible(true);
			}
			else if(arg1 == "echec"){
				dialog = new InterfaceEchec((Joueur)arg0, jeu.getPile().getPile().peek(), jeu);
				dialog.setLocation(925, 100);
				dialog.setVisible(true);
			}
			else{
				reset();
			}
				
			
			
		}
		else if( arg0 instanceof Pile){
			reset();
		}
		else if( arg0 instanceof Deck){
			reset();
		}
		else if( arg0 instanceof Jeu){
			if ( arg1 == "bool" || arg1 == "int1" || arg1 == "int2")
				dialog.setVisible(false);
			else
				reset();
		}
	}
}
