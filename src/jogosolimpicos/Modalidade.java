
package jogosolimpicos;

import listaligada.*;

public class Modalidade {

	private String					nome;
	private ListaLigada < Disciplina >	disc;

	public Modalidade( String nome ) {

		setNome( nome );
	}

	public ListaLigada < Disciplina > getDisc() {

		return disc;
	}

	public void setNome( String nome ) {

		this.nome = nome;
	}

	public String getNome() {

		return nome;
	}

	public String toString() {

		return String.format( "%s" , nome );
	}
}
