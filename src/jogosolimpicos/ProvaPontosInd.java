
package jogosolimpicos;

public class ProvaPontosInd extends ProvaInd {

	private float	ponto;

	public ProvaPontosInd( Disciplina disc , JogosOlimpicos jogos , float ponto ) {

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

		for ( int i = 0 ; i < getResultadosInd().size() - 1 ; i++ ) {
			for ( int j = i ; j < getResultadosInd().size() ; j++ ) {
				if ( getResultadosInd().get( i ).compareTo( getResultadosInd().get( j ) ) < 0 ) {
					Object obj = getResultadosInd().get( j );
					getResultadosInd().set( j , getResultadosInd().get( i ) );
					getResultadosInd().set( i , ( ResultadosInd ) obj );
				}
			}
		}
	}
}
