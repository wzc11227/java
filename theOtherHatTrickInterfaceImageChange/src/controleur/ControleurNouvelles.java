package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import modele.Jeu;

public class ControleurNouvelles {
	JCheckBox box1;
	JCheckBox box2;
	JCheckBox box3;
	JButton button;
	JDialog frame;
	public ControleurNouvelles(JCheckBox jbox1, JCheckBox jbox2, JCheckBox jbox3, JButton jbutton, JDialog frame, Jeu jeu){
		box1=jbox1;
		box2=jbox2;
		box3=jbox3;
		button=jbutton;
		this.frame=frame;
		box1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sum = 0;
				if(box1.isSelected())
					sum++;
				if(box2.isSelected())
					sum++;
				if(box3.isSelected())
					sum++;
				if(sum == 2)
					button.setEnabled(true);
				else
					button.setEnabled(false);
			}
		});
		box2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sum = 0;
				if(box1.isSelected())
					sum++;
				if(box2.isSelected())
					sum++;
				if(box3.isSelected())
					sum++;
				if(sum == 2)
					button.setEnabled(true);
				else
					button.setEnabled(false);
			}
		});
		box3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sum = 0;
				if(box1.isSelected())
					sum++;
				if(box2.isSelected())
					sum++;
				if(box3.isSelected())
					sum++;
				if(sum == 2)
					button.setEnabled(true);
				else
					button.setEnabled(false);
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(box1.isSelected()){
					jeu.setInt1(0);
					if(box2.isSelected())
						jeu.setInt2(1);
					else
						jeu.setInt2(2);
				}
				else{
					jeu.setInt1(1);
					jeu.setInt2(2);
				}
			}
		});
	}
}
