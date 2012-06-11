package listaligada;

import java.io.*;

/**
 * The Node of Linked List.
 * 
 * 
 * @param <E>
 *            type of Node.
 */

@SuppressWarnings("serial")
public class No<E> implements Serializable {
	E elemento;
	No<E> proximo, anterior;
}
