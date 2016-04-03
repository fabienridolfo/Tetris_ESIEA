package Clone;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Link extends JFrame  {

	public static int square;
	JLabel SCORE= new JLabel(" 0");
	public static String Best_5_scores;
	
	
	public Link(){
		
		JLabel Info = new JLabel(" 4");
		LireBestscore();
		} 
	
	
	public static void main(String[] args){
		Link affichage = new Link();
		Game_Logic Game = new Game_Logic(affichage);
		affichage.add(Game);
		Game.start();
		//affichage.LireBestscore();
		affichage.setTitle("Game");
		affichage.setSize(400, 620);
		affichage.setLocationRelativeTo(null);
		affichage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel SCORE = affichage.SCORE;
		affichage.add(SCORE, BorderLayout.NORTH);
        
         
        affichage.setVisible(true);
		} 

	public void LireBestscore(){
		try{
	    	InputStream File=new FileInputStream("Best_score.txt"); 
	    	InputStreamReader Data=new InputStreamReader(File);
	    	BufferedReader buff=new BufferedReader(Data);
	    	String ligne;
	    	while ((ligne=buff.readLine())!=null){
	    		System.out.println(ligne);
	    		Best_5_scores=ligne;
	    	}
	    	buff.close(); 
	    	}		
	    	catch (Exception e){
	    	System.out.println(e.toString());
	    	}
	}
}
