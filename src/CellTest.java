import static org.junit.Assert.*;

import org.junit.Test;


public class CellTest {

	@Test
	public void set_get_Test() {
		CellJeuVieTorique c = new CellJeuVieTorique(8);
		char c1 = c.getState().toChar();
		if (c1 != '.')
			fail("LifeState.DEAD or constructor not working");
		c.setState(LifeState.ALIVE);
		c1 = c.getState().toChar();
		if (c1 != 'O')
			fail("Change of state or LifeState.Alive not working");
	}

}
