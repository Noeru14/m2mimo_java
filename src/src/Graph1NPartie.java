import java.awt.*;

import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.CaretListener;

import java.awt.event.*;

public class Graph1NPartie extends JFrame{
	// attributs
		public static int nombreJoueurs;
		
		public static JFormattedTextField jtf1 = new JFormattedTextField("");//(new GLSN1NPartie('A'));
		public static JFormattedTextField jtf2 = new JFormattedTextField("");
		public static JFormattedTextField jtf3 = new JFormattedTextField("");
		public static JFormattedTextField jtf4 = new JFormattedTextField("");
		
		public static int Colorj1, Colorj2, Colorj3, Colorj4;
		
		
	public Graph1NPartie(){
		
		// JFRAME (Affichage fenêtre nouvelle partie)
		this.setTitle("NOUVELLE PARTIE");
		this.setSize(1000,750);
		this.setBackground(Color.green);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pan1 = new JPanel();
		this.add(pan1);
		pan1.setBackground(Color.WHITE);
		pan1.setSize(1000, 750); //  Taille du panel (?)
		//pan1.setPreferredSize(new Dimension(300, 120));
		pan1.setLayout(new GridBagLayout()); // d�finit le layout du panel.
		
		// ATTRIBUT
		String [] nbjoueurs = {"2", "3", "4"};
		int RColor; // Variable de switch
		
		// Attribution de la couleur des joueurs
		Random rand = new Random();				// G�n�rateur de nombre al�atoire
		
		
		Colorj1 = rand.nextInt(4-1+1)+1;			// Couleur J1
		
		Colorj2 = Colorj1;							// Sert � rentrer dans la boucle
		while(Colorj1==Colorj2){
			Colorj2 = rand.nextInt(4-1+1)+1;		// Couleur J2
		}
		
		Colorj3 = Colorj2;
		while((Colorj3==Colorj2) || (Colorj3==Colorj1)){
			Colorj3 = rand.nextInt(4-1+1)+1;		// Couleur J3
		}
		
		Colorj4 = Colorj3;
		while((Colorj4==Colorj3)||(Colorj4==Colorj2)||(Colorj4==Colorj1)){
			Colorj4 = rand.nextInt(4-1+1)+1;		// Couleur J4
		}
		

		/*System.out.println(Colorj1);              
		System.out.println(Colorj2);
		System.out.println(Colorj3);
		System.out.println(Colorj4);*/
		
		
		// OPTION PANES
		JOptionPane.showMessageDialog(
				null, "Vous avez lanc� une nouvelle partie !", "Information", JOptionPane.INFORMATION_MESSAGE
				);
		// La variable nombre permettra de d�terminer l'affichage du panel en fonction du nombre de joueurs
		String stringNombreJoueurs = (String) JOptionPane.showInputDialog(null, "Combien y a t il de joueurs ?", 
				"Nouvelle partie !", JOptionPane.QUESTION_MESSAGE, null, nbjoueurs, nbjoueurs[0]);
	    nombreJoueurs = Integer.parseInt(stringNombreJoueurs);
		JOptionPane.showMessageDialog(
				null, "Nombre de joueurs : " + nombreJoueurs, " ", JOptionPane.INFORMATION_MESSAGE
				);
		ArrayList<Joueur> allJoueurs = new ArrayList<Joueur>();
		
		Joueur joueur1 = new Joueur(Colorj1);
		Joueur joueur2 = new Joueur(Colorj2);
		Joueur joueur3 = new Joueur(Colorj3);
		Joueur joueur4 = new Joueur(Colorj4);
		allJoueurs.add(joueur1);
		allJoueurs.add(joueur2);
		// Si il y a 3 joueurs
		if (nombreJoueurs == 3) {
			allJoueurs.add(joueur3);
		}
		// Si il y a 4 joueurs
		if (nombreJoueurs == 4) {
			allJoueurs.add(joueur3);
			allJoueurs.add(joueur4);
		}

		// CELLULES DE JOUEURS
		
		 JPanel cell1 = new JPanel();
		    cell1.setBackground(Color.WHITE);
		    cell1.add(new JLabel ("Joueur 1", JLabel.CENTER));	  // ALIGNEMENT DU TEXTE
		    cell1.setBorder(BorderFactory.createMatteBorder(2, 2, 1, 2, Color.BLACK)); // BORDURES (HAUT / GAUCHE / BAS / DROITE)
		    cell1.setPreferredSize(new Dimension(100, 40));      
		    JPanel cell2 = new JPanel();
		    cell2.setBackground(Color.WHITE);
		    cell2.add(new JLabel ("Joueur 2", JLabel.CENTER));
		    cell2.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK)); // BORDURES 
		    cell2.setPreferredSize(new Dimension(100, 40));
		    
		    JPanel cell3 = new JPanel();
		    cell3.setBackground(Color.WHITE);
		    cell3.add(new JLabel ("Joueur 3", JLabel.CENTER));
		    cell3.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.BLACK)); // BORDURES
		    cell3.setPreferredSize(new Dimension(100, 40));
		    JPanel cell4 = new JPanel();
		    cell4.setBackground(Color.WHITE);
		    cell4.add(new JLabel ("Joueur 4", JLabel.CENTER));
		    cell4.setBorder(BorderFactory.createMatteBorder(1, 2, 2, 2, Color.BLACK)); // BORDURES
		    cell4.setPreferredSize(new Dimension(100, 40));
		    
		    
		 // CELLULES DE SAISIE DE NOMS
		    
		    
		    JPanel cell5 = new JPanel();
		    cell5.add(new JLabel ("Nom : ", JLabel.CENTER));
		    cell5.setBackground(Color.white);
		     
		    cell5.add(jtf1); // ON AJOUTE LE JTEXTFIELD
		    jtf1.setPreferredSize(new Dimension(150, 30));
		    jtf1.setForeground(Color.BLUE);
		    jtf1.setText("");
		    cell5.setPreferredSize(new Dimension(300, 40));
		    cell5.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 2, Color.BLACK)); // BORDURES
		    
		    JPanel cell6 = new JPanel();
		    cell6.setBackground(Color.white);
		    cell6.add(new JLabel ("Nom : ", JLabel.CENTER));
		 
		    cell6.add(jtf2); // ON AJOUTE LE JTEXTFIELD
		    jtf2.setPreferredSize(new Dimension(150, 30));
		    jtf2.setForeground(Color.BLUE);
		    jtf2.setText("");
		    cell6.setPreferredSize(new Dimension(300, 40));
		    cell6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 2, Color.BLACK)); // BORDURES
		    
		    JPanel cell7 = new JPanel();
		    cell7.setBackground(Color.white);
		    cell7.add(new JLabel ("Nom : ", JLabel.CENTER));
		 
		    cell7.add(jtf3); // ON AJOUTE LE JTEXTFIELD
		    jtf3.setPreferredSize(new Dimension(150, 30));
		    jtf3.setForeground(Color.BLUE);
		    jtf3.setText("");
		    cell7.setPreferredSize(new Dimension(300, 40));
		    cell7.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 2, Color.BLACK)); // BORDURES
		    
		    JPanel cell8 = new JPanel();
		    cell8.setBackground(Color.white);
		    cell8.add(new JLabel ("Nom : ", JLabel.CENTER));
		
		    cell8.add(jtf4); // ON AJOUTE LE JTEXTFIELD
		    jtf4.setPreferredSize(new Dimension(150, 30));
		    jtf4.setForeground(Color.BLUE);
		    jtf4.setText("");
		  
		    cell8.setPreferredSize(new Dimension(300, 40));
		    cell8.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK)); // BORDURES
		    
		  // CELLULES DE CHOIX DE LA COULEUR
		    
		    JPanel cell9 = new JPanel();
		    
			RColor = Colorj1;							// Couleur J1
			switch(RColor){
			case 1 : cell9.setBackground(Color.red);
			joueur1.setCouleur(Color.red);
			break;
			case 2 : cell9.setBackground(Color.blue);
			joueur1.setCouleur(Color.blue);
			break;
			case 3 : cell9.setBackground(Color.green);
			joueur1.setCouleur(Color.green);
			break;
			case 4 : cell9.setBackground(Color.yellow);
			joueur1.setCouleur(Color.yellow);
			}
		    cell9.add(new JLabel ("Couleur joueur 1", JLabel.CENTER));
		    cell9.setPreferredSize(new Dimension(300, 40));
		    cell9.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 2, Color.BLACK)); // BORDURES

		    
		    JPanel cell10 = new JPanel();
		    
			RColor = Colorj2;							// Couleur J2
			switch(RColor){
			case 1 : cell10.setBackground(Color.red);
			joueur2.setCouleur(Color.red);
			break;
			case 2 : cell10.setBackground(Color.blue);
			joueur2.setCouleur(Color.blue);
			break;
			case 3 : cell10.setBackground(Color.green);
			joueur2.setCouleur(Color.green);
			break;
			case 4 : cell10.setBackground(Color.yellow);
			joueur2.setCouleur(Color.yellow);
			}
		    cell10.add(new JLabel ("Couleur joueur 2", JLabel.CENTER));
		    cell10.setPreferredSize(new Dimension(300, 40));
		    cell10.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 2, Color.BLACK)); // BORDURES
		    
		    JPanel cell11 = new JPanel();
		    
			RColor = Colorj3;							// Couleur J3
			switch(RColor){
			case 1 : cell11.setBackground(Color.red);
			joueur3.setCouleur(Color.red);
			break;
			case 2 : cell11.setBackground(Color.blue);
			joueur3.setCouleur(Color.blue);
			break;
			case 3 : cell11.setBackground(Color.green);
			joueur3.setCouleur(Color.green);
			break;
			case 4 : cell11.setBackground(Color.yellow);
			joueur3.setCouleur(Color.yellow);
			}
		    cell11.add(new JLabel ("Couleur joueur 3", JLabel.CENTER));
		    cell11.setPreferredSize(new Dimension(300, 40));
		    cell11.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 2, Color.BLACK)); // BORDURES
		    
		    JPanel cell12 = new JPanel();
		    
			RColor = Colorj4;							// Couleur J4
			switch(RColor){
			case 1 : cell12.setBackground(Color.red);
			joueur4.setCouleur(Color.red);
			break;
			case 2 : cell12.setBackground(Color.blue);
			joueur4.setCouleur(Color.blue);
			break;
			case 3 : cell12.setBackground(Color.green);
			joueur4.setCouleur(Color.green);
			break;
			case 4 : cell12.setBackground(Color.yellow);
			joueur4.setCouleur(Color.yellow);
			}
		    cell12.add(new JLabel ("Couleur joueur 4", JLabel.CENTER));
		    cell12.setPreferredSize(new Dimension(300, 40));
		    cell12.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK)); // BORDURES
		    
		    // BOUTONS
		    
		    JPanel cellOK = new JPanel();
		    cellOK.setBackground(Color.white);
		    JButton ok = new JButton(new GLSN1NPartie('B', allJoueurs)); // Ce bouton de type GLSN1Partie (classe listener) sert à valider la saisie des joueurs
		    ok.setText("OK");
		    cellOK.add(ok);
		    cellOK.setPreferredSize(new Dimension (900, 100));
		    ok.setPreferredSize(new Dimension (700,40));
		    //ok.addActionListener(pan1);
		    
		    
		    // CREATION DES OBJETS JOUEURS
		    
		    /*Joueur J1 = new Joueur(jtf1.getText(),"test");
		    System.out.println(J1.getpseudo());*/
		    

		    
		    // POSITION DU GRIDBAGLAYOUT
		   
		    GridBagConstraints gbc = new GridBagConstraints();
		    
		    gbc.fill = GridBagConstraints.VERTICAL; // ????
            gbc.anchor = GridBagConstraints.LAST_LINE_START; // ????
            
            //On positionne la case de d�part du composant
            
            //La taille en hauteur et en largeur
            
            // JOUEUR 1
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            pan1.add(cell1, gbc); // Ajout des cellules
            	// NOM
            	//---------------------------------------------
            	gbc.gridx=1;
            	gbc.gridy=0;
            	pan1.add(cell5,gbc);
            	// COULEUR
                //---------------------------------------------
                gbc.gridx=2;
                gbc.gridy=0;
                pan1.add(cell9,gbc);
                
            // JOUEUR 2
               
                //---------------------------------------------
            gbc.gridy = 1;
            gbc.gridx = 0;
            pan1.add(cell2, gbc);
            	// NOM
            	//---------------------------------------------
             gbc.gridx=1;
             gbc.gridy=1;
             pan1.add(cell6,gbc);
             	// COULEUR
             	//---------------------------------------------
              gbc.gridx=2;
              gbc.gridy=1;
              pan1.add(cell10,gbc);
              
              if(nombreJoueurs == 4){ // Si il y a 4 joueurs on affiche les joueurs 3 et 4
            // JOUEUR 3
              	//---------------------------------------------
            gbc.gridy = 2;     
            gbc.gridx = 0;
            pan1.add(cell3, gbc);        
            	// NOM
            	//---------------------------------------------
            gbc.gridx=1;
            gbc.gridy=2;
            pan1.add(cell7,gbc);
            	// COULEUR
            	//---------------------------------------------
            gbc.gridx=2;
            gbc.gridy=2;
            pan1.add(cell11,gbc);
            // JOUEUR 4
            //Cette instruction informe le layout que c'est une fin de ligne
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.gridy = 3;
            gbc.gridx = 0;
            pan1.add(cell4, gbc);
            	// NOM
            	//---------------------------------------------
            gbc.gridx=1;
            gbc.gridy=3;
            pan1.add(cell8,gbc);
            	//COULEUR
            	//---------------------------------------------
            gbc.gridx=2;
            gbc.gridy=3;
            pan1.add(cell12,gbc);
            
            } // FIN DU IF NOMBRE = 4
              
              if(nombreJoueurs == 3){ // (Si il y a 3 joueurs, on affiche le joueur 3)
            	     // JOUEUR 3
                	//---------------------------------------------
              gbc.gridy = 2;     
              gbc.gridx = 0;
              pan1.add(cell3, gbc);        
              	// NOM
              	//---------------------------------------------
              gbc.gridx=1;
              gbc.gridy=2;
              pan1.add(cell7,gbc);
              	// COULEUR
              	//---------------------------------------------
              gbc.gridx=2;
              gbc.gridy=2;
              pan1.add(cell11,gbc);
              
              } // FIN DU IF NOMBRE = 3
              
              gbc.gridwidth=3; // Indique la largeur de la cellule
              gbc.gridx=0;
              gbc.gridy=4;
              pan1.add(ok, gbc);
              
              
	}
	
}