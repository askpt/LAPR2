package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import jogosolimpicos.*;
import listaligada.*;
import dados.*;

public class AddList extends JFrame {
	private Painel ca, nr, ar, rd, me;

	private Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JTabbedPane jtp = new JTabbedPane();
	private int index = 1;
	private final int MAX = 4, MIN = 1;
	private Botao add1 = new Botao(img.add1);
	private Botao reduce1 = new Botao(img.remove1);
	private Botao getResults = new Botao(img.getResults);
	private CardLayout cl = new CardLayout(10, 10);
	private CardLayout cl1 = new CardLayout(10, 10);
	private CardLayout cl2 = new CardLayout(10, 10);
	private CardLayout cl3 = new CardLayout(10, 10);
	private CardLayout cl4 = new CardLayout(10, 10);
	private JPanel card = new JPanel(cl);
	private JPanel card1 = new JPanel(cl1);
	private JPanel card2 = new JPanel(cl2);
	private JPanel card3 = new JPanel(cl3);
	private JPanel card4 = new JPanel(cl4);

	public AddList() {
		super("Statistics & Listings");

		addPaineis();
		addTabs();
		addCA();
		addHistoricoPaises();
		addHistoricoAtletas();
		addHistoricoDiscipline();
		addHistoricoSport();

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
		jtp.addTab("Ranking (Nation)", nr);
		jtp.addTab("Ranking (Athlete)", ar);
		jtp.addTab("Ranking (Discipline)", rd);
		jtp.addTab("Ranking (Sport)", me);

	}

	private void addPaineis() {

		// Panels
		ca = new Painel(img.bg3);
		nr = new Painel(img.bg3);
		ar = new Painel(img.bg3);
		rd = new Painel(img.bg3);
		me = new Painel(img.bg3);

		ca.setOpaque(false);
		nr.setOpaque(false);
		ar.setOpaque(false);
		rd.setOpaque(false);
		me.setOpaque(false);
	}

	private void addCA() {

		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(10, 10, 10, 10));
		p1.setOpaque(false);
		ca.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

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
		final Botao voltar = new Botao(img.back, img.back_o);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		voltar.setVisible(false);
		reduce1.setVisible(false);
		pButn.add(add1);
		pButn.add(reduce1);
		pButn.add(getResults);
		pButn.add(voltar);

		// PARA 2 PAISES
		JPanel p1_1 = new JPanel(new BorderLayout());

		p1_1.setOpaque(false);
		p1_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country1_1 = new JLabel("Country 1:  ");
		country1_1.setForeground(Color.white);
		p1_1.add(country1_1, BorderLayout.WEST);
		final JComboBox<Object> cmb1_1 = new JComboBox<Object>(Main.getPaises().toArray());
		cmb1_1.setToolTipText("1st Country.");
		p1_1.add(cmb1_1, BorderLayout.CENTER);

		JPanel p2_1 = new JPanel(new BorderLayout());
		p2_1.setOpaque(false);
		p2_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_1 = new JLabel("Country 2:  ");
		country2_1.setForeground(Color.white);
		p2_1.add(country2_1, BorderLayout.WEST);
		final JComboBox<Object> cmb2_1 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb2_1.setSelectedIndex(1);
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
		final JComboBox<Object> cmb1_2 = new JComboBox<Object>(Main.getPaises().toArray());
		cmb1_2.setToolTipText("1st Country.");
		p1_2.add(cmb1_2, BorderLayout.CENTER);

		JPanel p2_2 = new JPanel(new BorderLayout());
		p2_2.setOpaque(false);
		p2_2.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_2 = new JLabel("Country 2:  ");
		country2_2.setForeground(Color.white);
		p2_2.add(country2_2, BorderLayout.WEST);
		final JComboBox<Object> cmb2_2 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb2_2.setSelectedIndex(1);
		cmb2_2.setToolTipText("2nd Country");
		p2_2.add(cmb2_2, BorderLayout.CENTER);

		JPanel p3_2 = new JPanel(new BorderLayout());
		p3_2.setOpaque(false);
		p3_2.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country3_2 = new JLabel("Country 3:  ");
		country3_2.setForeground(Color.white);
		p3_2.add(country3_2, BorderLayout.WEST);
		final JComboBox<Object> cmb3_2 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb3_2.setSelectedIndex(2);
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
		final JComboBox<Object> cmb1_3 = new JComboBox<Object>(Main.getPaises().toArray());
		cmb1_3.setToolTipText("1st Country.");
		p1_3.add(cmb1_3, BorderLayout.CENTER);

		JPanel p2_3 = new JPanel(new BorderLayout(0, 10));
		p2_3.setOpaque(false);
		p2_3.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_3 = new JLabel("Country 2:  ");
		country2_3.setForeground(Color.white);
		p2_3.add(country2_3, BorderLayout.WEST);
		final JComboBox<Object> cmb2_3 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb2_3.setSelectedIndex(1);
		cmb2_3.setToolTipText("2nd Country.");
		p2_3.add(cmb2_3, BorderLayout.CENTER);

		JPanel p3_3 = new JPanel(new BorderLayout());
		p3_3.setOpaque(false);
		p3_3.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country3_3 = new JLabel("Country 3:  ");
		country3_3.setForeground(Color.white);
		p3_3.add(country3_3, BorderLayout.WEST);
		final JComboBox<Object> cmb3_3 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb3_3.setSelectedIndex(2);
		cmb3_3.setToolTipText("3rd Country");
		p3_3.add(cmb3_3, BorderLayout.CENTER);

		JPanel p4_3 = new JPanel(new BorderLayout());
		p4_3.setOpaque(false);
		p4_3.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country4_3 = new JLabel("Country 4:  ");
		country4_3.setForeground(Color.white);
		p4_3.add(country4_3, BorderLayout.WEST);
		final JComboBox<Object> cmb4_3 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb4_3.setSelectedIndex(3);
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
		final JComboBox<Object> cmb1_4 = new JComboBox<Object>(Main.getPaises().toArray());
		cmb1_4.setToolTipText("1st Country.");
		p1_4.add(cmb1_4, BorderLayout.CENTER);

		JPanel p2_4 = new JPanel(new BorderLayout());
		p2_4.setOpaque(false);
		p2_4.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_4 = new JLabel("Country 2:  ");
		country2_4.setForeground(Color.white);
		p2_4.add(country2_4, BorderLayout.WEST);
		final JComboBox<Object> cmb2_4 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb2_4.setSelectedIndex(1);
		cmb2_4.setToolTipText("2nd Country");
		p2_4.add(cmb2_4, BorderLayout.CENTER);

		JPanel p3_4 = new JPanel(new BorderLayout());
		p3_4.setOpaque(false);
		p3_4.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country3_4 = new JLabel("Country 3:  ");
		country3_4.setForeground(Color.white);
		p3_4.add(country3_4, BorderLayout.WEST);
		final JComboBox<Object> cmb3_4 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb3_4.setSelectedIndex(2);
		cmb3_3.setToolTipText("3rd Country");
		p3_4.add(cmb3_4, BorderLayout.CENTER);

		JPanel p4_4 = new JPanel(new BorderLayout());
		p4_4.setOpaque(false);
		p4_4.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country4_4 = new JLabel("Country 4:  ");
		country4_4.setForeground(Color.white);
		p4_4.add(country4_4, BorderLayout.WEST);
		final JComboBox<Object> cmb4_4 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb4_4.setSelectedIndex(3);
		cmb4_4.setToolTipText("4th Country");
		p4_4.add(cmb4_4, BorderLayout.CENTER);

		JPanel p5_4 = new JPanel(new BorderLayout());
		p5_4.setOpaque(false);
		p5_4.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country5_4 = new JLabel("Country 5:  ");
		country5_4.setForeground(Color.white);
		p5_4.add(country5_4, BorderLayout.WEST);
		final JComboBox<Object> cmb5_4 = new JComboBox<Object>(Main.getPaises().toArray());
		if (!isEmptyPaises())
			cmb5_4.setSelectedIndex(4);
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

		card.add(opcao1, "1");
		card.add(opcao2, "2");
		card.add(opcao3, "3");
		card.add(opcao4, "4");

		add1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < MAX) {
					index += 1;
					cl.show(card, "" + (index));
					if (index == 2) {
						cmb1_2.setSelectedIndex(cmb1_1.getSelectedIndex());
						cmb2_2.setSelectedIndex(cmb2_1.getSelectedIndex());
					} else if (index == 3) {
						cmb1_3.setSelectedIndex(cmb1_2.getSelectedIndex());
						cmb2_3.setSelectedIndex(cmb2_2.getSelectedIndex());
						cmb3_3.setSelectedIndex(cmb3_2.getSelectedIndex());
					} else if (index == 4) {
						cmb1_4.setSelectedIndex(cmb1_3.getSelectedIndex());
						cmb2_4.setSelectedIndex(cmb2_3.getSelectedIndex());
						cmb3_4.setSelectedIndex(cmb3_3.getSelectedIndex());
						cmb4_4.setSelectedIndex(cmb4_3.getSelectedIndex());
					}
					if (index == MAX) {
						add1.setVisible(false);
						reduce1.setVisible(true);
					} else {
						add1.setVisible(true);
					}
				}
			}
		});

		reduce1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > MIN) {
					index -= 1;
					cl.show(card, "" + (index));
					if (index == MIN) {
						reduce1.setVisible(false);
						add1.setVisible(true);
					} else {
						reduce1.setVisible(true);
					}
				}
			}
		});

		getResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaLigada<Integer> a = new ListaLigada<Integer>();
				for (int i = 1; i < 6; i++) {
					a.add(i);
				}
				add1.setVisible(false);
				reduce1.setVisible(false);
				voltar.setVisible(true);
				getResults.setVisible(false);
				// GraficoLinhas b = new GraficoLinhas(a);
				// b.createAndShowGui(a);

				if (index + 4 == 5) {
					if (cmb2_1.getSelectedItem() == null || cmb1_2.getSelectedItem() == null) {
						JOptionPane.showMessageDialog(null, "Choose the desired countries!");
					} else if (cmb2_1.getSelectedItem() == cmb1_2.getSelectedItem()) {
						JOptionPane.showMessageDialog(null, "Repeated countries!");
					} else {
						Pais pais = (Pais) cmb1_1.getSelectedItem();
						int index1 = findPais(pais.getNomePais());
						pais = (Pais) cmb2_1.getSelectedItem();
						int index2 = findPais(pais.getNomePais());
						int[] i = { index1, index2 };
						JPanel tabela1 = createTable(i);
						card.add(tabela1, "5");
						cl.show(card, "5");
					}
				} else if (index + 4 == 6) {
					if ((cmb1_2.getSelectedItem() == cmb2_2.getSelectedItem()) || (cmb1_2.getSelectedItem() == cmb3_2.getSelectedItem()) || (cmb2_2.getSelectedItem() == cmb3_2.getSelectedItem())) {
						JOptionPane.showMessageDialog(null, "Repeated countries!");
					} else {
						Pais pais = (Pais) cmb1_2.getSelectedItem();
						int index1 = findPais(pais.getNomePais());
						pais = (Pais) cmb2_2.getSelectedItem();
						int index2 = findPais(pais.getNomePais());
						pais = (Pais) cmb3_2.getSelectedItem();
						int index3 = findPais(pais.getNomePais());
						int[] i = { index1, index2, index3 };
						JPanel tabela2 = createTable(i);
						card.add(tabela2, "6");
						cl.show(card, "6");
					}
				} else if (index + 4 == 7) {
					if ((cmb1_3.getSelectedItem() == cmb2_3.getSelectedItem()) || (cmb1_3.getSelectedItem() == cmb3_3.getSelectedItem()) || (cmb1_3.getSelectedItem() == cmb4_3.getSelectedItem()) || (cmb2_3.getSelectedItem() == cmb3_3.getSelectedItem()) || (cmb2_3.getSelectedItem() == cmb4_3.getSelectedItem())) {
						JOptionPane.showMessageDialog(null, "Repeated countries!");
					} else {
						Pais pais = (Pais) cmb1_3.getSelectedItem();
						int index1 = findPais(pais.getNomePais());
						pais = (Pais) cmb2_3.getSelectedItem();
						int index2 = findPais(pais.getNomePais());
						pais = (Pais) cmb3_3.getSelectedItem();
						int index3 = findPais(pais.getNomePais());
						pais = (Pais) cmb4_3.getSelectedItem();
						int index4 = findPais(pais.getNomePais());
						int[] i = { index1, index2, index3, index4 };
						JPanel tabela3 = createTable(i);
						card.add(tabela3, "7");
						cl.show(card, "7");
					}
				} else if (index + 4 == 8) {
					if ((cmb1_4.getSelectedItem() == cmb2_4.getSelectedItem()) || (cmb1_4.getSelectedItem() == cmb3_4.getSelectedItem()) || (cmb1_4.getSelectedItem() == cmb4_4.getSelectedItem()) || (cmb1_4.getSelectedItem() == cmb5_4.getSelectedItem()) || (cmb2_4.getSelectedItem() == cmb3_4.getSelectedItem()) || (cmb2_4.getSelectedItem() == cmb4_4.getSelectedItem())
							|| (cmb2_4.getSelectedItem() == cmb5_4.getSelectedItem()) || (cmb3_4.getSelectedItem() == cmb4_4.getSelectedItem()) || (cmb3_4.getSelectedItem() == cmb5_4.getSelectedItem()) || (cmb4_4.getSelectedItem() == cmb5_4.getSelectedItem())) {
						JOptionPane.showMessageDialog(null, "Repeated countries!");
					} else {
						Pais pais = (Pais) cmb1_4.getSelectedItem();
						int index1 = findPais(pais.getNomePais());
						pais = (Pais) cmb2_4.getSelectedItem();
						int index2 = findPais(pais.getNomePais());
						pais = (Pais) cmb3_4.getSelectedItem();
						int index3 = findPais(pais.getNomePais());
						pais = (Pais) cmb4_4.getSelectedItem();
						int index4 = findPais(pais.getNomePais());
						pais = (Pais) cmb5_4.getSelectedItem();
						int index5 = findPais(pais.getNomePais());
						int[] i = { index1, index2, index3, index4, index5 };
						JPanel tabela4 = createTable(i);
						card.add(tabela4, "8");
						cl.show(card, "8");
					}

				}
			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(card, "1");
				add1.setVisible(true);
				reduce1.setVisible(true);
				voltar.setVisible(false);
				getResults.setVisible(true);
			}
		});

		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		ca.add(p1);

	}

	private void addHistoricoPaises() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(10, 10, 10, 10));
		p1.setOpaque(false);
		nr.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

		card1.setOpaque(false);

		JPanel pTitulo = new JPanel();
		pTitulo.setOpaque(false);
		JLabel a = new JLabel("Nation's ranking historical between editions");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		pTitulo.add(a);

		JPanel p1_1 = new JPanel(new BorderLayout());

		p1_1.setOpaque(false);
		p1_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country1_1 = new JLabel(" Begin:  ");
		country1_1.setForeground(Color.white);
		p1_1.add(country1_1, BorderLayout.WEST);
		final JComboBox<Object> cmb1_1 = new JComboBox<Object>(Main.getJogos().toArray());
		cmb1_1.setToolTipText("Begin of the historical you want to consult.");
		p1_1.add(cmb1_1, BorderLayout.CENTER);

		JPanel p2_1 = new JPanel(new BorderLayout());
		p2_1.setOpaque(false);
		p2_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_1 = new JLabel("  End:    ");
		country2_1.setForeground(Color.white);
		p2_1.add(country2_1, BorderLayout.WEST);
		final JComboBox<Object> cmb2_1 = new JComboBox<Object>(Main.getJogos().toArray());
		cmb2_1.setToolTipText("End of the historical you want to consult");
		p2_1.add(cmb2_1, BorderLayout.CENTER);

		JPanel opcao1 = new JPanel(new GridLayout(2, 1, 0, 0));
		opcao1.setOpaque(false);
		opcao1.setBorder(new EmptyBorder(30, 0, 30, 0));
		opcao1.add(p1_1);
		opcao1.add(p2_1);

		card1.add(opcao1, "1");

		JPanel pButn = new JPanel();
		pButn.setOpaque(false);
		final Botao ok = new Botao(img.ok, img.ok_o);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		Botao voltar = new Botao(img.back, img.back_o);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		pButn.add(ok);
		pButn.add(voltar);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogosOlimpicos jogos_inicio = (JogosOlimpicos) cmb1_1.getSelectedItem();
				JogosOlimpicos jogos_fim = (JogosOlimpicos) cmb2_1.getSelectedItem();
				int ano_inicio = jogos_inicio.getAno();
				int ano_fim = jogos_fim.getAno();
				ListaLigada<Pais> p = Listagem.listarMedalhasPais(Main.getPaises(), Main.getProvas(), ano_inicio, ano_fim, null, null);
				String pais = "Nation";
				JPanel tabela1 = createTablePaisAtleta(p, pais);
				card1.add(tabela1, "2");
				cl1.show(card1, "2");
				ok.setVisible(false);
			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl1.show(card1, "1");
				ok.setVisible(true);
			}
		});

		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card1, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		nr.add(p1);

	}

	private void addHistoricoAtletas() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(10, 10, 10, 10));
		p1.setOpaque(false);
		ar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

		card2.setOpaque(false);

		JPanel pTitulo = new JPanel();
		pTitulo.setOpaque(false);
		JLabel a = new JLabel("Athlete's ranking historical between editions");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		pTitulo.add(a);

		JPanel p1_1 = new JPanel(new BorderLayout());

		p1_1.setOpaque(false);
		p1_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country1_1 = new JLabel(" Begin:  ");
		country1_1.setForeground(Color.white);
		p1_1.add(country1_1, BorderLayout.WEST);
		final JComboBox<Object> cmb1_1 = new JComboBox<Object>(Main.getJogos().toArray());
		cmb1_1.setToolTipText("Begin of the historical you want to consult.");
		p1_1.add(cmb1_1, BorderLayout.CENTER);

		JPanel p2_1 = new JPanel(new BorderLayout());
		p2_1.setOpaque(false);
		p2_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_1 = new JLabel("  End:    ");
		country2_1.setForeground(Color.white);
		p2_1.add(country2_1, BorderLayout.WEST);
		final JComboBox<Object> cmb2_1 = new JComboBox<Object>(Main.getJogos().toArray());
		cmb2_1.setToolTipText("End of the historical you want to consult");
		p2_1.add(cmb2_1, BorderLayout.CENTER);

		JPanel opcao1 = new JPanel(new GridLayout(2, 1, 0, 0));
		opcao1.setOpaque(false);
		opcao1.setBorder(new EmptyBorder(30, 0, 30, 0));
		opcao1.add(p1_1);
		opcao1.add(p2_1);

		card2.add(opcao1, "1");

		JPanel pButn = new JPanel();
		pButn.setOpaque(false);
		final Botao ok = new Botao(img.ok, img.ok_o);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		Botao voltar = new Botao(img.back, img.back_o);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		pButn.add(ok);
		pButn.add(voltar);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogosOlimpicos jogos_inicio = (JogosOlimpicos) cmb1_1.getSelectedItem();
				JogosOlimpicos jogos_fim = (JogosOlimpicos) cmb2_1.getSelectedItem();
				int ano_inicio = jogos_inicio.getAno();
				int ano_fim = jogos_fim.getAno();
				ListaLigada<Atleta> a = Listagem.listarMedalhasAtleta(Main.getAtleta(), Main.getEquipas(), Main.getProvas(), ano_inicio, ano_fim, null, null);
				String atleta = "Athlete";
				JPanel tabela1 = createTablePaisAtleta(a, atleta);
				card2.add(tabela1, "2");
				cl2.show(card2, "2");
				ok.setVisible(false);

			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl2.show(card2, "1");
				ok.setVisible(true);

			}
		});

		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card2, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		ar.add(p1);

	}

	private void addHistoricoDiscipline() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(10, 10, 10, 10));
		p1.setOpaque(false);
		rd.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

		card3.setOpaque(false);

		JPanel pTitulo = new JPanel();
		pTitulo.setOpaque(false);
		JLabel a = new JLabel("Competition's ranking historical between editions");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		pTitulo.add(a);

		JPanel p3_1 = new JPanel(new BorderLayout());
		p3_1.setOpaque(false);
		p3_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel disc = new JLabel(" Competition:       ");
		disc.setForeground(Color.white);
		p3_1.add(disc, BorderLayout.WEST);
		final JComboBox<Object> cmbdis = new JComboBox<Object>(Main.getDisciplinas().toArray());
		cmbdis.setToolTipText("Competition you want to consult");
		p3_1.add(cmbdis, BorderLayout.CENTER);

		JPanel opcao1 = new JPanel(new GridLayout(3, 1, 0, 0));
		opcao1.setOpaque(false);
		opcao1.setBorder(new EmptyBorder(30, 0, 30, 0));
		opcao1.add(p3_1);

		card3.add(opcao1, "1");

		JPanel pButn = new JPanel();
		pButn.setOpaque(false);
		final Botao ok = new Botao(img.ok, img.ok_o);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		Botao voltar = new Botao(img.back, img.back_o);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		pButn.add(ok);
		pButn.add(voltar);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disciplina d = (Disciplina) cmbdis.getSelectedItem();
				ListaLigada<Atleta> a = Listagem.listarMedalhasAtleta(Main.getAtleta(), Main.getEquipas(), Main.getProvas(), Main.getJogos().get(0).getAno(), Main.getJogos().get(Main.getJogos().size() - 1).getAno(), null, d);
				String titulo = d.getNome();
				JPanel tabela1 = createTablePaisAtleta(a, titulo);
				card3.add(tabela1, "2");
				cl3.show(card3, "2");
				ok.setVisible(false);

			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl3.show(card3, "1");
				ok.setVisible(true);

			}
		});

		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card3, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		rd.add(p1);

	}

	private void addHistoricoSport() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(10, 10, 10, 10));
		p1.setOpaque(false);
		me.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

		card4.setOpaque(false);

		JPanel pTitulo = new JPanel();
		pTitulo.setOpaque(false);
		JLabel a = new JLabel("Sport's ranking historical between editions");
		a.setFont((new Font("Arial", Font.BOLD, 14)));
		a.setForeground(Color.white);
		pTitulo.add(a);

		JPanel p1_1 = new JPanel(new BorderLayout());

		p1_1.setOpaque(false);
		p1_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country1_1 = new JLabel("  Begin:               ");
		country1_1.setForeground(Color.white);
		p1_1.add(country1_1, BorderLayout.WEST);
		final JComboBox<Object> cmb1_1 = new JComboBox<Object>(Main.getJogos().toArray());
		cmb1_1.setToolTipText("Begin of the historical you want to consult.");
		p1_1.add(cmb1_1, BorderLayout.CENTER);

		JPanel p2_1 = new JPanel(new BorderLayout());
		p2_1.setOpaque(false);
		p2_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_1 = new JLabel("  End:                   ");
		country2_1.setForeground(Color.white);
		p2_1.add(country2_1, BorderLayout.WEST);
		final JComboBox<Object> cmb2_1 = new JComboBox<Object>(Main.getJogos().toArray());
		cmb2_1.setToolTipText("End of the historical you want to consult");
		p2_1.add(cmb2_1, BorderLayout.CENTER);

		JPanel p3_1 = new JPanel(new BorderLayout());
		p3_1.setOpaque(false);
		p3_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel sport = new JLabel("  Sport:               ");
		sport.setForeground(Color.white);
		p3_1.add(sport, BorderLayout.WEST);
		final JComboBox<Object> cmbSp = new JComboBox<Object>(Main.getModalidades().toArray());
		cmbSp.setToolTipText("Sport you want to consult");
		p3_1.add(cmbSp, BorderLayout.CENTER);

		JPanel opcao1 = new JPanel(new GridLayout(3, 1, 0, 0));
		opcao1.setOpaque(false);
		opcao1.setBorder(new EmptyBorder(30, 0, 30, 0));
		opcao1.add(p1_1);
		opcao1.add(p2_1);
		opcao1.add(p3_1);

		card4.add(opcao1, "1");

		JPanel pButn = new JPanel();
		pButn.setOpaque(false);
		final Botao ok = new Botao(img.ok, img.ok_o);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		Botao voltar = new Botao(img.back, img.back_o);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		pButn.add(ok);
		pButn.add(voltar);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogosOlimpicos jogos_inicio = (JogosOlimpicos) cmb1_1.getSelectedItem();
				JogosOlimpicos jogos_fim = (JogosOlimpicos) cmb2_1.getSelectedItem();
				int ano_inicio = jogos_inicio.getAno();
				int ano_fim = jogos_fim.getAno();
				Modalidade m = (Modalidade) cmbSp.getSelectedItem();
				ListaLigada<Atleta> a = Listagem.listarMedalhasAtleta(Main.getAtleta(), Main.getEquipas(), Main.getProvas(), ano_inicio, ano_fim, m.getNome(), null);
				String titulo = m.getNome();
				JPanel tabela1 = createTablePaisAtleta(a, titulo);
				card4.add(tabela1, "2");
				cl4.show(card4, "2");
				ok.setVisible(false);

			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl4.show(card4, "1");
				ok.setVisible(true);

			}
		});

		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card4, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		me.add(p1);

	}

	private boolean isEmptyPaises() {
		return Main.getPaises().isEmpty();
	}

	private int findPais(String name) {
		for (int i = 0; i < Main.getPaises().size(); i++) {
			if (Main.getPaises().get(i).getNomePais().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	private JPanel createTableDiscipline(ListaLigada<Atleta> a, String tit) {
		JPanel pTabela = new JPanel(new GridLayout(2, 1));
		JLabel titulo = new JLabel(tit);
		titulo.setFont((new Font("Arial", Font.BOLD, 14)));
		titulo.setForeground(Color.white);
		pTabela.add(titulo);
		pTabela.setOpaque(false);
		final int TOP = 10;
		String[] col = { "Athlete", "# Gold", "# Silver", "# Bronze" };
		Object[][] linhas = new Object[TOP][col.length];
		Object[] aux = new Object[4];
		for (int j = 0; j < TOP; j++) {
			aux[0] = ((Atleta) a.get(j)).getNome();
			aux[1] = ((Atleta) a.get(j)).getMedalha().getOuro();
			aux[2] = ((Atleta) a.get(j)).getMedalha().getPrata();
			aux[3] = ((Atleta) a.get(j)).getMedalha().getBronze();
			for (int k = 0; k < col.length; k++) {
				linhas[j][k] = aux[k];
			}
		}
		final JTable table = new JTable(linhas, col);
		table.setFont(new Font("Arial", Font.PLAIN, 9));
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		pTabela.add(scrollPane);

		return pTabela;
	}

	private JPanel createTablePaisAtleta(ListaLigada<?> p, String tipo) {
		JPanel pTabela = new JPanel(new FlowLayout());
		pTabela.setOpaque(false);
		final int TOP = 10;
		String[] col = { tipo, "# Gold", "# Silver", "# Bronze" };
		Object[][] linhas = new Object[TOP][col.length];
		Object[] aux = new Object[4];
		for (int j = 0; j < TOP; j++) {
			if (tipo.equals("Nation")) {
				aux[0] = ((Pais) p.get(j)).getNomePais();
				aux[1] = ((Pais) p.get(j)).getMedalha().getOuro();
				aux[2] = ((Pais) p.get(j)).getMedalha().getPrata();
				aux[3] = ((Pais) p.get(j)).getMedalha().getBronze();
			} else {
				aux[0] = ((Atleta) p.get(j)).getNome();
				aux[1] = ((Atleta) p.get(j)).getMedalha().getOuro();
				aux[2] = ((Atleta) p.get(j)).getMedalha().getPrata();
				aux[3] = ((Atleta) p.get(j)).getMedalha().getBronze();
			}
			for (int k = 0; k < col.length; k++) {
				linhas[j][k] = aux[k];
			}
		}
		final JTable table = new JTable(linhas, col);
		table.setFont(new Font("Arial", Font.PLAIN, 9));
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		pTabela.add(scrollPane);

		return pTabela;
	}

	private JPanel createTable(int[] i) {
		JPanel pTabela = new JPanel(new FlowLayout());
		pTabela.setOpaque(false);
		String[] col = { "Country", "# Participations", "# Competitions played", "Medals(G,S,B)", "Rank", "# Medals average" };
		Object[][] linhas = new Object[i.length][col.length];
		for (int j = 0; j < i.length; j++) {
			Object[] estatisticasPais = Listagem.estatisticaPais(Main.getPaises().get(i[j]), Main.getProvas(), Main.getPaises());
			Object[] aux = { Main.getPaises().get(i[j]).getNomePais(), estatisticasPais[0], estatisticasPais[1], "(" + estatisticasPais[2] + "," + estatisticasPais[3] + "," + estatisticasPais[4] + ")", estatisticasPais[5], estatisticasPais[6] };
			for (int k = 0; k < col.length; k++) {
				linhas[j][k] = aux[k];
			}
		}
		final JTable table = new JTable(linhas, col);
		table.setFont(new Font("Arial", Font.PLAIN, 9));
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		pTabela.add(scrollPane);

		return pTabela;
	}

}