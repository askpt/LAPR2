package jogosolimpicos;

public class Disciplina {

	private Modalidade mod;
	private String nome;
	private boolean tipoDisc; // true = coletivo false = individual
	private int genero; // 0 = masculino 1 = feminino 2 = both sem mixed masc
						// 3 = both sem mixed fem 4 = mixed
	private boolean ordenacao; // true = maior false = menor
	private int tipoClass; // 0 - distancia 1 = tempo 2 = pontos 3 = rank

	public Disciplina(String nome, Modalidade modalidade, boolean tipoDisc, int genero, boolean ordenacao, int tipoClass) {

		setNome(nome);
		setModalidade(modalidade);
		setTipoDisc(tipoDisc);
		setGenero(genero);
		setTipoClass(tipoClass);
		setOrdenacao(ordenacao);
	}

	public Disciplina(String nome) {
		setNome(nome);
		setGenero(-1);
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
		mod.getDisc().add(this);

	}

	public boolean isOrdenacao() {
		return ordenacao;
	}

	public void setOrdenacao(boolean ordenacao) {
		this.ordenacao = ordenacao;
	}

	public int getTipoClass() {
		return tipoClass;
	}

	public void setTipoClass(int tipoClass) {
		this.tipoClass = tipoClass;
	}

	public String toString() {

		return String.format("%s", nome);
	}

	public String toStringTest() {
		return String.format("%s - %s - %s - %d - %d - %s", mod, nome, tipoDisc, genero, tipoClass, ordenacao);
	}

	public boolean equals(Disciplina disc) {
		return (this.getNome().equalsIgnoreCase(disc.getNome()) && this.tipoDisc == disc.getTipoMod() && this.getModalidade().equals(disc.getModalidade()) && this.genero == disc.getGenero());
	}

}
