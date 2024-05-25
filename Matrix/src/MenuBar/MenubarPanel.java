package MenuBar;



import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import WindowsMain.StyleMethode;


public class MenubarPanel extends JPanel{

	public JPanel panel_menubar1;
	public JMenuBar menubar_1;
	public JMenu menu_1, menu_2, menu_3, menu_4, menu_5;
	public JMenuItem item_1, item_2, item_3, item_4, item_5;
	
	public MenubarPanel() {

		MenuBar1();
	}
	
	public void MenuBar1() {

		Color colorbarre = new Color(48, 48, 48);

		menubar_1 = new JMenuBar();
		menubar_1.setBackground(colorbarre);
		menubar_1.setBorder(BorderFactory.createEmptyBorder());

		menu_1 = new JMenu(" Menu 1   ");
		menu_2 = new JMenu(" Menu 2   ");
		menu_3 = new JMenu(" Menu 3   ");
		menu_4 = new JMenu(" Menu 4   ");
		menu_5 = new JMenu(" Menu 5   ");

		item_1 = new JMenuItem(" Item 1 ");
		item_2 = new JMenuItem(" Item 2 ");
		item_3 = new JMenuItem(" Item 3 ");
		item_4 = new JMenuItem(" Item 4 ");
		item_5 = new JMenuItem(" Item 5 ");

		menubar_1.add(menu_1);
		StyleMethode.StyleMenuBar(menu_1);
		menubar_1.add(menu_2);
		StyleMethode.StyleMenuBar(menu_2);
		menubar_1.add(menu_3);
		StyleMethode.StyleMenuBar(menu_3);
		menubar_1.add(menu_4);
		StyleMethode.StyleMenuBar(menu_4);
		menubar_1.add(menu_5);
		StyleMethode.StyleMenuBar(menu_5);

		menu_1.add(item_1);
		StyleMethode.StyleMenuItem(item_1);
		menu_2.add(item_2);
		StyleMethode.StyleMenuItem(item_2);
		menu_3.add(item_3);
		StyleMethode.StyleMenuItem(item_3);
		menu_4.add(item_4);
		StyleMethode.StyleMenuItem(item_4);
		menu_5.add(item_5);
		StyleMethode.StyleMenuItem(item_5);

		menubar_1.setPreferredSize(new Dimension(100, 25));

	}
	public JMenuBar getMenuBar() {
		return menubar_1;
		}

	
}
