package jogosolimpicos;

/**
 * Main class of the country.
 * 
 */
public class Pais {

	private String codigoPais;
	private String nomePais;
	private Medalhas medalha;

	/**
	 * Main constructor of the class country.
	 * 
	 * @param codigoPais
	 *            a string of the country's code with the IOC standart. Ex.:
	 *            "POR"
	 * @param nomePais
	 *            name of the country. Ex.: "Portugal"
	 */

	public Pais(String codigoPais, String nomePais) {
		setCodigoPais(codigoPais);
		setNomePais(nomePais);
		setMedalha();
	}

	/**
	 * Get the country's code.
	 * 
	 * @return the code of country
	 */
	public String getCodigoPais() {
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
	 */

	public Medalhas getMedalha() {
		return this.medalha;
	}

	/**
	 * @return returns a String in this format: "countrycode - countryname"
	 * 
	 */

	@Override
	public String toString() {
		return String.format("%s - %s", codigoPais, nomePais);
	}

}
