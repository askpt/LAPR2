package dados;

import java.io.*;
import java.util.*;
import java.awt.*;

import javax.accessibility.*;
import javax.swing.*;

public class csv extends JComponent implements Accessible {

	public static void importPais(Component janela) {

		try {
			Scanner in = new Scanner(new File("teste.csv"));

		} catch (FileNotFoundException exc) {
			JOptionPane.showMessageDialog(janela, "File not found!", "Import File", JOptionPane.ERROR_MESSAGE);
		}

		// try {
		// Scanner in = new Scanner(new File("trabs.txt"));
		// if (!in.hasNextLine()) {
		// JOptionPane.showMessageDialog(janela, "Ficheiro vazio!",
		// "Carregar Ficheiro", JOptionPane.WARNING_MESSAGE);
		// } else {
		// ArrayList<Trabalhador> temp = new ArrayList<Trabalhador>();
		// boolean formatoValido = true;
		// while (in.hasNextLine() && formatoValido) {
		// String tokens[] = in.nextLine().split(";");
		// if (tokens[0].equalsIgnoreCase("TrabCom")) {
		// temp.add(new TrabCom(tokens[1], Float.parseFloat(tokens[2]),
		// Float.parseFloat(tokens[3]), Float.parseFloat(tokens[4])));
		// } else if (tokens[0].equalsIgnoreCase("TrabHora")) {
		// temp.add(new TrabHora(tokens[1], Integer.parseInt(tokens[2]),
		// Float.parseFloat(tokens[3])));
		// } else if (tokens[0].equalsIgnoreCase("TrabPeca")) {
		// temp.add(new TrabPeca(tokens[1], Integer.parseInt(tokens[2]),
		// Integer.parseInt(tokens[3])));
		// } else {
		// formatoValido = false;
		// }
		// }
		// if (formatoValido) {
		// trabs.addAll(temp);
		// JOptionPane.showMessageDialog(janela,
		// "Trabalhadores carregados com sucesso.", "Carregar Ficheiro",
		// JOptionPane.INFORMATION_MESSAGE);
		// } else {
		// JOptionPane.showMessageDialog(janela,
		// "Formato de ficheiro inválido.", "Carregar Ficheiro",
		// JOptionPane.WARNING_MESSAGE);
		// }
		// }
		// in.close();
		// } catch (ArrayIndexOutOfBoundsException exc) {
		// JOptionPane.showMessageDialog(janela,
		// "Formato de ficheiro inválido.", "Carregar Ficheiro",
		// JOptionPane.WARNING_MESSAGE);
		// } catch (NumberFormatException exc) {
		// JOptionPane.showMessageDialog(janela,
		// "Formato de ficheiro inválido.", "Carregar Ficheiro",
		// JOptionPane.WARNING_MESSAGE);
		// }
	}

	public static void exportPais() {

		// try {
		// Formatter out = new Formatter(new File("listaTrabs.txt"));
		// for (Trabalhador trab : trabs) {
		// out.format("%s %n%n", trab);
		// }
		// out.close();
		// JOptionPane.showMessageDialog(janela, "Ficheiro criado com sucesso!",
		// "Listar Ficheiro", JOptionPane.INFORMATION_MESSAGE);
		// } catch (FileNotFoundException exc) {
		// JOptionPane.showMessageDialog(janela,
		// "Falha na criação do ficheiro!", "Listar Ficheiro",
		// JOptionPane.ERROR_MESSAGE);
		// }
	}

}
