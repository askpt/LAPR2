package gui;

import java.io.*;

import javax.swing.*;

import jogosolimpicos.*;
import listaligada.*;
import dados.*;

public class Main {

	private static ListaLigada<Atleta> atleta = new ListaLigada<Atleta>();
	private static ListaLigada<Pais> paises = new ListaLigada<Pais>();
	private static ListaLigada<Modalidade> modalidades = new ListaLigada<Modalidade>();
	private static ListaLigada<Prova> provas = new ListaLigada<Prova>();
	private static ListaLigada<Disciplina> disciplinas = new ListaLigada<Disciplina>();
	private static ListaLigada<Equipa> equipas = new ListaLigada<Equipa>();
	private static ListaLigada<JogosOlimpicos> jogos = new ListaLigada<JogosOlimpicos>();
	private static ListaLigada<Linguas> lingua = new ListaLigada<Linguas>();
	private static JanelaPrincipal maingui;
	public static Teste i = new Teste("Teste");

	public static ListaLigada<Modalidade> getModalidades() {
		return modalidades;
	}

	public static ListaLigada<Pais> getPaises() {
		return paises;
	}

	public static ListaLigada<Atleta> getAtleta() {
		return atleta;
	}

	public static ListaLigada<Prova> getProvas() {
		return provas;
	}

	public static ListaLigada<Linguas> getLingua() {
		return lingua;
	}

	public static void main(String[] args) {
		lerEstadoAnterior();
		adicionarLinguas();
		SplashScreen splash = new SplashScreen(3000);
		splash.showSplashAndAPP();

	}

	private static void adicionarLinguas() {
		boolean checkGB = true;
		boolean checkFR = true;
		boolean checkPT = true;
		for (int i = 0; i < getLingua().size(); i++) {
			if (getLingua().get(i).getLinguagem().equalsIgnoreCase("PT-PT")) {
				checkPT = false;
			} else if (getLingua().get(i).getLinguagem().equalsIgnoreCase("EN-GB")) {
				checkGB = false;
			} else if (getLingua().get(i).getLinguagem().equalsIgnoreCase("FR-FR")) {
				checkFR = false;
			}
		}
		if (checkGB) {
			getLingua().add(new Linguas("EN-GB", "Olympic Games", "Listing", "Classification", "Position", "Name", "Gold", "Silver", "Bronze", "Athlete", "Sport", "Competition", "Country", "Emission Date"));
		}
		if (checkFR) {
			getLingua().add(new Linguas("FR-FR", "Jeux Olympiques", "Liste", "Classification", "Position", "Nom", "Or", "Argent", "Bronze", "Athl&egrave;te", "Modalit&eacute;", "Discipline", "Pays", "Date d'&eacute;mission"));
		}
		if (checkPT) {
			getLingua().add(new Linguas("PT-PT", "Jogos Ol&iacute;mpicos", "Listagem", "Classifica&ccedil;&atilde;o", "Posi&ccedil;&atilde;o", "Nome", "Ouro", "Prata", "Bronze", "Atletas", "Modalidade", "Disciplina", "Pa&iacute;s", "Data de Emiss&atilde;o"));
		}

	}

	public static ListaLigada<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public static ListaLigada<Equipa> getEquipas() {
		return equipas;
	}

	public static ListaLigada<JogosOlimpicos> getJogos() {
		return jogos;
	}

	public static void gravarEstado() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("estado.bin"));
			out.writeObject(atleta);
			out.writeObject(modalidades);
			out.writeObject(provas);
			out.writeObject(paises);
			out.writeObject(equipas);
			out.writeObject(disciplinas);
			out.writeObject(jogos);
			out.writeObject(lingua);
			out.close();
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(maingui, "Status not saved!", "Closing Application", JOptionPane.ERROR_MESSAGE);
			exc.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked" })
	private static void lerEstadoAnterior() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("estado.bin"));
			atleta = (ListaLigada<Atleta>) in.readObject();
			modalidades = (ListaLigada<Modalidade>) in.readObject();
			provas = (ListaLigada<Prova>) in.readObject();
			paises = (ListaLigada<Pais>) in.readObject();
			equipas = (ListaLigada<Equipa>) in.readObject();
			disciplinas = (ListaLigada<Disciplina>) in.readObject();
			jogos = (ListaLigada<JogosOlimpicos>) in.readObject();
			lingua = (ListaLigada<Linguas>) in.readObject();
			in.close();
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(maingui, "Previous status wasn't successfully loaded!", "Loading previous status", JOptionPane.ERROR_MESSAGE);

		} catch (ClassNotFoundException exc) {
			JOptionPane.showMessageDialog(maingui, "Previous status wasn't successfully loaded!", "Loading previous status", JOptionPane.ERROR_MESSAGE);
		}
	}

}
