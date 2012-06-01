
package jogosolimpicos;

public class ProvaTempoInd extends ProvaInd {

	private String	tempo;
	private float	tempoSec;

	public ProvaTempoInd( Disciplina disc , JogosOlimpicos jogos , String tempo ) {

		super( disc , jogos );
		setTempo( tempo );
		calculaSec();
	}

	// GETTERS
	public float getTempoSec() {

		return tempoSec;
	}

	public String toString() {

		return super.toString() + String.format( "(%s)" , tempo );
	}

	// SETTERS

	private void calculaSec() {

		if ( tempo.matches( "^[0-9]{2}:[0-9]{2}:[0-9]{2}$" ) ) {
			String temp[] = tempo.split( ":" );
			setTempoSec( Float.parseFloat( temp[ 0 ] ) * 3600 + Float.parseFloat( temp[ 1 ] ) * 60 + Float.parseFloat( temp[ 2 ] ) );
		} else if ( tempo.matches( "^[0-9]{1,2}:[0-9]{2}(.[0-9]{1,})?$" ) ) {
			String temp[] = tempo.split( ":" );
			setTempoSec( Float.parseFloat( temp[ 0 ] ) * 60 + Float.parseFloat( temp[ 1 ] ) );

		} else {
			setTempoSec( Float.parseFloat( tempo ) );
		}
	}

	private void setTempo( String tempo ) {

		this.tempo = tempo;
	}

	public void setTempoSec( float tempoSec ) {

		this.tempoSec = tempoSec;
	}

	public void ordenarAsc() {

		for ( int i = 0 ; i < getResultadosInd().size() - 1 ; i++ ) {
			for ( int j = i ; j < getResultadosInd().size() ; j++ ) {
				if ( getResultadosInd().get( i ).compareTo( getResultadosInd().get( j ) ) > 0 ) {
					Object obj = getResultadosInd().get( j );
					getResultadosInd().set( j , getResultadosInd().get( i ) );
					getResultadosInd().set( i , ( ResultadosInd ) obj );
				}
			}
		}
	}

	public void atribuirMedalhaAtleta() {

	}

}
