
package jogosolimpicos;

public class ProvaTempoCol extends ProvaCol {

	private String	tempo;
	private float	tempoSec;

	public ProvaTempoCol( Disciplina disc , JogosOlimpicos jogos , String tempo ) {

		super( disc , jogos );
		setTempo( tempo );
		calculaSec();
	}

	// GETTERS
	public float getTempoSec() {

		return tempoSec;
	}

	public String getTempo() {

		return tempo;
	}

	public String toString() {

		return super.toString() + String.format( "(%s)" , tempo );
	}

	// SETTERS
	public void setTempoSec( float tempoSec ) {

		this.tempoSec = tempoSec;
	}

	public void setTempo( String tempo ) {

		this.tempo = tempo;
	}

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

	public void ordenarAsc() {

		for ( int i = 0 ; i < getResultadosCol().size() - 1 ; i++ ) {
			for ( int j = i ; j < getResultadosCol().size() ; j++ ) {
				if ( getResultadosCol().get( i ).compareTo( getResultadosCol().get( j ) ) > 0 ) {
					Object obj = getResultadosCol().get( j );
					getResultadosCol().set( j , getResultadosCol().get( i ) );
					getResultadosCol().set( i , ( ResultadosCol ) obj );
				}
			}
		}
	}

	public void atribuirMedalhaEquipa() {

	}

}
