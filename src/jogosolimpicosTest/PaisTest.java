package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class PaisTest {

	@Test
	public void testGetCodigoPais() {
		Pais paisTest = new Pais("POR", "Portugal");

		assertEquals("POR", paisTest.getCodigoPais(0));
	}

	@Test
	public void testSetCodigoPais() {
		Pais paisTest = new Pais(null, null);
		paisTest.setCodigoPais("POR");

		assertEquals("POR", paisTest.getCodigoPais(0));
	}

	@Test
	public void testGetNomePais() {
		Pais paisTest = new Pais("POR", "Portugal");

		assertEquals("Portugal", paisTest.getNomePais());
	}

	@Test
	public void testSetNomePais() {
		Pais paisTest = new Pais(null, null);

		paisTest.setNomePais("Portugal");
		assertEquals("Portugal", paisTest.getNomePais());
	}

	@Test
	public void testSetMedalha() {
		Pais paisTest = new Pais(null, null);
		paisTest.setMedalha();

		assertEquals(0, paisTest.getMedalha().getOuro());
		assertEquals(0, paisTest.getMedalha().getPrata());
		assertEquals(0, paisTest.getMedalha().getBronze());
	}

	@Test
	public void testGetMedalha() {
		Pais paisTest = new Pais(null, null);

		paisTest.getMedalha().addOuro();
		paisTest.getMedalha().addBronze();

		assertEquals(1, paisTest.getMedalha().getOuro());
		assertEquals(0, paisTest.getMedalha().getPrata());
		assertEquals(1, paisTest.getMedalha().getBronze());
	}

	@Test
	public void testGetCodigos() {
		Pais paisTest = new Pais(null, null);

		paisTest.getCodigos().add(new CodigosPais("POR", 2010));
		assertEquals("POR", paisTest.getCodigoPais(2010));
	}

	@Test
	public void testCompareTo() {
		Pais paisTest = new Pais(null, null);
		Pais paisTest1 = new Pais(null, null);

		paisTest.getMedalha().addOuro();
		assertEquals(1, paisTest.compareTo(paisTest1));
	}

}