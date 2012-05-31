
package jogosolimpicos;

public class Prova {

	private Disciplina		disc;
	private JogosOlimpicos	jogos;

	public Prova( Disciplina disc , JogosOlimpicos jogos ) {

		setDisciplina( disc );
		setJogosOlimpicos( jogos );

	}

	// GETTERS
	public JogosOlimpicos getJogosOlimpicos() {

		return jogos;
	}

	public Disciplina getDisciplina() {

		return disc;
	}

	public String toString() {

		return String.format( "%s, %s" , disc.getNome() , jogos.toString() );
	}

	// SETTERS

	public void setJogosOlimpicos( JogosOlimpicos jogos ) {

		this.jogos = jogos;
	}

	private void setDisciplina( Disciplina disc ) {

		this.disc = disc;

	}

}
