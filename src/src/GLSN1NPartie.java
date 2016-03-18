import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GLSN1NPartie extends AbstractAction{
	private char NP;
	JButton boutonSource = new JButton();
	JFrame fenetreSource = new JFrame();
	JFormattedTextField jtfsource = new JFormattedTextField();
	public static ArrayList<Joueur> allJoueurs;
	public static int CJ1, CJ2, CJ3, CJ4;

	
	public GLSN1NPartie(char arg, ArrayList<Joueur> allJoueurs){
		super();
		NP = arg;
		this.allJoueurs = allJoueurs;
	}

	
	public void actionPerformed(ActionEvent e){
		boutonSource = (JButton) e.getSource();
		fenetreSource = (JFrame) boutonSource.getTopLevelAncestor();
		jtfsource = (JFormattedTextField) jtfsource.getTopLevelAncestor();
		allJoueurs.get(0).setPseudo(Graph1NPartie.jtf1.getText());
		allJoueurs.get(1).setPseudo(Graph1NPartie.jtf2.getText());
		if (Graph1NPartie.nombreJoueurs == 3) {
			allJoueurs.get(2).setPseudo(Graph1NPartie.jtf3.getText());
		}
		if (Graph1NPartie.nombreJoueurs == 4) {
			allJoueurs.get(2).setPseudo(Graph1NPartie.jtf3.getText());
			allJoueurs.get(3).setPseudo(Graph1NPartie.jtf4.getText());
		}
		switch(NP){
		// Valide la saisie des joueurs et affiche le plateau de jeu
		case'B' : Graph3Board B = new Graph3Board(allJoueurs); B.setVisible(true); fenetreSource.dispose(); 

			break;
				  //System.out.println(Graph1NPartie.jtf1.getText());
				  
			//NameJ1 = jtfsource.getText();
		}
		
	
	}

}