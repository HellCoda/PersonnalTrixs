package PanelDataSet;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Donnes.ValeurDouble;
import Donnes.ValeurFloat;
import Donnes.ValeurInt;
import Listes.ListDoubleDouble;
import Listes.ListDoubleFloat;
import Listes.ListDoubleInt;
import Listes.ListSimpleDouble;
import Listes.ListSimpleFloat;
import Listes.ListSimpleInt;
import PanelTerminal.TerminalPanel;
import Tableaux.TableauxSimpleInt;
import WindowsMain.StyleMethode;

public class FormList extends JFrame implements ActionListener {

	private JComboBox<String> comboBoxList;
	private JComboBox<String> comboBoxType;
	private JComboBox<String> comboBoxEchelle;
	private JComboBox<String> comboBoxQuantite;
	private JButton btnAnnuler;
	private JButton btnGenerer;
	private TerminalPanel terminalPanel;

	public FormList() {

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

		setTitle("List");
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
		String[] tableauxOptions = { "List simple", "List double" };
		String[] typeOptions = { "Int", "Float", "Double" };
		String[] echelleOptions = { "0 - 10", "0 - 100", "0 - 1000", "0 - 10 000" };
		String[] quantiteOptions = { "10", "100", "1000", "10000", "100000" };

		comboBoxList = new JComboBox<>(tableauxOptions);
		comboBoxType = new JComboBox<>(typeOptions);
		comboBoxEchelle = new JComboBox<>(echelleOptions);
		comboBoxQuantite = new JComboBox<>(quantiteOptions);

		addLabelAndComboBox("List :", comboBoxList, gbc, 0);
		addLabelAndComboBox("Type :", comboBoxType, gbc, 1);
		addLabelAndComboBox("Echelle :", comboBoxEchelle, gbc, 2);
		addLabelAndComboBox("Quantité :", comboBoxQuantite, gbc, 3);

		StyleMethode.StyleComboBox(comboBoxList);
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
			GenererListe();
		} else if (e.getSource() == btnAnnuler) {
			dispose();
		}
	}

	private void GenererListe() {

		terminalPanel.area_central.setText(" >_");

		// Récupération des valeurs sélectionnées dans les JComboBox
		String typeTableau = (String) comboBoxList.getSelectedItem();
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
				: echelle.equals("0 - 10000") ? 10000
				: 100000;

		if (typeTableau.equals("List simple")) {

			if (typeDonnees.equals("Int")) {
				genererListSimpleInt(taille, min, max);

			} else if (typeDonnees.equals("Float")) {
				genererListSimpleFloat(taille, min, max);

			} else if (typeDonnees.equals("Double")) {
				genererListSimpleDouble(taille, min, max);
			}
		} else if (typeTableau.equals("List double")) {

			if (typeDonnees.equals("Int")) {
				genererListDoubleInt(newtaille, newtaille, min, max);

			} else if (typeDonnees.equals("Float")) {
				genererListDoubleFloat(newtaille, newtaille, min, max);

			} else if (typeDonnees.equals("Double")) {
				genererListDoubleDouble(newtaille, newtaille, min, max);
			}
		}
	}

	private void genererListSimpleInt(int taille, int min, int max) {

		terminalPanel.area_central.setText(" >_\n");

		ListSimpleInt listint = new ListSimpleInt(taille);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Liste simple de type int générée :\n{ ");

		for (int i = 0; i < taille; i++) {
			int valeurAleatoire = random.nextInt(max - min + 1) + min;
			listint.ajouter(new ValeurInt(valeurAleatoire));
			sb.append(valeurAleatoire).append(i < taille - 1 ? "-> " : "");
		}
		sb.append(" }\n\n");
		terminalPanel.area_central.append(sb.toString());

	}

	private void genererListSimpleFloat(int taille, int min, int max) {

		terminalPanel.area_central.setText(" >_\n");

		ListSimpleFloat listfloat = new ListSimpleFloat(taille);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Liste simple de type float générée :\n{ ");

		for (int i = 0; i < taille; i++) {
			float valeurAleatoire = min + random.nextFloat() * (max - min);
			listfloat.ajouter(new ValeurFloat(valeurAleatoire));
			sb.append(valeurAleatoire).append(i < taille - 1 ? " -> " : "");
		}
		sb.append(" }\n\n");
		terminalPanel.area_central.append(sb.toString());

	}

	private void genererListSimpleDouble(int taille, int min, int max) {

		terminalPanel.area_central.setText(" >_\n");

		ListSimpleDouble listdouble = new ListSimpleDouble(taille);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Liste simple de type double générée :\n{ ");

		for (int i = 0; i < taille; i++) {
			Double valeurAleatoire = min + random.nextDouble() * (max - min);
			listdouble.ajouter(new ValeurDouble(valeurAleatoire));
			sb.append(valeurAleatoire).append(i < taille - 1 ? " -> " : "");
		}
		sb.append(" }\n\n");
		terminalPanel.area_central.append(sb.toString());

	}

	private void genererListDoubleInt(int lignes, int colonnes, int min, int max) {
		terminalPanel.area_central.setText(">_\n");

		ListDoubleInt listeDoubleInt = new ListDoubleInt(colonnes);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Liste de listes de type int générée :\n");

		for (int i = 0; i < lignes; i++) {
			List<ValeurInt> ligneListe = new ArrayList<>();
			sb.append("{");
			for (int j = 0; j < colonnes; j++) {
				int valeurAleatoire = random.nextInt(max - min + 1) + min;
				ligneListe.add(new ValeurInt(valeurAleatoire));
				sb.append(valeurAleatoire).append(j < colonnes - 1 ? " -> " : "");
			}
			sb.append("}");
			if (i < lignes - 1) {
				sb.append(",\n");
			}
			listeDoubleInt.ajouterLigne(ligneListe);
		}
		sb.append("\n\n");
		terminalPanel.area_central.append(sb.toString());
	}
	
	private void genererListDoubleFloat(int lignes, int colonnes, int min, int max) {
		terminalPanel.area_central.setText(">_\n");

		ListDoubleFloat listeDoubleFloat = new ListDoubleFloat(colonnes);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Liste de listes de type float générée :\n");

		for (int i = 0; i < lignes; i++) {
			List<ValeurFloat> ligneListe = new ArrayList<>();
			sb.append("{");
			for (int j = 0; j < colonnes; j++) {
				float valeurAleatoire = random.nextFloat(max - min + 1) + min;
				ligneListe.add(new ValeurFloat(valeurAleatoire));
				sb.append(valeurAleatoire).append(j < colonnes - 1 ? " -> " : "");
			}
			sb.append("}");
			if (i < lignes - 1) {
				sb.append(",\n");
			}
			listeDoubleFloat.ajouterLigne(ligneListe);
		}
		sb.append("\n\n");
		terminalPanel.area_central.append(sb.toString());
	}
	
	private void genererListDoubleDouble(int lignes, int colonnes, int min, int max) {
		terminalPanel.area_central.setText(">_\n");

		ListDoubleDouble listeDoubleDouble = new ListDoubleDouble(colonnes);
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		sb.append("Liste de listes de type double générée :\n");

		for (int i = 0; i < lignes; i++) {
			List<ValeurDouble> ligneListe = new ArrayList<>();
			sb.append("{");
			for (int j = 0; j < colonnes; j++) {
				double valeurAleatoire = random.nextDouble(max - min + 1) + min;
				ligneListe.add(new ValeurDouble(valeurAleatoire));
				sb.append(valeurAleatoire).append(j < colonnes - 1 ? " -> " : "");
			}
			sb.append("}");
			if (i < lignes - 1) {
				sb.append(",\n");
			}
			listeDoubleDouble.ajouterLigne(ligneListe);
		}
		sb.append("\n\n");
		terminalPanel.area_central.append(sb.toString());
	}

}
