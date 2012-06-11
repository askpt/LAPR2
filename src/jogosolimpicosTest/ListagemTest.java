package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;
import listaligada.*;

import org.junit.*;

public class ListagemTest {

	@Test
	public void testListarMedalhasPais() {
		Pais por = new Pais("POR", "Portugal");
		Pais ing = new Pais("GBR", "Gra Bretanha");
		Pais fra = new Pais("FRA", "Franca");
		ListaLigada<Pais> paises = new ListaLigada<>();
		paises.add(por);
		paises.add(ing);
		paises.add(fra);

		ProvaInd a1 = new ProvaInd(new Disciplina("random", new Modalidade("aleat"), false, 0, false, 0), new JogosOlimpicos(2000));

		a1.getResultados().add(new ResultadosInd(new Atleta("MantorrasPT", paises.get(0)), "10.3", 0));
		a1.getResultados().add(new ResultadosInd(new Atleta("TobiasING", paises.get(1)), "11.3", 0));
		a1.getResultados().add(new ResultadosInd(new Atleta("JoaoFRA", paises.get(2)), "12.3", 0));

		ListaLigada<Prova> provas = new ListaLigada<Prova>();
		provas.add(a1);

		ListaLigada<Pais> paisesTest = Listagem.listarMedalhasPais(paises, provas, 2000, 2000, null, null);
		assertEquals("POR", paisesTest.get(0).getCodigoPais(0));
		assertEquals("GBR", paisesTest.get(1).getCodigoPais(0));
		assertEquals("FRA", paisesTest.get(2).getCodigoPais(0));
	}

	@Test
	public void testListarMedalhasAtleta() {
		Pais por = new Pais("POR", "Portugal");
		Pais ing = new Pais("GBR", "Gra Bretanha");
		Pais fra = new Pais("FRA", "Franca");
		ListaLigada<Pais> paises = new ListaLigada<>();
		paises.add(por);
		paises.add(ing);
		paises.add(fra);

		ProvaInd a1 = new ProvaInd(new Disciplina("random", new Modalidade("aleat"), false, 0, false, 0), new JogosOlimpicos(2000));

		Atleta man = new Atleta("Mantorras", paises.get(0));
		Atleta tob = new Atleta("Tobias", paises.get(1));
		Atleta jo = new Atleta("Joao", paises.get(2));
		ListaLigada<Atleta> atletas = new ListaLigada<Atleta>();
		atletas.add(man);
		atletas.add(tob);
		atletas.add(jo);

		a1.getResultados().add(new ResultadosInd(man, "10.3", 0));
		a1.getResultados().add(new ResultadosInd(tob, "11.3", 0));
		a1.getResultados().add(new ResultadosInd(jo, "12.3", 0));

		ListaLigada<Prova> provas = new ListaLigada<Prova>();
		provas.add(a1);

		ListaLigada<Atleta> atletasTest = Listagem.listarMedalhasAtleta(atletas, new ListaLigada<Equipa>(), provas, 2000, 2000, null, null);
		assertEquals("Mantorras", atletasTest.get(0).getNome());
		assertEquals("Tobias", atletasTest.get(1).getNome());
		assertEquals("Joao", atletasTest.get(2).getNome());
	}

	@Test
	public void testEstatisticaPais() {
		Pais por = new Pais("POR", "Portugal");
		Pais ing = new Pais("GBR", "Gra Bretanha");
		Pais fra = new Pais("FRA", "Franca");
		ListaLigada<Pais> paises = new ListaLigada<>();
		paises.add(por);
		paises.add(ing);
		paises.add(fra);

		ProvaInd a1 = new ProvaInd(new Disciplina("random", new Modalidade("aleat"), false, 0, false, 0), new JogosOlimpicos(2000));

		a1.getResultados().add(new ResultadosInd(new Atleta("MantorrasPT", paises.get(0)), "10.3", 0));
		a1.getResultados().add(new ResultadosInd(new Atleta("TobiasING", paises.get(1)), "11.3", 0));
		a1.getResultados().add(new ResultadosInd(new Atleta("JoaoFRA", paises.get(2)), "12.3", 0));

		ListaLigada<Prova> provas = new ListaLigada<Prova>();
		provas.add(a1);

		Object[] valoresTest = Listagem.estatisticaPais(paises.get(0), provas, paises);
		assertEquals(1, valoresTest[0]);
		assertEquals(1, valoresTest[1]);
		assertEquals(1, valoresTest[2]);
		assertEquals(0, valoresTest[3]);
		assertEquals(0, valoresTest[4]);
		assertEquals(1, valoresTest[5]);
		assertEquals(1, valoresTest[6]);
	}

}
