package dados;

import gui.*;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import jogosolimpicos.*;
import listaligada.*;

public class HTML {

	public void exportPais(Component janela, int anoInicio, int anoFim)
			throws FileNotFoundException {

		if (!Main.getPaises().isEmpty()) {

			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new HTMLFilter());
			int returnVal = fc.showSaveDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;
			File ficheiro = fc.getSelectedFile();
			Formatter fout = new Formatter(ficheiro + ".html");
			corpoInicio(fout);
			ListaLigada<Prova> provaTemp = Main.getProvas();
			ListaLigada<Pais> paisTemp = Main.getPaises();
			for (int i = anoInicio; i < anoFim; i += 4) {
				for (int j = 0; j < provaTemp.size(); j++) {
					if (provaTemp.get(j).getJogosOlimpicos().getAno() != i) {
						provaTemp.remove(j);
						j--;
					}
				}
				for (int j = 0; j < provaTemp.size(); j++) {
					if (provaTemp.get(j) instanceof ProvaInd && !((ProvaInd) provaTemp.get(j)).getResultados().isEmpty()) {
						provaTemp.get(j).ordenar();
						
					}else if(provaTemp.get(j) instanceof ProvaCol && !((ProvaCol) provaTemp.get(j)).getResultados().isEmpty()){
						provaTemp.get(j).ordenar();
					}	
				}
			}
		} else {
			JOptionPane.showMessageDialog(janela,
					"Não existem países para exportar", "Export",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	public void corpoInicio(Formatter fout) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">");
		fout.format("<head>");
		fout.format("<title> Jogos Ol&iacutempicos");
		fout.format("</title>");
		fout.format("</head>");
		fout.format("<body>");

	}

	private class HTMLFilter extends FileFilter {

		@Override
		public boolean accept(File f) {

			if (f.isDirectory()) {
				return true;
			}
			int ponto = f.getName().lastIndexOf(".");
			String extensao = f.getName().substring(ponto + 1);

			if (extensao != null) {
				if (extensao.equalsIgnoreCase("html"))
					return true;
			} else
				return false;

			return false;

		}

		@Override
		public String getDescription() {

			return String.format("HTML File.");
		}
	}

}
