
package jogosolimpicos;

import listaligada.*;

public class ProvaDistanciaCol extends ProvaCol {

	private String	distancia;

	public ProvaDistanciaCol( Disciplina disc , JogosOlimpicos jogos , String distancia ) {

		super( disc , jogos );
		setDistancia( distancia );
	}

	// GETTERS
	public String getDistancia() {

		return distancia;
	}

	public String toString() {

		return super.toString() + String.format( "(%s)" , distancia );
	}

	// SETTERS
	public void setDistancia( String distancia ) {

		this.distancia = distancia;
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

	public void atribuirMedalhasEquipa( ListaLigada < Equipa > equipa , ListaLigada < Pais > pais ) {

		int equipaOuro = getResultadosCol().get( 0 ).getEquipa().getID();
		int equipaPrata = getResultadosCol().get( 1 ).getEquipa().getID();
		int equipaBronze = getResultadosCol().get( 2 ).getEquipa().getID();
		int iOuro = 0;
		int iPrata = 0;
		int iBronze = 0;

	}

}
