package dados;

import gui.Main;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.accessibility.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import jogosolimpicos.*;
import listaligada.*;

@SuppressWarnings("serial")
public class Csv extends JComponent implements Accessible {

	public void importPais(Component janela, ListaLigada<Pais> paises) {

		try {

			JFileChooser fc = new JFileChooser();
			fc.addChoosableFileFilter(new CsvFilter());
			fc.setAcceptAllFileFilterUsed(false);
			int returnVal = fc.showOpenDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;

			File ficheiro = fc.getSelectedFile();

			Scanner in = new Scanner(ficheiro);

			if (!in.hasNextLine()) {
				JOptionPane.showMessageDialog(janela, "Empty File!", "Import File", JOptionPane.ERROR_MESSAGE);
				return;
			}

			in.nextLine();
			while (in.hasNextLine()) {
				String temp[] = in.nextLine().split(";");
				paises.add(new Pais(temp[0], temp[1]));
			}
			in.close();
			JOptionPane.showMessageDialog(janela, "File imported successful!", "Import File", JOptionPane.INFORMATION_MESSAGE);

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "File not found!", "Import File", JOptionPane.ERROR_MESSAGE);
		} catch (ArrayIndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(janela, "Corrupted File!", "Import File", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void exportPais(Component janela, ListaLigada<Pais> paises) {

		if (paises.isEmpty()) {
			JOptionPane.showMessageDialog(janela, "File is empty!", "Export File", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			JFileChooser fc = new JFileChooser();

			fc.setFileFilter(new CsvFilter());
			int returnVal = fc.showSaveDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;
			File ficheiro = fc.getSelectedFile();
			Formatter out = new Formatter(ficheiro + ".csv");
			out.format("Code ;Nation (NOC) ;\n");
			for (int i = 0; i < paises.size(); i++) {
				out.format("%s ;%s ;\n", paises.get(i).getCodigoPais(), paises.get(i).getNomePais());
			}
			out.close();
			JOptionPane.showMessageDialog(janela, "File exported successful!", "Export File", JOptionPane.INFORMATION_MESSAGE);

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void importDisc(Component janela, ListaLigada<Disciplina> disciplina, ListaLigada<Modalidade> modalidades) {

		// diretamente na lista disciplina

		try {

			JFileChooser fc = new JFileChooser();
			fc.addChoosableFileFilter(new CsvFilter());
			fc.setAcceptAllFileFilterUsed(false);
			int returnVal = fc.showOpenDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;

			File ficheiro = fc.getSelectedFile();

			Scanner in = new Scanner(ficheiro);

			if (!in.hasNextLine()) {
				JOptionPane.showMessageDialog(janela, "Empty File!", "Import File", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Disciplina(String nome, Modalidade modalidade, boolean tipoDisc,
			// int genero)

			// import modalidades
			in.nextLine();
			while (in.hasNextLine()) {
				String tempModal[] = in.nextLine().split(";");
				boolean temModal = false;

				for (int i = 0; i < modalidades.size(); i++) {
					if (tempModal[0].equals(modalidades.get(i).getNome()))
						temModal = true;
				}

				if (!temModal)
					modalidades.add(new Modalidade(tempModal[0]));
			}
			in.close();

			// import disciplinas
			Scanner in2 = new Scanner(ficheiro);
			in2.nextLine();
			while (in2.hasNextLine()) {
				String temp[] = in2.nextLine().split(";");
				Disciplina tempDisc = new Disciplina("temp");
				Disciplina tempDisc2 = new Disciplina("temp");
				int i = 0;

				for (; i < modalidades.size(); i++) {
					if (temp[0].equals(modalidades.get(i).getNome()))
						break;
				}

				if (temp[2].equalsIgnoreCase("Individual")) {
					if (temp[3].equalsIgnoreCase("X")) {

						if (temp[7].equalsIgnoreCase("H")) {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, true, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, true, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, true, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, true, 3);
							}

						} else {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, false, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, false, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, false, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, false, 3);
							}

						}

					}
					if (temp[4].equalsIgnoreCase("X")) {

						if (temp[7].equalsIgnoreCase("H")) {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 1, true, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 1, true, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 1, true, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 1, true, 3);
							}

						} else {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 1, false, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 1, false, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 1, false, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 1, false, 3);
							}

						}
					}
					if (temp[5].equalsIgnoreCase("X")) {
						if (temp[7].equalsIgnoreCase("H")) {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 3, true, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 3, true, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 3, true, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 3, true, 3);
							}

						} else {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 3, false, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 3, false, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 3, false, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 3, false, 3);
							}

						}
					}
					if (temp[3].equalsIgnoreCase("X") && temp[4].equalsIgnoreCase("X")) {

						if (temp[7].equalsIgnoreCase("H")) {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, true, 0);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), false, 1, true, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, true, 1);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), false, 1, true, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, true, 2);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), false, 1, true, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, true, 3);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), false, 1, true, 3);
							}

						} else {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, false, 0);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), false, 1, false, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, false, 1);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), false, 1, false, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, false, 2);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), false, 1, false, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), false, 0, false, 3);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), false, 1, false, 3);
							}

						}

					}
				} else if (temp[2].equalsIgnoreCase("Team")) {
					if (temp[3].equalsIgnoreCase("X")) {

						if (temp[7].equalsIgnoreCase("H")) {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, true, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, true, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, true, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, true, 3);
							}

						} else {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, false, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, false, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, false, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, false, 3);
							}

						}

					}
					if (temp[4].equalsIgnoreCase("X")) {

						if (temp[7].equalsIgnoreCase("H")) {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 1, true, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 1, true, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 1, true, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 1, true, 3);
							}

						} else {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 1, false, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 1, false, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 1, false, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 1, false, 3);
							}

						}
					}
					if (temp[5].equalsIgnoreCase("X")) {
						if (temp[7].equalsIgnoreCase("H")) {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 4, true, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 4, true, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 4, true, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 4, true, 3);
							}

						} else {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 4, false, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 4, false, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 4, false, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 4, false, 3);
							}

						}
					}
					if (temp[3].equalsIgnoreCase("X") && temp[4].equalsIgnoreCase("X")) {

						if (temp[7].equalsIgnoreCase("H")) {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, true, 0);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), true, 1, true, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, true, 1);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), true, 1, true, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, true, 2);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), true, 1, true, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, true, 3);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), true, 1, true, 3);
							}

						} else {
							if (temp[6].equalsIgnoreCase("m, ft")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, false, 0);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), true, 1, false, 0);
							} else if (temp[6].equalsIgnoreCase("time")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, false, 1);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), true, 1, false, 1);
							} else if (temp[6].equalsIgnoreCase("points")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, false, 2);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), true, 1, false, 2);
							} else if (temp[6].equalsIgnoreCase("rank")) {
								tempDisc = new Disciplina(temp[1], modalidades.get(i), true, 0, false, 3);
								tempDisc2 = new Disciplina(temp[1], modalidades.get(i), true, 1, false, 3);
							}

						}

					}
				}

				disciplina.add(tempDisc);
				if (!tempDisc2.getNome().equals("temp"))
					disciplina.add(tempDisc2);
			}
			in2.close();
			JOptionPane.showMessageDialog(janela, "File imported successful!", "Import File", JOptionPane.INFORMATION_MESSAGE);

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "File not found!", "Import File", JOptionPane.ERROR_MESSAGE);
		} catch (ArrayIndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(janela, "Corrupted File!", "Import File", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void exportDisciplina(Component janela, ListaLigada<Modalidade> modalidades) {

		if (modalidades.isEmpty()) {
			JOptionPane.showMessageDialog(janela, "File is empty!", "Export File", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			JFileChooser fc = new JFileChooser();

			fc.setFileFilter(new CsvFilter());
			int returnVal = fc.showSaveDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;
			File ficheiro = fc.getSelectedFile();
			Formatter out = new Formatter(ficheiro + ".csv");
			out.format("Sport;Discipline;Type;Men;Women;Mixed;Type;Order\n");
			for (int i = 0; i < modalidades.size(); i++) {
				String nomeModal = modalidades.get(i).getNome();
				String nomeDisc = "";
				String tipo = "";
				String typeClass = "";
				String order = "";

				ListaLigada<Disciplina> discTemp = modalidades.get(i).getDisc();
				for (int j = 0; j < discTemp.size(); j++) {
					nomeDisc = discTemp.get(j).getNome();
					String men = "";
					String women = "";
					String mixed = "";
					if (discTemp.get(j).getTipoMod())
						tipo = "Team";
					else
						tipo = "Individual";
					if (discTemp.get(j).getOrdenacao())
						order = "H";
					else
						order = "L";
					if (discTemp.get(j).getTipoClass() == 0)
						typeClass = "m, ft";
					else if (discTemp.get(j).getTipoClass() == 1)
						typeClass = "time";
					else if (discTemp.get(j).getTipoClass() == 2)
						typeClass = "points";
					else if (discTemp.get(j).getTipoClass() == 3)
						typeClass = "rank";
					if (discTemp.get(j).getGenero() == 0)
						men = "X";
					else if (discTemp.get(j).getGenero() == 1)
						women = "X";
					else if (discTemp.get(j).getGenero() == 2)
						mixed = "X";

					for (int k = j + 1; k < discTemp.size(); k++) {
						if (discTemp.get(j).equals(discTemp.get(k))) {
							if (discTemp.get(k).getGenero() == 0)
								men = "X";
							else if (discTemp.get(k).getGenero() == 1)
								women = "X";
							else if (discTemp.get(k).getGenero() == 2)
								mixed = "X";
							discTemp.remove(k);
							k--;
						}
					}
					out.format("%s;%s;%s;%s;%s;%s;%s;%s\n", nomeModal, nomeDisc, tipo, men, women, mixed, typeClass, order);
				}

			}
			out.close();
			JOptionPane.showMessageDialog(janela, "File exported successful!", "Export File", JOptionPane.INFORMATION_MESSAGE);

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
		}

	}

	@SuppressWarnings("unused")
	public void importResultados(Component janela, ListaLigada<Atleta> atletas, ListaLigada<Modalidade> modalidades, ListaLigada<Pais> paises, ListaLigada<Prova> provas, ListaLigada<Equipa> equipas) {
		try {

			JFileChooser fc = new JFileChooser();
			fc.addChoosableFileFilter(new CsvFilter());
			fc.setAcceptAllFileFilterUsed(false);
			int returnVal = fc.showOpenDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;
			File ficheiro = fc.getSelectedFile();

			int ponto = ficheiro.getName().lastIndexOf(".");
			String[] tempPrin = ficheiro.getName().substring(0, ponto).split("_");
			int ano = Integer.parseInt(tempPrin[0]);
			String modalidade = tempPrin[1];
			String genero = tempPrin[2];
			int codGenero = -1; // 0 = masc 1= fem 2= mixed
			boolean tipoDisc = false; // false = individual true = coletivo
			int tipoClass = -1; // 0 - distancia 1 = tempo 2 = pontos 3 = rank
			String nomeDisc;
			int itDisc = 0;
			int itProva = 0;

			if (genero.equalsIgnoreCase("Men"))
				codGenero = 0;
			else if (genero.equalsIgnoreCase("Women"))
				codGenero = 1;
			else if (genero.equalsIgnoreCase("Mixed"))
				codGenero = 2;

			int itModal = 0;

			boolean testModal = false;
			for (; itModal < modalidades.size(); itModal++) {
				if (modalidade.equals(modalidades.get(itModal).getNome())) {
					testModal = true;
					break;
				}
			}

			if (itModal == modalidades.size()) {
				JOptionPane.showMessageDialog(janela, "Sport not found!\nPlease import: " + modalidade + "!", "Import File", JOptionPane.ERROR_MESSAGE);
				return;
			}

			Scanner inTest = new Scanner(ficheiro);

			if (!inTest.hasNextLine()) {
				JOptionPane.showMessageDialog(janela, "Empty File!", "Import File", JOptionPane.ERROR_MESSAGE);
				return;
			}

			while (inTest.hasNextLine()) {
				String test[] = inTest.nextLine().split(";");
				if (test[0].equalsIgnoreCase("Individual ") || test[0].equalsIgnoreCase("Team ")) {
				} else if (test[0].equals("")) {
				} else {
					boolean testeDisc = false;
					for (int j = 0; j < modalidades.get(itModal).getDisc().size(); j++) {
						if (test[0].equalsIgnoreCase(modalidades.get(itModal).getDisc().get(j).getNome()))
							testeDisc = true;
					}
					if (!testeDisc) {
						JOptionPane.showMessageDialog(janela, "Competition not found!\nPlease import: " + test[0] + "!", "Import File", JOptionPane.ERROR_MESSAGE);
						return;
					}

				}

			}

			Scanner in = new Scanner(ficheiro);
			while (in.hasNextLine()) {

				String temp[] = in.nextLine().split(";");
				if (temp[0].equals("")) {
					if (!tipoDisc) {

						String[] atl = temp[1].split(", ");

						int itAtleta = 0;
						for (; itAtleta < atletas.size(); itAtleta++) {
							if (atletas.get(itAtleta).getNome().equalsIgnoreCase(atl[0]) && atletas.get(itAtleta).getPais().getCodigoPais().equalsIgnoreCase(atl[1])) {

								break;
							}

						}

						if (itAtleta == atletas.size()) {
							int itPais = 0;
							for (; itPais < paises.size(); itPais++) {
								if (atl[1].equalsIgnoreCase(paises.get(itPais).getCodigoPais())) {
									break;
								}
							}

							if (itPais == paises.size()) {
								JOptionPane.showMessageDialog(janela, "Country not found!\nPlease import: " + atl[1] + "!", "Import File", JOptionPane.ERROR_MESSAGE);
								return;
							}

							atletas.add(new Atleta(atl[0], paises.get(itPais)));

						}

						((ProvaInd) provas.get(itProva)).getResultados().add(new ResultadosInd(atletas.get(itAtleta), temp[2], tipoClass));

					} else {
						String[] team = temp[1].split("\\(");

						boolean existeAtletas = false;

						int itPais = 0;
						for (; itPais < paises.size(); itPais++) {
							if (team[0].equalsIgnoreCase(paises.get(itPais).getCodigoPais())) {
								break;
							}
						}

						if (itPais == paises.size()) {
							JOptionPane.showMessageDialog(janela, "Country not found!\nPlease import: " + team[0] + "!", "Import File", JOptionPane.ERROR_MESSAGE);
							return;
						}

						boolean existeAtleta = false;

						equipas.add(new Equipa(paises.get(itPais)));
						String[] atletasTemp = team[1].split(", ");
						for (int i = 0; i < atletasTemp.length; i++) {
							int itAtleta = 0;
							for (; itAtleta < atletas.size(); itAtleta++) {
								if (atletas.get(itAtleta).getNome().equalsIgnoreCase(atletasTemp[i]) && atletas.get(itAtleta).getPais().getCodigoPais().equalsIgnoreCase(atletasTemp[i])) {
									existeAtleta = true;
									break;
								}

							}

							if (!existeAtleta) {

								atletas.add(new Atleta(atletasTemp[i], paises.get(itPais)));

							}
							equipas.get(equipas.size() - 1).addAtleta(atletas.get(itAtleta));
						}

						((ProvaCol) provas.get(itProva)).getResultados().add(new ResultadosCol(equipas.get(equipas.size() - 1), temp[2], tipoClass));

					}

				} else if (temp[0].equalsIgnoreCase("Individual ")) {
					tipoDisc = false;

				} else if (temp[0].equalsIgnoreCase("Team ")) {
					tipoDisc = true;
				} else {
					nomeDisc = temp[0];
					itDisc = 0;
					for (; itDisc < modalidades.get(itModal).getDisc().size(); itDisc++) {
						if (nomeDisc.equalsIgnoreCase(modalidades.get(itModal).getDisc().get(itDisc).getNome()) && codGenero == modalidades.get(itModal).getDisc().get(itDisc).getGenero())
							break;
					}
					tipoClass = modalidades.get(itModal).getDisc().get(itDisc).getTipoClass(); // tipo
					// class

					if (!tipoDisc) {
						boolean existeAtleta = false;
						String[] atl = temp[1].split(", ");

						int itAtleta = 0;
						for (; itAtleta < atletas.size(); itAtleta++) {
							if (atletas.get(itAtleta).getNome().equalsIgnoreCase(atl[0]) && atletas.get(itAtleta).getPais().getCodigoPais().equalsIgnoreCase(atl[1])) {
								existeAtleta = true;
								break;
							}

						}

						if (!existeAtleta) {
							int itPais = 0;
							for (; itPais < paises.size(); itPais++) {
								if (atl[1].equalsIgnoreCase(paises.get(itPais).getCodigoPais())) {
									break;
								}
							}

							if (itPais == paises.size()) {
								JOptionPane.showMessageDialog(janela, "Country not found!\nPlease import: " + atl[1] + "!", "Import File", JOptionPane.ERROR_MESSAGE);
								return;
							}

							atletas.add(new Atleta(atl[0], paises.get(itPais)));

						}

						itProva = 0;

						for (; itProva < provas.size(); itProva++) {
							if (provas.get(itProva).getJogosOlimpicos().getAno() == ano && provas.get(itProva).getDisciplina().getNome().equals(nomeDisc) && provas.get(itProva).getDisciplina().getTipoMod() == tipoDisc) {
								break;
							}
						}

						if (itProva == provas.size()) {
							provas.add(new ProvaInd(modalidades.get(itModal).getDisc().get(itDisc), new JogosOlimpicos(ano)));
						}

						((ProvaInd) provas.get(itProva)).getResultados().add(new ResultadosInd(atletas.get(itAtleta), temp[2], tipoClass));

					} else {
						String[] team = temp[1].split("\\(");

						boolean existeAtletas = false;

						int itPais = 0;
						for (; itPais < paises.size(); itPais++) {
							if (team[0].equalsIgnoreCase(paises.get(itPais).getCodigoPais())) {
								break;
							}
						}

						if (itPais == paises.size()) {
							JOptionPane.showMessageDialog(janela, "Country not found!\nPlease import: " + team[0] + "!", "Import File", JOptionPane.ERROR_MESSAGE);
							return;
						}

						boolean existeAtleta = false;

						equipas.add(new Equipa(paises.get(itPais)));
						String[] atletasTemp = team[1].split(", ");
						for (int i = 0; i < atletasTemp.length; i++) {
							int itAtleta = 0;
							for (; itAtleta < atletas.size(); itAtleta++) {
								if (atletas.get(itAtleta).getNome().equalsIgnoreCase(atletasTemp[i]) && atletas.get(itAtleta).getPais().getCodigoPais().equalsIgnoreCase(atletasTemp[i])) {
									existeAtleta = true;
									break;
								}

							}

							if (!existeAtleta) {

								atletas.add(new Atleta(atletasTemp[i], paises.get(itPais)));

							}
							equipas.get(equipas.size() - 1).addAtleta(atletas.get(itAtleta));
						}

						itProva = 0;

						for (; itProva < provas.size(); itProva++) {
							if (provas.get(itProva).getJogosOlimpicos().getAno() == ano && provas.get(itProva).getDisciplina().getNome().equals(nomeDisc) && provas.get(itProva).getDisciplina().getTipoMod() == tipoDisc) {
								break;
							}
						}

						if (itProva == provas.size()) {
							provas.add(new ProvaCol(modalidades.get(itModal).getDisc().get(itDisc), new JogosOlimpicos(ano)));
						}

						((ProvaCol) provas.get(itProva)).getResultados().add(new ResultadosCol(equipas.get(equipas.size() - 1), temp[2], tipoClass));

					}

				}

			}
			in.close();
			JOptionPane.showMessageDialog(janela, "File imported successful!", "Import File", JOptionPane.INFORMATION_MESSAGE);

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "File not found!", "Import File", JOptionPane.ERROR_MESSAGE);
		} catch (ArrayIndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(janela, "Corrupted File!", "Import File", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void exportResultados(Component janela, ListaLigada<Modalidade> modalidades, ListaLigada<Prova> provas, String modalidade, int genero, int ano) {

		if (modalidades.isEmpty() || provas.isEmpty()) {
			JOptionPane.showMessageDialog(janela, "File is empty!", "Export File", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			JFileChooser fc = new JFileChooser();

			fc.setFileFilter(new CsvFilter());
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showSaveDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;
			File ficheiro = fc.getSelectedFile();
			Formatter out;
			if (genero == 0)
				out = new Formatter(ficheiro + "\\" + ano + "_" + modalidade + "_Men.csv");
			else {
				out = new Formatter(ficheiro + "\\" + ano + "_" + modalidade + "_Women.csv");
			}
			out.format("Individual ;;Value\n");
			int imod = 0;
			for (; imod < modalidades.size(); imod++) {
				if (modalidade.equalsIgnoreCase(modalidades.get(imod).getNome()))
					break;
			}

			for (int i = 0; i < modalidades.get(imod).getDisc().size(); i++) {

			}

			int itModal = 0;

			for (; itModal < modalidades.size(); itModal++) {
				if (modalidades.get(itModal).getNome().equals(modalidade))
					break;
			}

			for (int i = 0; i < modalidades.get(itModal).getDisc().size(); i++) {
				if (!modalidades.get(itModal).getDisc().get(i).getTipoMod())
					for (int j = 0; j < provas.size(); j++) {

						if (modalidades.get(itModal).getDisc().get(i).getNome().equals(provas.get(j).getDisciplina().getNome()) && modalidades.get(itModal).getNome().equals(provas.get(j).getDisciplina().getModalidade().getNome())) {

							if (provas.get(j) instanceof ProvaInd) {

								out.format(modalidades.get(itModal).getDisc().get(i).getNome());
								for (int k = 0; k < ((ProvaInd) provas.get(j)).getResultados().size(); k++) {
									out.format(";" + ((ProvaInd) provas.get(j)).getResultados().get(k).getAtleta().getNome() + ", ");
									out.format(((ProvaInd) provas.get(j)).getResultados().get(k).getAtleta().getPais().getCodigoPais() + ";");
									out.format(((ProvaInd) provas.get(j)).getResultados().get(k).getResulTemp() + "\n");
								}
							}

						}
					}
			}
			out.format("Team ;;Value\n");
			for (int i = 0; i < modalidades.get(itModal).getDisc().size(); i++) {
				if (modalidades.get(itModal).getDisc().get(i).getTipoMod())
					for (int j = 0; j < Main.getProvas().size(); j++) {

						if (modalidades.get(itModal).getDisc().get(i).getNome().equals(provas.get(j).getDisciplina().getNome()) && modalidades.get(itModal).getNome().equals(Main.getProvas().get(j).getDisciplina().getModalidade().getNome())) {

							if (provas.get(j) instanceof ProvaCol) {
								out.format(modalidades.get(itModal).getDisc().get(i).getNome());

								for (int k = 0; k < ((ProvaCol) provas.get(j)).getResultados().size(); k++) {
									out.format(((ProvaCol) provas.get(j)).getResultados().get(k).getEquipa().getPais().getCodigoPais() + "(");
									for (int l = 0; l < ((ProvaCol) provas.get(j)).getResultados().get(k).getEquipa().getAtleta().size(); l++) {
										out.format(((ProvaCol) provas.get(j)).getResultados().get(k).getEquipa().getAtleta().get(l).getNome() + ", ");
										if (l == ((ProvaCol) provas.get(j)).getResultados().get(k).getEquipa().getAtleta().size() - 1)
											out.format(((ProvaCol) provas.get(j)).getResultados().get(k).getEquipa().getAtleta().get(l).getNome());
									}

									out.format(");");
									out.format(((ProvaCol) provas.get(j)).getResultados().get(k).getResulTemp() + "\n");
								}
							}

						}
					}
			}

			out.close();
			JOptionPane.showMessageDialog(janela, "File exported successful!", "Export File", JOptionPane.INFORMATION_MESSAGE);

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
		}

	}

	private class CsvFilter extends FileFilter {

		@Override
		public boolean accept(File f) {

			if (f.isDirectory()) {
				return true;
			}
			int ponto = f.getName().lastIndexOf(".");
			String extensao = f.getName().substring(ponto + 1);

			if (extensao != null) {
				if (extensao.equals("csv"))
					return true;
			} else
				return false;

			return false;

		}

		@Override
		public String getDescription() {

			return String.format("CSV File");
		}

	}

}
