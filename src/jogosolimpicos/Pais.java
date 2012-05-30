package jogosolimpicos;

public class Pais {

	private String codigoPais;
	private String nomePais;
	private Medalhas medalha;

	public Pais(String codigoPais, String nomePais) {
		setCodigoPais(codigoPais);
		setNomePais(nomePais);

	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public void setMedalha() {
		this.medalha = new Medalhas();
	};

	public Medalhas getMedalha() {
		return this.medalha;
	}

	@Override
	public String toString() {
		return String.format("%s - %s", codigoPais, nomePais);
	}

}
