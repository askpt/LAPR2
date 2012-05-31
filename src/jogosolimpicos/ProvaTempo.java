
package jogosolimpicos;

public class ProvaTempo extends Prova {

	private String	tempo;
	private float	tempoSec;

	public ProvaTempo( Disciplina disc , JogosOlimpicos jogos , String tempo ) {

		super( disc , jogos );
		setTempo( tempo );
		calculaSec();
	}

	private void calculaSec() {

		if ( tempo.matches( "^[0-9]{2}:[0-9]{2}:[0-9]{2}$" ) ) {
			String temp[] = tempo.split( ":" );
			setTempoSec(Float.parseFloat( temp[ 0 ] ) * 3600 + Float.parseFloat( temp[ 1 ] ) * 60 + Float.parseFloat( temp[ 2 ] ));
		} else if ( tempo.matches( "^[0-9]{1,2}:[0-9]{2}(.[0-9]{1,})?$" ) ) {
			String temp[] = tempo.split( ":" );
			setTempoSec(Float.parseFloat( temp[ 0 ] ) * 60 + Float.parseFloat( temp[ 1 ] ));

		} else {
			setTempoSec(Float.parseFloat( tempo ));
		}
	}

	private void setTempo( String tempo ) {

		this.tempo = tempo;
	}

	public float getTempoSec() {
		return tempoSec;
	}

	public void setTempoSec(float tempoSec) {
		this.tempoSec = tempoSec;
	}

}
