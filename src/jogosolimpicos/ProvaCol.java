
package jogosolimpicos;

import listaligada.*;

public class ProvaCol {

	private Disciplina					disc;
	private JogosOlimpicos				jogos;
	private ListaLigada < ResultadosCol >	resultadosCol	= new ListaLigada < ResultadosCol >();

	public ProvaCol( Disciplina disc , JogosOlimpicos jogos ) {

	}

	// GETTERS
	public Disciplina getDisciplina() {

		return disc;
	}

	public JogosOlimpicos getJogosOlimpicos() {

		return jogos;
	}

	public ListaLigada < ResultadosCol > getResultadosCol() {

		return resultadosCol;
	}

	public String toString() {

		return String.format( "%s, %s" , disc.getNome() , jogos );
	}

	// SETTERS

	public void setDisciplina( Disciplina disc ) {

		this.disc = disc;
	}

	public void setJogosOlimpicos( JogosOlimpicos jogos ) {

		this.jogos = jogos;
	}

	public void setResultadosCol( ListaLigada < ResultadosCol > resultadosCol ) {

		this.resultadosCol = resultadosCol;
	}

}
