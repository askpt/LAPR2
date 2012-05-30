package jogosolimpicos;

import listaligada.*;

public class Atleta {

	private String nome;
	private String codPais;
	private int numid;
	private static int num;
	private Pais pais;
	private Modalidade mod;
	private Disciplina disciplina;
	private ListaLigada<Disciplina> disc = new ListaLigada<Disciplina>();

	public Atleta(String nome, Modalidade mod, Pais pais, Disciplina disciplina) {
		setID();
		setNome(nome);
		setModalidade(mod);
		setPais(pais);
		setDisciplina(disciplina);
	}

	public Atleta(String nome, Modalidade mod, Pais pais, ListaLigada<Disciplina> disciplina) {
		setID();
		setNome(nome);
		setModalidade(mod);
		setPais(pais);
		setDisciplinas(disciplina);
	}

	// GETTERS
	public void setDisciplinas(ListaLigada<Disciplina> disciplina) {
		for (int i = 0; i < disciplina.size(); i++) {
			if (!disc.contains(disciplina.get(i))) {
				disc.add(disciplina.get(i));
			}
		}
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Modalidade getModalidade() {

		return mod;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public ListaLigada<Disciplina> getDisciplinas() {
		return disc;
	}

	public String toString() {

		return String.format("%d: %s - %s", numid, nome, pais);
	}

	// SETTERS

	public void setDisciplina(Disciplina disciplina) {
		if (!disc.contains(disciplina)) {
			disc.add(disciplina);
		}
	}

	public void setID() {
		this.numid = ++num;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public void setModalidade(Modalidade mod) {

		this.mod = mod;
	}

}
