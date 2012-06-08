package listaligadaTest;

import static org.junit.Assert.*;
import listaligada.*;

import org.junit.Test;

public class ListaLigadaTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testSize() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);
		teste.add(2);

		assertEquals(2, teste.size());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testAdd() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);

		assertEquals(1, teste.get(0));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testSet() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);
		teste.set(0, 2);

		assertEquals(2, teste.get(0));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testNo() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);

		// TODO falta testar

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testToArray() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);
		teste.add(2);
		teste.add(3);
		Object[] esperado = { 1, 2, 3 };

		assertArrayEquals(esperado, teste.toArray());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testAdd2() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);
		teste.add(3);
		teste.add(4);
		teste.add(1, 2);

		Object[] esperado = { 1, 2, 3, 4 };
		assertArrayEquals(esperado, teste.toArray());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testGet() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);

		assertEquals(1, teste.get(0));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testIndexOf() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);
		teste.add(2);
		teste.add(3);
		teste.add(4);

		assertEquals(2, teste.indexOf(3));
	}

	@SuppressWarnings({ "rawtypes" })
	@Test
	public void testIsEmpty() {
		ListaLigada teste = new ListaLigada();

		assertTrue(teste.isEmpty());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemove() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);
		teste.add(2);
		teste.add(3);
		teste.add(4);
		teste.remove(3);

		Object[] esperado = { 1, 2, 3 };
		assertArrayEquals(esperado, teste.toArray());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testContains() {
		ListaLigada teste = new ListaLigada();
		teste.add(1);
		teste.add(2);

		assertTrue(teste.contains(2));
	}

}
