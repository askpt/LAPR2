package jogosolimpicos;

import listaligada.*;

public class Atleta {

	private String nome;
	private String codPais;
	private int numid;
	private static int num;
	private Pais pais;
	private Modalidade mod;
	private ListaLigada<Prova> provas = new ListaLigada<Prova>();

	public Atleta(String nome, Modalidade mod, Pais pais, Prova prova) {

		setID();
		setNome(nome);
		setModalidade(mod);
		setPais(pais);
		addProva(prova);
	}

	// public Atleta( String nome , Modalidade mod , Pais pais , ListaLigada <
	// Prova > provas ) {
	//
	// setID();
	// setNome( nome );
	// setModalidade( mod );
	// setPais( pais );
	// setProvas( provas );
	// }

	// GETTERS
	public String getCodPais() {

		return codPais;
	}

	public void setProvas(ListaLigada<Prova> provas) {

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

	public ListaLigada<Prova> getProvas() {

		return provas;
	}

	public String toString() {

		return String.format("%d: %s - %s", numid, nome, pais);
	}

	// SETTERS
	public void setCodPais(String codPais) {

		this.codPais = codPais;
	}

	public void addProva(Prova prova) {

		if (!provas.contains(prova)) {
			provas.add(prova);
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
