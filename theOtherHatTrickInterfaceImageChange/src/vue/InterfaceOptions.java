package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.ControleurRetourDeOptions;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class InterfaceOptions extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceOptions frame = new InterfaceOptions();
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
	public InterfaceOptions(InterfaceDeJeu main) {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 331, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnFacile = new JRadioButton("facile");
		rdbtnFacile.setSelected(true);
		rdbtnFacile.setBounds(33, 54, 157, 27);
		contentPane.add(rdbtnFacile);
		
		JRadioButton rdbtnDifficile = new JRadioButton("difficile");
		rdbtnDifficile.setBounds(191, 54, 157, 27);
		contentPane.add(rdbtnDifficile);
		
		ButtonGroup difficulteGroup = new ButtonGroup();
		difficulteGroup.add(rdbtnDifficile);
		difficulteGroup.add(rdbtnFacile);
		
		JButton btnRetour = new JButton("D'accord");
		btnRetour.setBounds(100, 162, 113, 27);
		contentPane.add(btnRetour);		
		
		JLabel lblNombreDeJoueur = new JLabel("nombre de joueur virtuel");
		lblNombreDeJoueur.setBounds(33, 99, 222, 18);
		contentPane.add(lblNombreDeJoueur);
		
		JLabel lblDifficulteDeJoueur = new JLabel("difficulte de joueur virtuel");
		lblDifficulteDeJoueur.setBounds(33, 27, 385, 18);
		contentPane.add(lblDifficulteDeJoueur);
		
		JRadioButton radioButton_1 = new JRadioButton("0");
		radioButton_1.setSelected(true);
		radioButton_1.setBounds(33, 126, 56, 27);
		contentPane.add(radioButton_1);

		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setBounds(95, 126, 56, 27);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_2 = new JRadioButton("2");
		radioButton_2.setBounds(157, 126, 56, 27);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("3");
		radioButton_3.setBounds(219, 126, 56, 27);
		contentPane.add(radioButton_3);
		
		ButtonGroup nombreGroup = new ButtonGroup();
		nombreGroup.add(radioButton);
		nombreGroup.add(radioButton_1);
		nombreGroup.add(radioButton_2);
		nombreGroup.add(radioButton_3);
		
		
		new ControleurRetourDeOptions(btnRetour, this, main);
	}
}
