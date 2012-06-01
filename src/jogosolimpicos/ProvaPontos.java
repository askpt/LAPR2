package jogosolimpicos;

import listaligada.ListaLigada;

public class ProvaPontos extends Prova {

	private float ponto;
	private ListaLigada<Resultados> resultado = new ListaLigada<Resultados>();

	public ProvaPontos(Disciplina disc, JogosOlimpicos jogos, float ponto) {

		super(disc, jogos);
		setPonto(ponto);

	}

	public void setPonto(float ponto) {

		this.ponto = ponto;
	}

	public float getPonto() {

		return ponto;
	}

	public void ordenar() {
		for (int i = 0; i < resultado.size() - 1; i++) {
			for (int j = i; j < resultado.size(); j++) {
				if (resultado.get(i).compareTo(resultado.get(j)) < 0) {
					Object obj = resultado.get(j);
					resultado.set(j, resultado.get(i));
					resultado.set(i, (Resultados) obj);
				}
			}
		}
	}

}
