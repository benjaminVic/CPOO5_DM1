package highLife;

import square.LifeState;
import square.SquareGridNbh;
import appli.Cell;
import appli.State;

public class CellHighLifeSquare implements Cell<State, SquareGridNbh>{
	private State cellState;
	private CellHighLifeSquare[] neighbor;
	
	/**
	 * Cell Constructor
	 * @param sizeEnum : neighbors table size : 8 if all directions 4 if only cardinals
	 */
	public CellHighLifeSquare(int sizeEnum){
		cellState = LifeState.DEAD;
		neighbor = new CellHighLifeSquare[sizeEnum];
	}

	/**
	 * Return the state of the cell
	 */
	public State getState() {
		return cellState;
	}

	/**
	 * Change the state of the cell
	 */
	public void setState(State state) {
		cellState = state;		
	}

	@Override
	public LifeState nextState() {
		int aliveNeighbor = 0 ;
		for (CellHighLifeSquare cjv : neighbor){
			if(cjv.getState() == LifeState.ALIVE){
				aliveNeighbor++;
			}
		}
		if (cellState == LifeState.ALIVE && 
				(aliveNeighbor == 2 || aliveNeighbor == 3)){
			return LifeState.ALIVE;
		} else if ((cellState == LifeState.DEAD && aliveNeighbor == 3)
				|| (cellState == LifeState.DEAD && aliveNeighbor == 6)){
			return LifeState.ALIVE;
		}
		return LifeState.DEAD;
	}

	/**
	 * Give the reference to another cell
	 * @param direction : direction of the neighbor
	 * @param c : cell to which the neigbor is pointing
	 */
	public void setNeighbors(SquareGridNbh direction, CellHighLifeSquare c){
		neighbor[neighborDirection(direction)] = c;
	}
		
	public CellHighLifeSquare getNeighbor(SquareGridNbh direction) {
		return neighbor[neighborDirection(direction)];
		
	}
	
	/**
	 * points in the array of neighbors
	 * @param direction : the direction from which the neighbor is needed
	 * @return : a pointer to the array of reference of neighbors
	 */
	public int neighborDirection(SquareGridNbh direction){
		switch (direction){
		
		case NORTH :
			return 0;
			
		case NORTH_EAST :
			return 4;
			
		case EAST :
			return 1;
			
		case SOUTH_EAST :
			return 5;
			
		case SOUTH :
			return 2;
			
		case SOUTH_WEST :
			return 6;
			
		case WEST :
			return 3;
			
		case NORTH_WEST:
			return 7;
			
		default : return -1;
		}
	}
}
