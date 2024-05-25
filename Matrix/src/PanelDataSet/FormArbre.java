package PanelDataSet;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import WindowsMain.StyleMethode;

public class FormArbre extends JFrame implements ActionListener {

	private JComboBox<String> comboBoxArbre;
	private JComboBox<String> comboBoxType;
	private JComboBox<String> comboBoxEchelle;
	private JComboBox<String> comboBoxQuantite;
	private JButton btnAnnuler;
	private JButton btnGenerer;

	public FormArbre() {

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

		setTitle("Objets");
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
		String[] tableauxOptions = { "Arbre", "..." };
		String[] typeOptions = { "Int", "Float", "Double" };
		String[] echelleOptions = { "0 - 10", "0 - 100", "0 - 1000", "0 - 10 000" };
		String[] quantiteOptions = { "10", "100", "1000", "10 000", "100 000" };

		comboBoxArbre = new JComboBox<>(tableauxOptions);
		comboBoxType = new JComboBox<>(typeOptions);
		comboBoxEchelle = new JComboBox<>(echelleOptions);
		comboBoxQuantite = new JComboBox<>(quantiteOptions);

		addLabelAndComboBox("Arbre :", comboBoxArbre, gbc, 0);
		addLabelAndComboBox("Type :", comboBoxType, gbc, 1);
		addLabelAndComboBox("Echelle :", comboBoxEchelle, gbc, 2);
		addLabelAndComboBox("Quantité :", comboBoxQuantite, gbc, 3);
		
		
		StyleMethode.StyleComboBox(comboBoxArbre);
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

	}

}
