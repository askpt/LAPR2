package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dados.Csv;

public class RemDados extends JFrame {
	private Painel jo, co, di, spo, at, ev;

	private Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JTabbedPane jtp = new JTabbedPane();

	public RemDados() {
		super("Remove Info");

		addPaineis();
		addTabs();
		remEdition();
		remCountry();
		remDiscipline();
		remSport();
		remEvent();
		remAthlete();

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
		jtp.addTab("Edition", new ImageIcon(), jo);
		jtp.addTab("Country", new ImageIcon(), co);
		jtp.addTab("Discipline", new ImageIcon(), di);
		jtp.addTab("Sport", new ImageIcon(), spo);
		jtp.addTab("Athlete", new ImageIcon(), at);
		jtp.addTab("Events", new ImageIcon(), ev);

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

	private void remEdition() {

		String nome = "Olympic Games";
		String tooltip = "Year of the Olympic Games Edition you want to remove.";
		remove(nome, tooltip, jo);
	}

	private void remCountry() {
		String nome = "Country";
		String tooltip = "Country you want to remove.";
		remove(nome, tooltip, co);
	}

	private void remDiscipline() {
		String nome = "Discipline";
		String tooltip = "Discipline you want to remove.";
		remove(nome, tooltip, di);
	}

	private void remSport() {
		String nome = "Sport";
		String tooltip = "Sport you want to remove.";
		remove(nome, tooltip, spo);
	}

	private void remAthlete() {
		String nome = "Athlete";
		String tooltip = "Athlete you want to remove.";
		remove(nome, tooltip, at);
	}

	private void remEvent() {
		String nome = "Event";
		String tooltip = "Event you want to remove.";
		remove(nome, tooltip, ev);
	}

	private void remove(String nome, String tooltip, Painel p) {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel(nome);
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		panel1.add(a, BorderLayout.NORTH);
		JComboBox b = new JComboBox();
		b.setToolTipText(tooltip);
		panel1.add(b, BorderLayout.CENTER);

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
		p1.add(panel3, BorderLayout.SOUTH);
		p.add(p1);
	}

}
