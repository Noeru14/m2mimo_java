
import java.util.Random;

import javax.swing.JOptionPane;

public class ZM1{
	// Var
	private int target;
	private int TRY = 0;
	private int joueurGagnant;
	public static int joueurOK=0;
	
	
	
	// Constr
	public ZM1(){
		target = defineTarget();
	} 
	
	// M�thodes
	public int defineTarget(){
		// PART1 : d�finir un nbre cible (entre 1 et 100). Ce nombre doit être trouvé par le joueur.
		int valeurMax = 100;
		int valeurMin = 1;
		Random r = new Random();
		int target = valeurMin + r.nextInt(valeurMax - valeurMin); // nombre cible
		return target;
	}
	
	public String petitGrandOK(){
		// PART2 : traitement 
		String number;
		int prop = Integer.parseInt(ZGraphM1.answer.getText()); // Récupère la valeur saisie par le joueur dans le JTextField, et la convertit en int pour les traitements.
		
		if(prop < target){
			if (TRY%2 != 0){
				joueurGagnant = 1;
			}
			else {
				joueurGagnant = 2;
			}
		// Traitement KO, joueur suivant
		TRY++;
		return number = "Au joueur "+joueurGagnant+" de jouer : Le nombre recherch� est plus �lev�";
		}
			else if(prop > target){
				if (TRY%2 != 0){
					joueurGagnant = 1;
				}
				else {
					joueurGagnant = 2;
				}
				// Traitement KO, joueur suivant
				TRY++;
				return number = "Au joueur "+joueurGagnant+" de jouer : Le nombre recherch� est plus petit";
			}
				else{
					// Traitement OK, arr�t, r�cup�rer le joueur gagnant et appliquer effets
					TRY++;
					if (TRY%2 != 0){
						joueurGagnant = 1;
						GLSN3Board.positionJoueurApresLancer=GLSN3Board.positionJoueurApresLancer+2;
						GLSN3Board.allJoueurs.get(GLSN3Board.positionDansListeJoueurs).setPosition(GLSN3Board.positionJoueurApresLancer);
						JOptionPane.showMessageDialog(
								null, "Le joueur "+joueurGagnant+" a trouv� le nombre recherch�  !", "CONGRATULATIONS", JOptionPane.INFORMATION_MESSAGE
								);
						return number = "Vous avez trouv� le nombre recherch� !";
					}
					else {
						joueurGagnant = 2;
						GLSN3Board.MJ=true;
						JOptionPane.showMessageDialog(
								null, "Le joueur "+joueurGagnant+" a trouv� le nombre recherch� !", "CONGRATULATIONS", JOptionPane.INFORMATION_MESSAGE
								);
						return number = "Vous avez trouv� le nombre recherch� !";
					}

				}
	}
}