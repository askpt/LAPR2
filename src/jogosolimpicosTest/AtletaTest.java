package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class AtletaTest {

	private Atleta atletaTest = new Atleta(null, null);

	@Test
	public void testGetNome() {
		atletaTest.setNome("Vitor Hugo");

		assertEquals("Vitor Hugo", atletaTest.getNome());
	}

	@Test
	public void testGetPais() {
		atletaTest.setPais(new Pais("POR", "Portugal"));

		assertEquals("POR", atletaTest.getPais().getCodigoPais(0));
		assertEquals("Portugal", atletaTest.getPais().getNomePais());
	}

	@Test
	public void testGetMedalha() {
		assertEquals(0, atletaTest.getMedalha().getOuro());
		assertEquals(0, atletaTest.getMedalha().getPrata());
		assertEquals(0, atletaTest.getMedalha().getBronze());
	}

	@Test
	public void testSetNome() {
		atletaTest.setNome("Vitor Hugo");

		assertEquals("Vitor Hugo", atletaTest.getNome());
	}

	@Test
	public void testSetPais() {
		atletaTest.setPais(new Pais("POR", "Portugal"));

		assertEquals("POR", atletaTest.getPais().getCodigoPais(0));
		assertEquals("Portugal", atletaTest.getPais().getNomePais());
	}

	@Test
	public void testSetMedalha() {
		assertEquals(0, atletaTest.getMedalha().getOuro());
		assertEquals(0, atletaTest.getMedalha().getPrata());
		assertEquals(0, atletaTest.getMedalha().getBronze());
	}

	@Test
	public void testCompareTo() {
		Atleta atletaTest2 = new Atleta("João", new Pais("POR", "Portugal"));
		atletaTest.getMedalha().addOuro();
		assertEquals(1, atletaTest.compareTo(atletaTest2));

	}

}
