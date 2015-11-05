
public class CellJeuVieTorique implements Cell<State, SquareGridNbh>{

	private State cellState;
	private CellJeuVieTorique[] neighbor;
	
	public CellJeuVieTorique(int sizeEnum){
		cellState = LifeState.DEAD;
		neighbor = new CellJeuVieTorique[sizeEnum];
	}
	
	public State getState() {
		return cellState;
	}

	public void setState(State state) {
		cellState = state;		
	}

	public State nextState() {
		if (cellState == LifeState.DEAD)
			return LifeState.ALIVE;
		else
			return LifeState.DEAD;
	}

	public void setNeighbors(SquareGridNbh direction, CellJeuVieTorique j){
		neighbor[neighborDirection(direction)] = j;
	}
	
	@Override
	public CellJeuVieTorique getNeighbor(SquareGridNbh direction) {
		return neighbor[neighborDirection(direction)];
		
	}
	
	public int neighborDirection(SquareGridNbh direction){
		switch (direction){
		
		case NORTH :
			return 0;
			
		case NORTH_EAST :
			return 1;
			
		case EAST :
			return 2;
			
		case SOUTH_EAST :
			return 3;
			
		case SOUTH :
			return 4;
			
		case SOUTH_WEST :
			return 5;
			
		case WEST :
			return 6;
			
		case NORTH_WEST:
			return 7;
			
		default : return -1;
		}
	}

}
