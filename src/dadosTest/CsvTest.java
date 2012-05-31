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

}
