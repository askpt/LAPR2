package jogosolimpicos;

import listaligada.*;

public class ProvaInd extends Prova {

	private ListaLigada<ResultadosInd> resultados = new ListaLigada<ResultadosInd>();
	private String resulTemp;

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

	public void setResultadosInd(ListaLigada<ResultadosInd> resultadosInd) {

		this.resultados = resultadosInd;
	}

	private void convertTempo(Atleta atleta) {

		if (resulTemp.matches("^[0-9]{2}:[0-9]{2}:[0-9]{2}$")) {
			String temp[] = resulTemp.split(":");
			resultados.add(new ResultadosInd(atleta, Float.parseFloat(temp[0]) * 3600 + Float.parseFloat(temp[1]) * 60 + Float.parseFloat(temp[2])));
		} else if (resulTemp.matches("^[0-9]{1,2}:[0-9]{2}(.[0-9]{1,})?$")) {
			String temp[] = resulTemp.split(":");
			resultados.add(new ResultadosInd(atleta, Float.parseFloat(temp[0]) * 60 + Float.parseFloat(temp[1])));

		} else {
			resultados.add(new ResultadosInd(atleta, Float.parseFloat(resulTemp)));
		}

	}

}
