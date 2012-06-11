package gui;

import java.io.*;
import java.net.*;

import javax.swing.*;

import dados.*;

import jogosolimpicos.*;
import listaligada.*;

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
		try {
			maingui = new JanelaPrincipal();
		} catch (URISyntaxException e) {

			e.printStackTrace();
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
			out.close();
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(maingui, "Status not saved!", "Closing Application", JOptionPane.ERROR_MESSAGE);
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
			in.close();
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(maingui, "Previous status wasn't successfully loaded!", "Loading previous status", JOptionPane.ERROR_MESSAGE);

		} catch (ClassNotFoundException exc) {
			JOptionPane.showMessageDialog(maingui, "Previous status wasn't successfully loaded!", "Loading previous status", JOptionPane.ERROR_MESSAGE);
		}
	}

}
