package jogosolimpicos;

import listaligada.ListaLigada;

/**
 * Main class of the country.
 * 
 */
@SuppressWarnings("rawtypes")
public class Pais implements Comparable {

	private String codigoPais;
	private String nomePais;
	private Medalhas medalha;
	private ListaLigada<CodigosPais> codigos;

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
	 */

	public Medalhas getMedalha() {
		return this.medalha;
	}

	public ListaLigada<CodigosPais> getCodigos() {
		return this.codigos;
	}

	/**
	 * @return returns a String in this format: "countrycode - countryname"
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%s - %s", codigoPais, nomePais);
	}

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
				return (this.getNomePais().compareTo(that.getNomePais()));
			}
		}
		return 0;
	}
}
