package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import jogosolimpicos.*;
import dados.*;

public class AppConfig extends JFrame {

	private Painel imp, exp, add, edit, remove;

	private Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private JTabbedPane jtp = new JTabbedPane();

	public AppConfig() {

		setTitle("Application Configuration");

		addPaineis();
		addTabs();
		addImports();
		addExports();
		addAdds();
		addEdits();
		addRemoves();
		setProperties(400, 400, 1, true);

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

	}

	private void addPaineis() {

		// Panels
		imp = new Painel(img.imp);
		exp = new Painel(img.exp);
		add = new Painel(img.add);
		edit = new Painel(img.edit);
		remove = new Painel(img.remove);

		imp.setOpaque(false);
		exp.setOpaque(false);
		add.setOpaque(false);
		edit.setOpaque(false);
		remove.setOpaque(false);
	}

	private void addImports() {

		JPanel p1 = new JPanel(new GridLayout(3, 2, 10, 10));
		p1.setOpaque(false);
		imp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		// Countries
		Botao impCountry = new Botao(img.impCountry);
		impCountry.setContentAreaFilled(false);
		impCountry.setBorder(emptyBorder);
		impCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importPais(AppConfig.this, Main.getPaises());
			}
		});

		Botao impCountryHtml = new Botao(img.impCountryHtml);
		impCountryHtml.setContentAreaFilled(false);
		impCountryHtml.setBorder(emptyBorder);

		// Disciplines
		Botao impDisc = new Botao(img.impDisc);
		impDisc.setContentAreaFilled(false);
		impDisc.setBorder(emptyBorder);
		impDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importDisc(AppConfig.this, Main.getDisciplinas(), Main.getModalidades());
			}
		});

		Botao impDiscHtml = new Botao(img.impDiscHtml);
		impDiscHtml.setContentAreaFilled(false);
		impDiscHtml.setBorder(emptyBorder);

		// Results
		Botao impResu = new Botao(img.impResu);
		impResu.setContentAreaFilled(false);
		impResu.setBorder(emptyBorder);
		impResu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importResultados(AppConfig.this, Main.getAtleta(), Main.getModalidades(), Main.getPaises(), Main.getProvas(), Main.getEquipas(), Main.getJogos());
			}
		});

		Botao impResuHtml = new Botao(img.impResuHtml);
		impResuHtml.setContentAreaFilled(false);
		impResuHtml.setBorder(emptyBorder);

		p1.add(impCountry);
		p1.add(impCountryHtml);
		p1.add(impDisc);
		p1.add(impDiscHtml);
		p1.add(impResu);
		p1.add(impResuHtml);
		imp.add(p1);
	}

	private void addExports() {

		JPanel p1 = new JPanel(new GridLayout(3, 2, 10, 10));
		p1.setOpaque(false);
		exp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		// Countries
		Botao expCountry = new Botao(img.expCountry);
		expCountry.setContentAreaFilled(false);
		expCountry.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportPais(AppConfig.this, Main.getPaises());
			}
		});

		Botao expCountryHtml = new Botao(img.expCountryHtml);
		expCountryHtml.setContentAreaFilled(false);
		expCountryHtml.setBorder(emptyBorder);

		// Disciplines
		Botao expDisc = new Botao(img.expDisc);
		expDisc.setContentAreaFilled(false);
		expDisc.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportDisciplina(AppConfig.this, Main.getModalidades());
			}
		});

		Botao expDiscHtml = new Botao(img.expDiscHtml);
		expDiscHtml.setContentAreaFilled(false);
		expDiscHtml.setBorder(emptyBorder);

		// Results
		Botao expResu = new Botao(img.expResu);
		expResu.setContentAreaFilled(false);
		expResu.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itModal = 0;

				for (; itModal < Main.getModalidades().size(); itModal++) {
					if (Main.getModalidades().get(itModal).getNome().equals("Gymnastics"))
						break;
				}

				for (int i = 0; i < Main.getModalidades().get(itModal).getDisc().size(); i++) {
					if (!Main.getModalidades().get(itModal).getDisc().get(i).getTipoMod())
						for (int j = 0; j < Main.getProvas().size(); j++) {

							if (Main.getModalidades().get(itModal).getDisc().get(i).getNome().equals(Main.getProvas().get(j).getDisciplina().getNome()) && Main.getModalidades().get(itModal).getNome().equals(Main.getProvas().get(j).getDisciplina().getModalidade().getNome())) {

								if (Main.getProvas().get(j) instanceof ProvaInd) {

									System.out.println(Main.getModalidades().get(itModal).getDisc().get(i).getNome());
									for (int k = 0; k < ((ProvaInd) Main.getProvas().get(j)).getResultados().size(); k++) {
										System.out.println(((ProvaInd) Main.getProvas().get(j)).getResultados().get(k).getAtleta().getNome() + " : " + ((ProvaInd) Main.getProvas().get(j)).getResultados().get(k).getResulTemp());
									}
								}

							}
						}
				}

				for (int i = 0; i < Main.getModalidades().get(itModal).getDisc().size(); i++) {
					if (Main.getModalidades().get(itModal).getDisc().get(i).getTipoMod())
						System.out.println(Main.getModalidades().get(itModal).getDisc().get(i).getNome());
					for (int j = 0; j < Main.getProvas().size(); j++) {

						if (Main.getModalidades().get(itModal).getDisc().get(i).getNome().equals(Main.getProvas().get(j).getDisciplina().getNome()) && Main.getModalidades().get(itModal).getNome().equals(Main.getProvas().get(j).getDisciplina().getModalidade().getNome())) {

							if (Main.getProvas().get(j).getDisciplina().getTipoMod()) {

								for (int k = 0; k < ((ProvaCol) Main.getProvas().get(j)).getResultados().size(); k++) {
									System.out.println(((ProvaCol) Main.getProvas().get(j)).getResultados().get(k).getEquipa().getPais().getCodigoPais() + " : " + ((ProvaCol) Main.getProvas().get(j)).getResultados().get(k).getResulTemp());
								}
							}

						}
					}
				}

			}
		});

		Botao expResuHtml = new Botao(img.expResuHtml);
		expResuHtml.setContentAreaFilled(false);
		expResuHtml.setBorder(emptyBorder);

		p1.add(expCountry);
		p1.add(expCountryHtml);
		p1.add(expDisc);
		p1.add(expDiscHtml);
		p1.add(expResu);
		p1.add(expResuHtml);
		exp.add(p1);
	}

	private void addAdds() {
		JPanel p1 = new JPanel(new GridLayout(3, 2, 10, 10));
		p1.setOpaque(false);
		add.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		Botao addAth = new Botao(img.addAth);
		addAth.setContentAreaFilled(false);
		addAth.setBorder(emptyBorder);
		addAth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDados a = new AddDados();
				a.setSelectedIndex(4);
			}
		});

		Botao addCo = new Botao(img.addCo);
		addCo.setContentAreaFilled(false);
		addCo.setBorder(emptyBorder);
		addCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDados a = new AddDados();
				a.setSelectedIndex(1);
			}
		});

		Botao addDis = new Botao(img.addDis);
		addDis.setContentAreaFilled(false);
		addDis.setBorder(emptyBorder);
		addDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDados a = new AddDados();
				a.setSelectedIndex(2);
			}
		});

		Botao addSpo = new Botao(img.addSpo);
		addSpo.setContentAreaFilled(false);
		addSpo.setBorder(emptyBorder);
		addSpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDados a = new AddDados();
				a.setSelectedIndex(3);
			}
		});

		Botao addJO = new Botao(img.addJO);
		addJO.setContentAreaFilled(false);
		addJO.setBorder(emptyBorder);
		addJO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDados a = new AddDados();
				a.setSelectedIndex(0);
			}
		});

		p1.add(addAth);
		p1.add(addCo);
		p1.add(addDis);
		p1.add(addSpo);
		p1.add(addJO);
		add.add(p1);

	}

	private void addEdits() {

		JPanel p1 = new JPanel(new GridLayout(3, 2, 10, 10));
		p1.setOpaque(false);
		edit.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		Botao editAth = new Botao(img.editAth);
		editAth.setContentAreaFilled(false);
		editAth.setBorder(emptyBorder);

		Botao editCo = new Botao(img.editCo);
		editCo.setContentAreaFilled(false);
		editCo.setBorder(emptyBorder);

		Botao editDis = new Botao(img.editDis);
		editDis.setContentAreaFilled(false);
		editDis.setBorder(emptyBorder);

		Botao editSpo = new Botao(img.editSpo);
		editSpo.setContentAreaFilled(false);
		editSpo.setBorder(emptyBorder);

		Botao editJO = new Botao(img.editJO);
		editJO.setContentAreaFilled(false);
		editJO.setBorder(emptyBorder);

		p1.add(editAth);
		p1.add(editCo);
		p1.add(editDis);
		p1.add(editSpo);
		p1.add(editJO);
		edit.add(p1);
	}

	private void addRemoves() {

		JPanel p1 = new JPanel(new GridLayout(3, 2, 10, 10));
		p1.setOpaque(false);
		remove.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		Botao removeAth = new Botao(img.removeAth);
		removeAth.setContentAreaFilled(false);
		removeAth.setBorder(emptyBorder);

		Botao removeCo = new Botao(img.removeCo);
		removeCo.setContentAreaFilled(false);
		removeCo.setBorder(emptyBorder);

		Botao removeDis = new Botao(img.removeDis);
		removeDis.setContentAreaFilled(false);
		removeDis.setBorder(emptyBorder);

		Botao removeSpo = new Botao(img.removeSpo);
		removeSpo.setContentAreaFilled(false);
		removeSpo.setBorder(emptyBorder);

		Botao removeJO = new Botao(img.removeJO);
		removeJO.setContentAreaFilled(false);
		removeJO.setBorder(emptyBorder);

		p1.add(removeAth);
		p1.add(removeCo);
		p1.add(removeDis);
		p1.add(removeSpo);
		p1.add(removeJO);
		remove.add(p1);
	}

}
