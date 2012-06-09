package jogosolimpicos;

import java.io.*;

@SuppressWarnings({ "rawtypes", "serial" })
public class Atleta implements Comparable, Serializable {

	private String nome;
	private int numid;
	private static int num;
	private Pais pais;
	private Medalhas medalha;

	public Atleta(String nome, Pais pais) {
		//
		setID();
		setNome(nome);
		setPais(pais);
		medalha = new Medalhas();
	}

	// GETTERS

	public String getNome() {

		return nome;
	}

	public Pais getPais() {

		return pais;
	}

	public String toString() {

		return String.format("%d: %s - %s", numid, nome, pais);
	}

	// SETTERS

	public int getID() {

		return numid;
	}

	private void setID() {

		this.numid = ++num;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public void setPais(Pais pais) {

		this.pais = pais;
	}

	public void setMedalha(Medalhas medalha) {

		this.medalha = medalha;
	}

	public Medalhas getMedalha() {

		return medalha;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Atleta) {
			Atleta that = (Atleta) o;
			if (this.getMedalha().getOuro() != that.getMedalha().getOuro()) {
				return (this.getMedalha().getOuro() - that.getMedalha().getOuro());
			} else if (this.getMedalha().getPrata() != that.getMedalha().getPrata()) {
				return (this.getMedalha().getPrata() - that.getMedalha().getPrata());
			} else if (this.getMedalha().getBronze() != that.getMedalha().getBronze()) {
				return (this.getMedalha().getBronze() - that.getMedalha().getBronze());
			} else {
				return (that.getNome().compareTo(this.getNome()));
			}
		}
		return 0;
	}

}
