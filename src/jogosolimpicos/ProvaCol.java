package jogosolimpicos;

import java.io.*;
import listaligada.*;

/**
 * Main class for the team competition with a year.
 * 
 * @see Prova competition details.
 */
@SuppressWarnings("serial")
public class ProvaCol extends Prova implements Serializable {
	/**
	 * List of results.
	 * 
	 * @see ResultadosCol results details
	 */
	private ListaLigada<ResultadosCol> resultados = new ListaLigada<ResultadosCol>();

	/**
	 * Main constructor for this competition.
	 * 
	 * @param disc
	 *            competition
	 * @param jogos
	 *            edition of the olympic games
	 * @see Disciplina competition details
	 * @see JogosOlimpicos edition details
	 */
	public ProvaCol(Disciplina disc, JogosOlimpicos jogos) {

		super(disc, jogos);

	}

	/**
	 * Get the results.
	 * 
	 * @return the results
	 * @see ResultadosCol results details
	 */
	public ListaLigada<ResultadosCol> getResultados() {

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
	 *            list of the results
	 * @see ResultadosCol result details
	 */
	public void setResultados(ListaLigada<ResultadosCol> resultados) {

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
						resultados.set(i, (ResultadosCol) obj);
					}
				}
			}
		} else {
			for (int i = 0; i < resultados.size(); i++) {
				for (int j = i + 1; j < resultados.size(); j++) {
					if (resultados.get(i).compareTo(resultados.get(j)) > 0) {
						Object obj = resultados.get(j);
						resultados.set(j, resultados.get(i));
						resultados.set(i, (ResultadosCol) obj);
					}
				}
			}
		}

	}

	// TODO remover
	@Override
	public String toStringTest() {
		return String.format("Coletivo, %s, %d, %d", this.getDisciplina().getNome(), this.getDisciplina().getGenero(), this.getJogosOlimpicos().getAno());

	}

}
