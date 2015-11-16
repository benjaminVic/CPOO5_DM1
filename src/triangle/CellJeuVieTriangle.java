package triangle;
import java.util.Objects;

import square.LifeState;
import appli.Cell;
import appli.State;


public class CellJeuVieTriangle implements Cell<State, TriangularGridNbh>{

	private State cellState;
	private CellJeuVieTriangle[] neighbor;
	
	/**
	 * Cell Constructor
	 * @param sizeEnum : neighbors table size is always 3 here
	 */
	public CellJeuVieTriangle(int sizeEnum) {
		cellState = LifeState.DEAD;
		neighbor = new CellJeuVieTriangle[sizeEnum];
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
		this.cellState = state;
	}
	
	/**
	 * Give the reference to another cell
	 * @param direction : direction of the neighbor
	 * @param c : cell to which the neigbor is pointing
	 */
	public void setNeighbors(TriangularGridNbh direction, CellJeuVieTriangle c){
		neighbor[neighborDirection(direction)] = c;
	}

	public CellJeuVieTriangle getNeighbor(TriangularGridNbh direction) {
			return neighbor[neighborDirection(direction)];
	}

	@Override
	//Here we use 1 neighbor to keep alive
	//and 2 to revive and 0 || 3 to kill
	public LifeState nextState() {
		int aliveNeighbor = 0 ;
		for (CellJeuVieTriangle cjv : neighbor){
			if (Objects.nonNull(cjv)){
				if(cjv.getState() == LifeState.ALIVE){
					aliveNeighbor++;
				}
			}
		}
		if (cellState == LifeState.ALIVE && 
				(aliveNeighbor == 1 )){
			return LifeState.ALIVE;
		} else if (cellState == LifeState.DEAD &&
				aliveNeighbor == 2){
			return LifeState.ALIVE;
		}
		return LifeState.DEAD;
	}
	
	/**
	 * points in the array of neighbors
	 * @param direction : the direction from which the neighbor is needed
	 * @return : a pointer to the array of reference of neighbors
	 */
	public int neighborDirection(TriangularGridNbh direction){
		switch(direction){
		
		case LEFT :
			return 0;
			
		case RIGHT :
			return 1;
			
		case VERTICALITY : 
			return 2;
		
		default : return -1;
		}
	}

}
