package dados;

import gui.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.accessibility.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import jogosolimpicos.*;

public class Csv extends JComponent implements Accessible {

	public void importPais(Component janela) {

		try {

			JFileChooser fc = new JFileChooser();
			fc.addChoosableFileFilter(new CsvFilter());
			fc.setAcceptAllFileFilterUsed(false);
			int returnVal = fc.showOpenDialog(janela);
			File ficheiro = fc.getSelectedFile();

			Scanner in = new Scanner(ficheiro);

			if (!in.hasNextLine()) {
				JOptionPane.showMessageDialog(janela, "Empty File!", "Import File", JOptionPane.ERROR_MESSAGE);
				return;
			}

			in.nextLine();
			while (in.hasNextLine()) {
				String temp[] = in.nextLine().split(" ;");
				Main.getPaises().add(new Pais(temp[0], temp[1]));
			}
			in.close();
			JOptionPane.showMessageDialog(janela, "File imported successful!", "Import File", JOptionPane.INFORMATION_MESSAGE);

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "File not found!", "Import File", JOptionPane.ERROR_MESSAGE);
		} catch (ArrayIndexOutOfBoundsException exc) {
			JOptionPane.showMessageDialog(janela, "Corrupted File!", "Import File", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void exportPais(Component janela) {

		try {
			JFileChooser fc = new JFileChooser();

			fc.setFileFilter(new CsvFilter());
			int returnVal = fc.showSaveDialog(janela);
			File ficheiro = fc.getSelectedFile();
			Formatter out = new Formatter(ficheiro);
			out.format("Code ;Nation (NOC) ;\n");
			for (int i = 0; i < Main.getPaises().size(); i++) {
				out.format("%s ;%s ;\n", Main.getPaises().get(i).getCodigoPais(), Main.getPaises().get(i).getNomePais());
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
			int mid = f.getName().lastIndexOf(".");
			String extensao = f.getName().substring(mid + 1);

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
