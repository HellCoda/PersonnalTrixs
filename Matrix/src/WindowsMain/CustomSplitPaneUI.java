package WindowsMain;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class CustomSplitPaneUI extends BasicSplitPaneUI {

	@Override
	public BasicSplitPaneDivider createDefaultDivider() {
	return new CustomSplitPaneDivider(this); // utilise votre classe CustomSplitPaneDivider
	}

	
	public Dimension preferredLayoutSize(Container container) {
	return divider.getPreferredSize(); // renvoie la taille préférée du diviseur
	}
}
