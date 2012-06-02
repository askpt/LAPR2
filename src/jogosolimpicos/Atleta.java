package jogosolimpicos;

import listaligada.*;

public class Atleta {

	private String nome;
	private int numid;
	private static int num;
	private Pais pais;
	private Modalidade mod;
	private ListaLigada<ProvaInd> provas = new ListaLigada<ProvaInd>();
	private boolean equipa = false;
	private Medalhas medalha;

	public Atleta(String nome, Modalidade mod, Pais pais, ProvaInd prova, boolean equipa) {
		//
		setID();
		setNome(nome);
		setModalidade(mod);
		setPais(pais);
		addProva(prova);
		setEquipa(equipa);
		medalha = new Medalhas();
	}

	// GETTERS

	public void setProvas(ListaLigada<ProvaInd> provas) {

		for (int i = 0; i < this.provas.size(); i++) {
			if (!this.provas.contains(provas.get(i))) {
				this.provas.add(provas.get(i));
			}
		}
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

	public ListaLigada<ProvaInd> getProvas() {

		return provas;
	}

	public String toString() {

		return String.format("%d: %s - %s", numid, nome, pais);
	}

	// SETTERS

	public void addProva(ProvaInd prova) {

		if (!provas.contains(prova)) {
			provas.add(prova);
		}
	}

	public int getID() {

		return numid;
	}

	private void setID() {

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

	public void setEquipa(boolean equipa) {

		this.equipa = equipa;

	}

	public void setMedalha(Medalhas medalha) {

		this.medalha = medalha;
	}

	public Medalhas getMedalha() {

		return medalha;
	}

}
