package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class DisciplinaTest {

	@Test
	public void testGetGenero() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		assertEquals(0, discTest.getGenero());
	}

	@Test
	public void testGetTipoMod() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		assertFalse(discTest.getTipoMod());
	}

	@Test
	public void testGetTipoClass() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		assertEquals(0, discTest.getTipoClass());
	}

	@Test
	public void testGetNome() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		assertEquals("100 m", discTest.getNome());
	}

	@Test
	public void testGetModalidade() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		assertEquals("Atletismo", discTest.getModalidade().getNome());
	}

	@Test
	public void testGetOrdenacao() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		assertTrue(discTest.getOrdenacao());
	}

	@Test
	public void testSetGenero() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		discTest.setGenero(1);

		assertEquals(1, discTest.getGenero());
	}

	@Test
	public void testSetTipoDisc() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		discTest.setTipoDisc(true);

		assertTrue(discTest.getTipoMod());
	}

	@Test
	public void testSetNome() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		discTest.setNome("4x100m");
		assertEquals("4x100m", discTest.getNome());
	}

	@Test
	public void testSetModalidade() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		discTest.setModalidade(new Modalidade("Ginastica"));

		assertEquals("Ginastica", discTest.getModalidade().getNome());
	}

	@Test
	public void testSetOrdenacao() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
		discTest.setOrdenacao(false);

		assertFalse(discTest.getOrdenacao());
	}

	@Test
	public void testSetTipoClass() {
		Disciplina discTest = new Disciplina("100 m", new Modalidade("Atletismo"), false, 0, true, 0);
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
