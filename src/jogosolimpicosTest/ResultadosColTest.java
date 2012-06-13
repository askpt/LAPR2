package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class ResultadosColTest {

	@Test
	public void testEquals() {
		ResultadosCol resulTest = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "17", 0);
		ResultadosCol resulTest2 = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "17", 0);

		assertTrue(resulTest.equals(resulTest2));
	}

	@Test
	public void testGetEquipa() {
		ResultadosCol resulTest = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "17", 0);

		assertEquals("POR", resulTest.getEquipa().getPais().getCodigoPais(0));
		assertEquals("Portugal", resulTest.getEquipa().getPais().getNomePais());
	}

	@Test
	public void testSetEquipa() {
		ResultadosCol resulTest = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "17", 0);

		resulTest.setEquipa(new Equipa(new Pais("USA", "United States")));

		assertEquals("USA", resulTest.getEquipa().getPais().getCodigoPais(0));
		assertEquals("United States", resulTest.getEquipa().getPais().getNomePais());
	}

	@Test
	public void testGetResultado() {
		ResultadosCol resulTest = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "17:12", 1);

		assertEquals(1032, resulTest.getResultado(), 0);
	}

	@Test
	public void testSetResultado() {
		ResultadosCol resulTest = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "17:12", 1);
		resulTest.setResultado(33);
		assertEquals(33, resulTest.getResultado(), 0);
	}

	@Test
	public void testSetResulTemp() {
		ResultadosCol resulTest = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "17:12", 1);
		resulTest.setResulTemp("12");

		assertEquals("12", resulTest.getResulTemp());
	}

	@Test
	public void testCompareTo() {
		ResultadosCol resulTest = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "16:12", 1);
		ResultadosCol resulTest2 = new ResultadosCol(new Equipa(new Pais("USA", "United States")), "17:12", 1);

		assertEquals(-600000, resulTest.compareTo(resulTest2));
	}

	@Test
	public void testGetResulTemp() {
		ResultadosCol resulTest = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "17:12", 1);

		assertEquals("17:12", resulTest.getResulTemp());
	}

}
