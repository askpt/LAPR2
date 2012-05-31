package gui;

import jogosolimpicos.*;
import listaligada.*;

public class Main {

	private static ListaLigada<Atleta> atleta = new ListaLigada<Atleta>();
	private static ListaLigada<Pais> paises = new ListaLigada<Pais>();
	private static ListaLigada<Modalidade> modalidades = new ListaLigada<Modalidade>();
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

	public static void main(String[] args) {

	}

}
