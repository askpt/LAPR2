package gui;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import jogosolimpicos.*;
import listaligada.*;

import org.jfree.ui.*;

import dados.*;

/**
 * Class that creates a frame to show listings and statistics, an instance of
 * this class is created on the class AppConfig.
 * 
 */
@SuppressWarnings("serial")
public class AddList extends JFrame {

	/**
	 * Custom Panel that contains the JPanel card (uses FlowLayout).
	 * 
	 * @see #card content of this panel
	 * 
	 * @see Panel Panel Class
	 */
	private Painel ca;
	/**
	 * Custom Panel that contains the JPanel card1 (uses FlowLayout).
	 * 
	 * @see #card1 content of this panel
	 * 
	 * @see Panel Panel Class
	 */
	private Painel nr;
	/**
	 * Custom Panel that contains the JPanel card2 (uses FlowLayout).
	 * 
	 * @see #card2 content of this panel
	 * 
	 * @see Panel Panel Class
	 */
	private Painel ar;
	/**
	 * Custom Panel that contains the JPanel card3 (uses FlowLayout).
	 * 
	 * @see #card3 content of this panel
	 * 
	 * @see Panel Panel Class
	 */
	private Painel rd;
	/**
	 * Custom Panel that contains the JPanel card4 (uses FlowLayout).
	 * 
	 * @see #card4 content of this panel
	 * 
	 * @see Panel Panel Class
	 */
	private Painel me;

	/**
	 * Instance of the class <code>Imagens</code>, used to load images in order
	 * to fill buttons and panels.
	 * 
	 * @see Imagens Imagens Class
	 */
	private Imagens img = new Imagens();
	/**
	 * TabbedPane that will hold various tabs.
	 */
	private JTabbedPane jtp = new JTabbedPane();
	/**
	 * Current index of the card.
	 * 
	 * @see #card used on this card
	 */
	private int index = 1;
	/**
	 * max size of <code>Comparative Analysis'</code> card (used to avoid
	 * errors).
	 * 
	 * @see #addCA() used in this method
	 */
	private final int MAX = 4;
	/**
	 * max size of <code>Comparative Analysis'</code> card (used to avoid
	 * errors).
	 * 
	 * @see #addCA() used in this method
	 */
	private final int MIN = 1;
	/**
	 * custom button used on <code>addCA()</code> method, its fuction is to show
	 * the last card index in order to show a table with results as output.
	 * 
	 * 
	 * @see Botao Botao Class
	 * 
	 * @see #addCA() used in this method
	 */
	// private Botao getResults = new Botao(img.getResults);
	/**
	 * CardLayout to be used in the panel card.
	 */
	private CardLayout cl = new CardLayout(10, 10);
	/**
	 * CardLayout to be used in the panel card1.
	 */
	private CardLayout cl1 = new CardLayout(10, 10);
	/**
	 * CardLayout to be used in the panel card2.
	 */
	private CardLayout cl2 = new CardLayout(10, 10);
	/**
	 * CardLayout to be used in the panel card3.
	 */
	private CardLayout cl3 = new CardLayout(10, 10);
	/**
	 * CardLayout to be used in the panel card4.
	 */
	private CardLayout cl4 = new CardLayout(10, 10);
	/**
	 * JPanel using CardLayout, this panel is used in the method
	 * <code>addCA()</code>.
	 * 
	 * @see #addCA()
	 */
	private JPanel card = new JPanel(cl);
	/**
	 * JPanel using CardLayout, this panel is used in the method
	 * <code>addHistoricoPaises()</code>.
	 * 
	 * @see #addHistoricoPaises()
	 */
	private JPanel card1 = new JPanel(cl1);
	/**
	 * JPanel using CardLayout, this panel is used in the method
	 * <code>addHistoricoAtletas()</code>.
	 * 
	 * @see #addHistoricoAtletas()
	 */
	private JPanel card2 = new JPanel(cl2);
	/**
	 * JPanel using CardLayout, this panel is used in the method
	 * <code>addHistoricoDiscipline()</code>.
	 * 
	 * @see #addHistoricoDiscipline()
	 */
	private JPanel card3 = new JPanel(cl3);
	/**
	 * JPanel using CardLayout, this panel is used in the method
	 * <code>addHistoricoSport()</code>.
	 * 
	 * @see #addHistoricoSport()
	 */
	private JPanel card4 = new JPanel(cl4);

	/**
	 * Constructor of this class it calls its superclass constructor to set the
	 * <code>title</code>, it also calls all the necessary methods in this class
	 * in order to initialize the <code>panels</code> when an object of this
	 * class is created. Sets properties.
	 * 
	 * @see javax.swing.JFrame#constructor(String)
	 * 
	 * @see #addPaineis()
	 * 
	 * @see #addTabs()
	 * 
	 * @see #addCA()
	 * 
	 * @see #addHistoricoPaises()
	 * 
	 * @see #addHistoricoAtletas()
	 * 
	 * @see #addHistoricoDiscipline()
	 * 
	 * @see #addHistoricoSport()
	 * 
	 * @see #setProperties(int,int,int,boolean)
	 */
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

	/**
	 * Sets the properties to this frame such as <code>/size<code>,
	 * <code>visibility</code> and the <code>operation</code> that will happen
	 * by default when the user initiates a "close" on this frame.
	 * 
	 * @see java.awt.Window#setSize(int,int)
	 * 
	 * @see javax.swing.JFrame#setDefaultCloseOperation(int)
	 * 
	 * @see java.awt.Window#setVisible(boolean)
	 * 
	 * @param w
	 *            the desired width to the window
	 * 
	 * @param h
	 *            the desired height to the window
	 * 
	 * @param opcao
	 *            parameter to use when calling
	 *            javax.swing.JFrame#setDefaultCloseOperation(int)
	 * 
	 * @param visible
	 *            sets the windows to visible if the parameter is true
	 */
	private void setProperties(int w, int h, int opcao, boolean visible) {
		setSize(w, h);
		setDefaultCloseOperation(opcao);
		setVisible(visible);
		setLocationRelativeTo(null);
	}

	/**
	 * Sets the selected index of the <code>TabbedPane/<code>, this method is
	 * for exterior use and it is used in the class <code>AppConfig</code>.
	 * 
	 * @see AppConfig used in this class
	 * 
	 * @param i
	 *            index of the tab
	 */
	public void setSelectedIndex(int i) {
		jtp.setSelectedIndex(i);
	}

	/**
	 * This method adds tabs to the TabbedPane, it is called on the constructor.
	 * 
	 * @see #constructor
	 */
	private void addTabs() {

		getContentPane().add(jtp);
		// Tabs
		jtp.addTab("Comparative analysis", ca);
		jtp.addTab("Ranking (Nation)", nr);
		jtp.addTab("Ranking (Athlete)", ar);
		jtp.addTab("Ranking (Competition)", rd);
		jtp.addTab("Ranking (Sport)", me);

	}

	/***
	 * This method creates custom panels and sets them as not Opaque, it is
	 * called in the constructor.
	 * 
	 * @see #ca
	 * 
	 * @see #nr
	 * 
	 * @see #ar
	 * 
	 * @see #rd
	 * 
	 * @see #me
	 * 
	 * @see javax.swing.JComponent#setOpaque()
	 * 
	 * @see gui.Painel#constructor(URL)
	 * 
	 * 
	 * @see #constructor
	 */
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

	/**
	 * Sets both contentAreaFilled and BorderPainted of the vector botoes to
	 * false
	 * 
	 * @param botoes
	 *            vector of Botao
	 */
	private void configButtons(Botao[] botoes) {
		for (Botao bt : botoes) {
			bt.setContentAreaFilled(false);
			bt.setBorderPainted(false);
		}
	}

	/***
	 * Creates the form to <code>Comparative Analysis</code> that will be
	 * inserted into the panel <code>ca</code>. This form allows the user to
	 * choose from 2 to 5 countries he wants to compare, the first 4 indexes of
	 * the <code>card panel</code> are used to comboboxes showing a list of
	 * countries, the last 4 indexes are used to create <code>tables</code> with
	 * statistcs, those will be shown as a result of the selected countries.
	 * This action will be handled in the actionlistener of the button
	 * <code>getResults</code> which has several conditions in order not to let
	 * the user choose repeated countries. It uses the method
	 * <code>isEmpty()</code> to check if the list of countries isnt empty and
	 * avoid errors. It also uses the method <code>createTable()</code>.
	 * 
	 * @see #ca container
	 * 
	 * @see #isEmpty()
	 * 
	 * @see #createTable()
	 */
	private void addCA() {

		// Panels
		final Painel main_panel = new Painel(img.bg4);
		final JPanel title_panel = new JPanel();
		final JPanel buttons_panel = new JPanel();

		// Layout
		ca.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
		main_panel.setLayout(new BorderLayout());

		// Labels
		JLabel lbl_header = new JLabel("Choose 2 to 5 countries you want to compare");

		// Buttons
		final Botao btn_add = new Botao(img.add1, img.add1_o);
		final Botao btn_reduce = new Botao(img.remove1, img.remove1_o);
		final Botao btn_back = new Botao(img.back, img.back_o);
		final Botao btn_chart = new Botao(img.chart, img.chart_o);
		final Botao btn_results = new Botao(img.getResults, img.getResults_o);
		final Botao[] btns = { btn_add, btn_reduce, btn_back, btn_chart, btn_results };

		// Customize

		// Borders
		main_panel.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Font
		lbl_header.setFont((new Font("Arial", Font.BOLD, 14)));

		// Color
		final Color color = Color.WHITE;
		lbl_header.setForeground(color);

		// Opaque
		main_panel.setOpaque(false);
		title_panel.setOpaque(false);
		card.setOpaque(false);
		buttons_panel.setOpaque(false);

		// Buttons
		configButtons(btns);
		btn_reduce.setVisible(false);
		btn_back.setVisible(false);
		btn_chart.setVisible(false);

		btn_add.setMnemonic('+');
		btn_reduce.setMnemonic('-');

		// Adding to panels
		title_panel.add(lbl_header);

		buttons_panel.add(btn_add);
		buttons_panel.add(btn_reduce);
		buttons_panel.add(btn_results);
		buttons_panel.add(btn_back);
		buttons_panel.add(btn_chart);

		// 2 COUNTRIES
		final JPanel p1_1 = new JPanel(new BorderLayout());

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

		// 3 COUNTRIES
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

		// 4 COUNTRIES
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

		// 5 COUNTRIES
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

		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < MAX) {
					index += 1;
					cl.show(card, "" + (index));
					if (index == MAX) {
						btn_add.setVisible(false);
						btn_reduce.setVisible(true);
					} else {
						btn_add.setVisible(true);
						if (index > MIN) {
							btn_reduce.setVisible(true);
						}
					}
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
				}
			}
		});

		btn_reduce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > MIN) {
					index -= 1;
					btn_reduce.setVisible(true);
					cl.show(card, "" + (index));
					if (index == MIN) {
						btn_reduce.setVisible(false);
						btn_add.setVisible(true);
					} else {
						btn_reduce.setVisible(true);
						if (index < MAX) {
							btn_add.setVisible(true);
						}
					}
				}
			}
		});

		btn_results.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_add.setVisible(false);
				btn_reduce.setVisible(false);
				btn_back.setVisible(true);
				btn_results.setVisible(false);
				btn_chart.setVisible(true);

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

		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(card, "" + index);
				btn_add.setVisible(true);
				btn_reduce.setVisible(true);
				btn_back.setVisible(false);
				btn_results.setVisible(true);
				btn_chart.setVisible(false);
			}
		});

		btn_chart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index + 4 == 5) {
					ListaLigada<String> nomes = new ListaLigada<String>();

					Pais pais1 = (Pais) cmb1_1.getSelectedItem();
					int index1 = findPais(pais1.getNomePais());
					nomes.add(pais1.getNomePais());
					ListaLigada<Integer> historico_pais1 = Listagem.historicoMedalhasPais(Main.getPaises().get(index1), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais2 = (Pais) cmb2_1.getSelectedItem();
					int index2 = findPais(pais2.getNomePais());
					nomes.add(pais2.getNomePais());
					ListaLigada<Integer> historico_pais2 = Listagem.historicoMedalhasPais(Main.getPaises().get(index2), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Chart chart1 = new Chart("Comparative Analysis", nomes, historico_pais1, historico_pais2, null, null, null);
					RefineryUtilities.centerFrameOnScreen(chart1);
				} else if (index + 4 == 6) {
					ListaLigada<String> nomes = new ListaLigada<String>();

					Pais pais1 = (Pais) cmb1_2.getSelectedItem();
					int index1 = findPais(pais1.getNomePais());
					nomes.add(pais1.getNomePais());
					ListaLigada<Integer> historico_pais1 = Listagem.historicoMedalhasPais(Main.getPaises().get(index1), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais2 = (Pais) cmb2_2.getSelectedItem();
					int index2 = findPais(pais2.getNomePais());
					nomes.add(pais2.getNomePais());
					ListaLigada<Integer> historico_pais2 = Listagem.historicoMedalhasPais(Main.getPaises().get(index2), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais3 = (Pais) cmb3_2.getSelectedItem();
					int index3 = findPais(pais3.getNomePais());
					nomes.add(pais3.getNomePais());
					ListaLigada<Integer> historico_pais3 = Listagem.historicoMedalhasPais(Main.getPaises().get(index3), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Chart chart1 = new Chart("Comparative Analysis", nomes, historico_pais1, historico_pais2, historico_pais3, null, null);
					RefineryUtilities.centerFrameOnScreen(chart1);
				} else if (index + 4 == 7) {
					ListaLigada<String> nomes = new ListaLigada<String>();

					Pais pais1 = (Pais) cmb1_3.getSelectedItem();
					int index1 = findPais(pais1.getNomePais());
					nomes.add(pais1.getNomePais());
					ListaLigada<Integer> historico_pais1 = Listagem.historicoMedalhasPais(Main.getPaises().get(index1), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais2 = (Pais) cmb2_3.getSelectedItem();
					int index2 = findPais(pais2.getNomePais());
					nomes.add(pais2.getNomePais());
					ListaLigada<Integer> historico_pais2 = Listagem.historicoMedalhasPais(Main.getPaises().get(index2), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais3 = (Pais) cmb3_3.getSelectedItem();
					int index3 = findPais(pais3.getNomePais());
					nomes.add(pais3.getNomePais());
					ListaLigada<Integer> historico_pais3 = Listagem.historicoMedalhasPais(Main.getPaises().get(index3), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais4 = (Pais) cmb4_3.getSelectedItem();
					int index4 = findPais(pais4.getNomePais());
					nomes.add(pais4.getNomePais());
					ListaLigada<Integer> historico_pais4 = Listagem.historicoMedalhasPais(Main.getPaises().get(index4), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Chart chart1 = new Chart("Comparative Analysis", nomes, historico_pais1, historico_pais2, historico_pais3, historico_pais4, null);
					RefineryUtilities.centerFrameOnScreen(chart1);

				} else if (index + 4 == 8) {
					ListaLigada<String> nomes = new ListaLigada<String>();

					Pais pais1 = (Pais) cmb1_4.getSelectedItem();
					int index1 = findPais(pais1.getNomePais());
					nomes.add(pais1.getNomePais());
					ListaLigada<Integer> historico_pais1 = Listagem.historicoMedalhasPais(Main.getPaises().get(index1), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais2 = (Pais) cmb2_4.getSelectedItem();
					int index2 = findPais(pais2.getNomePais());
					nomes.add(pais2.getNomePais());
					ListaLigada<Integer> historico_pais2 = Listagem.historicoMedalhasPais(Main.getPaises().get(index2), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais3 = (Pais) cmb3_4.getSelectedItem();
					int index3 = findPais(pais3.getNomePais());
					nomes.add(pais3.getNomePais());
					ListaLigada<Integer> historico_pais3 = Listagem.historicoMedalhasPais(Main.getPaises().get(index3), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais4 = (Pais) cmb4_4.getSelectedItem();
					int index4 = findPais(pais4.getNomePais());
					nomes.add(pais4.getNomePais());
					ListaLigada<Integer> historico_pais4 = Listagem.historicoMedalhasPais(Main.getPaises().get(index4), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Pais pais5 = (Pais) cmb5_4.getSelectedItem();
					int index5 = findPais(pais5.getNomePais());
					nomes.add(pais5.getNomePais());
					ListaLigada<Integer> historico_pais5 = Listagem.historicoMedalhasPais(Main.getPaises().get(index5), Main.getPaises(), Main.getProvas(), Main.getJogos());

					Chart chart1 = new Chart("Comparative Analysis", nomes, historico_pais1, historico_pais2, historico_pais3, historico_pais4, historico_pais5);
					RefineryUtilities.centerFrameOnScreen(chart1);
				}
			}
		});

		main_panel.add(title_panel, BorderLayout.NORTH);
		main_panel.add(card, BorderLayout.CENTER);
		main_panel.add(buttons_panel, BorderLayout.SOUTH);
		ca.add(main_panel);

	}

	/**
	 * Creates the form to <code>Nation's Ranking</code> that will be inserted
	 * into the panel <code>nr</code>. This form allows the user to choose 2
	 * editions of the games, as a result a table will be created using the
	 * method <code>createTablePaisAtleta()</code> and its content will be the
	 * historical of the nations between those 2 editions. The 1st index of the
	 * <code>card panel</code> has the form and the second index has the table
	 * created as a result of the options chosen on the form. It uses a static
	 * method of the class <code>Listagem</code> to receive the necessary data
	 * to create the table.
	 * 
	 * @see #nr container
	 * 
	 * @see jogosolimpicos.Listagem#listarMedalhasPais
	 * 
	 * @see #createTablePaisAtleta()
	 */
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
		final Botao voltar = new Botao(img.back, img.back_o);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		voltar.setVisible(false);
		final Botao html = new Botao(img.html, img.html_o);
		html.setContentAreaFilled(false);
		html.setBorderPainted(false);
		pButn.add(ok);
		pButn.add(html);
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
				voltar.setVisible(true);
			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl1.show(card1, "1");
				ok.setVisible(true);
				voltar.setVisible(false);
			}
		});

		html.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HTML html = new HTML();
				Linguas lingua = (Linguas) JOptionPane.showInputDialog(AddList.this, "Choose a language: ", "Export to HTML", 0, new ImageIcon(img.html_icon), Main.getLingua().toArray(), Main.getLingua().toArray()[0]);
				JogosOlimpicos jogos_inicio = (JogosOlimpicos) cmb1_1.getSelectedItem();
				JogosOlimpicos jogos_fim = (JogosOlimpicos) cmb2_1.getSelectedItem();
				int ano_inicio = jogos_inicio.getAno();
				int ano_fim = jogos_fim.getAno();
				if (lingua != null)
					html.exportPais(AddList.this, ano_inicio, ano_fim, lingua, Main.getLingua(), Main.getProvas(), Main.getPaises());
			}
		});

		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card1, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		nr.add(p1);

	}

	/**
	 * Creates the form to <code>Athlete's Ranking</code> that will be inserted
	 * into the panel <code>ar</code>. This form allows the user to choose 2
	 * editions of the games, as a result a table will be created using the
	 * method <code>createTablePaisAtleta()</code> and its content will be the
	 * historical of the athletes between those 2 editions. The 1st index of the
	 * <code>card panel</code> has the form and the second index has the table
	 * created as a result of the options chosen on the form. It uses a static
	 * method of the class <code>Listagem</code> to receive the necessary data
	 * to create the table.
	 * 
	 * @see #ar container
	 * 
	 * @see jogosolimpicos.Listagem#listarMedalhasAtleta
	 * 
	 * @see #createTablePaisAtleta()
	 */
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
		final Botao voltar = new Botao(img.back, img.back_o);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		voltar.setVisible(false);
		final Botao html = new Botao(img.html, img.html_o);
		html.setContentAreaFilled(false);
		html.setBorderPainted(false);
		pButn.add(ok);
		pButn.add(html);
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
				voltar.setVisible(true);

			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl2.show(card2, "1");
				ok.setVisible(true);
				voltar.setVisible(false);

			}
		});

		html.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HTML html = new HTML();
				Linguas lingua = (Linguas) JOptionPane.showInputDialog(AddList.this, "Choose a language: ", "Export to HTML", 0, new ImageIcon(img.html_icon), Main.getLingua().toArray(), Main.getLingua().toArray()[0]);
				JogosOlimpicos jogos_inicio = (JogosOlimpicos) cmb1_1.getSelectedItem();
				JogosOlimpicos jogos_fim = (JogosOlimpicos) cmb2_1.getSelectedItem();
				int ano_inicio = jogos_inicio.getAno();
				int ano_fim = jogos_fim.getAno();

				if (lingua != null)
					html.exportAtleta(AddList.this, ano_inicio, ano_fim, lingua, Main.getLingua(), Main.getAtleta(), Main.getProvas(), Main.getEquipas());
			}
		});

		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card2, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		ar.add(p1);

	}

	/**
	 * Creates the form to <code>Competition's Ranking</code> that will be
	 * inserted into the panel <code>ar</code>. This form allows the user to
	 * choose 2 editions of the games and a competition, as a result a table
	 * will be created using the method <code>createTablePaisAtleta()</code> and
	 * its content will be the historical of the competition between those 2
	 * editions. The 1st index of the <code>card panel</code> has the form and
	 * the second index has the table created as a result of the options chosen
	 * on the form. It uses a static method of the class <code>Listagem</code>
	 * to receive the necessary data to create the table.
	 * 
	 * @see #rd container
	 * 
	 * @see jogosolimpicos.Listagem#listarMedalhasAtleta
	 * 
	 * @see #createTablePaisAtleta()
	 */
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

		JPanel p1_1 = new JPanel(new BorderLayout());

		p1_1.setOpaque(false);
		p1_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country1_1 = new JLabel("  Begin:                ");
		country1_1.setForeground(Color.white);
		p1_1.add(country1_1, BorderLayout.WEST);
		final JComboBox<Object> cmb1_1 = new JComboBox<Object>(Main.getJogos().toArray());
		cmb1_1.setToolTipText("Begin of the historical you want to consult.");
		p1_1.add(cmb1_1, BorderLayout.CENTER);

		JPanel p2_1 = new JPanel(new BorderLayout());
		p2_1.setOpaque(false);
		p2_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel country2_1 = new JLabel("   End:                   ");
		country2_1.setForeground(Color.white);
		p2_1.add(country2_1, BorderLayout.WEST);
		final JComboBox<Object> cmb2_1 = new JComboBox<Object>(Main.getJogos().toArray());
		cmb2_1.setToolTipText("End of the historical you want to consult");
		p2_1.add(cmb2_1, BorderLayout.CENTER);

		JPanel p3_1 = new JPanel(new BorderLayout());
		p3_1.setOpaque(false);
		p3_1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel disc = new JLabel("   Competition:       ");
		disc.setForeground(Color.white);
		p3_1.add(disc, BorderLayout.WEST);
		final JComboBox<Object> cmbdis = new JComboBox<Object>(competitionsFiltradas().toArray());
		cmbdis.setToolTipText("Competition you want to consult");
		p3_1.add(cmbdis, BorderLayout.CENTER);

		JPanel opcao1 = new JPanel(new GridLayout(3, 1, 0, 0));
		opcao1.setOpaque(false);
		opcao1.setBorder(new EmptyBorder(30, 0, 30, 0));
		opcao1.add(p1_1);
		opcao1.add(p2_1);
		opcao1.add(p3_1);

		card3.add(opcao1, "1");

		JPanel pButn = new JPanel();
		pButn.setOpaque(false);
		final Botao ok = new Botao(img.ok, img.ok_o);
		ok.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		final Botao voltar = new Botao(img.back, img.back_o);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		voltar.setVisible(false);
		final Botao html = new Botao(img.html, img.html_o);
		html.setContentAreaFilled(false);
		html.setBorderPainted(false);
		pButn.add(ok);
		pButn.add(html);
		pButn.add(voltar);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogosOlimpicos jogos_inicio = (JogosOlimpicos) cmb1_1.getSelectedItem();
				JogosOlimpicos jogos_fim = (JogosOlimpicos) cmb2_1.getSelectedItem();
				int ano_inicio = jogos_inicio.getAno();
				int ano_fim = jogos_fim.getAno();
				Disciplina d = (Disciplina) cmbdis.getSelectedItem();
				ListaLigada<Pais> listagem_pais = Listagem.listarMedalhasPais(Main.getPaises(), Main.getProvas(), ano_inicio, ano_fim, null, d);
				JPanel tabela1 = createTablePaisAtleta(listagem_pais, "Nation");
				card3.add(tabela1, "2");
				cl3.show(card3, "2");
				ok.setVisible(false);
				voltar.setVisible(true);

			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl3.show(card3, "1");
				ok.setVisible(true);
				voltar.setVisible(false);
			}
		});

		html.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HTML html = new HTML();
				Linguas lingua = (Linguas) JOptionPane.showInputDialog(AddList.this, "Choose a language: ", "Export to HTML", 0, new ImageIcon(img.html_icon), Main.getLingua().toArray(), Main.getLingua().toArray()[0]);
				JogosOlimpicos jogos_inicio = (JogosOlimpicos) cmb1_1.getSelectedItem();
				JogosOlimpicos jogos_fim = (JogosOlimpicos) cmb2_1.getSelectedItem();
				int ano_inicio = jogos_inicio.getAno();
				int ano_fim = jogos_fim.getAno();
				Disciplina competition = (Disciplina) cmbdis.getSelectedItem();
				if (lingua != null)
					html.exportDisciplina(AddList.this, ano_inicio, ano_fim, Main.getProvas(), competition, Main.getLingua(), lingua, Main.getPaises());
			}
		});
		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card3, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		rd.add(p1);

	}

	/**
	 * Creates the form to <code>Sports Ranking</code> that will be inserted
	 * into the panel <code>me</code>. This form allows the user to choose 2
	 * editions of the games and a sport, as a result a table will be created
	 * using the method <code>createTablePaisAtleta()</code> and its content
	 * will be the historical of the sport between those 2 editions. The 1st
	 * index of the <code>card panel</code> has the form and the second index
	 * has the table created as a result of the options chosen on the form. It
	 * uses a static method of the class <code>Listagem</code> to receive the
	 * necessary data to create the table.
	 * 
	 * @see #me container
	 * 
	 * @see jogosolimpicos.Listagem#listarMedalhasAtleta
	 * 
	 * @see #createTablePaisAtleta()
	 */
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

		JLabel sport = new JLabel("   Sport:               ");
		sport.setForeground(Color.white);
		p3_1.add(sport, BorderLayout.WEST);
		final JComboBox<Object> cmbSp = new JComboBox<Object>(sportsFiltrados().toArray());
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
		final Botao voltar = new Botao(img.back, img.back_o);
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		voltar.setVisible(false);
		final Botao html = new Botao(img.html, img.html_o);
		html.setContentAreaFilled(false);
		html.setBorderPainted(false);
		pButn.add(ok);
		pButn.add(html);
		pButn.add(voltar);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogosOlimpicos jogos_inicio = (JogosOlimpicos) cmb1_1.getSelectedItem();
				JogosOlimpicos jogos_fim = (JogosOlimpicos) cmb2_1.getSelectedItem();
				int ano_inicio = jogos_inicio.getAno();
				int ano_fim = jogos_fim.getAno();
				Modalidade m = (Modalidade) cmbSp.getSelectedItem();
				ListaLigada<Pais> listagem_pais = Listagem.listarMedalhasPais(Main.getPaises(), Main.getProvas(), ano_inicio, ano_fim, m.getNome(), null);
				JPanel tabela1 = createTablePaisAtleta(listagem_pais, "Nation");
				card4.add(tabela1, "2");
				cl4.show(card4, "2");
				ok.setVisible(false);
				voltar.setVisible(true);

			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl4.show(card4, "1");
				ok.setVisible(true);
				voltar.setVisible(false);

			}
		});

		html.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HTML html = new HTML();
				Linguas lingua = (Linguas) JOptionPane.showInputDialog(AddList.this, "Choose a language: ", "Export to HTML", 0, new ImageIcon(img.html_icon), Main.getLingua().toArray(), Main.getLingua().toArray()[0]);
				JogosOlimpicos jogos_inicio = (JogosOlimpicos) cmb1_1.getSelectedItem();
				JogosOlimpicos jogos_fim = (JogosOlimpicos) cmb2_1.getSelectedItem();
				int ano_inicio = jogos_inicio.getAno();
				int ano_fim = jogos_fim.getAno();
				Modalidade sport = (Modalidade) cmbSp.getSelectedItem();
				if (lingua != null)
					html.exportModalidade(AddList.this, ano_inicio, ano_fim, sport.getNome(), Main.getLingua(), lingua, Main.getProvas(), Main.getPaises());
			}
		});

		p1.add(pTitulo, BorderLayout.NORTH);
		p1.add(card4, BorderLayout.CENTER);
		p1.add(pButn, BorderLayout.SOUTH);
		me.add(p1);

	}

	/**
	 * Returns true if the container of countries is empty.
	 * 
	 * @return true if the container of countries is empty
	 */
	private boolean isEmptyPaises() {
		return Main.getPaises().isEmpty();
	}

	/**
	 * Returns the index of the country with the same name as the parameter
	 * variable.
	 * 
	 * @param name
	 *            the name of the <code>country</code>
	 * 
	 * @return i returns the index of the country with the same name as the
	 *         parameter variable or -1 if it wasnt found
	 */
	private int findPais(String name) {
		for (int i = 0; i < Main.getPaises().size(); i++) {
			if (Main.getPaises().get(i).getNomePais().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns a linked list with filtered sports, only sports with results will
	 * be added to the list.
	 * 
	 * @return modalidadesValidas Returns a linked list with filtered sports,
	 *         only sports with results will be added to the list
	 */
	private ListaLigada<Modalidade> sportsFiltrados() {
		ListaLigada<Modalidade> modalidadesValidas = new ListaLigada<Modalidade>();
		for (int i = 0; i < Main.getProvas().size(); i++) {
			if (Main.getProvas().get(i) instanceof ProvaInd) {
				if (!((ProvaInd) Main.getProvas().get(i)).getResultados().isEmpty()) {
					if (!modalidadesValidas.contains(Main.getProvas().get(i).getDisciplina().getModalidade())) {
						modalidadesValidas.add(Main.getProvas().get(i).getDisciplina().getModalidade());
					}
				}
			} else {
				if (!((ProvaCol) Main.getProvas().get(i)).getResultados().isEmpty()) {
					if (!modalidadesValidas.contains(Main.getProvas().get(i).getDisciplina().getModalidade())) {
						modalidadesValidas.add(Main.getProvas().get(i).getDisciplina().getModalidade());
					}
				}
			}
		}
		return modalidadesValidas;
	}

	/**
	 * Returns a linked list with filtered competitions, only competitions with
	 * results will be added to the list.
	 * 
	 * @return disciplinaValidas Returns a linked list with filtered
	 *         competitions, only competitions with results will be added to the
	 *         list
	 */
	private ListaLigada<Disciplina> competitionsFiltradas() {
		ListaLigada<Disciplina> disciplinaValidas = new ListaLigada<Disciplina>();
		for (int i = 0; i < Main.getProvas().size(); i++) {
			if (Main.getProvas().get(i) instanceof ProvaInd) {
				if (!((ProvaInd) Main.getProvas().get(i)).getResultados().isEmpty()) {
					if (!disciplinaValidas.contains(Main.getProvas().get(i).getDisciplina())) {
						disciplinaValidas.add(Main.getProvas().get(i).getDisciplina());
					}
				}
			} else {
				if (!((ProvaCol) Main.getProvas().get(i)).getResultados().isEmpty()) {
					if (!disciplinaValidas.contains(Main.getProvas().get(i).getDisciplina())) {
						disciplinaValidas.add(Main.getProvas().get(i).getDisciplina());
					}
				}
			}
		}
		return disciplinaValidas;
	}

	/**
	 * Returns a panel with a <code>JTable</code> created with the data parsed
	 * in parameters. The header is the only part that is defined inside the
	 * method yet, it is easy to modify.
	 * 
	 * @param atleta
	 *            a linked list with the name of athletes and the number of
	 *            medals they have got
	 * 
	 * @param title
	 *            the title
	 * 
	 * @return pTabela Returns a panel with a table created with the data parsed
	 *         in parameters
	 */
	@SuppressWarnings("unused")
	private JPanel createTableDiscipline(ListaLigada<Atleta> atleta, String title) {
		JPanel pTabela = new JPanel(new GridLayout(2, 1));
		JLabel titulo = new JLabel(title);
		titulo.setFont((new Font("Arial", Font.BOLD, 14)));
		titulo.setForeground(Color.white);
		pTabela.add(titulo);
		pTabela.setOpaque(false);
		final int TOP = 10;
		String[] col = { "Athlete", "# Gold", "# Silver", "# Bronze" };
		Object[][] linhas = new Object[TOP][col.length];
		Object[] aux = new Object[4];
		for (int j = 0; j < TOP; j++) {
			aux[0] = ((Atleta) atleta.get(j)).getNome();
			aux[1] = ((Atleta) atleta.get(j)).getMedalha().getOuro();
			aux[2] = ((Atleta) atleta.get(j)).getMedalha().getPrata();
			aux[3] = ((Atleta) atleta.get(j)).getMedalha().getBronze();
			for (int k = 0; k < col.length; k++) {
				linhas[j][k] = aux[k];
			}
		}
		final JTable table = new JTable(linhas, col);
		table.setEnabled(false);

		table.setFont(new Font("Arial", Font.PLAIN, 9));
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		pTabela.add(scrollPane);

		return pTabela;
	}

	/**
	 * Returns a panel with a <code>JTable</code> created with the data parsed
	 * in parameters. The header is the only part that is defined inside the
	 * method yet, it is easy to modify.
	 * 
	 * @param a
	 *            a linked list with the name of athletes and the number of
	 *            medals they have got
	 * 
	 * @param tit
	 *            the title
	 * 
	 * @return pTabela Returns a panel with a table created with the data parsed
	 *         in parameters
	 */
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
		table.setEnabled(false);
		table.setGridColor(Color.WHITE);
		table.setBackground(new Color(60, 69, 76));
		table.setForeground(Color.WHITE);
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(60, 69, 76));
		header.setForeground(Color.white);

		table.setFont(new Font("Arial", Font.PLAIN, 9));
		table.setEnabled(false);
		table.setPreferredScrollableViewportSize(new Dimension(500, 163));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		pTabela.add(scrollPane);

		return pTabela;
	}

	/**
	 * Returns a panel with a <code>JTable</code> created with the data parsed
	 * in parameters. The header is the only part that is defined inside the
	 * method yet, it is easy to modify.
	 * 
	 * @param a
	 *            vector with indexes of countries
	 * 
	 * 
	 * @return pTabela Returns a panel with a table created with the data parsed
	 *         in parameters
	 */
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
		table.setEnabled(false);
		table.setGridColor(Color.WHITE);
		table.setBackground(new Color(60, 69, 76));
		table.setForeground(Color.WHITE);
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(60, 69, 76));
		header.setForeground(Color.white);

		table.setFont(new Font("Arial", Font.PLAIN, 9));
		if (i.length == 2) {
			table.setPreferredScrollableViewportSize(new Dimension(500, 32));
		} else if (i.length == 3) {
			table.setPreferredScrollableViewportSize(new Dimension(500, 48));
		} else if (i.length == 4) {
			table.setPreferredScrollableViewportSize(new Dimension(500, 64));
		} else if (i.length == 5) {
			table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		}
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);

		pTabela.add(scrollPane);

		return pTabela;
	}
}