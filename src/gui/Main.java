package gui;

import jogosolimpicos.*;
import listaligada.*;

public class Main {

	private static ListaLigada<Atleta> atleta = new ListaLigada<Atleta>();
	private static ListaLigada<Pais> paises = new ListaLigada<Pais>();
	private static ListaLigada<Modalidade> modalidades = new ListaLigada<Modalidade>();
	private static ListaLigada<ProvaInd> provas = new ListaLigada<ProvaInd>();
	private static ListaLigada<Disciplina> disciplinas = new ListaLigada<Disciplina>();
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

	public static ListaLigada<ProvaInd> getProvas() {
		return provas;
	}

	public static void main(String[] args) {

	}

	public static ListaLigada<Disciplina> getDisciplinas() {
		return disciplinas;
	}

}
