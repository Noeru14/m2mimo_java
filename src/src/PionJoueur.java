import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class PionJoueur extends JPanel{

	private Color couleur;
	private static final long serialVersionUID = -924127788464998360L;
	
	
	public PionJoueur(Color couleur) {
		this.couleur = couleur;
	}
	public void paintComponent(Graphics g){
		g.setColor(couleur);
		g.fillOval(0, 0, 10, 10);  
	}
}
