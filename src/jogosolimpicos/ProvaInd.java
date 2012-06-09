package jogosolimpicos;

import java.io.*;
import listaligada.*;

/**
 * 
 * Main class for the individual competition in this year.
 * 
 */
@SuppressWarnings("serial")
public class ProvaInd extends Prova implements Serializable {
	/**
	 * List of results
	 * 
	 * @see ResultadosInd result details
	 */
	private ListaLigada<ResultadosInd> resultados = new ListaLigada<ResultadosInd>();

	/**
	 * Main constructor of the competition in this year
	 * 
	 * @param disc
	 *            competition
	 * @param jogos
	 *            edition of the competition
	 * @see Disciplina competition details
	 * @see JogosOlimpicos edition details
	 */
	public ProvaInd(Disciplina disc, JogosOlimpicos jogos) {

		super(disc, jogos);
	}

	/**
	 * Get the list of results
	 * 
	 * @return the list of results
	 * @see ResultadosInd result details
	 */
	public ListaLigada<ResultadosInd> getResultados() {

		return resultados;
	}

	/**
	 * @see Prova#toString() toString
	 */
	public String toString() {

		return super.toString();
	}

	/**
	 * Add a list of the results
	 * 
	 * @param resultados
	 *            list of results
	 * @see ResultadosInd result details
	 */
	public void setResultadosInd(ListaLigada<ResultadosInd> resultados) {

		this.resultados = resultados;
	}

	/**
	 * Ordering methods for classification intended.
	 */
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

	// TODO remover
	@Override
	public String toStringTest() {
		return String.format("Individual, %s, %d, %d", this.getDisciplina().getNome(), this.getDisciplina().getGenero(), this.getJogosOlimpicos().getAno());

	}

}
