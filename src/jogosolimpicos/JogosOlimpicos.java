package jogosolimpicos;

public class JogosOlimpicos {

	private int ano;
	private String cidade;

	public JogosOlimpicos(int ano, String cidade) {

		setAno(ano);
		setCidade(cidade);

	}

	public JogosOlimpicos(int ano) {
		setAno(ano);
	}

	public String getCidade() {

		return cidade;
	}

	public int getAno() {

		return ano;
	}

	public void setCidade(String cidade) {

		this.cidade = cidade;

	}

	public void setAno(int ano) {

		this.ano = ano;

	}

	public String toString() {

		return String.format("%d %s Games", ano, cidade);
	}

}
