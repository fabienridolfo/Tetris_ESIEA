package Clone;

public class Format_Piece {
	String nom;
	String[] noms={"I","L","Carre"};
	int type;
	int rotation_indice;
	int[] rotation_indices={0,1,3};
	int[] types={0,1,2};
	int[][] cas= {{0,0},{0,1},{0,2},{0,3}};
	int[][][] cases={           {{0,0},{0,1},{0,2},{0,3}},
					            {{0,0},{1,0},{0,1},{0,2}},
					             {{0,0},{1,0},{0,1},{1,1}}  };

	int[][][][] cases_rotation={  { {{0,0},{0,1},{0,2},{0,3}}, {{0,0},{1,0},{2,0},{3,0}}, {{0,0},{1,0},{2,0},{3,0}},{{0,0},{0,1},{0,2},{0,3}} },
			 					{ {{0,0},{1,0},{0,1},{0,2}}, {{0,0},{-1,0},{0,1},{0,2}},{{0,0},{-1,0},{0,-1},{0,-2}},{{0,0},{1,0},{2,0},{0,1}} },
			 					{ {{0,0},{1,0},{0,1},{1,1}}, {{0,0},{1,0},{0,1},{1,1}},{{0,0},{1,0},{0,1},{1,1}},{{0,0},{1,0},{0,1},{1,1}}  }};
	int[][] Real_coordonne= {{0,0},{0,1},{0,2},{0,3}};
	
	public Format_Piece(){
		type= (int) (Math.random()*3); ;
		rotation_indice=0;
		for(int i=0;i<4;i++){
		Real_coordonne[i][0]=cases_rotation[type][rotation_indice][i][0];
		Real_coordonne[i][1]=cases_rotation[type][rotation_indice][i][1];
		cas[i][0]=cases[type][i][0];
		cas[i][1]=cases[type][i][1];
		}
		
	}
	
	public void move(int deltaX, int DeltaY){
		for(int i=0;i<4;i++){
				Real_coordonne[i][0]=Real_coordonne[i][0]+deltaX/Game_Logic.SquareTaille;
				Real_coordonne[i][1]=Real_coordonne[i][1]+DeltaY/Game_Logic.SquareTaille;
			
	}
}
	public void rotate(int direction){
		update_rotation_indice(direction);
		if(type==1){
		for(int i=0;i<4;i++){
				Real_coordonne[i][0]=Real_coordonne[0][0]+cases_rotation[type][rotation_indice][i][0];
				//if(rotation_indice==2)
				Real_coordonne[i][1]=Real_coordonne[0][1]+cases_rotation[type][rotation_indice][i][1];
	}
}
		if(type==0){
			for(int i=0;i<4;i++){
					Real_coordonne[i][0]=Real_coordonne[0][0]+cases_rotation[type][rotation_indice][i][0];
					Real_coordonne[i][1]=Real_coordonne[0][1]+cases_rotation[type][rotation_indice][i][1];
					//Real_coordonne[i][1]=Real_coordonne[i][1]+deltaX/Link.square;
		}
	}
}
	public void update_rotation_indice(int direction){
		if(direction==1){
		if(rotation_indice==0)
			rotation_indice=1;
		else if (rotation_indice==1)
			rotation_indice=2;
		else if (rotation_indice==2)
			rotation_indice=3;
		else rotation_indice=0;
		}
		else 
			if(rotation_indice==0)
				rotation_indice=3;
			else if (rotation_indice==3)
				rotation_indice=2;
			else if (rotation_indice==2)
				rotation_indice=1;
			else rotation_indice=0;
			
	}
}