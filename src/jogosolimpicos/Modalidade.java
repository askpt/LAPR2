package jogosolimpicos;

import listaligada.*;

public class Modalidade {

	private String nome;
	private ListaLigada<Disciplina> disc;

	public Modalidade(String nome) {

		setNome(nome);
		disc = new ListaLigada<Disciplina>();
	}

	public ListaLigada<Disciplina> getDisc() {

		return disc;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getNome() {

		return nome;
	}

	public String toString() {

		return String.format("%s", this.nome);

	}

	public String toStringTest() {
		return String.format("%s - %s", this.nome, this.disc);
	}
}
