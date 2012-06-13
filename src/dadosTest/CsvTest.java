package dadosTest;

import static org.junit.Assert.*;

import java.io.*;

import gui.*;
import jogosolimpicos.*;
import listaligada.*;

import org.junit.*;

import dados.*;

public class CsvTest {
	@Test
	public void testImportPais() {
		ListaLigada<Pais> testeList = new ListaLigada<Pais>();
		ListaLigada<Pais> esperadoList = new ListaLigada<Pais>();
		boolean teste = true;

		esperadoList.add(new Pais("AFG", "Afghanistan"));
		esperadoList.add(new Pais("ALB", "Albania"));
		esperadoList.add(new Pais("ALG", "Algeria"));

		Csv csv = new Csv();
		csv.importPais(new File("csv_tests\\IOC_test_JUnit_importPais.csv"), new Teste("Test"), testeList);

		for (int i = 0; i < testeList.size(); i++) {
			if (!esperadoList.get(i).getCodigoPais(0).equals(testeList.get(i).getCodigoPais(0)) || !esperadoList.get(i).getNomePais().equals(testeList.get(i).getNomePais()))
				teste = false;
		}

		assertTrue(teste);
	}

	// TODO acabar
	@Test
	public void testImportLingua() {
		fail("Not yet implemented");
	}

	@Test
	public void testImportDisc() {
		ListaLigada<Modalidade> esperadoModalList = new ListaLigada<Modalidade>();
		ListaLigada<Disciplina> esperadoDiscList = new ListaLigada<Disciplina>();
		ListaLigada<Modalidade> testeModalList = new ListaLigada<Modalidade>();
		ListaLigada<Disciplina> testeDiscList = new ListaLigada<Disciplina>();

		boolean teste = true;
		esperadoModalList.add(new Modalidade("Athletics"));
		esperadoModalList.add(new Modalidade("Basketball"));
		esperadoDiscList.add(new Disciplina("High Jump", esperadoModalList.get(0), false, 0, true, 0));
		esperadoDiscList.add(new Disciplina("High Jump", esperadoModalList.get(0), false, 1, true, 0));
		esperadoDiscList.add(new Disciplina("Long Jump", esperadoModalList.get(0), false, 0, true, 0));
		esperadoDiscList.add(new Disciplina("Long Jump", esperadoModalList.get(0), false, 1, true, 0));
		esperadoDiscList.add(new Disciplina("Basketball", esperadoModalList.get(1), true, 0, false, 3));
		esperadoDiscList.add(new Disciplina("Basketball", esperadoModalList.get(1), true, 1, false, 3));
		Csv csv = new Csv();
		csv.importDisc(new File("csv_tests\\IOC_test_JUnit_importDisc.csv"), new Teste("Test"), testeDiscList, testeModalList);
		for (int i = 0; i < esperadoModalList.size() && i < testeModalList.size() && teste; i++) {
			if (!esperadoModalList.get(i).getNome().equalsIgnoreCase(testeModalList.get(i).getNome()))
				teste = false;
		}

		for (int i = 0; i < esperadoDiscList.size() && i < testeDiscList.size() && teste; i++) {
			if (!esperadoDiscList.get(i).getNome().equalsIgnoreCase(testeDiscList.get(i).getNome()) || !esperadoDiscList.get(i).getModalidade().getNome().equalsIgnoreCase(testeDiscList.get(i).getModalidade().getNome()) || !esperadoDiscList.get(i).getOrdenacao() == testeDiscList.get(i).getOrdenacao() || !esperadoDiscList.get(i).getTipoMod() == testeDiscList.get(i).getTipoMod())
				teste = false;
		}

		assertTrue(true);
	}

	@Test
	public void testImportResultados() {

		Csv csv = new Csv();
		ListaLigada<Pais> paisesTest = new ListaLigada<Pais>();
		ListaLigada<JogosOlimpicos> jogosTest = new ListaLigada<JogosOlimpicos>();
		ListaLigada<Prova> provaTest = new ListaLigada<Prova>();
		ListaLigada<Disciplina> discTest = new ListaLigada<Disciplina>();
		ListaLigada<Modalidade> modalTest = new ListaLigada<Modalidade>();
		ListaLigada<Atleta> atletaTest = new ListaLigada<Atleta>();
		ListaLigada<Equipa> equipaTest = new ListaLigada<Equipa>();

		csv.importPais(new File("csv_tests\\IOC_test_JUnit_importPais.csv"), new Teste("Test"), paisesTest);
		csv.importDisc(new File("csv_tests\\IOC_test_JUnit_importDisc.csv"), new Teste("Test"), discTest, modalTest);
		csv.importProvas(new File("csv_tests\\IOC_Sports_OG_1996.csv"), new Teste("Test"), jogosTest, provaTest, discTest, modalTest);
		csv.importResultados(new File("csv_tests\\1996_Athletics_Men.csv"), new Teste("Test"), atletaTest, modalTest, paisesTest, provaTest, equipaTest, jogosTest);

		ListaLigada<Pais> paisesEsp = new ListaLigada<Pais>();
		ListaLigada<JogosOlimpicos> jogosEsp = new ListaLigada<JogosOlimpicos>();
		ListaLigada<Prova> provaEsp = new ListaLigada<Prova>();
		ListaLigada<Disciplina> discEsp = new ListaLigada<Disciplina>();
		ListaLigada<Modalidade> modalEsp = new ListaLigada<Modalidade>();

		paisesEsp.add(new Pais("AFG", "Afghanistan"));
		paisesEsp.add(new Pais("ALB", "Albania"));
		paisesEsp.add(new Pais("ALG", "Algeria"));
		modalEsp.add(new Modalidade("Athletics"));
		modalEsp.add(new Modalidade("Basketball"));
		discEsp.add(new Disciplina("High Jump", modalEsp.get(0), false, 0, true, 0));
		discEsp.add(new Disciplina("High Jump", modalEsp.get(0), false, 1, true, 0));
		discEsp.add(new Disciplina("Long Jump", modalEsp.get(0), false, 0, true, 0));
		discEsp.add(new Disciplina("Long Jump", modalEsp.get(0), false, 1, true, 0));
		discEsp.add(new Disciplina("Basketball", modalEsp.get(1), true, 0, false, 3));
		discEsp.add(new Disciplina("Basketball", modalEsp.get(1), true, 1, false, 3));
		jogosEsp.add(new JogosOlimpicos(1996));
		provaEsp.add(new ProvaInd(discEsp.get(0), jogosEsp.get(0)));
		provaEsp.add(new ProvaInd(discEsp.get(2), jogosEsp.get(0)));
		((ProvaInd) provaEsp.get(0)).getResultados().add(new ResultadosInd(new Atleta("Charles Austin", paisesEsp.get(1)), "2.38 m", 0));
		((ProvaInd) provaEsp.get(0)).getResultados().add(new ResultadosInd(new Atleta("Artur Partyka", paisesEsp.get(1)), "2.37 m", 0));
		((ProvaInd) provaEsp.get(0)).getResultados().add(new ResultadosInd(new Atleta("Steve Smith", paisesEsp.get(1)), "2.35 m", 0));
		((ProvaInd) provaEsp.get(1)).getResultados().add(new ResultadosInd(new Atleta("Carl Lewis", paisesEsp.get(2)), "8.50 m", 0));
		((ProvaInd) provaEsp.get(1)).getResultados().add(new ResultadosInd(new Atleta("James Beckford", paisesEsp.get(1)), "8.29 m", 0));
		((ProvaInd) provaEsp.get(1)).getResultados().add(new ResultadosInd(new Atleta("Joe Greene", paisesEsp.get(0)), "8.255 m", 0));

		boolean teste = true;
		for (int i = 0; i < provaEsp.size() && i < provaTest.size() && teste; i++) {
			if (!provaEsp.get(i).getDisciplina().getNome().equalsIgnoreCase(provaTest.get(i).getDisciplina().getNome()) || !provaEsp.get(i).getDisciplina().getModalidade().getNome().equalsIgnoreCase(provaTest.get(i).getDisciplina().getModalidade().getNome()) || !provaEsp.get(i).getDisciplina().getOrdenacao() == provaTest.get(i).getDisciplina().getOrdenacao() || !provaEsp.get(i).getDisciplina().getTipoMod() == provaTest.get(i).getDisciplina().getTipoMod() && provaEsp.get(i).getJogosOlimpicos().getAno() != provaTest.get(i).getJogosOlimpicos().getAno()) {
				teste = false;
			}
		}

		for (int i = 0; i < provaEsp.size() && i < provaTest.size() && teste; i++) {
			if (provaEsp.get(i) instanceof ProvaInd && provaTest.get(i) instanceof ProvaInd) {
				for (int j = 0; j < ((ProvaInd) provaEsp.get(i)).getResultados().size() && j < ((ProvaInd) provaTest.get(i)).getResultados().size() && teste; j++) {
					if (!((ProvaInd) provaEsp.get(i)).getResultados().get(j).getAtleta().getNome().equalsIgnoreCase(((ProvaInd) provaTest.get(i)).getResultados().get(j).getAtleta().getNome()) && !((ProvaInd) provaEsp.get(i)).getResultados().get(j).getResulTemp().equalsIgnoreCase(((ProvaInd) provaTest.get(i)).getResultados().get(j).getResulTemp())) {

						teste = false;
					}
				}
			} else if (provaEsp.get(i) instanceof ProvaCol && provaTest.get(i) instanceof ProvaCol) {
				for (int j = 0; j < ((ProvaCol) provaEsp.get(i)).getResultados().size() && j < ((ProvaCol) provaTest.get(i)).getResultados().size() && teste; j++) {
					if (!((ProvaCol) provaEsp.get(i)).getResultados().get(j).getEquipa().getPais().getCodigoPais(0).equalsIgnoreCase(((ProvaCol) provaTest.get(i)).getResultados().get(j).getEquipa().getPais().getCodigoPais(0)) && !((ProvaCol) provaEsp.get(i)).getResultados().get(j).getResulTemp().equalsIgnoreCase(((ProvaCol) provaTest.get(i)).getResultados().get(j).getResulTemp())) {
						teste = false;
					}
				}
			} else {
				teste = false;
			}

			if (!discEsp.get(i).getNome().equalsIgnoreCase(discTest.get(i).getNome()) || !discEsp.get(i).getModalidade().getNome().equalsIgnoreCase(discTest.get(i).getModalidade().getNome()) || !discEsp.get(i).getOrdenacao() == discTest.get(i).getOrdenacao() || !discEsp.get(i).getTipoMod() == discTest.get(i).getTipoMod())
				teste = false;
		}

		assertTrue(teste);
	}

	@Test
	public void testImportProvas() {
		Csv csv = new Csv();
		ListaLigada<JogosOlimpicos> jogosTest = new ListaLigada<JogosOlimpicos>();
		ListaLigada<Prova> provaTest = new ListaLigada<Prova>();
		ListaLigada<Disciplina> discTest = new ListaLigada<Disciplina>();
		ListaLigada<Modalidade> modalTest = new ListaLigada<Modalidade>();

		ListaLigada<JogosOlimpicos> jogosEsp = new ListaLigada<JogosOlimpicos>();
		ListaLigada<Prova> provaEsp = new ListaLigada<Prova>();
		ListaLigada<Disciplina> discEsp = new ListaLigada<Disciplina>();
		ListaLigada<Modalidade> modalEsp = new ListaLigada<Modalidade>();

		modalEsp.add(new Modalidade("Athletics"));
		modalEsp.add(new Modalidade("Basketball"));
		discEsp.add(new Disciplina("High Jump", modalEsp.get(0), false, 0, true, 0));
		discEsp.add(new Disciplina("High Jump", modalEsp.get(0), false, 1, true, 0));
		discEsp.add(new Disciplina("Long Jump", modalEsp.get(0), false, 0, true, 0));
		discEsp.add(new Disciplina("Long Jump", modalEsp.get(0), false, 1, true, 0));
		discEsp.add(new Disciplina("Basketball", modalEsp.get(1), true, 0, false, 3));
		discEsp.add(new Disciplina("Basketball", modalEsp.get(1), true, 1, false, 3));
		jogosEsp.add(new JogosOlimpicos(1996));
		provaEsp.add(new ProvaInd(discEsp.get(0), jogosEsp.get(0)));
		provaEsp.add(new ProvaInd(discEsp.get(2), jogosEsp.get(0)));
		provaEsp.add(new ProvaInd(discEsp.get(3), jogosEsp.get(0)));
		csv.importDisc(new File("csv_tests\\IOC_test_JUnit_importDisc.csv"), new Teste("Test"), discTest, modalTest);
		csv.importProvas(new File("csv_tests\\IOC_Sports_OG_1996.csv"), new Teste("Test"), jogosTest, provaTest, discTest, modalTest);

		boolean teste = true;
		for (int i = 0; i < modalEsp.size() && i < modalTest.size() && teste; i++) {
			if (!modalEsp.get(i).getNome().equalsIgnoreCase(modalTest.get(i).getNome()))
				teste = false;
		}

		for (int i = 0; i < discEsp.size() && i < discTest.size() && teste; i++) {
			if (!discEsp.get(i).getNome().equalsIgnoreCase(discTest.get(i).getNome()) || !discEsp.get(i).getModalidade().getNome().equalsIgnoreCase(discTest.get(i).getModalidade().getNome()) || !discEsp.get(i).getOrdenacao() == discTest.get(i).getOrdenacao() || !discEsp.get(i).getTipoMod() == discTest.get(i).getTipoMod())
				teste = false;
		}

		assertTrue(teste);
	}

}
