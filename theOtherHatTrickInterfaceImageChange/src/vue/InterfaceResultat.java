package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.Jeu;

import javax.swing.JLabel;

public class InterfaceResultat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceResultat frame = new InterfaceResultat();
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
	public InterfaceResultat(int[] resultat, Jeu jeu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(jeu.getJoueurs()[resultat[0]].getPrenom());
		label.setBounds(115, 35, 173, 18);
		contentPane.add(label);
		
		if( resultat[1] != -1){
			JLabel label_1 = new JLabel(jeu.getJoueurs()[resultat[1]].getPrenom());
			label_1.setBounds(115, 68, 173, 18);
			contentPane.add(label_1);
		}
		
		if( resultat[2] != -1){
			JLabel label_2 = new JLabel(jeu.getJoueurs()[resultat[2]].getPrenom());
			label_2.setBounds(115, 99, 173, 18);
			contentPane.add(label_2);
		}
		
		
		JLabel lblWin = new JLabel("Win!");
		lblWin.setBounds(115, 130, 72, 18);
		contentPane.add(lblWin);
	}

}
