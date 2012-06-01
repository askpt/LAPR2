package jogosolimpicos;

public class Disciplina {

	private Modalidade mod;
	private String nome;
	private boolean tipoDisc; // true = coletivo false = individual
	private int genero; // 0 = masculino 1 = feminino 2 = both sem mixed masc
						// 3 = both sem mixed fem 4 = mixed

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

	public boolean equals(Disciplina disc) {
		return (this.getNome().equalsIgnoreCase(disc.getNome()) && this.tipoDisc == disc.getTipoMod() && this.mod.getNome().equalsIgnoreCase(disc.getModalidade().getNome()) && this.genero == disc.getGenero());
	}

}
