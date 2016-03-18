public class Partie{
	private int idPartie;
	private int nbJoueurs;
	private static int compteur = 1;
	
	public Partie(){
		idPartie = compteur;
		nbJoueurs = Graph1NPartie.nombreJoueurs;
		compteur++;
	}
}