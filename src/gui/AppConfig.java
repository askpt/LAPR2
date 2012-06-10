package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import dados.*;

public class AppConfig extends JFrame {

	private Painel imp, exp, add, edit, remove, reg, list;

	private Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JTabbedPane jtp = new JTabbedPane();
	private AddDados a;
	private RemDados r;
	private AddRegs re;
	private AddList al;

	public AppConfig() {

		setTitle("Application Configuration");

		addPaineis();
		addTabs();
		addImports();
		addExports();
		addAdds();
		addEdits();
		addRemoves();
		addRegs();
		addList();
		setProperties(600, 400, 1, true);

	}

	private void setProperties(int w, int h, int opcao, boolean visible) {
		setSize(w, h);
		setDefaultCloseOperation(opcao);
		setVisible(visible);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			}
		});
	}

	private void addTabs() {

		getContentPane().add(jtp);

		// Tabs
		jtp.addTab("Import", imp);
		jtp.addTab("Export", exp);
		jtp.addTab("Add", add);
		jtp.addTab("Edit", edit);
		jtp.addTab("Remove", remove);
		jtp.addTab("Register", reg);
		jtp.addTab("List", list);
		jtp.setBackground(new Color(61, 71, 78));
		jtp.setForeground(Color.WHITE);
	}

	private void addPaineis() {

		// Panels
		imp = new Painel(img.bg3);
		exp = new Painel(img.bg3);
		add = new Painel(img.bg3);
		edit = new Painel(img.bg3);
		remove = new Painel(img.bg3);
		reg = new Painel(img.bg3);
		list = new Painel(img.bg3);

		imp.setOpaque(false);
		exp.setOpaque(false);
		add.setOpaque(false);
		edit.setOpaque(false);
		remove.setOpaque(false);
		reg.setOpaque(false);
		list.setOpaque(false);
	}

	private void addList() {

		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		list.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));

		JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 10));
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
				if (al != null) {
					al.setSelectedIndex(0);
					al.setVisible(true);
				} else {
					al = new AddList();
					al.setSelectedIndex(0);
				}
			}
		});

		Botao rankP = new Botao(img.rn);
		rankP.setBotaoRollOver(img.rn_o);
		rankP.setContentAreaFilled(false);
		rankP.setBorder(emptyBorder);
		rankP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (al != null) {
					al.setSelectedIndex(1);
					al.setVisible(true);
				} else {
					al = new AddList();
					al.setSelectedIndex(1);
				}
			}
		});

		Botao rankA = new Botao(img.ra);
		rankA.setBotaoRollOver(img.ra_o);
		rankA.setContentAreaFilled(false);
		rankA.setBorder(emptyBorder);
		rankA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (al != null) {
					al.setSelectedIndex(2);
					al.setVisible(true);
				} else {
					al = new AddList();
					al.setSelectedIndex(2);
				}
			}
		});

		p2.add(compAnalysis);
		p2.add(rankP);
		p2.add(rankA);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		list.add(p1);

	}

	private void addImports() {

		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		imp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));

		JPanel p2 = new JPanel(new GridLayout(4, 2, 10, 10));
		p2.setBorder(new EmptyBorder(20, 20, 20, 20));
		p2.setOpaque(false);

		JLabel lb = new JLabel("     Import:");
		lb.setFont((new Font("Arial", Font.BOLD, 14)));
		lb.setForeground(Color.white);

		// Countries
		Botao impCountry = new Botao(img.impCountry);
		impCountry.setBotaoRollOver(img.impCountry_o);
		impCountry.setContentAreaFilled(false);
		impCountry.setBorder(emptyBorder);
		impCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importPais(AppConfig.this, Main.getPaises());
			}
		});

		// Disciplines
		Botao impDisc = new Botao(img.impDisc);
		impDisc.setBotaoRollOver(img.impDisc_o);
		impDisc.setContentAreaFilled(false);
		impDisc.setBorder(emptyBorder);
		impDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importDisc(AppConfig.this, Main.getDisciplinas(), Main.getModalidades());
			}
		});

		// Results
		Botao impResu = new Botao(img.impResu);
		impResu.setBotaoRollOver(img.impResu_o);
		impResu.setContentAreaFilled(false);
		impResu.setBorder(emptyBorder);
		impResu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importResultados(AppConfig.this, Main.getAtleta(), Main.getModalidades(), Main.getPaises(), Main.getProvas(), Main.getEquipas(), Main.getJogos());
			}
		});

		// Events
		Botao impEv = new Botao(img.impEv);
		impEv.setBotaoRollOver(img.impEv_o);
		impEv.setContentAreaFilled(false);
		impEv.setBorder(emptyBorder);
		impEv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importProvas(AppConfig.this, Main.getJogos(), Main.getProvas(), Main.getDisciplinas(), Main.getModalidades());
			}
		});

		p2.add(impCountry);
		p2.add(impDisc);
		p2.add(impEv);
		p2.add(impResu);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		imp.add(p1);
	}

	private void addExports() {

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

	private void addAdds() {
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

		Botao addJO = new Botao(img.addJO);
		addJO.setBotaoRollOver(img.addJO_o);
		addJO.setContentAreaFilled(false);
		addJO.setBorder(emptyBorder);
		addJO.addActionListener(new ActionListener() {
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

		Botao addCo = new Botao(img.addCo);
		addCo.setBotaoRollOver(img.addCo_o);
		addCo.setContentAreaFilled(false);
		addCo.setBorder(emptyBorder);
		addCo.addActionListener(new ActionListener() {
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

		Botao addDis = new Botao(img.addDis);
		addDis.setBotaoRollOver(img.addDis_o);
		addDis.setContentAreaFilled(false);
		addDis.setBorder(emptyBorder);
		addDis.addActionListener(new ActionListener() {
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

		Botao addSpo = new Botao(img.addSpo);
		addSpo.setBotaoRollOver(img.addSpo_o);
		addSpo.setContentAreaFilled(false);
		addSpo.setBorder(emptyBorder);
		addSpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a != null) {
					a.setSelectedIndex(3);
					a.setVisible(true);
				} else {
					a = new AddDados();
					a.setSelectedIndex(3);
				}
			}
		});

		Botao addEv = new Botao(img.addEv);
		addEv.setBotaoRollOver(img.addEv_o);
		addEv.setContentAreaFilled(false);
		addEv.setBorder(emptyBorder);
		addEv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a != null) {
					a.setSelectedIndex(4);
					a.setVisible(true);
				} else {
					a = new AddDados();
					a.setSelectedIndex(4);
				}
			}
		});

		Botao addAth = new Botao(img.addAth);
		addAth.setBotaoRollOver(img.addAth_o);
		addAth.setContentAreaFilled(false);
		addAth.setBorder(emptyBorder);
		addAth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a != null) {
					a.setSelectedIndex(5);
					a.setVisible(true);
				} else {
					a = new AddDados();
					a.setSelectedIndex(5);
				}
			}
		});

		p2.add(addJO);
		p2.add(addCo);
		p2.add(addDis);
		p2.add(addSpo);
		p2.add(addEv);
		p2.add(addAth);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		add.add(p1);

	}

	private void addEdits() {

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
		Botao editJO = new Botao(img.editJO);
		editJO.setBotaoRollOver(img.editJO_o);
		editJO.setContentAreaFilled(false);
		editJO.setBorder(emptyBorder);
		editJO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FIXME: array so para testes
				// if ( !Main.getJogos().isEmpty()){}
				String[] edition = { "Barcelona, 1992", "London, 2012" };
				// JogosOlimpicos jo = (JogosOlimpicos) ...
				String b = (String) JOptionPane.showInputDialog(AppConfig.this, "Choose the Edition you want to modify:", "Edit Olympic Games Edition", JOptionPane.PLAIN_MESSAGE, new ImageIcon(img.calendar), edition, edition[0]);
				/*
				 * boolean valido = true; for(int i = 0; i < Main.getProvas();
				 * i++{ if(jo.getCidade().equals(Main.gerProvas().get(i).
				 * getJogosOlimpicos.getCidade()){ TODO: Mensagem de erro a
				 * informar que nao pode editar esta edicao dos jogos, pois ha
				 * provas registadas nela valido = false; break; } }
				 */
				// if (valido){}

			}
		});

		Botao editCo = new Botao(img.editCo);
		editCo.setBotaoRollOver(img.editCo_o);
		editCo.setContentAreaFilled(false);
		editCo.setBorder(emptyBorder);
		editCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FIXME:
				String[] atletas = { "Portugal", "Espanha", "Franca" };
				String atleta = (String) JOptionPane.showInputDialog(AppConfig.this, "Choose the country:", "Edit Country", JOptionPane.PLAIN_MESSAGE, new ImageIcon(img.flag), atletas, atletas[0]);

			}
		});

		Botao editDis = new Botao(img.editDis);
		editDis.setBotaoRollOver(img.editDis_o);
		editDis.setContentAreaFilled(false);
		editDis.setBorder(emptyBorder);
		editDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FIXME:
				String[] atletas = { "Bolt", "Boltas", "Boltes" };
				String atleta = (String) JOptionPane.showInputDialog(AppConfig.this, "Choose the discipline:", "Edit Discipline", JOptionPane.PLAIN_MESSAGE, new ImageIcon(img.sport), atletas, atletas[0]);

			}
		});

		Botao editSpo = new Botao(img.editSpo);
		editSpo.setBotaoRollOver(img.editSpo_o);
		editSpo.setContentAreaFilled(false);
		editSpo.setBorder(emptyBorder);
		editSpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FIXME:
				String[] atletas = { "Bolt", "Boltas", "Boltes" };
				String atleta = (String) JOptionPane.showInputDialog(AppConfig.this, "Choose the sport:", "Edit Sport", JOptionPane.PLAIN_MESSAGE, new ImageIcon(img.sport), atletas, atletas[0]);

			}
		});

		Botao editEv = new Botao(img.editEv);
		editEv.setBotaoRollOver(img.editEv_o);
		editEv.setContentAreaFilled(false);
		editEv.setBorder(emptyBorder);
		editEv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FIXME:
				String[] atletas = { "Bolt", "Boltas", "Boltes" };
				String atleta = (String) JOptionPane.showInputDialog(AppConfig.this, "Choose the event:", "Edit Event", JOptionPane.PLAIN_MESSAGE, new ImageIcon(img.event), atletas, atletas[0]);

			}
		});

		Botao editAth = new Botao(img.editAth);
		editAth.setBotaoRollOver(img.editAth_o);
		editAth.setContentAreaFilled(false);
		editAth.setBorder(emptyBorder);
		editAth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FIXME: Lista de atletas
				String[] atletas = { "Bolt", "Boltas", "Boltes" };
				if (atletas.length > 0) {
					String atleta = (String) JOptionPane.showInputDialog(AppConfig.this, "Choose the athlete:", "Edit Athlete", JOptionPane.PLAIN_MESSAGE, new ImageIcon(img.user), atletas, atletas[0]);
				}

			}
		});

		p2.add(editJO);
		p2.add(editCo);
		p2.add(editDis);
		p2.add(editSpo);
		p2.add(editEv);
		p2.add(editAth);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		edit.add(p1);
	}

	private void addRemoves() {

		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		remove.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));

		JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 10));
		p2.setBorder(new EmptyBorder(20, 20, 20, 20));
		p2.setOpaque(false);

		JLabel lb = new JLabel("     Remove:");
		lb.setFont((new Font("Arial", Font.BOLD, 14)));
		lb.setForeground(Color.white);

		Botao removeJO = new Botao(img.removeJO);
		removeJO.setBotaoRollOver(img.removeJO_o);
		removeJO.setContentAreaFilled(false);
		removeJO.setBorder(emptyBorder);
		removeJO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (r != null) {
					r.setSelectedIndex(0);
					r.setVisible(true);
				} else {
					r = new RemDados();
					r.setSelectedIndex(0);
				}
			}
		});

		Botao removeCo = new Botao(img.removeCo);
		removeCo.setBotaoRollOver(img.removeCo_o);
		removeCo.setContentAreaFilled(false);
		removeCo.setBorder(emptyBorder);
		removeCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (r != null) {
					r.setSelectedIndex(1);
					r.setVisible(true);
				} else {
					r = new RemDados();
					r.setSelectedIndex(1);
				}
			}
		});

		Botao removeDis = new Botao(img.removeDis);
		removeDis.setBotaoRollOver(img.removeDis_o);
		removeDis.setContentAreaFilled(false);
		removeDis.setBorder(emptyBorder);
		removeDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (r != null) {
					r.setSelectedIndex(2);
					r.setVisible(true);
				} else {
					r = new RemDados();
					r.setSelectedIndex(2);
				}
			}
		});

		Botao removeSpo = new Botao(img.removeSpo);
		removeSpo.setBotaoRollOver(img.removeSpo_o);
		removeSpo.setContentAreaFilled(false);
		removeSpo.setBorder(emptyBorder);
		removeSpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (r != null) {
					r.setSelectedIndex(3);
					r.setVisible(true);
				} else {
					r = new RemDados();
					r.setSelectedIndex(3);
				}
			}
		});

		Botao removeEv = new Botao(img.removeEv);
		removeEv.setBotaoRollOver(img.removeEv_o);
		removeEv.setContentAreaFilled(false);
		removeEv.setBorder(emptyBorder);
		removeEv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (r != null) {
					r.setSelectedIndex(4);
					r.setVisible(true);
				} else {
					r = new RemDados();
					r.setSelectedIndex(4);
				}
			}
		});

		Botao removeAth = new Botao(img.removeAth);
		removeAth.setBotaoRollOver(img.removeAth_o);
		removeAth.setContentAreaFilled(false);
		removeAth.setBorder(emptyBorder);
		removeAth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (r != null) {
					r.setSelectedIndex(5);
					r.setVisible(true);
				} else {
					r = new RemDados();
					r.setSelectedIndex(5);
				}
			}
		});

		p2.add(removeJO);
		p2.add(removeCo);
		p2.add(removeDis);
		p2.add(removeSpo);
		p2.add(removeEv);
		p2.add(removeAth);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		remove.add(p1);
	}

	private void addRegs() {
		Painel p1 = new Painel(img.bg4);
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(20, 20, 20, 20));
		p1.setOpaque(false);
		reg.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));

		JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 10));
		p2.setBorder(new EmptyBorder(20, 20, 20, 20));
		p2.setOpaque(false);

		JLabel lb = new JLabel("     Register:");
		lb.setFont((new Font("Arial", Font.BOLD, 14)));
		lb.setForeground(Color.white);

		Botao regAtToTeam = new Botao(img.regAt);
		regAtToTeam.setBotaoRollOver(img.regAt_o);
		regAtToTeam.setContentAreaFilled(false);
		regAtToTeam.setToolTipText("Add athlete to a team.");
		regAtToTeam.setBorder(emptyBorder);
		regAtToTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (re != null) {
					re.setSelectedIndex(0);
					re.setVisible(true);
				} else {
					re = new AddRegs();
					re.setSelectedIndex(0);
				}
			}
		});

		Botao regResult = new Botao(img.regRe);
		regResult.setBotaoRollOver(img.regRe_o);
		regResult.setContentAreaFilled(false);
		regResult.setToolTipText("Register athlete's result.");
		regResult.setBorder(emptyBorder);
		regResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (re != null) {
					re.setSelectedIndex(1);
					re.setVisible(true);
				} else {
					re = new AddRegs();
					re.setSelectedIndex(1);
				}
			}
		});

		Botao regResultTeam = new Botao(img.regReTeam);
		regResultTeam.setBotaoRollOver(img.regReTeam_o);
		regResultTeam.setContentAreaFilled(false);
		regResultTeam.setToolTipText("Register team's result.");
		regResultTeam.setBorder(emptyBorder);
		regResultTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (re != null) {
					re.setSelectedIndex(2);
					re.setVisible(true);
				} else {
					re = new AddRegs();
					re.setSelectedIndex(2);
				}
			}
		});

		p2.add(regAtToTeam);
		p2.add(regResult);
		p2.add(regResultTeam);
		p1.add(lb, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.SOUTH);
		reg.add(p1);

	}
}
