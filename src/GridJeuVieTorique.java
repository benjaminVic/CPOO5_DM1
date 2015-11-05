
public class GridJeuVieTorique implements Grid<State, SquareGridNbh, CellJeuVieTorique>{

	private CellJeuVieTorique[][] tableau;
	private final int enumElem;
	private int rows;
	private int colums;
	

	public GridJeuVieTorique(int rows, int colums){
		int enumElems = 0;
		enumElems = SquareGridNbh.values().length;
			
		
		
		this.enumElem = enumElems;
		System.out.println(enumElems);
		
		/*Initialisation du tableau*/
		tableau = new CellJeuVieTorique[rows][colums];
		for (int i = 0;i<rows;i++){
			for (int j = 0; j<colums ; j++){
				tableau[i][j] = new CellJeuVieTorique(this.enumElem);
			}
		}
		/*Gestion des voisins*/

		/*
		 * General case
		 * handles the table without its border
		 */
		for (int i = 1;i<rows-1;i++){
			for (int j = 1; j<colums-1 ; j++){
				tableau[i][j].setNeighbors(SquareGridNbh.NORTH, tableau[i-1][j]);
				tableau[i][j].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[i-1][j+1]);
				tableau[i][j].setNeighbors(SquareGridNbh.EAST, tableau[i][j+1]);
				tableau[i][j].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[i+1][j+1]);
				tableau[i][j].setNeighbors(SquareGridNbh.SOUTH, tableau[i+1][j]);
				tableau[i][j].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[i+1][j-1]);
				tableau[i][j].setNeighbors(SquareGridNbh.WEST, tableau[i][j-1]);
				tableau[i][j].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[i-1][j-1]);
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
		tableau[0][0].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-1][1]);
		tableau[0][0].setNeighbors(SquareGridNbh.EAST, tableau[0][1]);
		tableau[0][0].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[1][1]);
		tableau[0][0].setNeighbors(SquareGridNbh.SOUTH, tableau[1][0]);
		tableau[0][0].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[1][colums-1]);
		tableau[0][0].setNeighbors(SquareGridNbh.WEST, tableau[rows-1][colums-1]);
		tableau[0][0].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-1][colums-1]);

		/*
		 * TOP RIGHT CORNER
		 */
		tableau[0][colums-1].setNeighbors(SquareGridNbh.NORTH, tableau[rows-1][colums-1]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-1][0]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.EAST, tableau[0][0]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[1][0]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.SOUTH, tableau[1][colums-1]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[1][colums-2]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.WEST, tableau[0][colums-2]);
		tableau[0][colums-1].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-1][colums-2]);

		/*
		 * BOTTOM LEFT CORNER
		 */
		tableau[rows-1][0].setNeighbors(SquareGridNbh.NORTH, tableau[rows-2][0]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-2][1]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.EAST, tableau[rows-1][1]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[0][1]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.SOUTH, tableau[0][0]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[0][colums-1]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.WEST, tableau[rows-1][colums-1]);
		tableau[rows-1][0].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-2][colums-1]);

		/*
		 * BOTTOM LEFT CORNER
		 */
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.NORTH, tableau[rows-2][colums-1]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-2][0]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.EAST, tableau[rows-1][0]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[0][0]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.SOUTH, tableau[0][colums-1]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[0][colums-2]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.WEST, tableau[rows-1][colums-2]);
		tableau[rows-1][colums-1].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-2][colums-2]);

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
			tableau[0][c].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-1][c+1]);
			tableau[0][c].setNeighbors(SquareGridNbh.EAST, tableau[0][c+1]);
			tableau[0][c].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[1][c+1]);
			tableau[0][c].setNeighbors(SquareGridNbh.SOUTH, tableau[1][colums-1]);
			tableau[0][c].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[1][c-1]);
			tableau[0][c].setNeighbors(SquareGridNbh.WEST, tableau[0][c-1]);
			tableau[0][c].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-1][c-1]);
			
			//BOOTTOM
			tableau[rows-1][c].setNeighbors(SquareGridNbh.NORTH, tableau[rows-2][c]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[rows-2][c+1]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.EAST, tableau[rows-1][c+1]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[0][c+1]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.SOUTH, tableau[0][colums-1]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[0][c-1]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.WEST, tableau[rows-1][c-1]);
			tableau[rows-1][c].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[rows-2][c-1]);
		}
		
		/*
		 * LEFT AND RIGHT BORDERS
		 */
		for (int l = 1 ; l<rows-1 ; l++){
			//LEFT
			tableau[l][0].setNeighbors(SquareGridNbh.NORTH, tableau[l-1][0]);
			tableau[l][0].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[l-1][1]);
			tableau[l][0].setNeighbors(SquareGridNbh.EAST, tableau[l][1]);
			tableau[l][0].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[l+1][1]);
			tableau[l][0].setNeighbors(SquareGridNbh.SOUTH, tableau[l+1][0]);
			tableau[l][0].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[l+1][colums-1]);
			tableau[l][0].setNeighbors(SquareGridNbh.WEST, tableau[l][colums-1]);
			tableau[l][0].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[l-1][colums-1]);
			
			//RIGHT
			tableau[l][colums-1].setNeighbors(SquareGridNbh.NORTH, tableau[l-1][colums-1]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.NORTH_EAST, tableau[l-1][0]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.EAST, tableau[l][0]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.SOUTH_EAST, tableau[l+1][0]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.SOUTH, tableau[l+1][colums-1]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.SOUTH_WEST, tableau[l+1][colums-2]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.WEST, tableau[l][colums-2]);
			tableau[l][colums-1].setNeighbors(SquareGridNbh.NORTH_WEST, tableau[l-1][colums-2]);
		}
	}
	
	public CellJeuVieTorique getCell(int row, int colum){
		return tableau[row][colum];
	}

	@Override
	public void update() {
		CellJeuVieTorique[][] tableauEtatTemp = tableau.clone();
		int aliveNeighbors;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				// Number of living neighbors
				aliveNeighbors = 0;
				for (SquareGridNbh direction : SquareGridNbh.values()) {
					if (tableau[i][j].getNeighbor(direction).getState() == LifeState.ALIVE) {
						aliveNeighbors++;
					}
				}
				//Choosing of the cell's state
				if (tableau[i][j].getState() == LifeState.ALIVE 
						&& (aliveNeighbors == 2 || aliveNeighbors == 3)) {
					tableauEtatTemp[i][j].setState(LifeState.ALIVE);
				} else if(tableau[i][j].getState() == LifeState.DEAD 
						&& aliveNeighbors == 3) {
					tableauEtatTemp[i][j].setState(LifeState.ALIVE);
				} else {
					tableauEtatTemp[i][j].setState(LifeState.DEAD);
				}
			}
		}
		//Changing state of the actual table
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				tableau[i][j].setState(tableauEtatTemp[i][j].getState());
			}			
		}
	}

	@Override
	public String stateAsString() {
		String returnValue = "";
		for (int i = 0 ; i<rows ; i++){
			returnValue += "\n";
			for (int j = 0 ; j < colums ; j++){
				returnValue += " " + tableau[i][j].getState().toChar();
			}
		}
		return returnValue;
	}

}
