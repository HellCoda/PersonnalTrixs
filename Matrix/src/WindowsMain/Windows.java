package WindowsMain;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicSplitPaneDivider;

import MenuBar.MenubarPanel;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import PanelDataSet.DataSetPanel;
import PanelPerformances.PerformancesPanel;
import PanelStatGraph.StatGraphPanel;
import PanelTerminal.TerminalPanel;

public class Windows extends JFrame {
	
	private DataSetPanel panel_gauche;
	private TerminalPanel panel_central;
	private MenubarPanel menubar_1;
	private StatGraphPanel panel_droit;
	private PerformancesPanel panel_bas;
	
	public Windows(String titre) {

		super(titre);
		
		ContentFenetre1();
		MenuBar1();
		PanelGauche1();
		PanelCentral1();
		PanelDroit1();
		PanelBas1();
		PanelSplitPane();
		setVisible(true);
	}

	public void ContentFenetre1() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Programme de Tri");
		setSize(screenSize.width, screenSize.height);
		setLocation(0, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(true);
	}
	
	public void MenuBar1() {
		
		menubar_1 = new MenubarPanel();
		setJMenuBar(menubar_1.getMenuBar());
	}
	
	public void PanelGauche1() {
	
		panel_gauche = new DataSetPanel();
	
	}
	
	public void PanelCentral1() {
	
		panel_central = new TerminalPanel();
	}
	
	public void PanelDroit1() {
		
		panel_droit = new StatGraphPanel();
		
	}
	
	public void PanelBas1() {
	
		panel_bas = new PerformancesPanel();
	}
	
	public void PanelSplitPane() {

		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel_gauche, panel_central);
		BasicSplitPaneDivider divider1 = (BasicSplitPaneDivider) splitPane1.getComponent(2);
		divider1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
		splitPane1.setContinuousLayout(false);
		splitPane1.setOneTouchExpandable(true);
		splitPane1.setDividerLocation(270);

		JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, panel_bas);
		BasicSplitPaneDivider divider2 = (BasicSplitPaneDivider) splitPane2.getComponent(2);
		divider2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
		splitPane2.setOneTouchExpandable(true);
		splitPane2.setDividerLocation(480);

		JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane2, panel_droit);
		BasicSplitPaneDivider divider3 = (BasicSplitPaneDivider) splitPane3.getComponent(2);
		divider3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
		splitPane3.setOneTouchExpandable(true);
		splitPane3.setDividerLocation(1100);

		add(splitPane3, BorderLayout.CENTER);
	}

}
