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

	@Override
	public void ordenar() {
		if (super.getDisciplina().getOrdenacao()) {
			for (int i = 0; i < resultados.size() - 1; i++) {
				for (int j = i + 1; j < resultados.size(); j++) {
					if (resultados.get(i).compareTo(resultados.get(j)) < 0) {
						Object obj = resultados.get(j);
						resultados.set(j, resultados.get(i));
						resultados.set(i, (ResultadosInd) obj);
					}
				}
			}
		} else {
			for (int i = 0; i < resultados.size(); i++) {
				for (int j = i + 1; j < resultados.size(); j++) {
					if (resultados.get(i).compareTo(resultados.get(j)) > 0) {
						Object obj = resultados.get(j);
						resultados.set(j, resultados.get(i));
						resultados.set(i, (ResultadosInd) obj);
					}
				}
			}
		}

	}

	@Override
	public String toStringTest() {
		return String.format("Individual, %s, %d, %d", this.getDisciplina().getNome(), this.getDisciplina().getGenero(), this.getJogosOlimpicos().getAno());

	}

}
