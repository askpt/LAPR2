
package jogosolimpicos;

import listaligada.*;

public class Equipa {

	private int					numid;
	private static int				num;
	private Pais					pais;
	private ListaLigada < Atleta >	atletas	= new ListaLigada < Atleta >();
	private Atleta					atleta;
	private Modalidade				modalidade;
	private Medalhas				medalhas;

	public Equipa( Pais pais ) {

		setID();
		setPais( pais );
	}

	public Equipa( Pais pais , Atleta atleta ) {

		this( pais );
		setAtleta( atleta );

	}

	public Equipa( Pais pais , Modalidade modalidade ) {

		this( pais );
		setModalidade( modalidade );
	}

	public Equipa( Pais pais , ListaLigada < Atleta > atletas ) {

		this( pais );
		setAtletas( atletas );

	}

	public Equipa( Pais pais , Modalidade modalidade , Atleta atleta ) {

		this( pais , modalidade );
		setAtleta( atleta );
	}

	public Equipa( Pais pais , Modalidade modalidade , ListaLigada < Atleta > atletas ) {

		this( pais , modalidade );
		setAtletas( atletas );
	}

	// GETTERS
	public int getID() {

		return numid;
	}

	public Modalidade getModalidade() {

		return modalidade;
	}

	/*
	 * public ListaLigada < Atleta > getAtletas() {
	 * 
	 * if ( ! atletas.isEmpty() ) return atletas;
	 * }
	 */

	// SETTERS
	private void setID() {

		this.numid = ++num;
	}

	public void setPais( Pais pais ) {

		this.pais = pais;
	}

	public void setAtleta( Atleta atleta ) {

		if ( ! atletas.contains( atleta ) ) {
			atletas.add( atleta );
		}
	}

	public void setAtletas( ListaLigada < Atleta > atletas ) {

		for ( int i = 0 ; i < atletas.size() ; i++ ) {
			if ( ! this.atletas.contains( atletas.get( i ) ) ) {
				this.atletas.add( atletas.get( i ) );
			}
		}
	}

	public void setModalidade( Modalidade modalidade ) {

		this.modalidade = modalidade;
	}

}
