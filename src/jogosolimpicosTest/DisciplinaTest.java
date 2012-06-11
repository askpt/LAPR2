package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class DisciplinaTest {

	private static Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);

	@Test
	public void testGetGenero() {
		assertEquals(0, discTest.getGenero());
	}

	@Test
	public void testGetTipoMod() {
		assertFalse(discTest.getTipoMod());
	}

	@Test
	public void testGetTipoClass() {
		assertEquals(0, discTest.getTipoClass());
	}

	@Test
	public void testGetNome() {
		assertEquals("100 m", discTest.getNome());
	}

	@Test
	public void testGetModalidade() {
		assertEquals("Atletismo", discTest.getModalidade().getNome());
	}

	@Test
	public void testGetOrdenacao() {
		assertTrue(discTest.getOrdenacao());
	}

	@Test
	public void testSetGenero() {
		discTest.setGenero(1);

		assertEquals(1, discTest.getGenero());
	}

	@Test
	public void testSetTipoDisc() {
		discTest.setTipoDisc(true);

		assertTrue(discTest.getTipoMod());
	}

	@Test
	public void testSetNome() {
		discTest.setNome("4x100m");
		assertEquals("4x100m", discTest.getNome());
	}

	@Test
	public void testSetModalidade() {
		discTest.setModalidade(new Modalidade("Ginastica"));

		assertEquals("Ginastica", discTest.getModalidade().getNome());
	}

	@Test
	public void testSetOrdenacao() {
		discTest.setOrdenacao(false);

		assertFalse(discTest.getOrdenacao());
	}

	@Test
	public void testSetTipoClass() {
		discTest.setTipoClass(1);

		assertEquals(1, discTest.getTipoClass());
	}

	@Test
	public void testEqualsObject() {
		Disciplina discTest2 = new Disciplina("4x100m", new Modalidade("Ginastica"), true, 1, false, 1);
		Disciplina discTest3 = new Disciplina("4x100m", new Modalidade("Ginastica"), true, 1, false, 1);

		assertTrue(discTest2.equals(discTest3));
	}

}
