package jogosolimpicosTest;

import static org.junit.Assert.*;
import jogosolimpicos.*;

import org.junit.*;

public class ModalidadeTest {

	@Test
	public void testGetDisc() {
		Modalidade testModal = new Modalidade("Cigala");
		Disciplina testDisc = new Disciplina("Arroz", testModal, true, 0, true, 0);
		testModal.getDisc().add(testDisc);

		assertEquals(testDisc, testModal.getDisc().get(0));
	}

	@Test
	public void testSetNome() {
		Modalidade testModal = new Modalidade(null);

		testModal.setNome("Sky");
		assertEquals("Sky", testModal.getNome());
	}

	@Test
	public void testGetNome() {
		Modalidade testModal = new Modalidade("Sky");

		assertEquals("Sky", testModal.getNome());
	}

}
