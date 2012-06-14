package dados;

import gui.*;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import jogosolimpicos.*;
import listaligada.*;

/**
 * HTML class to export data to files.
 */

public class HTML {

	/**
	 * Method to Export HTML files about the results of the countries.
	 * 
	 * @param janela
	 *            the parent component of the dialog
	 * @param anoInicio
	 *            sets from which year starts the ranking
	 * @param anoFim
	 *            sets from which year ends the ranking
	 * @param lingua
	 *            sets which language it will be used to present the data
	 * @param linguas
	 *            language details
	 * @param prova
	 *            competition details
	 * @param pais
	 *            country details
	 */
	public void exportPais(Component janela, int anoInicio, int anoFim, Linguas lingua, ListaLigada<Linguas> linguas, ListaLigada<Prova> prova, ListaLigada<Pais> pais) {
		Imagens img = new Imagens();

		int it = 0;
		for (; it < linguas.size(); it++) {
			if (linguas.get(it).getLinguagem().equalsIgnoreCase(lingua.getLinguagem()))
				break;
		}
		if (linguas.size() == it) {
			JOptionPane.showMessageDialog(janela, "Language not found!", "Export File", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!Main.getPaises().isEmpty()) {
			try {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new HTMLFilter());
				int returnVal = fc.showSaveDialog(janela);
				if (returnVal != JFileChooser.APPROVE_OPTION)
					return;
				File ficheiro = fc.getSelectedFile();
				String dir = getDirPath(ficheiro);
				createImage(dir, img.html_bg);
				createImage(dir, img.argolas);
				Formatter fout = new Formatter(ficheiro + ".html");
				ListaLigada<Prova> provaTemp = prova;
				ListaLigada<Pais> paisTemp = pais;
				paisTemp = Listagem.listarMedalhasPais(paisTemp, provaTemp, anoInicio, anoFim, null, null);
				corpoInicio(fout, it, linguas);
				String fonte = "<font = \"Times New Roman\" color = \"white\">";
				for (int i = 0; i < paisTemp.size(); i++) {

					fout.format("</tr>\n");
					fout.format("<tr align=center>\n");
					fout.format("<td width=400>" + fonte + (i + 1) + "</font></td><td>" + fonte + paisTemp.get(i).getNomePais() + "</font></td><td>" + fonte + paisTemp.get(i).getMedalha().getOuro() + "</font></td><td>" + fonte + paisTemp.get(i).getMedalha().getPrata() + "</fonte></td><td>" + fonte + paisTemp.get(i).getMedalha().getBronze() + "</font></td>\n");

				}

				criarFimHTML(fout);
			} catch (IOException f) {
				JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(janela, "No Countries to export", "Export", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	/**
	 * Copy the image to the specified directory, near the html document.
	 * 
	 * @param dirHTML
	 *            the html directory
	 * @param img
	 *            the image to be copied
	 * @throws IOException
	 */
	private void createImage(String dirHTML, URL img) throws IOException {
		File dir = new File(dirHTML + "/Imagens");
		dir.mkdirs();

		String[] temp = img.getPath().split("/");
		String image = temp[temp.length - 1];

		File f1 = new File(img.getPath().replaceAll("\\\\", "/").replaceAll("%20", " "));
		File f2 = new File(dir + "/" + image);

		Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);

	}

	/**
	 * Method to export HTML files about the results of the athletes
	 * 
	 * @param janela
	 *            the parent component of the dialog
	 * @param anoInicio
	 *            sets from which year starts the ranking
	 * @param anoFim
	 *            sets from which year ends the ranking
	 * @param lingua
	 *            sets which language it will be used to present the data
	 * @param linguas
	 *            languages details
	 * @param atleta
	 *            athletes details
	 * @param prova
	 *            competition details
	 * @param equipa
	 *            team details
	 */
	public void exportAtleta(Component janela, int anoInicio, int anoFim, Linguas lingua, ListaLigada<Linguas> linguas, ListaLigada<Atleta> atleta, ListaLigada<Prova> prova, ListaLigada<Equipa> equipa) {

		int it = 0;
		for (; it < linguas.size(); it++) {
			if (linguas.get(it).getLinguagem().equalsIgnoreCase(lingua.getLinguagem()))
				break;
		}
		if (linguas.size() == it) {
			JOptionPane.showMessageDialog(janela, "Language not found!", "Export File", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!Main.getAtleta().isEmpty()) {
			try {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new HTMLFilter());
				int returnVal = fc.showSaveDialog(janela);
				if (returnVal != JFileChooser.APPROVE_OPTION)
					return;
				File ficheiro = fc.getSelectedFile();
				Formatter fout = new Formatter(ficheiro + ".html");
				ListaLigada<Prova> provaTemp = prova;
				ListaLigada<Atleta> atletaTemp;
				ListaLigada<Equipa> equipaTemp = equipa;
				atletaTemp = Listagem.listarMedalhasAtleta(atleta, equipaTemp, provaTemp, anoInicio, anoFim, null, null);
				corpoInicio(fout, it, linguas);
				String fonte = "<font = \"Times New Roman\" color = \"white\">";
				for (int i = 0; i < atletaTemp.size(); i++) {

					fout.format("</tr>\n");
					fout.format("<tr align=center>\n");
					fout.format("<td width=400>" + fonte + (i + 1) + "</font></td><td>" + fonte + atletaTemp.get(i).getNome() + "</font></td><td>" + fonte + atletaTemp.get(i).getMedalha().getOuro() + "</font></td><td>" + fonte + atletaTemp.get(i).getMedalha().getPrata() + "</font></td><td>" + fonte + atletaTemp.get(i).getMedalha().getBronze() + "</font></td>\n");

				}
				criarFimHTML(fout);
			} catch (FileNotFoundException f) {
				JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(janela, "No Athletes to export", "Export", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	/**
	 * Method to export HTML files about a specific sport.
	 * 
	 * @param janela
	 * 
	 * @param janela
	 *            the parent component of the dialog
	 * @param anoInicio
	 *            sets from which year starts the ranking
	 * @param anoFim
	 *            sets from which year ends the ranking
	 * @param linguas
	 *            languages details
	 * @param lingua
	 *            sets which language it will be used to present the data
	 * @param prova
	 *            competition details
	 * @param pais
	 *            country details
	 * @param modalidade
	 *            linked list of sports
	 */
	public void exportModalidade(Component janela, int anoInicio, int anoFim, String modalidade, ListaLigada<Linguas> linguas, Linguas lingua, ListaLigada<Prova> prova, ListaLigada<Pais> pais) {

		int it = 0;
		for (; it < linguas.size(); it++) {
			if (linguas.get(it).getLinguagem().equalsIgnoreCase(lingua.getLinguagem()))
				break;
		}
		if (linguas.size() == it) {
			JOptionPane.showMessageDialog(janela, "Language not found!", "Export File", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!Main.getModalidades().isEmpty()) {
			try {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new HTMLFilter());
				int returnVal = fc.showSaveDialog(janela);
				if (returnVal != JFileChooser.APPROVE_OPTION)
					return;
				File ficheiro = fc.getSelectedFile();
				Formatter fout = new Formatter(ficheiro + ".html");
				ListaLigada<Prova> provaTemp = prova;
				ListaLigada<Pais> paisTemp;
				paisTemp = Listagem.listarMedalhasPais(pais, provaTemp, anoInicio, anoFim, modalidade, null);
				corpoInicio(fout, it, linguas);
				String fonte = "<font = \"Times New Roman\" color = \"white\">";
				for (int i = 0; i < pais.size(); i++) {

					fout.format("</tr>\n");
					fout.format("<tr align=center>\n");
					fout.format("<td width=400>" + fonte + (i + 1) + "</font></td><td>" + fonte + paisTemp.get(i).getNomePais() + "</font></td><td>" + fonte + paisTemp.get(i).getMedalha().getOuro() + "</font></td><td>" + fonte + paisTemp.get(i).getMedalha().getPrata() + "</fonte></td><td>" + fonte + paisTemp.get(i).getMedalha().getBronze() + "</font></td>\n");

				}
				criarFimHTML(fout);
			} catch (FileNotFoundException f) {
				JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(janela, "No Sports to export", "Export", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	/**
	 * Method to export HTML files about a specific competition.
	 * 
	 * @param janela
	 *            the parent component of the dialog
	 * @param anoInicio
	 *            sets from which year starts the ranking
	 * @param anoFim
	 *            sets from which year ends the ranking
	 * @param linguas
	 *            languages details
	 * @param lingua
	 *            sets which language it will be used to present the data
	 * @param atleta
	 *            athletes details
	 * @param equipa
	 *            team details
	 * @param pais
	 *            country details
	 * @param provas
	 *            linked list of competitoin with event
	 * @param disciplina
	 *            linked list of the competitons
	 */
	public void exportDisciplina(Component janela, int anoInicio, int anoFim, ListaLigada<Prova> provas, Disciplina disciplina, ListaLigada<Linguas> linguas, Linguas lingua, ListaLigada<Pais> pais) {

		int it = 0;
		for (; it < linguas.size(); it++) {
			if (linguas.get(it).getLinguagem().equalsIgnoreCase(lingua.getLinguagem()))
				break;
		}
		if (linguas.size() == it) {
			JOptionPane.showMessageDialog(janela, "Language not found!", "Export File", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!Main.getDisciplinas().isEmpty()) {
			try {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new HTMLFilter());
				int returnVal = fc.showSaveDialog(janela);
				if (returnVal != JFileChooser.APPROVE_OPTION)
					return;
				File ficheiro = fc.getSelectedFile();
				Formatter fout = new Formatter(ficheiro + ".html");
				ListaLigada<Pais> paisTemp;
				paisTemp = Listagem.listarMedalhasPais(pais, provas, anoInicio, anoFim, null, disciplina);
				corpoInicio(fout, it, linguas);
				String fonte = "<font = \"Times New Roman\" color = \"white\">";
				for (int i = 0; i < paisTemp.size(); i++) {

					fout.format("</tr>\n");
					fout.format("<tr align=center>\n");
					fout.format("<td width=400>" + fonte + (i + 1) + "</font></td><td>" + fonte + paisTemp.get(i).getNomePais() + "</font></td><td>" + fonte + paisTemp.get(i).getMedalha().getOuro() + "</font></td><td>" + fonte + paisTemp.get(i).getMedalha().getPrata() + "</fonte></td><td>" + fonte + paisTemp.get(i).getMedalha().getBronze() + "</font></td>\n");

				}
				criarFimHTML(fout);
			} catch (FileNotFoundException f) {
				JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(janela, "No Competitions to export", "Export", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	/**
	 * Creates the end of the html body.
	 * 
	 * @param fout
	 *            file to be written upon
	 */
	private void criarFimHTML(Formatter fout) {
		fout.format("</tr>\n");
		fout.format("</table><br>\n");
		fout.format("</body>\n");
		fout.format("</html>");
		fout.close();
	}

	/**
	 * Method to write the starting lines on the file.
	 * 
	 * @param fout
	 *            file to be written upon
	 * @param it
	 *            location of the language inside languages
	 * @param linguas
	 *            language details
	 */
	private void corpoInicio(Formatter fout, int it, ListaLigada<Linguas> linguas) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">\n");
		fout.format("<head>\n");
		fout.format("<title> " + linguas.get(it).getJogosOlimpicos() + "\n");
		fout.format("</title>\n");
		fout.format("</head>\n");
		fout.format("<body background=\"Imagens/html_bg.png\">\n");
		fout.format("<table border=1 align = center>\n");
		fout.format("<tr>\n");
		fout.format("<td rowspan = 2><img src=\"Imagens/argolascr3.png\" width=500 height= 140> </td>\n");
		fout.format("<td align = center width = 500 height = 70 align = center><font = \"Times New Roman\" color = \"white\"> " + linguas.get(it).getListagem() + " </font></td>\n");
		fout.format("</tr>\n");
		fout.format("<tr>\n");
		fout.format("<td align = center width = 400 height= 70 align = center><font = \"Times New Roman\" color = \"white\"> " + linguas.get(it).getClassificacao() + " " + linguas.get(it).getPais() + " </font></td>\n");
		fout.format("</tr>\n");
		fout.format("</table><br>\n");
		Date d = new Date();
		fout.format("<table border = 0 align = center>\n");
		fout.format("<tr align = center>\n");
		fout.format("<td><font = \"Times New Roman\" color = \"white\">" + linguas.get(it).getData() + ": " + d + "</font></td>\n");
		fout.format("</tr>\n");
		fout.format("</table>\n");
		fout.format("<table border = 1 align=center>\n");
		fout.format("<tr>\n");
		fout.format("<td width=200 align = center><font = \"Times New Roman\" color = \"white\">" + linguas.get(it).getPosicao() + "</font></td><td align=center width=200><font = \"Times New Roman\" color = \"white\">" + linguas.get(it).getNome() + "</font></td> <td align=center width=200><font = \"Times New Roman\" color = \"white\">" + linguas.get(it).getOuro() + "</font></td> <td align=center width=200><font = \"Times New Roman\" color = \"white\">" + linguas.get(it).getPrata() + "</font></td> <td align=center width=200><font = \"Times New Roman\" color = \"white\">" + linguas.get(it).getBronze() + "</font></td>\n");

	}

	/**
	 * Returns the path of the directory where the file in param is located
	 * 
	 * @param f
	 *            the file we need to know the directory he is in
	 * 
	 * @return returns the path of the directory where the file in param is
	 *         located
	 */
	private String getDirPath(final File f) {

		String file = f.getAbsolutePath();
		String temp[] = file.split("\\\\");
		String fixedPath = "";

		for (int i = 0; i < temp.length - 1; i++) {
			fixedPath += temp[i] + "\\";
		}
		return fixedPath;
	}

	/**
	 * Private class to filter the files in the JChooseFile by HTML
	 * 
	 */
	private class HTMLFilter extends FileFilter {

		/**
		 * Choose if the file in File chooser is acceptable
		 * 
		 * @param f
		 *            file to be evaluated
		 * @return true if is acceptable
		 */
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

		/**
		 * The description of this filter. Eg: "HTMLs File"
		 * 
		 */
		@Override
		public String getDescription() {

			return String.format("HTML File");
		}
	}

}
