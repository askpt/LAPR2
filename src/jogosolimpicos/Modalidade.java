package jogosolimpicos;

import java.io.*;
import listaligada.*;

/**
 * Main class of the sport.
 * 
 */
@SuppressWarnings("serial")
public class Modalidade implements Serializable {
	/**
	 * Name of the sport.
	 */
	private String nome;
	/**
	 * Group of the competitions.
	 * 
	 * @see Disciplina competition details
	 */
	private ListaLigada<Disciplina> disc;

	/**
	 * Main constructor of the sport.
	 * 
	 * @param nome
	 *            name of the sport.
	 */
	public Modalidade(String nome) {

		setNome(nome);
		disc = new ListaLigada<Disciplina>();
	}

	/**
	 * Get the group competitions of the sport.
	 * 
	 * @return the group of competitions of the sport.
	 */
	public ListaLigada<Disciplina> getDisc() {

		return disc;
	}

	/**
	 * Set the name of the sport
	 * 
	 * @param nome
	 *            name of the sport
	 */
	public void setNome(String nome) {

		this.nome = nome;
	}

	/**
	 * Get the name of the sport
	 * 
	 * @return name of the sport
	 */
	public String getNome() {

		return nome;
	}

	/**
	 * 
	 * @return returns a String in this format: "modalidade". Eg.: "Athletics"
	 */
	public String toString() {

		return String.format("%s", this.nome);

	}

	// TODO remover
	public String toStringTest() {
		return String.format("%s - %s", this.nome, this.disc);
	}
}
