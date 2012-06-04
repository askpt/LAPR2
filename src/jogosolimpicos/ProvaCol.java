package jogosolimpicos;

import listaligada.*;

public abstract class ProvaCol extends Prova {

	private ListaLigada<ResultadosCol> resultadosCol = new ListaLigada<ResultadosCol>();

	public ProvaCol(Disciplina disc, JogosOlimpicos jogos) {

		super(disc, jogos);

	}

	// GETTERS

	public ListaLigada<ResultadosCol> getResultadosCol() {

		return resultadosCol;
	}

	public String toString() {

		return super.toString();
	}

	// SETTERS

	public void setResultadosCol(ListaLigada<ResultadosCol> resultadosCol) {

		this.resultadosCol = resultadosCol;
	}

}
