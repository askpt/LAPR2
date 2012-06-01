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

			in.nextLine();
			while (in.hasNextLine()) {
				String temp[] = in.nextLine().split(";");
				Disciplina tempDisc = new Disciplina("teste", "teste", false, -1);
				Disciplina tempDisc2 = new Disciplina("teste", "teste", false, -1);

				if (temp[2].equalsIgnoreCase("Individual")) {

					if (temp[3].equalsIgnoreCase("X") && temp[4].equalsIgnoreCase("X")) {
						tempDisc = new Disciplina(temp[1], "a", false, 2);
						tempDisc2 = new Disciplina(temp[1], temp[0], false, 3);
						disciplina.add(tempDisc);
						disciplina.add(tempDisc2);

					} else if (temp[3].equalsIgnoreCase("X")) {
						tempDisc = new Disciplina(temp[1], "a", false, 0);
						disciplina.add(tempDisc);
					} else if (temp[4].equalsIgnoreCase("X")) {
						tempDisc = new Disciplina(temp[1], "a", false, 1);
						disciplina.add(tempDisc);
					}
					if (temp.length == 6 && temp[5].equalsIgnoreCase("X")) {
						tempDisc = new Disciplina(temp[1], "a", false, 4);
						disciplina.add(tempDisc);
					}
				} else if (temp[2].equalsIgnoreCase("Team")) {
					if (temp[3].equalsIgnoreCase("X") && temp[4].equalsIgnoreCase("X")) {
						tempDisc = new Disciplina(temp[1], temp[0], true, 2);
						tempDisc2 = new Disciplina(temp[1], temp[0], true, 3);
						disciplina.add(tempDisc);
						disciplina.add(tempDisc2);
					} else if (temp[3].equalsIgnoreCase("X")) {
						tempDisc = new Disciplina(temp[1], temp[0], true, 0);
						disciplina.add(tempDisc);
					} else if (temp[4].equalsIgnoreCase("X")) {
						tempDisc = new Disciplina(temp[1], temp[0], true, 1);
						disciplina.add(tempDisc);
					}
					if (temp.length == 6 && temp[5].equalsIgnoreCase("X")) {
						tempDisc = new Disciplina(temp[1], temp[0], true, 4);
						disciplina.add(tempDisc);
					}
				}

				System.out.println(temp[0]);

				boolean controlModal = false;
				boolean controlDisc = false;
				boolean controlDisc1 = false;
				if (tempDisc2.getNome().equals("teste"))
					controlDisc1 = true;
				int i = 0;

				for (; !controlModal && i < modalidades.size(); i++) {
					for (int j = 0; j < modalidades.get(i).getDisc().size(); j++) {
						if (modalidades.get(i).getNome().equalsIgnoreCase(temp[0])) {
							controlModal = true;
							if (modalidades.get(i).getDisc().get(j).equals(tempDisc))
								controlDisc = true;
							if (modalidades.get(i).getDisc().get(j).equals(tempDisc) && controlDisc1 == false)
								controlDisc1 = true;
						}
					}

				}
				if (!controlModal) {
					modalidades.add(new Modalidade(temp[0]));
				}
				if (!controlDisc && modalidades.size() == 0) {
					modalidades.get(i).getDisc().add(tempDisc);
				} else
					modalidades.get(i - 1).getDisc().add(tempDisc);

				if (!controlDisc1 && modalidades.size() == 0) {
					modalidades.get(i).getDisc().add(tempDisc2);
				} else
					modalidades.get(i - 1).getDisc().add(tempDisc2);

			}
			in.close();
			JOptionPane.showMessageDialog(janela, "File imported successful!", "Import File", JOptionPane.INFORMATION_MESSAGE);

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "File not found!", "Import File", JOptionPane.ERROR_MESSAGE);
		} catch (ArrayIndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(janela, "Corrupted File!", "Import File", JOptionPane.ERROR_MESSAGE);
			exc.printStackTrace();
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
