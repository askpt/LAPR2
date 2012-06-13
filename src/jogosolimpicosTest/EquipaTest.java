package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;
import listaligada.*;

import org.junit.*;

public class EquipaTest {

	@Test
	public void testEquals() {
		ListaLigada<Atleta> atletasEquTest = new ListaLigada<Atleta>();
		Atleta a = new Atleta("AA", new Pais("POR", "Portugal"));
		Atleta b = new Atleta("BB", new Pais("POR", "Portugal"));
		Atleta c = new Atleta("CC", new Pais("POR", "Portugal"));
		atletasEquTest.add(a);
		atletasEquTest.add(b);
		atletasEquTest.add(c);

		Equipa eqA = new Equipa(new Pais("POR", "Portugal"));
		Equipa eqB = new Equipa(new Pais("POR", "Portugal"));
		eqA.setAtletas(atletasEquTest);
		eqB.setAtletas(atletasEquTest);
		assertTrue(eqA.equals(eqB));

	}

	@Test
	public void testGetPais() {
		Equipa equipaTest = new Equipa(new Pais("POR", "Portugal"));
		assertEquals("POR", equipaTest.getPais().getCodigoPais(0));
		assertEquals("Portugal", equipaTest.getPais().getNomePais());
	}

	@Test
	public void testSetPais() {
		Equipa equipaTest = new Equipa(new Pais("POR", "Portugal"));
		equipaTest.setPais(new Pais("USA", "United States"));
		assertEquals("USA", equipaTest.getPais().getCodigoPais(0));
		assertEquals("United States", equipaTest.getPais().getNomePais());
	}

	@Test
	public void testAddAtleta() {
		Equipa equipaTest = new Equipa(new Pais("POR", "Portugal"));
		equipaTest.addAtleta(new Atleta("Joao", new Pais("USA", "United States")));

		assertEquals("Joao", equipaTest.getAtleta().get(0).getNome());
		assertEquals("USA", equipaTest.getAtleta().get(0).getPais().getCodigoPais(0));
		assertEquals("United States", equipaTest.getAtleta().get(0).getPais().getNomePais());
	}

	@Test
	public void testGetAtleta() {
		Equipa equipaTest = new Equipa(new Pais("POR", "Portugal"));
		equipaTest.addAtleta(new Atleta("Joao", new Pais("POR", "Portugal")));
		assertEquals("Joao", equipaTest.getAtleta().get(0).getNome());
		assertEquals("POR", equipaTest.getAtleta().get(0).getPais().getCodigoPais(0));
		assertEquals("Portugal", equipaTest.getAtleta().get(0).getPais().getNomePais());
	}

	@Test
	public void testSetAtletas() {
		Equipa equipaTest = new Equipa(new Pais("USA", "United States"));
		equipaTest.addAtleta(new Atleta("Joao", new Pais("USA", "United States")));
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
