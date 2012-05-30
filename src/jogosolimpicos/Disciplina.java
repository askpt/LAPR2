package jogosolimpicos;

import listaligada.ListaLigada;

public class Disciplina {

	private Modalidade mod;
	private String nome;

	public Disciplina() {

		setModalidade(mod);
		setNome(nome);
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getNome() {

		return nome;
	}

	public Modalidade getModalidade() {

		return mod;
	}

	public void setModalidade(Modalidade mod) {
		this.mod = mod;

	}

	public String toString(){
		
		return String.format("%s", nome);
	}
	
}
