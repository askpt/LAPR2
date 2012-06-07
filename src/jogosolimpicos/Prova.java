package jogosolimpicos;

public abstract class Prova {

	private Disciplina disc;
	private JogosOlimpicos jogos;

	public Prova(Disciplina disc, JogosOlimpicos jogos) {

		setDisciplina(disc);
		setJogosOlimpicos(jogos);
	}

	public void setJogosOlimpicos(JogosOlimpicos jogos) {
		this.jogos = jogos;

	}

	public void setDisciplina(Disciplina disc) {
		this.disc = disc;

	}

	public JogosOlimpicos getJogosOlimpicos() {

		return jogos;
	}

	public Disciplina getDisciplina() {

		return disc;
	}

	public String toString() {

		return String.format("%s - %s", jogos, disc.getNome());
	}

	public boolean equals(Disciplina disc) {
		return (this.disc.getNome().equalsIgnoreCase(disc.getNome()) && this.disc.getModalidade().getNome().equalsIgnoreCase(disc.getModalidade().getNome()) && this.disc.getTipoMod() == disc.getTipoMod());
	}

}
