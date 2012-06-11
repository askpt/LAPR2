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

	public void exportPais(Component janela, int anoInicio, int anoFim, Linguas lingua, ListaLigada<Linguas> linguas, ListaLigada<Prova> prova, ListaLigada<Pais> pais) {

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
				Formatter fout = new Formatter(ficheiro + ".html");
				ListaLigada<Prova> provaTemp = prova;
				ListaLigada<Pais> paisTemp = pais;
				paisTemp = Listagem.listarMedalhasPais(paisTemp, provaTemp, anoInicio, anoFim, null, null);
				Date d = new Date();
				corpoInicioPais(fout, it, linguas);

				for (int i = 0; i < paisTemp.size(); i++) {

					fout.format("</tr>");
					fout.format("<tr align=center>");
					fout.format("<td width=400>" + (i + 1) + "</td><td>" + paisTemp.get(i).getNomePais() + "</td><td>" + pais.get(i).getMedalha().getOuro() + "</td><td>" + paisTemp.get(i).getMedalha().getPrata() + "</td><td>" + paisTemp.get(i).getMedalha().getBronze() + "</td><td>" + d + "</td>");
					fout.format("</tr>");

				}
				fout.format("</table><br>");
			} catch (FileNotFoundException f) {
				JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(janela, "No Countries to export", "Export", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

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
				ListaLigada<Atleta> atletaTemp = atleta;
				ListaLigada<Equipa> equipaTemp = equipa;
				atletaTemp = Listagem.listarMedalhasAtleta(atletaTemp, equipaTemp, provaTemp, anoInicio, anoFim, null, null);
				Date d = new Date();
				corpoInicioAtleta(fout, linguas, it);
				for (int i = 0; i < atletaTemp.size(); i++) {

					fout.format("</tr>");
					fout.format("<tr align=center>");
					fout.format("<td width=400>" + (i + 1) + "</td><td>" + atletaTemp.get(i).getNome() + "</td><td>" + atletaTemp.get(i).getMedalha().getOuro() + "</td><td>" + atletaTemp.get(i).getMedalha().getPrata() + "</td><td>" + atletaTemp.get(i).getMedalha().getBronze() + "</td><td>" + d + "</td>");
					fout.format("</tr>");
				}
				fout.format("</table><br>");
			} catch (FileNotFoundException f) {
				JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(janela, "No Countries to export", "Export", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

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
				ListaLigada<Pais> paisTemp = pais;
				paisTemp = Listagem.listarMedalhasPais(paisTemp, provaTemp, anoInicio, anoFim, modalidade, null);
				Date d = new Date();
				corpoInicioModalidade(fout, linguas, it);
				for (int i = 0; i < pais.size(); i++) {

					fout.format("</tr>");
					fout.format("<tr align=center>");
					fout.format("<td width=400>" + (i + 1) + "</td><td>" + paisTemp.get(i).getNomePais() + "</td><td>" + pais.get(i).getMedalha().getOuro() + "</td><td>" + paisTemp.get(i).getMedalha().getPrata() + "</td><td>" + paisTemp.get(i).getMedalha().getBronze() + "</td><td>" + d + "</td>");
					fout.format("</tr>");

				}
				fout.format("</table><br>");
			} catch (FileNotFoundException f) {
				JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(janela, "No Countries to export", "Export", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	public void exportDisciplina(Component janela, int anoInicio, int anoFim, ListaLigada<Prova> provas, Disciplina disciplina, ListaLigada<Linguas> linguas, Linguas lingua, ListaLigada<Atleta> atleta, ListaLigada<Equipa> equipa, ListaLigada<Pais> pais) {

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
				ListaLigada<Prova> provaTemp = provas;
				ListaLigada<Atleta> atletaTemp = atleta;
				ListaLigada<Equipa> equipaTemp = equipa;
				atletaTemp = Listagem.listarMedalhasAtleta(atletaTemp, equipaTemp, provaTemp, anoInicio, anoFim, null, disciplina);
				ListaLigada<Pais> paisTemp = pais;
				paisTemp = Listagem.listarMedalhasPais(pais, provas, anoInicio, anoFim, null, disciplina);
				Date d = new Date();
				corpoInicioDisciplina(fout, it, linguas);
				for (int i = 0; i < paisTemp.size(); i++) {

					fout.format("</tr>");
					fout.format("<tr align=center>");
					fout.format("<td width=400>" + (i + 1) + "</td><td>" + paisTemp.get(i).getNomePais() + "</td><td>" + pais.get(i).getMedalha().getOuro() + "</td><td>" + paisTemp.get(i).getMedalha().getPrata() + "</td><td>" + paisTemp.get(i).getMedalha().getBronze() + "</td><td>" + d + "</td>");
					fout.format("</tr>");

				}
				fout.format("</table><br>");

				fout.format("<tr>");
				fout.format("<td width=400 align = center>" + linguas.get(it).getPosicao() + "<td>" + linguas.get(it).getNome() + "</td> <td>" + linguas.get(it).getOuro() + "</td> <td>" + linguas.get(it).getPrata() + "</td> <td>" + linguas.get(it).getBronze() + "</td><td>" + linguas.get(it).getData());
				for (int i = 0; i < atletaTemp.size(); i++) {

					fout.format("</tr>");
					fout.format("<tr align=center>");
					fout.format("<td width=400>" + (i + 1) + "</td><td>" + atletaTemp.get(i).getNome() + "</td><td>" + atletaTemp.get(i).getMedalha().getOuro() + "</td><td>" + atletaTemp.get(i).getMedalha().getPrata() + "</td><td>" + atletaTemp.get(i).getMedalha().getBronze() + "</td><td>" + d + "</td>");
					fout.format("</tr>");

				}
				fout.format("</table><br>");

			} catch (FileNotFoundException f) {
				JOptionPane.showMessageDialog(janela, "Error exporting the document!", "Export File", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(janela, "No Countries to export", "Export", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	public void corpoInicioPais(Formatter fout, int it, ListaLigada<Linguas> linguas) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">");
		fout.format("<head>");
		fout.format("<title> " + linguas.get(it).getJogosOlimpicos());
		fout.format("</title>");
		fout.format("</head>");
		fout.format("<body>");
		fout.format("<table border=1 align = center>");
		fout.format("<tr>");
		fout.format("<td rowspan = 2><img src=\"argolascr3.gif\" width=350 height= 140> </td>");
		fout.format("<td align = center width = 400 height = 70 align = center> " + linguas.get(it).getListagem() + " </td>");
		fout.format("</tr>");
		fout.format("<tr>");
		fout.format("<td align = center width = 400 height= 70 align = center> " + linguas.get(it).getClassificacao() + " " + linguas.get(it).getPais() + " </td>");
		fout.format("</tr>");
		fout.format("</table><br>");
		fout.format("<table border = 1 align=center>");
		fout.format("<tr>");
		fout.format("<td width=400 align = center>" + linguas.get(it).getPosicao() + "<td>" + linguas.get(it).getNome() + "</td> <td>" + linguas.get(it).getOuro() + "</td> <td>" + linguas.get(it).getPrata() + "</td> <td>" + linguas.get(it).getBronze() + "</td><td>" + linguas.get(it).getData());

	}

	public void corpoInicioAtleta(Formatter fout, ListaLigada<Linguas> linguas, int it) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">");
		fout.format("<head>");
		fout.format("<title> " + linguas.get(it).getJogosOlimpicos());
		fout.format("</title>");
		fout.format("</head>");
		fout.format("<body>");
		fout.format("<table border=1 align = center>");
		fout.format("<tr>");
		fout.format("<td rowspan = 2><img src=\"argolascr3.gif\" width=350 height= 140> </td>");
		fout.format("<td align = center width = 400 height = 70 align = center> Listagem </td>");
		fout.format("</tr>");
		fout.format("<tr>");
		fout.format("<td align = center width = 400 height= 70 align = center>" + linguas.get(it).getClassificacao() + " " + linguas.get(it).getAtleta() + "</td>");
		fout.format("</tr>");
		fout.format("</table><br>");
		fout.format("<table border = 1 align=center>");
		fout.format("<tr>");
		fout.format("<td width=400 align = center>" + linguas.get(it).getPosicao() + "<td>" + linguas.get(it).getNome() + "</td> <td>" + linguas.get(it).getOuro() + "</td> <td>" + linguas.get(it).getPrata() + "</td> <td>" + linguas.get(it).getBronze() + "</td><td>" + linguas.get(it).getData());
	}

	public void corpoInicioModalidade(Formatter fout, ListaLigada<Linguas> linguas, int it) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">");
		fout.format("<head>");
		fout.format("<title> " + linguas.get(it).getJogosOlimpicos());
		fout.format("</title>");
		fout.format("</head>");
		fout.format("<body>");
		fout.format("<table border=1 align = center>");
		fout.format("<tr>");
		fout.format("<td rowspan = 2><img src=\"argolascr3.gif\" width=350 height= 140> </td>");
		fout.format("<td align = center width = 400 height = 70 align = center> Listagem </td>");
		fout.format("</tr>");
		fout.format("<tr>");
		fout.format("<td align = center width = 400 height= 70 align = center>" + linguas.get(it).getClassificacao() + " " + linguas.get(it).getModalidade() + "</td>");
		fout.format("</tr>");
		fout.format("</table><br>");
		fout.format("<table border = 1 align=center>");
		fout.format("<tr>");
		fout.format("<td width=400 align = center>" + linguas.get(it).getPosicao() + "<td>" + linguas.get(it).getNome() + "</td> <td>" + linguas.get(it).getOuro() + "</td> <td>" + linguas.get(it).getPrata() + "</td> <td>" + linguas.get(it).getBronze() + "</td><td>" + linguas.get(it).getData());

	}

	public void corpoInicioDisciplina(Formatter fout, int it, ListaLigada<Linguas> linguas) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">");
		fout.format("<head>");
		fout.format("<title>" + linguas.get(it).getJogosOlimpicos());
		fout.format("</title>");
		fout.format("</head>");
		fout.format("<body>");
		fout.format("<table border=1 align = center>");
		fout.format("<tr>");
		fout.format("<td rowspan = 2><img src=\"argolascr3.gif\" width=350 height= 140> </td>");
		fout.format("<td align = center width = 400 height = 70 align = center> Listagem </td>");
		fout.format("</tr>");
		fout.format("<tr>");
		fout.format("<td align = center width = 400 height= 70 align = center>" + linguas.get(it).getClassificacao() + " " + linguas.get(it).getDisciplina() + "</td>");
		fout.format("</tr>");
		fout.format("</table><br>");
		fout.format("<table border = 1 align=center>");
		fout.format("<tr>");
		fout.format("<td width=400 align = center>" + linguas.get(it).getPosicao() + "<td>" + linguas.get(it).getNome() + "</td> <td>" + linguas.get(it).getOuro() + "</td> <td>" + linguas.get(it).getPrata() + "</td> <td>" + linguas.get(it).getBronze() + "</td><td>" + linguas.get(it).getData());

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
