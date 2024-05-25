package PanelTerminal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import WindowsMain.StyleMethode;

public class TerminalPanel extends JPanel {

	public JPanel panel_central;
	public static JTextArea area_central = new JTextArea();
	public JPanel panelbarre_central;
	public JLabel labelbarre_panelcentral;
	public JScrollPane scrollpanel_central;

	
	
	public TerminalPanel() {

		PanelCentral1();
		
	}

	public void PanelCentral1() {

		setLayout(new BorderLayout());
		
		panelbarre_central = new JPanel();
		labelbarre_panelcentral = new JLabel("Terminal");
		scrollpanel_central = new JScrollPane(area_central);

		area_central.setBackground(new Color(21,16,16));
		area_central.setForeground(Color.GREEN);
		area_central.setFont(new Font("Calibri", Font.PLAIN, 16));
		scrollpanel_central.setViewportView(area_central);

		panelbarre_central.setPreferredSize(new Dimension(290, 22));
		StyleMethode.StyleBarPanel(panelbarre_central);
		StyleMethode.StyleBarLabel(labelbarre_panelcentral);
		StyleMethode.StyleScrollPane(scrollpanel_central);

		panelbarre_central.add(labelbarre_panelcentral);
		add(panelbarre_central, BorderLayout.NORTH);
		add(scrollpanel_central, BorderLayout.CENTER);

		area_central.setText(" >_ \n");

		
		
	}
	
}
