package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import dados.*;

public class AddRegs extends JFrame {
	private Painel at, rr, rtr;

	private Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JTabbedPane jtp = new JTabbedPane();

	public AddRegs() {
		super("Register");

		addPaineis();
		addTabs();
		addToTeam();
		registResult();

		setProperties(600, 400, 1, true);
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
		jtp.addTab("Add to team", new ImageIcon(img.mais), at);
		jtp.addTab("Register result", new ImageIcon(img.mais), rr);
		jtp.addTab("Register team's result", new ImageIcon(img.mais), rtr);

	}

	private void addPaineis() {

		// Panels
		at = new Painel(img.bg2);
		rr = new Painel(img.bg2);
		rtr = new Painel(img.bg2);

		at.setOpaque(false);
		rr.setOpaque(false);
		rtr.setOpaque(false);
	}

	private void addToTeam() {
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.setBackground(new Color(158, 193, 213));
		at.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Add athlete to this team");
		a.setFont((new Font("Courier New", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		panel1.add(new JLabel("Name:  "), BorderLayout.WEST);
		JTextField txtName = new JTextField(20);
		txtName.setToolTipText("Athlete's name");
		panel1.add(txtName, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		panel2.add(new JLabel("  Team:  "), BorderLayout.WEST);
		JComboBox cmbTeam = new JComboBox();
		cmbTeam.setToolTipText("team whom this athlete will belong.");
		panel2.add(cmbTeam, BorderLayout.CENTER);

		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		Botao ok = new Botao(img.ok);
		ok.setContentAreaFilled(false);
		Botao clear = new Botao(img.clear);
		clear.setContentAreaFilled(false);
		panel3.add(ok);
		panel3.add(clear);

		p1.add(panel1, BorderLayout.NORTH);
		p1.add(panel2, BorderLayout.CENTER);
		p1.add(panel3, BorderLayout.SOUTH);
		at.add(p1);
	}

	private void registResult() {
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.setBackground(new Color(158, 193, 213));
		rr.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Register individual result");
		a.setFont((new Font("Courier New", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		panel1.add(new JLabel("Athlete:  "), BorderLayout.WEST);
		JComboBox cmbAt = new JComboBox();
		cmbAt.setToolTipText("Athlete's name");
		panel1.add(cmbAt, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		ButtonGroup btngrp = new ButtonGroup();
		JRadioButton rbDistancia = new JRadioButton("Distance", true);
		JRadioButton rbTempo = new JRadioButton("Time", false);
		JRadioButton rbPontos = new JRadioButton("Score", false);

		rbDistancia.setOpaque(false);
		rbTempo.setOpaque(false);
		rbPontos.setOpaque(false);

		btngrp.add(rbDistancia);
		btngrp.add(rbTempo);
		btngrp.add(rbPontos);

		panel2.add(rbDistancia);
		panel2.add(rbTempo);
		panel2.add(rbPontos);

		JPanel panel4 = new JPanel();
		panel4.setOpaque(false);
		Botao ok = new Botao(img.ok);
		ok.setContentAreaFilled(false);
		Botao clear = new Botao(img.clear);
		clear.setContentAreaFilled(false);
		panel4.add(ok);
		panel4.add(clear);

		JPanel panel3 = new JPanel(new BorderLayout(0, 10));
		panel3.setOpaque(false);
		// panel4.setOpaque(false);
		panel3.add(new JLabel("  Result:  "), BorderLayout.WEST);
		JTextField txtResult = new JTextField(20);
		txtResult.setToolTipText("Athlete's result");
		panel3.add(txtResult, BorderLayout.EAST);
		panel3.add(panel4, BorderLayout.SOUTH);

		p1.add(panel1, BorderLayout.NORTH);
		p1.add(panel2, BorderLayout.CENTER);
		p1.add(panel3, BorderLayout.SOUTH);
		rr.add(p1);
	}
}
