package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import jogosolimpicos.*;
import dados.*;

public class AppConfig extends JFrame {

	private Botao expCountry, expCountryHtml, expDisc, expDiscHtml, expResu,
			expResuHtml, impCountry, impCountryHtml, impDisc, impDiscHtml,
			impResu, impResuHtml;

	private JPanel p1;
	Imagens img = new Imagens();
	private final Csv csv = new Csv();
	private Border emptyBorder = BorderFactory.createEmptyBorder();

	public AppConfig() {
		setTitle("Application Configuration");
		JTabbedPane jtp = new JTabbedPane();
		getContentPane().add(jtp);

		// Panels
		Painel imp = new Painel(img.imp);
		Painel exp = new Painel(img.exp);
		Painel add = new Painel(img.add);
		Painel edit = new Painel(img.edit);
		Painel remove = new Painel(img.remove);

		imp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
		exp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

		criarImport();
		imp.add(p1);
		criarExport();
		exp.add(p1);

		jtp.addTab("Import", imp);
		jtp.addTab("Export", exp);
		jtp.addTab("Add", add);
		jtp.addTab("Edit", edit);
		jtp.addTab("Remove", remove);

		setSize(400, 400);
		setVisible(true);

	}

	public void criarImport() {

		p1 = new JPanel(new GridLayout(3, 2, 10, 10));
		// Countries
		impCountry = new Botao(img.impCountry);
		impCountry.setContentAreaFilled(false);
		impCountry.setBorder(emptyBorder);
		impCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importPais(AppConfig.this, Main.getPaises());
			}
		});

		impCountryHtml = new Botao(img.impCountryHtml);
		impCountryHtml.setContentAreaFilled(false);
		impCountryHtml.setBorder(emptyBorder);

		// Disciplines
		impDisc = new Botao(img.impDisc);
		impDisc.setContentAreaFilled(false);
		impDisc.setBorder(emptyBorder);
		impDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importDisc(AppConfig.this, Main.getDisciplinas(),
						Main.getModalidades());
			}
		});

		impDiscHtml = new Botao(img.impDiscHtml);
		impDiscHtml.setContentAreaFilled(false);
		impDiscHtml.setBorder(emptyBorder);

		// Results
		impResu = new Botao(img.impResu);
		impResu.setContentAreaFilled(false);
		impResu.setBorder(emptyBorder);
		impResu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importResultados(AppConfig.this, Main.getAtleta(),
						Main.getModalidades(), Main.getPaises(),
						Main.getProvas(), Main.getEquipas());
			}
		});

		impResuHtml = new Botao(img.impResuHtml);
		impResuHtml.setContentAreaFilled(false);
		impResuHtml.setBorder(emptyBorder);

		p1.add(impCountry);
		p1.add(impCountryHtml);
		p1.add(impDisc);
		p1.add(impDiscHtml);
		p1.add(impResu);
		p1.add(impResuHtml);
	}

	public void criarExport() {

		p1 = new JPanel(new GridLayout(3, 2, 10, 10));
		// Countries
		expCountry = new Botao(img.expCountry);
		expCountry.setContentAreaFilled(false);
		expCountry.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportPais(AppConfig.this, Main.getPaises());
			}
		});

		expCountryHtml = new Botao(img.expCountryHtml);
		expCountryHtml.setContentAreaFilled(false);
		expCountryHtml.setBorder(emptyBorder);

		// Disciplines
		expDisc = new Botao(img.expDisc);
		expDisc.setContentAreaFilled(false);
		expDisc.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.exportDisciplina(AppConfig.this, Main.getModalidades());
			}
		});

		expDiscHtml = new Botao(img.expDiscHtml);
		expDiscHtml.setContentAreaFilled(false);
		expDiscHtml.setBorder(emptyBorder);

		// Results
		expResu = new Botao(img.expResu);
		expResu.setContentAreaFilled(false);
		expResu.setBorder(emptyBorder);
		expCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itModal = 0;

				for (; itModal < Main.getModalidades().size(); itModal++) {
					if (Main.getModalidades().get(itModal).getNome()
							.equals("Gymnastics"))
						break;
				}

				for (int i = 0; i < Main.getModalidades().get(itModal)
						.getDisc().size(); i++) {
					if (!Main.getModalidades().get(itModal).getDisc().get(i)
							.getTipoMod())
						for (int j = 0; j < Main.getProvas().size(); j++) {

							if (Main.getModalidades()
									.get(itModal)
									.getDisc()
									.get(i)
									.getNome()
									.equals(Main.getProvas().get(j)
											.getDisciplina().getNome())
									&& Main.getModalidades()
											.get(itModal)
											.getNome()
											.equals(Main.getProvas().get(j)
													.getDisciplina()
													.getModalidade().getNome())) {

								if (Main.getProvas().get(j) instanceof ProvaInd) {

									System.out.println(Main.getModalidades()
											.get(itModal).getDisc().get(i)
											.getNome());
									for (int k = 0; k < ((ProvaInd) Main
											.getProvas().get(j))
											.getResultados().size(); k++) {
										System.out.println(((ProvaInd) Main
												.getProvas().get(j))
												.getResultados().get(k)
												.getAtleta().getNome()
												+ " : "
												+ ((ProvaInd) Main.getProvas()
														.get(j))
														.getResultados().get(k)
														.getResulTemp());
									}
								}

							}
						}
				}

				for (int i = 0; i < Main.getModalidades().get(itModal)
						.getDisc().size(); i++) {
					if (Main.getModalidades().get(itModal).getDisc().get(i)
							.getTipoMod())
						System.out.println(Main.getModalidades().get(itModal)
								.getDisc().get(i).getNome());
					for (int j = 0; j < Main.getProvas().size(); j++) {

						if (Main.getModalidades()
								.get(itModal)
								.getDisc()
								.get(i)
								.getNome()
								.equals(Main.getProvas().get(j).getDisciplina()
										.getNome())
								&& Main.getModalidades()
										.get(itModal)
										.getNome()
										.equals(Main.getProvas().get(j)
												.getDisciplina()
												.getModalidade().getNome())) {

							if (Main.getProvas().get(j).getDisciplina()
									.getTipoMod()) {

								for (int k = 0; k < ((ProvaCol) Main
										.getProvas().get(j)).getResultados()
										.size(); k++) {
									System.out.println(((ProvaCol) Main
											.getProvas().get(j))
											.getResultados().get(k).getEquipa()
											.getPais().getCodigoPais()
											+ " : "
											+ ((ProvaCol) Main.getProvas().get(
													j)).getResultados().get(k)
													.getResulTemp());
								}
							}

						}
					}
				}

			}
		});

		expResuHtml = new Botao(img.expResuHtml);
		expResuHtml.setContentAreaFilled(false);
		expResuHtml.setBorder(emptyBorder);

		p1.add(expCountry);
		p1.add(expCountryHtml);
		p1.add(expDisc);
		p1.add(expDiscHtml);
		p1.add(expResu);
		p1.add(expResuHtml);
	}
}
