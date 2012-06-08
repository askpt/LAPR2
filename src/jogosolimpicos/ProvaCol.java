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

	@Override
	public void ordenar() {
		if (super.getDisciplina().getOrdenacao()) {
			for (int i = 0; i < resultados.size() - 1; i++) {
				for (int j = 0; j < resultados.size(); j++) {
					if (resultados.get(i).compareTo(resultados.get(j)) < 0) {
						Object obj = resultados.get(j);
						resultados.set(j, resultados.get(i));
						resultados.set(i, (ResultadosCol) obj);
					}
				}
			}
		} else {
			for (int i = 0; i < resultados.size(); i++) {
				for (int j = 0; j < resultados.size(); j++) {
					if (resultados.get(i).compareTo(resultados.get(j)) > 0) {
						Object obj = resultados.get(j);
						resultados.set(j, resultados.get(i));
						resultados.set(i, (ResultadosCol) obj);
					}
				}
			}
		}

	}

}
