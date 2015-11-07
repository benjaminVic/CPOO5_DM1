import static org.junit.Assert.*;

import org.junit.Test;

public class GridJeuVieToriqueTest {

	@Test
	public void testNeighbors() {
		int rows = 10;
		int colums = 10;
		int k = 0;
		int i = 0;
		int j = 0;
		GridJeuVieTorique g = new GridJeuVieTorique(rows, colums);
		for (i = 0; i < rows; ++i) {
			for (j = 0; j < colums; ++j) {
				k=0;
				for (SquareGridNbh s : SquareGridNbh.values()) {
					if(g.getCell(i, j).getNeighbor(s).getState() == LifeState.DEAD){
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
		if (i != 10 && j != 10){
			fail("Colum size or rows counting failure");
		}
		g.update();
	}

}
