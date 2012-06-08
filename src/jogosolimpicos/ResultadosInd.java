package jogosolimpicos;

public class ResultadosInd {

	private Atleta atleta;
	private String resulTemp;
	private float resultado;

	public ResultadosInd(Atleta atleta, String resultado, int tipoClass) {
		setResulTemp(resultado);
		convertResul(resultado, tipoClass);
		setAtleta(atleta);

	}

	// GETTERS
	public Atleta getAtleta() {

		return atleta;
	}

	public String toString() {

		return String.format("%s", atleta.toString()) + super.toString();
	}

	// SETTERS
	public void setAtleta(Atleta atleta) {

		this.atleta = atleta;
	}

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

	private void convertResul(String resultado2, int tipoClass) {
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

	private void convertDist() {
		String temp = resulTemp;
		if (temp.matches("^[0-9]*(.{1}[0-9]{1,})?( m){1}$"))
			temp.replaceAll(" m", "");
		else if (temp.matches("^[0-9]*(.{1}[0-9]{1,})?( ft){1}$"))
			temp.replaceAll(" ft", "");

		setResultado(Float.parseFloat(temp));
	}

	public float getResultado() {
		return resultado;
	}

	public void setResultado(float resultado) {
		this.resultado = resultado;
	}

	public void setResulTemp(String resulTemp) {
		this.resulTemp = resulTemp;
	}

	public int compareTo(Object o) {

		return (int) (this.getResultado() - ((ResultadosInd) o).getResultado());
	}

	public String getResulTemp() {
		return resulTemp;
	}

}
