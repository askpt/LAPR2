package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import dados.*;

public class AddDados extends JFrame {
	private Painel jo, co, di, spo, at, ev;

	private Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JTabbedPane jtp = new JTabbedPane();
	
	public AddDados() {
		super("Add Info");

		addPaineis();
		addTabs();
		addEdition();
		addCountry();
		addDiscipline();
		addSport();
		addEvent();
		addAthlete();

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
		jtp.addTab("Edition", new ImageIcon(img.mais), jo);
		jtp.addTab("Country", new ImageIcon(img.mais), co);
		jtp.addTab("Discipline", new ImageIcon(img.mais), di);
		jtp.addTab("Sport", new ImageIcon(img.mais), spo);
		jtp.addTab("Events", new ImageIcon(img.mais), ev);
		jtp.addTab("Athlete", new ImageIcon(img.mais), at);

	}

	private void addPaineis() {

		// Panels
		jo = new Painel(img.bg2);
		co = new Painel(img.bg2);
		di = new Painel(img.bg2);
		spo = new Painel(img.bg2);
		at = new Painel(img.bg2);
		ev = new Painel(img.bg2);

		jo.setOpaque(false);
		co.setOpaque(false);
		di.setOpaque(false);
		spo.setOpaque(false);
		at.setOpaque(false);
		ev.setOpaque(false);
	}

	private void addEdition() {
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.setBackground(new Color(158, 193, 213));
		jo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Olympic Games");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		panel1.add(new JLabel("Year:  "), BorderLayout.WEST);
		JTextField txtAno = new JTextField(20);
		txtAno.setToolTipText("Year of the Olympic Games Edition.");
		panel1.add(txtAno, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		panel2.add(new JLabel("   City:  "), BorderLayout.WEST);
		JTextField txtCidade = new JTextField(20);
		txtCidade.setToolTipText("City of the Olympic Games Edition.");
		panel2.add(txtCidade, BorderLayout.CENTER);

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
		jo.add(p1);

	}

	private void addCountry() {
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.setBackground(new Color(158, 193, 213));
		co.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Country");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		panel1.add(new JLabel("Name: "), BorderLayout.WEST);
		JTextField txtAno = new JTextField(20);
		txtAno.setToolTipText("Country's name.");
		panel1.add(txtAno, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		panel2.add(new JLabel("    Code:  "), BorderLayout.WEST);
		JTextField txtCidade = new JTextField(20);
		txtCidade.setToolTipText("Country's code.");
		panel2.add(txtCidade, BorderLayout.CENTER);

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
		co.add(p1);

	}

	private void addDiscipline() {
		di.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
		
		JPanel panel = new JPanel(new GridLayout(5,1));
		panel.setBackground(new Color(158, 193, 213));

		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Discipline");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		panel1.add(new JLabel("Name:  "),BorderLayout.WEST);
		final JTextField txtName = new JTextField(20);
		txtName.setToolTipText("Discipline's name");
		panel1.add(txtName, BorderLayout.CENTER);
		panel.add(panel1);
		
		JPanel panel6 = new JPanel(new BorderLayout());
		panel6.setBorder(new EmptyBorder(15, 10, 0, 10));
		panel6.setOpaque(false);
		panel6.add(new JLabel("  Sport:  "), BorderLayout.WEST);
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
		rbTempo.setOpaque(false);
		rbPontos.setOpaque(false);
		rbRank.setOpaque(false);

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
		rbF.setOpaque(false);
		rbMi.setOpaque(false);

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
		final Botao clear = new Botao(img.clear);
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
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.setBackground(new Color(158, 193, 213));
		spo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Sport");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		panel1.add(new JLabel(" Name:    "), BorderLayout.WEST);
		JTextField txtSpo = new JTextField(20);
		txtSpo.setToolTipText("Discipline whose this sport belongs");
		panel1.add(txtSpo, BorderLayout.CENTER);

		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		Botao ok = new Botao(img.ok);
		ok.setContentAreaFilled(false);
		Botao clear = new Botao(img.clear);
		clear.setContentAreaFilled(false);
		panel3.add(ok);
		panel3.add(clear);

		p1.add(panel1, BorderLayout.CENTER);
		p1.add(panel3, BorderLayout.SOUTH);
		spo.add(p1);
	}

	private void addEvent() {
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.setBackground(new Color(158, 193, 213));
		ev.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Event");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		panel1.add(new JLabel("Sport:     "), BorderLayout.WEST);
		JComboBox cmbDiscipline = new JComboBox();
		cmbDiscipline.setToolTipText("Event's name");
		panel1.add(cmbDiscipline, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		panel2.add(new JLabel("    Edition:  "), BorderLayout.WEST);
		JComboBox cmbEdition = new JComboBox();
		cmbEdition.setToolTipText("Edition whose this event belongs.");
		panel2.add(cmbEdition, BorderLayout.CENTER);

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
		ev.add(p1);
	}

	private void addAthlete() {
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.setBackground(new Color(158, 193, 213));
		at.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Athlete");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		panel1.add(new JLabel("Name:      "), BorderLayout.WEST);
		JTextField txtName = new JTextField(20);
		txtName.setToolTipText("Athlete's name");
		panel1.add(txtName, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		panel2.add(new JLabel("   Country:  "), BorderLayout.WEST);
		JComboBox cmbEdition = new JComboBox();
		cmbEdition.setToolTipText("Athlete's country.");
		panel2.add(cmbEdition, BorderLayout.CENTER);

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
}
