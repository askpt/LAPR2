package jogosolimpicos;

import listaligada.ListaLigada;

public class ProvaDistancia extends Prova {

	private String distancia;
	private ListaLigada<Resultados> resultado = new ListaLigada<Resultados>();

	public ProvaDistancia(Disciplina disc, JogosOlimpicos jogos, String distancia) {

		super(disc, jogos);
		setDistancia(distancia);

	}

	public void setDistancia(String distancia) {

		this.distancia = distancia;
	}

	public String getDistancia() {

		return distancia;
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

	public void atribuirMedalhasAtleta(ListaLigada<Atleta> atleta, ListaLigada<Pais> pais) {

		int atletaOuro = resultado.get(0).getIdAtleta();
		int atletaPrata = resultado.get(1).getIdAtleta();
		int atletaBronze = resultado.get(2).getIdAtleta();
		int iOuro = 0;
		int iPrata = 0;
		int iBronze = 0;

	}

}