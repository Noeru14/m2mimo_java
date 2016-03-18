
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

public class ZGraphM2 extends JFrame {
	public static JLabel label0 = new JLabel("Find the right box !");
	ZM2 testM10 = new ZM2();
	
	// ImageIcon imageM1 = new ImageIcon("backgroundM1.jpg");
	// JLabel imageLabel = new JLabel(imageM1);

	public ZGraphM2(){
		// JFRAME (Affichage de la fenêtre et du titre)
		this.setTitle("Find the right box");
		this.setSize(1000,750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPANEL (Affichage des boîtes mystère)
		JPanel pan0 = new JPanel();
		
		Font F0 = new Font("Calibri", Font.BOLD, 50);
		label0.setFont(F0);
		pan0.add(label0);
		
		this.add(pan0,BorderLayout.NORTH);
		
		JPanel pan1 = new JPanel();
		this.add(pan1);
		pan1.setBackground(Color.WHITE);
		pan1.setSize(1000, 750); 
		pan1.setLayout(new GridBagLayout());
		
		JButton Box1 = new JButton(new ZGLSNM2('1')); // Chaque boîte est de type ZGLSNM2 (classe listener). 
		Box1.setText("?"); 
		JPanel cell1 = new JPanel();
		cell1.setBackground(Color.WHITE);
		cell1.add(Box1);
		    

		JButton Box2 = new JButton(new ZGLSNM2('2'));
		Box2.setText("?");
		JPanel cell2 = new JPanel();
		cell2.setBackground(Color.WHITE);
		cell2.add(Box2);
		
		JButton Box3 = new JButton(new ZGLSNM2('3'));
		Box3.setText("?");
		JPanel cell3 = new JPanel();
		cell3.setBackground(Color.WHITE);
		cell3.add(Box3);
		
		JButton Box4 = new JButton(new ZGLSNM2('4'));
		Box4.setText("?");
		JPanel cell4 = new JPanel();
		cell4.setBackground(Color.WHITE);
		cell4.add(Box4);
		
		JButton Box5 = new JButton(new ZGLSNM2('5'));
		Box5.setText("?");
		JPanel cell5 = new JPanel();
		cell5.setBackground(Color.WHITE);
		cell5.add(Box5);
		
		JButton Box6 = new JButton(new ZGLSNM2('6'));
		Box6.setText("?");
		JPanel cell6 = new JPanel();
		cell6.setBackground(Color.WHITE);
		cell6.add(Box6);
		
		JButton Box7 = new JButton(new ZGLSNM2('7'));
		Box7.setText("?");
		JPanel cell7 = new JPanel();
		cell7.setBackground(Color.WHITE);
		cell7.add(Box7);
		
		JButton Box8 = new JButton(new ZGLSNM2('8'));
		Box8.setText("?");
		JPanel cell8 = new JPanel();
		cell8.setBackground(Color.WHITE);
		cell8.add(Box8);
		
		JButton Box9 = new JButton(new ZGLSNM2('9'));
		Box9.setText("?");
		JPanel cell9 = new JPanel();
		cell9.setBackground(Color.WHITE);
		cell9.add(Box9);
		
		JButton Box10 = new JButton(new ZGLSNM2('0'));
		Box10.setText("?");
		JPanel cell10 = new JPanel();
		cell10.setBackground(Color.WHITE);
		cell10.add(Box10);
		  
		    
		GridBagConstraints gbc = new GridBagConstraints();
		    
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
            
		gbc.gridx=0;
		gbc.gridy=1;
		pan1.add(cell1,gbc);
            
		gbc.gridx=1;
		gbc.gridy=1;
		pan1.add(cell2,gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		pan1.add(cell3,gbc);
		
		gbc.gridx=3;
		gbc.gridy=1;
		pan1.add(cell4,gbc);
		
		gbc.gridx=4;
		gbc.gridy=1;
		pan1.add(cell5,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		pan1.add(cell6,gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		pan1.add(cell7,gbc);
		
		gbc.gridx=2;
		gbc.gridy=2;
		pan1.add(cell8,gbc);
		
		gbc.gridx=3;
		gbc.gridy=2;
		pan1.add(cell9,gbc);
		
		gbc.gridx=4;
		gbc.gridy=2;
		pan1.add(cell10,gbc);
		
		
		gbc.gridx=0;
		gbc.gridy=0;
		//pan1.add(imageLabel, gbc);
		

		this.setVisible(true);	
	}
}