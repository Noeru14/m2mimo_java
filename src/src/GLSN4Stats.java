import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GLSN4Stats extends AbstractAction{
	private char S;
	private JButton boutonSource = new JButton();
	private JFrame fenetreSource = new JFrame();
	
	public GLSN4Stats(char arg){
		super();
		S = arg;
	}
	
	public void actionPerformed(ActionEvent e){
		boutonSource = (JButton) e.getSource(); // récupère la source d'un évenènement
		fenetreSource = (JFrame) boutonSource.getTopLevelAncestor();
		
		fenetreSource.dispose();
		Graph0 Menu = new Graph0();
		Menu.setVisible(true);
	}
}