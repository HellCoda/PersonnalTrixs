package WindowsMain;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class CustomSplitPaneDivider extends BasicSplitPaneDivider {

	public CustomSplitPaneDivider(BasicSplitPaneUI ui) {
		super(ui); // appelle le constructeur de la classe mère
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK); // spécifie la couleur de la bordure
		//g.fillRect(0, 0, getWidth(), getHeight()); // dessine la bordure avec la taille et la position du diviseur
		super.paint(g); // dessine les autres éléments du diviseur
	}
}
