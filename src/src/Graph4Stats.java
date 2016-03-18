// STATS - RUBRIQUES : NUMERO PARTIE, STATUT (EN COURS / TERMINE), TOUR ACTUEL, ID ET PSEUDO JOUEUR GAGNANT SI TERMINE

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graph4Stats extends JFrame{
	
	public Graph4Stats(){
		this.setTitle("STATS");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel principal
		JPanel pan1 = new JPanel();
		pan1.setBackground(Color.orange);
		pan1.setLayout(new GridBagLayout());
		
		Dimension dStats = new Dimension(700,40);
		Dimension dStatsRes = new Dimension(500,40);
		Dimension dStatsResInfo = new Dimension(200,40);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Sous-JPanels
			// pan00 : sous-titre
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;

		
		JPanel pan00 = new JPanel ();
		ImageIcon imageG4 = new ImageIcon("backgroundG4.jpg");
		JLabel imageLabel4 = new JLabel(imageG4);
		pan00.add(imageLabel4);
		pan00.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK));
	    
	    pan1.add(pan00, gbc);
		
	    	// pan10 : stats1
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    JLabel stats1 = new JLabel ("Nombre total de parties jou�es : ");
		JPanel pan10 = new JPanel();
		pan10.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		pan10.setPreferredSize(dStatsRes);
		
		pan10.add(stats1);
		pan1.add(pan10, gbc);
		
				// pan11 : stats1 info
		gbc.gridx = 1;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    
	    // récupère et affiche le nombre total de parties jouées 
	    JLabel stats11 = new JLabel(ConnexionDB.affichernbPTotal());
		JPanel pan11 = new JPanel();
		pan11.setBorder(BorderFactory.createMatteBorder(0,0,2,2, Color.BLACK));
		pan11.setPreferredSize(dStatsResInfo);
		
		pan11.add(stats11);
		pan1.add(pan11, gbc);
		

			// pan20 : stats2
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    JLabel stats2 = new JLabel ("Partie la plus longue : ");
	    JPanel pan20 = new JPanel();
	    pan20.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
	    pan20.setPreferredSize(dStatsRes);
	    
	    pan20.add(stats2);
	    pan1.add(pan20, gbc);
	    
				// pan21 : stats2 info
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    //récupère et affiche la partie la plus longue (selon le nombre de tours joués)
	    JLabel stats21 = new JLabel (ConnexionDB.afficherPlongue());
	    JPanel pan21 = new JPanel();
	    pan21.setBorder(BorderFactory.createMatteBorder(0,0,2,2, Color.BLACK));
	    pan21.setPreferredSize(dStatsResInfo);

	    pan21.add(stats21);
	    pan1.add(pan21, gbc);
	    
			// pan30 : stats3
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    JLabel stats3 = new JLabel ("Partie la plus courte : " );
	    JPanel pan30 = new JPanel();
	    pan30.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
	    pan30.setPreferredSize(dStatsRes);
	    
	    pan30.add(stats3);
	    pan1.add(pan30, gbc);
	    
				// pan31 : stats3 info
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    // récupère et affiche la partie la plus courte (selon le nombre de tours joués)
	    JLabel stats31 = new JLabel(ConnexionDB.afficherPcourte());

	    JPanel pan31 = new JPanel();
	    pan31.setBorder(BorderFactory.createMatteBorder(0,0,2,2, Color.BLACK));
	    pan31.setPreferredSize(dStatsResInfo);

	    pan31.add(stats31);
	    pan1.add(pan31, gbc);
    
	    	// pan40 : stats4
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    JLabel stats4 = new JLabel ("Joueur avec le meilleur % de victoire : ");
	    JPanel pan40 = new JPanel();
	    pan40.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
	    pan40.setPreferredSize(dStatsRes);
	    
	    pan40.add(stats4);
	    pan1.add(pan40, gbc);
	    
				// pan41 : stats4 info
	    gbc.gridx = 1;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    
	    //récupère et affiche le nom du joueur ayant le plus de victoires
	    JLabel stats41 = new JLabel (ConnexionDB.afficherMaxWinner());
	    JPanel pan41 = new JPanel();
	    pan41.setBorder(BorderFactory.createMatteBorder(0,0,2,2, Color.BLACK));
	    pan41.setPreferredSize(dStatsResInfo);

	    pan41.add(stats41);
	    pan1.add(pan41, gbc);
	    
		// buttonMenu : bouton de retour au menu
	    gbc.gridx = 0;
	    gbc.gridy = 9;
	    gbc.gridwidth = 2;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    JButton buttonMenu = new JButton(new GLSN4Stats('M'));
	    buttonMenu.setPreferredSize(dStats);
	    buttonMenu.setText("MENU");
	    buttonMenu.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
	    pan1.add(buttonMenu, gbc);
	    
	    //
	    
		this.setContentPane(pan1);
	}
}