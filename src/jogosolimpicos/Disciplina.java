package jogosolimpicos;

import java.io.*;

/**
 * Main class of the generic competition.
 * 
 */

@SuppressWarnings("serial")
public class Disciplina implements Serializable {
	/**
	 * the sport of the competition.
	 * 
	 * @see Modalidade
	 */
	private Modalidade mod;
	/**
	 * the name of the competition.
	 */
	private String nome;
	/**
	 * the type of the competition. True = Team, False = Individual.
	 */
	private boolean tipoDisc;
	/**
	 * the genre of the competition. Male = 0, Female = 1, Mixed = 2
	 */
	private int genero;
	/**
	 * the ordination of this competition. Highest: true, Lowest: false
	 */
	private boolean ordenacao;
	/**
	 * the type of the classification of this competition. Distance = 0, time =
	 * 1, score = 2 and ranked = 3.
	 */
	private int tipoClass;

	/**
	 * Main constructor of this class.
	 * 
	 * @param nome
	 *            the name of the competition.
	 * @param modalidade
	 *            the sport of this competition.
	 * @param tipoDisc
	 *            the type of the competition. If is a team competition, this
	 *            atribute is True.
	 * @param genero
	 *            the genre of this competition. If is a male competion, is 0
	 *            (zero), if is a female is 1(one) and if is a mixed competition
	 *            is 2(two).
	 * @param ordenacao
	 *            the ordination of this competition. If is the highest, who
	 *            wins, this atribute is true.
	 * @param tipoClass
	 *            the type of classification of this competition. If is a
	 *            distance competition, is 0(zero), if is a time competition, is
	 *            1(one), if is a score competition, is 2(two) and if is a
	 *            ranked competition, is 3(three).
	 */

	public Disciplina(String nome, Modalidade modalidade, boolean tipoDisc, int genero, boolean ordenacao, int tipoClass) {
		setNome(nome);
		setModalidade(modalidade);
		setTipoDisc(tipoDisc);
		setGenero(genero);
		setTipoClass(tipoClass);
		setOrdenacao(ordenacao);
	}

	/**
	 * Constructor for the competition who only we know the name. By default,
	 * the genre will be invalid (-1).
	 * 
	 * @param nome
	 *            name of the competition
	 */

	public Disciplina(String nome) {
		setNome(nome);
		setGenero(-1);
	}

	/**
	 * Set the genre of this competition.
	 * 
	 * @param genero
	 *            the genre of this competition. Male = 0, Female = 1, Mixed = 2
	 */

	public void setGenero(int genero) {
		this.genero = genero;
	}

	/**
	 * Set the type of this competition.
	 * 
	 * @param tipoDisc
	 *            True = Team, False = Individual.
	 */

	public void setTipoDisc(boolean tipoDisc) {
		this.tipoDisc = tipoDisc;
	}

	/**
	 * Get the genre of this competition.
	 * 
	 * @return the genre of this competition. Male = 0, Female = 1, Mixed = 2
	 */

	public int getGenero() {
		return genero;
	}

	/**
	 * Get the type of this competition.
	 * 
	 * @return the type of this competition. True = Team, False = Individual.
	 */

	public boolean getTipoMod() {
		return tipoDisc;
	}

	/**
	 * Set the name of this competition.
	 * 
	 * @param nome
	 *            the name of the competition.
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Get the name of the competition.
	 * 
	 * @return name of the competition.
	 */

	public String getNome() {
		return nome;
	}

	/**
	 * Get the sport of this competition.
	 * 
	 * @return the sport of the competition.
	 * @see Modalidade Sport details
	 */

	public Modalidade getModalidade() {
		return mod;
	}

	/**
	 * Set the sport of this competition.
	 * 
	 * @param mod
	 *            the sport of the competition.
	 * @see Modalidade Sport details
	 */

	public void setModalidade(Modalidade mod) {
		this.mod = mod;
		mod.getDisc().add(this);
	}

	/**
	 * Get the ordination of this competition.
	 * 
	 * @return the ordination of the competition. Highest: true, Lowest: false
	 */

	public boolean getOrdenacao() {
		return ordenacao;
	}

	/**
	 * Set the ordination of this competition.
	 * 
	 * @param ordenacao
	 *            the ordination of the competition. Highest: true, Lowest:
	 *            false
	 */

	public void setOrdenacao(boolean ordenacao) {
		this.ordenacao = ordenacao;
	}

	/**
	 * Get the type of classification.
	 * 
	 * @return the type of the classification. Distance = 0(zero), time =
	 *         1(one), score = 2(two) and ranked = 3(three).
	 */

	public int getTipoClass() {
		return tipoClass;
	}

	/**
	 * Set the type of classification.
	 * 
	 * @param tipoClass
	 *            the type of the classification. Distance = 0(zero), time =
	 *            1(one), score = 2(two) and ranked = 3(three).
	 */

	public void setTipoClass(int tipoClass) {
		this.tipoClass = tipoClass;
	}

	/**
	 * @return returns a String in this format: "name". Eg:"100 m"
	 */
	@Override
	public String toString() {
		return String.format("%s", nome);
	}

	// TODO Remover
	public String toStringTest() {
		return String.format("%s - %s - %s - %d - %d - %s", mod, nome, tipoDisc, genero, tipoClass, ordenacao);
	}

	/**
	 * @param obj
	 *            object to be compared.
	 * @return true if the competition insert is equal to this competition.
	 * @see java.lang.String#equalsIgnoreCase(java.lang.String) String
	 *      comparison.
	 */

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Disciplina) {
			Disciplina disc = (Disciplina) obj;
			return (this.getNome().equalsIgnoreCase(disc.getNome()) && this.mod.getNome().equalsIgnoreCase(disc.getModalidade().getNome()) && this.tipoDisc == disc.getTipoMod() && this.genero == disc.getGenero());
		}
		return false;
	}

}
