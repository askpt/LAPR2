package jogosolimpicos;

import java.io.*;
import listaligada.*;

/**
 * Main class of the teams of athletes for the team competitions.
 * 
 */
@SuppressWarnings("serial")
public class Equipa implements Serializable {
	/**
	 * identification number of the team.
	 */
	private int numid;
	/**
	 * the counter for the the team's identification number
	 */
	private static int num;
	/**
	 * the country of the team
	 * 
	 * @see Pais country details
	 */
	private Pais pais;

	/**
	 * the group of athletes
	 * 
	 * @see Atleta athlete detail
	 */
	private ListaLigada<Atleta> atletas = new ListaLigada<Atleta>();

	/**
	 * The main constructor of the team.
	 * 
	 * @param pais
	 *            the country of the team.
	 * @see Pais country details
	 */
	public Equipa(Pais pais) {

		setID();
		setPais(pais);
	}

	/**
	 * Get the team's identification number.
	 * 
	 * @return the identification number of the team.
	 */
	public int getID() {

		return numid;
	}

	/**
	 * Set the athlete's identification number. Adds one number at the previous
	 * identification number.
	 */
	private void setID() {

		this.numid = ++num;
	}

	/**
	 * Set the team's country.
	 * 
	 * @param pais
	 *            the country of the team.
	 * @see Pais Country details.
	 */
	public void setPais(Pais pais) {

		this.pais = pais;
	}

	/**
	 * Get the team's country.
	 * 
	 * @return the country of the team.
	 */

	public Pais getPais() {

		return pais;
	}

	/**
	 * Get the group of the athletes.
	 * 
	 * @return the group of the atheletes.
	 * @see Atleta athlete details.
	 */

	public ListaLigada<Atleta> getAtleta() {

		return atletas;
	}

	/**
	 * Verify if the team contains that athlete, and if doesn't, adds a athelete
	 * to a team.
	 * 
	 * @param atleta
	 *            athlete to be added
	 * @see Atleta athlete details
	 */

	public void addAtleta(Atleta atleta) {

		if (!atletas.contains(atleta)) {
			atletas.add(atleta);
		}
	}

	/**
	 * Add a new group of athletes to this group, but in first time, verify if
	 * the old group already have the athlete to be added.
	 * 
	 * @param atletas
	 *            ListaLigada of athletes.
	 * @see Atleta athlete details.
	 */

	public void setAtletas(ListaLigada<Atleta> atletas) {

		for (int i = 0; i < atletas.size(); i++) {
			if (!this.atletas.contains(atletas.get(i))) {
				this.atletas.add(atletas.get(i));
			}
		}
	}
}
