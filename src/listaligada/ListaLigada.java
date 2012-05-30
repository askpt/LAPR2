package listaligada;


/**
 * 
 * Classe principal da Lista Ligada. Pertence 
 * 
 * 
 * 
 * @author http://pt.wikipedia.org/wiki/Lista_ligada
 *
 */

public class ListaLigada {
	private No primeiro, ultimo;
	private int nroNos;

	public ListaLigada() {
		primeiro = null;
		ultimo = null;
		nroNos = 0;
	}

	public boolean isVazia() {
		return (primeiro == null && ultimo == null);
	}

	public void addInicio(Object o) {
		nroNos++;
		No novoNo = new No(o);
		if (isVazia())
			ultimo = novoNo;
		else
			novoNo.prox = primeiro;
		primeiro = novoNo;
	}

	public void addFinal(Object o) {
		nroNos++;
		No novoNo = new No(o);
		if (isVazia())
			primeiro = novoNo;
		else
			ultimo.prox = novoNo;
		ultimo = novoNo;
	}

	public int getNroNos() {
		return nroNos;
	}

	/*
	 * @param posicao posição contada a partir do zero como primeiro elemento
	 */
	public void addMeio(Object o, int posicao) {
		nroNos++;
		No novoNo = new No(o);
		if (posicao <= 1) {
			addInicio(novoNo);
			return;
		}
		if (posicao > nroNos) { // Outra abordagem seria lançar exceção para
								// posição inválida (>nroNos+1)
			addFinal(novoNo);
			return;
		}
		No noTemp = primeiro.prox;
		for (int posAux = 1; posAux < posicao; posAux++)
			noTemp = noTemp.prox;
		novoNo.prox = (noTemp.prox).prox;
		noTemp.prox = novoNo;
	}

	public void Remover(Object elemento) {
		No noTemp = primeiro;
		No noAnt = null;

		if (primeiro.elemento.equals(elemento)) {
			primeiro = primeiro.prox;
			nroNos--;
		} else {
			while (noTemp != null && !noTemp.elemento.equals(elemento)) {
				noAnt = noTemp;
				noTemp = noTemp.prox;
			}
			if (noTemp != null) {
				noAnt.prox = noTemp.prox;
				nroNos--;
			}
			if (noTemp == ultimo) {
				ultimo = noAnt;
			}
		}
	}

	public Object BuscarElemento(Object elemento) {
		int i = 1;
		No noTemp = primeiro;

		while (noTemp != null) {
			if (noTemp.elemento.equals(elemento)) {
				return noTemp;
			}
			i = i + 1;
			noTemp = noTemp.prox;
		}
		return null;
	}
}