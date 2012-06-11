package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import jogosolimpicos.*;
import dados.*;

public class AddDados extends JFrame {
	private Painel co, di, spo;

	private Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JTabbedPane jtp = new JTabbedPane();

	public AddDados() {
		super("Add Info");

		addPaineis();
		addTabs();

		addCountry();
		addDiscipline();
		addSport();

		setProperties(600, 480, 1, true);
	}

	private void setProperties(int w, int h, int opcao, boolean visible) {
		setSize(w, h);
		setDefaultCloseOperation(opcao);
		setVisible(visible);
	}

	public void setSelectedIndex(int i) {
		jtp.setSelectedIndex(i);
	}

	private void addTabs() {

		getContentPane().add(jtp);
		// Tabs
		jtp.addTab("Country", co);
		jtp.addTab("Discipline", di);
		jtp.addTab("Sport", spo);

	}

	private void addPaineis() {

		// Panels
		co = new Painel(img.bg3);
		di = new Painel(img.bg3);
		spo = new Painel(img.bg3);

		co.setOpaque(false);
		di.setOpaque(false);
		spo.setOpaque(false);
	}

	private void addCountry() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		co.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Country");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JLabel b = new JLabel("Name: ");
		b.setForeground(Color.white);
		panel1.add(b, BorderLayout.WEST);
		final JTextField txtName = new JTextField(20);
		txtName.setToolTipText("Country's name.");
		panel1.add(txtName, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel c = new JLabel("    Code:  ");
		c.setForeground(Color.white);
		panel2.add(c, BorderLayout.WEST);
		final JTextField txtCode = new JTextField(20);
		txtCode.setToolTipText("Country's code.");
		panel2.add(txtCode, BorderLayout.CENTER);

		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		Botao ok = new Botao(img.ok);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		Botao clear = new Botao(img.clear);
		clear.setBorderPainted(false);
		clear.setContentAreaFilled(false);
		panel3.add(ok);
		panel3.add(clear);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.equals("")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure there are no empty fields!");
					txtName.requestFocus();
				} else if (txtCode.equals("")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure there are no empty fields!");
					txtCode.requestFocus();
				} else if (!txtCode.getText().matches("^[A-Z]{1,}$")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure the code field is formatted within the correct format!");
					txtCode.requestFocus();
				} else if (!txtName.getText().matches("^[A-Za-z]{1,}$")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure the name field is formatted within the correct format!");
					txtName.requestFocus();
				} else if (codeExists(txtCode.getText())) {
					JOptionPane.showMessageDialog(AddDados.this, "That code already exists!");
					txtCode.requestFocus();
				} else if (codeExists(txtName.getText())) {
					JOptionPane.showMessageDialog(AddDados.this, "That name already exists!");
					txtName.requestFocus();
				} else {
					Main.getPaises().add(new Pais(txtCode.getText(), txtName.getText()));
				}
			}
		});
		p1.add(panel1, BorderLayout.NORTH);
		p1.add(panel2, BorderLayout.CENTER);
		p1.add(panel3, BorderLayout.SOUTH);
		co.add(p1);

	}

	private void addDiscipline() {
		di.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		Painel panel = new Painel(img.bg4);
		panel.setLayout(new GridLayout(5, 1));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.setOpaque(false);

		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Discipline");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JLabel b = new JLabel("Name:  ");
		b.setForeground(Color.white);
		panel1.add(b, BorderLayout.WEST);
		final JTextField txtName = new JTextField(20);
		txtName.setToolTipText("Discipline's name");
		panel1.add(txtName, BorderLayout.CENTER);
		panel.add(panel1);

		JPanel panel6 = new JPanel(new BorderLayout());
		panel6.setBorder(new EmptyBorder(25, 2, 0, 10));
		panel6.setOpaque(false);
		JLabel c = new JLabel("  Sport:  ");
		c.setForeground(Color.white);
		panel6.add(c, BorderLayout.WEST);
		final JComboBox cmbDiscipline = new JComboBox();
		cmbDiscipline.setToolTipText("Discipline's Sport.");
		panel6.add(cmbDiscipline, BorderLayout.CENTER);
		panel.add(panel6);

		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setBorder(new EmptyBorder(10, 10, 0, 10));
		ButtonGroup btngrp = new ButtonGroup();
		JRadioButton rbDistancia = new JRadioButton("Distance", true);

		JRadioButton rbTempo = new JRadioButton("Time", false);
		JRadioButton rbPontos = new JRadioButton("Points", false);
		JRadioButton rbRank = new JRadioButton("Rank", false);

		rbDistancia.setOpaque(false);
		rbDistancia.setForeground(Color.white);
		rbTempo.setOpaque(false);
		rbTempo.setForeground(Color.white);
		rbPontos.setOpaque(false);
		rbPontos.setForeground(Color.white);
		rbRank.setOpaque(false);
		rbRank.setForeground(Color.white);

		btngrp.add(rbDistancia);
		btngrp.add(rbTempo);
		btngrp.add(rbPontos);
		btngrp.add(rbRank);

		panel2.add(rbDistancia);
		panel2.add(rbTempo);
		panel2.add(rbPontos);
		panel2.add(rbRank);
		panel.add(panel2);

		JPanel panel4 = new JPanel();
		panel4.setOpaque(false);
		ButtonGroup btngrp2 = new ButtonGroup();
		JRadioButton rbM = new JRadioButton("Male", true);
		JRadioButton rbF = new JRadioButton("Female", false);
		JRadioButton rbMi = new JRadioButton("Mixed", false);

		rbM.setOpaque(false);
		rbM.setForeground(Color.white);
		rbF.setOpaque(false);
		rbF.setForeground(Color.white);
		rbMi.setOpaque(false);
		rbMi.setForeground(Color.white);

		btngrp.add(rbM);
		btngrp.add(rbF);
		btngrp.add(rbMi);

		panel4.add(rbM);
		panel4.add(rbF);
		panel4.add(rbMi);
		panel.add(panel4);

		JPanel panel5 = new JPanel();
		panel5.setOpaque(false);
		Botao ok = new Botao(img.ok);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		Botao clear = new Botao(img.clear);
		clear.setBorderPainted(false);
		clear.setContentAreaFilled(false);
		panel5.add(ok);
		panel5.add(clear);

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
			}
		});

		panel.add(panel5);

		di.add(panel);
	}

	private void addSport() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		spo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Sport");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JLabel b = new JLabel("Name:    ");
		b.setForeground(Color.white);
		panel1.add(b, BorderLayout.WEST);
		JTextField txtSpo = new JTextField(20);
		txtSpo.setToolTipText("Discipline whose this sport belongs");
		panel1.add(txtSpo, BorderLayout.CENTER);

		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		Botao ok = new Botao(img.ok);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		Botao clear = new Botao(img.clear);
		clear.setBorderPainted(false);
		clear.setContentAreaFilled(false);
		panel3.add(ok);
		panel3.add(clear);

		p1.add(panel1, BorderLayout.CENTER);
		p1.add(panel3, BorderLayout.SOUTH);
		spo.add(p1);
	}

	private boolean codeExists(String code) {
		for (int i = 0; i < Main.getPaises().size(); i++) {
			if (Main.getPaises().get(i).getCodigoPais(0).equalsIgnoreCase(code))
				return true;
		}
		return false;
	}

	private boolean nameExists(String name) {
		for (int i = 0; i < Main.getPaises().size(); i++) {
			if (Main.getPaises().get(i).getNomePais().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

}
