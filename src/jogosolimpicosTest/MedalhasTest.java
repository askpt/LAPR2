package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class MedalhasTest {

	@Test
	public void testGetOuro() {
		Medalhas medalhasTest = new Medalhas();
		assertEquals(0, medalhasTest.getOuro());
	}

	@Test
	public void testGetPrata() {
		Medalhas medalhasTest = new Medalhas();
		assertEquals(0, medalhasTest.getPrata());
	}

	@Test
	public void testGetBronze() {
		Medalhas medalhasTest = new Medalhas();
		assertEquals(0, medalhasTest.getBronze());
	}

	@Test
	public void testAddOuro() {
		Medalhas medalhasTest = new Medalhas();
		medalhasTest.addOuro();
		assertEquals(1, medalhasTest.getOuro());
	}

	@Test
	public void testAddPrata() {
		Medalhas medalhasTest = new Medalhas();
		medalhasTest.addPrata();
		assertEquals(1, medalhasTest.getPrata());
	}

	@Test
	public void testAddBronze() {
		Medalhas medalhasTest = new Medalhas();
		medalhasTest.addBronze();
		assertEquals(1, medalhasTest.getBronze());
	}

	@Test
	public void testResetMedalhas() {
		Medalhas medalhasTest = new Medalhas();
		medalhasTest.resetMedalhas();
		assertEquals(0, medalhasTest.getOuro());
		assertEquals(0, medalhasTest.getPrata());
		assertEquals(0, medalhasTest.getBronze());
	}

}
