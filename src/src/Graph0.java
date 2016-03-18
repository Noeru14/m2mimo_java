// ECRAN DE MENU

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graph0 extends JFrame{
	
	public Graph0(){
		// JFRAME
		this.setTitle("Menu");
		this.setSize(1000,750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* this.setResizable(false); */
		
		// JPanel : chaque panel recoit un bouton sauf pan0 recevant le titre
		JPanel pan0 = new JPanel();
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		
		this.add(pan0,BorderLayout.NORTH);
		this.add(pan1,BorderLayout.CENTER);
		this.add(pan2,BorderLayout.SOUTH);
		this.add(pan3,BorderLayout.EAST);
		this.add(pan4,BorderLayout.WEST);
		
		pan0.setPreferredSize(new Dimension(100,100));
		pan2.setPreferredSize(new Dimension(100,100));
		pan3.setPreferredSize(new Dimension(100,100));
		pan4.setPreferredSize(new Dimension(100,100));
		
		pan0.setBackground(Color.GREEN);
		pan2.setBackground(Color.GREEN);
		pan3.setBackground(Color.WHITE);
		pan4.setBackground(Color.WHITE);
		
		// image au nord et au sud de l'ecran
		ImageIcon imageG01 = new ImageIcon("backgroundG01.jpg");
		JLabel imageLabel01 = new JLabel(imageG01);
		pan0.add(imageLabel01);
		
		ImageIcon imageG02 = new ImageIcon("backgroundG02.jpg");
		JLabel imageLabel02 = new JLabel(imageG02);
		pan2.add(imageLabel02);
		
		pan1.setLayout(new GridLayout(4,1));
		pan1.setPreferredSize(new Dimension(500,500));
		
		// Bouton et Fonts
		Font F1 = new Font("Calibri", Font.BOLD, 40);
		
		JButton B1 = new JButton(new GLSN0('N'));
		JButton B2 = new JButton(new GLSN0('C'));
		JButton B3 = new JButton(new GLSN0('S'));
		JButton B4 = new JButton(new GLSN0('Q'));
		
		B1.setText("Nouvelle partie");
		B2.setText("Charger partie");
		B3.setText("Stats");
		B4.setText("Quitter");
		
		B1.setFont(F1);
		B2.setFont(F1);
		B3.setFont(F1);
		B4.setFont(F1);
			
		pan1.add(B1);
		pan1.add(B2);
		pan1.add(B3);
		pan1.add(B4);
		
		this.setVisible(true);
	}
}