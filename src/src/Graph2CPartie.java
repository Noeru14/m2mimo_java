// CHARGER UNE PARTIE EN SAISISSANT SON ID

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Graph2CPartie extends JFrame{
	public static JTextField saisieId1  = new JTextField();
	public Graph2CPartie(){
		// JFRAME
		this.setTitle("CHARGEMENT PARTIE");
		this.setSize(800,200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel principal
		JPanel pan1 = new JPanel();
		pan1.setBackground(Color.orange);
		pan1.setLayout(new GridBagLayout());
		
		Dimension dCPartie = new Dimension(400,30);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		
		// Sous-JPanels
			// pan10 : sous-titre
		JLabel label10 = new JLabel("Bienvenue sur l'écran de chargement d'une partie");
		JPanel pan10 = new JPanel();
		pan10.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK)); // haut, gauche, bas, droite
		pan10.setBackground(Color.YELLOW);
	    pan10.setPreferredSize(dCPartie);
	    
	    pan10.add(label10);
	    pan1.add(pan10, gbc);

	    	// pan11 : saisie du nom de la partie sauvegardée
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 2;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
		JPanel pan11 = new JPanel();
		JLabel saisieId0 = new JLabel("Nom partie : ");
		saisieId1 = new JTextField("  Saisissez le nom de la partie  ");
		
		pan11.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		pan11.setPreferredSize(dCPartie);
		
		pan11.add(saisieId0);
		pan11.add(saisieId1);
		pan1.add(pan11, gbc);

			// pan12 : bouton de validation
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
	    gbc.gridheight = 2;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    JPanel pan12 = new JPanel();
	    JButton button12 = new JButton(new GLSN2CPartie('B'));
	    button12.setText("Valider");
	    pan12.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
	    pan12.setPreferredSize(dCPartie);
	    button12.setPreferredSize(new Dimension(350, 20));
	    
	    pan12.add(button12);
	    pan1.add(pan12, gbc);
	    
		//
		
		this.setContentPane(pan1);
	}
} 