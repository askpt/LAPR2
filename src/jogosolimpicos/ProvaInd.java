
package jogosolimpicos;

import listaligada.*;

public class ProvaInd {

	private Disciplina					disc;
	private JogosOlimpicos				jogos;
	private ListaLigada < ResultadosInd >	resultadosInd	= new ListaLigada < ResultadosInd >();

	public ProvaInd( Disciplina disc , JogosOlimpicos jogos ) {

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

	public ListaLigada < ResultadosInd > getResultadosInd() {

		return resultadosInd;
	}

	public String toString() {

		return String.format( "%s, %s" , disc.getNome() , jogos );
	}

	// SETTERS

	public void setJogosOlimpicos( JogosOlimpicos jogos ) {

		this.jogos = jogos;
	}

	public void setDisciplina( Disciplina disc ) {

		this.disc = disc;

	}

	public void setResultadosInd( ListaLigada < ResultadosInd > resultadosInd ) {

		this.resultadosInd = resultadosInd;
	}

}
