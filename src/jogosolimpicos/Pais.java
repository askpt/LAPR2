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
	private ListaLigada<Medalhas> medalProva = new ListaLigada<Medalhas>();

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

	public ListaLigada<Medalhas> getMedalModal() {

		return medalProva;
	}

	@Override
	public int compareTo(Object o) {
		if (this.medalha.getOuro() != ((Pais) o).getMedalha().getOuro()) {
			return this.medalha.getOuro() - ((Pais) o).getMedalha().getOuro();
		} else if (this.medalha.getPrata() != ((Pais) o).getMedalha().getPrata()) {
			return this.medalha.getPrata() - ((Pais) o).getMedalha().getPrata();
		} else if (this.medalha.getBronze() != ((Pais) o).getMedalha().getBronze()) {
			return this.medalha.getBronze() - ((Pais) o).getMedalha().getBronze();
		} else {
			return ((Pais) o).getNomePais().compareToIgnoreCase(this.getNomePais());
		}
	}

	public int compareToPond(Object o) {
		int pondthis = this.medalha.getOuro() * 3 + this.medalha.getPrata() * 2 + this.medalha.getBronze();
		int pondobj = ((Pais) o).getMedalha().getOuro() * 3 + ((Pais) o).getMedalha().getPrata() * 2 + ((Pais) o).getMedalha().getBronze();

		if (pondthis != pondobj) {
			return pondthis - pondobj;
		} else {
			return ((Pais) o).getNomePais().compareToIgnoreCase(this.getNomePais());
		}
	}

	public int compararMod(String modalidade, Object o) {

		int itthismodal = -1;
		int itobjmodal = -1;

		for (int i = 0; i < this.medalProva.size(); i++) {
			if (this.medalProva.get(i).getModalidade().equals(modalidade)) {
				itthismodal = i;
			}
		}

		for (int i = 0; i < ((Pais) o).getMedalModal().size(); i++) {
			if (((Pais) o).getMedalModal().get(i).getModalidade().equals(modalidade)) {
				itobjmodal = i;
			}
		}

		if (this.medalProva.get(itthismodal).getOuro() != ((Pais) o).getMedalModal().get(itobjmodal).getOuro()) {
			return this.medalProva.get(itthismodal).getOuro() - ((Pais) o).getMedalModal().get(itobjmodal).getOuro();
		} else if (this.medalProva.get(itthismodal).getPrata() != ((Pais) o).getMedalModal().get(itobjmodal).getPrata()) {
			return this.medalProva.get(itthismodal).getPrata() - ((Pais) o).getMedalModal().get(itobjmodal).getPrata();
		} else if (this.medalProva.get(itthismodal).getBronze() != ((Pais) o).getMedalModal().get(itobjmodal).getBronze()) {
			return this.medalProva.get(itthismodal).getBronze() - ((Pais) o).getMedalModal().get(itobjmodal).getBronze();
		} else {
			return ((Pais) o).getNomePais().compareToIgnoreCase(this.getNomePais());
		}

	}

	public int compararModPond(String modalidade, Object o) {
		int itthismodal = -1;
		int itobjmodal = -1;

		for (int i = 0; i < this.medalProva.size(); i++) {
			if (this.medalProva.get(i).getModalidade().equals(modalidade)) {
				itthismodal = i;
			}
		}

		for (int i = 0; i < ((Pais) o).getMedalModal().size(); i++) {
			if (((Pais) o).getMedalModal().get(i).getModalidade().equals(modalidade)) {
				itobjmodal = i;
			}
		}

		int pondthis = this.medalProva.get(itthismodal).getOuro() * 3 + this.medalProva.get(itthismodal).getPrata() * 2 + this.medalProva.get(itthismodal).getBronze();
		int pondobj = ((Pais) o).getMedalModal().get(itobjmodal).getOuro() * 3 + ((Pais) o).getMedalModal().get(itobjmodal).getPrata() * 2 + ((Pais) o).getMedalModal().get(itobjmodal).getBronze();

		if (pondthis != pondobj) {
			return pondthis - pondobj;
		} else {
			return ((Pais) o).getNomePais().compareToIgnoreCase(this.getNomePais());
		}

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
