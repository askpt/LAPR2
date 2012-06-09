package jogosolimpicos;

import java.io.*;

@SuppressWarnings("serial")
public abstract class Prova implements Serializable {

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

	public boolean equals(Prova disc) {
		return (this.disc.getNome().equalsIgnoreCase(disc.getDisciplina().getNome()) && this.disc.getModalidade().getNome().equalsIgnoreCase(disc.getDisciplina().getModalidade().getNome()) && this.disc.getTipoMod() == disc.getDisciplina().getTipoMod());
	}

	public abstract void ordenar();

	public abstract String toStringTest();

}
