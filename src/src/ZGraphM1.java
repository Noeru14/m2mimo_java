
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZGraphM1 extends JFrame {
	public static JFormattedTextField answer = new JFormattedTextField("");
	public static JLabel label0 = new JLabel("Find the number ! Joueur 1 commence");
	ZM1 testM10 = new ZM1();
	
	ImageIcon imageM1 = new ImageIcon("backgroundM1.jpg");
	JLabel imageLabel = new JLabel(imageM1);

	public ZGraphM1(){
		// JFRAME (Affichage fenêtre mini jeu)
		this.setTitle("Find the number");
		this.setSize(1000,750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPANEL (Affichage du champ de saisie et du bouton OK)
		JPanel pan0 = new JPanel();
		
		Font F0 = new Font("Calibri", Font.BOLD, 40);
		label0.setFont(F0);
		pan0.add(label0);
		
		this.add(pan0,BorderLayout.NORTH);
		
		JPanel pan1 = new JPanel();
		this.add(pan1);
		pan1.setBackground(Color.WHITE);
		pan1.setSize(1000, 750); 
		pan1.setLayout(new GridBagLayout());
		
		JPanel cell1 = new JPanel();
		cell1.setBackground(Color.WHITE);

		cell1.setPreferredSize(new Dimension(150, 40)); 
		answer.setPreferredSize(new Dimension(150, 30));
		cell1.add(answer);
		    

		JButton ok = new JButton(new ZGLSNM1('Z')); // Bouton OK permettant de valider la saisie du joueur. De type ZGLSNM1 (classe listener)
		ok.setText("OK");
		    
		JPanel cell2 = new JPanel();
		cell2.setBackground(Color.WHITE);
		cell2.add(ok);
		  
		    
		GridBagConstraints gbc = new GridBagConstraints();
		    
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
            
		gbc.gridx=0;
		gbc.gridy=1;
		pan1.add(cell1,gbc);
            
		gbc.gridx=1;
		gbc.gridy=1;
		pan1.add(cell2,gbc);
		
		gbc.gridx=0;
		gbc.gridy=0;
		pan1.add(imageLabel, gbc);

		this.setVisible(true);	
	}
}