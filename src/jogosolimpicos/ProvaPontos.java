package jogosolimpicos;

public class ProvaPontos extends Prova {

	private float ponto;

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

}
