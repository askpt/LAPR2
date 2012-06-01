
package jogosolimpicos;

public class ResultadosCol extends Resultados {

	private Equipa	equipa;

	public ResultadosCol( Equipa equipa , float resultado ) {

		super( resultado );

	}

	// GETTERS
	public Equipa getEquipa() {

		return equipa;
	}

	public String toString() {

		return String.format( "%s" , equipa ) + super.toString();
	}

	// SETTERS
	public void setEquipa( Equipa equipa ) {

		this.equipa = equipa;
	}

}
