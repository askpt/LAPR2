package listaligada;

/**
 * Main class for the Linked List. Accepts the generic form.
 * 
 * @author http://www.dreamincode.net/forums/topic/143089-linked-list-tutorial/
 * 
 */

public class ListaLigada<E> {
	private No<E> cabeca = null;
	private No<E> cauda = null;
	private No<E> temp = null;
	private int contador = 0;

	/**
	 * Constructor of the Linked List. Initializes the instance of the Linked
	 * List to null and the counter to zero.
	 */
	public ListaLigada() {
	}

	/**
	 * Method to get the size of the Linked List.
	 * 
	 * @return size of the Linked List.
	 */

	public int size() {
		return contador;
	}

	/**
	 * Method to add an element to the end of the Linked List.
	 * 
	 * @param elemento
	 *            element to be added to Linked List.
	 */

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

	/**
	 * Method to add an element to a specific index of the Linked List.
	 * 
	 * @param index
	 *            index of the Linked List, where the element will be added.
	 * @param elemento
	 *            element to be added to Linked List.
	 */
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

	/**
	 * Method to get the element in the specific index in the Linked List.
	 * 
	 * @param index
	 *            index of the Linked List.
	 * @return element of the Linked List in the index position.
	 */

	public E get(int index) {
		assert (index >= 0 && index < size());

		temp = cabeca;
		for (int i = 0; i < index; i++) {
			temp = temp.proximo;
		}

		return temp.elemento;
	}

	/**
	 * Method to get the index of certain element in the Linked List.
	 * 
	 * @param elem
	 *            element of the Linked List
	 * @return index of element or -1 if that element wasn't found.
	 */

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

	/**
	 * Method to know if that Linked List was empty.
	 * 
	 * @return a boolean, if is Empty, returns true.
	 */

	public boolean isEmpty() {
		return (cabeca == null && cauda == null);
	}

	/**
	 * Method to element a node in the specific index in Linked List.
	 * 
	 * @param index
	 *            index of element to be removed.
	 * @return the element removed
	 */

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