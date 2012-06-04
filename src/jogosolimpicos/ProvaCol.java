package jogosolimpicos;

import listaligada.*;

public class ProvaCol extends Prova {

	private ListaLigada<ResultadosCol> resultados = new ListaLigada<ResultadosCol>();

	public ProvaCol(Disciplina disc, JogosOlimpicos jogos) {

		super(disc, jogos);

	}

	// GETTERS

	public ListaLigada<ResultadosCol> getResultados() {

		return resultados;
	}

	public String toString() {

		return super.toString();
	}

	// SETTERS

	public void setResultados(ListaLigada<ResultadosCol> resultados) {

		this.resultados = resultados;
	}

}
