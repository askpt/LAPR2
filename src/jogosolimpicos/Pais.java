package jogosolimpicos;

import java.io.*;

import listaligada.*;

/**
 * Main class of the country.
 * 
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class Pais implements Comparable, Serializable {
	/**
	 * the current IOC code
	 */
	private String codigoPais;

	/**
	 * name of the country
	 */
	private String nomePais;
	/**
	 * medals of the country
	 * 
	 * @see Medalhas medal details
	 */
	private Medalhas medalha;
	/**
	 * the historical of the IOC codes for this country
	 * 
	 * @see CodigosPais historical details
	 */
	private ListaLigada<CodigosPais> codigos;

	/**
	 * Main constructor of the class country.
	 * 
	 * @param codigoPais
	 *            a string of the country's code with the IOC code. Eg.: "POR"
	 * @param nomePais
	 *            name of the country. Ex.: "Portugal"
	 */

	public Pais(String codigoPais, String nomePais) {

		setCodigoPais(codigoPais);
		setNomePais(nomePais);
		setMedalha();
		this.codigos = new ListaLigada<CodigosPais>();
	}

	/**
	 * Get the country's code.
	 * 
	 * @return the code of country
	 */
	public String getCodigoPais(int ano) {
		for (int i = 0; i < this.codigos.size(); i++) {
			if (this.codigos.get(i).getAnoInicio() <= ano && this.codigos.get(i).getAnoFim() >= ano) {
				return this.codigos.get(i).getCodigo();
			}
		}

		return codigoPais;
	}

	/**
	 * Set the country's code.
	 * 
	 * @param codigoPais
	 *            country's code with the IOC standart. Ex.: "POR"
	 */

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	/**
	 * Get the country's name.
	 * 
	 * @return the name of the country.
	 */

	public String getNomePais() {
		return nomePais;
	}

	/**
	 * Set the country's name.
	 * 
	 * @param nomePais
	 *            the name of the country.
	 */

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	/**
	 * Initializes the medals to zero.
	 */

	public void setMedalha() {
		this.medalha = new Medalhas();
	};

	/**
	 * Get the country's medals.
	 * 
	 * @return the medals of the country.
	 * @see Medalhas medal details.
	 */

	public Medalhas getMedalha() {
		return this.medalha;
	}

	/**
	 * Get the historical of the IOC codes for this country.
	 * 
	 * @return the historical of the codes
	 */
	public ListaLigada<CodigosPais> getCodigos() {
		return this.codigos;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	/**
	 * @return returns a String in this format: "countrycode - countryname"
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%s - %s", codigoPais, nomePais);
	}

	/**
	 * @param o
	 *            Object to be compared.
	 * @return the difference between the gold medals if doesn't equals. If
	 *         equals, returns the silver medals' difference. If all medals are
	 *         equal, return the value 0 if the name of country is equal to this
	 *         country; a value less than 0 if this name is lexicographically
	 *         less than the name argument; and a value greater than 0 if this
	 *         name is lexicographically greater than the name argument.
	 * @see Medalhas Medals details.
	 * @see java.lang.String#compareTo(java.lang.String) Name of country's
	 *      comparison.
	 */
	@Override
	public int compareTo(Object o) {
		if (o instanceof Pais) {
			Pais that = (Pais) o;
			if (this.getMedalha().getOuro() != that.getMedalha().getOuro()) {
				return (this.getMedalha().getOuro() - that.getMedalha().getOuro());
			} else if (this.getMedalha().getPrata() != that.getMedalha().getPrata()) {
				return (this.getMedalha().getPrata() - that.getMedalha().getPrata());
			} else if (this.getMedalha().getBronze() != that.getMedalha().getBronze()) {
				return (this.getMedalha().getBronze() - that.getMedalha().getBronze());
			} else {
				return (that.getNomePais().compareTo(this.getNomePais()));
			}
		}
		return 0;
	}

	/**
	 * Compares tow countries and returns true if either their name or code is
	 * the same
	 * 
	 * @param another
	 *            country
	 * @return returns true if either their name or code is the same, false if
	 *         it isn't
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pais) {
			Pais pais = (Pais) obj;
			return this.getNomePais().equalsIgnoreCase(pais.getNomePais()) || this.getCodigoPais().equalsIgnoreCase(pais.getCodigoPais());
		} else {
			return false;
		}
	}
}
