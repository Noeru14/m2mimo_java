import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* 
classe reprenant les actions et renvoyant vers :
- la fen�tre de nouvelle partie (Graph1NPartie) ;
- ou la fen�tre de chargement de partie (Graph2NPartie) ;
- ou la fen�tre de stats (Graph3Stats);
- ou quitter (Graph4Quitter); (<=> afficher "Byebye" et fermer la fen�tre au bout de qq secondes)
*/

public class GLSN0 extends AbstractAction{
	private char menu;
	private JButton boutonSource = new JButton();
	private JFrame fenetreSource = new JFrame();
	
	public GLSN0(char arg){
		super();
		menu = arg;
	}
	
	public void actionPerformed(ActionEvent e){
		boutonSource = (JButton) e.getSource(); // r�cup�re la source d'un �ven�nement
		fenetreSource = (JFrame) boutonSource.getTopLevelAncestor(); // r�cup�re la JFrame dans laquelle se trouve boutonSource
		
		switch(menu){
			// Affiche l'écran de nouvelle partie (saisie pseudos)
			case 'N' : Graph1NPartie N = new Graph1NPartie(); N.setVisible(true); fenetreSource.dispose();
				break;
			// Affiche l'écran de chargement de partie
			case 'C' : Graph2CPartie C = new Graph2CPartie(); C.setVisible(true); fenetreSource.dispose();	
				break;
			// Affiche l'écran des statistiques
			case 'S' : Graph4Stats S = new Graph4Stats(); S.setVisible(true); fenetreSource.dispose();	
				break;
			// Quitte le programme et affiche l'écran de sortie
			case 'Q' : Graph5Quitter Q = new Graph5Quitter(); Q.setVisible(true); fenetreSource.dispose();	
				break;
		}
	}
}