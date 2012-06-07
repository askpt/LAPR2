package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import dados.*;

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
		jtp.addTab("Edition", new ImageIcon(img.menos), jo);
		jtp.addTab("Country", new ImageIcon(img.menos), co);
		jtp.addTab("Discipline", new ImageIcon(img.menos), di);
		jtp.addTab("Sport", new ImageIcon(img.menos), spo);
		jtp.addTab("Athlete", new ImageIcon(img.menos), at);
		jtp.addTab("Events", new ImageIcon(img.menos), ev);

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
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.setBackground(new Color(158, 193, 213));
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		JPanel panel1 = new JPanel(new BorderLayout(0, 10));
		panel1.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		JLabel a = new JLabel(nome);
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		panel1.add(a, BorderLayout.NORTH);
		JComboBox b = new JComboBox();
		b.setToolTipText(tooltip);
		panel1.add(b, BorderLayout.CENTER);

		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		Botao ok = new Botao(img.ok);
		ok.setContentAreaFilled(false);
		Botao clear = new Botao(img.clear);
		clear.setContentAreaFilled(false);
		panel3.add(ok);
		panel3.add(clear);

		p1.add(panel1, BorderLayout.NORTH);
		p1.add(panel3, BorderLayout.SOUTH);
		p.add(p1);
	}

}
