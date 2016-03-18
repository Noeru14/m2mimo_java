import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

// Profil de joueur : ID, Pseudo, Nombre de parties jou�es, % de victoire

public class Joueur{
	// Attributs
	private int idJoueur;
	private int position;
	private String pseudo;
	private int couleurP;
	private int nbParties;
	private float pcVictoire;
	private Color couleur;
	private PionJoueur joueurPion;

	private static int compteur = 1;
	
	// Constructeurs
	public Joueur(int couleurJ) {
		couleurP = couleurJ;
	}

	public Joueur(String pseudoJ, int couleurJ){
		idJoueur = compteur;
		pseudo = pseudoJ;
		couleurP = couleurJ;
		compteur++;
	}
	
	// M�thodes
	public int getidJoueur(){
		return this.idJoueur;
	}
	
	public String getpseudo(){
		return this.pseudo;
	}
	
	public int getcouleurP(){
		return this.couleurP;
	}
	
	public int nbParties(){
		return this.nbParties;
	}
	
	public float pcVictoire(){
		return this.pcVictoire;
	}

	
	public int lancerDe(){	// Lance un dé (valeur entre 1 et 7 pour ne pas compter le 0)
		int valeurMax = 7;
		int valeurMin = 1;
		Random r = new Random();
		int valeur = valeurMin + r.nextInt(valeurMax - valeurMin);
		System.out.println(valeur);
		return valeur;
	}
	
	public int lancerDeuxDes(){ // Appelle deux fois lancer un dé et stocke le résultat dans deux variables avant de las additionner
		int valeurUn = lancerDe();
		int valeurDeux = lancerDe();
		int scoreDes = valeurUn + valeurDeux;
		return scoreDes;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public PionJoueur getJoueurPion() {
		return joueurPion;
	}

	public void setJoueurPion(PionJoueur joueurPion) {
		this.joueurPion = joueurPion;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}