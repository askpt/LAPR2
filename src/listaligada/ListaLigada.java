package listaligada;

import java.io.*;

/**
 * Main class for the Linked List. Accepts the generic form.
 * 
 * @author http://www.dreamincode.net/forums/topic/143089-linked-list-tutorial/
 *         (Translated and made some changes by the team).
 * 
 */

@SuppressWarnings("serial")
public class ListaLigada<E> implements Serializable {
	/**
	 * head of the linked list
	 */
	private No<E> cabeca = null;
	/**
	 * tail of the linked list
	 */
	private No<E> cauda = null;
	/**
	 * temporary node of the linked list
	 */
	private No<E> temp = null;
	/**
	 * size of the linked list
	 */
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
	 * Method to edit the element at the specified index.
	 * 
	 * @param index
	 *            index of the element to edit
	 * @param elemento
	 *            the new value of the element
	 * @return the element previously at the specified index
	 * @throws IndexOutOfBoundsException
	 */
	public E set(int index, E elemento) {

		verificarIndex(index);
		No<E> x = no(index);
		E valAnt = x.elemento;
		x.elemento = elemento;
		return valAnt;
	}

	/**
	 * Method that returns the Node at the specified index.
	 * 
	 * @param index
	 *            index of the element in order to get its node
	 * @return the node that corresponds to the index passed as parameter
	 */
	public No<E> no(int index) {

		No<E> x = cabeca;
		if (index < size()) {
			for (int i = 0; i < index; i++) {
				x = x.proximo;
			}
		}
		return x;

	}

	/**
	 * Method to verify if the index is in the linked list
	 * 
	 * @param index
	 *            index to be verified
	 * @throws IndexOutOfBoundsException
	 */

	private void verificarIndex(int index) {

		if (!indexExiste(index)) {
			throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size());
		}
	}

	/**
	 * Method to verify if the index is in the linked list
	 * 
	 * @param index
	 *            index to be verified
	 * @return true if exists
	 */

	private boolean indexExiste(int index) {

		return index >= 0 && index < size();
	}

	/**
	 * Method that returns an array containing all the elements in the
	 * ListaLigada
	 * 
	 * @return an array resulting of the conversion from ListaLigada
	 */
	public Object[] toArray() {

		Object[] array = new Object[size()];
		int i = 0;
		for (No<E> x = cabeca; x != null; x = x.proximo) {
			array[i++] = x.elemento;
		}
		return array;
	}

	/**
	 * Method to add an element to a specific index of the Linked List.
	 * 
	 * @param index
	 *            index of the Linked List, where the element will be added,
	 *            between 0 and the size of Linked List.
	 * @param elemento
	 *            element to be added to Linked List.
	 */
	public void add(int index, E elemento) {

		assert (index == 0 && index < size() + 1);

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
		for (int i = 0; i < index; i++) {
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
	 *            index of the Linked List between 0 and the last index of
	 *            Linked List.
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

		for (; temp != null && !temp.elemento.equals(elem); i++) {
			temp = temp.proximo;
		}

		if (i == this.size())
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
	 *            index of element to be removed between 0 and the last index of
	 *            Linked List.
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

	/**
	 * Method to check if the element is in the Linked List.
	 * 
	 * @param elem
	 *            element to be found
	 * @return true if exists
	 */

	public boolean contains(E elem) {

		return (this.indexOf(elem) >= 0);
	}

}