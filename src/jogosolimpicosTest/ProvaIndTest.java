package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;
import listaligada.*;

import org.junit.*;

public class ProvaIndTest {

	@Test
	public void testGetResultados() {
		ProvaInd provaTest = new ProvaInd(null, null);

		provaTest.getResultados().add(new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "15", 0));
		assertEquals("Quim", provaTest.getResultados().get(0).getAtleta().getNome());
		assertEquals("POR", provaTest.getResultados().get(0).getAtleta().getPais().getCodigoPais(0));
		assertEquals("15", provaTest.getResultados().get(0).getResulTemp());
	}

	@Test
	public void testSetResultadosInd() {
		ProvaInd provaTest = new ProvaInd(null, null);

		ResultadosInd resul1 = new ResultadosInd(new Atleta("Joe", new Pais("USA", "United States")), "20", 0);
		ResultadosInd resul2 = new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "15", 0);
		ListaLigada<ResultadosInd> resultados = new ListaLigada<ResultadosInd>();
		resultados.add(resul1);
		resultados.add(resul2);
		provaTest.setResultadosInd(resultados);

		assertEquals("Joe", provaTest.getResultados().get(0).getAtleta().getNome());
		assertEquals("USA", provaTest.getResultados().get(0).getAtleta().getPais().getCodigoPais(0));
		assertEquals("20", provaTest.getResultados().get(0).getResulTemp());
		assertEquals("Quim", provaTest.getResultados().get(1).getAtleta().getNome());
		assertEquals("POR", provaTest.getResultados().get(1).getAtleta().getPais().getCodigoPais(0));
		assertEquals("15", provaTest.getResultados().get(1).getResulTemp());
	}

	@Test
	public void testOrdenar() {
		ProvaInd provaTest = new ProvaInd(new Disciplina("teste", new Modalidade("test"), false, 0, false, 0), null);
		ResultadosInd resul1 = new ResultadosInd(new Atleta("Joe", new Pais("USA", "United States")), "20", 0);
		ResultadosInd resul2 = new ResultadosInd(new Atleta("Quim", new Pais("POR", "Portugal")), "15", 0);
		ListaLigada<ResultadosInd> resultados = new ListaLigada<ResultadosInd>();
		resultados.add(resul1);
		resultados.add(resul2);
		provaTest.setResultadosInd(resultados);
		provaTest.ordenar();

		assertEquals("Quim", provaTest.getResultados().get(0).getAtleta().getNome());
		assertEquals("POR", provaTest.getResultados().get(0).getAtleta().getPais().getCodigoPais(0));
		assertEquals("15", provaTest.getResultados().get(0).getResulTemp());
		assertEquals("Joe", provaTest.getResultados().get(1).getAtleta().getNome());
		assertEquals("USA", provaTest.getResultados().get(1).getAtleta().getPais().getCodigoPais(0));
		assertEquals("20", provaTest.getResultados().get(1).getResulTemp());
	}
}
