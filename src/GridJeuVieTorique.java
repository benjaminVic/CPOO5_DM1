
public class GridJeuVieTorique implements Grid<State, SquareGridNbh, CellJeuVie>{

	private CellJeuVie[][] tableau;
	private final boolean handlesDiagonals;
	private int rows;
	private int colums;	

	/**TODO
	 * Construct a grid randomly
	 * @param rows : number of rows
	 * @param colums : number of colums
	 */
	public GridJeuVieTorique(int rows, int colums, boolean handlesDiagonals){
		int enumElems = 0;
		this.handlesDiagonals = handlesDiagonals;
		if (this.handlesDiagonals == true){
			enumElems = SquareGridNbh.values().length;
		} else {
			enumElems = (SquareGridNbh.values().length/2);	
		}

		this.rows = rows;
		this.colums = colums;	

		/*Initialisation du tableau*/
		tableau = new CellJeuVie[rows][colums];
		for (int i = 0;i<rows;i++){
			for (int j = 0; j<colums ; j++){
				tableau[i][j] = new CellJeuVie(enumElems);
			}
		}
		neighborConstructor();
	}
	
	/**
	 * Constructor of a Grid with preset
	 * @param preset : code of the chosen preset
	 */
	public GridJeuVieTorique(String preset, boolean handlesDiagonals){
		this.handlesDiagonals = handlesDiagonals;
		switch (preset){
		case ("a") :
			this.rows = 15;
			this.colums = 38;
			/*Initialisation du tableau*/
			tableau = new CellJeuVie[rows][colums];
			for (int i = 0;i<rows;i++){
				for (int j = 0; j<colums ; j++){
					tableau[i][j] = new CellJeuVie(8);
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
			int enumElems2 = 0;
			enumElems2 = SquareGridNbh.values().length;
			this.rows = 9;
			this.colums = 28;
			/* Initialisation du tableau */
			tableau = new CellJeuVie[rows][colums];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < colums; j++) {
					tableau[i][j] = new CellJeuVie(enumElems2);
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
	 * but it make the creation process way faster
	 */
	private void neighborConstructor(){
		/*Gestion des voisins*/

		/*
		 * General case
		 * handles the table without its border
		 */
		for (int i = 1;i<rows-1;i++){
			for (int j = 1; j<colums-1 ; j++){
				tableau[i][j].setNeighbors(SquareGridNbh.NORTH, tableau[i-1][j]);
				tableau[i][j].setNeighbors(SquareGridNbh.EAST, tableau[i][j+1]);
				tableau[i][j].setNeighbors(SquareGridNbh.SOUTH, tableau[i+1][j]);
				tableau[i][j].setNeighbors(SquareGridNbh.WEST, tableau[i][j-1]);
				if (this.handlesDiagonals == true){
					tableau[i][j].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[i-1][j+1]);				
					tableau[i][j].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[i+1][j+1]);
					tableau[i][j].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[i+1][j-1]);
					tableau[i][j].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[i-1][j-1]);
				}
			}
		}

		/*
		 * Corner Case
		 * by doing them independently we drastically reduce the number of tests needed
		 * to handle the corners and therefor we acceleerate the algorithm
		 */

		/*
		 * TOP LEFT CORNER
		 */		
		tableau[0][0].setNeighbors(SquareGridNbh.NORTH, tableau[rows-1][0]);
		tableau[0][0].setNeighbors(SquareGridNbh.EAST, tableau[0][1]);
		tableau[0][0].setNeighbors(SquareGridNbh.SOUTH, tableau[1][0]);
		tableau[0][0].setNeighbors(SquareGridNbh.WEST, tableau[rows-1][colums-1]);
		if (this.handlesDiagonals == true){
			tableau[0][0].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-1][1]);
			tableau[0][0].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[1][1]);
			tableau[0][0].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[1][colums-1]);
			tableau[0][0].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-1][colums-1]);
		}

		/*
		 * TOP RIGHT CORNER
		 */
		tableau[0][colums-1].setNeighbors(SquareGridNbh.NORTH, tableau[rows-1][colums-1]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.EAST, tableau[0][0]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.SOUTH, tableau[1][colums-1]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.WEST, tableau[0][colums-2]);
		if (this.handlesDiagonals == true){
			tableau[0][colums-1].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-1][0]);
			tableau[0][colums-1].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[1][0]);
			tableau[0][colums-1].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[1][colums-2]);
			tableau[0][colums-1].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-1][colums-2]);
		}

		/*
		 * BOTTOM LEFT CORNER
		 */
		tableau[rows-1][0].setNeighbors(SquareGridNbh.NORTH, tableau[rows-2][0]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.EAST, tableau[rows-1][1]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.SOUTH, tableau[0][0]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.WEST, tableau[rows-1][colums-1]);
		if (this.handlesDiagonals == true){
			tableau[rows-1][0].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-2][1]);
			tableau[rows-1][0].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[0][1]);
			tableau[rows-1][0].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[0][colums-1]);
			tableau[rows-1][0].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-2][colums-1]);
		}

		/*
		 * BOTTOM LEFT CORNER
		 */
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.NORTH, tableau[rows-2][colums-1]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.EAST, tableau[rows-1][0]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.SOUTH, tableau[0][colums-1]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.WEST, tableau[rows-1][colums-2]);
		if (this.handlesDiagonals == true){
			tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-2][0]);
			tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[0][0]);
			tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[0][colums-2]);
			tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-2][colums-2]);
		}

		/*
		 * Border case
		 * Handles the border without the corners of the table.
		 */

		/*
		 * TOP AND BOTTOM BORDER
		 */
		for (int c = 1 ; c<colums-1 ; c++){
			//TOP
			tableau[0][c].setNeighbors(SquareGridNbh.NORTH, tableau[rows-1][c]);
			tableau[0][c].setNeighbors(SquareGridNbh.EAST, tableau[0][c+1]);
			tableau[0][c].setNeighbors(SquareGridNbh.SOUTH, tableau[1][colums-1]);
			tableau[0][c].setNeighbors(SquareGridNbh.WEST, tableau[0][c-1]);
			if (this.handlesDiagonals == true){
				tableau[0][c].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-1][c+1]);
				tableau[0][c].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[1][c+1]);
				tableau[0][c].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[1][c-1]);
				tableau[0][c].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-1][c-1]);
			}

			//BOOTTOM
			tableau[rows-1][c].setNeighbors(SquareGridNbh.NORTH, tableau[rows-2][c]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.EAST, tableau[rows-1][c+1]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.SOUTH, tableau[0][colums-1]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.WEST, tableau[rows-1][c-1]);
			if (this.handlesDiagonals == true){
				tableau[rows-1][c].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-2][c+1]);
				tableau[rows-1][c].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[0][c+1]);
				tableau[rows-1][c].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[0][c-1]);
				tableau[rows-1][c].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-2][c-1]);
			}
		}

		/*
		 * LEFT AND RIGHT BORDERS
		 */
		for (int l = 1 ; l<rows-1 ; l++){
			//LEFT
			tableau[l][0].setNeighbors(SquareGridNbh.NORTH, tableau[l-1][0]);
			tableau[l][0].setNeighbors(SquareGridNbh.EAST, tableau[l][1]);
			tableau[l][0].setNeighbors(SquareGridNbh.SOUTH, tableau[l+1][0]);
			tableau[l][0].setNeighbors(SquareGridNbh.WEST, tableau[l][colums-1]);
			if (this.handlesDiagonals == true){
				tableau[l][0].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[l-1][1]);
				tableau[l][0].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[l+1][1]);
				tableau[l][0].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[l+1][colums-1]);
				tableau[l][0].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[l-1][colums-1]);
			}

			//RIGHT
			tableau[l][colums-1].setNeighbors(SquareGridNbh.NORTH, tableau[l-1][colums-1]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.EAST, tableau[l][0]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.SOUTH, tableau[l+1][colums-1]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.WEST, tableau[l][colums-2]);
			if (this.handlesDiagonals == true){
				tableau[l][colums-1].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[l-1][0]);
				tableau[l][colums-1].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[l+1][0]);
				tableau[l][colums-1].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[l+1][colums-2]);
				tableau[l][colums-1].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[l-1][colums-2]);
			}
		}
	}
	
	/**
	 * Obtain a cell from the Grid
	 * @param row : rows number
	 * @param colum : column number
	 * @return : the cell at a given position
	 */
	public CellJeuVie getCell(int row, int colum){
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
			for (int j = 0 ; j < colums ; j++){
				stringBuilder.append(' ').append(tableau[i][j].getState().toChar());
			}
		}
		return stringBuilder.toString();
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
