package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import jogosolimpicos.*;

/*
 * Class that creates a frame to add data manually, an instance of this class is created on the class AppConfig.
 * 
 */
public class AddDados extends JFrame {

	/*
	 * Custom Panel that contains a form within another panel.
	 * 
	 * @see Panel Panel Class
	 */
	private Painel co;
	/*
	 * Custom Panel that contains a form within another panel.
	 * 
	 * @see Panel Panel Class
	 */
	private Painel di;
	/*
	 * Custom Panel that contains a form within another panel.
	 * 
	 * @see Panel Panel Class
	 */
	private Painel spo;
	/*
	 * Custom Panel that contains a form within another panel.
	 * 
	 * @see Panel Panel Class
	 */
	private Imagens img = new Imagens();
	/*
	 * Custom Panel that contains a form within another panel.
	 * 
	 * @see Panel Panel Class
	 */
	private JTabbedPane jtp = new JTabbedPane();

	/*
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
	 * @see #addCountry()
	 * 
	 * @see #addDiscipline()
	 * 
	 * @see #addSport()
	 * 
	 * @see #setProperties(int,int,int,boolean)
	 */
	public AddDados() {
		super("Add Info");

		addPaineis();
		addTabs();

		addCountry();
		addDiscipline();
		addSport();

		setProperties(600, 480, 1, true);
	}

	/*
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
	 * @param w the desired width to the window
	 * 
	 * @param h the desired height to the window
	 * 
	 * @param opcao parameter to use when calling
	 * javax.swing.JFrame#setDefaultCloseOperation(int)
	 * 
	 * @param visible sets the windows to visible if the parameter is true
	 */
	private void setProperties(int w, int h, int opcao, boolean visible) {
		setSize(w, h);
		setDefaultCloseOperation(opcao);
		setVisible(visible);
	}

	/*
	 * Sets the selected index of the <code>TabbedPane/<code>, this method is
	 * for exterior use and it is used in the class <code>AppConfig</code>.
	 * 
	 * @see AppConfig used in this class
	 * 
	 * @param i index of the tab
	 */
	public void setSelectedIndex(int i) {
		jtp.setSelectedIndex(i);
	}

	/*
	 * This method adds tabs to the TabbedPane, it is called on the constructor.
	 * 
	 * @see #constructor
	 */
	private void addTabs() {

		getContentPane().add(jtp);
		// Tabs
		jtp.addTab("Country", co);
		jtp.addTab("Discipline", di);
		jtp.addTab("Sport", spo);

	}

	/*
	 * This method creates custom panels and sets them as not Opaque, it is
	 * called in the constructor.
	 * 
	 * @see #co
	 * 
	 * @see #di
	 * 
	 * @see #spo
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
		co = new Painel(img.bg3);
		di = new Painel(img.bg3);
		spo = new Painel(img.bg3);

		co.setOpaque(false);
		di.setOpaque(false);
		spo.setOpaque(false);
	}

	/*
	 * Creates the form to create a <code>Country</code> that will be inserted
	 * into the panel <code>co</code>. This form allows the user to give the
	 * country a name and its correspondent code. This method is really
	 * meticulous about the way it reads the input as it tests if the input
	 * matches the desired format.It will not accept until the user types
	 * something that matches the format.
	 */
	private void addCountry() {
		CardLayout cl = new CardLayout();
		JPanel card = new JPanel(cl);
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
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
		panel1.add(b, BorderLayout.WEST);
		final JTextField txtName = new JTextField(20);
		txtName.setToolTipText("Country's name.");
		panel1.add(txtName, BorderLayout.CENTER);

		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setOpaque(false);
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));

		JLabel c = new JLabel("    Code:  ");
		c.setForeground(Color.white);
		panel2.add(c, BorderLayout.WEST);
		final JTextField txtCode = new JTextField(20);
		txtCode.setToolTipText("Country's code.");
		panel2.add(txtCode, BorderLayout.CENTER);
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

		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtCode.setText("");

			}
		});

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.equals("")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure there are no empty fields!");
					txtName.requestFocus();
				} else if (txtCode.equals("")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure there are no empty fields!");
					txtCode.requestFocus();
				} else if (!txtCode.getText().matches("^[A-Z]{3}$")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure the code field is formatted within the correct format!");
					txtCode.requestFocus();
				} else if (!txtName.getText().matches("^[A-Za-z]{1,}$")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure the name field is formatted within the correct format!");
					txtName.requestFocus();
				} else if (codeExists(txtCode.getText())) {
					JOptionPane.showMessageDialog(AddDados.this, "That code already exists!");
					txtCode.requestFocus();
				} else if (codeExists(txtName.getText())) {
					JOptionPane.showMessageDialog(AddDados.this, "That name already exists!");
					txtName.requestFocus();
				} else {
					Pais pais = new Pais(txtCode.getText(), corrigirNome(txtName.getText()));
					Main.getPaises().add(pais);
					JOptionPane.showMessageDialog(AddDados.this, "Country (" + pais + ") was added successfully!");
					txtName.setText("");
					txtCode.setText("");
				}
			}
		});
		p1.add(panel1, BorderLayout.NORTH);
		p1.add(panel2, BorderLayout.CENTER);
		p1.add(panel3, BorderLayout.SOUTH);
		co.add(p1);

	}

	/*
	 * Creates the form to create a <code>Competition</code> that will be
	 * inserted into the panel <code>di</code>. This form allows the user to
	 * give the competition a name, to choose its correspondent sport. This
	 * method is really meticulous about the way it reads the input as it tests
	 * if the input matches the desired format.It will not accept until the user
	 * types something that matches the format.
	 */
	private void addDiscipline() {
		di.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));

		Painel panel = new Painel(img.bg4);
		panel.setLayout(new GridLayout(7, 1));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
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
		final JComboBox<?> cmbDiscipline = new JComboBox<Object>(Main.getModalidades().toArray());
		cmbDiscipline.setToolTipText("Discipline's Sport.");
		panel6.add(cmbDiscipline, BorderLayout.CENTER);
		panel.add(panel6);

		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setBorder(new EmptyBorder(10, 10, 0, 10));
		ButtonGroup btngrp = new ButtonGroup();
		final JRadioButton rbDistancia = new JRadioButton("Distance", true);
		final JRadioButton rbTempo = new JRadioButton("Time", false);
		final JRadioButton rbPontos = new JRadioButton("Score", false);
		final JRadioButton rbRank = new JRadioButton("Rank", false);

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
		final JRadioButton rbM = new JRadioButton("Male", true);
		final JRadioButton rbF = new JRadioButton("Female", false);
		final JRadioButton rbMi = new JRadioButton("Mixed", false);

		rbM.setOpaque(false);
		rbM.setForeground(Color.white);
		rbF.setOpaque(false);
		rbF.setForeground(Color.white);
		rbMi.setOpaque(false);
		rbMi.setForeground(Color.white);

		btngrp2.add(rbM);
		btngrp2.add(rbF);
		btngrp2.add(rbMi);

		panel4.add(rbM);
		panel4.add(rbF);
		panel4.add(rbMi);
		panel.add(panel4);

		JPanel panel7 = new JPanel();
		panel7.setOpaque(false);
		ButtonGroup btngrp3 = new ButtonGroup();
		final JRadioButton rbI = new JRadioButton("Individual", true);
		final JRadioButton rbC = new JRadioButton("Colective", false);

		rbI.setOpaque(false);
		rbI.setForeground(Color.white);
		rbC.setOpaque(false);
		rbC.setForeground(Color.white);

		btngrp3.add(rbI);
		btngrp3.add(rbC);

		panel7.add(rbI);
		panel7.add(rbC);
		panel.add(panel7);

		JPanel panel8 = new JPanel();
		panel8.setOpaque(false);
		ButtonGroup btngrp4 = new ButtonGroup();
		final JRadioButton rbH = new JRadioButton("Highest", true);
		final JRadioButton rbL = new JRadioButton("Lowest", false);

		rbH.setOpaque(false);
		rbH.setForeground(Color.white);
		rbL.setOpaque(false);
		rbL.setForeground(Color.white);

		btngrp4.add(rbH);
		btngrp4.add(rbL);

		panel8.add(rbH);
		panel8.add(rbL);
		panel.add(panel8);

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

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.equals("")) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure there are no empty fields!");
					txtName.requestFocus();
				} else if (!((txtName.getText().matches("^[A-Za-z]{1,}$")) || (txtName.getText().matches("^[A-Za-z-]{1,}[-]{1}[A-Za-z]{1,}$")))) {
					JOptionPane.showMessageDialog(AddDados.this, "Make sure the name field is formatted within the correct format!");
					txtName.requestFocus();
				} else if (txtName.getText().matches("^[A-Za-z]{1,}$")) {
					String comp = corrigirNome(txtName.getText());
					if (comp != null) {
						Disciplina comp_ = new Disciplina(comp);
						if (rbM.isSelected()) {
							comp_.setGenero(0);
						} else if (rbF.isSelected()) {
							comp_.setGenero(1);
						} else if (rbMi.isSelected()) {
							comp_.setGenero(2);
						}
						if (rbI.isSelected()) {
							comp_.setTipoDisc(false);
						} else if (rbC.isSelected()) {
							comp_.setTipoDisc(true);
						}
						if (rbDistancia.isSelected()) {
							comp_.setTipoClass(0);
						} else if (rbPontos.isSelected()) {
							comp_.setTipoClass(2);
						} else if (rbRank.isSelected()) {
							comp_.setTipoClass(3);
						} else if (rbTempo.isSelected()) {
							comp_.setTipoClass(1);

						}
						if (rbH.isSelected()) {
							comp_.setOrdenacao(true);
						} else if (rbL.isSelected()) {
							comp_.setOrdenacao(false);
						}

						if (cmbDiscipline.getSelectedItem() != null) {
							int index = Main.getModalidades().indexOf((Modalidade) cmbDiscipline.getSelectedItem());
							comp_.setModalidade(Main.getModalidades().get(index));
						}
						if (competitionExists(comp_)) {
							JOptionPane.showMessageDialog(AddDados.this, "That competition already exists!");
							txtName.setText("");
							txtName.requestFocus();
						} else {
							Main.getDisciplinas().add(comp_);
							JOptionPane.showMessageDialog(AddDados.this, "Competition (" + comp_ + ") was added successfully!");
							txtName.setText("");

						}
					}
				} else if (txtName.getText().matches("^[A-Za-z-]{1,}[-]{1}[A-Za-z]{1,}$")) {
					String comp = corrigirNomeCar(txtName.getText());

					Disciplina comp_ = new Disciplina(comp);
					if (rbM.isSelected()) {
						comp_.setGenero(0);
					} else if (rbF.isSelected()) {
						comp_.setGenero(1);
					} else if (rbMi.isSelected()) {
						comp_.setGenero(2);
					}
					if (rbI.isSelected()) {
						comp_.setTipoDisc(false);
					} else if (rbC.isSelected()) {
						comp_.setTipoDisc(true);
					}
					if (rbDistancia.isSelected()) {
						comp_.setTipoClass(0);
					} else if (rbPontos.isSelected()) {
						comp_.setTipoClass(2);
					} else if (rbRank.isSelected()) {
						comp_.setTipoClass(3);
					} else if (rbTempo.isSelected()) {
						comp_.setTipoClass(1);

					}
					if (rbH.isSelected()) {
						comp_.setOrdenacao(true);
					} else if (rbL.isSelected()) {
						comp_.setOrdenacao(false);
					}

					if (cmbDiscipline.getSelectedItem() != null) {
						int index = Main.getModalidades().indexOf((Modalidade) cmbDiscipline.getSelectedItem());
						comp_.setModalidade(Main.getModalidades().get(index));
					}
					if (competitionExists(comp_)) {
						JOptionPane.showMessageDialog(AddDados.this, "That competition already exists!");
						txtName.setText("");
						txtName.requestFocus();
					} else {
						Main.getDisciplinas().add(comp_);
						JOptionPane.showMessageDialog(AddDados.this, "Competition (" + comp_ + ") was added successfully!");
						txtName.setText("");
					}

				}

			}
		});

		panel.add(panel5);

		di.add(panel);
	}

	/*
	 * Creates the form to create a <code>Sport</code> that will be inserted
	 * into the panel <code>spo</code>. This form allows the user to give the
	 * sport a name. This method is really meticulous about the way it reads the
	 * input as it tests if the input matches the desired format.It will not
	 * accept until the user types something that matches the format.
	 */
	private void addSport() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
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
		final JTextField txtSpo = new JTextField(20);
		txtSpo.setToolTipText("Sport's name");
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
							Modalidade n_mod = new Modalidade(modalidade);
							Main.getModalidades().add(n_mod);
							JOptionPane.showMessageDialog(AddDados.this, "Sport (" + n_mod + ") was added successfully!");
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

		p1.add(panel1, BorderLayout.CENTER);
		p1.add(panel3, BorderLayout.SOUTH);
		spo.add(p1);
	}

	/*
	 * Returns true if there is already a country with the code equal to the
	 * code in the parameter.
	 * 
	 * @return Returns true if there is already a country with the code equal to
	 * the code in the parameter
	 */
	private boolean codeExists(String code) {
		for (int i = 0; i < Main.getPaises().size(); i++) {
			if (Main.getPaises().get(i).getCodigoPais(0).equalsIgnoreCase(code))
				return true;
		}
		return false;
	}

	/*
	 * Returns true if there is already a sport with the name equal to the name
	 * in the parameter.
	 * 
	 * @return Returns true if there is already a sport with the name equal to
	 * the name in the parameter
	 */
	private boolean sportExists(String sport) {
		for (int i = 0; i < Main.getModalidades().size(); i++) {
			if (Main.getModalidades().get(i).getNome().equalsIgnoreCase(sport))
				return true;
		}
		return false;
	}

	/*
	 * Returns true if there is already a competition equal to the the parameter
	 * 
	 * @return Returns true if there is already a competition equal to the the
	 * parameter
	 */
	private boolean competitionExists(Disciplina a) {
		for (int i = 0; i < Main.getDisciplinas().size(); i++) {
			if (Main.getDisciplinas().get(i).equals(a))
				return true;
		}
		return false;
	}

	/*
	 * Returns true if there is already a country with the name equal to the
	 * name in the parameter.
	 * 
	 * @return Returns true if there is already a country with the name equal to
	 * the name in the parameter
	 */
	private boolean nameExists(String name) {
		for (int i = 0; i < Main.getPaises().size(); i++) {
			if (Main.getPaises().get(i).getNomePais().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

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
}
