package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import jogosolimpicos.*;
import listaligada.*;

/**
 * Class that creates a frame to add data manually, an instance of this class is
 * created on the class AppConfig.
 * 
 */
@SuppressWarnings("serial")
public class AddDados extends JFrame {

	/**
	 * Custom Panel that contains a form within another panel.
	 * 
	 * @see Panel Panel Class
	 */
	private Painel co;
	/**
	 * Custom Panel that contains a form within another panel.
	 * 
	 * @see Panel Panel Class
	 */
	private Painel di;
	/**
	 * Custom Panel that contains a form within another panel.
	 * 
	 * @see Panel Panel Class
	 */
	private Painel spo;
	/**
	 * Instance of the class <code>Imagens</code>, used to load images in order
	 * to fill buttons and panels.
	 * 
	 * @see Imagens Imagens Class
	 */
	private Imagens img = new Imagens();
	/**
	 * Custom Panel that contains a form within another panel.
	 * 
	 * @see Panel Panel Class
	 */
	private JTabbedPane jtp = new JTabbedPane();

	@SuppressWarnings("unused")
	private Pais country;
	private Disciplina competition;
	private Modalidade sport;

	/**
	 * Constructor of this class it calls its superclass constructor to set the
	 * <code>title</code>, it also calls all the necessary methods in this class
	 * in order to initialize the <code>panels</code> when an object of this
	 * class is created. Sets properties.
	 * 
	 * @see #addPaineis()
	 * 
	 * @see #addTabs()
	 * 
	 * @see #addCompetition()
	 * 
	 * @see #addSport()
	 * 
	 * @see #setProperties(int,int,int,boolean)
	 */
	public AddDados(Pais country, Disciplina competition, Modalidade sport) {
		super("Add/Edit Info");

		addPaineis();
		addTabs();
		setSport(sport);
		setCompetition(competition);
		addCountry(country);
		addCompetition();
		addSport();

		setProperties(600, 480, 1, true);
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
	 * Sets the country to edit
	 * 
	 * @param pais
	 *            country to edit
	 */
	public void setCountry(Pais pais) {
		this.country = pais;
	}

	/**
	 * Sets the competition to edit
	 * 
	 * @param comp
	 *            competition to edit
	 */
	public void setCompetition(Disciplina comp) {
		this.competition = comp;
	}

	/**
	 * Sets the sport to edit
	 * 
	 * @param mod
	 *            sport to edit
	 */
	public void setSport(Modalidade mod) {
		this.sport = mod;
	}

	/**
	 * This method adds tabs to the TabbedPane, it is called on the constructor.
	 * 
	 */
	private void addTabs() {

		getContentPane().add(jtp);
		// Tabs
		jtp.addTab("Country", co);
		jtp.addTab("Discipline", di);
		jtp.addTab("Sport", spo);

	}

	/**
	 * This method creates custom panels and sets them as not Opaque, it is
	 * called in the constructor.
	 * 
	 * @see #co
	 * 
	 * @see #di
	 * 
	 * @see #spo
	 * 
	 */
	private void addPaineis() {

		// Panels
		co = new Painel(img.bg3);
		di = new Painel(img.bg3);
		spo = new Painel(img.bg3);

		co.setOpaque(false);
		di.setOpaque(false);
		spo.setOpaque(false);
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

	/**
	 * Sets panel's opaque option to false
	 * 
	 * @param panels
	 *            vector of JPanel
	 */
	private void setOpaquePanels(JPanel[] panels) {
		for (JPanel panel : panels) {
			panel.setOpaque(false);
		}
	}

	/**
	 * Sets radiobuttons opaque option to false and sets the color in parameter
	 * 
	 * @param rdb
	 *            vector of radio buttons
	 * @param color
	 *            color
	 */
	private void customizeRadioButtons(JRadioButton[] rdb, Color color) {
		for (JRadioButton rdbtn : rdb) {
			rdbtn.setOpaque(false);
			rdbtn.setForeground(color);
		}
	}

	/**
	 * Sets the labels color
	 * 
	 * @param labels
	 *            vector of labels
	 * @param color
	 *            color
	 */
	private void paintLabels(JLabel[] labels, Color color) {
		for (JLabel label : labels) {
			label.setForeground(color);
		}
	}

	/**
	 * Returns true if there is already a sport with the name equal to the name
	 * in the parameter.
	 * 
	 * @return Returns true if there is already a sport with the name equal to
	 *         the name in the parameter
	 */
	private boolean sportExists(String sport) {
		for (int i = 0; i < Main.getModalidades().size(); i++) {
			if (Main.getModalidades().get(i).getNome().equalsIgnoreCase(sport))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if there is already a competition equal to the the parameter
	 * 
	 * @return Returns true if there is already a competition equal to the the
	 *         parameter
	 */
	private boolean competitionExists(String name) {
		for (int i = 0; i < Main.getDisciplinas().size(); i++) {
			if (Main.getDisciplinas().get(i).getNome().equals(name))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if there is already a country with the name and code equal
	 * to the parameter.
	 * 
	 * @return Returns true if there is already a country with the name and code
	 *         equal to the parameter
	 */
	private boolean countryExists(Pais pais) {
		ListaLigada<Pais> temp = new ListaLigada<Pais>(Main.getPaises());

		for (int j = 0; j < temp.size(); j++) {
			if (temp.get(j).equals(pais)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if there is already a country with the same name and code as
	 * the country in parameter
	 * 
	 * @param pais
	 *            country to compare
	 * @param exception
	 *            country that will not be compared
	 * @return Returns true if there is already a country with its name and code
	 */
	private boolean countryExistsExcept(Pais pais, Pais exception) {
		ListaLigada<Pais> temp = new ListaLigada<Pais>(Main.getPaises());
		temp.remove(temp.indexOf(exception));

		for (int j = 0; j < temp.size(); j++) {
			if (temp.get(j).equals(pais)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Fixes string problems, eg: nAmE will returns Name
	 * 
	 * @param nome
	 * @return fixed string
	 */
	private String corrigirNome(String nome) {
		String pletra = "";
		String novo = "";
		if (nome.matches("^[A-Za-z]{1,}$")) {
			nome = nome.toLowerCase();
			char[] c = nome.toCharArray();
			pletra = c[0] + "";
			pletra = pletra.toUpperCase();
			novo = pletra;
			for (int i = 1; i < c.length; i++) {
				novo += "" + c[i];
			}
		}
		return novo;
	}

	/**
	 * Fixes string problems with characteres, eg: fIrst-sPort returns
	 * First-Sport
	 * 
	 * @param nome
	 * @return fixed String
	 */
	private String corrigirNomeCar(String nome) {
		String novo = "";
		if (nome.matches("^[A-Za-z-]{1,}[-]{1}[A-Za-z]{1,}$")) {
			String[] a = nome.split("-");
			for (int i = 0; i < a.length; i++) {
				a[i] = a[i].trim();
				a[i] = corrigirNome(a[i]);
				if (i != a.length - 1) {
					novo += "" + a[i] + "-";
				} else {
					novo += "" + a[i];
				}
			}
		}
		return novo;
	}

	private boolean isCountryValid(String name, String code) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(AddDados.this, "Make sure there are no empty fields!");
			return false;
		} else if (code.equals("")) {
			JOptionPane.showMessageDialog(AddDados.this, "Make sure there are no empty fields!");
			return false;
		} else if (!code.matches("^[A-Z]{3}$")) {
			JOptionPane.showMessageDialog(AddDados.this, "Make sure the code field is formatted within the correct format!");
			return false;
		} else if (!name.matches("^[A-Za-z]{1,}$")) {
			JOptionPane.showMessageDialog(AddDados.this, "Make sure the name field is formatted within the correct format!");
			return false;
		} else {

			return true;
		}
	}

	/**
	 * Creates the form to create or edit a <code>Country</code> that will be
	 * inserted into the panel <code>co</code>. This form allows the user to
	 * give the country a name and its correspondent code. This method is really
	 * meticulous about the way it reads the input as it tests if the input
	 * matches the desired format.It will not accept until the user types
	 * something that matches the format.
	 */
	private void addCountry(final Pais country) {

		// Layout
		final CardLayout cl = new CardLayout();

		// Color
		Color color = Color.WHITE;

		// Panels
		final JPanel card_panel = new JPanel(cl);
		final Painel main_panel = new Painel(img.bg4);
		final JPanel name_panel = new JPanel(new BorderLayout(0, 10));
		final JPanel code_panel = new JPanel(new BorderLayout());
		final JPanel buttons_panel = new JPanel();
		final JPanel[] panels = { card_panel, name_panel, code_panel, buttons_panel };

		// Labels
		final JLabel lbl_country = new JLabel("Country");
		final JLabel lbl_name = new JLabel("Name: ");
		final JLabel lbl_code = new JLabel("    Code:  ");
		final JLabel[] labels = { lbl_country, lbl_name, lbl_code };

		// TextFields
		final JTextField txtName = new JTextField(20);
		final JTextField txtCode = new JTextField(20);
		// If country is not null it means the user wants to edit that country
		if (country != null) {
			txtName.setText(country.getNomePais());
			txtCode.setText(country.getCodigoPais(0));
		}

		// Buttons
		final Botao ok = new Botao(img.ok, img.ok_o);
		final Botao clear = new Botao(img.clear, img.clear_o);
		Botao[] botoes = { ok, clear };

		// Customization
		co.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		setOpaquePanels(panels);
		configButtons(botoes);
		paintLabels(labels, color);

		main_panel.setLayout(new BorderLayout(10, 10));
		main_panel.setOpaque(false);
		main_panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		name_panel.setBorder(new EmptyBorder(10, 10, 0, 10));

		lbl_country.setFont((new Font("Arial", Font.BOLD, 14)));

		txtName.setToolTipText("Country's name.");
		txtCode.setToolTipText("Country's code.");

		// ActionListeners
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtCode.setText("");

			}
		});

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isCountryValid(txtName.getText(), txtCode.getText())) {
					txtName.requestFocus();
				} else {
					if (country == null) {
						if (countryExists(new Pais(corrigirNome(txtName.getText()), txtCode.getText()))) {
							JOptionPane.showMessageDialog(AddDados.this, "That country already exists!");

						} else {
							Pais pais = new Pais(txtCode.getText(), corrigirNome(txtName.getText()));
							Main.getPaises().add(pais);
							JOptionPane.showMessageDialog(AddDados.this, "Country (" + pais + ") was added successfully!");
						}
					} else {

						Pais novoPais = new Pais(txtCode.getText(), corrigirNome(txtName.getText()));

						if (!countryExistsExcept(novoPais, country)) {
							country.setNomePais(corrigirNome(txtName.getText()));
							country.setCodigoPais(txtCode.getText());
							JOptionPane.showMessageDialog(AddDados.this, "Country was edited successfully!");
							dispose();
						} else {
							JOptionPane.showMessageDialog(AddDados.this, "That country already exists!");
							dispose();
						}
					}
					txtName.setText("");
					txtCode.setText("");
				}

			}
		});

		// Adding to panels
		name_panel.add(lbl_country, BorderLayout.NORTH);
		name_panel.add(lbl_name, BorderLayout.WEST);
		name_panel.add(txtName, BorderLayout.CENTER);

		code_panel.add(lbl_code, BorderLayout.WEST);
		code_panel.add(txtCode, BorderLayout.CENTER);

		buttons_panel.add(ok);
		buttons_panel.add(clear);

		main_panel.add(name_panel, BorderLayout.NORTH);
		main_panel.add(code_panel, BorderLayout.CENTER);
		main_panel.add(buttons_panel, BorderLayout.SOUTH);

		co.add(main_panel);

	}

	/**
	 * Creates the form to create a <code>Competition</code> that will be
	 * inserted into the panel <code>di</code>. This form allows the user to
	 * give the competition a name, to choose its correspondent sport. This
	 * method is really meticulous about the way it reads the input as it tests
	 * if the input matches the desired format.It will not accept until the user
	 * types something that matches the format.
	 */
	private void addCompetition() {

		// Layout
		di.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));

		// Color
		final Color color = Color.white;

		// Panels
		final Painel main_panel = new Painel(img.bg4);
		final JPanel name_panel = new JPanel(new BorderLayout());
		final JPanel sport_panel = new JPanel(new BorderLayout());
		final JPanel cType_panel = new JPanel();
		final JPanel cGenre_panel = new JPanel();
		final JPanel cTypeCompetition_panel = new JPanel();
		final JPanel cOrdination_panel = new JPanel();
		final JPanel buttons_panel = new JPanel();
		final JPanel[] panels = { name_panel, sport_panel, cType_panel, cGenre_panel, cTypeCompetition_panel, cOrdination_panel, buttons_panel };

		// Labels
		JLabel lbl_title = new JLabel("Competition");
		JLabel lbl_name = new JLabel("Name:  ");
		JLabel lbl_sport = new JLabel("  Sport:  ");
		JLabel[] labels = { lbl_title, lbl_name, lbl_sport };

		// TextFields
		final JTextField txtName = new JTextField(20);
		if (this.competition != null) {
			txtName.setText(competition.getNome());
		}

		// ComboBoxes
		final JComboBox<?> cmb_sport = new JComboBox<Object>(Main.getModalidades().toArray());
		if (competition != null) {
			cmb_sport.setEditable(true);
			cmb_sport.setSelectedItem(competition.getModalidade());
		}

		// Buttons
		final Botao ok = new Botao(img.ok, img.ok_o);
		final Botao clear = new Botao(img.clear, img.clear_o);
		final Botao[] botoes = { ok, clear };

		// JRadio Buttons
		final ButtonGroup btngrp = new ButtonGroup(); // classification type
		final JRadioButton rbDistancia = new JRadioButton("Distance");
		final JRadioButton rbTempo = new JRadioButton("Time");
		final JRadioButton rbPontos = new JRadioButton("Score");
		final JRadioButton rbRank = new JRadioButton("Rank");
		if (competition != null) {
			int tipoClass = competition.getTipoClass();
			if (tipoClass == 0) {
				rbDistancia.setSelected(true);
			} else if (tipoClass == 1) {
				rbTempo.setSelected(true);
			} else if (tipoClass == 2) {
				rbPontos.setSelected(true);
			} else {
				rbRank.setSelected(true);
			}
		}

		final ButtonGroup btngrp2 = new ButtonGroup(); // competition genre
		final JRadioButton rbM = new JRadioButton("Male");
		final JRadioButton rbF = new JRadioButton("Female");
		final JRadioButton rbMi = new JRadioButton("Mixed");
		if (competition != null) {
			int genero = competition.getGenero();
			if (genero == 0) {
				rbM.setSelected(true);
			} else if (genero == 1) {
				rbF.setSelected(true);
			} else {
				rbMi.setSelected(true);
			}
		}

		final ButtonGroup btngrp3 = new ButtonGroup(); // competition type
		final JRadioButton rbI = new JRadioButton("Individual");
		final JRadioButton rbC = new JRadioButton("Colective");
		if (competition != null) {
			boolean ver = competition.getTipoMod();
			if (ver == false) {
				rbI.setSelected(true);
			} else {
				rbC.setSelected(true);
			}
		}
		final ButtonGroup btngrp4 = new ButtonGroup(); // ordination type
		final JRadioButton rbH = new JRadioButton("Highest");
		final JRadioButton rbL = new JRadioButton("Lowest");
		if (competition != null) {
			boolean ver = competition.getOrdenacao();
			if (ver) {
				rbH.setSelected(true);
			} else {
				rbL.setSelected(true);
			}
		}

		final JRadioButton[] rdbtns = { rbDistancia, rbTempo, rbPontos, rbRank, rbM, rbF, rbMi, rbI, rbC, rbH, rbL };

		// Customization

		// font
		lbl_title.setFont((new Font("Arial", Font.BOLD, 14)));

		// layout
		main_panel.setLayout(new GridLayout(7, 1));

		// border
		main_panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		name_panel.setBorder(new EmptyBorder(10, 10, 0, 10));
		cType_panel.setBorder(new EmptyBorder(10, 10, 0, 10));
		sport_panel.setBorder(new EmptyBorder(25, 2, 0, 10));

		// opaque
		setOpaquePanels(panels);
		main_panel.setOpaque(false);

		// color
		paintLabels(labels, color);

		// buttons customization
		configButtons(botoes);

		// radiobuttons customization
		customizeRadioButtons(rdbtns, color);

		// tooltiptext
		txtName.setToolTipText("Competition's name");
		cmb_sport.setToolTipText("Competition's Sport.");

		// Adding rButtons
		btngrp.add(rbDistancia);
		btngrp.add(rbTempo);
		btngrp.add(rbPontos);
		btngrp.add(rbRank);

		btngrp2.add(rbM);
		btngrp2.add(rbF);
		btngrp2.add(rbMi);

		btngrp3.add(rbI);
		btngrp3.add(rbC);

		btngrp4.add(rbH);
		btngrp4.add(rbL);

		// ActionListeners
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
			}
		});

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.equals("")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure there are no empty fields!");
					txtName.requestFocus();
				} else {

					String NAME = txtName.getText();
					boolean editar = competition == null ? false : true;

					if (!competitionExists(NAME)) {
						int GENRE = -1;
						boolean TIPO_DISC = false;
						int TIPO = -1;
						boolean ORD = false;
						Modalidade MOD = null;

						if (rbM.isSelected()) {
							if (competition == null) {
							} else {
								GENRE = 0;
							}
						} else if (rbF.isSelected()) {
							if (competition == null) {
							} else {
								GENRE = 1;
							}
						} else if (rbMi.isSelected()) {
							if (competition == null) {
							} else {
								GENRE = 2;
							}
						}
						if (rbI.isSelected()) {
							if (competition == null) {
							} else {
								TIPO_DISC = false;
							}
						} else if (rbC.isSelected()) {
							if (competition == null) {
							} else {
								TIPO_DISC = true;
							}
						}
						if (rbDistancia.isSelected()) {
							if (competition == null) {
							} else {
								TIPO = 0;
							}
						} else if (rbPontos.isSelected()) {
							if (competition == null) {
							} else {
								TIPO = 2;
							}
						} else if (rbRank.isSelected()) {
							if (competition == null) {
							} else {
								TIPO = 3;
							}
						} else if (rbTempo.isSelected()) {
							if (competition == null) {
							} else {
								TIPO = 1;
							}
						}
						if (rbH.isSelected()) {
							if (competition == null) {
							} else {
								ORD = true;
							}
						} else if (rbL.isSelected()) {
							if (competition == null) {
							} else {
								ORD = false;
							}
						}

						if (cmb_sport.getSelectedItem() != null) {
							Modalidade sport = (Modalidade) cmb_sport.getSelectedItem();
							int index = Main.getModalidades().indexOf(sport);
							MOD = Main.getModalidades().get(index);
						}

						if (editar) {
							competition.setNome(NAME);
							competition.setModalidade(MOD);
							competition.setGenero(GENRE);
							competition.setTipoDisc(TIPO_DISC);
							competition.setTipoClass(TIPO);
							competition.setOrdenacao(ORD);
							JOptionPane.showMessageDialog(AddDados.this, "Competition (" + competition.getNome() + ") was edited successfully!");
						} else {
							Disciplina nova_disciplina = new Disciplina(NAME, MOD, TIPO_DISC, GENRE, ORD, TIPO);
							Main.getDisciplinas().add(nova_disciplina);
							JOptionPane.showMessageDialog(AddDados.this, "Competition (" + nova_disciplina.getNome() + ") was added successfully!");
						}
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(AddDados.this, "That competition already exists!");
						txtName.setText("");
						txtName.requestFocus();
					}
				}
			}

		});

		// Adding to panel
		name_panel.add(lbl_title, BorderLayout.NORTH);
		name_panel.add(lbl_name, BorderLayout.WEST);
		name_panel.add(txtName, BorderLayout.CENTER);

		main_panel.add(name_panel);

		sport_panel.add(lbl_sport, BorderLayout.WEST);
		sport_panel.add(cmb_sport, BorderLayout.CENTER);

		main_panel.add(sport_panel);

		cType_panel.add(rbDistancia);
		cType_panel.add(rbTempo);
		cType_panel.add(rbPontos);
		cType_panel.add(rbRank);

		main_panel.add(cType_panel);

		cGenre_panel.add(rbM);
		cGenre_panel.add(rbF);
		cGenre_panel.add(rbMi);

		main_panel.add(cGenre_panel);

		cTypeCompetition_panel.add(rbI);
		cTypeCompetition_panel.add(rbC);

		main_panel.add(cTypeCompetition_panel);

		cOrdination_panel.add(rbH);
		cOrdination_panel.add(rbL);

		main_panel.add(cOrdination_panel);

		buttons_panel.add(ok);
		buttons_panel.add(clear);

		main_panel.add(buttons_panel);

		di.add(main_panel);
	}

	/**
	 * Creates the form to create a <code>Sport</code> that will be inserted
	 * into the panel <code>spo</code>. This form allows the user to give the
	 * sport a name. This method is really meticulous about the way it reads the
	 * input as it tests if the input matches the desired format.It will not
	 * accept until the user types something that matches the format.
	 */
	private void addSport() {

		// Layout
		spo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
		// Color
		final Color color = Color.white;
		// Panels
		final Painel main_panel = new Painel(img.bg4);
		final JPanel top_panel = new JPanel(new BorderLayout(0, 10));
		final JPanel buttons_panel = new JPanel();
		final JPanel[] panels = { top_panel, buttons_panel };

		// Labels
		final JLabel lbl_title = new JLabel("Sport");
		final JLabel lbl_name = new JLabel("Name:    ");
		final JLabel[] labels = { lbl_title, lbl_name };

		// Buttons
		final Botao ok = new Botao(img.ok, img.ok_o);
		final Botao clear = new Botao(img.clear, img.clear_o);
		final Botao[] botoes = { ok, clear };

		// TextFields
		final JTextField txtSpo = new JTextField(20);
		// If sport is not null it means the user wants to edit that sport
		if (this.sport != null) {
			txtSpo.setText(this.sport.getNome());
		}

		// Customize

		// Layout
		main_panel.setLayout(new BorderLayout(10, 10));

		// Border
		main_panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		top_panel.setBorder(new EmptyBorder(10, 10, 0, 10));

		// Opaque
		main_panel.setOpaque(false);
		setOpaquePanels(panels);

		// Color
		paintLabels(labels, color);

		// Font
		lbl_title.setFont((new Font("Arial", Font.BOLD, 14)));

		// tooltiptext
		txtSpo.setToolTipText("Sport's name");

		// buttons customization
		configButtons(botoes);

		// ActionListeners
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSpo.setText("");
			}
		});

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSpo.equals("")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure there are no empty fields!");
					txtSpo.requestFocus();
				} else if (!((txtSpo.getText().matches("^[A-Za-z]{1,}$")) || (txtSpo.getText().matches("^[A-Za-z-]{1,}[-]{1}[A-Za-z]{1,}$")))) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure the sport field is formatted within the correct format!");
					txtSpo.requestFocus();
				} else if (txtSpo.getText().matches("^[A-Za-z]{1,}$")) {
					String modalidade = corrigirNome(txtSpo.getText());
					if (sportExists(modalidade)) {
						JOptionPane.showMessageDialog(AddDados.this, "That sport already exists!");
						txtSpo.setText("");
						txtSpo.requestFocus();
					} else {
						if (modalidade != null) {
							if (sport == null) {
								Modalidade n_mod = new Modalidade(modalidade);
								Main.getModalidades().add(n_mod);
								JOptionPane.showMessageDialog(AddDados.this, "Sport (" + n_mod + ") was added successfully!");
							} else {
								sport.setNome(modalidade);
								JOptionPane.showMessageDialog(AddDados.this, "Sport was edited successfully!");
							}
							txtSpo.setText("");

						}
					}
				} else if (txtSpo.getText().matches("^[A-Za-z-]{1,}[-]{1}[A-Za-z]{1,}$")) {
					String modalidade = corrigirNomeCar(txtSpo.getText());
					if (sportExists(modalidade)) {
						JOptionPane.showMessageDialog(AddDados.this, "That sport already exists!");
						txtSpo.setText("");
						txtSpo.requestFocus();
					} else {
						if (modalidade != null) {
							Modalidade n_mod = new Modalidade(modalidade);
							Main.getModalidades().add(n_mod);
							JOptionPane.showMessageDialog(AddDados.this, "Sport (" + n_mod + ") was added successfully!");
							txtSpo.setText("");

						}
					}
				}
			}
		});

		// Adding Panels

		top_panel.add(lbl_title, BorderLayout.NORTH);
		top_panel.add(lbl_name, BorderLayout.WEST);
		top_panel.add(txtSpo, BorderLayout.CENTER);

		buttons_panel.add(ok);
		buttons_panel.add(clear);

		main_panel.add(top_panel, BorderLayout.CENTER);
		main_panel.add(buttons_panel, BorderLayout.SOUTH);

		spo.add(main_panel);
	}

}
