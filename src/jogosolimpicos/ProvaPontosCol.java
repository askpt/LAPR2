
package jogosolimpicos;

public class ProvaPontosCol extends ProvaCol {

	private float	ponto;

	public ProvaPontosCol( Disciplina disc , JogosOlimpicos jogos , float ponto ) {

		super( disc , jogos );
		setPonto( ponto );
	}

	// GETTERS
	public float getPonto() {

		return ponto;
	}

	public String toString() {

		return super.toString() + String.format( "(%F)" , ponto );
	}

	// SETTERS
	public void setPonto( float ponto ) {

		this.ponto = ponto;
	}

	public void ordenar() {

		for ( int i = 0 ; i < getResultadosCol().size() - 1 ; i++ ) {
			for ( int j = i ; j < getResultadosCol().size() ; j++ ) {
				if ( getResultadosCol().get( i ).compareTo( getResultadosCol().get( j ) ) < 0 ) {
					Object obj = getResultadosCol().get( j );
					getResultadosCol().set( j , getResultadosCol().get( i ) );
					getResultadosCol().set( i , ( ResultadosCol ) obj );
				}
			}
		}
	}
}
