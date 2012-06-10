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
			ListaLigada<Prova> provaTemp = Main.getProvas();
			ListaLigada<Pais> paisTemp = Main.getPaises();
			paisTemp = Listagem.listarMedalhasPais(paisTemp, provaTemp,
					anoInicio, anoFim, null, null);
			corpoInicioPais(fout);
			for (int i = 0; i < paisTemp.size(); i++) {

				fout.format("<table border = 1>");
				fout.format("<tr>");
				fout.format("<td width=400> Posi&ccedil&atildeo<td> Nome </td> <td> Ouro </td> <td> Prata </td> <td> Bronze </td><td> Data de Emiss&atildeo");
				fout.format("</tr>");
				fout.format("<tr>");
				fout.format("<td width=400>" + (i+1) + "</td><td>" + paisTemp.get(i).getNomePais() + "</td> <td>" + paisTemp.get(i).getMedalha().getOuro()+ "</td> <td>" + paisTemp.get(i).getMedalha().getPrata() + "</td> <td>" + paisTemp.get(i).getMedalha().getBronze() + "</td><td>" + "Data de hoje" + "</td>");
				fout.format("</tr>");
				fout.format("</table><br>");

			}
		} else {
			JOptionPane.showMessageDialog(janela,
					"Não existem países para exportar", "Export",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	public void exportAtleta(Component janela, int anoInicio, int anoFim)
			throws FileNotFoundException {

		if (!Main.getPaises().isEmpty()) {

			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new HTMLFilter());
			int returnVal = fc.showSaveDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;
			File ficheiro = fc.getSelectedFile();
			Formatter fout = new Formatter(ficheiro + ".html");
			ListaLigada<Prova> provaTemp = Main.getProvas();
			ListaLigada<Atleta> atletaTemp = Main.getAtleta();
			ListaLigada<Equipa> equipaTemp = Main.getEquipas();
			atletaTemp = Listagem.listarMedalhasAtleta(atletaTemp, equipaTemp, provaTemp,	anoInicio, anoFim, null, null);
			corpoInicioAtleta(fout);
			for (int i = 0; i < atletaTemp.size(); i++) {
				
				fout.format("<table border = 1>");
				fout.format("<tr>");
				fout.format("<td width=400> Posi&ccedil&atildeo<td> Nome </td> <td> Ouro </td> <td> Prata </td> <td> Bronze </td><td> Data de Emiss&atildeo");
				fout.format("</tr>");
				fout.format("<tr>");
				fout.format("<td width=400>" + (i+1) + "</td><td>" + atletaTemp.get(i).getNome() + "</td><td>" + atletaTemp.get(i).getMedalha().getOuro() + "</td><td>" + atletaTemp.get(i).getMedalha().getPrata() + "</td><td>" + atletaTemp.get(i).getMedalha().getBronze() + "</td><td>" + "Data de Hoje" + "</td>");
				fout.format("</tr>");
				fout.format("</table><br>");
				
			}
		} else {
			JOptionPane.showMessageDialog(janela,
					"Não existem países para exportar", "Export",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	
	public void exportModalidade(Component janela, int anoInicio, int anoFim, String modalidade)
			throws FileNotFoundException {

		if (!Main.getPaises().isEmpty()) {

			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new HTMLFilter());
			int returnVal = fc.showSaveDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;
			File ficheiro = fc.getSelectedFile();
			Formatter fout = new Formatter(ficheiro + ".html");
			ListaLigada<Prova> provaTemp = Main.getProvas();
			ListaLigada<Atleta> atletaTemp = Main.getAtleta();
			ListaLigada<Equipa> equipaTemp = Main.getEquipas();
			atletaTemp = Listagem.listarMedalhasAtleta(atletaTemp, equipaTemp, provaTemp,	anoInicio, anoFim, modalidade, null);
			corpoInicioModalidade(fout);
			for (int i = 0; i < atletaTemp.size(); i++) {
				
				fout.format("<table border = 1>");
				fout.format("<tr>");
				fout.format("<td width=400> Posi&ccedil&atildeo<td> Nome </td> <td> Ouro </td> <td> Prata </td> <td> Bronze </td><td> Data de Emiss&atildeo");
				fout.format("</tr>");
				fout.format("<tr>");
				fout.format("<td width=400>" + (i+1) + "</td><td>" + atletaTemp.get(i).getNome() + "</td><td>" + atletaTemp.get(i).getMedalha().getOuro() + "</td><td>" + atletaTemp.get(i).getMedalha().getPrata() + "</td><td>" + atletaTemp.get(i).getMedalha().getBronze() + "</td><td>" + "Data de Hoje" + "</td>");
				fout.format("</tr>");
				fout.format("</table><br>");
				
			}
		} else {
			JOptionPane.showMessageDialog(janela,
					"Não existem países para exportar", "Export",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	
	public void exportDisciplina(Component janela, int anoInicio, int anoFim, Disciplina disciplina)
			throws FileNotFoundException {

		if (!Main.getPaises().isEmpty()) {

			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new HTMLFilter());
			int returnVal = fc.showSaveDialog(janela);
			if (returnVal != JFileChooser.APPROVE_OPTION)
				return;
			File ficheiro = fc.getSelectedFile();
			Formatter fout = new Formatter(ficheiro + ".html");
			ListaLigada<Prova> provaTemp = Main.getProvas();
			ListaLigada<Atleta> atletaTemp = Main.getAtleta();
			ListaLigada<Equipa> equipaTemp = Main.getEquipas();
			atletaTemp = Listagem.listarMedalhasAtleta(atletaTemp, equipaTemp, provaTemp,	anoInicio, anoFim, null, disciplina);
			corpoInicioDisciplina(fout);
			for (int i = 0; i < atletaTemp.size(); i++) {
				
				fout.format("<table border = 1>");
				fout.format("<tr>");
				fout.format("<td width=400> Posi&ccedil&atildeo<td> Nome </td> <td> Ouro </td> <td> Prata </td> <td> Bronze </td><td> Data de Emiss&atildeo");
				fout.format("</tr>");
				fout.format("<tr>");
				fout.format("<td width=400>" + (i+1) + "</td><td>" + atletaTemp.get(i).getNome() + "</td><td>" + atletaTemp.get(i).getMedalha().getOuro() + "</td><td>" + atletaTemp.get(i).getMedalha().getPrata() + "</td><td>" + atletaTemp.get(i).getMedalha().getBronze() + "</td><td>" + "Data de Hoje" + "</td>");
				fout.format("</tr>");
				fout.format("</table><br>");
				
			}
		} else {
			JOptionPane.showMessageDialog(janela,
					"Não existem países para exportar", "Export",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

	public void corpoInicioPais(Formatter fout) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">");
		fout.format("<head>");
		fout.format("<title> Jogos Ol&iacutempicos");
		fout.format("</title>");
		fout.format("</head>");
		fout.format("<body>");
		fout.format("<table border=1 align = center>");
		fout.format("<tr>");
		fout.format("<td rowspan = 2><img src=\"argolascr3.gif\" width=350 height= 140> </td>");
		fout.format("<td align = center width = 400 height = 70> Listagens </td>");
		fout.format("</tr>");
		fout.format("<tr>");
		fout.format("<td align = center width = 400 height= 70> Classificações de Países </td>");
		fout.format("</tr>");
		fout.format("</table><br>");
	}

	public void corpoInicioAtleta(Formatter fout) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">");
		fout.format("<head>");
		fout.format("<title> Jogos Ol&iacutempicos");
		fout.format("</title>");
		fout.format("</head>");
		fout.format("<body>");
		fout.format("<table border=1 align = center>");
		fout.format("<tr>");
		fout.format("<td rowspan = 2><img src=\"argolascr3.gif\" width=350 height= 140> </td>");
		fout.format("<td align = center width = 400 height = 70> Listagens </td>");
		fout.format("</tr>");
		fout.format("<tr>");
		fout.format("<td align = center width = 400 height= 70> Classificações de Atletas </td>");
		fout.format("</tr>");
		fout.format("</table><br>");

	}
	
	public void corpoInicioModalidade(Formatter fout) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">");
		fout.format("<head>");
		fout.format("<title> Jogos Ol&iacutempicos");
		fout.format("</title>");
		fout.format("</head>");
		fout.format("<body>");
		fout.format("<table border=1 align = center>");
		fout.format("<tr>");
		fout.format("<td rowspan = 2><img src=\"argolascr3.gif\" width=350 height= 140> </td>");
		fout.format("<td align = center width = 400 height = 70> Listagens </td>");
		fout.format("</tr>");
		fout.format("<tr>");
		fout.format("<td align = center width = 400 height= 70> Classificações Da Modalidade </td>");
		fout.format("</tr>");
		fout.format("</table><br>");

	}

	public void corpoInicioDisciplina(Formatter fout) {

		fout.format("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\n");
		fout.format("\"http://www.w3.org/TR/html4/loose.dtd\">");
		fout.format("<head>");
		fout.format("<title> Jogos Ol&iacutempicos");
		fout.format("</title>");
		fout.format("</head>");
		fout.format("<body>");
		fout.format("<table border=1 align = center>");
		fout.format("<tr>");
		fout.format("<td rowspan = 2><img src=\"argolascr3.gif\" width=350 height= 140> </td>");
		fout.format("<td align = center width = 400 height = 70> Listagens </td>");
		fout.format("</tr>");
		fout.format("<tr>");
		fout.format("<td align = center width = 400 height= 70> Classificações Da Disciplina </td>");
		fout.format("</tr>");
		fout.format("</table><br>");

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
