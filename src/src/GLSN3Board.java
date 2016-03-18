import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GLSN3Board extends AbstractAction{
	private char B;
	JButton boutonSource = new JButton();
	JFrame fenetreSource = new JFrame();
	Joueur joueurBoard;
	int valRoll;
	int numeroJoueur = 1;
	ArrayList<JPanel> allPanel;
	public static ArrayList<Joueur> allJoueurs;
	public static int positionJoueurApresLancer;
	public static int positionDansListeJoueurs;
	public static String defineID;
	public static boolean MJ = false;
	
	public GLSN3Board(char arg, ArrayList<JPanel> allPanel, ArrayList<Joueur> allJoueurs){
		super();
		B = arg;
		this.allPanel = allPanel;
		this.allJoueurs= allJoueurs;
		joueurBoard = new Joueur("sfdfd", 9);
	}
	
	public void actionPerformed(ActionEvent e) {
		boutonSource = (JButton) e.getSource(); 
		fenetreSource = (JFrame) boutonSource.getTopLevelAncestor();


		switch(B){
			// selon le tour en cours, on affiche le numero de tour et le pseudo du joueur
			case 'R' : 
				if(boutonSource.getText().startsWith("Score")){	
					boutonSource.setText("ROLL THE DICE");
					Graph3Board.Tour++;
					Graph3Board.Tourjoueur++;
					if (Graph3Board.Tourjoueur > allJoueurs.size()) {
						Graph3Board.Tourjoueur = 1;
					}
					if(Graph3Board.Tourjoueur==1){
						Graph3Board.label10.setText("Tour de jeu : "+Graph3Board.Tour+". C'est au tour de "+allJoueurs.get(0).getpseudo()+" de lancer les d�s !");
					}
					else if(Graph3Board.Tourjoueur==2){
						Graph3Board.label10.setText("Tour de jeu : "+Graph3Board.Tour+". C'est au tour de "+allJoueurs.get(1).getpseudo()+" de lancer les d�s !");
					}
					else if(Graph3Board.Tourjoueur == 3){
						Graph3Board.label10.setText("Tour de jeu : "+Graph3Board.Tour+". C'est au tour de "+allJoueurs.get(2).getpseudo()+" de lancer les d�s !");
					} else if(Graph3Board.Tourjoueur == 4){
						Graph3Board.label10.setText("Tour de jeu : "+Graph3Board.Tour+". C'est au tour de "+allJoueurs.get(3).getpseudo()+" de lancer les d�s !");
					}
				} else {
					// avancement des joueurs en fonction du valRoll
					// suppression des anciennes positions sur le board
					valRoll = joueurBoard.lancerDeuxDes(); 
					boutonSource.setText("Score : "+valRoll);
					positionDansListeJoueurs = Graph3Board.Tourjoueur -1;
					int positionJoueurAvantLancer = allJoueurs.get(positionDansListeJoueurs).getPosition();
					int positionDansListePanel = positionJoueurAvantLancer;
					if (positionJoueurAvantLancer != 0) {
						positionDansListePanel = positionJoueurAvantLancer -1;
					}
					allPanel.get(positionDansListePanel).remove(allJoueurs.get(positionDansListeJoueurs).getJoueurPion());
					positionJoueurApresLancer = positionJoueurAvantLancer + valRoll;
					
					// affichage d'un message de victoire si un des joueurs atteint la 64eme case
					if (positionJoueurApresLancer > 63){
						positionJoueurApresLancer=64;
						JOptionPane.showMessageDialog(
								null, "Partie terminee, le joueur "+Graph3Board.Tourjoueur+" a gagne ! Vous allez retourner au menu...", 
								"Bravo !", JOptionPane.INFORMATION_MESSAGE
								);
						
						String defineId = (String)JOptionPane.showInputDialog(
								null, "Saisissez le nom de la partie : ", "On est plus tres loin !", JOptionPane.PLAIN_MESSAGE); 
				
						// COMM BDD : le programme se ferme et on enregistre la partie + les noms de joueurs le nbre de tours + la position des joueurs + le gagnant 
						// Données pour le menu Stats
						
						switch (allJoueurs.size())
						{
						case 2:
							if(Graph3Board.Tourjoueur==1){
								
								ConnexionDB.ajouterPartieWin2(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), 
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(0).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
							}
							else if (Graph3Board.Tourjoueur==2){
								ConnexionDB.ajouterPartieWin2(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), 
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(1).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
							}
							else if (Graph3Board.Tourjoueur==3){
								ConnexionDB.ajouterPartieWin2(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), 
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
							}
							else if (Graph3Board.Tourjoueur==4){
								ConnexionDB.ajouterPartieWin2(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), 
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(3).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
							}
							break;
						case 3:
							if(Graph3Board.Tourjoueur==1){
							ConnexionDB.ajouterPartieWin3(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),
									allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), allJoueurs.get(0).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
							}
							else if(Graph3Board.Tourjoueur==2){
								ConnexionDB.ajouterPartieWin3(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), allJoueurs.get(1).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
								}
							else if(Graph3Board.Tourjoueur==3){
								ConnexionDB.ajouterPartieWin3(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), allJoueurs.get(2).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
								}
							else if(Graph3Board.Tourjoueur==4){
								ConnexionDB.ajouterPartieWin3(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), allJoueurs.get(3).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
								}				
							break;
						case 4:
							if(Graph3Board.Tourjoueur==1){
							ConnexionDB.ajouterPartieWin4(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),allJoueurs.get(3).getpseudo(),
									allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), allJoueurs.get(3).getPosition(), allJoueurs.get(0).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
							}
							else if(Graph3Board.Tourjoueur==2){
								ConnexionDB.ajouterPartieWin4(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),allJoueurs.get(3).getpseudo(),
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), allJoueurs.get(3).getPosition(), allJoueurs.get(1).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
								}
							else if(Graph3Board.Tourjoueur==3){
								ConnexionDB.ajouterPartieWin4(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),allJoueurs.get(3).getpseudo(),
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), allJoueurs.get(3).getPosition(), allJoueurs.get(2).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
								}
							else if(Graph3Board.Tourjoueur==4){
								ConnexionDB.ajouterPartieWin4(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),allJoueurs.get(3).getpseudo(),
										allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), allJoueurs.get(3).getPosition(), allJoueurs.get(3).getpseudo(), Graph3Board.Tour, Graph3Board.Tourjoueur);
								}
							break;
						}
						
						
						Graph0 M = new Graph0(); M.setVisible(true); fenetreSource.dispose();
					}
					else{
					allJoueurs.get(positionDansListeJoueurs).setPosition(positionJoueurApresLancer);
					positionDansListePanel = positionJoueurApresLancer -1;
					allPanel.get(positionDansListePanel).add(allJoueurs.get(positionDansListeJoueurs).getJoueurPion());
					
					// en fonction des cases, on déclenche des effets différents
					// CAS 1 : case mini-jeu, déclenchement d'un mini-jeu aleatoire
					if(positionJoueurApresLancer==19||positionJoueurApresLancer==48||positionJoueurApresLancer==60||positionJoueurApresLancer==3||positionJoueurApresLancer==12||positionJoueurApresLancer==5){
						Random rand = new Random();
						int Game = rand.nextInt(2-1+1)+1;
						if(Game==1){
						ZGraphM1 Z = new ZGraphM1(); Z.setVisible(true);
						}
						else if(Game==2){
						ZGraphM2 Y = new ZGraphM2(); Y.setVisible(true);
						}
						JOptionPane.showMessageDialog(
								null, "Mini jeu !", "Preparez vous !", JOptionPane.INFORMATION_MESSAGE
								);

					}
			
					// CAS 2 : Case piege, le joueur recule de deux cases
					else if(positionJoueurApresLancer==42||positionJoueurApresLancer==23||positionJoueurApresLancer==31||
							positionJoueurApresLancer==52||positionJoueurApresLancer==58||positionJoueurApresLancer==62){
						positionJoueurApresLancer=positionJoueurApresLancer-2;
						JOptionPane.showMessageDialog(
								null, "Case piege, vous reculez de deux cases !", "Pas de chance !", JOptionPane.INFORMATION_MESSAGE
								);
					}
					// CAS 3 : Case bonus : le joueur avance de deux cases
					else if(positionJoueurApresLancer==6||positionJoueurApresLancer==14||positionJoueurApresLancer==38){
						positionJoueurApresLancer=positionJoueurApresLancer+2;
						JOptionPane.showMessageDialog(
								null, "Case bonus, vous sautez deux cases !", "Super !", JOptionPane.INFORMATION_MESSAGE
								);
					}
					// CAS 4 : Case oie : doublement du score au lancer de des
					else if(positionJoueurApresLancer==9||positionJoueurApresLancer==18||positionJoueurApresLancer==27||
							positionJoueurApresLancer==36||positionJoueurApresLancer==45||positionJoueurApresLancer==54){
						positionJoueurApresLancer=positionJoueurApresLancer+valRoll;
						JOptionPane.showMessageDialog(
								null, "Case oie, vous doublez votre jet de des !", "Fantastique !!", JOptionPane.INFORMATION_MESSAGE
								);
						if (positionJoueurApresLancer > 63){
							positionJoueurApresLancer=64;
							allJoueurs.get(positionDansListeJoueurs).setPosition(positionJoueurApresLancer);
							positionDansListePanel = positionJoueurApresLancer -1;
							allPanel.get(positionDansListePanel).add(allJoueurs.get(positionDansListeJoueurs).getJoueurPion());
							JOptionPane.showMessageDialog(
									null, "Partie terminee, le joueur "+Graph3Board.Tourjoueur+" a gagne ! Vous allez retourner au menu...", 
									"Bravo !", JOptionPane.INFORMATION_MESSAGE
									);
							
							// COMM BDD : le programme se ferme et on enregistre la partie + le nbre de tours + le gagnant 
							
							Graph0 M = new Graph0(); M.setVisible(true); fenetreSource.dispose();
						}
					}
					allJoueurs.get(positionDansListeJoueurs).setPosition(positionJoueurApresLancer);
					positionDansListePanel = positionJoueurApresLancer -1;
					allPanel.get(positionDansListePanel).add(allJoueurs.get(positionDansListeJoueurs).getJoueurPion());
					}
				}
			    break;
			case 'L' :
				String [] leaveNot = {"OUI", "NON"};
				String answerSave = (String) JOptionPane.showInputDialog(null, "Souhaitez-vous sauvegarder ?", 
						"Une derniere question !", JOptionPane.QUESTION_MESSAGE, null, leaveNot, leaveNot[0]);
				
				if (answerSave.equals("OUI")){
					String defineId = (String)JOptionPane.showInputDialog(
							null, "Saisissez le nom de la partie  sauvegarder : ", "On est plus tres loin !", JOptionPane.PLAIN_MESSAGE); 
					
					// COMM BDD : le programme se ferme et on enregistre la partie + le nbre de tours + la position joueurs pour pouvoir le recharger
					// defineId va ici recuperer le nom de la partie de la partie à sauvegarder
					switch (allJoueurs.size())
					{
					case 2:
						ConnexionDB.ajouterPartie2(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), 
								allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), Graph3Board.Tour, Graph3Board.Tourjoueur);
						break;
					case 3:
						ConnexionDB.ajouterPartie3(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),
								allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), Graph3Board.Tour, Graph3Board.Tourjoueur);
						break;
					case 4:
						ConnexionDB.ajouterPartie4(defineId, allJoueurs.get(0).getpseudo(), allJoueurs.get(1).getpseudo(), allJoueurs.get(2).getpseudo(),allJoueurs.get(3).getpseudo(),
								allJoueurs.get(0).getPosition(), allJoueurs.get(1).getPosition(), allJoueurs.get(2).getPosition(), allJoueurs.get(3).getPosition(), Graph3Board.Tour, Graph3Board.Tourjoueur);
						break;
						
						
					}
				}
				
				Graph5Quitter Q = new Graph5Quitter(); Q.setVisible(true); fenetreSource.dispose();	
		}
		
		
	}

}
	
	