package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import controleur.*;

public class InterfaceDeJeu {

	private JFrame frame;
	private JButton btnStart;
	private JButton btnOptions;
	private int difficulte; // 0 facile 1 difficile
	private int nombre; // nombre de joueur virtuel 0 1 2 3
	
	public void setDifficulte(int d) throws Exception{
		if(d==0||d==1)
			difficulte = d;
		else
			throw( new Exception("seulement 0 ou 1"));
	}
	public void setNombre(int n) throws Exception{
		if(n==0||n==1||n==2||n==3)
			nombre = n;
		else
			throw( new Exception("seulement 0 ou 1 ou 2 ou 3"));
	}
	public int getNombre(){ return nombre;}
	public JFrame getFrame(){ return frame;}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceDeJeu window = new InterfaceDeJeu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceDeJeu() {
		initialize();
		
		new ControleurOptions(btnOptions, this);
		
		new ControleurEntrer(btnStart, this);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		difficulte = 0;
		nombre = 0;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(135, 79, 352, 106);
		frame.getContentPane().add(btnStart);
		
		btnOptions = new JButton("Options");
		btnOptions.setBounds(135, 230, 352, 97);
		frame.getContentPane().add(btnOptions);
		
		
		
	}
}
