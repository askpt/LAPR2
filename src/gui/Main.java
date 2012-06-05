package gui;

import jogosolimpicos.*;
import listaligada.*;

public class Main {

	private static ListaLigada<Atleta> atleta = new ListaLigada<Atleta>();
	private static ListaLigada<Pais> paises = new ListaLigada<Pais>();
	private static ListaLigada<Modalidade> modalidades = new ListaLigada<Modalidade>();
	private static ListaLigada<Prova> provas = new ListaLigada<Prova>();
	private static ListaLigada<Disciplina> disciplinas = new ListaLigada<Disciplina>();
	private static ListaLigada<Equipa> equipas = new ListaLigada<Equipa>();

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

	}

	public static ListaLigada<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public static ListaLigada<Equipa> getEquipas() {
		return equipas;
	}

}
