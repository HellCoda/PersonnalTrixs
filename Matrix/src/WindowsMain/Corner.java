package WindowsMain;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

class Corner extends JComponent {
	protected void paintComponent(Graphics g) {
	g.setColor(Color.DARK_GRAY);
	g.fillRect(0, 0, getWidth(), getHeight());
	}

}