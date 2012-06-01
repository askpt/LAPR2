package jogosolimpicos;

public class Disciplina {

	private String mod;
	private String nome;
	private boolean tipoDisc; // true = coletivo false = individual
	private int genero; // 0 = masculino 1 = feminino 2 = both sem mixed masc
						// 3 = both sem mixed fem 4 = mixed

	public Disciplina(String nome, String modalidade, boolean tipoDisc, int genero) {

		setNome(nome);
		setModalidade(modalidade);
		setTipoDisc(tipoDisc);
		setGenero(genero);
	}

	public Disciplina() {

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

	public String getModalidade() {

		return mod;
	}

	public void setModalidade(String mod) {

		this.mod = mod;

	}

	public String toString() {

		return String.format("%s", nome);
	}

	public String toStringTest() {
		return String.format("%s - %s - %s - %d", mod, nome, tipoDisc, genero);
	}

	public boolean equals(Disciplina disc) {
		return (this.getNome().equalsIgnoreCase(disc.getNome()) && this.tipoDisc == disc.getTipoMod() && this.getModalidade().equalsIgnoreCase(disc.getModalidade()) && this.genero == disc.getGenero());
	}

}
