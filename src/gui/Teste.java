package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import jogosolimpicos.*;
import listaligada.*;
import dados.*;

//TODO Remove class
@SuppressWarnings("serial")
public class Teste extends JFrame {

	public Teste(String titulo) {

		super(titulo);
		setLayout(new BorderLayout());

		Imagens img = new Imagens();

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		final Csv csv = new Csv();
		final HTML html = new HTML();

		menuBar = new JMenuBar();

		menu = new JMenu("File");
		menu.setMnemonic('F');
		menuBar.add(menu);

		menuItem = new JMenuItem("IntelImport", 'I');
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				csv.intelImport(Teste.this, Main.getPaises(), Main.getDisciplinas(), Main.getModalidades(), Main.getJogos(), Main.getProvas(), Main.getEquipas(), Main.getAtleta());
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Import Country", 'I');
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				csv.importPais(null, Teste.this, Main.getPaises());
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Export Country", 'E');
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				csv.exportPais(Teste.this, Main.getPaises());
			}
		});

		menuItem = new JMenuItem("Export Country HTML", 'H');
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				for (int i = 0; i < Main.getLingua().size(); i++) {
					if (Main.getLingua().get(i).getLinguagem().equalsIgnoreCase("English")) {
						index = i;
					}
				}
				html.exportPais(Teste.this, 1996, 2008, Main.getLingua().get(index), Main.getLingua(), Main.getProvas(), Main.getPaises());
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Export Atlhete HTML", 'A');
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				for (int i = 0; i < Main.getLingua().size(); i++) {
					if (Main.getLingua().get(i).getLinguagem().equalsIgnoreCase("English")) {
						index = i;
					}
				}
				html.exportAtleta(Teste.this, 1996, 2008, Main.getLingua().get(index), Main.getLingua(), Main.getAtleta(), Main.getProvas(), Main.getEquipas());
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Import Language", 'L');
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csv.importLingua(Teste.this, Main.getLingua());
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("List Country", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < Main.getPaises().size(); i++) {
					System.out.println(Main.getPaises().get(i));
				}

			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Import Competitions", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				csv.importDisc(null, Teste.this, Main.getDisciplinas(), Main.getModalidades());
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Export Competitions", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				csv.exportDisciplina(Teste.this, Main.getModalidades());

			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("List Competitions", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < Main.getDisciplinas().size(); i++) {
					System.out.println(Main.getDisciplinas().get(i).toStringTest());
				}

				for (int i = 0; i < Main.getModalidades().size(); i++) {
					System.out.println(Main.getModalidades().get(i).toStringTest());
				}

			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Import Results", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				csv.importResultados(null, Teste.this, Main.getAtleta(), Main.getModalidades(), Main.getPaises(), Main.getProvas(), Main.getEquipas(), Main.getJogos());
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("List Results", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int itModal = 0;

				for (; itModal < Main.getModalidades().size(); itModal++) {
					if (Main.getModalidades().get(itModal).getNome().equals("Gymnastics"))
						break;
				}

				ListaLigada<Prova> provasTemp = new ListaLigada<Prova>();
				for (int i = 0; i < Main.getProvas().size(); i++) {
					provasTemp.add(Main.getProvas().get(i));
				}

				for (int i = 0; i < Main.getModalidades().get(itModal).getDisc().size(); i++) {
					if (!Main.getModalidades().get(itModal).getDisc().get(i).getTipoMod())
						for (int j = 0; j < provasTemp.size(); j++) {

							if (Main.getModalidades().get(itModal).getDisc().get(i).getNome().equals(provasTemp.get(j).getDisciplina().getNome()) && Main.getModalidades().get(itModal).getNome().equals(Main.getProvas().get(j).getDisciplina().getModalidade().getNome())) {

								if (provasTemp.get(j) instanceof ProvaInd) {

									System.out.println(Main.getModalidades().get(itModal).getDisc().get(i).getNome() + " Year: " + provasTemp.get(j).getJogosOlimpicos().getAno());
									for (int k = 0; k < ((ProvaInd) provasTemp.get(j)).getResultados().size(); k++) {
										System.out.println(((ProvaInd) provasTemp.get(j)).getResultados().get(k).getAtleta().getNome() + " : " + ((ProvaInd) provasTemp.get(j)).getResultados().get(k).getResulTemp());
									}
									provasTemp.remove(j);
									j--;
								}

							}
						}
				}

				for (int i = 0; i < Main.getModalidades().get(itModal).getDisc().size(); i++) {
					if (Main.getModalidades().get(itModal).getDisc().get(i).getTipoMod())
						for (int j = 0; j < Main.getProvas().size(); j++) {

							if (Main.getModalidades().get(itModal).getDisc().get(i).getNome().equals(Main.getProvas().get(j).getDisciplina().getNome()) && Main.getModalidades().get(itModal).getNome().equals(Main.getProvas().get(j).getDisciplina().getModalidade().getNome())) {

								if (provasTemp.get(j) instanceof ProvaCol) {
									System.out.println(Main.getModalidades().get(itModal).getDisc().get(i).getNome() + " Year: " + provasTemp.get(j).getJogosOlimpicos().getAno());

									for (int k = 0; k < ((ProvaCol) provasTemp.get(j)).getResultados().size(); k++) {
										System.out.println(((ProvaCol) provasTemp.get(j)).getResultados().get(k).getEquipa().getPais().getCodigoPais(2008) + " : " + ((ProvaCol) provasTemp.get(j)).getResultados().get(k).getResulTemp());
									}
									provasTemp.remove(j);
									j--;
								}

							}
						}
				}

			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Export Results", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				csv.exportResultados(Teste.this, Main.getModalidades(), Main.getProvas(), "Gymnastics", 1, 2008);
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Import Provas", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				csv.importProvas(null, Teste.this, Main.getJogos(), Main.getProvas(), Main.getDisciplinas(), Main.getModalidades());
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Export Provas", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				csv.exportProvas(Teste.this, Main.getProvas(), 2008);
			}
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("List Provas", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < Main.getProvas().size(); i++) {
					System.out.println(Main.getProvas().get(i).toStringTest());
				}

			}
		});

		menu.add(menuItem);

		JMenu listar = new JMenu("Listar");

		menuItem = new JMenuItem("Listar Paises", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TesteListagens.listarMedalhasPais(Main.getPaises(), Main.getProvas(), 1996, 2008, null, null);
			}
		});

		listar.add(menuItem);
		menuItem = new JMenuItem("Listar Atletas", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TesteListagens.listarMedalhasAtleta(Main.getAtleta(), Main.getEquipas(), Main.getProvas(), 1996, 2008, null, null);
			}
		});

		listar.add(menuItem);
		menuBar.add(listar);

		menuItem = new JMenuItem("Estatisticas", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pais pais = new Pais("USA", "United States");
				TesteListagens.estatisticaPais(pais, Main.getProvas(), Main.getPaises());
			}
		});

		listar.add(menuItem);

		menuItem = new JMenuItem("Medalhas por ano", 'L');
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pais pais = new Pais("USA", "United States");
				ListaLigada<Integer> medalhas;
				medalhas = Listagem.historicoMedalhasPais(pais, Main.getPaises(), Main.getProvas(), Main.getJogos());

				for (int i = 0; i < medalhas.size(); i++) {
					System.out.println(medalhas.get(i));
				}
			}
		});

		listar.add(menuItem);
		menuBar.add(listar);

		setJMenuBar(menuBar);

		JLabel label = new JLabel(new ImageIcon(img.constrution));
		label.setEnabled(false);
		label.setDisabledIcon(new ImageIcon(img.constrution));
		add(label);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		pack();
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
