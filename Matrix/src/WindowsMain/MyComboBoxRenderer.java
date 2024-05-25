package WindowsMain;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

class MyComboBoxRenderer extends DefaultListCellRenderer {
	// Redéfinir la méthode getListCellRendererComponent
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	// Appeler la méthode de la classe parente
	super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	// Centrer le texte horizontalement
	setHorizontalAlignment(CENTER);
	setVerticalAlignment(CENTER);

	if (isSelected || cellHasFocus) {
		setForeground(Color.BLACK);
		} else {
		setForeground(Color.BLACK);
		}
	return this;
	}
	}
