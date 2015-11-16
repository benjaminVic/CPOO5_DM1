package square;

import appli.State;

public enum LifeState implements State {
	DEAD {
		public char toChar() {
			return '.';
		}
	},
	ALIVE {
		public char toChar() {
			return 'O';
		}
	}
}
