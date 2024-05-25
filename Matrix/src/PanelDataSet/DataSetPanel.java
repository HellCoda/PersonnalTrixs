package PanelDataSet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import Donnes.ValeurInt;
import PanelTerminal.TerminalPanel;
import Tableaux.TableauxSimpleInt;
import WindowsMain.StyleMethode;

public class DataSetPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public JPanel panel_gauche;
	public JPanel panelbarre_gauche;
	public JLabel labelbarre_panelgauche;
	public JScrollPane scrollpanel_gauche;
	public JPanel boutonPanel;

	JButton bouton_tableaux = new JButton("Tableaux");
	JButton bouton_list = new JButton("Listes");
	JButton bouton_piles = new JButton("Piles");
	JButton bouton_files = new JButton("Files");
	JButton bouton_objet = new JButton("Objets");
	JButton bouton_arbre = new JButton("Arbres");
	JButton bouton1 = new JButton("Feature 1");
	JButton bouton2 = new JButton("Feature 2");
	JButton bouton3 = new JButton("Feature 3");
	JButton bouton4 = new JButton("Feature 4");

	JButton bouton_compter = new JButton("Compter");
	JButton bouton_chercher = new JButton("Chercher");
	JButton bouton_ajouter = new JButton("Ajouter");
	JButton bouton_supprimer = new JButton("Supprimer");
	JButton bouton_remplacer = new JButton("Remplacer");
	JButton bouton_autres = new JButton("Autres...");
	JButton bouton5 = new JButton("Feature 1");
	JButton bouton6 = new JButton("Feature 2");
	JButton bouton7 = new JButton("Feature 3");
	JButton bouton8 = new JButton("Feature 4");

	FormTableaux FenetreTableaux;
	FormList FenetreList;
	FormPiles FenetrePiles;
	FormFiles FenetreFiles;
	FormObjet FenetreObjet;
	FormArbre FenetreArbre;

	TerminalPanel terminalPanel;
	TerminalPanel area_central;

	public DataSetPanel() {


		setLayout(new BorderLayout());
		PanelGauche1();
		BoutonPanelGauche();

		
		FenetreTableaux = new FormTableaux();
		FenetreTableaux.setVisible(false);

		FenetreList = new FormList();
		FenetreList.setVisible(false);

		FenetrePiles = new FormPiles();
		FenetrePiles.setVisible(false);

		FenetreFiles = new FormFiles();
		FenetreFiles.setVisible(false);

		FenetreObjet = new FormObjet();
		FenetreObjet.setVisible(false);

		FenetreArbre = new FormArbre();
		FenetreArbre.setVisible(false);

	}

	public void PanelGauche1() {

		panelbarre_gauche = new JPanel();
		labelbarre_panelgauche = new JLabel("Data Set");

		setBackground(new Color(0, 139, 139));
		// panel_gauche.setPreferredSize(new Dimension(2000, 1000)); // Commentez ou
		// supprimez cette ligne
		panelbarre_gauche.setPreferredSize(new Dimension(270, 22));

		StyleMethode.StyleBarPanel(panelbarre_gauche);
		StyleMethode.StyleBarLabel(labelbarre_panelgauche);

		panelbarre_gauche.add(labelbarre_panelgauche);
		add(panelbarre_gauche, BorderLayout.NORTH);

	}

	public void BoutonPanelGauche() {

		boutonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		boutonPanel.setBackground(new Color(0, 139, 139));

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0; // Colonne 0
		gbc.gridy = 0; // Ligne 0
		gbc.insets = new Insets(5, 5, 5, 5); // Marge externe
		boutonPanel.add(bouton_tableaux, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_tableaux);

		gbc.gridx = 1;
		gbc.gridy = 0;
		boutonPanel.add(bouton_list, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_list);

		gbc.gridx = 0;
		gbc.gridy = 1;
		boutonPanel.add(bouton_piles, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_piles);

		gbc.gridx = 1;
		gbc.gridy = 1;
		boutonPanel.add(bouton_files, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_files);

		gbc.gridx = 0;
		gbc.gridy = 2;
		boutonPanel.add(bouton_objet, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_objet);

		gbc.gridx = 1;
		gbc.gridy = 2;
		boutonPanel.add(bouton_arbre, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_arbre);

		gbc.gridx = 0;
		gbc.gridy = 3;
		boutonPanel.add(bouton1, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton1);

		gbc.gridx = 1;
		gbc.gridy = 3;
		boutonPanel.add(bouton2, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton2);

		gbc.gridx = 0;
		gbc.gridy = 4;
		boutonPanel.add(bouton3, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton3);

		gbc.gridx = 1;
		gbc.gridy = 4;
		boutonPanel.add(bouton4, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton4);

		JLabel separator = new JLabel();
		separator.setPreferredSize(new Dimension(boutonPanel.getWidth(), 3));
		separator.setOpaque(true);
		separator.setBackground(Color.DARK_GRAY);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 0, 20, 0);
		boutonPanel.add(separator, gbc);

		gbc.gridwidth = 1;

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.insets = new Insets(5, 5, 5, 5);
		boutonPanel.add(bouton_compter, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_compter);

		gbc.gridx = 1;
		gbc.gridy = 6;
		boutonPanel.add(bouton_chercher, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_chercher);

		gbc.gridx = 0;
		gbc.gridy = 7;
		boutonPanel.add(bouton_ajouter, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_ajouter);

		gbc.gridx = 1;
		gbc.gridy = 7;
		boutonPanel.add(bouton_supprimer, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_supprimer);

		gbc.gridx = 0;
		gbc.gridy = 8;
		boutonPanel.add(bouton_remplacer, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_remplacer);

		gbc.gridx = 1;
		gbc.gridy = 8;
		boutonPanel.add(bouton_autres, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton_autres);

		gbc.gridx = 0;
		gbc.gridy = 9;
		boutonPanel.add(bouton5, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton5);

		gbc.gridx = 1;
		gbc.gridy = 9;
		boutonPanel.add(bouton6, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton6);

		gbc.gridx = 0;
		gbc.gridy = 10;
		boutonPanel.add(bouton7, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton7);

		gbc.gridx = 1;
		gbc.gridy = 10;
		boutonPanel.add(bouton8, gbc);
		StyleMethode.StyleBouttonPanelGauche(bouton8);

		add(boutonPanel, BorderLayout.CENTER);

		bouton_tableaux.addActionListener((ActionListener) this);
		bouton_list.addActionListener((ActionListener) this);
		bouton_piles.addActionListener((ActionListener) this);
		bouton_files.addActionListener((ActionListener) this);
		bouton_objet.addActionListener((ActionListener) this);
		bouton_arbre.addActionListener((ActionListener) this);

	}

	private void WindowsTableaux() {

		FenetreTableaux.setVisible(true);
		TargetWindowsTableaux(FenetreTableaux);

	}

	private void TargetWindowsTableaux(FormTableaux FenetreTableaux) {

		int x = this.getX();
		int y = this.getY();
		int x2 = x + 0;
		int y2 = y + 55;
		FenetreTableaux.setLocation(x2, y2);
	}

	private void WindowsList() {

		FenetreList.setVisible(true);
		TargetWindowsList(FenetreList);

	}

	private void TargetWindowsList(FormList FenetreList) {

		int x = this.getX();
		int y = this.getY();
		int x2 = x + 0;
		int y2 = y + 55;
		FenetreList.setLocation(x2, y2);
	}

	private void WindowsPiles() {

		FenetrePiles.setVisible(true);
		TargetWindowsPiles(FenetrePiles);

	}

	private void TargetWindowsPiles(FormPiles FenetrePiles) {

		int x = this.getX();
		int y = this.getY();
		int x2 = x + 0;
		int y2 = y + 55;
		FenetrePiles.setLocation(x2, y2);
	}

	private void WindowsFiles() {

		FenetreFiles.setVisible(true);
		TargetWindowsFiles(FenetreFiles);

	}

	private void TargetWindowsFiles(FormFiles FenetreFiles) {

		int x = this.getX();
		int y = this.getY();
		int x2 = x + 0;
		int y2 = y + 55;
		FenetreFiles.setLocation(x2, y2);
	}

	private void WindowsObjet() {

		FenetreObjet.setVisible(true);
		TargetWindowsObjet(FenetreObjet);

	}

	private void TargetWindowsObjet(FormObjet FenetreObjet) {

		int x = this.getX();
		int y = this.getY();
		int x2 = x + 0;
		int y2 = y + 55;
		FenetreObjet.setLocation(x2, y2);
	}

	private void WindowsArbre() {

		FenetreArbre.setVisible(true);
		TargetWindowsObjet(FenetreArbre);

	}

	private void TargetWindowsObjet(FormArbre FenetreArbre) {

		int x = this.getX();
		int y = this.getY();
		int x2 = x + 0;
		int y2 = y + 55;
		FenetreArbre.setLocation(x2, y2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Gérer les actions des menus

		Object source = e.getSource();

		if (source == bouton_tableaux) {
			WindowsTableaux();

		} else if (source == bouton_list) {
			WindowsList();

		} else if (source == bouton_piles) {
			WindowsPiles();

		} else if (source == bouton_files) {
			WindowsFiles();

		} else if (source == bouton_objet) {
			WindowsObjet();

		} else if (source == bouton_arbre) {
			WindowsArbre();
		}

	}

}

