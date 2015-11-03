import javax.swing.Icon;
import javax.swing.ImageIcon;

public interface State {
	/**
	 * icône vide par défaut
	 */
	Icon DEFAULT_ICON = new ImageIcon();

	/**
	 * @return caractère représentant l'état
	 */
	default char toChar() { return '.'; }

	/**
	 * @return icône représentant l'état
	 */
	default Icon toIcon() { return DEFAULT_ICON; }
}
