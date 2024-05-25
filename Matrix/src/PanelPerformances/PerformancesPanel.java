package PanelPerformances;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import WindowsMain.StyleMethode;


public class PerformancesPanel extends JPanel {

	public JPanel panel_bas;
	public JPanel panelbarre_bas;
	public JLabel labelbarre_panelbas;
	public JScrollPane scrollpanel_bas;
	
	public PerformancesPanel() {
		
		PanelBas1();
	}
	
	public void PanelBas1() {

		setLayout(new BorderLayout());
		panelbarre_bas = new JPanel();
		labelbarre_panelbas = new JLabel("Retour des performances");

		setBackground(new Color(255,215,0));
		//panel_bas.setPreferredSize(new Dimension(320, 180));

		panelbarre_bas.setPreferredSize(new Dimension(320, 22));
		StyleMethode.StyleBarPanel(panelbarre_bas);
		StyleMethode.StyleBarLabel(labelbarre_panelbas);

		panelbarre_bas.add(labelbarre_panelbas);
		add(panelbarre_bas, BorderLayout.NORTH);
		
	}
}
