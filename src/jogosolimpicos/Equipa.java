package jogosolimpicos;

import listaligada.*;

public class Equipa {

	private int numid;
	private static int num;
	private Pais pais;
	private ListaLigada<Atleta> atletas = new ListaLigada<Atleta>();

	public Equipa(Pais pais) {

		setID();
		setPais(pais);
	}

	// GETTERS
	public int getID() {

		return numid;
	}

	// SETTERS
	private void setID() {

		this.numid = ++num;
	}

	public void setPais(Pais pais) {

		this.pais = pais;
	}

	public Pais getPais() {

		return pais;
	}

	public ListaLigada<Atleta> getAtleta() {

		return atletas;
	}

	public void addAtleta(Atleta atleta) {

		if (!atletas.contains(atleta)) {
			atletas.add(atleta);
		}
	}

	public void setAtletas(ListaLigada<Atleta> atletas) {

		for (int i = 0; i < atletas.size(); i++) {
			if (!this.atletas.contains(atletas.get(i))) {
				this.atletas.add(atletas.get(i));
			}
		}
	}
}
