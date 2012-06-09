package jogosolimpicos;

import java.io.*;

/**
 * 
 * Main class for the historical of the IOC codes for the countries.
 * 
 * @see Pais country details.
 * 
 */

@SuppressWarnings("serial")
public class CodigosPais implements Serializable {
	/**
	 * the beginning year of the IOC code.
	 */
	private int anoInicio;
	/**
	 * the last year of the IOC code.
	 */
	private int anoFim;
	/**
	 * the IOC code.
	 */
	private String codigo;

	/**
	 * Main constructor for the class IOC codes.
	 * 
	 * @param codigo
	 *            the IOC code.
	 * @param anoInicio
	 *            the first year of appearance.
	 * @param anoFim
	 *            the last year of appearance.
	 */

	public CodigosPais(String codigo, int anoInicio, int anoFim) {
		setCodigo(codigo);
		setAnoInicio(anoInicio);
		setAnoFim(anoFim);
	}

	/**
	 * Constructor of the IOC class if that code only appeared in one year.
	 * 
	 * @param codigo
	 *            the IOC code.
	 * @param ano
	 *            the year of appearance.
	 */

	public CodigosPais(String codigo, int ano) {
		this(codigo, ano, ano);
	}

	/**
	 * Get the first year of appearance of the IOC code.
	 * 
	 * @return the year.
	 */

	public int getAnoInicio() {
		return anoInicio;
	}

	/**
	 * Get the last year of appearance of the IOC code.
	 * 
	 * @return the year.
	 */

	public int getAnoFim() {
		return anoFim;
	}

	/**
	 * Get the IOC code for that country.
	 * 
	 * @return the IOC code.
	 */

	public String getCodigo() {
		return codigo;
	}

	/**
	 * Set the first year of appearance of the IOC code.
	 * 
	 * @param anoInicio
	 *            the year.
	 */

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}

	/**
	 * Set the last year of appearance of the IOC code.
	 * 
	 * @param anoFim
	 *            the year.
	 */

	public void setAnoFim(int anoFim) {
		this.anoFim = anoFim;
	}

	/**
	 * Get the IOC code for that country.
	 * 
	 * @param codigo
	 *            the IOC code.
	 */

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
