package jogosolimpicos;

import java.io.*;

/**
 * 
 * Main class for the team results
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class ResultadosCol implements Comparable, Serializable {
	/**
	 * team with that result
	 * 
	 * @see Equipa team details
	 */
	private Equipa equipa;
	/**
	 * result in the string
	 */
	private String resulTemp;
	/**
	 * numeric result to compare
	 */
	private float resultado;

	/**
	 * Main constructor for the team result. This constructor adds the team, the
	 * result and converts the string result to numeric.
	 * 
	 * @param equipa
	 *            team
	 * @param resultado
	 *            result in the string
	 * @param tipoClass
	 *            type of the classification. Distance = 0, time = 1, score = 2
	 *            and ranked = 3.
	 * @see Equipa team details
	 * @see Disciplina type of the classification details
	 */
	public ResultadosCol(Equipa equipa, String resultado, int tipoClass) {
		setResulTemp(resultado);
		convertResul(resultado, tipoClass);
		setEquipa(equipa);

	}

	/**
	 * Get the team
	 * 
	 * @return the team
	 * @see Equipa team details
	 */
	public Equipa getEquipa() {

		return equipa;
	}

	/**
	 * Set the team
	 * 
	 * @param equipa
	 *            the team
	 * @see Equipa team details
	 */
	public void setEquipa(Equipa equipa) {

		this.equipa = equipa;
	}

	/**
	 * Convert the string time into numeric.
	 */
	private void convertTempo() {

		if (resulTemp.matches("^[0-9]{2}:[0-9]{2}:[0-9]{2}$")) {
			String temp[] = resulTemp.split(":");
			setResultado(Float.parseFloat(temp[0]) * 3600 + Float.parseFloat(temp[1]) * 60 + Float.parseFloat(temp[2]));
		} else if (resulTemp.matches("^[0-9]{1,2}:[0-9]{2}(.[0-9]{1,})?$")) {
			String temp[] = resulTemp.split(":");
			setResultado(Float.parseFloat(temp[0]) * 60 + Float.parseFloat(temp[1]));

		} else {
			setResultado(Float.parseFloat(resulTemp));
		}

	}

	/**
	 * Convert the string result into numeric.
	 * 
	 * @param resultado
	 *            string with the result.
	 * @param tipoClass
	 *            type of the classification. Distance = 0, time = 1, score = 2
	 *            and ranked = 3.
	 * @see Disciplina type of classification details
	 */
	private void convertResul(String resultado, int tipoClass) {
		if (tipoClass == 0) {
			convertDist();
		} else if (tipoClass == 1) {
			convertTempo();
		} else if (tipoClass == 2) {
			setResultado(Float.parseFloat(resulTemp));
		} else {
			setResultado(Float.parseFloat(resulTemp));
		}

	}

	/**
	 * Convert the string distance into numeric
	 */
	private void convertDist() {
		String temp = resulTemp;
		if (temp.matches("^[0-9]*(.{1}[0-9]{1,})?( m){1}$"))
			temp.replaceAll(" m", "");
		else if (temp.matches("^[0-9]*(.{1}[0-9]{1,})?( ft){1}$"))
			temp.replaceAll(" ft", "");

		setResultado(Float.parseFloat(temp));
	}

	/**
	 * Get the numeric result
	 * 
	 * @return numeric result
	 */
	public float getResultado() {
		return resultado;
	}

	/**
	 * Set the numeric result
	 * 
	 * @param resultado
	 *            numeric result
	 */
	public void setResultado(float resultado) {
		this.resultado = resultado;
	}

	/**
	 * Set the string result
	 * 
	 * @param resulTemp
	 *            string result
	 */
	public void setResulTemp(String resulTemp) {
		this.resulTemp = resulTemp;
	}

	/**
	 * @param o
	 *            Object to be compared.
	 * @return the difference between this result and that result.
	 */
	@Override
	public int compareTo(Object obj) {
		if (obj instanceof ResultadosCol) {
			ResultadosCol resul = (ResultadosCol) obj;
			return (int) (this.getResultado() * 10000 - resul.getResultado() * 10000);
		}
		return 0;
	}

	/**
	 * Get the string result
	 * 
	 * @return string result
	 */
	public String getResulTemp() {
		return resulTemp;
	}

}
