
import java.util.Random;

import javax.swing.JOptionPane;

public class ZM2{
	// Var
	public static int target;

	
	
	// Constr
	public ZM2(){
		target = defineTarget();
	} 
	
	public int defineTarget(){
		// PART1 : definir un nbre cible correspondant a la boite gagnante. 
		int valeurMax = 10;
		int valeurMin = 1;
		Random r = new Random();
		int target = valeurMin + r.nextInt(valeurMax - valeurMin); // nombre cible
		return target;
	}
	
	
	
}