package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;
import listaligada.*;

import org.junit.*;

public class ProvaColTest {

	@Test
	public void testGetResultados() {
		ProvaCol provaTest = new ProvaCol(null, null);

		provaTest.getResultados().add(new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "15", 0));
		assertEquals("POR", provaTest.getResultados().get(0).getEquipa().getPais().getCodigoPais(0));
		assertEquals("15", provaTest.getResultados().get(0).getResulTemp());
	}

	@Test
	public void testSetResultados() {
		ProvaCol provaTest = new ProvaCol(null, null);

		ResultadosCol resul1 = new ResultadosCol(new Equipa(new Pais("USA", "United States")), "20", 0);
		ResultadosCol resul2 = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "15", 0);
		ListaLigada<ResultadosCol> resultados = new ListaLigada<ResultadosCol>();
		resultados.add(resul1);
		resultados.add(resul2);
		provaTest.setResultados(resultados);

		assertEquals("USA", provaTest.getResultados().get(0).getEquipa().getPais().getCodigoPais(0));
		assertEquals("20", provaTest.getResultados().get(0).getResulTemp());
		assertEquals("POR", provaTest.getResultados().get(1).getEquipa().getPais().getCodigoPais(0));
		assertEquals("15", provaTest.getResultados().get(1).getResulTemp());
	}

	@Test
	public void testOrdenar() {

		ProvaCol provaTest = new ProvaCol(new Disciplina("teste", new Modalidade("test"), true, 0, false, 0), null);
		ResultadosCol resul1 = new ResultadosCol(new Equipa(new Pais("USA", "United States")), "20", 0);
		ResultadosCol resul2 = new ResultadosCol(new Equipa(new Pais("POR", "Portugal")), "15", 0);
		ListaLigada<ResultadosCol> resultados = new ListaLigada<ResultadosCol>();
		resultados.add(resul1);
		resultados.add(resul2);
		provaTest.setResultados(resultados);
		provaTest.ordenar();

		assertEquals("USA", provaTest.getResultados().get(1).getEquipa().getPais().getCodigoPais(0));
		assertEquals("20", provaTest.getResultados().get(1).getResulTemp());
		assertEquals("POR", provaTest.getResultados().get(0).getEquipa().getPais().getCodigoPais(0));
		assertEquals("15", provaTest.getResultados().get(0).getResulTemp());
	}

}
