package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class ResultadosIndTest {
	// TODO equals test
	@Test
	public void testGetAtleta() {
		ResultadosInd resulTest = new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "17", 0);

		assertEquals("Quim", resulTest.getAtleta().getNome());
		assertEquals("POR", resulTest.getAtleta().getPais().getCodigoPais(0));
		assertEquals("Portugal", resulTest.getAtleta().getPais().getNomePais());
	}

	@Test
	public void testSetAtleta() {
		ResultadosInd resulTest = new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "17", 0);

		resulTest.setAtleta(new Atleta("Joe", new Pais("USA", "United States")));

		assertEquals("Joe", resulTest.getAtleta().getNome());
		assertEquals("USA", resulTest.getAtleta().getPais().getCodigoPais(0));
		assertEquals("United States", resulTest.getAtleta().getPais().getNomePais());
	}

	@Test
	public void testGetResultado() {
		ResultadosInd resulTest = new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "17:12", 1);

		assertEquals(1032, resulTest.getResultado(), 0);
	}

	@Test
	public void testSetResultado() {
		ResultadosInd resulTest = new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "17:12", 1);
		resulTest.setResultado(33);

		assertEquals(33, resulTest.getResultado(), 0);
	}

	@Test
	public void testSetResulTemp() {
		ResultadosInd resulTest = new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "17:12", 1);

		resulTest.setResulTemp("15");

		assertEquals("15", resulTest.getResulTemp());
	}

	@Test
	public void testCompareTo() {
		ResultadosInd resulTest = new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "16:12", 1);
		ResultadosInd resulTest2 = new ResultadosInd(new Atleta("Joe", new Pais("USA", "United States")), "17:12", 1);

		assertEquals(-600000, resulTest.compareTo(resulTest2));
	}

	@Test
	public void testGetResulTemp() {
		ResultadosInd resulTest = new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "17:12", 1);

		assertEquals("17:12", resulTest.getResulTemp());
	}

}
