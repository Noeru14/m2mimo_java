import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GLSN2CPartie extends AbstractAction {
	private char CP;
	private JButton boutonSource = new JButton();
	private JFrame fenetreSource = new JFrame();

	public GLSN2CPartie(char arg) {
		super();
		CP = arg;
	}

	// LISTENER VERS GRAPH3BOARD
	public void actionPerformed(ActionEvent e) {
		boutonSource = (JButton) e.getSource(); // récupère la source d'un
												// évènement
		fenetreSource = (JFrame) boutonSource.getTopLevelAncestor();

		fenetreSource.dispose();

		// on charge le plateau avec le nom de la partie concerne
		ArrayList<Joueur> alljoueurs = new ArrayList<Joueur>();
		String nomPartie = (Graph2CPartie.saisieId1.getText());
		PartieDB partieDB = new PartieDB();
		partieDB = ConnexionDB.chargerPartie(nomPartie);

		// Attribution de la couleur des joueurs
		
		Random rand = new Random(); // Générateur de nombre aléatoire

		int Colorj1 = rand.nextInt(4 - 1 + 1) + 1; // Couleur J1

		int Colorj2 = Colorj1;       // Rentre dans la boucle
		while (Colorj1 == Colorj2) {
			Colorj2 = rand.nextInt(4 - 1 + 1) + 1; // Couleur J2
		}

		int Colorj3 = Colorj2;
		while ((Colorj3 == Colorj2) || (Colorj3 == Colorj1)) {
			Colorj3 = rand.nextInt(4 - 1 + 1) + 1; // Couleur J3
		}

		int Colorj4 = Colorj3;
		while ((Colorj4 == Colorj3) || (Colorj4 == Colorj2)
				|| (Colorj4 == Colorj1)) {
			Colorj4 = rand.nextInt(4 - 1 + 1) + 1; // Couleur J4
		}

		Joueur J1 = new Joueur(Colorj1);  
		J1.setPseudo(partieDB.nomJ1);		// récupération du nom du joueur 1
		J1.setPosition(partieDB.posJ1);		// récuparation de la position du joueur 1

		Joueur J2 = new Joueur(Colorj2);
		J2.setPseudo(partieDB.nomJ2);		// récupération du nom du joueur 2
		J2.setPosition(partieDB.posJ2);		// récupération de la position du joueur 2
		
		alljoueurs.add(J1);
		alljoueurs.add(J2);


		int RColor = Colorj1; // Couleur du joueur 1
		switch (RColor) {
		case 1:
			J1.setCouleur(Color.red);
			break;
		case 2:
			J1.setCouleur(Color.blue);
			break;
		case 3:
			J1.setCouleur(Color.green);
			break;
		case 4:
			J1.setCouleur(Color.yellow);
		}


		RColor = Colorj2; // Couleur du joueur 2
		switch (RColor) {
		case 1:
	
			J2.setCouleur(Color.red);
			break;
		case 2:
			J2.setCouleur(Color.blue);
			break;
		case 3:
			J2.setCouleur(Color.green);
			break;
		case 4:
			J2.setCouleur(Color.yellow);
		}

		if (partieDB.nomJ3 != null) {
			Joueur J3 = new Joueur(Colorj3);
			J3.setPseudo(partieDB.nomJ3);		   // récupération du nom du joueur 3
			J3.setPosition(partieDB.posJ3);			// récupération de la position du joueur 3 
			
			RColor = Colorj3; // Couleur du joueur 3
			switch (RColor) {
			case 1:
		
				J3.setCouleur(Color.red);
				break;
			case 2:
				J3.setCouleur(Color.blue);
				break;
			case 3:
				J3.setCouleur(Color.green);
				break;
			case 4:
				J3.setCouleur(Color.yellow);
			}
			
			alljoueurs.add(J3);
		}
		if (partieDB.nomJ4 != null) {
			Joueur J4 = new Joueur(Colorj4);
			J4.setPseudo(partieDB.nomJ4); 			// récupération du nom du joueur 4 
			J4.setPosition(partieDB.posJ4);			// récupération de la position du joueur 4
			
			RColor = Colorj4; // Couleur du joueur 4
			switch (RColor) {
			case 1:
		
				J4.setCouleur(Color.red);
				break;
			case 2:
				J4.setCouleur(Color.blue);
				break;
			case 3:
				J4.setCouleur(Color.green);
				break;
			case 4:
				J4.setCouleur(Color.yellow);
			}
			
			alljoueurs.add(J4);
		}

		
		Graph3Board G3B = new Graph3Board(alljoueurs);	//affiche le plateau avec les données récupérées
		G3B.setVisible(true);
	}
}