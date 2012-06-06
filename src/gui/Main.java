package gui;

import java.net.URISyntaxException;

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

	public static void main(String[] args) {
		try {
			JanelaPrincipal teste = new JanelaPrincipal();
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

}
