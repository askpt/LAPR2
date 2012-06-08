package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.StyledEditorKit.ForegroundAction;

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
		jtp.addTab("Edition", jo);
		jtp.addTab("Country", co);
		jtp.addTab("Discipline", di);
		jtp.addTab("Sport", spo);
		jtp.addTab("Events", ev);
		jtp.addTab("Athlete",  at);

	}

	private void addPaineis() {

		// Panels
		jo = new Painel(img.bg3);
		co = new Painel(img.bg3);
		di = new Painel(img.bg3);
		spo = new Painel(img.bg3);
		at = new Painel(img.bg3);
		ev = new Painel(img.bg3);

		jo.setOpaque(false);
		co.setOpaque(false);
		di.setOpaque(false);
		spo.setOpaque(false);
		at.setOpaque(false);
		ev.setOpaque(false);
	}

	private void addEdition() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20,20,20,20));
		p1.setOpaque(false);
		jo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(20, 10, 0, 10));
		JLabel a = new JLabel("Olympic Games");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JLabel b = new JLabel("Year:  ");
		b.setForeground(Color.white);
		panel1.add(b, BorderLayout.WEST);
		JTextField txtAno = new JTextField(20);
		txtAno.setToolTipText("Year of the Olympic Games Edition.");
		panel1.add(txtAno, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel c = new JLabel("    City:  ");
		c.setForeground(Color.white);
		panel2.add(c,BorderLayout.WEST);
		JTextField txtCidade = new JTextField(20);
		txtCidade.setToolTipText("City of the Olympic Games Edition.");
		panel2.add(txtCidade, BorderLayout.CENTER);

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
		jo.add(p1);

	}

	private void addCountry() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20,20,20,20));
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
		panel1.add(b,BorderLayout.WEST);
		JTextField txtAno = new JTextField(20);
		txtAno.setToolTipText("Country's name.");
		panel1.add(txtAno, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel c = new JLabel("    Code:  ");
		c.setForeground(Color.white);
		panel2.add(c, BorderLayout.WEST);
		JTextField txtCidade = new JTextField(20);
		txtCidade.setToolTipText("Country's code.");
		panel2.add(txtCidade, BorderLayout.CENTER);

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
		co.add(p1);

	}

	private void addDiscipline() {
		di.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
		
		Painel panel = new Painel(img.bg4);
		panel.setLayout(new GridLayout(5,1));
		panel.setBorder(new EmptyBorder(20,20,20,20));
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
		p1.setBorder(new EmptyBorder(20,20,20,20));
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

	private void addEvent() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20,20,20,20));
		p1.setOpaque(false);
		ev.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Event");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JLabel b = new JLabel("Sport:  ");
		b.setForeground(Color.white);
		panel1.add(b, BorderLayout.WEST);
		JComboBox cmbDiscipline = new JComboBox();
		cmbDiscipline.setToolTipText("Event's name");
		panel1.add(cmbDiscipline, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);

		JLabel c = new JLabel("   Edition:  ");
		c.setForeground(Color.white);
		panel2.add(c,BorderLayout.WEST);
		JComboBox cmbEdition = new JComboBox();
		cmbEdition.setToolTipText("Edition whose this event belongs.");
		panel2.add(cmbEdition, BorderLayout.CENTER);

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
		ev.add(p1);
	}

	private void addAthlete() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20,20,20,20));
		p1.setOpaque(false);
		at.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Athlete");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JLabel b = new JLabel("Name:     ");
		b.setForeground(Color.white);
		panel1.add(b, BorderLayout.WEST);
		JTextField txtName = new JTextField(20);
		txtName.setToolTipText("Athlete's name");
		panel1.add(txtName, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel c = new JLabel("   Country:  ");
		c.setForeground(Color.white);
		panel2.add(c,BorderLayout.WEST);
		JComboBox cmbEdition = new JComboBox();
		cmbEdition.setToolTipText("Athlete's country.");
		panel2.add(cmbEdition, BorderLayout.CENTER);

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
}
