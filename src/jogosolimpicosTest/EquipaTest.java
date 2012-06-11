package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;
import listaligada.*;

import org.junit.*;

public class EquipaTest {

	private static Equipa equipaTest = new Equipa(new Pais("POR", "Portugal"));

	@Test
	public void testGetPais() {
		assertEquals("POR", equipaTest.getPais().getCodigoPais(0));
		assertEquals("Portugal", equipaTest.getPais().getNomePais());
	}

	@Test
	public void testSetPais() {
		equipaTest.setPais(new Pais("USA", "United States"));
		assertEquals("USA", equipaTest.getPais().getCodigoPais(0));
		assertEquals("United States", equipaTest.getPais().getNomePais());
	}

	@Test
	public void testAddAtleta() {
		equipaTest.addAtleta(new Atleta("Joao", new Pais("USA", "United States")));

		assertEquals("Joao", equipaTest.getAtleta().get(0).getNome());
		assertEquals("USA", equipaTest.getAtleta().get(0).getPais().getCodigoPais(0));
		assertEquals("United States", equipaTest.getAtleta().get(0).getPais().getNomePais());
	}

	@Test
	public void testGetAtleta() {
		assertEquals("Joao", equipaTest.getAtleta().get(0).getNome());
		assertEquals("USA", equipaTest.getAtleta().get(0).getPais().getCodigoPais(0));
		assertEquals("United States", equipaTest.getAtleta().get(0).getPais().getNomePais());
	}

	@Test
	public void testSetAtletas() {
		ListaLigada<Atleta> atl = new ListaLigada<Atleta>();
		atl.add(new Atleta("Andre", new Pais("USA", "United States")));

		equipaTest.setAtletas(atl);

		assertEquals("Joao", equipaTest.getAtleta().get(0).getNome());
		assertEquals("USA", equipaTest.getAtleta().get(0).getPais().getCodigoPais(0));
		assertEquals("United States", equipaTest.getAtleta().get(0).getPais().getNomePais());
		assertEquals("Andre", equipaTest.getAtleta().get(1).getNome());
		assertEquals("USA", equipaTest.getAtleta().get(1).getPais().getCodigoPais(0));
		assertEquals("United States", equipaTest.getAtleta().get(1).getPais().getNomePais());

	}

}
