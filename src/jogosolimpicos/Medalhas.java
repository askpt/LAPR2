package jogosolimpicos;

import java.io.*;

/**
 * Class of the management of the medals.
 */

@SuppressWarnings("serial")
public class Medalhas implements Serializable {

	private int ouro, prata, bronze;

	/**
	 * Main constructor of class medals. Initializes the gold, silver and bronze
	 * medals to zero.
	 */
	public Medalhas() {
		this.ouro = 0;
		this.prata = 0;
		this.bronze = 0;
	}

	/**
	 * Get the gold medals.
	 * 
	 * @return gold medals
	 */

	public int getOuro() {
		return ouro;
	}

	/**
	 * Get the silver medals.
	 * 
	 * @return silver medals
	 */

	public int getPrata() {
		return prata;
	}

	/**
	 * Get the bronze medals.
	 * 
	 * @return bronze medals
	 */

	public int getBronze() {
		return bronze;
	}

	/**
	 * Add one medal to the gold medals.
	 */

	public void addOuro() {
		this.ouro += 1;
	}

	/**
	 * Add one medal to the silver medals.
	 */

	public void addPrata() {
		this.prata += 1;
	}

	/**
	 * Add one medal to the bronze medals.
	 */

	public void addBronze() {
		this.bronze += 1;
	}

	/**
	 * @return returns a String in this format: "Gold: gold medals
	 *         <p>
	 *         Silver: silver medals
	 *         <p>
	 *         Bronze: bronze medals"
	 */
	@Override
	public String toString() {
		return String.format("Gold: %d Silver: %d Bronze: %d", this.ouro, this.prata, this.bronze);
	}

}
