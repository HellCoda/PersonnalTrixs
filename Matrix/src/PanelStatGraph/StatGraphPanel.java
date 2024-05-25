package PanelStatGraph;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import WindowsMain.StyleMethode;



public class StatGraphPanel extends JPanel {

	public JPanel panel_droit;
	public JPanel panelbarre_droit;
	public JLabel labelbarre_paneldroit;
	public JScrollPane scrollpanel_droit;

	
	public StatGraphPanel() {
		
		PanelDroit1();
	}
	
	public void PanelDroit1() {

		setLayout(new BorderLayout());
		panelbarre_droit = new JPanel();
		labelbarre_paneldroit = new JLabel("Stats & Graphs");

		setBackground(new Color(224, 0, 66));
		//panel_droit.setPreferredSize(new Dimension(240, 600));

		panelbarre_droit.setPreferredSize(new Dimension(240, 22));
		StyleMethode.StyleBarPanel(panelbarre_droit);
		StyleMethode.StyleBarLabel(labelbarre_paneldroit);

		panelbarre_droit.add(labelbarre_paneldroit);
		add(panelbarre_droit, BorderLayout.NORTH);
		
	}

}
