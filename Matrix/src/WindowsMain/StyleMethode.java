package WindowsMain;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class StyleMethode {

	Windows labelbarre_panelgauche;

	public static void StyleMenuBar(JMenu menu) {

		Color colorbarre = new Color(48, 48, 48);
		menu.setOpaque(false);
		menu.setBackground(colorbarre);
		menu.setForeground(Color.WHITE);
		menu.setHorizontalAlignment(JLabel.CENTER);
		menu.setVerticalAlignment(JLabel.CENTER);
		menu.setFocusable(false);
		menu.setBorder(BorderFactory.createEmptyBorder());

	}

	public static void StyleMenuItem(JMenuItem item) {

		Color colorbarre = new Color(47, 47, 47);
		item.setOpaque(true);
		item.setBackground(colorbarre);
		item.setForeground(Color.WHITE);
		item.setHorizontalAlignment(JLabel.CENTER);
		item.setVerticalAlignment(JLabel.CENTER);
		item.setFocusable(false);
		// item.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	}

	public static void StyleBarPanel(JPanel panel) {

		Color colorbarre = new Color(81, 86, 88);
		panel.setBackground(colorbarre);
	}

	public static void StyleBarLabel(JLabel label) {

		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		Font font = new Font("Calibri", Font.BOLD, 14);
		label.setFont(font);
	}

	public static void StyleComboBox(JComboBox combobox) {

		combobox.setPreferredSize(new Dimension(100, 22));
		combobox.setMinimumSize(new Dimension(0, 0));
		combobox.setFocusable(false);
		combobox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		combobox.setFont(new Font("Calibri", Font.BOLD, 14));
		UIManager.put("ComboBox.selectionBackground", Color.GRAY);
		combobox.setRenderer(new MyComboBoxRenderer());
		combobox.setUI(new BasicComboBoxUI());
		combobox.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
		Component button = combobox.getComponent(0);
		button.setBackground(Color.BLACK);

	}

	public static void StyleLabelPanelGauche(JLabel label) {

		label.setPreferredSize(new Dimension(150, 22));
		label.setMinimumSize(new Dimension(0, 0));
		label.setFont(new Font("Calibri", Font.BOLD, 14));
		label.setForeground(Color.BLACK);

	}

	public static void StyleTextPanelGauche(JTextField text) {

		text.setPreferredSize(new Dimension(100, 22));
		text.setMinimumSize(new Dimension(0, 0));
		text.setFont(new Font("Calibri", Font.BOLD, 14));
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setForeground(Color.BLACK);
		text.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

	}

	public static void StyleBouttonPanelGauche(JButton bouton) {
		bouton.setFocusable(false);
		bouton.setPreferredSize(new Dimension(120, 24));
		bouton.setFont(new Font("Calibri", Font.BOLD, 14));
		bouton.setHorizontalAlignment(JButton.CENTER);
		bouton.setBackground(Color.DARK_GRAY);
		bouton.setForeground(Color.WHITE);
		bouton.repaint();

	}
	
	public static void StyleBouttonForm(JButton bouton) {
		bouton.setFocusable(false);
		bouton.setPreferredSize(new Dimension(90, 24));
		bouton.setFont(new Font("Calibri", Font.BOLD, 14));
		bouton.setHorizontalAlignment(JButton.CENTER);
		bouton.setBackground(Color.DARK_GRAY);
		bouton.setForeground(Color.WHITE);
		bouton.repaint();

	}
	
	public static void StyleLabelForm(JLabel label) {
		label.setFont(new Font("Calibri", Font.BOLD, 14));
		label.setForeground(Color.black);
		}

	public static void StyleScrollPane(JScrollPane scrollPane) {
		
		scrollPane.getViewport().setBackground(Color.black);
		
		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		verticalScrollBar.setPreferredSize(new Dimension(15, Integer.MAX_VALUE));
		verticalScrollBar.setBackground(Color.DARK_GRAY);
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.DARK_GRAY));

		JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
		horizontalScrollBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 15));
		horizontalScrollBar.setBackground(Color.DARK_GRAY);

		//scrollPane.repaint();
		
		scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, new Corner());
		scrollPane.setCorner(JScrollPane.LOWER_LEFT_CORNER, new Corner());
		scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, new Corner());
		scrollPane.setCorner(JScrollPane.LOWER_RIGHT_CORNER, new Corner());

		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scrollPane.repaint();
		}

	
}
