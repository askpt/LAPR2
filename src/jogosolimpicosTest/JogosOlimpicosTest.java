package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class JogosOlimpicosTest {

	private static JogosOlimpicos jogosOlTest = new JogosOlimpicos(2012, "London");

	@Test
	public void testGetCidade() {

		assertEquals("London", jogosOlTest.getCidade());
	}

	@Test
	public void testGetAno() {
		assertEquals(2012, jogosOlTest.getAno());
	}

	@Test
	public void testSetCidade() {
		jogosOlTest.setCidade("Beijing");

		assertEquals("Beijing", jogosOlTest.getCidade());
	}

	@Test
	public void testSetAno() {
		jogosOlTest.setAno(2008);

		assertEquals(2008, jogosOlTest.getAno());
	}

}
