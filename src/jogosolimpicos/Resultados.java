package jogosolimpicos;

@SuppressWarnings("rawtypes")
public class Resultados implements Comparable {

	@SuppressWarnings("unused")
	private int idAtleta;
	private float resultado;

	public Resultados(int idAtleta, float resultado) {

	}

	public float getResultado() {
		return resultado;
	}

	public void setResultados(float resultado) {
		this.resultado = resultado;
	}

	@Override
	public int compareTo(Object outro) {
		return (int) (this.getResultado() - ((Resultados) outro).getResultado());
	}

	@Override
	public String toString() {
		return String.format("%.2f", resultado);
	}
}
