package jogosolimpicos;

public class Atleta {

	private String nome;
	private int numid;
	private static int num;
	private Pais pais;
	private Medalhas medalha;

	public Atleta(String nome, Pais pais) {
		//
		setID();
		setNome(nome);
		setPais(pais);
		medalha = new Medalhas();
	}

	// GETTERS

	public String getNome() {

		return nome;
	}

	public Pais getPais() {

		return pais;
	}

	public String toString() {

		return String.format("%d: %s - %s", numid, nome, pais);
	}

	// SETTERS

	public int getID() {

		return numid;
	}

	private void setID() {

		this.numid = ++num;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public void setPais(Pais pais) {

		this.pais = pais;
	}

	public void setMedalha(Medalhas medalha) {

		this.medalha = medalha;
	}

	public Medalhas getMedalha() {

		return medalha;
	}

}
