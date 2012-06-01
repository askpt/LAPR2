
package jogosolimpicos;

import listaligada.*;

public class ProvaDistanciaInd extends ProvaInd {

	private String	distancia;

	public ProvaDistanciaInd( Disciplina disc , JogosOlimpicos jogos , String distancia ) {

		super( disc , jogos );
		setDistancia( distancia );

	}

	// GETTERS
	public String getDistancia() {

		return distancia;
	}

	public String toString() {

		return super.toString() + String.format( ( "%s" ) , distancia );
	}

	// SETTERS

	public void setDistancia( String distancia ) {

		this.distancia = distancia;
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

	public void atribuirMedalhasAtleta( ListaLigada < Atleta > atleta , ListaLigada < Pais > pais ) {

		int atletaOuro = getResultadosInd().get( 0 ).getAtleta().getID();
		int atletaPrata = getResultadosInd().get( 1 ).getAtleta().getID();
		int atletaBronze = getResultadosInd().get( 2 ).getAtleta().getID();
		int iOuro = 0;
		int iPrata = 0;
		int iBronze = 0;

	}

}
