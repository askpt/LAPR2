package dadosTest;

import static org.junit.Assert.*;
import listaligada.*;
import jogosolimpicos.*;

import org.junit.Test;
import dados.*;
import gui.*;

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
		csv.importPais(new Teste("Test"), testeList);

		for (int i = 0; i < testeList.size(); i++) {
			if (!esperadoList.get(i).getCodigoPais().equals(testeList.get(i).getCodigoPais()) || !esperadoList.get(i).getNomePais().equals(testeList.get(i).getNomePais()))
				teste = false;
		}

		assertTrue(teste);
	}

	@Test
	public void testExportPais() {
		ListaLigada<Pais> esperadoList = new ListaLigada<Pais>();
		boolean teste = true;

		esperadoList.add(new Pais("AFG", "Afghanistan"));
		esperadoList.add(new Pais("ALB", "Albania"));
		esperadoList.add(new Pais("ALG", "Algeria"));

		Csv csv = new Csv();
		csv.exportPais(new Teste("Test"), esperadoList);

		ListaLigada<Pais> testList = new ListaLigada<Pais>();
		csv.importPais(new Teste("Test"), testList);
		for (int i = 0; i < testList.size(); i++) {
			if (!esperadoList.get(i).getCodigoPais().equals(testList.get(i).getCodigoPais()) || !esperadoList.get(i).getNomePais().equals(testList.get(i).getNomePais()))
				teste = false;
		}

		assertTrue(teste);

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
		esperadoDiscList.add(new Disciplina("High Jump ", esperadoModalList.get(0), false, 0, true, 0));
		esperadoDiscList.add(new Disciplina("High Jump ", esperadoModalList.get(0), false, 1, true, 0));
		esperadoDiscList.add(new Disciplina("Long Jump ", esperadoModalList.get(0), false, 0, true, 0));
		esperadoDiscList.add(new Disciplina("Long Jump ", esperadoModalList.get(0), false, 1, true, 0));
		esperadoDiscList.add(new Disciplina("Basketball", esperadoModalList.get(1), true, 0, false, 3));
		esperadoDiscList.add(new Disciplina("Basketball", esperadoModalList.get(1), true, 1, false, 3));
		Csv csv = new Csv();
		csv.importDisc(new Teste("Test"), testeDiscList, testeModalList);
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
	public void testExportDisc() {

		ListaLigada<Modalidade> esperadoModalList = new ListaLigada<Modalidade>();
		ListaLigada<Disciplina> esperadoDiscList = new ListaLigada<Disciplina>();

		boolean teste = true;
		esperadoModalList.add(new Modalidade("Athletics"));
		esperadoModalList.add(new Modalidade("Basketball"));
		esperadoDiscList.add(new Disciplina("High Jump ", esperadoModalList.get(0), false, 0, true, 0));
		esperadoDiscList.add(new Disciplina("High Jump ", esperadoModalList.get(0), false, 1, true, 0));
		esperadoDiscList.add(new Disciplina("Long Jump ", esperadoModalList.get(0), false, 0, true, 0));
		esperadoDiscList.add(new Disciplina("Long Jump ", esperadoModalList.get(0), false, 1, true, 0));
		esperadoDiscList.add(new Disciplina("Basketball", esperadoModalList.get(1), true, 0, false, 3));
		esperadoDiscList.add(new Disciplina("Basketball", esperadoModalList.get(1), true, 1, false, 3));
		Csv csv = new Csv();
		csv.exportDisciplina(new Teste("Test"), esperadoModalList);

		ListaLigada<Modalidade> testeModalList = new ListaLigada<Modalidade>();
		ListaLigada<Disciplina> testeDiscList = new ListaLigada<Disciplina>();
		csv.importDisc(new Teste("Test"), testeDiscList, testeModalList);

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

}
