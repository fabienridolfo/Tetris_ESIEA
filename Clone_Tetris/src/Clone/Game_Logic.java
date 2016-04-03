package Clone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;






public class Game_Logic extends JPanel implements ActionListener, KeyListener {
	
	Timer temp ;
	Format_Piece Piece;
	JLabel Affich;
	static int SquareTaille=20;
	int SquareTaill=18;
	int[] vecteur_mouvement={0,1};
	int squareStoredX=19;
	int squareStoredY=28;
	int rotate=-1;
	int score=0;
	public  String Best_5_scores;
	public int[][] squareStored = new int[squareStoredX][squareStoredY] ;
	 JLabel SCORE = new JLabel(" 0");
	public  Game_Logic(Link link){
		addKeyListener(this);
		  setFocusable(true);
		 temp = new Timer(100, this);
		 Piece= new Format_Piece();
		 SCORE=link.SCORE;
		 
		 for(int i=0;i<squareStoredX;i++){
			 for(int j=0;j<squareStoredY;j++){
				 squareStored[i][j]=0;
		 }
	}
		 Best_5_scores=link.Best_5_scores; 
	}
	

	public void keyReleased(KeyEvent e) { 
		vecteur_mouvement[0]=0; 
		vecteur_mouvement[1]=1;
		} 

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_DOWN){
			vecteur_mouvement[0]=0;
			vecteur_mouvement[1]=1;
			}
		if (code == KeyEvent.VK_UP){
			rotate=1;} 
		if (code == KeyEvent.VK_LEFT){ 
			vecteur_mouvement[0]=-1;
			vecteur_mouvement[1]=0;
			}
		if (code == KeyEvent.VK_RIGHT){
			vecteur_mouvement[0]=1;
			vecteur_mouvement[1]=0;
			} } 

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(rotate==1){
			Piece.rotate(1);
			if(limitrotation()){
				Piece.rotate(-1);
			}
			rotate=-1;
			
		}
		// TODO Auto-generated method stub
		int [][] coorbefore= new int[4][2];
		for (int i=0;i<4;i++){
			for (int j=0;j<2;j++){
				coorbefore[i][j]=Piece.Real_coordonne[i][j];
			}
		}
		//int [][] coorbefore=Piece.Real_coordonne
		Piece.move(vecteur_mouvement[0]*SquareTaille, vecteur_mouvement[1]*SquareTaille);
		limi(coorbefore);
		/*System.out.print(vecteur_mouvement[0]+"\n");
		System.out.print("action \n");
		System.out.print(vecteur_mouvement[1]+"\n");*/
		if(Gameover()){
			SCORE.setText("Game Over");
			temp.stop();
		}
		else
		SCORE.setText("The bests scores are : "+Best_5_scores+"  Your score is : "+String.valueOf(score));
		repaint(); 
	}
	private boolean limitrotation() {
		for(int i=0;i<4;i++){
			if(Piece.Real_coordonne[i][0]>18)
				return true;
			if(Piece.Real_coordonne[i][0]<0)
				return true;
			if(squareStored[Piece.Real_coordonne[i][0]][Piece.Real_coordonne[i][1]]==1){	
			System.out.print("w");
			int a= Piece.Real_coordonne[i][0];
				return true;
			}
		}
		return false;
	}


	public void start(){
		ChoisirPiece();
	       temp.start();
	       repaint();
	}
	public void ChoisirPiece(){
		//Piece.type=0;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.red);
		for(int i=0;i<4;i++){
		//System.out.print(Piece.Real_coordonne[i][0]+" "+Piece.Real_coordonne[i][1]);
		g.fillRect(SquareTaille*Piece.Real_coordonne[i][0], SquareTaille*Piece.Real_coordonne[i][1], SquareTaill, SquareTaill);
		}
		
		 for(int i=0;i<squareStoredX;i++){
			 for(int j=0;j<squareStoredY;j++){
				 if(squareStored[i][j]==1)
					 g.fillRect(i*SquareTaille, j*SquareTaille, SquareTaill, SquareTaill);
		 }
		 	}
		//g.fillRect(18*SquareTaille, 27*SquareTaille, SquareTaille, SquareTaille);
		}
		
		public void limi(int[][] coorbefore){
			if(limitsquareStoredX(Piece.Real_coordonne)){
				Piece.move(-1*vecteur_mouvement[0]*SquareTaille, vecteur_mouvement[1]*SquareTaille);
			}
			if(limitY()){
				Piece.move(-1*vecteur_mouvement[0]*SquareTaille, -1*vecteur_mouvement[1]*SquareTaille);
				for(int i=0;i<4;i++){
				squareStored[Piece.Real_coordonne[i][0]][Piece.Real_coordonne[i][1]]=1;
				}
				Piece= new Format_Piece();
				removeLine();
			}
			else if(limitsquareStored(Piece.Real_coordonne)){
				//Piece.move(-0*vecteur_mouvement[0]*SquareTaille, -3*vecteur_mouvement[1]*SquareTaille);
				for(int i=0;i<4;i++){
					squareStored[Piece.Real_coordonne[i][0]][Piece.Real_coordonne[i][1]]=1;
					}
				Piece= new Format_Piece();
				removeLine();
			}
			
		/* if(limitsquareUNStored()){
				Piece.move(-1*vecteur_mouvement[0]*SquareTaille, -1*vecteur_mouvement[1]*SquareTaille);
			}*/
			if(limitX()){
				Piece.move(-1*vecteur_mouvement[0]*SquareTaille, -1*vecteur_mouvement[1]*SquareTaille);
			}
			/*if(limitsquareStored(Piece.Real_coordonne)){
				Piece.move(-1*vecteur_mouvement[0]*SquareTaille, -1*vecteur_mouvement[1]*SquareTaille);
			}*/
			
			//else if()

		}
		public Boolean limitY(){
			for(int i=0;i<4;i++){
				if(Piece.Real_coordonne[i][1]>27)
					return true;
			}
			return false;
		}
		public Boolean limitX(){
			for(int i=0;i<4;i++){
				if(Piece.Real_coordonne[i][0]>18||Piece.Real_coordonne[i][0]<0)
					return true;
			}
			return false;
		}
		public Boolean limitsquareStored( int[][] coorbefore){
			int[] maxsquareStoredY =maxsquareStoredY();
			int[] maxsquareStoredX =maxsquareStoredX();
			
			//int[] minsquareStoredY = minsquareStoredY();
			for(int i=0;i<4;i++){
				if(coorbefore[i][1]>maxsquareStoredY[coorbefore[i][0]]-2){
				System.out.print("w");
				int a= Piece.Real_coordonne[i][0];
					return true;
				}
			}
			return false;
		}
		public Boolean limitsquareStoredX( int[][] coorbefore){
			
			
			//int[] minsquareStoredY = minsquareStoredY();
			for(int i=0;i<4;i++){
				if(coorbefore[i][0]>18)
					return true;
				if(coorbefore[i][0]<0)
					return true;
				if(squareStored[coorbefore[i][0]][coorbefore[i][1]]==1){	
				System.out.print("w");
				int a= Piece.Real_coordonne[i][0];
					return true;
				}
			}
			return false;
		}
		
		public int[] maxsquareStoredX(){
			int[]   maxX =new int [squareStoredY];
			for(int j=0;j<squareStoredY;j++){
				maxX[j]=squareStoredX;
				 for(int i=0;i<squareStoredX;i++){
					 if(squareStored[i][j]==1){
						 maxX[i]=i;
						 break;	
					 }
						 
				 	}
				 
			 	}
		return maxX;
		}
		
		public int[] maxsquareStoredY(){
			int[]   maxY =new int [squareStoredX];
			for(int i=0;i<squareStoredX;i++){
				maxY[i]=squareStoredY;
				 for(int j=0;j<squareStoredY;j++){
					 if(squareStored[i][j]==1){
						 maxY[i]=j;
						 break;	
					 }
						 
				 	}
				 
			 	}
		return maxY;
		}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	} 
	public void removeLine(){
		for(int j =squareStoredY-1;j>0;j--){
			int SumLine=0;
			for(int i =0;i<squareStoredX;i++){
				if(squareStored[i][j]==1)
					SumLine=SumLine+1;
			}
			if(SumLine==squareStoredX){
				score=score+1;
				for(int i =0;i<squareStoredX;i++){
					squareStored[i][j]=0;
				}
				
				for(int k =j;k>0;k--){
					for(int i =0;i<squareStoredX;i++){
						squareStored[i][k]=squareStored[i][k-1];
							
					}
				}
			}
		}
	}
	
	public Boolean Gameover(){
		if(squareStored[0][2]==1)
			return true;
		return false;
	}

}
