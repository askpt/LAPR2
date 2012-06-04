package jogosolimpicos;

import listaligada.*;

public class ProvaInd extends Prova {

	private ListaLigada<ResultadosInd> resultados = new ListaLigada<ResultadosInd>();

	public ProvaInd(Disciplina disc, JogosOlimpicos jogos) {

		super(disc, jogos);
	}

	// GETTERS

	public ListaLigada<ResultadosInd> getResultados() {

		return resultados;
	}

	public String toString() {

		return super.toString();
	}

	// SETTERS

	public void setResultadosInd(ListaLigada<ResultadosInd> resultados) {

		this.resultados = resultados;
	}

}
