
package jogosolimpicos;

public class ResultadosInd extends Resultados {

	private Atleta	atleta;

	public ResultadosInd( Atleta atleta , float resultado ) {

		super( resultado );
		setAtleta( atleta );

	}

	// GETTERS
	public Atleta getAtleta() {

		return atleta;
	}

	public String toString() {

		return String.format( "%s" , atleta.toString() ) + super.toString();
	}

	// SETTERS
	public void setAtleta( Atleta atleta ) {

		this.atleta = atleta;
	}

}
