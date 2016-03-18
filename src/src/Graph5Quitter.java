import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Graph5Quitter extends JFrame{
	JLabel labQ = new JLabel("<html>Merci d'avoir utilis� notre application !<br>Extinction dans 5 secondes...</html>", SwingConstants.CENTER);
	
	public Graph5Quitter(){
		this.setSize(400, 370); // 450 100
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pan00 = new JPanel ();
		ImageIcon imageG5 = new ImageIcon("backgroundG5.jpg");
		JLabel imageLabel5 = new JLabel(imageG5);
		pan00.add(imageLabel5);
		pan00.add(labQ);
		this.add(pan00);
		
		
		// Timer de cinq secondes avant extinction <-> fermeture de l'écran quitter
		TimerTask task = new TimerTask(){
			@Override
			public void run(){
				extinction();
				}	
			};
				
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(task, 5000, 420);
			}
	
	// méthode d'exctinction de la fenêtre
	public void extinction(){
		this.dispose();
	}
}