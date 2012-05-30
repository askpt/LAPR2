package jogosolimpicos;

import listaligada.*;

public class Atleta {

	private String nome;
	private String codPais;
	private int numid;
	private static int num;
	private Pais pais;
	private Modalidade mod;
	private ListaLigada disc = new ListaLigada();

	public Atleta(String nome, Modalidade mod, Pais pais) {

		this.numid = ++num;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getNome() {

		return nome;
	}

	public Pais getPais() {

		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Modalidade getModalidade() {

		return mod;
	}

	public void setModalidade(Modalidade mod) {

		this.mod = mod;
	}

	public void addDisciplina() {

	}

	public String getCodPais() {
		return codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String toString() {

		return String.format("%d: %s - %s", numid, nome, pais);
	}

}
