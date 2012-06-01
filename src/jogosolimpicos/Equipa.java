package jogosolimpicos;

import listaligada.ListaLigada;

public class Equipa {

	private Pais pais;
	private ListaLigada<Atleta> atletas = new ListaLigada<Atleta>();
	private Atleta atleta;

	public Equipa(Pais pais) {

		setPais(pais);
	}

	public Equipa(Pais pais, Atleta atleta) {

		this(pais);
		setAtleta(atleta);

	}

	public Equipa(Pais pais, ListaLigada<Atleta> atletas) {

		this(pais);
		setAtletas(atletas);

	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public void setAtleta(Atleta atleta) {
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
