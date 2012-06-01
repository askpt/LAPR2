
package jogosolimpicos;

@SuppressWarnings ("rawtypes" )
public class Resultados implements Comparable {

	@SuppressWarnings ("unused" )
	// private int idAtleta;
	private float	resultado;

	public Resultados( float resultado ) {

		setResultados( resultado );

	}

	/**
	 * public void setIdAtleta(int idAtleta) {
	 * this.idAtleta = idAtleta;
	 * }
	 * 
	 * public int getIdAtleta() {
	 * 
	 * return idAtleta;
	 * }
	 */

	public float getResultado() {

		return resultado;
	}

	public void setResultados( float resultado ) {

		this.resultado = resultado;
	}

	@Override
	public int compareTo( Object outro ) {

		return ( int ) ( this.getResultado() - ( ( Resultados ) outro ).getResultado() );
	}

	@Override
	public String toString() {

		return String.format( "%.2f" , resultado );
	}
}
