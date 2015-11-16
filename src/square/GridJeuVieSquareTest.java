package square;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.Test;

import triangle.CellJeuVieTriangle;
import triangle.GridJeuVieTriangle;
import triangle.TriangularGridNbh;

public class GridJeuVieSquareTest {

	@Test
	public void testNeighbors() {
		
		int k = 0;
		int i = 0;
		int j = 0;
		GridJeuVieSquare g = new GridJeuVieSquare("a", true);
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
	
	@Test
	public void testTriangles() {
		
		int k = 0;
		int i = 0;
		int j = 0;
		GridJeuVieTriangle g = new GridJeuVieTriangle("a");
		int rows = g.getRows();
		int colums = g.getColums();
		System.out.println(g.stateAsString());
		g.update();
		System.out.println(g.stateAsString());
	}

	@Test
	public void testNull() {
		CellJeuVieSquare c = new CellJeuVieSquare(2);
		c.setNeighbors(SquareGridNbh.NORTH, c);
		if (!Objects.isNull(c.getNeighbor(SquareGridNbh.EAST))){
			fail("SHOULD BE NULL");
		}
		
	}
}
