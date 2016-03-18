import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ZGLSNM2 extends AbstractAction{
	private char S;
	private JButton boutonSource = new JButton();
	private JFrame fenetreSource = new JFrame();
	
	
	
	
	ZM2 testM2 = new ZM2();
	
	public ZGLSNM2 (char arg){	// Reçoit en argument le bouton sur lequel le joueur appuie.
		super();
		S = arg;
	}
	
	public void actionPerformed(ActionEvent e){
		boutonSource = (JButton) e.getSource();
		fenetreSource = (JFrame) boutonSource.getTopLevelAncestor();
		
		switch(S){	// Selon le bouton sélectionné par le joueur, on cherche si la valeur de la boîte correspond à la valeur aléatoire
			case'1':
				if(1 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
			case'2':
				if(2 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
			case'3':
				if(3 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
			case'4':
				if(4 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
			case'5':
				if(5 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
			case'6':
				if(6 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
			case'7':
				if(7 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
			case'8':
				if(8 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
			case'9':
				if(9 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
			case'0':
				if(10 == testM2.target){
					JOptionPane.showMessageDialog(
							null, "Vous avez trouv� la bo�te gagnante !", "Gagn� !", JOptionPane.INFORMATION_MESSAGE
							);
					GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
					GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
					fenetreSource.dispose();
				}
				else{
					JOptionPane.showMessageDialog(
							null, "Perdu, essaye encore !", "Perdu !", JOptionPane.INFORMATION_MESSAGE
							);
				}
				break;
				
		
				
		
		}
	}
}
