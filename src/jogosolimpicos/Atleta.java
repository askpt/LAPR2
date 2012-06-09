package jogosolimpicos;

import java.io.*;

/**
 * 
 * Main class of Athlete.
 * 
 */

@SuppressWarnings({ "rawtypes", "serial" })
public class Atleta implements Comparable, Serializable {
	/**
	 * a string with the name of the athlete.
	 */
	private String nome;
	/**
	 * the athlete's identification number
	 */
	private int numid;
	/**
	 * the counter for the the athlete's identification number
	 */
	private static int num;
	/**
	 * the country of the athlete.
	 * 
	 * @see Pais
	 */
	private Pais pais;
	/**
	 * the medals of the athlete.
	 */
	private Medalhas medalha;

	/**
	 * Main constructor of the class athlete. This constructor assigns the ID of
	 * the athletes and the first will be the 1 (one).
	 * 
	 * @param nome
	 *            a string with the name of the athlete.
	 * @param pais
	 *            add a contry atribute to the athlete.
	 * @see Pais Country atribute details.
	 */

	public Atleta(String nome, Pais pais) {
		setID();
		setNome(nome);
		setPais(pais);
		medalha = new Medalhas();
	}

	/**
	 * Get the athlete's name.
	 * 
	 * @return the name of the athlete.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Get the athlete's country.
	 * 
	 * @return the country of the athlete.
	 */

	public Pais getPais() {
		return pais;
	}

	/**
	 * Get the athlete's identification number.
	 * 
	 * @return the identification number of the athlete.
	 */

	public int getID() {
		return numid;
	}

	/**
	 * Get the athlete's medals.
	 * 
	 * @return the medals of the athlete.
	 * @see Medalhas Medals information.
	 */

	public Medalhas getMedalha() {
		return medalha;
	}

	/**
	 * Set the athlete's name.
	 * 
	 * @param nome
	 *            the name of the athlete.
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Set the athlete's country.
	 * 
	 * @param pais
	 *            the country of the athlete.
	 * @see Pais Country details.
	 */

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * Set the athlete's identification number. Adds one number at the previous
	 * identification number.
	 */

	private void setID() {
		this.numid = ++num;
	}

	/**
	 * Set the athlete's medals.
	 * 
	 * @param medalha
	 *            the medals of athlete
	 * @see Medalhas Medals information.
	 */

	public void setMedalha(Medalhas medalha) {
		this.medalha = medalha;
	}

	/**
	 * 
	 * @return returns a String in this format: "athId - name - countryString".
	 *         Eg.: "1 - Usain Bolt - JAM"
	 */
	@Override
	public String toString() {
		return String.format("%d: %s - %s", numid, nome, pais);
	}

	/**
	 * @param o
	 *            Object to be compared.
	 * @return the difference between the gold medals if doesn't equals. If
	 *         equals, returns the silver medals' difference. If all medals are
	 *         equal, return the value 0 if the name of athlete is equal to this
	 *         athlete; a value less than 0 if this name is lexicographically
	 *         less than the name argument; and a value greater than 0 if this
	 *         name is lexicographically greater than the name argument.
	 * @see Medalhas Medals details.
	 * @see java.lang.String#compareTo(java.lang.String) Name of athlete's
	 *      comparison.
	 */

	@Override
	public int compareTo(Object o) {
		if (o instanceof Atleta) {
			Atleta that = (Atleta) o;
			if (this.getMedalha().getOuro() != that.getMedalha().getOuro()) {
				return (this.getMedalha().getOuro() - that.getMedalha().getOuro());
			} else if (this.getMedalha().getPrata() != that.getMedalha().getPrata()) {
				return (this.getMedalha().getPrata() - that.getMedalha().getPrata());
			} else if (this.getMedalha().getBronze() != that.getMedalha().getBronze()) {
				return (this.getMedalha().getBronze() - that.getMedalha().getBronze());
			} else {
				return (that.getNome().compareTo(this.getNome()));
			}
		}
		return 0;
	}

}
