package jogosolimpicos;

public class JogosOlimpicos {

	private int ano;
	private String cidade;

	public JogosOlimpicos(int ano, String cidade) {

		setAno(ano);
		setCidade(cidade);

	}

	public void setCidade(String cidade) {
		this.cidade = cidade;

	}

	public String getCidade() {

		return cidade;
	}

	public int getAno() {

		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;

	}

}
