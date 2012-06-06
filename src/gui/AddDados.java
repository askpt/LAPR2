package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import dados.*;

public class AddDados extends JFrame {
	private Painel jo, co, di, spo, at;

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
		jtp.addTab("Athlete", new ImageIcon(img.mais), at);

	}

	private void addPaineis() {

		// Panels
		jo = new Painel(img.bg2);
		co = new Painel(img.bg2);
		di = new Painel(img.bg2);
		spo = new Painel(img.bg2);
		at = new Painel(img.bg2);

		jo.setOpaque(false);
		co.setOpaque(false);
		di.setOpaque(false);
		spo.setOpaque(false);
		at.setOpaque(false);
	}

	private void addEdition() {
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.setBackground(new Color(158, 193, 213));
		jo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel("Olympic Games");
		a.setFont((new Font("Courier New", Font.BOLD, 14)));
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
		a.setFont((new Font("Courier New", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		panel1.add(new JLabel("Name: "), BorderLayout.WEST);
		JTextField txtAno = new JTextField(20);
		txtAno.setToolTipText("Country's name.");
		panel1.add(txtAno, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		panel2.add(new JLabel("  Code:  "), BorderLayout.WEST);
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
}
