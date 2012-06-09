package jogosolimpicos;

import java.io.*;

/**
 * Main class for the edition of the Olympic Games.
 * 
 */

@SuppressWarnings("serial")
public class JogosOlimpicos implements Serializable {

	/**
	 * year of the edition.
	 */
	private int ano;
	/**
	 * city of the edition.
	 */
	private String cidade;

	/**
	 * Main constructor of the class.
	 * 
	 * @param ano
	 *            year of edition
	 * @param cidade
	 *            city of edition
	 */

	public JogosOlimpicos(int ano, String cidade) {
		setAno(ano);
		setCidade(cidade);
	}

	/**
	 * Constructor of class with only year known. By default, city will be
	 * empty.
	 * 
	 * @param ano
	 *            year of edition
	 */
	public JogosOlimpicos(int ano) {
		this(ano, "");
	}

	/**
	 * Get the city of this edition.
	 * 
	 * @return the city of edition.
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Get the year of this edition
	 * 
	 * @return the year of edition
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * Set the city of this edition
	 * 
	 * @param cidade
	 *            the city of edition
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Set the year of this edition
	 * 
	 * @param ano
	 *            year of this edition
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * 
	 * @return returns a String in this format: "year city Games". Eg.:
	 *         "2012 London Games"
	 */
	public String toString() {
		return String.format("%d %s Games", ano, cidade);
	}

}
