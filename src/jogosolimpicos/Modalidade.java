package jogosolimpicos;

import listaligada.ListaLigada;

public class Modalidade {

	private String nome;
	private ListaLigada<Disciplina> disc;

	public Modalidade(String nome) {

		setNome(nome);
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getNome() {

		return nome;
	}
}
