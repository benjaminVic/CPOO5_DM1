
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

	@Override
	public LifeState nextState() {
		int aliveNeighbor = 0 ;
		for (CellJeuVieTorique cjvt : neighbor){
			if(cjvt.getState() == LifeState.ALIVE){
				aliveNeighbor++;
			}
		}
		if (cellState == LifeState.ALIVE && 
				(aliveNeighbor == 2 || aliveNeighbor == 3)){
			return LifeState.ALIVE;
		} else if (cellState == LifeState.DEAD &&
				aliveNeighbor == 3){
			return LifeState.ALIVE;
		}
		return LifeState.DEAD;
	}

	public void setNeighbors(SquareGridNbh direction, CellJeuVieTorique c){
		neighbor[neighborDirection(direction)] = c;
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
