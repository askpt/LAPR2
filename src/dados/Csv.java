package dados;

import listaligada.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.accessibility.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import jogosolimpicos.*;

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
				String temp[] = in.nextLine().split(" ;");
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
			exc.printStackTrace();
		}

	}

	public void exportDisciplina(Component janela, ListaLigada<Modalidade> modalidades) {

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
	public void importProvas(Component janela, ListaLigada<Atleta> atletas, ListaLigada<Modalidade> modalidades, ListaLigada<Prova> provas) {
		// TODO falta acabar
		try {

			JFileChooser fc = new JFileChooser();
			fc.addChoosableFileFilter(new CsvFilter());
			fc.setAcceptAllFileFilterUsed(false);
			int returnVal = fc.showOpenDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;
			File ficheiro = fc.getSelectedFile();

			int ponto = ficheiro.getName().lastIndexOf(".");
			String[] tempPrin = ficheiro.getName().substring(0, ponto - 1).split("_");
			String ano = tempPrin[0];
			String modalidade = tempPrin[1];
			String genero = tempPrin[2];
			int pos = -1;

			for (int i = 0; i < modalidades.size(); i++) {
				if (modalidade.equals(modalidades.get(i))) {
					pos = i;
				}
			}

			if (pos == -1) {
				modalidades.add(new Modalidade(modalidade));
				pos = modalidades.size() - 1;
			}

			Scanner in = new Scanner(ficheiro);

			if (!in.hasNextLine()) {
				JOptionPane.showMessageDialog(janela, "Empty File!", "Import File", JOptionPane.ERROR_MESSAGE);
				return;
			}

			in.nextLine();
			while (in.hasNextLine()) {
				String temp[] = in.nextLine().split(" ;");

			}
			in.close();
			JOptionPane.showMessageDialog(janela, "File imported successful!", "Import File", JOptionPane.INFORMATION_MESSAGE);

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "File not found!", "Import File", JOptionPane.ERROR_MESSAGE);
		} catch (ArrayIndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(janela, "Corrupted File!", "Import File", JOptionPane.ERROR_MESSAGE);
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
