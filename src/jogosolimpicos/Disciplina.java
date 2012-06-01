package jogosolimpicos;

public class Disciplina {

	private Modalidade mod;
	private String nome;
	private boolean tipoDisc;
	private int genero;

	public Disciplina(String nome, Modalidade modalidade, boolean tipoDisc, int genero) {

		setNome(nome);
		setModalidade(mod);
		setTipoDisc(tipoDisc);
		setGenero(genero);
	}

	public void setGenero(int genero) {

		this.genero = genero;
	}

	public void setTipoDisc(boolean tipoDisc) {

		this.tipoDisc = tipoDisc;

	}

	public int getGenero() {

		return genero;
	}

	public boolean getTipoMod() {

		return tipoDisc;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getNome() {

		return nome;
	}

	public Modalidade getModalidade() {

		return mod;
	}

	public void setModalidade(Modalidade mod) {

		this.mod = mod;

	}

	public String toString() {

		return String.format("%s", nome);
	}

}
