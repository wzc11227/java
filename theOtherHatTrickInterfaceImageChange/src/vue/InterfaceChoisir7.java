package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.ControleurNouvelles;
import modele.Accessoire;
import modele.Jeu;
import modele.Joueur;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;

public class InterfaceChoisir7 extends JDialog implements Observer{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceChoisir7 frame = new InterfaceChoisir7();
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
	public InterfaceChoisir7(Joueur j, Accessoire sept, Jeu jeu) {
		setModal(true);
		ImageIcon icon;
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChoisirDes = new JLabel("Choisir 2 des carte que tu veux");
		lblChoisirDes.setBounds(92, 13, 248, 18);
		contentPane.add(lblChoisirDes);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(10, 40, 25, 27);
		contentPane.add(checkBox);
		
		JLabel label = new JLabel("");
		label.setBounds(45, 40, 70, 100);
		icon = new ImageIcon("Accessoire/" + j.getCarte()[0].getNumero() + ".png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
		contentPane.add(label);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(125, 40, 25, 27);
		contentPane.add(checkBox_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(160, 44, 70, 100);
		icon = new ImageIcon("Accessoire/" + j.getCarte()[1].getNumero() + ".png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(icon);
		contentPane.add(label_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(240, 40, 25, 27);
		contentPane.add(checkBox_2);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(275, 44, 70, 100);
		icon = new ImageIcon("Accessoire/" + sept.getNumero() + ".png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label_2.setIcon(icon);
		contentPane.add(label_2);
		
		JButton btnDaccord = new JButton("D'accord");
		btnDaccord.setEnabled(false);
		btnDaccord.setBounds(152, 176, 113, 27);
		contentPane.add(btnDaccord);
		
		new ControleurNouvelles(checkBox, checkBox_1, checkBox_2, btnDaccord, this, jeu);
	}
	
	public void update(Observable arg0, Object arg1) {
		if (arg1 == "choisir7")
			this.setVisible(false);
	}
}
