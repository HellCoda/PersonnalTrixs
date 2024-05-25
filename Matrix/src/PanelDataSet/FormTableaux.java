package PanelDataSet;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import Donnes.ValeurInt;
import Donnes.ValeurDouble;
import Donnes.ValeurFloat;
import PanelTerminal.TerminalPanel;
import Structure.StructureFactory;
import Tableaux.ITableausimpleInt;
import Tableaux.TableauxDoubleDouble;
import Tableaux.TableauxDoubleFloat;
import Tableaux.TableauxDoubleInt;
import Tableaux.TableauxSimpleDouble;
import Tableaux.TableauxSimpleFloat;
import Tableaux.TableauxSimpleInt;
import WindowsMain.StyleMethode;

public class FormTableaux extends JFrame implements ActionListener {

	private JComboBox<String> comboBoxTableaux;
	private JComboBox<String> comboBoxType;
	private JComboBox<String> comboBoxEchelle;
	private JComboBox<String> comboBoxQuantite;
	private JButton btnAnnuler;
	private JButton btnGenerer;
	private TerminalPanel terminalPanel;

	public FormTableaux() {

		super();

		Content();
		Formulaire();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});

	}

	private void Content() {

		setTitle("Tableaux");
		setSize(275, 275);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 139, 139));

	}

	private void Formulaire() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Labels and ComboBoxes
		String[] tableauxOptions = { "Simple", "Double" };
		String[] typeOptions = { "Int", "Float", "Double" };
		String[] echelleOptions = { "0 - 10", "0 - 100", "0 - 1000", "0 - 10 000" };
		String[] quantiteOptions = { "10", "100", "1000", "10000", "100000" };

		comboBoxTableaux = new JComboBox<>(tableauxOptions);
		comboBoxType = new JComboBox<>(typeOptions);
		comboBoxEchelle = new JComboBox<>(echelleOptions);
		comboBoxQuantite = new JComboBox<>(quantiteOptions);

		addLabelAndComboBox("Tableaux :", comboBoxTableaux, gbc, 0);
		addLabelAndComboBox("Type :", comboBoxType, gbc, 1);
		addLabelAndComboBox("Echelle :", comboBoxEchelle, gbc, 2);
		addLabelAndComboBox("Quantité :", comboBoxQuantite, gbc, 3);

		StyleMethode.StyleComboBox(comboBoxTableaux);
		StyleMethode.StyleComboBox(comboBoxType);
		StyleMethode.StyleComboBox(comboBoxEchelle);
		StyleMethode.StyleComboBox(comboBoxQuantite);

		// Buttons
		btnAnnuler = new JButton("Annuler");
		btnGenerer = new JButton("Générer");

		btnAnnuler.addActionListener(this);
		btnGenerer.addActionListener(this);

		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(btnAnnuler, gbc);
		StyleMethode.StyleBouttonForm(btnAnnuler);

		gbc.gridx = 1;
		gbc.gridy = 4;
		add(btnGenerer, gbc);
		StyleMethode.StyleBouttonForm(btnGenerer);
	}

	private void addLabelAndComboBox(String labelText, JComboBox<String> comboBox, GridBagConstraints gbc, int yPos) {
		JLabel label = new JLabel(labelText);
		StyleMethode.StyleLabelForm(label);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = yPos;
		add(label, gbc);

		gbc.gridx = 1;
		gbc.gridy = yPos;
		add(comboBox, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object source = e.getSource();

		if (e.getSource() == btnGenerer) {
			GenererTableau();
		} else if (e.getSource() == btnAnnuler) {
			dispose();
		}

	}

	private void GenererTableau() {
		terminalPanel.area_central.setText(" >_");

		// Récupération des valeurs sélectionnées dans les JComboBox
		String typeTableau = (String) comboBoxTableaux.getSelectedItem();
		String typeDonnees = (String) comboBoxType.getSelectedItem();
		String echelle = (String) comboBoxEchelle.getSelectedItem();
		String quantite = (String) comboBoxQuantite.getSelectedItem();

		// Conversion des valeurs en paramètres numériques
		int taille = Integer.parseInt(quantite);
		int newtaille = taille / 2;
		int min = 0;
		int max = echelle.equals("0 - 10") ? 10
				: echelle.equals("0 - 100") ? 100 
				: echelle.equals("0 - 1000") ? 1000 
				: 10000;

		if (typeTableau.equals("Simple")) {

			if (typeDonnees.equals("Int")) {
				// Générer un tableau simple de type int
				genererTableauSimpleInt(taille, min, max);

			} else if (typeDonnees.equals("Float")) {
				// Générer un tableau simple de type float
				genererTableauSimpleFloat(taille, min, max);

			} else if (typeDonnees.equals("Double")) {
				// Générer un tableau simple de type double
				genererTableauSimpleDouble(taille, min, max);
			}
		} else if (typeTableau.equals("Double")) {

			if (typeDonnees.equals("Int")) {
				// Générer un tableau simple de type int
				genererTableauDoubleInt(newtaille, newtaille, min, max);

			} else if (typeDonnees.equals("Float")) {
				// Générer un tableau simple de type float
				genererTableauDoubleFloat(newtaille, newtaille, min, max);

			} else if (typeDonnees.equals("Double")) {
				// Générer un tableau simple de type double
				genererTableauDoubleDouble(newtaille, newtaille, min, max);
			}
		}
	}

	private void genererTableauSimpleInt(int taille, int min, int max) {

		terminalPanel.area_central.setText(" >_\n");

		TableauxSimpleInt tableauint = new TableauxSimpleInt(taille);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Tableau simple de type int généré :\n[");

		for (int i = 0; i < taille; i++) {

			int valeurAleatoire = random.nextInt(max - min + 1) + min;
			tableauint.ajouter(new ValeurInt(valeurAleatoire));
			sb.append(valeurAleatoire).append(i < taille - 1 ? ", " : "");
		}
		sb.append("]\n\n");
		terminalPanel.area_central.append(sb.toString());
	}
	

	private void genererTableauSimpleFloat(int taille, int min, int max) {

		terminalPanel.area_central.setText(" >_\n");

		TableauxSimpleFloat tableaufloat = new TableauxSimpleFloat(taille);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Tableau simple de type float généré :\n[");

		for (int i = 0; i < taille; i++) {

			float valeurAleatoire = min + random.nextFloat() * (max - min);
			tableaufloat.ajouter(valeurAleatoire);
			sb.append(valeurAleatoire).append(i < taille - 1 ? ", " : "");
		}
		sb.append("]\n\n");
		terminalPanel.area_central.append(sb.toString());
	}
	

	private void genererTableauSimpleDouble(int taille, int min, int max) {

		terminalPanel.area_central.setText(" >_\n");

		TableauxSimpleDouble tableaudouble = new TableauxSimpleDouble(taille);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Tableau simple de type double généré :\n[");

		for (int i = 0; i < taille; i++) {

			double valeurAleatoire = random.nextDouble(max - min + 1) + min;
			tableaudouble.ajouter(valeurAleatoire);
			sb.append(valeurAleatoire).append(i < taille - 1 ? ", " : "");
		}
		sb.append("]\n\n");
		terminalPanel.area_central.append(sb.toString());
	}
	

	private void genererTableauDoubleInt(int lignes, int colonnes, int min, int max) {

		terminalPanel.area_central.setText(" >_\n");

		TableauxDoubleInt tableaudoubleint = new TableauxDoubleInt(lignes, colonnes);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Tableau double de type int généré :\n");

		for (int i = 0; i < lignes; i++) {
			ValeurInt[] ligne = new ValeurInt[colonnes];
			sb.append("[");
			for (int j = 0; j < colonnes; j++) {
				int valeurAleatoire = random.nextInt(max - min + 1) + min;
				ligne[j] = new ValeurInt(valeurAleatoire);
				sb.append(valeurAleatoire).append(j < colonnes - 1 ? ", " : "");
			}
			sb.append("]");
			if (i < lignes - 1) {
				sb.append(",\n");
			}
			tableaudoubleint.ajouterLigne(ligne);
		}
		sb.append("\n\n");
		terminalPanel.area_central.append(sb.toString());
	}
	

	private void genererTableauDoubleFloat(int lignes, int colonnes, float min, float max) {
		terminalPanel.area_central.setText(">_\n");

		TableauxDoubleFloat tableauDoubleFloat = new TableauxDoubleFloat(lignes, colonnes);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Tableau double de type float généré :\n");

		for (int i = 0; i < lignes; i++) {
			ValeurFloat[] ligne = new ValeurFloat[colonnes];
			sb.append("[");
			for (int j = 0; j < colonnes; j++) {
				float valeurAleatoire = min + random.nextFloat() * (max - min);
				ligne[j] = new ValeurFloat(valeurAleatoire);
				sb.append(valeurAleatoire).append(j < colonnes - 1 ? ", " : "");
			}
			sb.append("]");
			if (i < lignes - 1) {
				sb.append(",\n");
			}
			tableauDoubleFloat.ajouterLigne(ligne);
		}
		sb.append("\n\n");
		terminalPanel.area_central.append(sb.toString());
	}
	

	private void genererTableauDoubleDouble(int lignes, int colonnes, double min, double max) {
		terminalPanel.area_central.setText(">_\n");

		TableauxDoubleDouble tableauDoubleDouble = new TableauxDoubleDouble(lignes, colonnes);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Tableau double de type Double généré :\n");

		for (int i = 0; i < lignes; i++) {
			ValeurDouble[] ligne = new ValeurDouble[colonnes];
			sb.append("[");
			for (int j = 0; j < colonnes; j++) {
				double valeurAleatoire = min + random.nextDouble() * (max - min);
				ligne[j] = new ValeurDouble(valeurAleatoire);
				sb.append(valeurAleatoire).append(j < colonnes - 1 ? ", " : "");
			}
			sb.append("]");
			if (i < lignes - 1) {
				sb.append(",\n");
			}
			tableauDoubleDouble.ajouterLigne(ligne);
		}
		sb.append("\n\n");
		terminalPanel.area_central.append(sb.toString());
	}

}
