
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ZGLSNM1 extends AbstractAction{	// Il s'agit de la classe listener du mini jeu 1. 
	private char S;
	private JButton boutonSource = new JButton();
	private JFrame fenetreSource = new JFrame();
	private String test1;
	
	//
	ZM1 testM1 = new ZM1();
	
	public ZGLSNM1 (char arg){ // Reçoit en argument le bouton OK permettant de valider la saisie du joueur.
		super();
		S = arg;
	}
	
	public void actionPerformed(ActionEvent e){
		boutonSource = (JButton) e.getSource();
		fenetreSource = (JFrame) boutonSource.getTopLevelAncestor();
		
		try{
		ZGraphM1.label0.setText(testM1.petitGrandOK());// titre
		test1 = ZGraphM1.label0.getText();
		
		// instructions si nombre recherché trouvé
		if (test1.equals("Vous avez trouv� le nombre recherch� !")){
				fenetreSource.dispose();
			}
		} catch (NumberFormatException exc){
			// Instructions si la saisie n'est pas un nombre
			JOptionPane.showMessageDialog(
					null, "Etes-vous sur d'avoir bien saisi un nombre ? :)", "Whoops !", JOptionPane.INFORMATION_MESSAGE
					);
		}
	}
}