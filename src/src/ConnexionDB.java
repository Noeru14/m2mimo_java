import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class ConnexionDB {

	static Connection conn;
	static java.sql.Statement state;
	static ResultSet result;

	

	/*
	 * 
	 * CONNEXION A LA BDD
	 */

	public static Connection connecterDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// TEST System.out.println("Driver O.K.");

			String url = "jdbc:mysql://localhost/mimo";
			String user = "root";
			String passwd = "";

			java.sql.Connection conn = DriverManager.getConnection(url, user,
					passwd);
			// TEST System.out.println("Connexion effective !");

			return (Connection) conn;
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	} // connecterDB

	
	
	
	/*
	 * 
	 * RECUPERATION /AFFICHAGE DES DONNEES
	 */

	// Récupère le nom (saisi par le user) de la partie la plus longue
	public static String afficherPlongue() {

		try {

			// Connexion à la bdd
			conn = connecterDB();

			// Création d'un objet Statement
			state = conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			// ici récupère dans la table "partie"
			result = state
					.executeQuery("SELECT nomPartie FROM partie WHERE nbTour = (SELECT MAX(nbTour) FROM partie)");

			// On récupère les MetaData
			//java.sql.ResultSetMetaData resultMeta = result.getMetaData();

			result.next();

			return (result.getObject(1).toString() + "\t");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	} // afficherPlongue

	// Récupère le nom (saisi par le user) de la partie la plus courte
	public static String afficherPcourte() {

		try {

			// Connexion à la bdd
			conn = connecterDB();

			// Création d'un objet Statement
			state = conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			// ici récupère dans la table "partie"
			result = state
					.executeQuery("SELECT nomPartie FROM partie WHERE nbTour = (SELECT MIN(nbTour) FROM partie)");

			// On récupère les MetaData
			//java.sql.ResultSetMetaData resultMeta = result.getMetaData();

			result.next();

			return result.getObject(1).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	} // afficherPcourte

	
	
	// Récupère le nombre total de parties jouées
	public static String affichernbPTotal() {

		try {

			// Connexion à la bdd
			conn = connecterDB();

			// Création d'un objet Statement
			state = conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			// ici récupère dans la table "partie"
			result = state.executeQuery("SELECT COUNT(*) FROM partie");

			// On récupère les MetaData
			//java.sql.ResultSetMetaData resultMeta = result.getMetaData();

			result.next();

			return (result.getObject(1).toString() + "\t");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	} // affichernbPTotal

	
	
	// Récupère le nom du joueur avec le plus de parties gagnées
	public static String afficherMaxWinner() {

		try {

			// Connexion à la bdd
			conn = connecterDB();

			// Création d'un objet Statement
			state = conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			// ici récupère dans la table "partie"
			result = state
					.executeQuery("SELECT nomWinner FROM partie WHERE nomWinner = (SELECT MAX(nomWinner) FROM partie)");

			// On récupère les MetaData
			//java.sql.ResultSetMetaData resultMeta = result.getMetaData();

			result.next();

			return result.getObject(1).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	} // afficherMaxWinner

	
	
	
	// Recupère les infos d'une partie sauvegardée pour recharger le plateau -
	// menu Charger partie
	public static PartieDB chargerPartie(String nomPartie) {

		PartieDB partieDB = new PartieDB();
		try {

			// Connexion à la bdd
			conn = connecterDB();

			// Création d'un objet Statement
			state = conn.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL
			// ici récupère dans la table "partie"

			String query = "SELECT * FROM partie";

			ResultSet result = state.executeQuery(query);
			
			
			// On récupère les MetaData
			//java.sql.ResultSetMetaData resultMeta = result.getMetaData();
			
			
			while (result.next()) {
				if(!(result.getString("nomPartie").isEmpty()) || result.getString("nomPartie") != null )
				if (nomPartie.compareTo(result.getString("nomPartie")) == 0) {
					partieDB.nbTour = result.getInt("nbTour");
					partieDB.nomJ1 = result.getString("nomJ1");
					partieDB.nomJ2 = result.getString("nomJ2");
					partieDB.nomJ3 = result.getString("nomJ3");
					partieDB.nomJ4 = result.getString("nomJ4");
					partieDB.nomPartie = result.getString("nomPartie");
					partieDB.posJ1 = result.getInt("posJ1");
					partieDB.posJ2 = result.getInt("posJ2");
					partieDB.posJ3 = result.getInt("posJ3");
					partieDB.posJ4 = result.getInt("posJ4");
					partieDB.tourJoueur = result.getInt("tourJoueur");
					
				}

				
			}
			state.close();
			
			return partieDB;
			
		} catch (Exception e) {
			e.printStackTrace();
			return partieDB;
		}

	} // chargerPartie

	
	
	
	
	
	/*
	 * 
	 * SAUVEGARDE DES DONNEES - PARTIE EN COURS
	 */

	// Ajout des données dans la table partie - Sauvegarde partie en cours avec
	// 2 joueurs

	public static void ajouterPartie2(String nomPartie, String nomJ1,
			String nomJ2, int posJ1, int posJ2, int nbTour, int tourJoueur) {
		try {

			String query = "INSERT INTO partie (nomPartie, nomJ1, nomJ2, posJ1, posJ2, nbTour, tourJoueur) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

			conn = connecterDB();
			state = (Statement) conn.createStatement();

			// méthode preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			preparedStmt.setString(1, nomPartie);
			preparedStmt.setString(2, nomJ1);
			preparedStmt.setString(3, nomJ2);
			preparedStmt.setInt(4, posJ1);
			preparedStmt.setInt(5, posJ2);
			preparedStmt.setInt(6, nbTour);
			preparedStmt.setInt(7, tourJoueur);

			preparedStmt.execute();

			System.out.println("Element bien ajouté !");

		} // try

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}// catch
	}

	
	
	// Ajout des données dans la table partie - Sauvegarde partie en cours avec
	// 3 joueurs

	public static void ajouterPartie3(String nomPartie, String nomJ1,
			String nomJ2, String nomJ3, int posJ1, int posJ2, int posJ3,
			int nbTour, int tourJoueur) {
		try {

			String query = "INSERT INTO partie (nomPartie, nomJ1, nomJ2, nomJ3, posJ1, posJ2, posJ3, nbTour, tourJoueur) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			conn = connecterDB();
			state = (Statement) conn.createStatement();

			// méthode preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			preparedStmt.setString(1, nomPartie);
			preparedStmt.setString(2, nomJ1);
			preparedStmt.setString(3, nomJ2);
			preparedStmt.setString(4, nomJ3);
			preparedStmt.setInt(5, posJ1);
			preparedStmt.setInt(6, posJ2);
			preparedStmt.setInt(7, posJ3);
			preparedStmt.setInt(8, nbTour);
			preparedStmt.setInt(9, tourJoueur);

			preparedStmt.execute();

			System.out.println("Element bien ajouté !");

		} // try

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}// catch
	}

	
	
	// Ajout des données dans la table partie- Sauvegarde partie en cours avec 4
	// joueurs

	public static void ajouterPartie4(String nomPartie, String nomJ1,
			String nomJ2, String nomJ3, String nomJ4, int posJ1, int posJ2,
			int posJ3, int posJ4, int nbTour, int tourJoueur) {
		try {

			String query = "INSERT INTO partie (nomPartie, nomJ1, nomJ2, nomJ3, nomJ4, posJ1, posJ2, posJ3, posJ4, nbTour, tourJoueur) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			conn = connecterDB();
			state = (Statement) conn.createStatement();

			// méthode preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			preparedStmt.setString(1, nomPartie);
			preparedStmt.setString(2, nomJ1);
			preparedStmt.setString(3, nomJ2);
			preparedStmt.setString(4, nomJ3);
			preparedStmt.setString(5, nomJ4);
			preparedStmt.setInt(6, posJ1);
			preparedStmt.setInt(7, posJ2);
			preparedStmt.setInt(8, posJ3);
			preparedStmt.setInt(9, posJ4);
			preparedStmt.setInt(10, nbTour);
			preparedStmt.setInt(11, tourJoueur);

			preparedStmt.execute();

			System.out.println("Element bien ajouté !");

		} // try

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}// catch
	}

	
	
	/*
	 * 
	 * SAUVEGARDE DES DONNEES - PARTIE TERMINEE
	 */

	// Ajout des données dans la table partie - Sauvegarde partie terminée avec
	// 2 joueurs

	public static void ajouterPartieWin2(String nomPartie, String nomJ1,
			String nomJ2, int posJ1, int posJ2, String nomWinner, int nbTour,
			int tourJoueur) {
		try {

			String query = "INSERT INTO partie (nomPartie, nomJ1, nomJ2, posJ1, posJ2, nomWinner, nbTour, tourJoueur) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			conn = connecterDB();
			state = (Statement) conn.createStatement();

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			preparedStmt.setString(1, nomPartie);
			preparedStmt.setString(2, nomJ1);
			preparedStmt.setString(3, nomJ2);
			preparedStmt.setInt(4, posJ1);
			preparedStmt.setInt(5, posJ2);
			preparedStmt.setString(6, nomWinner);
			preparedStmt.setInt(7, nbTour);
			preparedStmt.setInt(8, tourJoueur);

			preparedStmt.execute();

			System.out.println("Element bien ajouté !");

		} // try

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}// catch
	}

	
	// Ajout des données dans la table partie - Sauvegarde partie terminée avec
	// 3 joueurs

	public static void ajouterPartieWin3(String nomPartie, String nomJ1,
			String nomJ2, String nomJ3, int posJ1, int posJ2, int posJ3,
			String nomWinner, int nbTour, int tourJoueur) {
		try {

			String query = "INSERT INTO partie (nomPartie, nomJ1, nomJ2, nomJ3, posJ1, posJ2, posJ3, nomWinner, nbTour, tourJoueur) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			conn = connecterDB();
			state = (Statement) conn.createStatement();

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			preparedStmt.setString(1, nomPartie);
			preparedStmt.setString(2, nomJ1);
			preparedStmt.setString(3, nomJ2);
			preparedStmt.setString(4, nomJ3);
			preparedStmt.setInt(5, posJ1);
			preparedStmt.setInt(6, posJ2);
			preparedStmt.setInt(7, posJ3);
			preparedStmt.setString(8, nomWinner);
			preparedStmt.setInt(9, nbTour);
			preparedStmt.setInt(10, tourJoueur);

			preparedStmt.execute();

			System.out.println("Element bien ajouté !");

		} // try

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}// catch
	}

	
	// Ajout des données dans la table partie- Sauvegarde partie terminée avec 4
	// joueurs

	public static void ajouterPartieWin4(String nomPartie, String nomJ1,
			String nomJ2, String nomJ3, String nomJ4, int posJ1, int posJ2,
			int posJ3, int posJ4, String nomWinner, int nbTour, int tourJoueur) {
		try {

			String query = "INSERT INTO partie (nomPartie, nomJ1, nomJ2, nomJ3, nomJ4, posJ1, posJ2, posJ3, posJ4, nomWinner, nbTour, tourJoueur) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			conn = connecterDB();
			state = (Statement) conn.createStatement();

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn
					.prepareStatement(query);
			preparedStmt.setString(1, nomPartie);
			preparedStmt.setString(2, nomJ1);
			preparedStmt.setString(3, nomJ2);
			preparedStmt.setString(4, nomJ3);
			preparedStmt.setString(5, nomJ4);
			preparedStmt.setInt(6, posJ1);
			preparedStmt.setInt(7, posJ2);
			preparedStmt.setInt(8, posJ3);
			preparedStmt.setInt(9, posJ4);
			preparedStmt.setString(10, nomWinner);
			preparedStmt.setInt(11, nbTour);
			preparedStmt.setInt(12, tourJoueur);

			preparedStmt.execute();

			System.out.println("Element bien ajouté !");

		} // try

		catch (SQLException e) {

			System.out.println(e.getMessage());

		}// catch
	}

} // Connexion DB
