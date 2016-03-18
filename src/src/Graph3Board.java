// PLATEAU DE JEU 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graph3Board extends JFrame{

	private int graphIdPartie; // précise l'id de la partie jouée ou chargée, sert surtout pour préciser quelle partie chargée
	public static int Tour = 1;
	public static int Tourjoueur = 1;
	public static JLabel label10 = new JLabel();
	
	// Constructeur pour chargement partie
	public Graph3Board(ArrayList<Joueur> allJoueurs){
		
	label10.setText("Tour de jeu : "+Tour +". C'est au tour de "+allJoueurs.get(0).getpseudo()+" de lancer les d�s !");
	
		// JFRAME
		this.setTitle("Let's go!");
		this.setSize(1200,1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel principal
		JPanel panP = new JPanel();
		panP.setBackground(Color.orange);
		panP.setLayout(new GridBagLayout());
		
		// Dimension
		Dimension title = new Dimension(640,40);
		Dimension caseB = new Dimension(80,80);
		Dimension caseC = new Dimension(10,10);
		
		// Création de l'objet GBC
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Arraylist contenant les cases crées (correspondant chacune à un JPanel)
		// Préalablement, création des pions qui seront placés dans l'arraylist
		PionJoueur pionJoueur1 = new PionJoueur(allJoueurs.get(0).getCouleur());
		pionJoueur1.setPreferredSize(caseC);
		allJoueurs.get(0).setJoueurPion(pionJoueur1);
		
		PionJoueur pionJoueur2 = new PionJoueur(allJoueurs.get(1).getCouleur());
		pionJoueur2.setPreferredSize(caseC);
		allJoueurs.get(1).setJoueurPion(pionJoueur2);

		if (allJoueurs.size() == 3) {
			PionJoueur pionJoueur3 = new PionJoueur(allJoueurs.get(2).getCouleur());
			pionJoueur3.setPreferredSize(caseC);
			allJoueurs.get(2).setJoueurPion(pionJoueur3);
		}
		if (allJoueurs.size() == 4) {
			PionJoueur pionJoueur3 = new PionJoueur(allJoueurs.get(2).getCouleur());
			pionJoueur3.setPreferredSize(caseC);
			allJoueurs.get(2).setJoueurPion(pionJoueur3);
			PionJoueur pionJoueur4 = new PionJoueur(allJoueurs.get(3).getCouleur());
			pionJoueur4.setPreferredSize(caseC);
			allJoueurs.get(3).setJoueurPion(pionJoueur4);
		}

		ArrayList<JPanel> allPanel = new ArrayList<JPanel>();
		for (int i = 1; i < 65; i++) {
			JLabel jLabel = new JLabel(String.valueOf(i));
			JPanel jPanel = new JPanel();
			jPanel.add(jLabel);
			jPanel.setBorder(BorderFactory.createMatteBorder(0,0,2,2, Color.BLACK));
			jPanel.setPreferredSize(caseB);
			allPanel.add(jPanel);
		}

			// Bordure 
		allPanel.get(21).setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		allPanel.get(22).setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		allPanel.get(23).setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		allPanel.get(24).setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		allPanel.get(25).setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		allPanel.get(26).setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		allPanel.get(27).setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		allPanel.get(0).setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
		
			// Coloration
		allPanel.get(5).setBackground(Color.orange);
		allPanel.get(13).setBackground(Color.orange);
		allPanel.get(37).setBackground(Color.orange);
		
		allPanel.get(8).setBackground(Color.pink);
		allPanel.get(17).setBackground(Color.pink);
		allPanel.get(26).setBackground(Color.pink);
		allPanel.get(35).setBackground(Color.pink);
		allPanel.get(44).setBackground(Color.pink);
		allPanel.get(53).setBackground(Color.pink);
		
		allPanel.get(2).setBackground(Color.gray);
		allPanel.get(18).setBackground(Color.gray);
		allPanel.get(47).setBackground(Color.gray);
		allPanel.get(11).setBackground(Color.gray);
		allPanel.get(59).setBackground(Color.gray);

		allPanel.get(22).setBackground(Color.cyan);
		allPanel.get(30).setBackground(Color.cyan);
		allPanel.get(41).setBackground(Color.cyan);
		allPanel.get(51).setBackground(Color.cyan);
		allPanel.get(57).setBackground(Color.cyan);
		allPanel.get(61).setBackground(Color.cyan);
		
		allPanel.get(63).setBackground(Color.white);
		JLabel goal = new JLabel("(GOAL)");
		allPanel.get(63).add(goal);
		
			// pan00 : board title
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 8;
		
		JPanel pan00 = new JPanel();
		pan00.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK)); // haut, gauche, bas, droite
		pan00.setBackground(Color.YELLOW);
	    pan00.setPreferredSize(title);
	    
	    pan00.add(label10);
	    panP.add(pan00, gbc);
		
	    	// pan21 : case 21
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
		panP.add(allPanel.get(21), gbc);
		
			// pan20 : case 20
		gbc.gridx = 1;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    
		panP.add(allPanel.get(20), gbc);
		
			// pan19 : case 19
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
			    
		panP.add(allPanel.get(19), gbc);

			// pan18 : case 18
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
			    
		panP.add(allPanel.get(18), gbc);
		
			// pan17 : case 17
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
			    

		panP.add(allPanel.get(17), gbc);
		
			// pan16 : case 16
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		panP.add(allPanel.get(16), gbc);
		
			// pan15 : case 15
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
			    
		panP.add(allPanel.get(15), gbc);
		
			// pan14 : case 14
		gbc.gridx = 7;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
			    
		panP.add(allPanel.get(14), gbc);
		
			// pan22 : case 22
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(22), gbc);
	    
			// pan43 : case 43 
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(43), gbc);
	    
			// pan42 : case 42
	    gbc.gridx = 2;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(42), gbc);
	    
			// pan41 : case 41
	    gbc.gridx = 3;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(41), gbc);
	    
			// pan40 : case 40
	    gbc.gridx = 4;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(40), gbc);
	    
			// pan39 : case 39
	    gbc.gridx = 5;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(39), gbc);
	    
			// pan38 : case 38
	    gbc.gridx = 6;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(38), gbc);
	    
			// pan13 : case 13
	    gbc.gridx = 7;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(13), gbc);
	    
			// pan23 : case 23
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;

	    panP.add(allPanel.get(23), gbc);
	    
			// pan44 : case 44
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(44), gbc);
	    
			// pan57 : case 57
	    gbc.gridx = 2;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(57), gbc);
	    
			// pan56 : case 56
	    gbc.gridx = 3;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(56), gbc);
	    
			// pan55 : case 55
	    gbc.gridx = 4;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(55), gbc);
	    
			// pan54 : case 54
	    gbc.gridx = 5;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(54), gbc);
	    
			// pan37 : case 37
	    gbc.gridx = 6;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(37), gbc);
	    
			// pan12 : case 12
	    gbc.gridx = 7;
	    gbc.gridy = 3;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(12), gbc);
    
	    	// pan24 : case 24
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(24), gbc);
	    
			// pan45 : case 45
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(45), gbc);
	    
			// pan58 : case 58
	    gbc.gridx = 2;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(58), gbc);
	    
			// pan63 : case 63
	    gbc.gridx = 3;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(63), gbc);
	    
			// pan62 : case 62
	    gbc.gridx = 4;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(62), gbc);
	    
			// pan53 : case 53
	    gbc.gridx = 5;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(53), gbc);
	    
			// pan36 : case 36
	    gbc.gridx = 6;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(36), gbc);
	    
			// pan11 : case 11
	    gbc.gridx = 7;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;

	    panP.add(allPanel.get(11), gbc);
	    
			// pan25 : case 25
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(25), gbc);
	    
			// pan46 : case 46
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(46), gbc);
	    
			// pan59 : case 59
	    gbc.gridx = 2;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(59), gbc);
	    
			// pan60 : case 60
	    gbc.gridx = 3;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(60), gbc);
	    
			// pan61 : case 61
	    gbc.gridx = 4;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(61), gbc);
	    
			// pan52 : case 52
	    gbc.gridx = 5;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(52), gbc);
	    
			// pan35 : case 35
	    gbc.gridx = 6;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(35), gbc);
	    
			// pan10 : case 10
	    gbc.gridx = 7;
	    gbc.gridy = 5;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(10), gbc);
	    
			// pan26 : case 26
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(26), gbc);
	    
			// pan47 : case 47
	    gbc.gridx = 1;
	    gbc.gridy = 6;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(47), gbc);
	    
		// pan48 : case 48
	    gbc.gridx = 2;
	    gbc.gridy = 6;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(48), gbc);
	    
		// pan49 : case 49
	    gbc.gridx = 3;
	    gbc.gridy = 6;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(49), gbc);
	    
		// pan50 : case 50
	    gbc.gridx = 4;
	    gbc.gridy = 6;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;

	    panP.add(allPanel.get(50), gbc);
	    
		// pan51 : case 51
	    gbc.gridx = 5;
	    gbc.gridy = 6;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(51), gbc);
	    
		// pan34 : case 34
	    gbc.gridx = 6;
	    gbc.gridy = 6;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(34), gbc);
	    
		// pan9 : case 9
	    gbc.gridx = 7;
	    gbc.gridy = 6;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(9), gbc);
	    
			// pan27 : case 27
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(27), gbc);
	    
			// pan28 : case 28
	    gbc.gridx = 1;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(28), gbc);
	    
			// pan29 : case 29
	    gbc.gridx = 2;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;

	    panP.add(allPanel.get(29), gbc);
	    
			// pan30 : case 30
	    gbc.gridx = 3;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(30), gbc);
	    
		// pan31 : case 31
	    gbc.gridx = 4;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(31), gbc);
	    
		// pan32 : case 32
	    gbc.gridx = 5;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(32), gbc);
	    
		// pan33 : case 33
	    gbc.gridx = 6;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(33), gbc);
	    
		// pan8 : case 8
	    gbc.gridx = 7;
	    gbc.gridy = 7;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(8), gbc);
	    
			// pan0 : case 0
	    gbc.gridx = 0;
	    gbc.gridy = 8;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(0), gbc);
	    
			// pan1 : case 1
	    gbc.gridx = 1;
	    gbc.gridy = 8;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(1), gbc);
	    
			// pan2 : case 2
	    gbc.gridx = 2;
	    gbc.gridy = 8;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;

	    panP.add(allPanel.get(2), gbc);
	    
			// pan3 : case 3
	    gbc.gridx = 3;
	    gbc.gridy = 8;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(3), gbc);
	    
			// pan4 : case 4
	    gbc.gridx = 4;
	    gbc.gridy = 8;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(4), gbc);
	    
		// pan5 : case 5
	    gbc.gridx = 5;
	    gbc.gridy = 8;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;

	    panP.add(allPanel.get(5), gbc);
	    
		// pan6 : case 6
	    gbc.gridx = 6;
	    gbc.gridy = 8;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(6), gbc);
	    
		// pan7 : case 7
	    gbc.gridx = 7;
	    gbc.gridy = 8;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    panP.add(allPanel.get(7), gbc);
	    
	    	//  buttonRoll : lancer de d�s
	    gbc.gridx = 0;
	    gbc.gridy = 9;
	    gbc.gridwidth = 8;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    JButton buttonRoll = new JButton(new GLSN3Board('R', allPanel, allJoueurs));
	    buttonRoll.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
	    buttonRoll.setPreferredSize(new Dimension(400,80));
	    buttonRoll.setText("ROLL THE DICE");
	    panP.add(buttonRoll, gbc);

	    	//  buttonLeave : quitter
	    gbc.gridx = 0;
	    gbc.gridy = 15;
	    gbc.gridwidth = 8;
	    gbc.gridheight = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    JButton buttonLeave = new JButton(new GLSN3Board('L', allPanel, allJoueurs));
	    buttonLeave.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.BLACK));
	    buttonLeave.setPreferredSize(new Dimension(400,80));
	    buttonLeave.setText("QUITTER");
	    panP.add(buttonLeave, gbc);
    
	    
		this.setContentPane(panP);
		
		this.setVisible(true);
	}

}

/* 

d�faut : aucun effet 

orange (6, 14, 38) : pont > + 2 cases
	= CaseBonus


pink (9, 18, 27, 36, 45, 54) : oie > x2 score lancer de d�s
	= CaseOie

gray (19, 48) : mini-jeu au hasard
	= CaseJeu

cyan (23, 31, 42, 52, 58, 62) : piege > -2 cases
	= CasePiege
	
 */