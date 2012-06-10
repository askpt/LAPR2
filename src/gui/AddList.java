package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import listaligada.ListaLigada;
import dados.Csv;

public class AddList extends JFrame {
	private Painel ca, co, di, spo, at, ev;

	private Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JTabbedPane jtp = new JTabbedPane();
	private int index = 1;
	private final int MAX = 4, MIN = 1;
	private Botao add1 = new Botao(img.add1);
	private Botao reduce1 = new Botao(img.remove1);
	private Botao getResults = new Botao(img.getResults);

	public AddList() {
		super("Add List");

		addPaineis();
		addTabs();
		addCA();

		setProperties(680, 520, 1, true);
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
		jtp.addTab("Comparative analysis", ca);
		jtp.addTab("Country", co);
		jtp.addTab("Discipline", di);
		jtp.addTab("Sport", spo);
		jtp.addTab("Events", ev);
		jtp.addTab("Athlete", at);

	}

	private void addPaineis() {

		// Panels
		ca = new Painel(img.bg3);
		co = new Painel(img.bg3);
		di = new Painel(img.bg3);
		spo = new Painel(img.bg3);
		at = new Painel(img.bg3);
		ev = new Painel(img.bg3);

		ca.setOpaque(false);
		co.setOpaque(false);
		di.setOpaque(false);
		spo.setOpaque(false);
		at.setOpaque(false);
		ev.setOpaque(false);
	}

	private void addCA() {

		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(10, 10, 10, 10));
		p1.setOpaque(false);
		ca.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

		final CardLayout cl = new CardLayout(10, 10);
		final JPanel card = new JPanel(cl);
		card.setOpaque(false);

		JPanel pTitulo = new JPanel();
		pTitulo.setOpaque(false);
		JLabel a = new JLabel("Choose 2 to 5 countries you want to compare");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		pTitulo.add(a);

		JPanel pButn = new JPanel();
		pButn.setOpaque(false);
		add1.setBotaoRollOver(img.add1_o);
		add1.setContentAreaFilled(false);
		add1.setBorderPainted(false);
		reduce1.setBotaoRollOver(img.remove1_o);
		reduce1.setBorderPainted(false);
		reduce1.setContentAreaFilled(false);
		getResults.setBotaoRollOver(img.getResults_o);
		getResults.setBorderPainted(false);
		getResults.setContentAreaFilled(false);
		pButn.add(add1);
		pButn.add(reduce1);
		pButn.add(getResults);

		// PARA 2 PAISES
		JPanel p1_1 = new JPanel(new BorderLayout());

		p1_1.setOpaque(false);
		p1_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country1_1 = new JLabel("Country 1:  ");
		country1_1.setForeground(Color.white);
		p1_1.add(country1_1, BorderLayout.WEST);
		JComboBox cmb1_1 = new JComboBox();
		cmb1_1.setToolTipText("1st Country.");
		p1_1.add(cmb1_1, BorderLayout.CENTER);

		JPanel p2_1 = new JPanel(new BorderLayout());
		p2_1.setOpaque(false);
		p2_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_1 = new JLabel("Country 2:  ");
		country2_1.setForeground(Color.white);
		p2_1.add(country2_1, BorderLayout.WEST);
		JComboBox cmb2_1 = new JComboBox();
		cmb2_1.setToolTipText("2nd Country");
		p2_1.add(cmb2_1, BorderLayout.CENTER);

		JPanel opcao1 = new JPanel(new GridLayout(2, 1, 0, 0));
		opcao1.setBorder(new EmptyBorder(90, 0, 90, 0));
		opcao1.setOpaque(false);
		opcao1.add(p1_1);
		opcao1.add(p2_1);

		// PARA 3 PAISES
		JPanel p1_2 = new JPanel(new BorderLayout());
		p1_2.setOpaque(false);
		p1_2.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country1_2 = new JLabel("Country 1:  ");
		country1_2.setForeground(Color.white);
		p1_2.add(country1_2, BorderLayout.WEST);
		JComboBox cmb1_2 = new JComboBox();
		cmb1_2.setToolTipText("1st Country.");
		p1_2.add(cmb1_2, BorderLayout.CENTER);

		JPanel p2_2 = new JPanel(new BorderLayout());
		p2_2.setOpaque(false);
		p2_2.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_2 = new JLabel("Country 2:  ");
		country2_2.setForeground(Color.white);
		p2_2.add(country2_2, BorderLayout.WEST);
		JComboBox cmb2_2 = new JComboBox();
		cmb2_2.setToolTipText("2nd Country");
		p2_2.add(cmb2_2, BorderLayout.CENTER);

		JPanel p3_2 = new JPanel(new BorderLayout());
		p3_2.setOpaque(false);
		p3_2.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country3_2 = new JLabel("Country 3:  ");
		country3_2.setForeground(Color.white);
		p3_2.add(country3_2, BorderLayout.WEST);
		JComboBox cmb3_2 = new JComboBox();
		cmb3_2.setToolTipText("3rd Country");
		p3_2.add(cmb3_2, BorderLayout.CENTER);

		JPanel opcao2 = new JPanel(new GridLayout(3, 1, 0, 0));
		opcao2.setOpaque(false);
		opcao2.setBorder(new EmptyBorder(70, 0, 70, 0));
		opcao2.add(p1_2);
		opcao2.add(p2_2);
		opcao2.add(p3_2);

		// PARA 4 PAISES
		JPanel p1_3 = new JPanel(new BorderLayout(0, 10));
		p1_3.setOpaque(false);
		p1_3.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country1_3 = new JLabel("Country 1:  ");
		country1_3.setForeground(Color.white);
		p1_3.add(country1_3, BorderLayout.WEST);
		JComboBox cmb1_3 = new JComboBox();
		cmb1_3.setToolTipText("1st Country.");
		p1_3.add(cmb1_3, BorderLayout.CENTER);

		JPanel p2_3 = new JPanel(new BorderLayout(0, 10));
		p2_3.setOpaque(false);
		p2_3.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_3 = new JLabel("Country 2:  ");
		country2_3.setForeground(Color.white);
		p2_3.add(country2_3, BorderLayout.WEST);
		JComboBox cmb2_3 = new JComboBox();
		cmb2_3.setToolTipText("2nd Country.");
		p2_3.add(cmb2_3, BorderLayout.CENTER);

		JPanel p3_3 = new JPanel(new BorderLayout());
		p3_3.setOpaque(false);
		p3_3.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country3_3 = new JLabel("Country 3:  ");
		country3_3.setForeground(Color.white);
		p3_3.add(country3_3, BorderLayout.WEST);
		JComboBox cmb3_3 = new JComboBox();
		cmb3_3.setToolTipText("3rd Country");
		p3_3.add(cmb3_3, BorderLayout.CENTER);

		JPanel p4_3 = new JPanel(new BorderLayout());
		p4_3.setOpaque(false);
		p4_3.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country4_3 = new JLabel("Country 4:  ");
		country4_3.setForeground(Color.white);
		p4_3.add(country4_3, BorderLayout.WEST);
		JComboBox cmb4_3 = new JComboBox();
		cmb4_3.setToolTipText("4th Country");
		p4_3.add(cmb4_3, BorderLayout.CENTER);

		JPanel opcao3 = new JPanel(new GridLayout(4, 1, 0, 0));
		opcao3.setOpaque(false);
		opcao3.setBorder(new EmptyBorder(60, 0, 60, 0));
		opcao3.add(p1_3);
		opcao3.add(p2_3);
		opcao3.add(p3_3);
		opcao3.add(p4_3);

		// PARA 5 PAISES
		JPanel p1_4 = new JPanel(new BorderLayout());
		p1_4.setOpaque(false);
		p1_4.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country1_4 = new JLabel("Country 1:  ");
		country1_4.setForeground(Color.white);
		p1_4.add(country1_4, BorderLayout.WEST);
		JComboBox cmb1_4 = new JComboBox();
		cmb1_4.setToolTipText("1st Country.");
		p1_4.add(cmb1_4, BorderLayout.CENTER);

		JPanel p2_4 = new JPanel(new BorderLayout());
		p2_4.setOpaque(false);
		p2_4.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_4 = new JLabel("Country 2:  ");
		country2_4.setForeground(Color.white);
		p2_4.add(country2_4, BorderLayout.WEST);
		JComboBox cmb2_4 = new JComboBox();
		cmb2_4.setToolTipText("2nd Country");
		p2_4.add(cmb2_4, BorderLayout.CENTER);

		JPanel p3_4 = new JPanel(new BorderLayout());
		p3_4.setOpaque(false);
		p3_4.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country3_4 = new JLabel("Country 3:  ");
		country3_4.setForeground(Color.white);
		p3_4.add(country3_4, BorderLayout.WEST);
		JComboBox cmb3_4 = new JComboBox();
		cmb3_3.setToolTipText("3rd Country");
		p3_4.add(cmb3_4, BorderLayout.CENTER);

		JPanel p4_4 = new JPanel(new BorderLayout());
		p4_4.setOpaque(false);
		p4_4.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country4_4 = new JLabel("Country 4:  ");
		country4_4.setForeground(Color.white);
		p4_4.add(country4_4, BorderLayout.WEST);
		JComboBox cmb4_4 = new JComboBox();
		cmb4_4.setToolTipText("4th Country");
		p4_4.add(cmb4_4, BorderLayout.CENTER);

		JPanel p5_4 = new JPanel(new BorderLayout());
		p5_4.setOpaque(false);
		p5_4.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country5_4 = new JLabel("Country 5:  ");
		country5_4.setForeground(Color.white);
		p5_4.add(country5_4, BorderLayout.WEST);
		JComboBox cmb5_4 = new JComboBox();
		cmb5_4.setToolTipText("5th Country");
		p5_4.add(cmb5_4, BorderLayout.CENTER);

		JPanel opcao4 = new JPanel(new GridLayout(5, 1, 0, 0));
		opcao4.setOpaque(false);
		opcao4.setBorder(new EmptyBorder(30, 0, 30, 0));
		opcao4.add(p1_4);
		opcao4.add(p2_4);
		opcao4.add(p3_4);
		opcao4.add(p4_4);
		opcao4.add(p5_4);

		// Tabela 1
		String[] col = { "Country", "# Participations", "# Disciplines played", "Medals(O,S,B)", "# Medals average" };
		Object[][] lin = { { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) }, { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) } };
		JPanel tabela1 = createTable(col, lin);

		// Tabela 2
		String[] col2 = { "Country", "# Participations", "# Disciplines played", "Medals(O,S,B)", "# Medals average" };
		Object[][] lin2 = { { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) }, { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) }, { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) } };
		JPanel tabela2 = createTable(col2, lin2);

		// Tabela 3
		String[] col3 = { "Country", "# Participations", "# Disciplines played", "Medals(O,S,B)", "# Medals average" };
		Object[][] lin3 = { { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) }, { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) }, { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) },
				{ "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) } };
		JPanel tabela3 = createTable(col3, lin3);

		// Tabela 4
		String[] col4 = { "Country", "# Participations", "# Disciplines played", "Medals(O,S,B)", "# Medals average" };
		Object[][] lin4 = { { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) }, { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) }, { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) },
				{ "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) }, { "Portugal", new Integer(5), new Integer(3), new Integer(1), new Integer(2), new Integer(3) } };
		JPanel tabela4 = createTable(col4, lin4);

		card.add(opcao1, "1");
		card.add(opcao2, "2");
		card.add(opcao3, "3");
		card.add(opcao4, "4");
		card.add(tabela1, "5");
		card.add(tabela2, "6");
		card.add(tabela3, "7");
		card.add(tabela4, "8");

		add1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < MAX) {
					index += 1;
					cl.show(card, "" + (index));
					if (index == MAX) {
						add1.setEnabled(false);
					}
					add1.setEnabled(true);
				}
			}
		});

		reduce1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > MIN) {
					index -= 1;
					cl.show(card, "" + (index));
					if (index == MIN) {
						reduce1.setEnabled(false);
					}
					reduce1.setEnabled(true);
				}
			}
		});

		getResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaLigada<Integer> a = new ListaLigada<Integer>();
				for (int i = 1; i < 6; i++) {
					a.add(i);
				}
				// GraficoLinhas b = new GraficoLinhas(a);
				// b.createAndShowGui(a);
				cl.show(card, "" + (index + 4));
			}
		});

		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		ca.add(p1);

	}

	private JPanel createTable(String[] colunas, Object[][] linhas) {
		JPanel pTabela = new JPanel(new FlowLayout());
		pTabela.setOpaque(false);
		final JTable table = new JTable(linhas, colunas);
		table.setFont(new Font("Arial", Font.PLAIN, 9));
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		pTabela.add(scrollPane);

		return pTabela;
	}

}