package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class CodigosPaisTest {

	@Test
	public void testGetAnoInicio() {
		CodigosPais codTest = new CodigosPais(null, 1999, 2000);
		assertEquals(1999, codTest.getAnoInicio());
	}

	@Test
	public void testGetAnoFim() {
		CodigosPais codTest = new CodigosPais(null, 1999, 2000);
		assertEquals(2000, codTest.getAnoFim());
	}

	@Test
	public void testGetCodigo() {
		CodigosPais codTest = new CodigosPais("TST", 1999, 2000);
		assertEquals("TST", codTest.getCodigo());
	}

	@Test
	public void testSetAnoInicio() {
		CodigosPais codTest = new CodigosPais(null, 1999, 2002);
		codTest.setAnoInicio(2000);
		assertEquals(2000, codTest.getAnoInicio());
	}

	@Test
	public void testSetAnoFim() {
		CodigosPais codTest = new CodigosPais(null, 1999, 2000);
		codTest.setAnoFim(2003);
		assertEquals(2003, codTest.getAnoFim());
	}

	@Test
	public void testSetCodigo() {
		CodigosPais codTest = new CodigosPais("TEST", 1999, 2002);
		codTest.setCodigo("TST");
		assertEquals("TST", codTest.getCodigo());
	}

}
