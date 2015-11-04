
public class CellJeuVieTorique implements Cell<State, SquareGridNbh>{

	private State cellState;
	private CellJeuVieTorique[] neighbor;
	
	public CellJeuVieTorique(){
		cellState = LifeState.DEAD;
	}
	
	public State getState() {
		return cellState;
	}

	public void setState(State state) {
		cellState = state;		
	}

	public State nextState() {
		if (getState() == LifeState.DEAD)
			return LifeState.ALIVE;
		else
			return LifeState.DEAD;
	}

	public void setNeighbors(int direction, CellJeuVieTorique j){
		neighbor[direction] = j;
	}
	
	@Override
	public CellJeuVieTorique getNeighbor(SquareGridNbh direction) {
		//Clock rotation
		switch (direction){
				
		case NORTH :
			return neighbor[0];
			
		case NORTH_EAST :
			return neighbor[1];
			
		case EAST :
			return neighbor[2];
			
		case SOUTH_EAST :
			return neighbor[3];
			
		case SOUTH :
			return neighbor[4];
			
		case SOUTH_WEST :
			return neighbor[5];
			
		case WEST :
			return neighbor[6];
			
		case NORTH_WEST:
			return neighbor[7];
			
		default : return null;
		}
	}

}
