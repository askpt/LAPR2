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
		registerResult();
		registerTeamResult();

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
		jtp.addTab("Add to team", at);
		jtp.addTab("Register result", rr);
		jtp.addTab("Register team's result", rtr);

	}

	private void addPaineis() {

		// Panels
		at = new Painel(img.bg3);
		rr = new Painel(img.bg3);
		rtr = new Painel(img.bg3);

		at.setOpaque(false);
		rr.setOpaque(false);
		rtr.setOpaque(false);
	}

	private void addToTeam() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20,20,20,20));
		p1.setOpaque(false);
		at.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Add athlete to this team");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JLabel b =  new JLabel("Name:  ");
		b.setForeground(Color.white);
		panel1.add(b, BorderLayout.WEST);
		JTextField txtName = new JTextField(20);
		txtName.setToolTipText("Athlete's name");
		panel1.add(txtName, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel2.setBorder(new EmptyBorder(10, 0, 0, 10));

		JLabel c = new JLabel("   Team:  ");
		c.setForeground(Color.white);
		panel2.add(c, BorderLayout.WEST);
		JComboBox cmbTeam = new JComboBox();
		cmbTeam.setToolTipText("team whom this athlete will belong.");
		panel2.add(cmbTeam, BorderLayout.CENTER);

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

		p1.add(panel1, BorderLayout.NORTH);
		p1.add(panel2, BorderLayout.CENTER);
		p1.add(panel3, BorderLayout.SOUTH);
		at.add(p1);
	}
	
	private void registerTeamResult() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20,20,20,20));
		p1.setOpaque(false);
		rtr.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Register individual result");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JLabel b =  new JLabel("Team:  ");
		b.setForeground(Color.white);
		panel1.add(b, BorderLayout.WEST);
		JComboBox cmbAt = new JComboBox();
		cmbAt.setToolTipText("Team's country");
		panel1.add(cmbAt, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		ButtonGroup btngrp = new ButtonGroup();
		JRadioButton rbDistancia = new JRadioButton("Distance", true);
		JRadioButton rbTempo = new JRadioButton("Time", false);
		JRadioButton rbPontos = new JRadioButton("Points", false);
		JRadioButton rbrank = new JRadioButton("Rank", false);

		rbDistancia.setOpaque(false);
		rbTempo.setOpaque(false);
		rbPontos.setOpaque(false);
		rbrank.setOpaque(false);
		rbDistancia.setForeground(Color.white);
		rbTempo.setForeground(Color.white);
		rbPontos.setForeground(Color.white);
		rbrank.setForeground(Color.white);

		btngrp.add(rbDistancia);
		btngrp.add(rbTempo);
		btngrp.add(rbPontos);
		btngrp.add(rbrank);

		panel2.add(rbDistancia);
		panel2.add(rbTempo);
		panel2.add(rbPontos);
		panel2.add(rbrank);

		JPanel panel4 = new JPanel();
		panel4.setOpaque(false);
		Botao ok = new Botao(img.ok);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		Botao clear = new Botao(img.clear);
		clear.setBorderPainted(false);
		clear.setContentAreaFilled(false);
		panel4.add(ok);
		panel4.add(clear);

		JPanel panel3 = new JPanel(new BorderLayout(0, 10));
		panel3.setOpaque(false);
		JLabel d =  new JLabel("Result:  ");
		d.setForeground(Color.white);
		panel3.add(d, BorderLayout.WEST);
		JTextField txtResult = new JTextField(20);
		txtResult.setToolTipText("Team's result");
		panel3.add(txtResult, BorderLayout.EAST);
		panel3.add(panel4, BorderLayout.SOUTH);

		p1.add(panel1, BorderLayout.NORTH);
		p1.add(panel2, BorderLayout.CENTER);
		p1.add(panel3, BorderLayout.SOUTH);
		rtr.add(p1);
	}

	private void registerResult() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20,20,20,20));
		p1.setOpaque(false);
		rr.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Register individual result");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JLabel b =  new JLabel("Athlete:  ");
		b.setForeground(Color.white);
		panel1.add(b, BorderLayout.WEST);
		JComboBox cmbAt = new JComboBox();
		cmbAt.setToolTipText("Athlete's name");
		panel1.add(cmbAt, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		ButtonGroup btngrp = new ButtonGroup();
		JRadioButton rbDistancia = new JRadioButton("Distance", true);
		JRadioButton rbTempo = new JRadioButton("Time", false);
		JRadioButton rbPontos = new JRadioButton("Points", false);
		JRadioButton rbrank = new JRadioButton("Rank", false);

		rbDistancia.setOpaque(false);
		rbTempo.setOpaque(false);
		rbPontos.setOpaque(false);
		rbrank.setOpaque(false);
		rbDistancia.setForeground(Color.white);
		rbTempo.setForeground(Color.white);
		rbPontos.setForeground(Color.white);
		rbrank.setForeground(Color.white);

		btngrp.add(rbDistancia);
		btngrp.add(rbTempo);
		btngrp.add(rbPontos);
		btngrp.add(rbrank);

		panel2.add(rbDistancia);
		panel2.add(rbTempo);
		panel2.add(rbPontos);
		panel2.add(rbrank);

		JPanel panel4 = new JPanel();
		panel4.setOpaque(false);
		Botao ok = new Botao(img.ok);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		Botao clear = new Botao(img.clear);
		clear.setBorderPainted(false);
		clear.setContentAreaFilled(false);
		panel4.add(ok);
		panel4.add(clear);

		JPanel panel3 = new JPanel(new BorderLayout(0, 10));
		panel3.setOpaque(false);
		JLabel d =  new JLabel("Result:  ");
		d.setForeground(Color.white);
		panel3.add(d, BorderLayout.WEST);
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
