package jogosolimpicos;

public class Medalhas {

	private int ouro, prata, bronze;

	public Medalhas() {
		this.ouro = 0;
		this.prata = 0;
		this.bronze = 0;
	}

	public int getOuro() {
		return ouro;
	}

	public int getPrata() {
		return prata;
	}

	public int getBronze() {
		return bronze;
	}

	public void addOuro() {
		this.ouro += 1;
	}

	public void addPrata() {
		this.prata += 1;
	}

	public void addBronze() {
		this.bronze += 1;
	}

	@Override
	public String toString() {
		return String.format("Ouro: %d\nPrata: %d\nBronze: %d\n", this.ouro, this.prata, this.bronze);
	}

}
