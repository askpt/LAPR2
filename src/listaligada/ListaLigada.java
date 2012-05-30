package listaligada;

/**
 * Main class for the
 * 
 * @author http://www.dreamincode.net/forums/topic/143089-linked-list-tutorial/
 * 
 */

public class ListaLigada<E> {
	private No<E> cabeca = null;
	private No<E> cauda = null;
	private No<E> temp = null;

	private int contador = 0;

	public ListaLigada() {
	}

	public int size() {
		return contador;
	}

	public void add(E elemento) {
		if (cabeca == null) {
			cabeca = cauda = new No<E>();
			cabeca.elemento = elemento;
			cauda = cabeca;
		} else {
			cauda.proximo = new No<E>();
			cauda = cauda.proximo;
			cauda.elemento = elemento;
		}
		contador++;
	}

	public void add(int index, E elemento) {
		if (index == size()) {
			add(elemento);
			return;
		} else if (index == 0) {
			No<E> temp = new No<E>();
			temp.elemento = elemento;
			temp.proximo = cabeca;
			cabeca.anterior = temp;
			cabeca = temp;
			contador++;
			return;
		}
		temp = cabeca;
		for (int i = 0; i < index - 1; i++) {
			No<E> no = new No<E>();
			no.elemento = elemento;
			no.proximo = temp.proximo;
			temp.proximo = no;
			contador++;
		}
	}

	public E get(int index) {
		assert (index >= 0 && index < size());

		temp = cabeca;
		for (int i = 0; i < index; i++) {
			temp = temp.proximo;
		}

		return temp.elemento;
	}

	public int indexOf(E elem) {
		temp = cabeca;
		int i = 0;

		for (; !(temp.elemento).equals(elem) && temp != null; i++) {
			temp = temp.proximo;
		}

		if (i == size())
			return -1;
		return i;
	}

	public boolean isEmpty() {
		return (cabeca == null && cauda == null);
	}

	public E remove(int index) {
		assert (index >= 0 && index < size());
		temp = cabeca;

		if (index == 0) {
			E elem = cabeca.elemento;
			cabeca = cabeca.proximo;
			contador--;

			return elem;
		} else if (index == size()) {
			E elem = cauda.elemento;
			cauda = cauda.anterior;
			contador--;

			return elem;
		}

		for (int i = 0; i < index - 1; i++) {
			temp = temp.proximo;
		}
		No<E> dois = temp.proximo;
		temp.proximo = dois.proximo;
		E elem = dois.elemento;
		dois = null;
		contador--;

		return elem;
	}

}