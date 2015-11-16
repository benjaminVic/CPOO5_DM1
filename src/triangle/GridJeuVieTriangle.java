package triangle;
import square.CellJeuVieSquare;
import square.LifeState;
import square.SquareGridNbh;
import appli.Grid;
import appli.State;


public class GridJeuVieTriangle implements Grid<State, TriangularGridNbh, CellJeuVieTriangle>{

	private CellJeuVieTriangle[][] tableau;
	private int rows;
	private int colums;	
	
	/**
	 * Constructor of the TriangularGrid
	 * @param rows : number of rows
	 * @param colums : number of colums
	 */
	public GridJeuVieTriangle(int rows, int colums) {
		int enumElems;
		enumElems = TriangularGridNbh.values().length;
		this.rows = rows;
		this.colums = colums;
		
		/*Initialisation du tableau*/
		tableau = new CellJeuVieTriangle[rows][colums];
		for (int i = 0;i<rows;i++){
			for (int j = 0; j<colums ; j++){
				tableau[i][j] = new CellJeuVieTriangle(enumElems);
			}
		}
		neighborConstructor();
	}
	
	/**
	 * Constructor of prebuilt Grid
	 * @param preset : choice of the present in text mode
	 */
	public GridJeuVieTriangle(String preset){
		switch (preset){
		case ("a") :
			this.rows = 15;
			this.colums = 38;
			int enumElems = 0;
				enumElems = TriangularGridNbh.values().length;
			/*Initialisation du tableau*/
			tableau = new CellJeuVieTriangle[rows][colums];
			for (int i = 0;i<rows;i++){
				for (int j = 0; j<colums ; j++){
					tableau[i][j] = new CellJeuVieTriangle(enumElems);
				}
			}
			
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
				enumElems2 = TriangularGridNbh.values().length;
			/* Initialisation du tableau */
			tableau = new CellJeuVieTriangle[rows][colums];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < colums; j++) {
					tableau[i][j] = new CellJeuVieTriangle(enumElems2);
				}
			}
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
		neighborConstructor();
	}

	/**
	 * Build the table of neighbors, lots of verbose
	 * but it makes the creation process way faster
	 */
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
		tableau[0][0].setNeighbors(TriangularGridNbh.RIGHT, tableau[0][1]);
		
		// TOP RIGHT CORNER
		tableau[0][colums-1].setNeighbors(TriangularGridNbh.LEFT, tableau[0][colums-2]);
		if ((colums-1)%2 == 1){
			tableau[0][colums-1].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[1][colums-1]);
		}
		
		// BOTTOM LEFT CORNER
		tableau[rows-1][0].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[rows-1][1]);
		if((rows-1)%2 == 0){
			tableau[rows-1][0].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[rows-2][0]);
		}
		
		// BOTTOM RIGHT CORNER
		tableau[rows-1][colums-1].setNeighbors(TriangularGridNbh.LEFT, tableau[rows-1][colums-2]);
		if (((rows-1)%2 == 1 && ((colums-1)%2 == 1)) || ((rows-1)%2 == 0 && ((colums-1)%2 == 0))){
			tableau[rows-1][colums-1].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[rows-2][colums-1]);
		}
		
		//LEFT COLUMN AND RIGHT COLUMN
		for (int i = 1 ; i< rows-1 ; ++i){
			//LEFT
			tableau[i][0].setNeighbors(TriangularGridNbh.RIGHT, tableau[i][1]);
			//RIGHT
			tableau[i][colums-1].setNeighbors(TriangularGridNbh.LEFT, tableau[i][colums-2]);
			if(i%2 == 1){
				//LEFT
				tableau[i][0].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[i+1][0]);
				//RIGHT
				if((colums-1)%2 == 1 ){
					tableau[i][colums-1].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[i-1][colums-1]);
				}
			} else {
				//LEFT
				tableau[i][0].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[i-1][0]);
				//RIGHT
				if((colums-1)%2 == 0 ){
					tableau[i][colums-1].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[i-1][colums-1]);
				}
			}
		}
		
		//TOP AND BOTTOM LINE
			for (int j = 1 ; j < colums-1 ; ++j){
				//TOP
				tableau[0][j].setNeighbors(TriangularGridNbh.LEFT, tableau[0][j-1]);
				tableau[0][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[0][j+1]);
				//BOTTOM
				tableau[rows-1][j].setNeighbors(TriangularGridNbh.LEFT, tableau[rows-1][j-1]);
				tableau[rows-1][j].setNeighbors(TriangularGridNbh.RIGHT, tableau[rows-1][j+1]);
				//if the column is NOT EVEN
				if(j%2 == 1){
					//TOP
					tableau[0][j].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[1][j]);
					//if the last line is NOT EVEN
					if ((rows-1)%2 == 1){
						//BOTTOM
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[rows-1][j]);
					//if the last line is EVEN
					}
					//if the column is EVEN
				} else /*(j%2 == 0)*/{
					//if the last line is NOT EVEN
					 if (!((rows-1)%2 == 1)) {
						tableau[rows-1][j].setNeighbors(TriangularGridNbh.VERTICALITY, tableau[rows-1][j]);
					 }
				}
			}
				
	}
	
	/**
	 * Obtain a cell from the Grid
	 * @param row : rows number
	 * @param colum : column number
	 * @return : the cell at a given position
	 */
	public CellJeuVieTriangle getCell(int row, int colum){
		return tableau[row][colum];
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
		final StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0 ; i<rows ; i++){
			stringBuilder .append('\n');
			//appendTriangleLines(i,stringBuilder);
			stringBuilder .append('\n');
			if (i%2==1){
				stringBuilder.append('/');
			} else {
				stringBuilder.append('\\');
			}
			for (int j = 0 ; j < colums ; j++){
				if (i%2 == 1){
					if (j%2==1){
						stringBuilder.append(tableau[i][j].getState().toChar()).append('/');
					} else {
						stringBuilder.append(tableau[i][j].getState().toChar()).append('\\');
					}
				} else {
					if (j%2==1){
						stringBuilder.append(tableau[i][j].getState().toChar()).append('\\');
					} else {
						stringBuilder.append(tableau[i][j].getState().toChar()).append('/');
					}
				}
			}
		}
		return stringBuilder.toString();
	}
	
	/**
	 * Tentative of a cell maker, doesn't display as it should
	 * @param i : line to be displayed
	 * @param stringBuilder : to be appended for printing
	 * @return : argument stringBuilder with the cells underlines
	 */
	public StringBuilder appendTriangleLines(int i, StringBuilder stringBuilder){
		if (i%2 == 1){
			stringBuilder.append(' ').append('+');
			for (int j = 0 ; j<colums ; ++j){
				if (j%2 == 1){
					stringBuilder.append('-').append('-').append('-');
				} else {
					stringBuilder.append('+');
				}
			}
		} else {
			stringBuilder.append('+');
			for (int j = 0 ; j<colums ; ++j){
				if (j%2 == 1){
					stringBuilder.append('+');
				} else {
					stringBuilder.append('-').append('-').append('-');
				}
			}
		}
		
		return stringBuilder;
	}
	
	/**
	 * @return : number of rows in the Grid
	 */
	public int getRows(){
		return this.rows;
	}
	
	/**
	 * @return : number of colums in the Grid
	 */
	public int getColums(){
		return this.colums;
	}

}
