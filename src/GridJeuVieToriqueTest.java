import static org.junit.Assert.*;

import org.junit.Test;

public class GridJeuVieToriqueTest {

	@Test
	public void testNeighbors() {
		
		int k = 0;
		int i = 0;
		int j = 0;
		GridJeuVieTorique g = new GridJeuVieTorique("a", true);
		int rows = g.getRows();
		int colums = g.getColums();
		for (i = 0; i < rows; ++i) {
			for (j = 0; j < colums; ++j) {
				k=0;
				for (SquareGridNbh s : SquareGridNbh.values()) {
					if(g.getCell(i, j).getNeighbor(s).getState() == LifeState.DEAD
							|| g.getCell(i, j).getNeighbor(s).getState() == LifeState.ALIVE){
						k++;
					}
				}
				//si k != 8 on sait que les cellules n'ont pas 8 voisins != null
				if (k != 8) {
					fail("NOT ALL CELLS HAVE NEIGHBORS");
					//System.out.println(i + " & " + j);
				}
				
			}
			
		}
		if (i != rows && j != colums){
			fail("Colum size or rows counting failure");
		}
		g.update();
	}

}
