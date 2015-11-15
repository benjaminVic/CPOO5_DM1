
public class GridJeuVieTriangle implements Grid<State, TriangularGridNbh, CellJeuVieTriangle>{

	private CellJeuVieTriangle[][] tableau;
	private final boolean handlesDiagonals;
	private int rows;
	private int colums;	
	
	public GridJeuVieTriangle(String preset, boolean handlesDiagonals){
		this.handlesDiagonals = handlesDiagonals;
		switch (preset){
		case ("a") :
			this.rows = 15;
			this.colums = 38;
			int enumElems = 0;
			if (this.handlesDiagonals == true){
				enumElems = TriangularGridNbh.values().length;
			} else {
				enumElems = (TriangularGridNbh.values().length/2);	
			}
			/*Initialisation du tableau*/
			tableau = new CellJeuVieTriangle[rows][colums];
			for (int i = 0;i<rows;i++){
				for (int j = 0; j<colums ; j++){
					tableau[i][j] = new CellJeuVieTriangle(enumElems);
				}
			}
			neighborConstructor();
			
			/*
			 * Setting the preset on living cells
			 * models : http://math.pc.vh.free.fr/divers/life/guns.htm
			 */
			tableau[5][1].setState(LifeState.ALIVE);
			tableau[5][2].setState(LifeState.ALIVE);
			tableau[6][1].setState(LifeState.ALIVE);
			tableau[6][2].setState(LifeState.ALIVE);
			tableau[3][35].setState(LifeState.ALIVE);
			tableau[4][35].setState(LifeState.ALIVE);
			tableau[3][36].setState(LifeState.ALIVE);
			tableau[4][36].setState(LifeState.ALIVE);
			
			tableau[2][23].setState(LifeState.ALIVE);
			tableau[6][23].setState(LifeState.ALIVE);
			
			tableau[1][25].setState(LifeState.ALIVE);
			tableau[2][25].setState(LifeState.ALIVE);
			
			tableau[6][25].setState(LifeState.ALIVE);
			tableau[7][25].setState(LifeState.ALIVE);
			
			tableau[1][25].setState(LifeState.ALIVE);
			tableau[2][25].setState(LifeState.ALIVE);
			
			tableau[3][22].setState(LifeState.ALIVE);
			tableau[4][22].setState(LifeState.ALIVE);
			tableau[5][22].setState(LifeState.ALIVE);
			tableau[3][21].setState(LifeState.ALIVE);
			tableau[4][21].setState(LifeState.ALIVE);
			tableau[5][21].setState(LifeState.ALIVE);
			
			tableau[3][13].setState(LifeState.ALIVE);
			tableau[3][14].setState(LifeState.ALIVE);
			tableau[9][13].setState(LifeState.ALIVE);
			tableau[9][14].setState(LifeState.ALIVE);
			
			tableau[4][12].setState(LifeState.ALIVE);
			tableau[8][12].setState(LifeState.ALIVE);
			
			tableau[5][11].setState(LifeState.ALIVE);
			tableau[6][11].setState(LifeState.ALIVE);
			tableau[7][11].setState(LifeState.ALIVE);
			
			tableau[6][15].setState(LifeState.ALIVE);
			
			tableau[4][16].setState(LifeState.ALIVE);
			tableau[8][16].setState(LifeState.ALIVE);
			
			tableau[5][17].setState(LifeState.ALIVE);
			tableau[6][17].setState(LifeState.ALIVE);
			tableau[7][17].setState(LifeState.ALIVE);
			
			tableau[6][18].setState(LifeState.ALIVE);
		break;

		case ("b") :
			this.rows = 9;
			this.colums = 28;
			int enumElems2 = 0;
			if (this.handlesDiagonals == true){
				enumElems2 = TriangularGridNbh.values().length;
			} else {
				enumElems2 = (TriangularGridNbh.values().length/2);	
			}
			/* Initialisation du tableau */
			tableau = new CellJeuVieTriangle[rows][colums];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < colums; j++) {
					tableau[i][j] = new CellJeuVieTriangle(enumElems2);
				}
			}
			neighborConstructor();
			tableau[2][1].setState(LifeState.ALIVE);			
			tableau[1][2].setState(LifeState.ALIVE);
			tableau[1][3].setState(LifeState.ALIVE);
			tableau[1][4].setState(LifeState.ALIVE);
			tableau[2][4].setState(LifeState.ALIVE);
			tableau[3][4].setState(LifeState.ALIVE);
			tableau[4][4].setState(LifeState.ALIVE);
			tableau[5][4].setState(LifeState.ALIVE);
			tableau[6][4].setState(LifeState.ALIVE);
			tableau[7][3].setState(LifeState.ALIVE);
			
			tableau[5][7].setState(LifeState.ALIVE);
			tableau[6][7].setState(LifeState.ALIVE);
			tableau[6][8].setState(LifeState.ALIVE);
			tableau[7][7].setState(LifeState.ALIVE);
			tableau[7][8].setState(LifeState.ALIVE);
			
			tableau[3][9].setState(LifeState.ALIVE);
			tableau[2][10].setState(LifeState.ALIVE);
			tableau[3][10].setState(LifeState.ALIVE);
			tableau[1][11].setState(LifeState.ALIVE);
			tableau[2][11].setState(LifeState.ALIVE);
			tableau[2][12].setState(LifeState.ALIVE);
			tableau[3][12].setState(LifeState.ALIVE);
			
			tableau[2][16].setState(LifeState.ALIVE);
			tableau[3][16].setState(LifeState.ALIVE);
			tableau[1][17].setState(LifeState.ALIVE);
			tableau[2][17].setState(LifeState.ALIVE);
			tableau[2][18].setState(LifeState.ALIVE);
			tableau[3][18].setState(LifeState.ALIVE);
			tableau[3][19].setState(LifeState.ALIVE);
			
			tableau[6][20].setState(LifeState.ALIVE);
			tableau[7][20].setState(LifeState.ALIVE);
			tableau[5][21].setState(LifeState.ALIVE);
			tableau[6][21].setState(LifeState.ALIVE);
			tableau[7][21].setState(LifeState.ALIVE);
			
			tableau[6][24].setState(LifeState.ALIVE);
			tableau[5][24].setState(LifeState.ALIVE);
			tableau[4][24].setState(LifeState.ALIVE);
			tableau[3][24].setState(LifeState.ALIVE);
			tableau[2][24].setState(LifeState.ALIVE);
			tableau[1][24].setState(LifeState.ALIVE);
			tableau[7][25].setState(LifeState.ALIVE);
			tableau[1][25].setState(LifeState.ALIVE);
			tableau[1][26].setState(LifeState.ALIVE);
			tableau[2][27].setState(LifeState.ALIVE);
			break;
		}
	}
	
	private void neighborConstructor(){
		
		//GENERAL CASE
		for (int i = 1;i<rows-1;i++){
			for (int j = 1; j<colums-1 ; j++){
				if ( (i%2 == 1 && j%2 == 0) || (i%2 == 0 && j%2 == 1) ){
					tableau[i][j].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[i+1][j]);
					tableau[i][j].setNeighbors(TriangularGridNbh.LEFT, tableau[i][j-1]);
					tableau[i][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[i][j+1]);
				} else /*(i%2 == 0 && j%2 == 0) || (i%2 == 1 && j%2 == 1)*/{
					tableau[i][j].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[i-1][j]);
					tableau[i][j].setNeighbors(TriangularGridNbh.LEFT, tableau[i][j-1]);
					tableau[i][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[i][j+1]);
				}
			}
		}	
		
		//TOP LEFT CORNER
		tableau[0][0] = new CellJeuVieTriangle(1);
		tableau[0][0].setNeighbors(TriangularGridNbh.RIGHT, tableau[0][1]);
		
		//TODO TOP RIGHT CORNER
		
		//TODO BOTTOM LEFT CORNER
		
		//TODO BOTTOM RIGHT CORNER
		
		//LEFT COLUMN
		for (int i = 1 ; i< rows-1 ; ++i){
			tableau[i][0] = new CellJeuVieTriangle(2);
			if(i%2 == 1){
				tableau[i][0].setNeighbors(TriangularGridNbh.RIGHT, tableau[i][1]);
				tableau[i][0].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[i+1][0]);
			} else {
				tableau[i][0].setNeighbors(TriangularGridNbh.RIGHT, tableau[i][1]);
				tableau[i][0].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[i-1][0]);
			}
		}
		
		//RIGHT COLUMN
		for (int i = 1 ; i < rows-1 ; ++i){
			if (i%2 == 1){
				
			}
		}
		
		//TOP AND BOTTOM LINE
			for (int j = 1 ; j < colums-1 ; ++j){

				//if the column is NOT EVEN
				if(j%2 == 1){
					//TOP
					tableau[0][j].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[1][j]);
					tableau[0][j].setNeighbors(TriangularGridNbh.LEFT, tableau[0][j-1]);
					tableau[0][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[0][j+1]);				

					//if the last line is NOT EVEN
					if ((rows-1)%2 == 1){
						//BOTTOM
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.LEFT, tableau[rows-1][j-1]);
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[rows-1][j+1]);
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[rows-1][j]);
					//if the last line is EVEN
					} else {
						tableau[rows-1][j] = new CellJeuVieTriangle(2);
						//BOTTOM
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.LEFT, tableau[rows-1][j-1]);
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[rows-1][j+1]);
					}
					//if the column is EVEN
				} else /*(j%2 == 0)*/{
					//TOP
					tableau[0][j] = new CellJeuVieTriangle(2);
					tableau[0][j].setNeighbors(TriangularGridNbh.LEFT, tableau[0][j-1]);
					tableau[0][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[0][j+1]);
					//if the last line is NOT EVEN
					 if ((rows-1)%2 == 1) {
						 //BOTTOM
						tableau[rows-1][j] = new CellJeuVieTriangle(2);
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.LEFT, tableau[rows-1][j-1]);
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[rows-1][j+1]);
					//if the last line is EVEN
					 } else {
						//BOTTOM
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.LEFT, tableau[rows-1][j-1]);
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[rows-1][j+1]);
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[rows-1][j]);
					 }
				}
			}
				
	}
	
	@Override
	public void update() {
		LifeState[][] tableauEtatTemp = new LifeState[rows][colums];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				tableauEtatTemp[i][j] = tableau[i][j].nextState();
			}
		}
		//Changing state of the actual table
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				tableau[i][j].setState(tableauEtatTemp[i][j]);
			}			
		}
	}

	@Override
	public String stateAsString() {
		// TODO Auto-generated method stub
		return null;
	}

}
