package gui;

import java.io.*;
import java.net.*;

import javax.swing.*;

import jogosolimpicos.*;
import listaligada.*;
import dados.*;

/**
 * Main class of the program.
 * 
 */
public class Main {
	/**
	 * Linked list of athletes
	 */
	private static ListaLigada<Atleta> atleta = new ListaLigada<Atleta>();
	/**
	 * Linked list of the country
	 */
	private static ListaLigada<Pais> paises = new ListaLigada<Pais>();
	/**
	 * Linked list of the sports
	 */
	private static ListaLigada<Modalidade> modalidades = new ListaLigada<Modalidade>();
	/**
	 * Linked list of the competitions with events
	 */
	private static ListaLigada<Prova> provas = new ListaLigada<Prova>();
	/**
	 * Linked list of the competitions
	 */
	private static ListaLigada<Disciplina> disciplinas = new ListaLigada<Disciplina>();
	/**
	 * Linked list of the team
	 */
	private static ListaLigada<Equipa> equipas = new ListaLigada<Equipa>();
	/**
	 * Linked list of the events
	 */
	private static ListaLigada<JogosOlimpicos> jogos = new ListaLigada<JogosOlimpicos>();
	/**
	 * Linked list of the languages
	 */
	private static ListaLigada<Linguas> lingua = new ListaLigada<Linguas>();
	/**
	 * Main graphical user interface
	 */
	private static JanelaPrincipal maingui;

	/**
	 * Get the sports
	 * 
	 * @return linked list of the sports
	 */
	public static ListaLigada<Modalidade> getModalidades() {
		return modalidades;
	}

	/**
	 * Get the countries
	 * 
	 * @return linked list of the countries
	 */
	public static ListaLigada<Pais> getPaises() {
		return paises;
	}

	/**
	 * Get the athletes
	 * 
	 * @return linked list of the athletes
	 */
	public static ListaLigada<Atleta> getAtleta() {
		return atleta;
	}

	/**
	 * Get the competitions with events
	 * 
	 * @return linked list of the competition with events
	 */
	public static ListaLigada<Prova> getProvas() {
		return provas;
	}

	/**
	 * Get the languages
	 * 
	 * @return linked list of the languages
	 */
	public static ListaLigada<Linguas> getLingua() {
		return lingua;
	}

	/**
	 * The main method to start the program. This method will show a splash
	 * image while loads the previous state of the program.
	 * 
	 * @param args
	 *            command line parameters
	 */
	public static void main(String[] args) {
		Imagens img = new Imagens();
		@SuppressWarnings("unused")
		SplashScreen splash = new SplashScreen(5000, img.splash, true);
		lerEstadoAnterior();
		adicionarLinguas();
		try {
			maingui = new JanelaPrincipal();
		} catch (URISyntaxException e) {

		}

	}

	/**
	 * Method who will add the default export languages of the program.
	 */
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

	/**
	 * Get the competitions
	 * 
	 * @return linked list of the competitions
	 */
	public static ListaLigada<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * Get the teams
	 * 
	 * @return linked list of the teams
	 */
	public static ListaLigada<Equipa> getEquipas() {
		return equipas;
	}

	/**
	 * Get the events
	 * 
	 * @return linked list of the events
	 */
	public static ListaLigada<JogosOlimpicos> getJogos() {
		return jogos;
	}

	/**
	 * Method to save the current state of the program.
	 */
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
		}
	}

	/**
	 * Method to read the previous state of the program.
	 */
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
