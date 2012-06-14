package gui;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

import dados.*;

/**
 * Class that creates a frame with some tabs to let the user choose if he wants
 * to import, export, manually add, manually edit or either get listings and
 * statistics.
 * 
 */
@SuppressWarnings("serial")
public class AppConfig extends JFrame {

	/**
	 * Custom Panel that contains a menu within another panel.
	 * 
	 * @see #addTabs()
	 * 
	 * @see #addPaineis()
	 * 
	 * @see addImports()
	 * 
	 * @see Panel Panel Class
	 */
	private Painel imp;

	/**
	 * Custom Panel that contains a menu within another panel.
	 * 
	 * @see #addTabs()
	 * 
	 * @see #addPaineis()
	 * 
	 * @see addExports()
	 * 
	 * @see Panel Panel Class
	 */
	private Painel exp;

	/**
	 * Custom Panel that contains a menu within another panel.
	 * 
	 * @see #addTabs()
	 * 
	 * @see #addPaineis()
	 * 
	 * @see addAdds()
	 * 
	 * @see Panel Panel Class
	 */
	private Painel add;

	/**
	 * Custom Panel that contains a menu within another panel.
	 * 
	 * @see #addTabs()
	 * 
	 * @see #addPaineis()
	 * 
	 * @see addEdits()
	 * 
	 * @see Panel Panel Class
	 */
	private Painel edit;

	/**
	 * Custom Panel that contains a menu within another panel.
	 * 
	 * @see #addTabs()
	 * 
	 * @see #addPaineis()
	 * 
	 * @see addList()
	 * 
	 * @see Panel Panel Class
	 */
	private Painel list;

	/**
	 * Instance of the class <code>Imagens</code>, used to load images in order
	 * to fill buttons and panels.
	 * 
	 * @see Imagens Imagens Class
	 */
	private Imagens img = new Imagens();

	/**
	 * Instance of the class <code>Csv</code>, used in the method
	 * <code>addImports()</code> and <code>addExport()</code> in order to be
	 * able to import and export files.
	 */
	private final Csv csv = new Csv();

	/**
	 * TabbedPane that will hold various tabs.
	 */
	private JTabbedPane jtp = new JTabbedPane();

	/**
	 * Object AddDados important to control how tabs behave, if the object has
	 * been initialized, that object will be used instead of creating another
	 * one
	 */
	private AddDados a;

	/**
	 * Object AddList important to control how tabs behave, if the object has
	 * been initialized, that object will be used instead of creating another
	 * one
	 */
	private AddList al;

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
	 * @see #addImports()
	 * 
	 * @see #addExports()
	 * 
	 * @see #addEdits()
	 * 
	 * @see #addList()
	 * 
	 * @see #setProperties(int,int,int,boolean)
	 */
	public AppConfig() {

		setTitle("Application Configuration");

		addPaineis();
		addTabs();
		addImports();
		addExports();
		addAdds();
		addEdits();
		addList();
		setProperties(600, 500, 1, true);

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
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			}
		});
	}

	/**
	 * This method adds tabs to the TabbedPane, it is called on the constructor.
	 * 
	 * @see #constructor
	 */
	private void addTabs() {

		getContentPane().add(jtp);

		// Tabs
		jtp.addTab("Import", imp);
		jtp.addTab("Export", exp);
		jtp.addTab("Add", add);
		jtp.addTab("Edit", edit);
		jtp.addTab("List", list);
		jtp.setBackground(new Color(61, 71, 78));
		jtp.setForeground(Color.WHITE);

	}

	/**
	 * This method creates custom panels and sets them as not Opaque, it is
	 * called in the constructor.
	 * 
	 * @see #imp
	 * 
	 * @see #exp
	 * 
	 * @see #add
	 * 
	 * @see #edit
	 * 
	 * @see #list
	 * 
	 * @see javax.swing.JComponent#setOpaque()
	 * 
	 * @see gui.Painel#constructor(URL)
	 * 
	 * @see #constructor
	 */
	private void addPaineis() {

		// Panels
		imp = new Painel(img.bg3);
		exp = new Painel(img.bg3);
		add = new Painel(img.bg3);
		edit = new Painel(img.bg3);
		list = new Painel(img.bg3);

		imp.setOpaque(false);
		exp.setOpaque(false);
		add.setOpaque(false);
		edit.setOpaque(false);
		list.setOpaque(false);

	}

	/**
	 * Returns true if no linked lists needed are empty
	 * 
	 * @return Returns true if no linked lists needed are empty
	 */
	private boolean isReady() {
		return (!Main.getPaises().isEmpty() || !Main.getAtleta().isEmpty() || !Main.getJogos().isEmpty() || !Main.getDisciplinas().isEmpty() || !Main.getModalidades().isEmpty() || !Main.getProvas().isEmpty());
	}

	/**
	 * Has the purpose to create a minimalistic menu, adding a title and
	 * programmed buttons to the <code>list</code> panel. This method is
	 * meticulous about the way tabs behave trying to give the user a smooth
	 * navigation between tabs. It uses the method <code>isReady()</code> in
	 * order to aproach a safer implementation of the method.
	 */
	private void addList() {
		Border emptyBorder = BorderFactory.createEmptyBorder();
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		list.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));

		JPanel p2 = new JPanel(new GridLayout(5, 2, 10, 10));
		p2.setBorder(new EmptyBorder(20, 20, 20, 20));
		p2.setOpaque(false);

		JLabel lb = new JLabel("     Statistics and Listings:");
		lb.setFont((new Font("Arial", Font.BOLD, 14)));
		lb.setForeground(Color.white);

		Botao compAnalysis = new Botao(img.ca);
		compAnalysis.setBotaoRollOver(img.ca_o);
		compAnalysis.setContentAreaFilled(false);
		compAnalysis.setBorder(emptyBorder);
		compAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Main.getPaises().size() >= 5) {
					if (al != null) {
						al.setSelectedIndex(0);
						al.setVisible(true);
					} else {
						al = new AddList();
						al.setSelectedIndex(0);
					}
				} else {
					JOptionPane.showMessageDialog(AppConfig.this, "Make sure you imported countries!");
				}

			}
		});

		Botao rankP = new Botao(img.rn);
		rankP.setBotaoRollOver(img.rn_o);
		rankP.setContentAreaFilled(false);
		rankP.setBorder(emptyBorder);
		rankP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isReady()) {
					if (al != null) {
						al.setSelectedIndex(1);
						al.setVisible(true);
					} else {
						al = new AddList();
						al.setSelectedIndex(1);
					}
				} else {
					JOptionPane.showMessageDialog(AppConfig.this, "Make sure you imported the necessary data!");
				}
			}
		});

		Botao rankA = new Botao(img.ra);
		rankA.setBotaoRollOver(img.ra_o);
		rankA.setContentAreaFilled(false);
		rankA.setBorder(emptyBorder);
		rankA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isReady()) {
					if (al != null) {
						al.setSelectedIndex(2);
						al.setVisible(true);
					} else {
						al = new AddList();
						al.setSelectedIndex(2);
					}
				} else {
					JOptionPane.showMessageDialog(AppConfig.this, "Make sure you imported the necessary data!");
				}
			}
		});

		Botao rankC = new Botao(img.rc);
		rankC.setBotaoRollOver(img.rc_o);
		rankC.setContentAreaFilled(false);
		rankC.setBorder(emptyBorder);
		rankC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isReady()) {
					if (al != null) {
						al.setSelectedIndex(3);
						al.setVisible(true);
					} else {
						al = new AddList();
						al.setSelectedIndex(3);
					}
				} else {
					JOptionPane.showMessageDialog(AppConfig.this, "Make sure you imported the necessary data!");
				}
			}
		});

		Botao rankS = new Botao(img.rs);
		rankS.setBotaoRollOver(img.rs_o);
		rankS.setContentAreaFilled(false);
		rankS.setBorder(emptyBorder);
		rankS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isReady()) {
					if (al != null) {
						al.setSelectedIndex(4);
						al.setVisible(true);
					} else {
						al = new AddList();
						al.setSelectedIndex(4);
					}
				} else {
					JOptionPane.showMessageDialog(AppConfig.this, "Make sure you imported the necessary data!");
				}
			}
		});

		p2.add(compAnalysis);
		p2.add(rankP);
		p2.add(rankA);
		p2.add(rankC);
		p2.add(rankS);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		list.add(p1);

	}

	/**
	 * Has the purpose to create a minimalistic menu, adding a title and
	 * programmed buttons to the <code>imp</code> panel. This method is
	 * meticulous about the way tabs behave trying to give the user a smooth
	 * navigation between tabs. It uses the method <code>isReady()</code> in
	 * order to aproach a safer implementation of the method.
	 */
	private void addImports() {

		Border emptyBorder = BorderFactory.createEmptyBorder();
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		imp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));

		JPanel p2 = new JPanel(new GridLayout(3, 1, 10, 10));
		p2.setBorder(new EmptyBorder(20, 20, 20, 20));
		p2.setOpaque(false);

		JLabel lb = new JLabel("     Import:");
		lb.setFont((new Font("Arial", Font.BOLD, 14)));
		lb.setForeground(Color.white);

		// inteImport!
		Botao intelImport = new Botao(img.intelImport);
		intelImport.setBotaoRollOver(img.intelImport_o);
		intelImport.setContentAreaFilled(false);
		intelImport.setBorder(emptyBorder);
		intelImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.intelImport(null, AppConfig.this, Main.getPaises(), Main.getDisciplinas(), Main.getModalidades(), Main.getJogos(), Main.getProvas(), Main.getEquipas(), Main.getAtleta());

			}
		});

		// dragndrop
		Botao drag = new Botao(img.impdrag);
		drag.setBotaoRollOver(img.impdrag_o);
		drag.setContentAreaFilled(false);
		drag.setBorder(emptyBorder);
		drag.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Drag dragDg = new Drag(AppConfig.this);
				setVisible(true);

			}
		});

		// Countries
		Botao impCountry = new Botao(img.impCountry);
		impCountry.setBotaoRollOver(img.impCountry_o);
		impCountry.setContentAreaFilled(false);
		impCountry.setBorder(emptyBorder);
		impCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importPais(null, AppConfig.this, Main.getPaises());
			}
		});

		// Disciplines
		Botao impDisc = new Botao(img.impDisc);
		impDisc.setBotaoRollOver(img.impDisc_o);
		impDisc.setContentAreaFilled(false);
		impDisc.setBorder(emptyBorder);
		impDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importDisc(null, AppConfig.this, Main.getDisciplinas(), Main.getModalidades());
			}
		});

		// Results
		Botao impResu = new Botao(img.impResu);
		impResu.setBotaoRollOver(img.impResu_o);
		impResu.setContentAreaFilled(false);
		impResu.setBorder(emptyBorder);
		impResu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importResultados(null, AppConfig.this, Main.getAtleta(), Main.getModalidades(), Main.getPaises(), Main.getProvas(), Main.getEquipas(), Main.getJogos());
			}
		});

		// Events
		Botao impEv = new Botao(img.impEv);
		impEv.setBotaoRollOver(img.impEv_o);
		impEv.setContentAreaFilled(false);
		impEv.setBorder(emptyBorder);
		impEv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importProvas(null, AppConfig.this, Main.getJogos(), Main.getProvas(), Main.getDisciplinas(), Main.getModalidades());
			}
		});

		p2.add(intelImport);
		p2.add(drag);
		p2.add(impCountry);
		p2.add(impDisc);
		p2.add(impEv);
		p2.add(impResu);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		imp.add(p1);
	}

	/**
	 * Has the purpose to create a minimalistic menu, adding a title and
	 * programmed buttons to the <code>exp</code> panel. This method is
	 * meticulous about the way tabs behave trying to give the user a smooth
	 * navigation between tabs. It uses the method <code>isReady()</code> in
	 * order to aproach a safer implementation of the method.
	 */
	private void addExports() {

		Border emptyBorder = BorderFactory.createEmptyBorder();
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		exp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));

		JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 10));
		p2.setBorder(new EmptyBorder(20, 20, 20, 20));
		p2.setOpaque(false);

		JLabel lb = new JLabel("     Export:");
		lb.setFont((new Font("Arial", Font.BOLD, 14)));
		lb.setForeground(Color.white);

		// Countries
		Botao expCountry = new Botao(img.expCountry);
		expCountry.setBotaoRollOver(img.expCountry_o);
		expCountry.setContentAreaFilled(false);
		expCountry.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportPais(AppConfig.this, Main.getPaises());
			}
		});

		Botao expCountryHtml = new Botao(img.expCountryHtml);
		expCountryHtml.setBotaoRollOver(img.expCountryHtml_o);
		expCountryHtml.setContentAreaFilled(false);
		expCountryHtml.setBorder(emptyBorder);

		// Disciplines
		Botao expDisc = new Botao(img.expDisc);
		expDisc.setBotaoRollOver(img.expDisc_o);
		expDisc.setContentAreaFilled(false);
		expDisc.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportDisciplina(AppConfig.this, Main.getModalidades());
			}
		});

		Botao expDiscHtml = new Botao(img.expDiscHtml);
		expDiscHtml.setBotaoRollOver(img.expDiscHtml_o);
		expDiscHtml.setContentAreaFilled(false);
		expDiscHtml.setBorder(emptyBorder);

		// Results
		Botao expResu = new Botao(img.expResu);
		expResu.setBotaoRollOver(img.expResu_o);
		expResu.setContentAreaFilled(false);
		expResu.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportResultados(AppConfig.this, Main.getModalidades(), Main.getProvas(), "Gymnastics", 1, 2008);
			}
		});
		// FIXME erro a exportar CSV, adicionar botão competition with event
		// (exportProvas),
		// remover html's, check pre-definidos
		Botao expResuHtml = new Botao(img.expResuHtml);
		expResuHtml.setBotaoRollOver(img.expResuHtml_o);
		expResuHtml.setContentAreaFilled(false);
		expResuHtml.setBorder(emptyBorder);

		p2.add(expCountry);
		p2.add(expCountryHtml);
		p2.add(expDisc);
		p2.add(expDiscHtml);
		p2.add(expResu);
		p2.add(expResuHtml);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		exp.add(p1);
	}

	/**
	 * Has the purpose to create a minimalistic menu, adding a title and
	 * programmed buttons to the <code>add</code> panel. This method is
	 * meticulous about the way tabs behave trying to give the user a smooth
	 * navigation between tabs. It uses the method <code>isReady()</code> in
	 * order to aproach a safer implementation of the method.
	 */
	private void addAdds() {

		Border emptyBorder = BorderFactory.createEmptyBorder();
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		add.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));

		JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 10));
		p2.setBorder(new EmptyBorder(20, 20, 20, 20));
		p2.setOpaque(false);

		JLabel lb = new JLabel("     Add:");
		lb.setFont((new Font("Arial", Font.BOLD, 14)));
		lb.setForeground(Color.white);

		Botao addCo = new Botao(img.addCo);
		addCo.setBotaoRollOver(img.addCo_o);
		addCo.setContentAreaFilled(false);
		addCo.setBorder(emptyBorder);
		addCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a != null) {
					a.setSelectedIndex(0);
					a.setVisible(true);
				} else {
					a = new AddDados();
					a.setSelectedIndex(0);
				}
			}

		});

		Botao addDis = new Botao(img.addDis);
		addDis.setBotaoRollOver(img.addDis_o);
		addDis.setContentAreaFilled(false);
		addDis.setBorder(emptyBorder);
		addDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a != null) {
					a.setSelectedIndex(1);
					a.setVisible(true);
				} else {
					a = new AddDados();
					a.setSelectedIndex(1);
				}
			}
		});

		Botao addSpo = new Botao(img.addSpo);
		addSpo.setBotaoRollOver(img.addSpo_o);
		addSpo.setContentAreaFilled(false);
		addSpo.setBorder(emptyBorder);
		addSpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a != null) {
					a.setSelectedIndex(2);
					a.setVisible(true);
				} else {
					a = new AddDados();
					a.setSelectedIndex(2);
				}
			}
		});

		p2.add(addCo);
		p2.add(addDis);
		p2.add(addSpo);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		add.add(p1);

	}

	/**
	 * Has the purpose to create a minimalistic menu, adding a title and
	 * programmed buttons to the <code>edit</code> panel. This method is
	 * meticulous about the way tabs behave trying to give the user a smooth
	 * navigation between tabs. It uses the method <code>isReady()</code> in
	 * order to aproach a safer implementation of the method.
	 */
	private void addEdits() {

		Border emptyBorder = BorderFactory.createEmptyBorder();
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		edit.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));

		JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 10));
		p2.setBorder(new EmptyBorder(20, 20, 20, 20));
		p2.setOpaque(false);

		JLabel lb = new JLabel("     Edit:");
		lb.setFont((new Font("Arial", Font.BOLD, 14)));
		lb.setForeground(Color.white);

		Botao editCo = new Botao(img.editCo);
		editCo.setBotaoRollOver(img.editCo_o);
		editCo.setContentAreaFilled(false);
		editCo.setBorder(emptyBorder);
		editCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: não implementado
			}
		});

		Botao editDis = new Botao(img.editDis);
		editDis.setBotaoRollOver(img.editDis_o);
		editDis.setContentAreaFilled(false);
		editDis.setBorder(emptyBorder);
		editDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: não implementado
			}
		});

		Botao editSpo = new Botao(img.editSpo);
		editSpo.setBotaoRollOver(img.editSpo_o);
		editSpo.setContentAreaFilled(false);
		editSpo.setBorder(emptyBorder);
		editSpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: não implementado
			}
		});

		p2.add(editCo);
		p2.add(editDis);
		p2.add(editSpo);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		edit.add(p1);
	}

}
