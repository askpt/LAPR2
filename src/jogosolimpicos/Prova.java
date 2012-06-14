package jogosolimpicos;

import java.io.*;

/**
 * Main class for the competition with a year.
 * 
 */
@SuppressWarnings("serial")
public abstract class Prova implements Serializable {
	/**
	 * competition
	 * 
	 * @see Disciplina competition details
	 */
	private Disciplina disc;
	/**
	 * edition of the competition
	 * 
	 * @see JogosOlimpicos edition details
	 * 
	 */
	private JogosOlimpicos jogos;

	/**
	 * Main construction of the competition with a year
	 * 
	 * @param disc
	 *            competition
	 * @param jogos
	 *            edition of the competition
	 * @see Disciplina competition details
	 * @see JogosOlimpicos edition details
	 */
	public Prova(Disciplina disc, JogosOlimpicos jogos) {

		setDisciplina(disc);
		setJogosOlimpicos(jogos);
	}

	/**
	 * Set the edition of the olympic games
	 * 
	 * @param jogos
	 *            edition of the olympic games
	 * @see JogosOlimpicos edition details
	 */
	public void setJogosOlimpicos(JogosOlimpicos jogos) {
		this.jogos = jogos;

	}

	/**
	 * Set the competition of the olympic games
	 * 
	 * @param disc
	 *            competition
	 * @see Disciplina competition details
	 */
	public void setDisciplina(Disciplina disc) {
		this.disc = disc;

	}

	/**
	 * Get the edition of the olympic games
	 * 
	 * @return edition of the olympic games
	 * @see JogosOlimpicos edition details
	 */
	public JogosOlimpicos getJogosOlimpicos() {

		return jogos;
	}

	/**
	 * Get the competition of the olympic games
	 * 
	 * @return competition
	 * @see Disciplina competition details
	 */
	public Disciplina getDisciplina() {

		return disc;
	}

	/**
	 * 
	 * @return returns a String in this format: "games - name". Eg.:
	 *         "2012 London Game - 100m"
	 */
	public String toString() {

		return String.format("%s - %s", jogos, disc.getNome());
	}

	/**
	 * @param obj
	 *            object to be compared.
	 * @return true if the competition in that year insert is equal to this
	 *         competition in this year.
	 * @see java.lang.String#equalsIgnoreCase(java.lang.String) String
	 *      comparison.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Prova) {
			Prova that = (Prova) obj;
			return (this.disc.getNome().equalsIgnoreCase(that.getDisciplina().getNome()) && this.disc.getModalidade().getNome().equalsIgnoreCase(that.getDisciplina().getModalidade().getNome()) && this.disc.getTipoMod() == that.getDisciplina().getTipoMod() && this.jogos.getAno() == that.getJogosOlimpicos().getAno());
		}
		return false;
	}

	/**
	 * Ordering methods for classification intended.
	 */
	public abstract void ordenar();

}
